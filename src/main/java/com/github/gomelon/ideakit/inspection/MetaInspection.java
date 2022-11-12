package com.github.gomelon.ideakit.inspection;

import com.github.gomelon.ideakit.antlr.MetaLexer;
import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.github.gomelon.ideakit.utils.CommentUtils;
import com.goide.inspections.core.GoInspectionBase;
import com.goide.inspections.core.GoInspectionMessage;
import com.goide.inspections.core.GoProblemsHolder;
import com.goide.psi.GoPackageClause;
import com.goide.psi.GoVisitor;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class MetaInspection extends GoInspectionBase {

    @Override
    protected @NotNull GoVisitor buildGoVisitor(@NotNull GoProblemsHolder problemsHolder,
                                                @NotNull LocalInspectionToolSession localInspectionToolSession) {
        return new GoVisitor() {

            @Override
            public void visitPackageClause(@NotNull GoPackageClause o) {
                super.visitPackageClause(o);
            }

            @Override
            public void visitComment(@NotNull PsiComment psiComment) {
                String comment = CommentUtils.extractComment(psiComment);
                if (!StringUtils.startsWith(comment, "+")) {
                    return;
                }

                DeclarationCache declarationCache = DeclarationCacheManager.getInstance(psiComment.getProject());
                String text = psiComment.getText();
                CharStream inputStream = CharStreams.fromString(text);
                MetaLexer metaLexer = new MetaLexer(inputStream);
                TokenStream tokenStream = new CommonTokenStream(metaLexer);
                MetaParser metaParser = new MetaParser(tokenStream);
                metaParser.setErrorHandler(new MetaParserInspectionErrorStrategy(text));
                MetaParserInspectionListener listener = new MetaParserInspectionListener(declarationCache);
                metaParser.addParseListener(listener);
                List<MetaInspectionException> errors = new LinkedList<>();
                try {
                    metaParser.root();
                    errors.addAll(listener.getErrors());
                } catch (NotMetaCancellationException e) {
                    // Ignore
                } catch (MetaInspectionException e) {
                    errors.add(e);
                }
                for (MetaInspectionException e : errors) {
                    GoInspectionMessage message;
                    String problemCode = e.getErrorCode().getProblemCode();
                    if (problemCode.length() == 0) {
                        message = new GoMelonInspectionMessage(e.getMessage());
                    } else {
                        message = GoMelonInspectionMessage.message(problemCode);
                    }
                    problemsHolder.registerProblem(psiComment, message, ProblemHighlightType.GENERIC_ERROR,
                            TextRange.create(e.getStartIndex(), e.getStopIndex()));
                }
            }
        };
    }
}

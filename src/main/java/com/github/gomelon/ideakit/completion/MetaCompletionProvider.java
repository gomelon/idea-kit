package com.github.gomelon.ideakit.completion;

import com.github.gomelon.ideakit.antlr.MetaLexer;
import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.meta.CommentUtils;
import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.goide.GoIcons;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class MetaCompletionProvider extends CompletionProvider<CompletionParameters> {

    public MetaCompletionProvider() {
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet resultSet) {
        PsiElement position = parameters.getOriginalPosition();
        if (!(position instanceof PsiComment)) {
            return;
        }
        PsiComment psiComment = (PsiComment) position;
        String text = psiComment.getText();
        if (!CommentUtils.maybeMeta(psiComment)) {
            return;
        }

        DeclarationCache declarationCache = DeclarationCacheManager.getInstance(position.getProject());
        CharStream inputStream = CharStreams.fromString(text);
        MetaLexer metaLexer = new MetaLexer(inputStream);
        TokenStream tokenStream = new CommonTokenStream(metaLexer);
        MetaParser metaParser = new MetaParser(tokenStream);
        MetaParserCompletionListener listener = new MetaParserCompletionListener(declarationCache);
        metaParser.addParseListener(listener);
        metaParser.root();

        int lastRuleIndex = listener.getLastRuleIndex();
        final String lastSubText = listener.getLastSubText();
        List<LookupElementBuilder> builders = null;
        switch (lastRuleIndex) {
            //TODO gramer改了，这个进不去了
            case MetaParser.RULE_metaQualifyName:
                // 临时解决以点结束时,解析出来的qualifyName为没有.
                String innerLastSubText = text.endsWith(".") ? lastSubText + "." : lastSubText;
                builders = declarationCache.getAll()
                        .stream()
                        .filter(e -> StringUtils.startsWith(e.getName(), innerLastSubText))
                        .map(e -> LookupElementBuilder.createWithSmartPointer(e.getName(), e.getPsiElement())
                                .withIcon(GoIcons.TYPE)
                        )
                        .collect(Collectors.toList());
                break;
            case MetaParser.RULE_fieldName:
                Declaration decl = listener.getDecl();
                if (decl == null) {
                    break;
                }
                builders = decl.getFields()
                        .stream()
                        .filter(e -> !listener.getParsedFieldNames().contains(e.getName()))
                        .filter(e -> StringUtils.startsWith(e.getName(), lastSubText))
                        .map(e -> LookupElementBuilder.createWithSmartPointer(e.getName(), e.getPsiElement())
                                .withIcon(GoIcons.FIELD).withTypeText(e.getType().getGoType())
                        )
                        .collect(Collectors.toList());
                break;
            default:
                //empty
        }
        if (builders == null) {
            return;
        }
        if (StringUtils.isBlank(lastSubText)) {
            resultSet.addAllElements(builders);
        } else {
            resultSet.withPrefixMatcher(lastSubText).addAllElements(builders);
        }
    }
}

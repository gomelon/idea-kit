package com.github.gomelon.ideakit.highlighting;

import com.github.gomelon.ideakit.antlr.MetaLexer;
import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.antlr.MetaParserBaseListener;
import com.github.gomelon.ideakit.antlr.MetaParserListener;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationCacheManager;
import com.github.gomelon.ideakit.meta.DeclarationParser;
import com.github.gomelon.ideakit.utils.CommentUtils;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MetaCommentHighlighterAnnotator implements Annotator {

    public static final TextAttributesKey QUALIFY_NAME =
            createTextAttributesKey("META_QUALIFY_NAME", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey FIELD_NAME =
            createTextAttributesKey("META_FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("META_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("META_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("META_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof PsiComment)) {
            return;
        }

        String qualifyName = DeclarationParser.getQualifyName(CommentUtils.extractComment((PsiComment) element));
        if (StringUtils.isEmpty(qualifyName)) {
            return;
        }

        DeclarationCache declarationCache = DeclarationCacheManager.getInstance(element.getProject());
        if (!declarationCache.contains(qualifyName)) {
            return;
        }

        int startOffset = element.getTextRange().getStartOffset();
        List<Pair<TextRange, TextAttributesKey>> highlights = getHighlights(element.getText(), startOffset);

        for (Pair<TextRange, TextAttributesKey> highlight : highlights) {
            holder.newSilentAnnotation(HighlightSeverity.WARNING)
                    .range(highlight.first)
                    .textAttributes(highlight.second)
                    .create();
        }
    }

    private List<Pair<TextRange, TextAttributesKey>> getHighlights(String text, int startOffset) {
        List<Pair<TextRange, TextAttributesKey>> highlights = new LinkedList<>();

        CharStream inputStream = CharStreams.fromString(text);
        MetaLexer metaLexer = new MetaLexer(inputStream);
        TokenStream tokenStream = new CommonTokenStream(metaLexer);
        MetaParser metaParser = new MetaParser(tokenStream);
        ParseTree rootContext = metaParser.root();

        MetaParserListener listener = new MetaParserHighlightListener(highlights, startOffset);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, rootContext);
        return highlights;
    }

    private static Pair<TextRange, TextAttributesKey> createHighlight(
            ParserRuleContext ctx, int startOffset, TextAttributesKey attributesKey) {
        int innerStartOffset = startOffset + ctx.getStart().getStartIndex();
        int innerEndOffset = innerStartOffset + ctx.getText().length();
        TextRange textRange = new TextRange(innerStartOffset, innerEndOffset);
        return Pair.create(textRange, attributesKey);
    }

    static class MetaParserHighlightListener extends MetaParserBaseListener {

        private final List<Pair<TextRange, TextAttributesKey>> highlights;
        private final int startOffset;

        public MetaParserHighlightListener(List<Pair<TextRange, TextAttributesKey>> highlights, int startOffset) {
            this.highlights = highlights;
            this.startOffset = startOffset;
        }

        @Override
        public void exitMetaQualifyName(MetaParser.MetaQualifyNameContext ctx) {
            highlights.add(createHighlight(ctx, startOffset, QUALIFY_NAME));
        }

        @Override
        public void exitFieldName(MetaParser.FieldNameContext ctx) {
            highlights.add(createHighlight(ctx, startOffset, FIELD_NAME));
        }

        @Override
        public void exitStrValue(MetaParser.StrValueContext ctx) {
            highlights.add(createHighlight(ctx, startOffset, STRING));
        }

        @Override
        public void exitBoolValue(MetaParser.BoolValueContext ctx) {
            highlights.add(createHighlight(ctx, startOffset, KEYWORD));
        }

        @Override
        public void exitNumValue(MetaParser.NumValueContext ctx) {
            highlights.add(createHighlight(ctx, startOffset, NUMBER));
        }
    }
}

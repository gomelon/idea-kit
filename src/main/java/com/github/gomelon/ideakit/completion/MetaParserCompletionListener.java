package com.github.gomelon.ideakit.completion;

import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.antlr.MetaParserBaseListener;
import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * MetaParserListener for Completion
 */
public class MetaParserCompletionListener extends MetaParserBaseListener {

    private final DeclarationCache declarationCache;

    private Declaration decl;

    private final Set<String> parsedFieldNames = new HashSet<>();

    public int lastRuleIndex;

    public String lastSubText = "";

    public MetaParserCompletionListener(DeclarationCache declarationCache) {
        this.declarationCache = declarationCache;
    }

    public Declaration getDecl() {
        return decl;
    }

    public Set<String> getParsedFieldNames() {
        return parsedFieldNames;
    }

    public int getLastRuleIndex() {
        return lastRuleIndex;
    }

    public String getLastSubText() {
        return lastSubText;
    }

    @Override
    public void enterMetaQualifyName(MetaParser.MetaQualifyNameContext ctx) {
        lastRuleIndex = ctx.getRuleIndex();
        lastSubText = "";
    }

    @Override
    public void exitMetaQualifyName(MetaParser.MetaQualifyNameContext ctx) {
        String qualifyName = ctx.getText();
        Optional<Declaration> decl = declarationCache.get(qualifyName);
        decl.ifPresent(declaration -> this.decl = declaration);
        lastSubText = qualifyName;
    }

    @Override
    public void enterFieldName(MetaParser.FieldNameContext ctx) {
        lastRuleIndex = ctx.getRuleIndex();
        lastSubText = "";
    }

    @Override
    public void exitFieldName(MetaParser.FieldNameContext ctx) {
        parsedFieldNames.add(ctx.getText());
        lastSubText = ctx.getText();
    }

    @Override
    public void enterValueExpr(MetaParser.ValueExprContext ctx) {
        lastRuleIndex = ctx.getRuleIndex();
        lastSubText = "";
    }

    @Override
    public void exitValueExpr(MetaParser.ValueExprContext ctx) {
        lastSubText = ctx.getText();
    }
}

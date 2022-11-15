// Generated from /home/kimloong/IdeaProjects/idea-kit/idea-kit/src/main/java/com/github/gomelon/ideakit/antlr/MetaParser.g4 by ANTLR 4.10.1
package com.github.gomelon.ideakit.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MetaParser}.
 */
public interface MetaParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MetaParser#root}.
     *
     * @param ctx the parse tree
     */
    void enterRoot(MetaParser.RootContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#root}.
     *
     * @param ctx the parse tree
     */
    void exitRoot(MetaParser.RootContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#singleLine}.
     *
     * @param ctx the parse tree
     */
    void enterSingleLine(MetaParser.SingleLineContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#singleLine}.
     *
     * @param ctx the parse tree
     */
    void exitSingleLine(MetaParser.SingleLineContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#multipleLine}.
     *
     * @param ctx the parse tree
     */
    void enterMultipleLine(MetaParser.MultipleLineContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#multipleLine}.
     *
     * @param ctx the parse tree
     */
    void exitMultipleLine(MetaParser.MultipleLineContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#metaBody}.
     *
     * @param ctx the parse tree
     */
    void enterMetaBody(MetaParser.MetaBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#metaBody}.
     *
     * @param ctx the parse tree
     */
    void exitMetaBody(MetaParser.MetaBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#metaQualifyName}.
     *
     * @param ctx the parse tree
     */
    void enterMetaQualifyName(MetaParser.MetaQualifyNameContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#metaQualifyName}.
     *
     * @param ctx the parse tree
     */
    void exitMetaQualifyName(MetaParser.MetaQualifyNameContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#fieldExpr}.
     *
     * @param ctx the parse tree
     */
    void enterFieldExpr(MetaParser.FieldExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#fieldExpr}.
     *
     * @param ctx the parse tree
     */
    void exitFieldExpr(MetaParser.FieldExprContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#fieldNameValueExpr}.
     *
     * @param ctx the parse tree
     */
    void enterFieldNameValueExpr(MetaParser.FieldNameValueExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#fieldNameValueExpr}.
     *
     * @param ctx the parse tree
     */
    void exitFieldNameValueExpr(MetaParser.FieldNameValueExprContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#fieldName}.
     *
     * @param ctx the parse tree
     */
    void enterFieldName(MetaParser.FieldNameContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#fieldName}.
     *
     * @param ctx the parse tree
     */
    void exitFieldName(MetaParser.FieldNameContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#valueExpr}.
     *
     * @param ctx the parse tree
     */
    void enterValueExpr(MetaParser.ValueExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#valueExpr}.
     *
     * @param ctx the parse tree
     */
    void exitValueExpr(MetaParser.ValueExprContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#boolValue}.
     *
     * @param ctx the parse tree
     */
    void enterBoolValue(MetaParser.BoolValueContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#boolValue}.
     *
     * @param ctx the parse tree
     */
    void exitBoolValue(MetaParser.BoolValueContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#strValue}.
     *
     * @param ctx the parse tree
     */
    void enterStrValue(MetaParser.StrValueContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#strValue}.
     *
     * @param ctx the parse tree
     */
    void exitStrValue(MetaParser.StrValueContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#floatValue}.
     *
     * @param ctx the parse tree
     */
    void enterFloatValue(MetaParser.FloatValueContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#floatValue}.
     *
     * @param ctx the parse tree
     */
    void exitFloatValue(MetaParser.FloatValueContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#integerValue}.
     *
     * @param ctx the parse tree
     */
    void enterIntegerValue(MetaParser.IntegerValueContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#integerValue}.
     *
     * @param ctx the parse tree
     */
    void exitIntegerValue(MetaParser.IntegerValueContext ctx);

    /**
     * Enter a parse tree produced by {@link MetaParser#fieldNameExpr}.
     *
     * @param ctx the parse tree
     */
    void enterFieldNameExpr(MetaParser.FieldNameExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MetaParser#fieldNameExpr}.
     *
     * @param ctx the parse tree
     */
    void exitFieldNameExpr(MetaParser.FieldNameExprContext ctx);
}
package com.github.gomelon.ideakit.inspection;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class MetaParserInspectionErrorStrategy extends DefaultErrorStrategy {
    private final String text;

    public MetaParserInspectionErrorStrategy(String text) {
        this.text = text;
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        Token offendingToken = e.getOffendingToken();
        String msg = "mismatched input " + getTokenErrorDisplay(offendingToken) +
                " expecting " + e.getExpectedTokens().toString(recognizer.getVocabulary());

        MetaParserInspectionListener inspectionListener = null;
        for (ParseTreeListener parseListener : recognizer.getParseListeners()) {
            if (parseListener instanceof MetaParserInspectionListener) {
                inspectionListener = (MetaParserInspectionListener) parseListener;
            }
        }
        int startIndex = 0;
        int stopIndex = text.length();
        if (inspectionListener != null && inspectionListener.getPreRuleContext() != null) {
            ParserRuleContext preRuleContext = inspectionListener.getPreRuleContext();
            startIndex = preRuleContext.getStart().getStartIndex();
            stopIndex = startIndex + preRuleContext.getText().length();
        }

        throw new MetaInspectionException(startIndex, stopIndex, MetaErrorCode.INPUT_MISMATCH, msg);
    }
}

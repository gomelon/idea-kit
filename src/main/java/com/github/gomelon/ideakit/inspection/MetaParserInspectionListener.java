package com.github.gomelon.ideakit.inspection;

import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.antlr.MetaParserBaseListener;
import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationFieldType;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class MetaParserInspectionListener extends MetaParserBaseListener {

    private final DeclarationCache declarationCache;

    private Declaration decl;

    private final Set<String> parsedFieldNames = new HashSet<>();

    private Declaration.Field currentField;

    private Object currentFieldValue;

    private ParserRuleContext preRuleContext;

    private final List<MetaInspectionException> errors = new LinkedList<>();

    public MetaParserInspectionListener(DeclarationCache declarationCache) {
        this.declarationCache = declarationCache;
    }

    public List<MetaInspectionException> getErrors() {
        return errors;
    }

    public ParserRuleContext getPreRuleContext() {
        return preRuleContext;
    }

    @Override
    public void exitMetaQualifyName(MetaParser.MetaQualifyNameContext ctx) {
        // 去掉前面的+号
        String ctxText = ctx.getText();
        if (ctxText.length() <= 1) {
            throw new NotMetaCancellationException();
        }
        String qualifyName = ctxText.substring(1);
        Optional<Declaration> decl = declarationCache.get(qualifyName);
        if (decl.isPresent()) {
            this.decl = decl.get();
        } else {
            throw new NotMetaCancellationException();
        }
    }

    @Override
    public void exitFieldName(MetaParser.FieldNameContext ctx) {
        String currentFieldName = ctx.getText();
        Optional<Declaration.Field> field = decl.getField(currentFieldName);
        int startIndex = ctx.getStart().getStartIndex();
        int stopIndex = startIndex + ctx.getText().length();
        if (field.isPresent()) {
            if (parsedFieldNames.contains(currentFieldName)) {
                errors.add(new MetaInspectionException(startIndex, stopIndex, MetaErrorCode.DUPLICATE_FIELD,
                        "Duplicate meta field " + currentFieldName)
                );
                currentField = null;
            } else {
                currentField = field.get();
                parsedFieldNames.add(currentFieldName);
            }
        } else {
            errors.add(new MetaInspectionException(startIndex, stopIndex, MetaErrorCode.UNKNOWN_FIELD,
                    "Unknown meta field " + currentFieldName)
            );
            currentField = null;
        }
    }

    @Override
    public void exitFieldNameExpr(MetaParser.FieldNameExprContext ctx) {
        if (currentField == null) {
            return;
        }
        if (currentField.getType() != DeclarationFieldType.BOOL) {
            int startIndex = ctx.getStart().getStartIndex();
            int stopIndex = startIndex + ctx.getText().length();
            errors.add(new MetaInspectionException(startIndex, stopIndex, MetaErrorCode.INVALID_FIELD_VALUE,
                    "Only boolean type fields can omit value")
            );
        }
    }

    @Override
    public void exitFieldNameValueExpr(MetaParser.FieldNameValueExprContext ctx) {
        if (currentField == null) {
            return;
        }
        try {
            currentField.getType().checkValue(currentFieldValue);
        } catch (RuntimeException e) {
            int startIndex = ctx.getStart().getStartIndex();
            int stopIndex = startIndex + ctx.getText().length();
            errors.add(new MetaInspectionException(startIndex, stopIndex,
                    MetaErrorCode.INVALID_FIELD_VALUE, e.getMessage())
            );
        }
    }

    @Override
    public void exitBoolValue(MetaParser.BoolValueContext ctx) {
        String valueStr = ctx.getText();
        currentFieldValue = BooleanUtils.toBoolean(valueStr);
    }

    @Override
    public void exitStrValue(MetaParser.StrValueContext ctx) {
        String valueStr = ctx.getText();
        currentFieldValue = StringUtils.strip(valueStr, "\"");
    }

    @Override
    public void exitNumValue(MetaParser.NumValueContext ctx) {
        String valueStr = ctx.getText();
        currentFieldValue = new BigDecimal(valueStr);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        preRuleContext = ctx;
    }
}

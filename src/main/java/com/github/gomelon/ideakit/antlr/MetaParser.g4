parser grammar MetaParser;

options {
    tokenVocab = MetaLexer;
}

root:
    singleLine
    | multipleLine
    EOF;

singleLine:
    LINE_COMMENT PLUS meta;
multipleLine:
    BLOCK_COMMENT_START PLUS meta BLOCK_COMMENT_END ;

meta:
    metaQualifyName metaBody?;

metaQualifyName:
    META_QUALIFY_NAME;

metaBody:
    fieldExpr+;
fieldExpr:
    fieldNameValueExpr
    |fieldNameExpr;
fieldNameValueExpr:
    fieldName ASSIGNMENT valueExpr;
fieldName:
    IDENT;
valueExpr:
    boolValue
    | numValue
    | strValue;
boolValue:
    BOOLEAN;
strValue:
    STRING;
numValue:
    FLOAT|INTEGER;
fieldNameExpr:
    fieldName;
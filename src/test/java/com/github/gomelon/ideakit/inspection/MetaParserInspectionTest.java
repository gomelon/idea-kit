package com.github.gomelon.ideakit.inspection;

import com.github.gomelon.ideakit.antlr.MetaLexer;
import com.github.gomelon.ideakit.antlr.MetaParser;
import com.github.gomelon.ideakit.meta.Declaration;
import com.github.gomelon.ideakit.meta.DeclarationCache;
import com.github.gomelon.ideakit.meta.DeclarationFieldType;
import com.intellij.openapi.project.Project;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class MetaParserInspectionTest {

    private DeclarationCache declarationCache;

    private MetaParserInspectionListener listener;

    @BeforeEach
    void before() {
        Project project = mock(Project.class);
        doReturn("/home/kimloong/demo").when(project).getBasePath();
        declarationCache = new DeclarationCache(project);

        Declaration localDecl = new Declaration();
        localDecl.setFilePath("/home/kimloong/demo/meta.go");
        localDecl.setName("demo.Demo");

        Declaration.Field int32Field = new Declaration.Field();
        int32Field.setName("Int32Value");
        int32Field.setType(DeclarationFieldType.INT32);

        Declaration.Field stringField = new Declaration.Field();
        stringField.setName("StringValue");
        stringField.setType(DeclarationFieldType.STRING);

        Declaration.Field boolField = new Declaration.Field();
        boolField.setName("BoolValue");
        boolField.setType(DeclarationFieldType.BOOL);

        localDecl.setFields(Arrays.asList(int32Field, stringField, boolField));
        declarationCache.put(localDecl);
    }

    static Stream<Arguments> normalMetaExprProvider() {
        return Stream.of(
                Arguments.of("normal",
                        "//+demo.Demo Int32Value=1 StringValue=\"Hi\" BoolValue=true"),
                Arguments.of("with short",
                        "//+demo.Demo Int32Value=1 StringValue=\"Hi\" BoolValue")
        );
    }

    @ParameterizedTest
    @MethodSource("normalMetaExprProvider")
    void shouldAllowNormalMetaExpr(String caseName, String text) {
        System.out.println("caseName: " + caseName);
        DeclarationCache declarationCache = mock(DeclarationCache.class);
        doReturn(true).when(declarationCache).contains("a.b");

        parse(text);

        assertTrue(listener.getErrors().isEmpty());
    }

    static Stream<Arguments> invalidMetaExprProvider() {
        return Stream.of(
                Arguments.of("unknown field",
                        "//+demo.Demo UnknownField=1 StringValue=\"Hi\" BoolValue=true"),
                Arguments.of("duplicate field",
                        "//+demo.Demo Int32Value=1 Int32Value=1"),
                Arguments.of("invalid short for not bool field",
                        "//+demo.Demo Int32Value StringValue=\"Hi\" BoolValue"),
                Arguments.of("float value for integer field",
                        "//+demo.Demo Int32Value=1.1 StringValue=\"Hi\" BoolValue")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidMetaExprProvider")
    void shouldErrorOnInvalidMetaExpr(String caseName, String text) {
        System.out.println("caseName: " + caseName);
        DeclarationCache declarationCache = mock(DeclarationCache.class);
        doReturn(true).when(declarationCache).contains("a.b");

        parse(text);

        assertFalse(listener.getErrors().isEmpty());
    }

    @Test
    void shouldThrowOnNotMetaException() {
        String text = "//+demo.NoneMeta";

        assertThrows(
                NotMetaCancellationException.class,
                () -> parse(text),
                "expected throw exception but not");

    }

    @Test
    void shouldThrowOnMissingFieldValue() {
        DeclarationCache declarationCache = mock(DeclarationCache.class);
        String text = "//+demo.Demo Int32Value= StringValue=\"Hi\"";
        doReturn(true).when(declarationCache).contains("a.b");

        MetaInspectionException thrown = assertThrows(
                MetaInspectionException.class,
                () -> parse(text),
                "expected throw exception but not");
        assertEquals(MetaErrorCode.INPUT_MISMATCH, thrown.getErrorCode());
        assertEquals(25, thrown.getStartIndex());
        assertEquals(36, thrown.getStopIndex());
        assertEquals("mismatched input 'StringValue' expecting {BOOLEAN, FLOAT, INTEGER, STRING}",
                thrown.getMessage());
    }

    static Stream<Arguments> stringMissingQuoteProvider() {
        return Stream.of(
                Arguments.of("missing left quote",
                        "//+demo.Demo Int32Value=1 StringValue=Hi\" BoolValue", 38, 40),
                Arguments.of("missing right quote",
                        "//+demo.Demo Int32Value=1 StringValue=\"Hi BoolValue", 39, 41),
                Arguments.of("missing left and right quote",
                        "//+demo.Demo Int32Value=1 StringValue=Hi BoolValue", 38, 40)
        );
    }

    @ParameterizedTest
    @MethodSource("stringMissingQuoteProvider")
    void shouldThrowOnStringMissingQuote(String caseName, String text, int expectedStartIndex, int expectedStopIndex) {
        System.out.println("caseName: " + caseName);
        DeclarationCache declarationCache = mock(DeclarationCache.class);
        doReturn(true).when(declarationCache).contains("a.b");

        MetaInspectionException thrown = assertThrows(
                MetaInspectionException.class,
                () -> parse(text),
                "expected throw exception but not");
        assertEquals(MetaErrorCode.INPUT_MISMATCH, thrown.getErrorCode());
        assertEquals(expectedStartIndex, thrown.getStartIndex());
        assertEquals(expectedStopIndex, thrown.getStopIndex());
        assertEquals("mismatched input 'Hi' expecting {BOOLEAN, FLOAT, INTEGER, STRING}",
                thrown.getMessage());
    }

    @Test
    void t() {
        BigDecimal bigDecimal = new BigDecimal("1.1");
        System.out.println(bigDecimal.scale());
        BigDecimal bigDecimal2 = new BigDecimal("1");
        System.out.println(bigDecimal2.scale());
    }

    private void parse(String text) {
        CharStream inputStream = CharStreams.fromString(text);
        MetaLexer metaLexer = new MetaLexer(inputStream);
        TokenStream tokenStream = new CommonTokenStream(metaLexer);
        MetaParser metaParser = new MetaParser(tokenStream);
        metaParser.setErrorHandler(new MetaParserInspectionErrorStrategy(text));
        listener = new MetaParserInspectionListener(declarationCache);
        metaParser.addParseListener(listener);
        metaParser.root();
    }
}
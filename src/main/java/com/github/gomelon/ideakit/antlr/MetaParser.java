// Generated from /home/kimloong/IdeaProjects/idea-kit/idea-kit/src/main/java/com/github/gomelon/ideakit/antlr/MetaParser.g4 by ANTLR 4.10.1
package com.github.gomelon.ideakit.antlr;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaParser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final int
			META_QUALIFY_NAME = 1, STRING = 2, BOOLEAN = 3, FLOAT = 4, INTEGER = 5, LINE_COMMENT = 6,
			BLOCK_COMMENT_START = 7, BLOCK_COMMENT_END = 8, IDENT = 9, WS = 10, PLUS = 11, ASSIGNMENT = 12,
			DOT = 13, ERRCHAR = 14;
	public static final int
			RULE_root = 0, RULE_singleLine = 1, RULE_multipleLine = 2, RULE_metaBody = 3,
			RULE_metaQualifyName = 4, RULE_fieldExpr = 5, RULE_fieldNameValueExpr = 6,
			RULE_fieldName = 7, RULE_valueExpr = 8, RULE_boolValue = 9, RULE_strValue = 10,
			RULE_floatValue = 11, RULE_integerValue = 12, RULE_fieldNameExpr = 13;

	private static String[] makeRuleNames() {
		return new String[]{
				"root", "singleLine", "multipleLine", "metaBody", "metaQualifyName",
				"fieldExpr", "fieldNameValueExpr", "fieldName", "valueExpr", "boolValue",
				"strValue", "floatValue", "integerValue", "fieldNameExpr"
		};
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[]{
				null, null, null, null, null, null, "'//'", "'/*'", "'*/'", null, null,
				"'+'", "'='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[]{
				null, "META_QUALIFY_NAME", "STRING", "BOOLEAN", "FLOAT", "INTEGER", "LINE_COMMENT",
				"BLOCK_COMMENT_START", "BLOCK_COMMENT_END", "IDENT", "WS", "PLUS", "ASSIGNMENT",
				"DOT", "ERRCHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() {
		return "MetaParser.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public MetaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public SingleLineContext singleLine() {
			return getRuleContext(SingleLineContext.class, 0);
		}

		public MultipleLineContext multipleLine() {
			return getRuleContext(MultipleLineContext.class, 0);
		}

		public TerminalNode EOF() {
			return getToken(MetaParser.EOF, 0);
		}

		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_root;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case LINE_COMMENT:
					enterOuterAlt(_localctx, 1);
				{
					setState(28);
					singleLine();
				}
				break;
				case BLOCK_COMMENT_START:
					enterOuterAlt(_localctx, 2);
				{
					setState(29);
					multipleLine();
					setState(30);
					match(EOF);
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleLineContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() {
			return getToken(MetaParser.LINE_COMMENT, 0);
		}

		public MetaBodyContext metaBody() {
			return getRuleContext(MetaBodyContext.class, 0);
		}

		public SingleLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_singleLine;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterSingleLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitSingleLine(this);
		}
	}

	public final SingleLineContext singleLine() throws RecognitionException {
		SingleLineContext _localctx = new SingleLineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(34);
				match(LINE_COMMENT);
				setState(35);
				metaBody();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleLineContext extends ParserRuleContext {
		public TerminalNode BLOCK_COMMENT_START() {
			return getToken(MetaParser.BLOCK_COMMENT_START, 0);
		}

		public MetaBodyContext metaBody() {
			return getRuleContext(MetaBodyContext.class, 0);
		}

		public TerminalNode BLOCK_COMMENT_END() {
			return getToken(MetaParser.BLOCK_COMMENT_END, 0);
		}

		public MultipleLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_multipleLine;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMultipleLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMultipleLine(this);
		}
	}

	public final MultipleLineContext multipleLine() throws RecognitionException {
		MultipleLineContext _localctx = new MultipleLineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multipleLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(37);
				match(BLOCK_COMMENT_START);
				setState(38);
				metaBody();
				setState(39);
				match(BLOCK_COMMENT_END);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetaBodyContext extends ParserRuleContext {
		public MetaQualifyNameContext metaQualifyName() {
			return getRuleContext(MetaQualifyNameContext.class, 0);
		}
		public List<FieldExprContext> fieldExpr() {
			return getRuleContexts(FieldExprContext.class);
		}
		public FieldExprContext fieldExpr(int i) {
			return getRuleContext(FieldExprContext.class, i);
		}

		public MetaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_metaBody;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMetaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMetaBody(this);
		}
	}

	public final MetaBodyContext metaBody() throws RecognitionException {
		MetaBodyContext _localctx = new MetaBodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_metaBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(41);
				metaQualifyName();
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == IDENT) {
					{
						{
							setState(42);
							fieldExpr();
						}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetaQualifyNameContext extends ParserRuleContext {
		public TerminalNode META_QUALIFY_NAME() {
			return getToken(MetaParser.META_QUALIFY_NAME, 0);
		}

		public MetaQualifyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_metaQualifyName;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterMetaQualifyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitMetaQualifyName(this);
		}
	}

	public final MetaQualifyNameContext metaQualifyName() throws RecognitionException {
		MetaQualifyNameContext _localctx = new MetaQualifyNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_metaQualifyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(48);
				match(META_QUALIFY_NAME);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldExprContext extends ParserRuleContext {
		public FieldNameValueExprContext fieldNameValueExpr() {
			return getRuleContext(FieldNameValueExprContext.class, 0);
		}
		public FieldNameExprContext fieldNameExpr() {
			return getRuleContext(FieldNameExprContext.class, 0);
		}

		public FieldExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_fieldExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitFieldExpr(this);
		}
	}

	public final FieldExprContext fieldExpr() throws RecognitionException {
		FieldExprContext _localctx = new FieldExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fieldExpr);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(50);
					fieldNameValueExpr();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(51);
					fieldNameExpr();
				}
				break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameValueExprContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class, 0);
		}

		public TerminalNode ASSIGNMENT() {
			return getToken(MetaParser.ASSIGNMENT, 0);
		}

		public ValueExprContext valueExpr() {
			return getRuleContext(ValueExprContext.class, 0);
		}

		public FieldNameValueExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_fieldNameValueExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterFieldNameValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitFieldNameValueExpr(this);
		}
	}

	public final FieldNameValueExprContext fieldNameValueExpr() throws RecognitionException {
		FieldNameValueExprContext _localctx = new FieldNameValueExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldNameValueExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(54);
				fieldName();
				setState(55);
				match(ASSIGNMENT);
				setState(56);
				valueExpr();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode IDENT() {
			return getToken(MetaParser.IDENT, 0);
		}

		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_fieldName;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(58);
				match(IDENT);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExprContext extends ParserRuleContext {
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class, 0);
		}
		public FloatValueContext floatValue() {
			return getRuleContext(FloatValueContext.class, 0);
		}
		public IntegerValueContext integerValue() {
			return getRuleContext(IntegerValueContext.class, 0);
		}
		public StrValueContext strValue() {
			return getRuleContext(StrValueContext.class, 0);
		}

		public ValueExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_valueExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitValueExpr(this);
		}
	}

	public final ValueExprContext valueExpr() throws RecognitionException {
		ValueExprContext _localctx = new ValueExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_valueExpr);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case BOOLEAN:
					enterOuterAlt(_localctx, 1);
				{
					setState(60);
					boolValue();
				}
				break;
				case FLOAT:
					enterOuterAlt(_localctx, 2);
				{
					setState(61);
					floatValue();
				}
				break;
				case INTEGER:
					enterOuterAlt(_localctx, 3);
				{
					setState(62);
					integerValue();
				}
				break;
				case STRING:
					enterOuterAlt(_localctx, 4);
				{
					setState(63);
					strValue();
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() {
			return getToken(MetaParser.BOOLEAN, 0);
		}

		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_boolValue;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitBoolValue(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_boolValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(66);
				match(BOOLEAN);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrValueContext extends ParserRuleContext {
		public TerminalNode STRING() {
			return getToken(MetaParser.STRING, 0);
		}

		public StrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_strValue;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterStrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitStrValue(this);
		}
	}

	public final StrValueContext strValue() throws RecognitionException {
		StrValueContext _localctx = new StrValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_strValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(68);
				match(STRING);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FloatValueContext extends ParserRuleContext {
		public TerminalNode FLOAT() {
			return getToken(MetaParser.FLOAT, 0);
		}

		public FloatValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_floatValue;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterFloatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitFloatValue(this);
		}
	}

	public final FloatValueContext floatValue() throws RecognitionException {
		FloatValueContext _localctx = new FloatValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_floatValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(70);
				match(FLOAT);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerValueContext extends ParserRuleContext {
		public TerminalNode INTEGER() {
			return getToken(MetaParser.INTEGER, 0);
		}

		public IntegerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_integerValue;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterIntegerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitIntegerValue(this);
		}
	}

	public final IntegerValueContext integerValue() throws RecognitionException {
		IntegerValueContext _localctx = new IntegerValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_integerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(72);
				match(INTEGER);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameExprContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class, 0);
		}

		public FieldNameExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_fieldNameExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).enterFieldNameExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MetaParserListener) ((MetaParserListener) listener).exitFieldNameExpr(this);
		}
	}

	public final FieldNameExprContext fieldNameExpr() throws RecognitionException {
		FieldNameExprContext _localctx = new FieldNameExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fieldNameExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(74);
				fieldName();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
			"\u0004\u0001\u000eM\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
					"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
					"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
					"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
					"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
					"\u0003\u0000!\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002" +
					"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003" +
					",\b\u0003\n\u0003\f\u0003/\t\u0003\u0001\u0004\u0001\u0004\u0001\u0005" +
					"\u0001\u0005\u0003\u00055\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006" +
					"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003" +
					"\bA\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001" +
					"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004" +
					"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0000D\u0000" +
					" \u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004%\u0001" +
					"\u0000\u0000\u0000\u0006)\u0001\u0000\u0000\u0000\b0\u0001\u0000\u0000" +
					"\u0000\n4\u0001\u0000\u0000\u0000\f6\u0001\u0000\u0000\u0000\u000e:\u0001" +
					"\u0000\u0000\u0000\u0010@\u0001\u0000\u0000\u0000\u0012B\u0001\u0000\u0000" +
					"\u0000\u0014D\u0001\u0000\u0000\u0000\u0016F\u0001\u0000\u0000\u0000\u0018" +
					"H\u0001\u0000\u0000\u0000\u001aJ\u0001\u0000\u0000\u0000\u001c!\u0003" +
					"\u0002\u0001\u0000\u001d\u001e\u0003\u0004\u0002\u0000\u001e\u001f\u0005" +
					"\u0000\u0000\u0001\u001f!\u0001\u0000\u0000\u0000 \u001c\u0001\u0000\u0000" +
					"\u0000 \u001d\u0001\u0000\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\"" +
					"#\u0005\u0006\u0000\u0000#$\u0003\u0006\u0003\u0000$\u0003\u0001\u0000" +
					"\u0000\u0000%&\u0005\u0007\u0000\u0000&\'\u0003\u0006\u0003\u0000\'(\u0005" +
					"\b\u0000\u0000(\u0005\u0001\u0000\u0000\u0000)-\u0003\b\u0004\u0000*," +
					"\u0003\n\u0005\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000" +
					"-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\u0007\u0001\u0000" +
					"\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\u0001\u0000\u00001\t\u0001" +
					"\u0000\u0000\u000025\u0003\f\u0006\u000035\u0003\u001a\r\u000042\u0001" +
					"\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u000b\u0001\u0000\u0000" +
					"\u000067\u0003\u000e\u0007\u000078\u0005\f\u0000\u000089\u0003\u0010\b" +
					"\u00009\r\u0001\u0000\u0000\u0000:;\u0005\t\u0000\u0000;\u000f\u0001\u0000" +
					"\u0000\u0000<A\u0003\u0012\t\u0000=A\u0003\u0016\u000b\u0000>A\u0003\u0018" +
					"\f\u0000?A\u0003\u0014\n\u0000@<\u0001\u0000\u0000\u0000@=\u0001\u0000" +
					"\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\u0011" +
					"\u0001\u0000\u0000\u0000BC\u0005\u0003\u0000\u0000C\u0013\u0001\u0000" +
					"\u0000\u0000DE\u0005\u0002\u0000\u0000E\u0015\u0001\u0000\u0000\u0000" +
					"FG\u0005\u0004\u0000\u0000G\u0017\u0001\u0000\u0000\u0000HI\u0005\u0005" +
					"\u0000\u0000I\u0019\u0001\u0000\u0000\u0000JK\u0003\u000e\u0007\u0000" +
					"K\u001b\u0001\u0000\u0000\u0000\u0004 -4@";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
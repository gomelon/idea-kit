// Generated from /home/kimloong/IdeaProjects/idea-kit/idea-kit/src/main/java/com/github/gomelon/ideakit/antlr/MetaLexer.g4 by ANTLR 4.10.1
package com.github.gomelon.ideakit.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MetaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		META_QUALIFY_NAME=1, BOOLEAN=2, FLOAT=3, INTEGER=4, LINE_COMMENT=5, BLOCK_COMMENT_START=6, 
		BLOCK_COMMENT_END=7, IDENT=8, WS=9, STRING=10, PLUS=11, ASSIGNMENT=12, 
		DOT=13, ERRCHAR=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"META_QUALIFY_NAME", "BOOLEAN", "FLOAT", "INTEGER", "LINE_COMMENT", "BLOCK_COMMENT_START", 
			"BLOCK_COMMENT_END", "IDENT", "WS", "STRING", "DIGIT", "UNDERSCORE", 
			"ALPHA", "STRING_F", "PLUS", "ASSIGNMENT", "DOT", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'//'", "'/*'", "'*/'", null, null, null, 
			"'+'", "'='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "META_QUALIFY_NAME", "BOOLEAN", "FLOAT", "INTEGER", "LINE_COMMENT", 
			"BLOCK_COMMENT_START", "BLOCK_COMMENT_END", "IDENT", "WS", "STRING", 
			"PLUS", "ASSIGNMENT", "DOT", "ERRCHAR"
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


	public MetaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MetaLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000e\u0081\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000)\b\u0000\u000b\u0000"+
		"\f\u0000*\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00018\b\u0001\u0001\u0002\u0004\u0002;\b\u0002\u000b\u0002\f\u0002"+
		"<\u0001\u0002\u0001\u0002\u0004\u0002A\b\u0002\u000b\u0002\f\u0002B\u0001"+
		"\u0003\u0004\u0003F\b\u0003\u000b\u0003\f\u0003G\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007U\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007[\b\u0007\n\u0007\f\u0007"+
		"^\t\u0007\u0001\b\u0004\ba\b\b\u000b\b\f\bb\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0005\ti\b\t\n\t\f\tl\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u000b\u001f\f!\r#\u000e"+
		"\u0001\u0000\u0004\u0003\u0000\t\n\r\r  \u0004\u0000\n\n\r\r\"\"::\u0001"+
		"\u000009\u0002\u0000AZaz\u0088\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0001(\u0001\u0000\u0000\u0000\u00037\u0001\u0000\u0000\u0000\u0005"+
		":\u0001\u0000\u0000\u0000\u0007E\u0001\u0000\u0000\u0000\tI\u0001\u0000"+
		"\u0000\u0000\u000bL\u0001\u0000\u0000\u0000\rO\u0001\u0000\u0000\u0000"+
		"\u000fT\u0001\u0000\u0000\u0000\u0011`\u0001\u0000\u0000\u0000\u0013f"+
		"\u0001\u0000\u0000\u0000\u0015o\u0001\u0000\u0000\u0000\u0017q\u0001\u0000"+
		"\u0000\u0000\u0019s\u0001\u0000\u0000\u0000\u001bu\u0001\u0000\u0000\u0000"+
		"\u001dw\u0001\u0000\u0000\u0000\u001fy\u0001\u0000\u0000\u0000!{\u0001"+
		"\u0000\u0000\u0000#}\u0001\u0000\u0000\u0000%&\u0003\u000f\u0007\u0000"+
		"&\'\u0003!\u0010\u0000\')\u0001\u0000\u0000\u0000(%\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0003\u000f\u0007\u0000-\u0002"+
		"\u0001\u0000\u0000\u0000./\u0005t\u0000\u0000/0\u0005r\u0000\u000001\u0005"+
		"u\u0000\u000018\u0005e\u0000\u000023\u0005f\u0000\u000034\u0005a\u0000"+
		"\u000045\u0005l\u0000\u000056\u0005s\u0000\u000068\u0005e\u0000\u0000"+
		"7.\u0001\u0000\u0000\u000072\u0001\u0000\u0000\u00008\u0004\u0001\u0000"+
		"\u0000\u00009;\u0003\u0015\n\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>@\u0003!\u0010\u0000?A\u0003\u0015\n\u0000@?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000C\u0006\u0001\u0000\u0000\u0000DF\u0003\u0015"+
		"\n\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000GH\u0001\u0000\u0000\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005"+
		"/\u0000\u0000JK\u0005/\u0000\u0000K\n\u0001\u0000\u0000\u0000LM\u0005"+
		"/\u0000\u0000MN\u0005*\u0000\u0000N\f\u0001\u0000\u0000\u0000OP\u0005"+
		"*\u0000\u0000PQ\u0005/\u0000\u0000Q\u000e\u0001\u0000\u0000\u0000RU\u0003"+
		"\u0019\f\u0000SU\u0003\u0017\u000b\u0000TR\u0001\u0000\u0000\u0000TS\u0001"+
		"\u0000\u0000\u0000U\\\u0001\u0000\u0000\u0000V[\u0003\u0019\f\u0000W["+
		"\u0003\u0015\n\u0000X[\u0003\u0017\u000b\u0000Y[\u0005-\u0000\u0000ZV"+
		"\u0001\u0000\u0000\u0000ZW\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]\u0010\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000_a\u0007\u0000\u0000\u0000`_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0006\b\u0000\u0000e\u0012\u0001"+
		"\u0000\u0000\u0000fj\u0003\u001b\r\u0000gi\b\u0001\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000"+
		"\u0000mn\u0003\u001b\r\u0000n\u0014\u0001\u0000\u0000\u0000op\u0007\u0002"+
		"\u0000\u0000p\u0016\u0001\u0000\u0000\u0000qr\u0005_\u0000\u0000r\u0018"+
		"\u0001\u0000\u0000\u0000st\u0007\u0003\u0000\u0000t\u001a\u0001\u0000"+
		"\u0000\u0000uv\u0005\"\u0000\u0000v\u001c\u0001\u0000\u0000\u0000wx\u0005"+
		"+\u0000\u0000x\u001e\u0001\u0000\u0000\u0000yz\u0005=\u0000\u0000z \u0001"+
		"\u0000\u0000\u0000{|\u0005.\u0000\u0000|\"\u0001\u0000\u0000\u0000}~\t"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0006\u0011"+
		"\u0000\u0000\u0080$\u0001\u0000\u0000\u0000\u000b\u0000*7<BGTZ\\bj\u0001"+
		"\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
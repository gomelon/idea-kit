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
		META_QUALIFY_NAME=1, STRING=2, BOOLEAN=3, FLOAT=4, INTEGER=5, LINE_COMMENT=6, 
		BLOCK_COMMENT_START=7, BLOCK_COMMENT_END=8, IDENT=9, WS=10, PLUS=11, ASSIGNMENT=12, 
		DOT=13, ERRCHAR=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"META_QUALIFY_NAME", "STRING", "BOOLEAN", "FLOAT", "INTEGER", "LINE_COMMENT", 
			"BLOCK_COMMENT_START", "BLOCK_COMMENT_END", "IDENT", "WS", "DIGIT", "UNDERSCORE", 
			"ALPHA", "STRING_F", "PLUS", "ASSIGNMENT", "DOT", "ERRCHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'//'", "'/*'", "'*/'", null, null, 
			"'+'", "'='", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
		"\u0004\u0000\u000e\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000"+
		"\n\u0000\f\u0000-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0001\u0003"+
		"\u0004\u0003F\b\u0003\u000b\u0003\f\u0003G\u0001\u0003\u0001\u0003\u0004"+
		"\u0003L\b\u0003\u000b\u0003\f\u0003M\u0001\u0004\u0004\u0004Q\b\u0004"+
		"\u000b\u0004\f\u0004R\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0003\b`\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bf\b\b\n\b\f\bi"+
		"\t\b\u0001\t\u0004\tl\b\t\u000b\t\f\tm\u0001\t\u0001\t\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u000b\u001f\f"+
		"!\r#\u000e\u0001\u0000\u0004\u0001\u0000\"\"\u0003\u0000\t\n\r\r  \u0001"+
		"\u000009\u0002\u0000AZaz\u008a\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0001%\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u0005"+
		"B\u0001\u0000\u0000\u0000\u0007E\u0001\u0000\u0000\u0000\tP\u0001\u0000"+
		"\u0000\u0000\u000bT\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000"+
		"\u000fZ\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000\u0000\u0013k"+
		"\u0001\u0000\u0000\u0000\u0015q\u0001\u0000\u0000\u0000\u0017s\u0001\u0000"+
		"\u0000\u0000\u0019u\u0001\u0000\u0000\u0000\u001bw\u0001\u0000\u0000\u0000"+
		"\u001dy\u0001\u0000\u0000\u0000\u001f{\u0001\u0000\u0000\u0000!}\u0001"+
		"\u0000\u0000\u0000#\u007f\u0001\u0000\u0000\u0000%+\u0003\u001d\u000e"+
		"\u0000&\'\u0003\u0011\b\u0000\'(\u0003!\u0010\u0000(*\u0001\u0000\u0000"+
		"\u0000)&\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000./\u0003\u0011\b\u0000/\u0002\u0001\u0000\u0000\u0000"+
		"04\u0003\u001b\r\u000013\b\u0000\u0000\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0003\u001b"+
		"\r\u00008\u0004\u0001\u0000\u0000\u00009:\u0005t\u0000\u0000:;\u0005r"+
		"\u0000\u0000;<\u0005u\u0000\u0000<C\u0005e\u0000\u0000=>\u0005f\u0000"+
		"\u0000>?\u0005a\u0000\u0000?@\u0005l\u0000\u0000@A\u0005s\u0000\u0000"+
		"AC\u0005e\u0000\u0000B9\u0001\u0000\u0000\u0000B=\u0001\u0000\u0000\u0000"+
		"C\u0006\u0001\u0000\u0000\u0000DF\u0003\u0015\n\u0000ED\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0003!\u0010\u0000JL\u0003\u0015"+
		"\n\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000N\b\u0001\u0000\u0000\u0000OQ\u0003"+
		"\u0015\n\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\n\u0001\u0000\u0000\u0000"+
		"TU\u0005/\u0000\u0000UV\u0005/\u0000\u0000V\f\u0001\u0000\u0000\u0000"+
		"WX\u0005/\u0000\u0000XY\u0005*\u0000\u0000Y\u000e\u0001\u0000\u0000\u0000"+
		"Z[\u0005*\u0000\u0000[\\\u0005/\u0000\u0000\\\u0010\u0001\u0000\u0000"+
		"\u0000]`\u0003\u0019\f\u0000^`\u0003\u0017\u000b\u0000_]\u0001\u0000\u0000"+
		"\u0000_^\u0001\u0000\u0000\u0000`g\u0001\u0000\u0000\u0000af\u0003\u0019"+
		"\f\u0000bf\u0003\u0015\n\u0000cf\u0003\u0017\u000b\u0000df\u0005-\u0000"+
		"\u0000ea\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0012\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000jl\u0007\u0001\u0000\u0000kj\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0006\t\u0000\u0000p\u0014"+
		"\u0001\u0000\u0000\u0000qr\u0007\u0002\u0000\u0000r\u0016\u0001\u0000"+
		"\u0000\u0000st\u0005_\u0000\u0000t\u0018\u0001\u0000\u0000\u0000uv\u0007"+
		"\u0003\u0000\u0000v\u001a\u0001\u0000\u0000\u0000wx\u0005\"\u0000\u0000"+
		"x\u001c\u0001\u0000\u0000\u0000yz\u0005+\u0000\u0000z\u001e\u0001\u0000"+
		"\u0000\u0000{|\u0005=\u0000\u0000| \u0001\u0000\u0000\u0000}~\u0005.\u0000"+
		"\u0000~\"\u0001\u0000\u0000\u0000\u007f\u0080\t\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0006\u0011\u0000\u0000\u0082"+
		"$\u0001\u0000\u0000\u0000\u000b\u0000+4BGMR_egm\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
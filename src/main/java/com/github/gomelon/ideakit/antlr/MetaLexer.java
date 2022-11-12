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
		"\u0004\u0000\u000e\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000"+
		"\n\u0000\f\u0000-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0002\u0004\u0002=\b\u0002\u000b"+
		"\u0002\f\u0002>\u0001\u0002\u0001\u0002\u0004\u0002C\b\u0002\u000b\u0002"+
		"\f\u0002D\u0001\u0003\u0004\u0003H\b\u0003\u000b\u0003\f\u0003I\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007W\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007]\b"+
		"\u0007\n\u0007\f\u0007`\t\u0007\u0001\b\u0004\bc\b\b\u000b\b\f\bd\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0005\tk\b\t\n\t\f\tn\t\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d"+
		"\u000b\u001f\f!\r#\u000e\u0001\u0000\u0004\u0003\u0000\t\n\r\r  \u0004"+
		"\u0000\n\n\r\r\"\"::\u0001\u000009\u0002\u0000AZaz\u008a\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u00039"+
		"\u0001\u0000\u0000\u0000\u0005<\u0001\u0000\u0000\u0000\u0007G\u0001\u0000"+
		"\u0000\u0000\tK\u0001\u0000\u0000\u0000\u000bN\u0001\u0000\u0000\u0000"+
		"\rQ\u0001\u0000\u0000\u0000\u000fV\u0001\u0000\u0000\u0000\u0011b\u0001"+
		"\u0000\u0000\u0000\u0013h\u0001\u0000\u0000\u0000\u0015q\u0001\u0000\u0000"+
		"\u0000\u0017s\u0001\u0000\u0000\u0000\u0019u\u0001\u0000\u0000\u0000\u001b"+
		"w\u0001\u0000\u0000\u0000\u001dy\u0001\u0000\u0000\u0000\u001f{\u0001"+
		"\u0000\u0000\u0000!}\u0001\u0000\u0000\u0000#\u007f\u0001\u0000\u0000"+
		"\u0000%+\u0003\u001d\u000e\u0000&\'\u0003\u000f\u0007\u0000\'(\u0003!"+
		"\u0010\u0000(*\u0001\u0000\u0000\u0000)&\u0001\u0000\u0000\u0000*-\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0003\u000f\u0007"+
		"\u0000/\u0002\u0001\u0000\u0000\u000001\u0005t\u0000\u000012\u0005r\u0000"+
		"\u000023\u0005u\u0000\u00003:\u0005e\u0000\u000045\u0005f\u0000\u0000"+
		"56\u0005a\u0000\u000067\u0005l\u0000\u000078\u0005s\u0000\u00008:\u0005"+
		"e\u0000\u000090\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u0000:\u0004"+
		"\u0001\u0000\u0000\u0000;=\u0003\u0015\n\u0000<;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@B\u0003!\u0010\u0000AC\u0003\u0015\n"+
		"\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0006\u0001\u0000\u0000\u0000"+
		"FH\u0003\u0015\n\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\b\u0001\u0000\u0000"+
		"\u0000KL\u0005/\u0000\u0000LM\u0005/\u0000\u0000M\n\u0001\u0000\u0000"+
		"\u0000NO\u0005/\u0000\u0000OP\u0005*\u0000\u0000P\f\u0001\u0000\u0000"+
		"\u0000QR\u0005*\u0000\u0000RS\u0005/\u0000\u0000S\u000e\u0001\u0000\u0000"+
		"\u0000TW\u0003\u0019\f\u0000UW\u0003\u0017\u000b\u0000VT\u0001\u0000\u0000"+
		"\u0000VU\u0001\u0000\u0000\u0000W^\u0001\u0000\u0000\u0000X]\u0003\u0019"+
		"\f\u0000Y]\u0003\u0015\n\u0000Z]\u0003\u0017\u000b\u0000[]\u0005-\u0000"+
		"\u0000\\X\u0001\u0000\u0000\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000"+
		"^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0010\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0007\u0000\u0000\u0000ba\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0006\b\u0000\u0000"+
		"g\u0012\u0001\u0000\u0000\u0000hl\u0003\u001b\r\u0000ik\b\u0001\u0000"+
		"\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000op\u0003\u001b\r\u0000p\u0014\u0001\u0000\u0000\u0000"+
		"qr\u0007\u0002\u0000\u0000r\u0016\u0001\u0000\u0000\u0000st\u0005_\u0000"+
		"\u0000t\u0018\u0001\u0000\u0000\u0000uv\u0007\u0003\u0000\u0000v\u001a"+
		"\u0001\u0000\u0000\u0000wx\u0005\"\u0000\u0000x\u001c\u0001\u0000\u0000"+
		"\u0000yz\u0005+\u0000\u0000z\u001e\u0001\u0000\u0000\u0000{|\u0005=\u0000"+
		"\u0000| \u0001\u0000\u0000\u0000}~\u0005.\u0000\u0000~\"\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\t\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0006\u0011\u0000\u0000\u0082$\u0001\u0000\u0000\u0000\u000b"+
		"\u0000+9>DIV\\^dl\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
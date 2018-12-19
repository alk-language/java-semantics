// Generated from /home/alex/work/Alk/test/grammar/parts/alg.g4 by ANTLR 4.7.1

    package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class algLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, IF=4, ELSE=5, WHILE=6, DO=7, FOR=8, FORALL=9, 
		IN=10, OUT=11, CHOOSE=12, RETURN=13, SUCCESS=14, FAILURE=15, EMPTYSET=16, 
		EMPTYLIST=17, XOR=18, AT=19, BELONGSTO=20, DELETE=21, EMPTY=22, END=23, 
		FIRST=24, INSERT=25, POPBACK=26, POPFRONT=27, PUSHBACK=28, PUSHFRONT=29, 
		REMOVE=30, REMOVEALLEQTO=31, REMOVEAT=32, SINGLETONSET=33, SIZE=34, TOPBACK=35, 
		TOPFRONT=36, UPDATE=37, RANDOM=38, ARROW=39, UNION=40, INTERSECT=41, SUBSTRACT=42, 
		INT=43, DOUBLE=44, BOOL=45, ID=46, PLUSPLUS=47, MINUSMINUS=48, BITWISE_AND=49, 
		PLUSMOD=50, MINUSMOD=51, PLUSPLUSMOD=52, MINUSMINUSMOD=53, LOWER=54, GREATER=55, 
		LOWEREQ=56, GREATEREQ=57, ISEQUAL=58, NOTEQUAL=59, ASSIGNMENT_OPERATOR=60, 
		MINUS=61, PLUS=62, MUL=63, DIV=64, MOD=65, LPAR=66, RPAR=67, LEFTSHIFT=68, 
		RIGHTSHIFT=69, OR=70, AND=71, NOT=72, SEMICOLON=73, DPOINT=74, VBAR=75, 
		LCB=76, RCB=77, COMMA=78, POINT=79, LBRA=80, RBRA=81, QUOTE=82, QUESTION=83, 
		STRING=84;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LINE_COMMENT", "NONDIGIT", "DIGIT", "NONZERODIGIT", 
		"IF", "ELSE", "WHILE", "DO", "FOR", "FORALL", "IN", "OUT", "CHOOSE", "RETURN", 
		"SUCCESS", "FAILURE", "EMPTYSET", "EMPTYLIST", "XOR", "AT", "BELONGSTO", 
		"DELETE", "EMPTY", "END", "FIRST", "INSERT", "POPBACK", "POPFRONT", "PUSHBACK", 
		"PUSHFRONT", "REMOVE", "REMOVEALLEQTO", "REMOVEAT", "SINGLETONSET", "SIZE", 
		"TOPBACK", "TOPFRONT", "UPDATE", "RANDOM", "ARROW", "UNION", "INTERSECT", 
		"SUBSTRACT", "INT", "DOUBLE", "BOOL", "ID", "PLUSPLUS", "MINUSMINUS", 
		"BITWISE_AND", "PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", "MINUSMINUSMOD", 
		"LOWER", "GREATER", "LOWEREQ", "GREATEREQ", "ISEQUAL", "NOTEQUAL", "ASSIGNMENT_OPERATOR", 
		"MINUS", "PLUS", "MUL", "DIV", "MOD", "LPAR", "RPAR", "LEFTSHIFT", "RIGHTSHIFT", 
		"OR", "AND", "NOT", "SEMICOLON", "DPOINT", "VBAR", "LCB", "RCB", "COMMA", 
		"POINT", "LBRA", "RBRA", "QUOTE", "QUESTION", "STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'if'", "'else'", "'while'", "'do'", "'for'", 
		"'forall'", "'in'", "'out'", "'choose'", "'return'", "'success'", "'failure'", 
		"'emptySet'", "'emptyList'", "'xor'", "'at'", "'belongsTo'", "'delete'", 
		"'empty'", "'end'", "'first'", "'insert'", "'popBack'", "'popFront'", 
		"'pushBack'", "'pushFront'", "'remove'", "'removeAllEqTo'", "'removeAt'", 
		"'singletonSet'", "'size'", "'topBack'", "'topFront'", "'update'", "'random'", 
		"'->'", "'U'", "'^'", "'\\'", null, null, null, null, "'++'", "'--'", 
		"'&'", "'+%'", "'-%'", "'++%'", "'--%'", "'<'", "'>'", "'<='", "'>='", 
		"'=='", "'!='", null, "'-'", "'+'", "'*'", "'/'", "'%'", "'('", "')'", 
		"'<<'", "'>>'", "'||'", "'&&'", "'!'", "';'", "':'", "'|'", "'{'", "'}'", 
		"','", "'.'", "'['", "']'", "'\"'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "IF", "ELSE", "WHILE", "DO", "FOR", 
		"FORALL", "IN", "OUT", "CHOOSE", "RETURN", "SUCCESS", "FAILURE", "EMPTYSET", 
		"EMPTYLIST", "XOR", "AT", "BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", 
		"INSERT", "POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", "REMOVE", "REMOVEALLEQTO", 
		"REMOVEAT", "SINGLETONSET", "SIZE", "TOPBACK", "TOPFRONT", "UPDATE", "RANDOM", 
		"ARROW", "UNION", "INTERSECT", "SUBSTRACT", "INT", "DOUBLE", "BOOL", "ID", 
		"PLUSPLUS", "MINUSMINUS", "BITWISE_AND", "PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", 
		"MINUSMINUSMOD", "LOWER", "GREATER", "LOWEREQ", "GREATEREQ", "ISEQUAL", 
		"NOTEQUAL", "ASSIGNMENT_OPERATOR", "MINUS", "PLUS", "MUL", "DIV", "MOD", 
		"LPAR", "RPAR", "LEFTSHIFT", "RIGHTSHIFT", "OR", "AND", "NOT", "SEMICOLON", 
		"DPOINT", "VBAR", "LCB", "RCB", "COMMA", "POINT", "LBRA", "RBRA", "QUOTE", 
		"QUESTION", "STRING"
	};
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


	public algLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "alg.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2V\u0271\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\3\2\6\2\u00b3\n\2\r\2\16\2\u00b4\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\7\3\u00bd\n\3\f\3\16\3\u00c0\13\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\7\4\u00cb\n\4\f\4\16\4\u00ce\13\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3,"+
		"\3,\3-\3-\3.\3.\3/\6/\u01d8\n/\r/\16/\u01d9\3\60\6\60\u01dd\n\60\r\60"+
		"\16\60\u01de\3\60\3\60\6\60\u01e3\n\60\r\60\16\60\u01e4\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u01f0\n\61\3\62\3\62\3\62\7\62\u01f5"+
		"\n\62\f\62\16\62\u01f8\13\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\38\38\38\38\39\39\39\39\3:\3:\3;\3;\3<\3"+
		"<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0235\n@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3"+
		"F\3F\3G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3M\3M\3N\3N\3O\3"+
		"O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\7X\u026b\nX\f"+
		"X\16X\u026e\13X\3X\3X\3\u00be\2Y\3\3\5\4\7\5\t\2\13\2\r\2\17\6\21\7\23"+
		"\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61"+
		"\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,"+
		"]-_.a/c\60e\61g\62i\63k\64m\65o\66q\67s8u9w:y;{<}=\177>\u0081?\u0083@"+
		"\u0085A\u0087B\u0089C\u008bD\u008dE\u008fF\u0091G\u0093H\u0095I\u0097"+
		"J\u0099K\u009bL\u009dM\u009fN\u00a1O\u00a3P\u00a5Q\u00a7R\u00a9S\u00ab"+
		"T\u00adU\u00afV\3\2\b\5\2\13\f\17\17\"\"\4\2\f\f\17\17\5\2C\\aac|\3\2"+
		"\62;\3\2\63;\5\2\f\f\17\17$$\2\u0280\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{"+
		"\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\3\u00b2\3\2\2"+
		"\2\5\u00b8\3\2\2\2\7\u00c6\3\2\2\2\t\u00d1\3\2\2\2\13\u00d3\3\2\2\2\r"+
		"\u00d5\3\2\2\2\17\u00d7\3\2\2\2\21\u00da\3\2\2\2\23\u00df\3\2\2\2\25\u00e5"+
		"\3\2\2\2\27\u00e8\3\2\2\2\31\u00ec\3\2\2\2\33\u00f3\3\2\2\2\35\u00f6\3"+
		"\2\2\2\37\u00fa\3\2\2\2!\u0101\3\2\2\2#\u0108\3\2\2\2%\u0110\3\2\2\2\'"+
		"\u0118\3\2\2\2)\u0121\3\2\2\2+\u012b\3\2\2\2-\u012f\3\2\2\2/\u0132\3\2"+
		"\2\2\61\u013c\3\2\2\2\63\u0143\3\2\2\2\65\u0149\3\2\2\2\67\u014d\3\2\2"+
		"\29\u0153\3\2\2\2;\u015a\3\2\2\2=\u0162\3\2\2\2?\u016b\3\2\2\2A\u0174"+
		"\3\2\2\2C\u017e\3\2\2\2E\u0185\3\2\2\2G\u0193\3\2\2\2I\u019c\3\2\2\2K"+
		"\u01a9\3\2\2\2M\u01ae\3\2\2\2O\u01b6\3\2\2\2Q\u01bf\3\2\2\2S\u01c6\3\2"+
		"\2\2U\u01cd\3\2\2\2W\u01d0\3\2\2\2Y\u01d2\3\2\2\2[\u01d4\3\2\2\2]\u01d7"+
		"\3\2\2\2_\u01dc\3\2\2\2a\u01ef\3\2\2\2c\u01f1\3\2\2\2e\u01f9\3\2\2\2g"+
		"\u01fc\3\2\2\2i\u01ff\3\2\2\2k\u0201\3\2\2\2m\u0204\3\2\2\2o\u0207\3\2"+
		"\2\2q\u020b\3\2\2\2s\u020f\3\2\2\2u\u0211\3\2\2\2w\u0213\3\2\2\2y\u0216"+
		"\3\2\2\2{\u0219\3\2\2\2}\u021c\3\2\2\2\177\u0234\3\2\2\2\u0081\u0236\3"+
		"\2\2\2\u0083\u0238\3\2\2\2\u0085\u023a\3\2\2\2\u0087\u023c\3\2\2\2\u0089"+
		"\u023e\3\2\2\2\u008b\u0240\3\2\2\2\u008d\u0242\3\2\2\2\u008f\u0244\3\2"+
		"\2\2\u0091\u0247\3\2\2\2\u0093\u024a\3\2\2\2\u0095\u024d\3\2\2\2\u0097"+
		"\u0250\3\2\2\2\u0099\u0252\3\2\2\2\u009b\u0254\3\2\2\2\u009d\u0256\3\2"+
		"\2\2\u009f\u0258\3\2\2\2\u00a1\u025a\3\2\2\2\u00a3\u025c\3\2\2\2\u00a5"+
		"\u025e\3\2\2\2\u00a7\u0260\3\2\2\2\u00a9\u0262\3\2\2\2\u00ab\u0264\3\2"+
		"\2\2\u00ad\u0266\3\2\2\2\u00af\u0268\3\2\2\2\u00b1\u00b3\t\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\2\2\2\u00b7\4\3\2\2\2\u00b8\u00b9"+
		"\7\61\2\2\u00b9\u00ba\7,\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\13\2\2\2"+
		"\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc"+
		"\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7,\2\2\u00c2"+
		"\u00c3\7\61\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\3\2\2\u00c5\6\3\2\2"+
		"\2\u00c6\u00c7\7\61\2\2\u00c7\u00c8\7\61\2\2\u00c8\u00cc\3\2\2\2\u00c9"+
		"\u00cb\n\3\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\b\4\2\2\u00d0\b\3\2\2\2\u00d1\u00d2\t\4\2\2\u00d2\n\3\2\2\2\u00d3"+
		"\u00d4\t\5\2\2\u00d4\f\3\2\2\2\u00d5\u00d6\t\6\2\2\u00d6\16\3\2\2\2\u00d7"+
		"\u00d8\7k\2\2\u00d8\u00d9\7h\2\2\u00d9\20\3\2\2\2\u00da\u00db\7g\2\2\u00db"+
		"\u00dc\7n\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7g\2\2\u00de\22\3\2\2\2\u00df"+
		"\u00e0\7y\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7n\2\2"+
		"\u00e3\u00e4\7g\2\2\u00e4\24\3\2\2\2\u00e5\u00e6\7f\2\2\u00e6\u00e7\7"+
		"q\2\2\u00e7\26\3\2\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb"+
		"\7t\2\2\u00eb\30\3\2\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef"+
		"\7t\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7n\2\2\u00f2"+
		"\32\3\2\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7p\2\2\u00f5\34\3\2\2\2\u00f6"+
		"\u00f7\7q\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7v\2\2\u00f9\36\3\2\2\2\u00fa"+
		"\u00fb\7e\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7q\2\2"+
		"\u00fe\u00ff\7u\2\2\u00ff\u0100\7g\2\2\u0100 \3\2\2\2\u0101\u0102\7t\2"+
		"\2\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2\u0104\u0105\7w\2\2\u0105\u0106"+
		"\7t\2\2\u0106\u0107\7p\2\2\u0107\"\3\2\2\2\u0108\u0109\7u\2\2\u0109\u010a"+
		"\7w\2\2\u010a\u010b\7e\2\2\u010b\u010c\7e\2\2\u010c\u010d\7g\2\2\u010d"+
		"\u010e\7u\2\2\u010e\u010f\7u\2\2\u010f$\3\2\2\2\u0110\u0111\7h\2\2\u0111"+
		"\u0112\7c\2\2\u0112\u0113\7k\2\2\u0113\u0114\7n\2\2\u0114\u0115\7w\2\2"+
		"\u0115\u0116\7t\2\2\u0116\u0117\7g\2\2\u0117&\3\2\2\2\u0118\u0119\7g\2"+
		"\2\u0119\u011a\7o\2\2\u011a\u011b\7r\2\2\u011b\u011c\7v\2\2\u011c\u011d"+
		"\7{\2\2\u011d\u011e\7U\2\2\u011e\u011f\7g\2\2\u011f\u0120\7v\2\2\u0120"+
		"(\3\2\2\2\u0121\u0122\7g\2\2\u0122\u0123\7o\2\2\u0123\u0124\7r\2\2\u0124"+
		"\u0125\7v\2\2\u0125\u0126\7{\2\2\u0126\u0127\7N\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u0129\7u\2\2\u0129\u012a\7v\2\2\u012a*\3\2\2\2\u012b\u012c\7z\2"+
		"\2\u012c\u012d\7q\2\2\u012d\u012e\7t\2\2\u012e,\3\2\2\2\u012f\u0130\7"+
		"c\2\2\u0130\u0131\7v\2\2\u0131.\3\2\2\2\u0132\u0133\7d\2\2\u0133\u0134"+
		"\7g\2\2\u0134\u0135\7n\2\2\u0135\u0136\7q\2\2\u0136\u0137\7p\2\2\u0137"+
		"\u0138\7i\2\2\u0138\u0139\7u\2\2\u0139\u013a\7V\2\2\u013a\u013b\7q\2\2"+
		"\u013b\60\3\2\2\2\u013c\u013d\7f\2\2\u013d\u013e\7g\2\2\u013e\u013f\7"+
		"n\2\2\u013f\u0140\7g\2\2\u0140\u0141\7v\2\2\u0141\u0142\7g\2\2\u0142\62"+
		"\3\2\2\2\u0143\u0144\7g\2\2\u0144\u0145\7o\2\2\u0145\u0146\7r\2\2\u0146"+
		"\u0147\7v\2\2\u0147\u0148\7{\2\2\u0148\64\3\2\2\2\u0149\u014a\7g\2\2\u014a"+
		"\u014b\7p\2\2\u014b\u014c\7f\2\2\u014c\66\3\2\2\2\u014d\u014e\7h\2\2\u014e"+
		"\u014f\7k\2\2\u014f\u0150\7t\2\2\u0150\u0151\7u\2\2\u0151\u0152\7v\2\2"+
		"\u01528\3\2\2\2\u0153\u0154\7k\2\2\u0154\u0155\7p\2\2\u0155\u0156\7u\2"+
		"\2\u0156\u0157\7g\2\2\u0157\u0158\7t\2\2\u0158\u0159\7v\2\2\u0159:\3\2"+
		"\2\2\u015a\u015b\7r\2\2\u015b\u015c\7q\2\2\u015c\u015d\7r\2\2\u015d\u015e"+
		"\7D\2\2\u015e\u015f\7c\2\2\u015f\u0160\7e\2\2\u0160\u0161\7m\2\2\u0161"+
		"<\3\2\2\2\u0162\u0163\7r\2\2\u0163\u0164\7q\2\2\u0164\u0165\7r\2\2\u0165"+
		"\u0166\7H\2\2\u0166\u0167\7t\2\2\u0167\u0168\7q\2\2\u0168\u0169\7p\2\2"+
		"\u0169\u016a\7v\2\2\u016a>\3\2\2\2\u016b\u016c\7r\2\2\u016c\u016d\7w\2"+
		"\2\u016d\u016e\7u\2\2\u016e\u016f\7j\2\2\u016f\u0170\7D\2\2\u0170\u0171"+
		"\7c\2\2\u0171\u0172\7e\2\2\u0172\u0173\7m\2\2\u0173@\3\2\2\2\u0174\u0175"+
		"\7r\2\2\u0175\u0176\7w\2\2\u0176\u0177\7u\2\2\u0177\u0178\7j\2\2\u0178"+
		"\u0179\7H\2\2\u0179\u017a\7t\2\2\u017a\u017b\7q\2\2\u017b\u017c\7p\2\2"+
		"\u017c\u017d\7v\2\2\u017dB\3\2\2\2\u017e\u017f\7t\2\2\u017f\u0180\7g\2"+
		"\2\u0180\u0181\7o\2\2\u0181\u0182\7q\2\2\u0182\u0183\7x\2\2\u0183\u0184"+
		"\7g\2\2\u0184D\3\2\2\2\u0185\u0186\7t\2\2\u0186\u0187\7g\2\2\u0187\u0188"+
		"\7o\2\2\u0188\u0189\7q\2\2\u0189\u018a\7x\2\2\u018a\u018b\7g\2\2\u018b"+
		"\u018c\7C\2\2\u018c\u018d\7n\2\2\u018d\u018e\7n\2\2\u018e\u018f\7G\2\2"+
		"\u018f\u0190\7s\2\2\u0190\u0191\7V\2\2\u0191\u0192\7q\2\2\u0192F\3\2\2"+
		"\2\u0193\u0194\7t\2\2\u0194\u0195\7g\2\2\u0195\u0196\7o\2\2\u0196\u0197"+
		"\7q\2\2\u0197\u0198\7x\2\2\u0198\u0199\7g\2\2\u0199\u019a\7C\2\2\u019a"+
		"\u019b\7v\2\2\u019bH\3\2\2\2\u019c\u019d\7u\2\2\u019d\u019e\7k\2\2\u019e"+
		"\u019f\7p\2\2\u019f\u01a0\7i\2\2\u01a0\u01a1\7n\2\2\u01a1\u01a2\7g\2\2"+
		"\u01a2\u01a3\7v\2\2\u01a3\u01a4\7q\2\2\u01a4\u01a5\7p\2\2\u01a5\u01a6"+
		"\7U\2\2\u01a6\u01a7\7g\2\2\u01a7\u01a8\7v\2\2\u01a8J\3\2\2\2\u01a9\u01aa"+
		"\7u\2\2\u01aa\u01ab\7k\2\2\u01ab\u01ac\7|\2\2\u01ac\u01ad\7g\2\2\u01ad"+
		"L\3\2\2\2\u01ae\u01af\7v\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7r\2\2\u01b1"+
		"\u01b2\7D\2\2\u01b2\u01b3\7c\2\2\u01b3\u01b4\7e\2\2\u01b4\u01b5\7m\2\2"+
		"\u01b5N\3\2\2\2\u01b6\u01b7\7v\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7r\2"+
		"\2\u01b9\u01ba\7H\2\2\u01ba\u01bb\7t\2\2\u01bb\u01bc\7q\2\2\u01bc\u01bd"+
		"\7p\2\2\u01bd\u01be\7v\2\2\u01beP\3\2\2\2\u01bf\u01c0\7w\2\2\u01c0\u01c1"+
		"\7r\2\2\u01c1\u01c2\7f\2\2\u01c2\u01c3\7c\2\2\u01c3\u01c4\7v\2\2\u01c4"+
		"\u01c5\7g\2\2\u01c5R\3\2\2\2\u01c6\u01c7\7t\2\2\u01c7\u01c8\7c\2\2\u01c8"+
		"\u01c9\7p\2\2\u01c9\u01ca\7f\2\2\u01ca\u01cb\7q\2\2\u01cb\u01cc\7o\2\2"+
		"\u01ccT\3\2\2\2\u01cd\u01ce\7/\2\2\u01ce\u01cf\7@\2\2\u01cfV\3\2\2\2\u01d0"+
		"\u01d1\7W\2\2\u01d1X\3\2\2\2\u01d2\u01d3\7`\2\2\u01d3Z\3\2\2\2\u01d4\u01d5"+
		"\7^\2\2\u01d5\\\3\2\2\2\u01d6\u01d8\t\5\2\2\u01d7\u01d6\3\2\2\2\u01d8"+
		"\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da^\3\2\2\2"+
		"\u01db\u01dd\t\5\2\2\u01dc\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01dc"+
		"\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\5\u00a5S"+
		"\2\u01e1\u01e3\t\5\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e2"+
		"\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5`\3\2\2\2\u01e6\u01e7\7v\2\2\u01e7\u01e8"+
		"\7t\2\2\u01e8\u01e9\7w\2\2\u01e9\u01f0\7g\2\2\u01ea\u01eb\7h\2\2\u01eb"+
		"\u01ec\7c\2\2\u01ec\u01ed\7n\2\2\u01ed\u01ee\7u\2\2\u01ee\u01f0\7g\2\2"+
		"\u01ef\u01e6\3\2\2\2\u01ef\u01ea\3\2\2\2\u01f0b\3\2\2\2\u01f1\u01f6\5"+
		"\t\5\2\u01f2\u01f5\5\13\6\2\u01f3\u01f5\5\t\5\2\u01f4\u01f2\3\2\2\2\u01f4"+
		"\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2"+
		"\2\2\u01f7d\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u01fa\7-\2\2\u01fa\u01fb"+
		"\7-\2\2\u01fbf\3\2\2\2\u01fc\u01fd\7/\2\2\u01fd\u01fe\7/\2\2\u01feh\3"+
		"\2\2\2\u01ff\u0200\7(\2\2\u0200j\3\2\2\2\u0201\u0202\7-\2\2\u0202\u0203"+
		"\7\'\2\2\u0203l\3\2\2\2\u0204\u0205\7/\2\2\u0205\u0206\7\'\2\2\u0206n"+
		"\3\2\2\2\u0207\u0208\7-\2\2\u0208\u0209\7-\2\2\u0209\u020a\7\'\2\2\u020a"+
		"p\3\2\2\2\u020b\u020c\7/\2\2\u020c\u020d\7/\2\2\u020d\u020e\7\'\2\2\u020e"+
		"r\3\2\2\2\u020f\u0210\7>\2\2\u0210t\3\2\2\2\u0211\u0212\7@\2\2\u0212v"+
		"\3\2\2\2\u0213\u0214\7>\2\2\u0214\u0215\7?\2\2\u0215x\3\2\2\2\u0216\u0217"+
		"\7@\2\2\u0217\u0218\7?\2\2\u0218z\3\2\2\2\u0219\u021a\7?\2\2\u021a\u021b"+
		"\7?\2\2\u021b|\3\2\2\2\u021c\u021d\7#\2\2\u021d\u021e\7?\2\2\u021e~\3"+
		"\2\2\2\u021f\u0235\7?\2\2\u0220\u0221\7-\2\2\u0221\u0235\7?\2\2\u0222"+
		"\u0223\7/\2\2\u0223\u0235\7?\2\2\u0224\u0225\7,\2\2\u0225\u0235\7?\2\2"+
		"\u0226\u0227\7\61\2\2\u0227\u0235\7?\2\2\u0228\u0229\7\'\2\2\u0229\u0235"+
		"\7?\2\2\u022a\u022b\7>\2\2\u022b\u022c\7>\2\2\u022c\u0235\7?\2\2\u022d"+
		"\u022e\7@\2\2\u022e\u022f\7@\2\2\u022f\u0235\7?\2\2\u0230\u0231\7(\2\2"+
		"\u0231\u0235\7?\2\2\u0232\u0233\7~\2\2\u0233\u0235\7?\2\2\u0234\u021f"+
		"\3\2\2\2\u0234\u0220\3\2\2\2\u0234\u0222\3\2\2\2\u0234\u0224\3\2\2\2\u0234"+
		"\u0226\3\2\2\2\u0234\u0228\3\2\2\2\u0234\u022a\3\2\2\2\u0234\u022d\3\2"+
		"\2\2\u0234\u0230\3\2\2\2\u0234\u0232\3\2\2\2\u0235\u0080\3\2\2\2\u0236"+
		"\u0237\7/\2\2\u0237\u0082\3\2\2\2\u0238\u0239\7-\2\2\u0239\u0084\3\2\2"+
		"\2\u023a\u023b\7,\2\2\u023b\u0086\3\2\2\2\u023c\u023d\7\61\2\2\u023d\u0088"+
		"\3\2\2\2\u023e\u023f\7\'\2\2\u023f\u008a\3\2\2\2\u0240\u0241\7*\2\2\u0241"+
		"\u008c\3\2\2\2\u0242\u0243\7+\2\2\u0243\u008e\3\2\2\2\u0244\u0245\7>\2"+
		"\2\u0245\u0246\7>\2\2\u0246\u0090\3\2\2\2\u0247\u0248\7@\2\2\u0248\u0249"+
		"\7@\2\2\u0249\u0092\3\2\2\2\u024a\u024b\7~\2\2\u024b\u024c\7~\2\2\u024c"+
		"\u0094\3\2\2\2\u024d\u024e\7(\2\2\u024e\u024f\7(\2\2\u024f\u0096\3\2\2"+
		"\2\u0250\u0251\7#\2\2\u0251\u0098\3\2\2\2\u0252\u0253\7=\2\2\u0253\u009a"+
		"\3\2\2\2\u0254\u0255\7<\2\2\u0255\u009c\3\2\2\2\u0256\u0257\7~\2\2\u0257"+
		"\u009e\3\2\2\2\u0258\u0259\7}\2\2\u0259\u00a0\3\2\2\2\u025a\u025b\7\177"+
		"\2\2\u025b\u00a2\3\2\2\2\u025c\u025d\7.\2\2\u025d\u00a4\3\2\2\2\u025e"+
		"\u025f\7\60\2\2\u025f\u00a6\3\2\2\2\u0260\u0261\7]\2\2\u0261\u00a8\3\2"+
		"\2\2\u0262\u0263\7_\2\2\u0263\u00aa\3\2\2\2\u0264\u0265\7$\2\2\u0265\u00ac"+
		"\3\2\2\2\u0266\u0267\7A\2\2\u0267\u00ae\3\2\2\2\u0268\u026c\7$\2\2\u0269"+
		"\u026b\n\7\2\2\u026a\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026a\3\2"+
		"\2\2\u026c\u026d\3\2\2\2\u026d\u026f\3\2\2\2\u026e\u026c\3\2\2\2\u026f"+
		"\u0270\7$\2\2\u0270\u00b0\3\2\2\2\16\2\u00b4\u00be\u00cc\u01d9\u01de\u01e4"+
		"\u01ef\u01f4\u01f6\u0234\u026c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
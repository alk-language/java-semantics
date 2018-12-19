// Generated from /home/alex/work/Alk/script/../src/grammar/parts/alk.g4 by ANTLR 4.7.1

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
public class alkLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, IF=4, ELSE=5, WHILE=6, DO=7, FOR=8, FORALL=9, 
		IN=10, OUT=11, CHOOSE=12, RETURN=13, SUCCESS=14, FAILURE=15, EMPTYSET=16, 
		EMPTYLIST=17, AT=18, BELONGSTO=19, DELETE=20, EMPTY=21, END=22, FIRST=23, 
		INSERT=24, POPBACK=25, POPFRONT=26, PUSHBACK=27, PUSHFRONT=28, REMOVE=29, 
		REMOVEALLEQTO=30, REMOVEAT=31, SINGLETONSET=32, SIZE=33, TOPBACK=34, TOPFRONT=35, 
		UPDATE=36, RANDOM=37, ARROW=38, UNION=39, INTERSECT=40, SUBSTRACT=41, 
		INT=42, DOUBLE=43, BOOL=44, ID=45, PLUSPLUS=46, MINUSMINUS=47, BITWISE_AND=48, 
		PLUSMOD=49, MINUSMOD=50, PLUSPLUSMOD=51, MINUSMINUSMOD=52, LOWER=53, GREATER=54, 
		LOWEREQ=55, GREATEREQ=56, ISEQUAL=57, NOTEQUAL=58, ASSIGNMENT_OPERATOR=59, 
		MINUS=60, PLUS=61, MUL=62, DIV=63, MOD=64, LPAR=65, RPAR=66, LEFTSHIFT=67, 
		RIGHTSHIFT=68, OR=69, AND=70, NOT=71, SEMICOLON=72, DPOINT=73, VBAR=74, 
		LCB=75, RCB=76, COMMA=77, POINT=78, LBRA=79, RBRA=80, QUOTE=81, QUESTION=82, 
		STRING=83;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LINE_COMMENT", "NONDIGIT", "DIGIT", "NONZERODIGIT", 
		"IF", "ELSE", "WHILE", "DO", "FOR", "FORALL", "IN", "OUT", "CHOOSE", "RETURN", 
		"SUCCESS", "FAILURE", "EMPTYSET", "EMPTYLIST", "AT", "BELONGSTO", "DELETE", 
		"EMPTY", "END", "FIRST", "INSERT", "POPBACK", "POPFRONT", "PUSHBACK", 
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
		"'emptySet'", "'emptyList'", "'at'", "'belongsTo'", "'delete'", "'empty'", 
		"'end'", "'first'", "'insert'", "'popBack'", "'popFront'", "'pushBack'", 
		"'pushFront'", "'remove'", "'removeAllEqTo'", "'removeAt'", "'singletonSet'", 
		"'size'", "'topBack'", "'topFront'", "'update'", "'random'", "'->'", "'U'", 
		"'^'", "'\\'", null, null, null, null, "'++'", "'--'", "'&'", "'+%'", 
		"'-%'", "'++%'", "'--%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
		null, "'-'", "'+'", "'*'", "'/'", "'%'", "'('", "')'", "'<<'", "'>>'", 
		"'||'", "'&&'", "'!'", "';'", "':'", "'|'", "'{'", "'}'", "','", "'.'", 
		"'['", "']'", "'\"'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "IF", "ELSE", "WHILE", "DO", "FOR", 
		"FORALL", "IN", "OUT", "CHOOSE", "RETURN", "SUCCESS", "FAILURE", "EMPTYSET", 
		"EMPTYLIST", "AT", "BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", "INSERT", 
		"POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", "REMOVE", "REMOVEALLEQTO", 
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


	public alkLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "alk.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2U\u026b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\6\2\u00b1\n\2\r\2\16\2\u00b2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\7\3\u00bb\n\3\f\3\16\3\u00be\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\7\4\u00c9\n\4\f\4\16\4\u00cc\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\6.\u01d2\n.\r.\16.\u01d3\3/\6/\u01d7\n/\r/\16/\u01d8"+
		"\3/\3/\6/\u01dd\n/\r/\16/\u01de\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\5\60\u01ea\n\60\3\61\3\61\3\61\7\61\u01ef\n\61\f\61\16\61\u01f2"+
		"\13\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\38\38\38\38\39\39\3:\3:\3;\3;\3;\3<\3<\3<\3"+
		"=\3=\3=\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\5?\u022f\n?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3"+
		"G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3"+
		"Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\7W\u0265\nW\fW\16W\u0268\13W"+
		"\3W\3W\3\u00bc\2X\3\3\5\4\7\5\t\2\13\2\r\2\17\6\21\7\23\b\25\t\27\n\31"+
		"\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31"+
		"\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/c\60e\61g"+
		"\62i\63k\64m\65o\66q\67s8u9w:y;{<}=\177>\u0081?\u0083@\u0085A\u0087B\u0089"+
		"C\u008bD\u008dE\u008fF\u0091G\u0093H\u0095I\u0097J\u0099K\u009bL\u009d"+
		"M\u009fN\u00a1O\u00a3P\u00a5Q\u00a7R\u00a9S\u00abT\u00adU\3\2\b\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\5\2C\\aac|\3\2\62;\3\2\63;\5\2\f\f\17\17$$"+
		"\2\u027a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2"+
		"\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\3\u00b0\3\2\2\2\5\u00b6\3\2\2\2\7\u00c4\3\2\2\2\t\u00cf"+
		"\3\2\2\2\13\u00d1\3\2\2\2\r\u00d3\3\2\2\2\17\u00d5\3\2\2\2\21\u00d8\3"+
		"\2\2\2\23\u00dd\3\2\2\2\25\u00e3\3\2\2\2\27\u00e6\3\2\2\2\31\u00ea\3\2"+
		"\2\2\33\u00f1\3\2\2\2\35\u00f4\3\2\2\2\37\u00f8\3\2\2\2!\u00ff\3\2\2\2"+
		"#\u0106\3\2\2\2%\u010e\3\2\2\2\'\u0116\3\2\2\2)\u011f\3\2\2\2+\u0129\3"+
		"\2\2\2-\u012c\3\2\2\2/\u0136\3\2\2\2\61\u013d\3\2\2\2\63\u0143\3\2\2\2"+
		"\65\u0147\3\2\2\2\67\u014d\3\2\2\29\u0154\3\2\2\2;\u015c\3\2\2\2=\u0165"+
		"\3\2\2\2?\u016e\3\2\2\2A\u0178\3\2\2\2C\u017f\3\2\2\2E\u018d\3\2\2\2G"+
		"\u0196\3\2\2\2I\u01a3\3\2\2\2K\u01a8\3\2\2\2M\u01b0\3\2\2\2O\u01b9\3\2"+
		"\2\2Q\u01c0\3\2\2\2S\u01c7\3\2\2\2U\u01ca\3\2\2\2W\u01cc\3\2\2\2Y\u01ce"+
		"\3\2\2\2[\u01d1\3\2\2\2]\u01d6\3\2\2\2_\u01e9\3\2\2\2a\u01eb\3\2\2\2c"+
		"\u01f3\3\2\2\2e\u01f6\3\2\2\2g\u01f9\3\2\2\2i\u01fb\3\2\2\2k\u01fe\3\2"+
		"\2\2m\u0201\3\2\2\2o\u0205\3\2\2\2q\u0209\3\2\2\2s\u020b\3\2\2\2u\u020d"+
		"\3\2\2\2w\u0210\3\2\2\2y\u0213\3\2\2\2{\u0216\3\2\2\2}\u022e\3\2\2\2\177"+
		"\u0230\3\2\2\2\u0081\u0232\3\2\2\2\u0083\u0234\3\2\2\2\u0085\u0236\3\2"+
		"\2\2\u0087\u0238\3\2\2\2\u0089\u023a\3\2\2\2\u008b\u023c\3\2\2\2\u008d"+
		"\u023e\3\2\2\2\u008f\u0241\3\2\2\2\u0091\u0244\3\2\2\2\u0093\u0247\3\2"+
		"\2\2\u0095\u024a\3\2\2\2\u0097\u024c\3\2\2\2\u0099\u024e\3\2\2\2\u009b"+
		"\u0250\3\2\2\2\u009d\u0252\3\2\2\2\u009f\u0254\3\2\2\2\u00a1\u0256\3\2"+
		"\2\2\u00a3\u0258\3\2\2\2\u00a5\u025a\3\2\2\2\u00a7\u025c\3\2\2\2\u00a9"+
		"\u025e\3\2\2\2\u00ab\u0260\3\2\2\2\u00ad\u0262\3\2\2\2\u00af\u00b1\t\2"+
		"\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\2\2\2\u00b5\4\3\2\2\2"+
		"\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7,\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb"+
		"\13\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00bd\3\2\2\2"+
		"\u00bc\u00ba\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0"+
		"\7,\2\2\u00c0\u00c1\7\61\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\3\2\2\u00c3"+
		"\6\3\2\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c6\7\61\2\2\u00c6\u00ca\3\2\2"+
		"\2\u00c7\u00c9\n\3\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00ce\b\4\2\2\u00ce\b\3\2\2\2\u00cf\u00d0\t\4\2\2\u00d0\n\3\2\2\2\u00d1"+
		"\u00d2\t\5\2\2\u00d2\f\3\2\2\2\u00d3\u00d4\t\6\2\2\u00d4\16\3\2\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7h\2\2\u00d7\20\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\u00da\7n\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7g\2\2\u00dc\22\3\2\2\2\u00dd"+
		"\u00de\7y\2\2\u00de\u00df\7j\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7n\2\2"+
		"\u00e1\u00e2\7g\2\2\u00e2\24\3\2\2\2\u00e3\u00e4\7f\2\2\u00e4\u00e5\7"+
		"q\2\2\u00e5\26\3\2\2\2\u00e6\u00e7\7h\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9"+
		"\7t\2\2\u00e9\30\3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed"+
		"\7t\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0\7n\2\2\u00f0"+
		"\32\3\2\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\34\3\2\2\2\u00f4"+
		"\u00f5\7q\2\2\u00f5\u00f6\7w\2\2\u00f6\u00f7\7v\2\2\u00f7\36\3\2\2\2\u00f8"+
		"\u00f9\7e\2\2\u00f9\u00fa\7j\2\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7q\2\2"+
		"\u00fc\u00fd\7u\2\2\u00fd\u00fe\7g\2\2\u00fe \3\2\2\2\u00ff\u0100\7t\2"+
		"\2\u0100\u0101\7g\2\2\u0101\u0102\7v\2\2\u0102\u0103\7w\2\2\u0103\u0104"+
		"\7t\2\2\u0104\u0105\7p\2\2\u0105\"\3\2\2\2\u0106\u0107\7u\2\2\u0107\u0108"+
		"\7w\2\2\u0108\u0109\7e\2\2\u0109\u010a\7e\2\2\u010a\u010b\7g\2\2\u010b"+
		"\u010c\7u\2\2\u010c\u010d\7u\2\2\u010d$\3\2\2\2\u010e\u010f\7h\2\2\u010f"+
		"\u0110\7c\2\2\u0110\u0111\7k\2\2\u0111\u0112\7n\2\2\u0112\u0113\7w\2\2"+
		"\u0113\u0114\7t\2\2\u0114\u0115\7g\2\2\u0115&\3\2\2\2\u0116\u0117\7g\2"+
		"\2\u0117\u0118\7o\2\2\u0118\u0119\7r\2\2\u0119\u011a\7v\2\2\u011a\u011b"+
		"\7{\2\2\u011b\u011c\7U\2\2\u011c\u011d\7g\2\2\u011d\u011e\7v\2\2\u011e"+
		"(\3\2\2\2\u011f\u0120\7g\2\2\u0120\u0121\7o\2\2\u0121\u0122\7r\2\2\u0122"+
		"\u0123\7v\2\2\u0123\u0124\7{\2\2\u0124\u0125\7N\2\2\u0125\u0126\7k\2\2"+
		"\u0126\u0127\7u\2\2\u0127\u0128\7v\2\2\u0128*\3\2\2\2\u0129\u012a\7c\2"+
		"\2\u012a\u012b\7v\2\2\u012b,\3\2\2\2\u012c\u012d\7d\2\2\u012d\u012e\7"+
		"g\2\2\u012e\u012f\7n\2\2\u012f\u0130\7q\2\2\u0130\u0131\7p\2\2\u0131\u0132"+
		"\7i\2\2\u0132\u0133\7u\2\2\u0133\u0134\7V\2\2\u0134\u0135\7q\2\2\u0135"+
		".\3\2\2\2\u0136\u0137\7f\2\2\u0137\u0138\7g\2\2\u0138\u0139\7n\2\2\u0139"+
		"\u013a\7g\2\2\u013a\u013b\7v\2\2\u013b\u013c\7g\2\2\u013c\60\3\2\2\2\u013d"+
		"\u013e\7g\2\2\u013e\u013f\7o\2\2\u013f\u0140\7r\2\2\u0140\u0141\7v\2\2"+
		"\u0141\u0142\7{\2\2\u0142\62\3\2\2\2\u0143\u0144\7g\2\2\u0144\u0145\7"+
		"p\2\2\u0145\u0146\7f\2\2\u0146\64\3\2\2\2\u0147\u0148\7h\2\2\u0148\u0149"+
		"\7k\2\2\u0149\u014a\7t\2\2\u014a\u014b\7u\2\2\u014b\u014c\7v\2\2\u014c"+
		"\66\3\2\2\2\u014d\u014e\7k\2\2\u014e\u014f\7p\2\2\u014f\u0150\7u\2\2\u0150"+
		"\u0151\7g\2\2\u0151\u0152\7t\2\2\u0152\u0153\7v\2\2\u01538\3\2\2\2\u0154"+
		"\u0155\7r\2\2\u0155\u0156\7q\2\2\u0156\u0157\7r\2\2\u0157\u0158\7D\2\2"+
		"\u0158\u0159\7c\2\2\u0159\u015a\7e\2\2\u015a\u015b\7m\2\2\u015b:\3\2\2"+
		"\2\u015c\u015d\7r\2\2\u015d\u015e\7q\2\2\u015e\u015f\7r\2\2\u015f\u0160"+
		"\7H\2\2\u0160\u0161\7t\2\2\u0161\u0162\7q\2\2\u0162\u0163\7p\2\2\u0163"+
		"\u0164\7v\2\2\u0164<\3\2\2\2\u0165\u0166\7r\2\2\u0166\u0167\7w\2\2\u0167"+
		"\u0168\7u\2\2\u0168\u0169\7j\2\2\u0169\u016a\7D\2\2\u016a\u016b\7c\2\2"+
		"\u016b\u016c\7e\2\2\u016c\u016d\7m\2\2\u016d>\3\2\2\2\u016e\u016f\7r\2"+
		"\2\u016f\u0170\7w\2\2\u0170\u0171\7u\2\2\u0171\u0172\7j\2\2\u0172\u0173"+
		"\7H\2\2\u0173\u0174\7t\2\2\u0174\u0175\7q\2\2\u0175\u0176\7p\2\2\u0176"+
		"\u0177\7v\2\2\u0177@\3\2\2\2\u0178\u0179\7t\2\2\u0179\u017a\7g\2\2\u017a"+
		"\u017b\7o\2\2\u017b\u017c\7q\2\2\u017c\u017d\7x\2\2\u017d\u017e\7g\2\2"+
		"\u017eB\3\2\2\2\u017f\u0180\7t\2\2\u0180\u0181\7g\2\2\u0181\u0182\7o\2"+
		"\2\u0182\u0183\7q\2\2\u0183\u0184\7x\2\2\u0184\u0185\7g\2\2\u0185\u0186"+
		"\7C\2\2\u0186\u0187\7n\2\2\u0187\u0188\7n\2\2\u0188\u0189\7G\2\2\u0189"+
		"\u018a\7s\2\2\u018a\u018b\7V\2\2\u018b\u018c\7q\2\2\u018cD\3\2\2\2\u018d"+
		"\u018e\7t\2\2\u018e\u018f\7g\2\2\u018f\u0190\7o\2\2\u0190\u0191\7q\2\2"+
		"\u0191\u0192\7x\2\2\u0192\u0193\7g\2\2\u0193\u0194\7C\2\2\u0194\u0195"+
		"\7v\2\2\u0195F\3\2\2\2\u0196\u0197\7u\2\2\u0197\u0198\7k\2\2\u0198\u0199"+
		"\7p\2\2\u0199\u019a\7i\2\2\u019a\u019b\7n\2\2\u019b\u019c\7g\2\2\u019c"+
		"\u019d\7v\2\2\u019d\u019e\7q\2\2\u019e\u019f\7p\2\2\u019f\u01a0\7U\2\2"+
		"\u01a0\u01a1\7g\2\2\u01a1\u01a2\7v\2\2\u01a2H\3\2\2\2\u01a3\u01a4\7u\2"+
		"\2\u01a4\u01a5\7k\2\2\u01a5\u01a6\7|\2\2\u01a6\u01a7\7g\2\2\u01a7J\3\2"+
		"\2\2\u01a8\u01a9\7v\2\2\u01a9\u01aa\7q\2\2\u01aa\u01ab\7r\2\2\u01ab\u01ac"+
		"\7D\2\2\u01ac\u01ad\7c\2\2\u01ad\u01ae\7e\2\2\u01ae\u01af\7m\2\2\u01af"+
		"L\3\2\2\2\u01b0\u01b1\7v\2\2\u01b1\u01b2\7q\2\2\u01b2\u01b3\7r\2\2\u01b3"+
		"\u01b4\7H\2\2\u01b4\u01b5\7t\2\2\u01b5\u01b6\7q\2\2\u01b6\u01b7\7p\2\2"+
		"\u01b7\u01b8\7v\2\2\u01b8N\3\2\2\2\u01b9\u01ba\7w\2\2\u01ba\u01bb\7r\2"+
		"\2\u01bb\u01bc\7f\2\2\u01bc\u01bd\7c\2\2\u01bd\u01be\7v\2\2\u01be\u01bf"+
		"\7g\2\2\u01bfP\3\2\2\2\u01c0\u01c1\7t\2\2\u01c1\u01c2\7c\2\2\u01c2\u01c3"+
		"\7p\2\2\u01c3\u01c4\7f\2\2\u01c4\u01c5\7q\2\2\u01c5\u01c6\7o\2\2\u01c6"+
		"R\3\2\2\2\u01c7\u01c8\7/\2\2\u01c8\u01c9\7@\2\2\u01c9T\3\2\2\2\u01ca\u01cb"+
		"\7W\2\2\u01cbV\3\2\2\2\u01cc\u01cd\7`\2\2\u01cdX\3\2\2\2\u01ce\u01cf\7"+
		"^\2\2\u01cfZ\3\2\2\2\u01d0\u01d2\t\5\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3"+
		"\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\\\3\2\2\2\u01d5"+
		"\u01d7\t\5\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\5\u00a3R\2\u01db"+
		"\u01dd\t\5\2\2\u01dc\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01df^\3\2\2\2\u01e0\u01e1\7v\2\2\u01e1\u01e2"+
		"\7t\2\2\u01e2\u01e3\7w\2\2\u01e3\u01ea\7g\2\2\u01e4\u01e5\7h\2\2\u01e5"+
		"\u01e6\7c\2\2\u01e6\u01e7\7n\2\2\u01e7\u01e8\7u\2\2\u01e8\u01ea\7g\2\2"+
		"\u01e9\u01e0\3\2\2\2\u01e9\u01e4\3\2\2\2\u01ea`\3\2\2\2\u01eb\u01f0\5"+
		"\t\5\2\u01ec\u01ef\5\13\6\2\u01ed\u01ef\5\t\5\2\u01ee\u01ec\3\2\2\2\u01ee"+
		"\u01ed\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2"+
		"\2\2\u01f1b\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f4\7-\2\2\u01f4\u01f5"+
		"\7-\2\2\u01f5d\3\2\2\2\u01f6\u01f7\7/\2\2\u01f7\u01f8\7/\2\2\u01f8f\3"+
		"\2\2\2\u01f9\u01fa\7(\2\2\u01fah\3\2\2\2\u01fb\u01fc\7-\2\2\u01fc\u01fd"+
		"\7\'\2\2\u01fdj\3\2\2\2\u01fe\u01ff\7/\2\2\u01ff\u0200\7\'\2\2\u0200l"+
		"\3\2\2\2\u0201\u0202\7-\2\2\u0202\u0203\7-\2\2\u0203\u0204\7\'\2\2\u0204"+
		"n\3\2\2\2\u0205\u0206\7/\2\2\u0206\u0207\7/\2\2\u0207\u0208\7\'\2\2\u0208"+
		"p\3\2\2\2\u0209\u020a\7>\2\2\u020ar\3\2\2\2\u020b\u020c\7@\2\2\u020ct"+
		"\3\2\2\2\u020d\u020e\7>\2\2\u020e\u020f\7?\2\2\u020fv\3\2\2\2\u0210\u0211"+
		"\7@\2\2\u0211\u0212\7?\2\2\u0212x\3\2\2\2\u0213\u0214\7?\2\2\u0214\u0215"+
		"\7?\2\2\u0215z\3\2\2\2\u0216\u0217\7#\2\2\u0217\u0218\7?\2\2\u0218|\3"+
		"\2\2\2\u0219\u022f\7?\2\2\u021a\u021b\7-\2\2\u021b\u022f\7?\2\2\u021c"+
		"\u021d\7/\2\2\u021d\u022f\7?\2\2\u021e\u021f\7,\2\2\u021f\u022f\7?\2\2"+
		"\u0220\u0221\7\61\2\2\u0221\u022f\7?\2\2\u0222\u0223\7\'\2\2\u0223\u022f"+
		"\7?\2\2\u0224\u0225\7>\2\2\u0225\u0226\7>\2\2\u0226\u022f\7?\2\2\u0227"+
		"\u0228\7@\2\2\u0228\u0229\7@\2\2\u0229\u022f\7?\2\2\u022a\u022b\7(\2\2"+
		"\u022b\u022f\7?\2\2\u022c\u022d\7~\2\2\u022d\u022f\7?\2\2\u022e\u0219"+
		"\3\2\2\2\u022e\u021a\3\2\2\2\u022e\u021c\3\2\2\2\u022e\u021e\3\2\2\2\u022e"+
		"\u0220\3\2\2\2\u022e\u0222\3\2\2\2\u022e\u0224\3\2\2\2\u022e\u0227\3\2"+
		"\2\2\u022e\u022a\3\2\2\2\u022e\u022c\3\2\2\2\u022f~\3\2\2\2\u0230\u0231"+
		"\7/\2\2\u0231\u0080\3\2\2\2\u0232\u0233\7-\2\2\u0233\u0082\3\2\2\2\u0234"+
		"\u0235\7,\2\2\u0235\u0084\3\2\2\2\u0236\u0237\7\61\2\2\u0237\u0086\3\2"+
		"\2\2\u0238\u0239\7\'\2\2\u0239\u0088\3\2\2\2\u023a\u023b\7*\2\2\u023b"+
		"\u008a\3\2\2\2\u023c\u023d\7+\2\2\u023d\u008c\3\2\2\2\u023e\u023f\7>\2"+
		"\2\u023f\u0240\7>\2\2\u0240\u008e\3\2\2\2\u0241\u0242\7@\2\2\u0242\u0243"+
		"\7@\2\2\u0243\u0090\3\2\2\2\u0244\u0245\7~\2\2\u0245\u0246\7~\2\2\u0246"+
		"\u0092\3\2\2\2\u0247\u0248\7(\2\2\u0248\u0249\7(\2\2\u0249\u0094\3\2\2"+
		"\2\u024a\u024b\7#\2\2\u024b\u0096\3\2\2\2\u024c\u024d\7=\2\2\u024d\u0098"+
		"\3\2\2\2\u024e\u024f\7<\2\2\u024f\u009a\3\2\2\2\u0250\u0251\7~\2\2\u0251"+
		"\u009c\3\2\2\2\u0252\u0253\7}\2\2\u0253\u009e\3\2\2\2\u0254\u0255\7\177"+
		"\2\2\u0255\u00a0\3\2\2\2\u0256\u0257\7.\2\2\u0257\u00a2\3\2\2\2\u0258"+
		"\u0259\7\60\2\2\u0259\u00a4\3\2\2\2\u025a\u025b\7]\2\2\u025b\u00a6\3\2"+
		"\2\2\u025c\u025d\7_\2\2\u025d\u00a8\3\2\2\2\u025e\u025f\7$\2\2\u025f\u00aa"+
		"\3\2\2\2\u0260\u0261\7A\2\2\u0261\u00ac\3\2\2\2\u0262\u0266\7$\2\2\u0263"+
		"\u0265\n\7\2\2\u0264\u0263\3\2\2\2\u0265\u0268\3\2\2\2\u0266\u0264\3\2"+
		"\2\2\u0266\u0267\3\2\2\2\u0267\u0269\3\2\2\2\u0268\u0266\3\2\2\2\u0269"+
		"\u026a\7$\2\2\u026a\u00ae\3\2\2\2\16\2\u00b2\u00bc\u00ca\u01d3\u01d8\u01de"+
		"\u01e9\u01ee\u01f0\u022e\u0266\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
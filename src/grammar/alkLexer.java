// Generated from /home/alex/work/java-semantics/script/../src/grammar/parts/alk.g4 by ANTLR 4.7.1

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
		WS=1, COMMENT=2, LINE_COMMENT=3, TO=4, IF=5, ELSE=6, WHILE=7, DO=8, FOR=9, 
		FORALL=10, IN=11, OUT=12, CHOOSE=13, RETURN=14, SUCCESS=15, FAILURE=16, 
		EMPTYSET=17, EMPTYLIST=18, MODIFIES=19, XOR=20, AT=21, BELONGSTO=22, DELETE=23, 
		EMPTY=24, END=25, FIRST=26, INSERT=27, PRINT=28, POPBACK=29, POPFRONT=30, 
		PUSHBACK=31, PUSHFRONT=32, REMOVE=33, REMOVEALLEQTO=34, REMOVEAT=35, SINGLETONSET=36, 
		SIZE=37, TOPBACK=38, TOPFRONT=39, UPDATE=40, RANDOM=41, ARROW=42, UNION=43, 
		INTERSECT=44, SUBTRACT=45, INT=46, DOUBLE=47, BOOL=48, ID=49, PLUSPLUS=50, 
		MINUSMINUS=51, BITWISE_AND=52, PLUSMOD=53, MINUSMOD=54, PLUSPLUSMOD=55, 
		MINUSMINUSMOD=56, LOWER=57, GREATER=58, LOWEREQ=59, GREATEREQ=60, ISEQUAL=61, 
		NOTEQUAL=62, ASSIGNMENT_OPERATOR=63, MINUS=64, PLUS=65, MUL=66, DIV=67, 
		MOD=68, LPAR=69, RPAR=70, LEFTSHIFT=71, RIGHTSHIFT=72, OR=73, AND=74, 
		NOT=75, SEMICOLON=76, DPOINT=77, VBAR=78, LCB=79, RCB=80, COMMA=81, POINT=82, 
		LBRA=83, RBRA=84, QUOTE=85, QUESTION=86, STRING=87;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LINE_COMMENT", "NONDIGIT", "DIGIT", "NONZERODIGIT", 
		"TO", "IF", "ELSE", "WHILE", "DO", "FOR", "FORALL", "IN", "OUT", "CHOOSE", 
		"RETURN", "SUCCESS", "FAILURE", "EMPTYSET", "EMPTYLIST", "MODIFIES", "XOR", 
		"AT", "BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", "INSERT", "PRINT", 
		"POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", "REMOVE", "REMOVEALLEQTO", 
		"REMOVEAT", "SINGLETONSET", "SIZE", "TOPBACK", "TOPFRONT", "UPDATE", "RANDOM", 
		"ARROW", "UNION", "INTERSECT", "SUBTRACT", "INT", "DOUBLE", "BOOL", "ID", 
		"PLUSPLUS", "MINUSMINUS", "BITWISE_AND", "PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", 
		"MINUSMINUSMOD", "LOWER", "GREATER", "LOWEREQ", "GREATEREQ", "ISEQUAL", 
		"NOTEQUAL", "ASSIGNMENT_OPERATOR", "MINUS", "PLUS", "MUL", "DIV", "MOD", 
		"LPAR", "RPAR", "LEFTSHIFT", "RIGHTSHIFT", "OR", "AND", "NOT", "SEMICOLON", 
		"DPOINT", "VBAR", "LCB", "RCB", "COMMA", "POINT", "LBRA", "RBRA", "QUOTE", 
		"QUESTION", "STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'|->'", "'if'", "'else'", "'while'", "'do'", 
		"'for'", "'forall'", "'in'", "'out'", "'choose'", "'return'", "'success'", 
		"'failure'", "'emptySet'", "'emptyList'", "'modifies'", "'xor'", "'at'", 
		"'belongsTo'", "'delete'", "'empty'", "'end'", "'first'", "'insert'", 
		"'print'", "'popBack'", "'popFront'", "'pushBack'", "'pushFront'", "'remove'", 
		"'removeAllEqTo'", "'removeAt'", "'singletonSet'", "'size'", "'topBack'", 
		"'topFront'", "'update'", "'random'", "'->'", "'U'", "'^'", "'\\'", null, 
		null, null, null, "'++'", "'--'", "'&'", "'+%'", "'-%'", "'++%'", "'--%'", 
		"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", null, "'-'", "'+'", "'*'", 
		"'/'", "'%'", "'('", "')'", "'<<'", "'>>'", "'||'", "'&&'", "'!'", "';'", 
		"':'", "'|'", "'{'", "'}'", "','", "'.'", "'['", "']'", "'\"'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "TO", "IF", "ELSE", "WHILE", "DO", 
		"FOR", "FORALL", "IN", "OUT", "CHOOSE", "RETURN", "SUCCESS", "FAILURE", 
		"EMPTYSET", "EMPTYLIST", "MODIFIES", "XOR", "AT", "BELONGSTO", "DELETE", 
		"EMPTY", "END", "FIRST", "INSERT", "PRINT", "POPBACK", "POPFRONT", "PUSHBACK", 
		"PUSHFRONT", "REMOVE", "REMOVEALLEQTO", "REMOVEAT", "SINGLETONSET", "SIZE", 
		"TOPBACK", "TOPFRONT", "UPDATE", "RANDOM", "ARROW", "UNION", "INTERSECT", 
		"SUBTRACT", "INT", "DOUBLE", "BOOL", "ID", "PLUSPLUS", "MINUSMINUS", "BITWISE_AND", 
		"PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", "MINUSMINUSMOD", "LOWER", "GREATER", 
		"LOWEREQ", "GREATEREQ", "ISEQUAL", "NOTEQUAL", "ASSIGNMENT_OPERATOR", 
		"MINUS", "PLUS", "MUL", "DIV", "MOD", "LPAR", "RPAR", "LEFTSHIFT", "RIGHTSHIFT", 
		"OR", "AND", "NOT", "SEMICOLON", "DPOINT", "VBAR", "LCB", "RCB", "COMMA", 
		"POINT", "LBRA", "RBRA", "QUOTE", "QUESTION", "STRING"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2Y\u028a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\6\2\u00b9\n\2\r\2\16\2"+
		"\u00ba\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00c3\n\3\f\3\16\3\u00c6\13\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u00d1\n\4\f\4\16\4\u00d4\13\4\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\6\62\u01f1\n\62\r\62\16\62\u01f2\3"+
		"\63\6\63\u01f6\n\63\r\63\16\63\u01f7\3\63\3\63\6\63\u01fc\n\63\r\63\16"+
		"\63\u01fd\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0209\n\64"+
		"\3\65\3\65\3\65\7\65\u020e\n\65\f\65\16\65\u0211\13\65\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3=\3="+
		"\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C"+
		"\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u024e\nC\3D\3D\3E\3E\3F\3F\3G"+
		"\3G\3H\3H\3I\3I\3J\3J\3K\3K\3K\3L\3L\3L\3M\3M\3M\3N\3N\3N\3O\3O\3P\3P"+
		"\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\7["+
		"\u0284\n[\f[\16[\u0287\13[\3[\3[\3\u00c4\2\\\3\3\5\4\7\5\t\2\13\2\r\2"+
		"\17\6\21\7\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+"+
		"\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O"+
		"&Q\'S(U)W*Y+[,]-_.a/c\60e\61g\62i\63k\64m\65o\66q\67s8u9w:y;{<}=\177>"+
		"\u0081?\u0083@\u0085A\u0087B\u0089C\u008bD\u008dE\u008fF\u0091G\u0093"+
		"H\u0095I\u0097J\u0099K\u009bL\u009dM\u009fN\u00a1O\u00a3P\u00a5Q\u00a7"+
		"R\u00a9S\u00abT\u00adU\u00afV\u00b1W\u00b3X\u00b5Y\3\2\b\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\5\2C\\aac|\3\2\62;\3\2\63;\5\2\f\f\17\17$$\2\u0299"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2"+
		"\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad"+
		"\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2"+
		"\2\3\u00b8\3\2\2\2\5\u00be\3\2\2\2\7\u00cc\3\2\2\2\t\u00d7\3\2\2\2\13"+
		"\u00d9\3\2\2\2\r\u00db\3\2\2\2\17\u00dd\3\2\2\2\21\u00e1\3\2\2\2\23\u00e4"+
		"\3\2\2\2\25\u00e9\3\2\2\2\27\u00ef\3\2\2\2\31\u00f2\3\2\2\2\33\u00f6\3"+
		"\2\2\2\35\u00fd\3\2\2\2\37\u0100\3\2\2\2!\u0104\3\2\2\2#\u010b\3\2\2\2"+
		"%\u0112\3\2\2\2\'\u011a\3\2\2\2)\u0122\3\2\2\2+\u012b\3\2\2\2-\u0135\3"+
		"\2\2\2/\u013e\3\2\2\2\61\u0142\3\2\2\2\63\u0145\3\2\2\2\65\u014f\3\2\2"+
		"\2\67\u0156\3\2\2\29\u015c\3\2\2\2;\u0160\3\2\2\2=\u0166\3\2\2\2?\u016d"+
		"\3\2\2\2A\u0173\3\2\2\2C\u017b\3\2\2\2E\u0184\3\2\2\2G\u018d\3\2\2\2I"+
		"\u0197\3\2\2\2K\u019e\3\2\2\2M\u01ac\3\2\2\2O\u01b5\3\2\2\2Q\u01c2\3\2"+
		"\2\2S\u01c7\3\2\2\2U\u01cf\3\2\2\2W\u01d8\3\2\2\2Y\u01df\3\2\2\2[\u01e6"+
		"\3\2\2\2]\u01e9\3\2\2\2_\u01eb\3\2\2\2a\u01ed\3\2\2\2c\u01f0\3\2\2\2e"+
		"\u01f5\3\2\2\2g\u0208\3\2\2\2i\u020a\3\2\2\2k\u0212\3\2\2\2m\u0215\3\2"+
		"\2\2o\u0218\3\2\2\2q\u021a\3\2\2\2s\u021d\3\2\2\2u\u0220\3\2\2\2w\u0224"+
		"\3\2\2\2y\u0228\3\2\2\2{\u022a\3\2\2\2}\u022c\3\2\2\2\177\u022f\3\2\2"+
		"\2\u0081\u0232\3\2\2\2\u0083\u0235\3\2\2\2\u0085\u024d\3\2\2\2\u0087\u024f"+
		"\3\2\2\2\u0089\u0251\3\2\2\2\u008b\u0253\3\2\2\2\u008d\u0255\3\2\2\2\u008f"+
		"\u0257\3\2\2\2\u0091\u0259\3\2\2\2\u0093\u025b\3\2\2\2\u0095\u025d\3\2"+
		"\2\2\u0097\u0260\3\2\2\2\u0099\u0263\3\2\2\2\u009b\u0266\3\2\2\2\u009d"+
		"\u0269\3\2\2\2\u009f\u026b\3\2\2\2\u00a1\u026d\3\2\2\2\u00a3\u026f\3\2"+
		"\2\2\u00a5\u0271\3\2\2\2\u00a7\u0273\3\2\2\2\u00a9\u0275\3\2\2\2\u00ab"+
		"\u0277\3\2\2\2\u00ad\u0279\3\2\2\2\u00af\u027b\3\2\2\2\u00b1\u027d\3\2"+
		"\2\2\u00b3\u027f\3\2\2\2\u00b5\u0281\3\2\2\2\u00b7\u00b9\t\2\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\b\2\2\2\u00bd\4\3\2\2\2\u00be\u00bf"+
		"\7\61\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c4\3\2\2\2\u00c1\u00c3\13\2\2\2"+
		"\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7,\2\2\u00c8"+
		"\u00c9\7\61\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\3\2\2\u00cb\6\3\2\2"+
		"\2\u00cc\u00cd\7\61\2\2\u00cd\u00ce\7\61\2\2\u00ce\u00d2\3\2\2\2\u00cf"+
		"\u00d1\n\3\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d6\b\4\2\2\u00d6\b\3\2\2\2\u00d7\u00d8\t\4\2\2\u00d8\n\3\2\2\2\u00d9"+
		"\u00da\t\5\2\2\u00da\f\3\2\2\2\u00db\u00dc\t\6\2\2\u00dc\16\3\2\2\2\u00dd"+
		"\u00de\7~\2\2\u00de\u00df\7/\2\2\u00df\u00e0\7@\2\2\u00e0\20\3\2\2\2\u00e1"+
		"\u00e2\7k\2\2\u00e2\u00e3\7h\2\2\u00e3\22\3\2\2\2\u00e4\u00e5\7g\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8\24\3\2\2\2\u00e9"+
		"\u00ea\7y\2\2\u00ea\u00eb\7j\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7n\2\2"+
		"\u00ed\u00ee\7g\2\2\u00ee\26\3\2\2\2\u00ef\u00f0\7f\2\2\u00f0\u00f1\7"+
		"q\2\2\u00f1\30\3\2\2\2\u00f2\u00f3\7h\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5"+
		"\7t\2\2\u00f5\32\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7q\2\2\u00f8\u00f9"+
		"\7t\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7n\2\2\u00fb\u00fc\7n\2\2\u00fc"+
		"\34\3\2\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7p\2\2\u00ff\36\3\2\2\2\u0100"+
		"\u0101\7q\2\2\u0101\u0102\7w\2\2\u0102\u0103\7v\2\2\u0103 \3\2\2\2\u0104"+
		"\u0105\7e\2\2\u0105\u0106\7j\2\2\u0106\u0107\7q\2\2\u0107\u0108\7q\2\2"+
		"\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2\u010a\"\3\2\2\2\u010b\u010c\7t"+
		"\2\2\u010c\u010d\7g\2\2\u010d\u010e\7v\2\2\u010e\u010f\7w\2\2\u010f\u0110"+
		"\7t\2\2\u0110\u0111\7p\2\2\u0111$\3\2\2\2\u0112\u0113\7u\2\2\u0113\u0114"+
		"\7w\2\2\u0114\u0115\7e\2\2\u0115\u0116\7e\2\2\u0116\u0117\7g\2\2\u0117"+
		"\u0118\7u\2\2\u0118\u0119\7u\2\2\u0119&\3\2\2\2\u011a\u011b\7h\2\2\u011b"+
		"\u011c\7c\2\2\u011c\u011d\7k\2\2\u011d\u011e\7n\2\2\u011e\u011f\7w\2\2"+
		"\u011f\u0120\7t\2\2\u0120\u0121\7g\2\2\u0121(\3\2\2\2\u0122\u0123\7g\2"+
		"\2\u0123\u0124\7o\2\2\u0124\u0125\7r\2\2\u0125\u0126\7v\2\2\u0126\u0127"+
		"\7{\2\2\u0127\u0128\7U\2\2\u0128\u0129\7g\2\2\u0129\u012a\7v\2\2\u012a"+
		"*\3\2\2\2\u012b\u012c\7g\2\2\u012c\u012d\7o\2\2\u012d\u012e\7r\2\2\u012e"+
		"\u012f\7v\2\2\u012f\u0130\7{\2\2\u0130\u0131\7N\2\2\u0131\u0132\7k\2\2"+
		"\u0132\u0133\7u\2\2\u0133\u0134\7v\2\2\u0134,\3\2\2\2\u0135\u0136\7o\2"+
		"\2\u0136\u0137\7q\2\2\u0137\u0138\7f\2\2\u0138\u0139\7k\2\2\u0139\u013a"+
		"\7h\2\2\u013a\u013b\7k\2\2\u013b\u013c\7g\2\2\u013c\u013d\7u\2\2\u013d"+
		".\3\2\2\2\u013e\u013f\7z\2\2\u013f\u0140\7q\2\2\u0140\u0141\7t\2\2\u0141"+
		"\60\3\2\2\2\u0142\u0143\7c\2\2\u0143\u0144\7v\2\2\u0144\62\3\2\2\2\u0145"+
		"\u0146\7d\2\2\u0146\u0147\7g\2\2\u0147\u0148\7n\2\2\u0148\u0149\7q\2\2"+
		"\u0149\u014a\7p\2\2\u014a\u014b\7i\2\2\u014b\u014c\7u\2\2\u014c\u014d"+
		"\7V\2\2\u014d\u014e\7q\2\2\u014e\64\3\2\2\2\u014f\u0150\7f\2\2\u0150\u0151"+
		"\7g\2\2\u0151\u0152\7n\2\2\u0152\u0153\7g\2\2\u0153\u0154\7v\2\2\u0154"+
		"\u0155\7g\2\2\u0155\66\3\2\2\2\u0156\u0157\7g\2\2\u0157\u0158\7o\2\2\u0158"+
		"\u0159\7r\2\2\u0159\u015a\7v\2\2\u015a\u015b\7{\2\2\u015b8\3\2\2\2\u015c"+
		"\u015d\7g\2\2\u015d\u015e\7p\2\2\u015e\u015f\7f\2\2\u015f:\3\2\2\2\u0160"+
		"\u0161\7h\2\2\u0161\u0162\7k\2\2\u0162\u0163\7t\2\2\u0163\u0164\7u\2\2"+
		"\u0164\u0165\7v\2\2\u0165<\3\2\2\2\u0166\u0167\7k\2\2\u0167\u0168\7p\2"+
		"\2\u0168\u0169\7u\2\2\u0169\u016a\7g\2\2\u016a\u016b\7t\2\2\u016b\u016c"+
		"\7v\2\2\u016c>\3\2\2\2\u016d\u016e\7r\2\2\u016e\u016f\7t\2\2\u016f\u0170"+
		"\7k\2\2\u0170\u0171\7p\2\2\u0171\u0172\7v\2\2\u0172@\3\2\2\2\u0173\u0174"+
		"\7r\2\2\u0174\u0175\7q\2\2\u0175\u0176\7r\2\2\u0176\u0177\7D\2\2\u0177"+
		"\u0178\7c\2\2\u0178\u0179\7e\2\2\u0179\u017a\7m\2\2\u017aB\3\2\2\2\u017b"+
		"\u017c\7r\2\2\u017c\u017d\7q\2\2\u017d\u017e\7r\2\2\u017e\u017f\7H\2\2"+
		"\u017f\u0180\7t\2\2\u0180\u0181\7q\2\2\u0181\u0182\7p\2\2\u0182\u0183"+
		"\7v\2\2\u0183D\3\2\2\2\u0184\u0185\7r\2\2\u0185\u0186\7w\2\2\u0186\u0187"+
		"\7u\2\2\u0187\u0188\7j\2\2\u0188\u0189\7D\2\2\u0189\u018a\7c\2\2\u018a"+
		"\u018b\7e\2\2\u018b\u018c\7m\2\2\u018cF\3\2\2\2\u018d\u018e\7r\2\2\u018e"+
		"\u018f\7w\2\2\u018f\u0190\7u\2\2\u0190\u0191\7j\2\2\u0191\u0192\7H\2\2"+
		"\u0192\u0193\7t\2\2\u0193\u0194\7q\2\2\u0194\u0195\7p\2\2\u0195\u0196"+
		"\7v\2\2\u0196H\3\2\2\2\u0197\u0198\7t\2\2\u0198\u0199\7g\2\2\u0199\u019a"+
		"\7o\2\2\u019a\u019b\7q\2\2\u019b\u019c\7x\2\2\u019c\u019d\7g\2\2\u019d"+
		"J\3\2\2\2\u019e\u019f\7t\2\2\u019f\u01a0\7g\2\2\u01a0\u01a1\7o\2\2\u01a1"+
		"\u01a2\7q\2\2\u01a2\u01a3\7x\2\2\u01a3\u01a4\7g\2\2\u01a4\u01a5\7C\2\2"+
		"\u01a5\u01a6\7n\2\2\u01a6\u01a7\7n\2\2\u01a7\u01a8\7G\2\2\u01a8\u01a9"+
		"\7s\2\2\u01a9\u01aa\7V\2\2\u01aa\u01ab\7q\2\2\u01abL\3\2\2\2\u01ac\u01ad"+
		"\7t\2\2\u01ad\u01ae\7g\2\2\u01ae\u01af\7o\2\2\u01af\u01b0\7q\2\2\u01b0"+
		"\u01b1\7x\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b3\7C\2\2\u01b3\u01b4\7v\2\2"+
		"\u01b4N\3\2\2\2\u01b5\u01b6\7u\2\2\u01b6\u01b7\7k\2\2\u01b7\u01b8\7p\2"+
		"\2\u01b8\u01b9\7i\2\2\u01b9\u01ba\7n\2\2\u01ba\u01bb\7g\2\2\u01bb\u01bc"+
		"\7v\2\2\u01bc\u01bd\7q\2\2\u01bd\u01be\7p\2\2\u01be\u01bf\7U\2\2\u01bf"+
		"\u01c0\7g\2\2\u01c0\u01c1\7v\2\2\u01c1P\3\2\2\2\u01c2\u01c3\7u\2\2\u01c3"+
		"\u01c4\7k\2\2\u01c4\u01c5\7|\2\2\u01c5\u01c6\7g\2\2\u01c6R\3\2\2\2\u01c7"+
		"\u01c8\7v\2\2\u01c8\u01c9\7q\2\2\u01c9\u01ca\7r\2\2\u01ca\u01cb\7D\2\2"+
		"\u01cb\u01cc\7c\2\2\u01cc\u01cd\7e\2\2\u01cd\u01ce\7m\2\2\u01ceT\3\2\2"+
		"\2\u01cf\u01d0\7v\2\2\u01d0\u01d1\7q\2\2\u01d1\u01d2\7r\2\2\u01d2\u01d3"+
		"\7H\2\2\u01d3\u01d4\7t\2\2\u01d4\u01d5\7q\2\2\u01d5\u01d6\7p\2\2\u01d6"+
		"\u01d7\7v\2\2\u01d7V\3\2\2\2\u01d8\u01d9\7w\2\2\u01d9\u01da\7r\2\2\u01da"+
		"\u01db\7f\2\2\u01db\u01dc\7c\2\2\u01dc\u01dd\7v\2\2\u01dd\u01de\7g\2\2"+
		"\u01deX\3\2\2\2\u01df\u01e0\7t\2\2\u01e0\u01e1\7c\2\2\u01e1\u01e2\7p\2"+
		"\2\u01e2\u01e3\7f\2\2\u01e3\u01e4\7q\2\2\u01e4\u01e5\7o\2\2\u01e5Z\3\2"+
		"\2\2\u01e6\u01e7\7/\2\2\u01e7\u01e8\7@\2\2\u01e8\\\3\2\2\2\u01e9\u01ea"+
		"\7W\2\2\u01ea^\3\2\2\2\u01eb\u01ec\7`\2\2\u01ec`\3\2\2\2\u01ed\u01ee\7"+
		"^\2\2\u01eeb\3\2\2\2\u01ef\u01f1\t\5\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f2"+
		"\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3d\3\2\2\2\u01f4"+
		"\u01f6\t\5\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2"+
		"\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\5\u00abV\2\u01fa"+
		"\u01fc\t\5\2\2\u01fb\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fb\3\2"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fef\3\2\2\2\u01ff\u0200\7v\2\2\u0200\u0201"+
		"\7t\2\2\u0201\u0202\7w\2\2\u0202\u0209\7g\2\2\u0203\u0204\7h\2\2\u0204"+
		"\u0205\7c\2\2\u0205\u0206\7n\2\2\u0206\u0207\7u\2\2\u0207\u0209\7g\2\2"+
		"\u0208\u01ff\3\2\2\2\u0208\u0203\3\2\2\2\u0209h\3\2\2\2\u020a\u020f\5"+
		"\t\5\2\u020b\u020e\5\13\6\2\u020c\u020e\5\t\5\2\u020d\u020b\3\2\2\2\u020d"+
		"\u020c\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2"+
		"\2\2\u0210j\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0213\7-\2\2\u0213\u0214"+
		"\7-\2\2\u0214l\3\2\2\2\u0215\u0216\7/\2\2\u0216\u0217\7/\2\2\u0217n\3"+
		"\2\2\2\u0218\u0219\7(\2\2\u0219p\3\2\2\2\u021a\u021b\7-\2\2\u021b\u021c"+
		"\7\'\2\2\u021cr\3\2\2\2\u021d\u021e\7/\2\2\u021e\u021f\7\'\2\2\u021ft"+
		"\3\2\2\2\u0220\u0221\7-\2\2\u0221\u0222\7-\2\2\u0222\u0223\7\'\2\2\u0223"+
		"v\3\2\2\2\u0224\u0225\7/\2\2\u0225\u0226\7/\2\2\u0226\u0227\7\'\2\2\u0227"+
		"x\3\2\2\2\u0228\u0229\7>\2\2\u0229z\3\2\2\2\u022a\u022b\7@\2\2\u022b|"+
		"\3\2\2\2\u022c\u022d\7>\2\2\u022d\u022e\7?\2\2\u022e~\3\2\2\2\u022f\u0230"+
		"\7@\2\2\u0230\u0231\7?\2\2\u0231\u0080\3\2\2\2\u0232\u0233\7?\2\2\u0233"+
		"\u0234\7?\2\2\u0234\u0082\3\2\2\2\u0235\u0236\7#\2\2\u0236\u0237\7?\2"+
		"\2\u0237\u0084\3\2\2\2\u0238\u024e\7?\2\2\u0239\u023a\7-\2\2\u023a\u024e"+
		"\7?\2\2\u023b\u023c\7/\2\2\u023c\u024e\7?\2\2\u023d\u023e\7,\2\2\u023e"+
		"\u024e\7?\2\2\u023f\u0240\7\61\2\2\u0240\u024e\7?\2\2\u0241\u0242\7\'"+
		"\2\2\u0242\u024e\7?\2\2\u0243\u0244\7>\2\2\u0244\u0245\7>\2\2\u0245\u024e"+
		"\7?\2\2\u0246\u0247\7@\2\2\u0247\u0248\7@\2\2\u0248\u024e\7?\2\2\u0249"+
		"\u024a\7(\2\2\u024a\u024e\7?\2\2\u024b\u024c\7~\2\2\u024c\u024e\7?\2\2"+
		"\u024d\u0238\3\2\2\2\u024d\u0239\3\2\2\2\u024d\u023b\3\2\2\2\u024d\u023d"+
		"\3\2\2\2\u024d\u023f\3\2\2\2\u024d\u0241\3\2\2\2\u024d\u0243\3\2\2\2\u024d"+
		"\u0246\3\2\2\2\u024d\u0249\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0086\3\2"+
		"\2\2\u024f\u0250\7/\2\2\u0250\u0088\3\2\2\2\u0251\u0252\7-\2\2\u0252\u008a"+
		"\3\2\2\2\u0253\u0254\7,\2\2\u0254\u008c\3\2\2\2\u0255\u0256\7\61\2\2\u0256"+
		"\u008e\3\2\2\2\u0257\u0258\7\'\2\2\u0258\u0090\3\2\2\2\u0259\u025a\7*"+
		"\2\2\u025a\u0092\3\2\2\2\u025b\u025c\7+\2\2\u025c\u0094\3\2\2\2\u025d"+
		"\u025e\7>\2\2\u025e\u025f\7>\2\2\u025f\u0096\3\2\2\2\u0260\u0261\7@\2"+
		"\2\u0261\u0262\7@\2\2\u0262\u0098\3\2\2\2\u0263\u0264\7~\2\2\u0264\u0265"+
		"\7~\2\2\u0265\u009a\3\2\2\2\u0266\u0267\7(\2\2\u0267\u0268\7(\2\2\u0268"+
		"\u009c\3\2\2\2\u0269\u026a\7#\2\2\u026a\u009e\3\2\2\2\u026b\u026c\7=\2"+
		"\2\u026c\u00a0\3\2\2\2\u026d\u026e\7<\2\2\u026e\u00a2\3\2\2\2\u026f\u0270"+
		"\7~\2\2\u0270\u00a4\3\2\2\2\u0271\u0272\7}\2\2\u0272\u00a6\3\2\2\2\u0273"+
		"\u0274\7\177\2\2\u0274\u00a8\3\2\2\2\u0275\u0276\7.\2\2\u0276\u00aa\3"+
		"\2\2\2\u0277\u0278\7\60\2\2\u0278\u00ac\3\2\2\2\u0279\u027a\7]\2\2\u027a"+
		"\u00ae\3\2\2\2\u027b\u027c\7_\2\2\u027c\u00b0\3\2\2\2\u027d\u027e\7$\2"+
		"\2\u027e\u00b2\3\2\2\2\u027f\u0280\7A\2\2\u0280\u00b4\3\2\2\2\u0281\u0285"+
		"\7$\2\2\u0282\u0284\n\7\2\2\u0283\u0282\3\2\2\2\u0284\u0287\3\2\2\2\u0285"+
		"\u0283\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0288\3\2\2\2\u0287\u0285\3\2"+
		"\2\2\u0288\u0289\7$\2\2\u0289\u00b6\3\2\2\2\16\2\u00ba\u00c4\u00d2\u01f2"+
		"\u01f7\u01fd\u0208\u020d\u020f\u024d\u0285\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
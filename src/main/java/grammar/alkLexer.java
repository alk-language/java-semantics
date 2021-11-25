// Generated from ./../src/main/java/grammar/parts/alk.g4 by ANTLR 4.7.1

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
		WS=1, COMMENT=2, LINE_COMMENT=3, ASSERT=4, ASSUME=5, SYMBOLIC=6, TO=7, 
		IF=8, ELSE=9, WHILE=10, DO=11, FOR=12, FOREACH=13, IN=14, FROM=15, OUT=16, 
		CHOOSE=17, UNIFORM=18, REPEAT=19, RETURN=20, SUCCESS=21, UNTIL=22, FAILURE=23, 
		CONTINUE=24, BREAK=25, EMPTYSET=26, EMPTYLIST=27, EMPTYSTRUCTURE=28, MODIFIES=29, 
		USES=30, INCLDUE=31, XOR=32, ABS=33, ACOS=34, ASIN=35, ATAN=36, COS=37, 
		LOG=38, PI=39, POW=40, SIN=41, SQRT=42, TAN=43, LEN=44, ARRAY=45, SET=46, 
		AT=47, BELONGSTO=48, DELETE=49, EMPTY=50, END=51, FIRST=52, FLOAT=53, 
		INSERT=54, INTEGER=55, PRINT=56, POPBACK=57, POPFRONT=58, PUSHBACK=59, 
		PUSHFRONT=60, REMOVE=61, REMOVEALLEQTO=62, REMOVEAT=63, SINGLETONSET=64, 
		SIZE=65, SPLIT=66, TOPBACK=67, TOPFRONT=68, UPDATE=69, UNIFORMNAT=70, 
		FLIP=71, UNIFORMFLOAT=72, UNIFORMPERM=73, SOTHAT=74, SYM=75, ARROW=76, 
		NUMSIGN=77, ANNO=78, COUNT=79, UNION=80, INTERSECT=81, SUBTRACT=82, INT=83, 
		DOUBLE=84, BOOL=85, ID=86, PLUSPLUS=87, MINUSMINUS=88, BITWISE_AND=89, 
		PLUSMOD=90, MINUSMOD=91, PLUSPLUSMOD=92, MINUSMINUSMOD=93, LOWER=94, GREATER=95, 
		LOWEREQ=96, GREATEREQ=97, ISEQUAL=98, NOTEQUAL=99, ASSIGNMENT_OPERATOR=100, 
		MINUS=101, PLUS=102, MUL=103, DIV=104, MOD=105, LPAR=106, RPAR=107, LEFTSHIFT=108, 
		RIGHTSHIFT=109, OR=110, AND=111, NOT=112, SEMICOLON=113, DPOINT=114, VBAR=115, 
		LCB=116, RCB=117, COMMA=118, POINT=119, LBRA=120, RBRA=121, QUOTE=122, 
		QUESTION=123, STRING=124;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LINE_COMMENT", "NONDIGIT", "DIGIT", "NONZERODIGIT", 
		"ASSERT", "ASSUME", "SYMBOLIC", "TO", "IF", "ELSE", "WHILE", "DO", "FOR", 
		"FOREACH", "IN", "FROM", "OUT", "CHOOSE", "UNIFORM", "REPEAT", "RETURN", 
		"SUCCESS", "UNTIL", "FAILURE", "CONTINUE", "BREAK", "EMPTYSET", "EMPTYLIST", 
		"EMPTYSTRUCTURE", "MODIFIES", "USES", "INCLDUE", "XOR", "ABS", "ACOS", 
		"ASIN", "ATAN", "COS", "LOG", "PI", "POW", "SIN", "SQRT", "TAN", "LEN", 
		"ARRAY", "SET", "AT", "BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", 
		"FLOAT", "INSERT", "INTEGER", "PRINT", "POPBACK", "POPFRONT", "PUSHBACK", 
		"PUSHFRONT", "REMOVE", "REMOVEALLEQTO", "REMOVEAT", "SINGLETONSET", "SIZE", 
		"SPLIT", "TOPBACK", "TOPFRONT", "UPDATE", "UNIFORMNAT", "FLIP", "UNIFORMFLOAT", 
		"UNIFORMPERM", "SOTHAT", "SYM", "ARROW", "NUMSIGN", "ANNO", "COUNT", "UNION", 
		"INTERSECT", "SUBTRACT", "INT", "DOUBLE", "BOOL", "ID", "PLUSPLUS", "MINUSMINUS", 
		"BITWISE_AND", "PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", "MINUSMINUSMOD", 
		"LOWER", "GREATER", "LOWEREQ", "GREATEREQ", "ISEQUAL", "NOTEQUAL", "ASSIGNMENT_OPERATOR", 
		"MINUS", "PLUS", "MUL", "DIV", "MOD", "LPAR", "RPAR", "LEFTSHIFT", "RIGHTSHIFT", 
		"OR", "AND", "NOT", "SEMICOLON", "DPOINT", "VBAR", "LCB", "RCB", "COMMA", 
		"POINT", "LBRA", "RBRA", "QUOTE", "QUESTION", "STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'assert'", "'assume'", "'symbolic'", "'|->'", 
		"'if'", "'else'", "'while'", "'do'", "'for'", "'foreach'", "'in'", "'from'", 
		"'out'", "'choose'", "'uniform'", "'repeat'", "'return'", "'success'", 
		"'until'", "'failure'", "'continue'", "'break'", "'emptySet'", "'emptyList'", 
		"'emptyStructure'", "'modifies'", "'uses'", "'include'", "'xor'", "'abs'", 
		"'acos'", "'asin'", "'atan'", "'cos'", "'log'", "'pi'", "'pow'", "'sin'", 
		"'sqrt'", "'tan'", "'len'", "'array'", "'set'", "'at'", "'belongsTo'", 
		"'delete'", "'empty'", "'end'", "'first'", "'float'", "'insert'", "'int'", 
		"'print'", "'popBack'", "'popFront'", "'pushBack'", "'pushFront'", "'remove'", 
		"'removeAllEqTo'", "'removeAt'", "'singletonSet'", "'size'", "'split'", 
		"'topBack'", "'topFront'", "'update'", "'uniformNat'", "'flip'", "'uniformFloat'", 
		"'uniformPerm'", "'s.t.'", "'$'", "'->'", "'#'", "'@'", "'Count'", "'U'", 
		"'^'", "'\\'", null, null, null, null, "'++'", "'--'", "'&'", "'+%'", 
		"'-%'", "'++%'", "'--%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
		null, "'-'", "'+'", "'*'", "'/'", "'%'", "'('", "')'", "'<<'", "'>>'", 
		"'||'", "'&&'", "'!'", "';'", "':'", "'|'", "'{'", "'}'", "','", "'.'", 
		"'['", "']'", "'\"'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "ASSERT", "ASSUME", "SYMBOLIC", 
		"TO", "IF", "ELSE", "WHILE", "DO", "FOR", "FOREACH", "IN", "FROM", "OUT", 
		"CHOOSE", "UNIFORM", "REPEAT", "RETURN", "SUCCESS", "UNTIL", "FAILURE", 
		"CONTINUE", "BREAK", "EMPTYSET", "EMPTYLIST", "EMPTYSTRUCTURE", "MODIFIES", 
		"USES", "INCLDUE", "XOR", "ABS", "ACOS", "ASIN", "ATAN", "COS", "LOG", 
		"PI", "POW", "SIN", "SQRT", "TAN", "LEN", "ARRAY", "SET", "AT", "BELONGSTO", 
		"DELETE", "EMPTY", "END", "FIRST", "FLOAT", "INSERT", "INTEGER", "PRINT", 
		"POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", "REMOVE", "REMOVEALLEQTO", 
		"REMOVEAT", "SINGLETONSET", "SIZE", "SPLIT", "TOPBACK", "TOPFRONT", "UPDATE", 
		"UNIFORMNAT", "FLIP", "UNIFORMFLOAT", "UNIFORMPERM", "SOTHAT", "SYM", 
		"ARROW", "NUMSIGN", "ANNO", "COUNT", "UNION", "INTERSECT", "SUBTRACT", 
		"INT", "DOUBLE", "BOOL", "ID", "PLUSPLUS", "MINUSMINUS", "BITWISE_AND", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2~\u03b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\3\2\6\2\u0103\n\2\r\2\16\2\u0104\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u010d\n"+
		"\3\f\3\16\3\u0110\13\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u011b\n"+
		"\4\f\4\16\4\u011e\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3("+
		"\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3."+
		"\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\39\3:\3:\3"+
		":\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3"+
		"@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3D\3"+
		"D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3"+
		"H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3J\3"+
		"J\3J\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3"+
		"M\3M\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3O\3O\3P\3P\3P\3Q\3Q\3R\3R\3"+
		"S\3S\3S\3S\3S\3S\3T\3T\3U\3U\3V\3V\3W\6W\u0318\nW\rW\16W\u0319\3X\6X\u031d"+
		"\nX\rX\16X\u031e\3X\3X\6X\u0323\nX\rX\16X\u0324\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3"+
		"Y\3Y\5Y\u0330\nY\3Z\3Z\3Z\7Z\u0335\nZ\fZ\16Z\u0338\13Z\3[\3[\3[\3\\\3"+
		"\\\3\\\3]\3]\3^\3^\3^\3_\3_\3_\3`\3`\3`\3`\3a\3a\3a\3a\3b\3b\3c\3c\3d"+
		"\3d\3d\3e\3e\3e\3f\3f\3f\3g\3g\3g\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h"+
		"\3h\3h\3h\3h\3h\3h\3h\3h\3h\5h\u0375\nh\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m"+
		"\3n\3n\3o\3o\3p\3p\3p\3q\3q\3q\3r\3r\3r\3s\3s\3s\3t\3t\3u\3u\3v\3v\3w"+
		"\3w\3x\3x\3y\3y\3z\3z\3{\3{\3|\3|\3}\3}\3~\3~\3\177\3\177\3\u0080\3\u0080"+
		"\7\u0080\u03ab\n\u0080\f\u0080\16\u0080\u03ae\13\u0080\3\u0080\3\u0080"+
		"\3\u010e\2\u0081\3\3\5\4\7\5\t\2\13\2\r\2\17\6\21\7\23\b\25\t\27\n\31"+
		"\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31"+
		"\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_.a/c\60e\61g"+
		"\62i\63k\64m\65o\66q\67s8u9w:y;{<}=\177>\u0081?\u0083@\u0085A\u0087B\u0089"+
		"C\u008bD\u008dE\u008fF\u0091G\u0093H\u0095I\u0097J\u0099K\u009bL\u009d"+
		"M\u009fN\u00a1O\u00a3P\u00a5Q\u00a7R\u00a9S\u00abT\u00adU\u00afV\u00b1"+
		"W\u00b3X\u00b5Y\u00b7Z\u00b9[\u00bb\\\u00bd]\u00bf^\u00c1_\u00c3`\u00c5"+
		"a\u00c7b\u00c9c\u00cbd\u00cde\u00cff\u00d1g\u00d3h\u00d5i\u00d7j\u00d9"+
		"k\u00dbl\u00ddm\u00dfn\u00e1o\u00e3p\u00e5q\u00e7r\u00e9s\u00ebt\u00ed"+
		"u\u00efv\u00f1w\u00f3x\u00f5y\u00f7z\u00f9{\u00fb|\u00fd}\u00ff~\3\2\b"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\5\2C\\aac|\3\2\62;\3\2\63;\5\2\f\f\17"+
		"\17$$\2\u03c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2"+
		"\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7"+
		"\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2"+
		"\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9"+
		"\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2"+
		"\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb"+
		"\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2"+
		"\2\2\u00f5\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb\3\2\2\2\2\u00fd"+
		"\3\2\2\2\2\u00ff\3\2\2\2\3\u0102\3\2\2\2\5\u0108\3\2\2\2\7\u0116\3\2\2"+
		"\2\t\u0121\3\2\2\2\13\u0123\3\2\2\2\r\u0125\3\2\2\2\17\u0127\3\2\2\2\21"+
		"\u012e\3\2\2\2\23\u0135\3\2\2\2\25\u013e\3\2\2\2\27\u0142\3\2\2\2\31\u0145"+
		"\3\2\2\2\33\u014a\3\2\2\2\35\u0150\3\2\2\2\37\u0153\3\2\2\2!\u0157\3\2"+
		"\2\2#\u015f\3\2\2\2%\u0162\3\2\2\2\'\u0167\3\2\2\2)\u016b\3\2\2\2+\u0172"+
		"\3\2\2\2-\u017a\3\2\2\2/\u0181\3\2\2\2\61\u0188\3\2\2\2\63\u0190\3\2\2"+
		"\2\65\u0196\3\2\2\2\67\u019e\3\2\2\29\u01a7\3\2\2\2;\u01ad\3\2\2\2=\u01b6"+
		"\3\2\2\2?\u01c0\3\2\2\2A\u01cf\3\2\2\2C\u01d8\3\2\2\2E\u01dd\3\2\2\2G"+
		"\u01e5\3\2\2\2I\u01e9\3\2\2\2K\u01ed\3\2\2\2M\u01f2\3\2\2\2O\u01f7\3\2"+
		"\2\2Q\u01fc\3\2\2\2S\u0200\3\2\2\2U\u0204\3\2\2\2W\u0207\3\2\2\2Y\u020b"+
		"\3\2\2\2[\u020f\3\2\2\2]\u0214\3\2\2\2_\u0218\3\2\2\2a\u021c\3\2\2\2c"+
		"\u0222\3\2\2\2e\u0226\3\2\2\2g\u0229\3\2\2\2i\u0233\3\2\2\2k\u023a\3\2"+
		"\2\2m\u0240\3\2\2\2o\u0244\3\2\2\2q\u024a\3\2\2\2s\u0250\3\2\2\2u\u0257"+
		"\3\2\2\2w\u025b\3\2\2\2y\u0261\3\2\2\2{\u0269\3\2\2\2}\u0272\3\2\2\2\177"+
		"\u027b\3\2\2\2\u0081\u0285\3\2\2\2\u0083\u028c\3\2\2\2\u0085\u029a\3\2"+
		"\2\2\u0087\u02a3\3\2\2\2\u0089\u02b0\3\2\2\2\u008b\u02b5\3\2\2\2\u008d"+
		"\u02bb\3\2\2\2\u008f\u02c3\3\2\2\2\u0091\u02cc\3\2\2\2\u0093\u02d3\3\2"+
		"\2\2\u0095\u02de\3\2\2\2\u0097\u02e3\3\2\2\2\u0099\u02f0\3\2\2\2\u009b"+
		"\u02fc\3\2\2\2\u009d\u0301\3\2\2\2\u009f\u0303\3\2\2\2\u00a1\u0306\3\2"+
		"\2\2\u00a3\u0308\3\2\2\2\u00a5\u030a\3\2\2\2\u00a7\u0310\3\2\2\2\u00a9"+
		"\u0312\3\2\2\2\u00ab\u0314\3\2\2\2\u00ad\u0317\3\2\2\2\u00af\u031c\3\2"+
		"\2\2\u00b1\u032f\3\2\2\2\u00b3\u0331\3\2\2\2\u00b5\u0339\3\2\2\2\u00b7"+
		"\u033c\3\2\2\2\u00b9\u033f\3\2\2\2\u00bb\u0341\3\2\2\2\u00bd\u0344\3\2"+
		"\2\2\u00bf\u0347\3\2\2\2\u00c1\u034b\3\2\2\2\u00c3\u034f\3\2\2\2\u00c5"+
		"\u0351\3\2\2\2\u00c7\u0353\3\2\2\2\u00c9\u0356\3\2\2\2\u00cb\u0359\3\2"+
		"\2\2\u00cd\u035c\3\2\2\2\u00cf\u0374\3\2\2\2\u00d1\u0376\3\2\2\2\u00d3"+
		"\u0378\3\2\2\2\u00d5\u037a\3\2\2\2\u00d7\u037c\3\2\2\2\u00d9\u037e\3\2"+
		"\2\2\u00db\u0380\3\2\2\2\u00dd\u0382\3\2\2\2\u00df\u0384\3\2\2\2\u00e1"+
		"\u0387\3\2\2\2\u00e3\u038a\3\2\2\2\u00e5\u038d\3\2\2\2\u00e7\u0390\3\2"+
		"\2\2\u00e9\u0392\3\2\2\2\u00eb\u0394\3\2\2\2\u00ed\u0396\3\2\2\2\u00ef"+
		"\u0398\3\2\2\2\u00f1\u039a\3\2\2\2\u00f3\u039c\3\2\2\2\u00f5\u039e\3\2"+
		"\2\2\u00f7\u03a0\3\2\2\2\u00f9\u03a2\3\2\2\2\u00fb\u03a4\3\2\2\2\u00fd"+
		"\u03a6\3\2\2\2\u00ff\u03a8\3\2\2\2\u0101\u0103\t\2\2\2\u0102\u0101\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\b\2\2\2\u0107\4\3\2\2\2\u0108\u0109\7\61\2"+
		"\2\u0109\u010a\7,\2\2\u010a\u010e\3\2\2\2\u010b\u010d\13\2\2\2\u010c\u010b"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7,\2\2\u0112\u0113\7\61"+
		"\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b\3\2\2\u0115\6\3\2\2\2\u0116\u0117"+
		"\7\61\2\2\u0117\u0118\7\61\2\2\u0118\u011c\3\2\2\2\u0119\u011b\n\3\2\2"+
		"\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\b\4\2\2\u0120"+
		"\b\3\2\2\2\u0121\u0122\t\4\2\2\u0122\n\3\2\2\2\u0123\u0124\t\5\2\2\u0124"+
		"\f\3\2\2\2\u0125\u0126\t\6\2\2\u0126\16\3\2\2\2\u0127\u0128\7c\2\2\u0128"+
		"\u0129\7u\2\2\u0129\u012a\7u\2\2\u012a\u012b\7g\2\2\u012b\u012c\7t\2\2"+
		"\u012c\u012d\7v\2\2\u012d\20\3\2\2\2\u012e\u012f\7c\2\2\u012f\u0130\7"+
		"u\2\2\u0130\u0131\7u\2\2\u0131\u0132\7w\2\2\u0132\u0133\7o\2\2\u0133\u0134"+
		"\7g\2\2\u0134\22\3\2\2\2\u0135\u0136\7u\2\2\u0136\u0137\7{\2\2\u0137\u0138"+
		"\7o\2\2\u0138\u0139\7d\2\2\u0139\u013a\7q\2\2\u013a\u013b\7n\2\2\u013b"+
		"\u013c\7k\2\2\u013c\u013d\7e\2\2\u013d\24\3\2\2\2\u013e\u013f\7~\2\2\u013f"+
		"\u0140\7/\2\2\u0140\u0141\7@\2\2\u0141\26\3\2\2\2\u0142\u0143\7k\2\2\u0143"+
		"\u0144\7h\2\2\u0144\30\3\2\2\2\u0145\u0146\7g\2\2\u0146\u0147\7n\2\2\u0147"+
		"\u0148\7u\2\2\u0148\u0149\7g\2\2\u0149\32\3\2\2\2\u014a\u014b\7y\2\2\u014b"+
		"\u014c\7j\2\2\u014c\u014d\7k\2\2\u014d\u014e\7n\2\2\u014e\u014f\7g\2\2"+
		"\u014f\34\3\2\2\2\u0150\u0151\7f\2\2\u0151\u0152\7q\2\2\u0152\36\3\2\2"+
		"\2\u0153\u0154\7h\2\2\u0154\u0155\7q\2\2\u0155\u0156\7t\2\2\u0156 \3\2"+
		"\2\2\u0157\u0158\7h\2\2\u0158\u0159\7q\2\2\u0159\u015a\7t\2\2\u015a\u015b"+
		"\7g\2\2\u015b\u015c\7c\2\2\u015c\u015d\7e\2\2\u015d\u015e\7j\2\2\u015e"+
		"\"\3\2\2\2\u015f\u0160\7k\2\2\u0160\u0161\7p\2\2\u0161$\3\2\2\2\u0162"+
		"\u0163\7h\2\2\u0163\u0164\7t\2\2\u0164\u0165\7q\2\2\u0165\u0166\7o\2\2"+
		"\u0166&\3\2\2\2\u0167\u0168\7q\2\2\u0168\u0169\7w\2\2\u0169\u016a\7v\2"+
		"\2\u016a(\3\2\2\2\u016b\u016c\7e\2\2\u016c\u016d\7j\2\2\u016d\u016e\7"+
		"q\2\2\u016e\u016f\7q\2\2\u016f\u0170\7u\2\2\u0170\u0171\7g\2\2\u0171*"+
		"\3\2\2\2\u0172\u0173\7w\2\2\u0173\u0174\7p\2\2\u0174\u0175\7k\2\2\u0175"+
		"\u0176\7h\2\2\u0176\u0177\7q\2\2\u0177\u0178\7t\2\2\u0178\u0179\7o\2\2"+
		"\u0179,\3\2\2\2\u017a\u017b\7t\2\2\u017b\u017c\7g\2\2\u017c\u017d\7r\2"+
		"\2\u017d\u017e\7g\2\2\u017e\u017f\7c\2\2\u017f\u0180\7v\2\2\u0180.\3\2"+
		"\2\2\u0181\u0182\7t\2\2\u0182\u0183\7g\2\2\u0183\u0184\7v\2\2\u0184\u0185"+
		"\7w\2\2\u0185\u0186\7t\2\2\u0186\u0187\7p\2\2\u0187\60\3\2\2\2\u0188\u0189"+
		"\7u\2\2\u0189\u018a\7w\2\2\u018a\u018b\7e\2\2\u018b\u018c\7e\2\2\u018c"+
		"\u018d\7g\2\2\u018d\u018e\7u\2\2\u018e\u018f\7u\2\2\u018f\62\3\2\2\2\u0190"+
		"\u0191\7w\2\2\u0191\u0192\7p\2\2\u0192\u0193\7v\2\2\u0193\u0194\7k\2\2"+
		"\u0194\u0195\7n\2\2\u0195\64\3\2\2\2\u0196\u0197\7h\2\2\u0197\u0198\7"+
		"c\2\2\u0198\u0199\7k\2\2\u0199\u019a\7n\2\2\u019a\u019b\7w\2\2\u019b\u019c"+
		"\7t\2\2\u019c\u019d\7g\2\2\u019d\66\3\2\2\2\u019e\u019f\7e\2\2\u019f\u01a0"+
		"\7q\2\2\u01a0\u01a1\7p\2\2\u01a1\u01a2\7v\2\2\u01a2\u01a3\7k\2\2\u01a3"+
		"\u01a4\7p\2\2\u01a4\u01a5\7w\2\2\u01a5\u01a6\7g\2\2\u01a68\3\2\2\2\u01a7"+
		"\u01a8\7d\2\2\u01a8\u01a9\7t\2\2\u01a9\u01aa\7g\2\2\u01aa\u01ab\7c\2\2"+
		"\u01ab\u01ac\7m\2\2\u01ac:\3\2\2\2\u01ad\u01ae\7g\2\2\u01ae\u01af\7o\2"+
		"\2\u01af\u01b0\7r\2\2\u01b0\u01b1\7v\2\2\u01b1\u01b2\7{\2\2\u01b2\u01b3"+
		"\7U\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7v\2\2\u01b5<\3\2\2\2\u01b6\u01b7"+
		"\7g\2\2\u01b7\u01b8\7o\2\2\u01b8\u01b9\7r\2\2\u01b9\u01ba\7v\2\2\u01ba"+
		"\u01bb\7{\2\2\u01bb\u01bc\7N\2\2\u01bc\u01bd\7k\2\2\u01bd\u01be\7u\2\2"+
		"\u01be\u01bf\7v\2\2\u01bf>\3\2\2\2\u01c0\u01c1\7g\2\2\u01c1\u01c2\7o\2"+
		"\2\u01c2\u01c3\7r\2\2\u01c3\u01c4\7v\2\2\u01c4\u01c5\7{\2\2\u01c5\u01c6"+
		"\7U\2\2\u01c6\u01c7\7v\2\2\u01c7\u01c8\7t\2\2\u01c8\u01c9\7w\2\2\u01c9"+
		"\u01ca\7e\2\2\u01ca\u01cb\7v\2\2\u01cb\u01cc\7w\2\2\u01cc\u01cd\7t\2\2"+
		"\u01cd\u01ce\7g\2\2\u01ce@\3\2\2\2\u01cf\u01d0\7o\2\2\u01d0\u01d1\7q\2"+
		"\2\u01d1\u01d2\7f\2\2\u01d2\u01d3\7k\2\2\u01d3\u01d4\7h\2\2\u01d4\u01d5"+
		"\7k\2\2\u01d5\u01d6\7g\2\2\u01d6\u01d7\7u\2\2\u01d7B\3\2\2\2\u01d8\u01d9"+
		"\7w\2\2\u01d9\u01da\7u\2\2\u01da\u01db\7g\2\2\u01db\u01dc\7u\2\2\u01dc"+
		"D\3\2\2\2\u01dd\u01de\7k\2\2\u01de\u01df\7p\2\2\u01df\u01e0\7e\2\2\u01e0"+
		"\u01e1\7n\2\2\u01e1\u01e2\7w\2\2\u01e2\u01e3\7f\2\2\u01e3\u01e4\7g\2\2"+
		"\u01e4F\3\2\2\2\u01e5\u01e6\7z\2\2\u01e6\u01e7\7q\2\2\u01e7\u01e8\7t\2"+
		"\2\u01e8H\3\2\2\2\u01e9\u01ea\7c\2\2\u01ea\u01eb\7d\2\2\u01eb\u01ec\7"+
		"u\2\2\u01ecJ\3\2\2\2\u01ed\u01ee\7c\2\2\u01ee\u01ef\7e\2\2\u01ef\u01f0"+
		"\7q\2\2\u01f0\u01f1\7u\2\2\u01f1L\3\2\2\2\u01f2\u01f3\7c\2\2\u01f3\u01f4"+
		"\7u\2\2\u01f4\u01f5\7k\2\2\u01f5\u01f6\7p\2\2\u01f6N\3\2\2\2\u01f7\u01f8"+
		"\7c\2\2\u01f8\u01f9\7v\2\2\u01f9\u01fa\7c\2\2\u01fa\u01fb\7p\2\2\u01fb"+
		"P\3\2\2\2\u01fc\u01fd\7e\2\2\u01fd\u01fe\7q\2\2\u01fe\u01ff\7u\2\2\u01ff"+
		"R\3\2\2\2\u0200\u0201\7n\2\2\u0201\u0202\7q\2\2\u0202\u0203\7i\2\2\u0203"+
		"T\3\2\2\2\u0204\u0205\7r\2\2\u0205\u0206\7k\2\2\u0206V\3\2\2\2\u0207\u0208"+
		"\7r\2\2\u0208\u0209\7q\2\2\u0209\u020a\7y\2\2\u020aX\3\2\2\2\u020b\u020c"+
		"\7u\2\2\u020c\u020d\7k\2\2\u020d\u020e\7p\2\2\u020eZ\3\2\2\2\u020f\u0210"+
		"\7u\2\2\u0210\u0211\7s\2\2\u0211\u0212\7t\2\2\u0212\u0213\7v\2\2\u0213"+
		"\\\3\2\2\2\u0214\u0215\7v\2\2\u0215\u0216\7c\2\2\u0216\u0217\7p\2\2\u0217"+
		"^\3\2\2\2\u0218\u0219\7n\2\2\u0219\u021a\7g\2\2\u021a\u021b\7p\2\2\u021b"+
		"`\3\2\2\2\u021c\u021d\7c\2\2\u021d\u021e\7t\2\2\u021e\u021f\7t\2\2\u021f"+
		"\u0220\7c\2\2\u0220\u0221\7{\2\2\u0221b\3\2\2\2\u0222\u0223\7u\2\2\u0223"+
		"\u0224\7g\2\2\u0224\u0225\7v\2\2\u0225d\3\2\2\2\u0226\u0227\7c\2\2\u0227"+
		"\u0228\7v\2\2\u0228f\3\2\2\2\u0229\u022a\7d\2\2\u022a\u022b\7g\2\2\u022b"+
		"\u022c\7n\2\2\u022c\u022d\7q\2\2\u022d\u022e\7p\2\2\u022e\u022f\7i\2\2"+
		"\u022f\u0230\7u\2\2\u0230\u0231\7V\2\2\u0231\u0232\7q\2\2\u0232h\3\2\2"+
		"\2\u0233\u0234\7f\2\2\u0234\u0235\7g\2\2\u0235\u0236\7n\2\2\u0236\u0237"+
		"\7g\2\2\u0237\u0238\7v\2\2\u0238\u0239\7g\2\2\u0239j\3\2\2\2\u023a\u023b"+
		"\7g\2\2\u023b\u023c\7o\2\2\u023c\u023d\7r\2\2\u023d\u023e\7v\2\2\u023e"+
		"\u023f\7{\2\2\u023fl\3\2\2\2\u0240\u0241\7g\2\2\u0241\u0242\7p\2\2\u0242"+
		"\u0243\7f\2\2\u0243n\3\2\2\2\u0244\u0245\7h\2\2\u0245\u0246\7k\2\2\u0246"+
		"\u0247\7t\2\2\u0247\u0248\7u\2\2\u0248\u0249\7v\2\2\u0249p\3\2\2\2\u024a"+
		"\u024b\7h\2\2\u024b\u024c\7n\2\2\u024c\u024d\7q\2\2\u024d\u024e\7c\2\2"+
		"\u024e\u024f\7v\2\2\u024fr\3\2\2\2\u0250\u0251\7k\2\2\u0251\u0252\7p\2"+
		"\2\u0252\u0253\7u\2\2\u0253\u0254\7g\2\2\u0254\u0255\7t\2\2\u0255\u0256"+
		"\7v\2\2\u0256t\3\2\2\2\u0257\u0258\7k\2\2\u0258\u0259\7p\2\2\u0259\u025a"+
		"\7v\2\2\u025av\3\2\2\2\u025b\u025c\7r\2\2\u025c\u025d\7t\2\2\u025d\u025e"+
		"\7k\2\2\u025e\u025f\7p\2\2\u025f\u0260\7v\2\2\u0260x\3\2\2\2\u0261\u0262"+
		"\7r\2\2\u0262\u0263\7q\2\2\u0263\u0264\7r\2\2\u0264\u0265\7D\2\2\u0265"+
		"\u0266\7c\2\2\u0266\u0267\7e\2\2\u0267\u0268\7m\2\2\u0268z\3\2\2\2\u0269"+
		"\u026a\7r\2\2\u026a\u026b\7q\2\2\u026b\u026c\7r\2\2\u026c\u026d\7H\2\2"+
		"\u026d\u026e\7t\2\2\u026e\u026f\7q\2\2\u026f\u0270\7p\2\2\u0270\u0271"+
		"\7v\2\2\u0271|\3\2\2\2\u0272\u0273\7r\2\2\u0273\u0274\7w\2\2\u0274\u0275"+
		"\7u\2\2\u0275\u0276\7j\2\2\u0276\u0277\7D\2\2\u0277\u0278\7c\2\2\u0278"+
		"\u0279\7e\2\2\u0279\u027a\7m\2\2\u027a~\3\2\2\2\u027b\u027c\7r\2\2\u027c"+
		"\u027d\7w\2\2\u027d\u027e\7u\2\2\u027e\u027f\7j\2\2\u027f\u0280\7H\2\2"+
		"\u0280\u0281\7t\2\2\u0281\u0282\7q\2\2\u0282\u0283\7p\2\2\u0283\u0284"+
		"\7v\2\2\u0284\u0080\3\2\2\2\u0285\u0286\7t\2\2\u0286\u0287\7g\2\2\u0287"+
		"\u0288\7o\2\2\u0288\u0289\7q\2\2\u0289\u028a\7x\2\2\u028a\u028b\7g\2\2"+
		"\u028b\u0082\3\2\2\2\u028c\u028d\7t\2\2\u028d\u028e\7g\2\2\u028e\u028f"+
		"\7o\2\2\u028f\u0290\7q\2\2\u0290\u0291\7x\2\2\u0291\u0292\7g\2\2\u0292"+
		"\u0293\7C\2\2\u0293\u0294\7n\2\2\u0294\u0295\7n\2\2\u0295\u0296\7G\2\2"+
		"\u0296\u0297\7s\2\2\u0297\u0298\7V\2\2\u0298\u0299\7q\2\2\u0299\u0084"+
		"\3\2\2\2\u029a\u029b\7t\2\2\u029b\u029c\7g\2\2\u029c\u029d\7o\2\2\u029d"+
		"\u029e\7q\2\2\u029e\u029f\7x\2\2\u029f\u02a0\7g\2\2\u02a0\u02a1\7C\2\2"+
		"\u02a1\u02a2\7v\2\2\u02a2\u0086\3\2\2\2\u02a3\u02a4\7u\2\2\u02a4\u02a5"+
		"\7k\2\2\u02a5\u02a6\7p\2\2\u02a6\u02a7\7i\2\2\u02a7\u02a8\7n\2\2\u02a8"+
		"\u02a9\7g\2\2\u02a9\u02aa\7v\2\2\u02aa\u02ab\7q\2\2\u02ab\u02ac\7p\2\2"+
		"\u02ac\u02ad\7U\2\2\u02ad\u02ae\7g\2\2\u02ae\u02af\7v\2\2\u02af\u0088"+
		"\3\2\2\2\u02b0\u02b1\7u\2\2\u02b1\u02b2\7k\2\2\u02b2\u02b3\7|\2\2\u02b3"+
		"\u02b4\7g\2\2\u02b4\u008a\3\2\2\2\u02b5\u02b6\7u\2\2\u02b6\u02b7\7r\2"+
		"\2\u02b7\u02b8\7n\2\2\u02b8\u02b9\7k\2\2\u02b9\u02ba\7v\2\2\u02ba\u008c"+
		"\3\2\2\2\u02bb\u02bc\7v\2\2\u02bc\u02bd\7q\2\2\u02bd\u02be\7r\2\2\u02be"+
		"\u02bf\7D\2\2\u02bf\u02c0\7c\2\2\u02c0\u02c1\7e\2\2\u02c1\u02c2\7m\2\2"+
		"\u02c2\u008e\3\2\2\2\u02c3\u02c4\7v\2\2\u02c4\u02c5\7q\2\2\u02c5\u02c6"+
		"\7r\2\2\u02c6\u02c7\7H\2\2\u02c7\u02c8\7t\2\2\u02c8\u02c9\7q\2\2\u02c9"+
		"\u02ca\7p\2\2\u02ca\u02cb\7v\2\2\u02cb\u0090\3\2\2\2\u02cc\u02cd\7w\2"+
		"\2\u02cd\u02ce\7r\2\2\u02ce\u02cf\7f\2\2\u02cf\u02d0\7c\2\2\u02d0\u02d1"+
		"\7v\2\2\u02d1\u02d2\7g\2\2\u02d2\u0092\3\2\2\2\u02d3\u02d4\7w\2\2\u02d4"+
		"\u02d5\7p\2\2\u02d5\u02d6\7k\2\2\u02d6\u02d7\7h\2\2\u02d7\u02d8\7q\2\2"+
		"\u02d8\u02d9\7t\2\2\u02d9\u02da\7o\2\2\u02da\u02db\7P\2\2\u02db\u02dc"+
		"\7c\2\2\u02dc\u02dd\7v\2\2\u02dd\u0094\3\2\2\2\u02de\u02df\7h\2\2\u02df"+
		"\u02e0\7n\2\2\u02e0\u02e1\7k\2\2\u02e1\u02e2\7r\2\2\u02e2\u0096\3\2\2"+
		"\2\u02e3\u02e4\7w\2\2\u02e4\u02e5\7p\2\2\u02e5\u02e6\7k\2\2\u02e6\u02e7"+
		"\7h\2\2\u02e7\u02e8\7q\2\2\u02e8\u02e9\7t\2\2\u02e9\u02ea\7o\2\2\u02ea"+
		"\u02eb\7H\2\2\u02eb\u02ec\7n\2\2\u02ec\u02ed\7q\2\2\u02ed\u02ee\7c\2\2"+
		"\u02ee\u02ef\7v\2\2\u02ef\u0098\3\2\2\2\u02f0\u02f1\7w\2\2\u02f1\u02f2"+
		"\7p\2\2\u02f2\u02f3\7k\2\2\u02f3\u02f4\7h\2\2\u02f4\u02f5\7q\2\2\u02f5"+
		"\u02f6\7t\2\2\u02f6\u02f7\7o\2\2\u02f7\u02f8\7R\2\2\u02f8\u02f9\7g\2\2"+
		"\u02f9\u02fa\7t\2\2\u02fa\u02fb\7o\2\2\u02fb\u009a\3\2\2\2\u02fc\u02fd"+
		"\7u\2\2\u02fd\u02fe\7\60\2\2\u02fe\u02ff\7v\2\2\u02ff\u0300\7\60\2\2\u0300"+
		"\u009c\3\2\2\2\u0301\u0302\7&\2\2\u0302\u009e\3\2\2\2\u0303\u0304\7/\2"+
		"\2\u0304\u0305\7@\2\2\u0305\u00a0\3\2\2\2\u0306\u0307\7%\2\2\u0307\u00a2"+
		"\3\2\2\2\u0308\u0309\7B\2\2\u0309\u00a4\3\2\2\2\u030a\u030b\7E\2\2\u030b"+
		"\u030c\7q\2\2\u030c\u030d\7w\2\2\u030d\u030e\7p\2\2\u030e\u030f\7v\2\2"+
		"\u030f\u00a6\3\2\2\2\u0310\u0311\7W\2\2\u0311\u00a8\3\2\2\2\u0312\u0313"+
		"\7`\2\2\u0313\u00aa\3\2\2\2\u0314\u0315\7^\2\2\u0315\u00ac\3\2\2\2\u0316"+
		"\u0318\t\5\2\2\u0317\u0316\3\2\2\2\u0318\u0319\3\2\2\2\u0319\u0317\3\2"+
		"\2\2\u0319\u031a\3\2\2\2\u031a\u00ae\3\2\2\2\u031b\u031d\t\5\2\2\u031c"+
		"\u031b\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2"+
		"\2\2\u031f\u0320\3\2\2\2\u0320\u0322\5\u00f5{\2\u0321\u0323\t\5\2\2\u0322"+
		"\u0321\3\2\2\2\u0323\u0324\3\2\2\2\u0324\u0322\3\2\2\2\u0324\u0325\3\2"+
		"\2\2\u0325\u00b0\3\2\2\2\u0326\u0327\7v\2\2\u0327\u0328\7t\2\2\u0328\u0329"+
		"\7w\2\2\u0329\u0330\7g\2\2\u032a\u032b\7h\2\2\u032b\u032c\7c\2\2\u032c"+
		"\u032d\7n\2\2\u032d\u032e\7u\2\2\u032e\u0330\7g\2\2\u032f\u0326\3\2\2"+
		"\2\u032f\u032a\3\2\2\2\u0330\u00b2\3\2\2\2\u0331\u0336\5\t\5\2\u0332\u0335"+
		"\5\13\6\2\u0333\u0335\5\t\5\2\u0334\u0332\3\2\2\2\u0334\u0333\3\2\2\2"+
		"\u0335\u0338\3\2\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u00b4"+
		"\3\2\2\2\u0338\u0336\3\2\2\2\u0339\u033a\7-\2\2\u033a\u033b\7-\2\2\u033b"+
		"\u00b6\3\2\2\2\u033c\u033d\7/\2\2\u033d\u033e\7/\2\2\u033e\u00b8\3\2\2"+
		"\2\u033f\u0340\7(\2\2\u0340\u00ba\3\2\2\2\u0341\u0342\7-\2\2\u0342\u0343"+
		"\7\'\2\2\u0343\u00bc\3\2\2\2\u0344\u0345\7/\2\2\u0345\u0346\7\'\2\2\u0346"+
		"\u00be\3\2\2\2\u0347\u0348\7-\2\2\u0348\u0349\7-\2\2\u0349\u034a\7\'\2"+
		"\2\u034a\u00c0\3\2\2\2\u034b\u034c\7/\2\2\u034c\u034d\7/\2\2\u034d\u034e"+
		"\7\'\2\2\u034e\u00c2\3\2\2\2\u034f\u0350\7>\2\2\u0350\u00c4\3\2\2\2\u0351"+
		"\u0352\7@\2\2\u0352\u00c6\3\2\2\2\u0353\u0354\7>\2\2\u0354\u0355\7?\2"+
		"\2\u0355\u00c8\3\2\2\2\u0356\u0357\7@\2\2\u0357\u0358\7?\2\2\u0358\u00ca"+
		"\3\2\2\2\u0359\u035a\7?\2\2\u035a\u035b\7?\2\2\u035b\u00cc\3\2\2\2\u035c"+
		"\u035d\7#\2\2\u035d\u035e\7?\2\2\u035e\u00ce\3\2\2\2\u035f\u0375\7?\2"+
		"\2\u0360\u0361\7-\2\2\u0361\u0375\7?\2\2\u0362\u0363\7/\2\2\u0363\u0375"+
		"\7?\2\2\u0364\u0365\7,\2\2\u0365\u0375\7?\2\2\u0366\u0367\7\61\2\2\u0367"+
		"\u0375\7?\2\2\u0368\u0369\7\'\2\2\u0369\u0375\7?\2\2\u036a\u036b\7>\2"+
		"\2\u036b\u036c\7>\2\2\u036c\u0375\7?\2\2\u036d\u036e\7@\2\2\u036e\u036f"+
		"\7@\2\2\u036f\u0375\7?\2\2\u0370\u0371\7(\2\2\u0371\u0375\7?\2\2\u0372"+
		"\u0373\7~\2\2\u0373\u0375\7?\2\2\u0374\u035f\3\2\2\2\u0374\u0360\3\2\2"+
		"\2\u0374\u0362\3\2\2\2\u0374\u0364\3\2\2\2\u0374\u0366\3\2\2\2\u0374\u0368"+
		"\3\2\2\2\u0374\u036a\3\2\2\2\u0374\u036d\3\2\2\2\u0374\u0370\3\2\2\2\u0374"+
		"\u0372\3\2\2\2\u0375\u00d0\3\2\2\2\u0376\u0377\7/\2\2\u0377\u00d2\3\2"+
		"\2\2\u0378\u0379\7-\2\2\u0379\u00d4\3\2\2\2\u037a\u037b\7,\2\2\u037b\u00d6"+
		"\3\2\2\2\u037c\u037d\7\61\2\2\u037d\u00d8\3\2\2\2\u037e\u037f\7\'\2\2"+
		"\u037f\u00da\3\2\2\2\u0380\u0381\7*\2\2\u0381\u00dc\3\2\2\2\u0382\u0383"+
		"\7+\2\2\u0383\u00de\3\2\2\2\u0384\u0385\7>\2\2\u0385\u0386\7>\2\2\u0386"+
		"\u00e0\3\2\2\2\u0387\u0388\7@\2\2\u0388\u0389\7@\2\2\u0389\u00e2\3\2\2"+
		"\2\u038a\u038b\7~\2\2\u038b\u038c\7~\2\2\u038c\u00e4\3\2\2\2\u038d\u038e"+
		"\7(\2\2\u038e\u038f\7(\2\2\u038f\u00e6\3\2\2\2\u0390\u0391\7#\2\2\u0391"+
		"\u00e8\3\2\2\2\u0392\u0393\7=\2\2\u0393\u00ea\3\2\2\2\u0394\u0395\7<\2"+
		"\2\u0395\u00ec\3\2\2\2\u0396\u0397\7~\2\2\u0397\u00ee\3\2\2\2\u0398\u0399"+
		"\7}\2\2\u0399\u00f0\3\2\2\2\u039a\u039b\7\177\2\2\u039b\u00f2\3\2\2\2"+
		"\u039c\u039d\7.\2\2\u039d\u00f4\3\2\2\2\u039e\u039f\7\60\2\2\u039f\u00f6"+
		"\3\2\2\2\u03a0\u03a1\7]\2\2\u03a1\u00f8\3\2\2\2\u03a2\u03a3\7_\2\2\u03a3"+
		"\u00fa\3\2\2\2\u03a4\u03a5\7$\2\2\u03a5\u00fc\3\2\2\2\u03a6\u03a7\7A\2"+
		"\2\u03a7\u00fe\3\2\2\2\u03a8\u03ac\7$\2\2\u03a9\u03ab\n\7\2\2\u03aa\u03a9"+
		"\3\2\2\2\u03ab\u03ae\3\2\2\2\u03ac\u03aa\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad"+
		"\u03af\3\2\2\2\u03ae\u03ac\3\2\2\2\u03af\u03b0\7$\2\2\u03b0\u0100\3\2"+
		"\2\2\16\2\u0104\u010e\u011c\u0319\u031e\u0324\u032f\u0334\u0336\u0374"+
		"\u03ac\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
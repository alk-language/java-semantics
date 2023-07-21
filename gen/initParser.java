// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkInit.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class initParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, ASSERT=4, ASSUME=5, SYMBOLIC=6, INVARIANT=7, 
		REQURIES=8, ENSURES=9, LOOPASSESRT=10, WHILEMODIFIES=11, RESULT=12, OLD=13, 
		IMPLIES=14, EQUIV=15, FORALL=16, EXISTS=17, QUANTIFIER_SEPARATOR=18, TO=19, 
		IF=20, ELSE=21, WHILE=22, DO=23, FOR=24, FOREACH=25, IN=26, FROM=27, OUT=28, 
		HAVOC=29, VAR=30, CHOOSE=31, UNIFORM=32, REPEAT=33, RETURN=34, SUCCESS=35, 
		UNTIL=36, FAILURE=37, CONTINUE=38, BREAK=39, EMPTYARRAY=40, EMPTYMAP=41, 
		EMPTYSET=42, EMPTYLIST=43, EMPTYSTRUCTURE=44, MODIFIES=45, USES=46, INCLDUE=47, 
		XOR=48, ABS=49, ACOS=50, ASIN=51, ATAN=52, COS=53, LOG=54, PI=55, POW=56, 
		SIN=57, SQRT=58, TAN=59, LEN=60, ARRAY=61, LIST=62, SET=63, AT=64, BELONGSTO=65, 
		DELETE=66, EMPTY=67, END=68, FIRST=69, FLOAT=70, INSERT=71, KEYS=72, INTEGER=73, 
		BOOLEAN=74, PRINT=75, POPBACK=76, POPFRONT=77, PUSHBACK=78, PUSHFRONT=79, 
		REMOVE=80, REMOVEALLEQTO=81, REMOVEAT=82, SINGLETONSET=83, SIZE=84, SPLIT=85, 
		TOPBACK=86, TOPFRONT=87, UPDATE=88, UNIFORMNAT=89, FLIP=90, UNIFORMFLOAT=91, 
		UNIFORMPERM=92, SOTHAT=93, SYM=94, ARROW=95, NUMSIGN=96, ANNO=97, COUNT=98, 
		UNION=99, INTERSECT=100, SUBTRACT=101, INT=102, DOUBLE=103, BOOL=104, 
		ID=105, PLUSPLUS=106, MINUSMINUS=107, BITWISE_AND=108, PLUSMOD=109, MINUSMOD=110, 
		PLUSPLUSMOD=111, MINUSMINUSMOD=112, LOWER=113, GREATER=114, LOWEREQ=115, 
		GREATEREQ=116, ISEQUAL=117, NOTEQUAL=118, ASSIGNMENT_OPERATOR=119, MINUS=120, 
		PLUS=121, MUL=122, DIV=123, MOD=124, LPAR=125, RPAR=126, LEFTSHIFT=127, 
		RIGHTSHIFT=128, OR=129, AND=130, NOT=131, SEMICOLON=132, DPOINT=133, VBAR=134, 
		LCB=135, RCB=136, COMMA=137, POINT=138, LBRA=139, RBRA=140, QUOTE=141, 
		QUESTION=142, STRING=143;
	public static final int
		RULE_configuration = 0, RULE_expression = 1, RULE_assign_expression = 2, 
		RULE_conditional_expression = 3, RULE_logical_or_expression = 4, RULE_logical_and_expression = 5, 
		RULE_in_expression = 6, RULE_equality_expression = 7, RULE_relational_expression = 8, 
		RULE_set_expression = 9, RULE_bitwise_or = 10, RULE_bitwise_and = 11, 
		RULE_shift_expression = 12, RULE_additive_expression = 13, RULE_multiplicative_expression = 14, 
		RULE_unary_expression = 15, RULE_postfix_expression = 16, RULE_factor = 17, 
		RULE_base_factor = 18, RULE_anno = 19, RULE_value = 20, RULE_scalar_value = 21, 
		RULE_ref_name = 22, RULE_data_structure = 23, RULE_interval = 24, RULE_spec = 25, 
		RULE_component = 26, RULE_mapping_component = 27, RULE_array = 28, RULE_list = 29, 
		RULE_mapping = 30, RULE_structure = 31, RULE_set = 32, RULE_function_call = 33, 
		RULE_builtin_function = 34, RULE_builtin_method = 35, RULE_dataType = 36, 
		RULE_function_name = 37, RULE_method_name = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"configuration", "expression", "assign_expression", "conditional_expression", 
			"logical_or_expression", "logical_and_expression", "in_expression", "equality_expression", 
			"relational_expression", "set_expression", "bitwise_or", "bitwise_and", 
			"shift_expression", "additive_expression", "multiplicative_expression", 
			"unary_expression", "postfix_expression", "factor", "base_factor", "anno", 
			"value", "scalar_value", "ref_name", "data_structure", "interval", "spec", 
			"component", "mapping_component", "array", "list", "mapping", "structure", 
			"set", "function_call", "builtin_function", "builtin_method", "dataType", 
			"function_name", "method_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'@assert'", "'@assume'", "'@symbolic'", "'@invariant'", 
			"'@requires'", "'@ensures'", "'@loopassert'", "'@modifies'", "'\\result'", 
			"'\\old'", "'==>'", "'<==>'", "'forall'", "'exists'", "'::'", "'|->'", 
			"'if'", "'else'", "'while'", "'do'", "'for'", "'foreach'", "'in'", "'from'", 
			"'out'", "'@havoc'", "'@var'", "'choose'", "'uniform'", "'repeat'", "'return'", 
			"'success'", "'until'", "'failure'", "'continue'", "'break'", "'emptyArray'", 
			"'emptyMap'", "'emptySet'", "'emptyList'", "'emptyStructure'", "'modifies'", 
			"'uses'", "'include'", "'xor'", "'abs'", "'acos'", "'asin'", "'atan'", 
			"'cos'", "'log'", "'pi'", "'pow'", "'sin'", "'sqrt'", "'tan'", "'len'", 
			"'array'", "'list'", "'set'", "'at'", "'belongsTo'", "'delete'", "'empty'", 
			"'end'", "'first'", "'float'", "'insert'", "'keys'", "'int'", "'boolean'", 
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
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LINE_COMMENT", "ASSERT", "ASSUME", "SYMBOLIC", 
			"INVARIANT", "REQURIES", "ENSURES", "LOOPASSESRT", "WHILEMODIFIES", "RESULT", 
			"OLD", "IMPLIES", "EQUIV", "FORALL", "EXISTS", "QUANTIFIER_SEPARATOR", 
			"TO", "IF", "ELSE", "WHILE", "DO", "FOR", "FOREACH", "IN", "FROM", "OUT", 
			"HAVOC", "VAR", "CHOOSE", "UNIFORM", "REPEAT", "RETURN", "SUCCESS", "UNTIL", 
			"FAILURE", "CONTINUE", "BREAK", "EMPTYARRAY", "EMPTYMAP", "EMPTYSET", 
			"EMPTYLIST", "EMPTYSTRUCTURE", "MODIFIES", "USES", "INCLDUE", "XOR", 
			"ABS", "ACOS", "ASIN", "ATAN", "COS", "LOG", "PI", "POW", "SIN", "SQRT", 
			"TAN", "LEN", "ARRAY", "LIST", "SET", "AT", "BELONGSTO", "DELETE", "EMPTY", 
			"END", "FIRST", "FLOAT", "INSERT", "KEYS", "INTEGER", "BOOLEAN", "PRINT", 
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
	public String getGrammarFileName() { return "AlkInit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public initParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ConfigurationContext extends ParserRuleContext {
		public ConfigurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_configuration; }
	 
		public ConfigurationContext() { }
		public void copyFrom(ConfigurationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConfigContext extends ConfigurationContext {
		public TerminalNode EOF() { return getToken(initParser.EOF, 0); }
		public List<TerminalNode> ID() { return getTokens(initParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(initParser.ID, i);
		}
		public List<TerminalNode> TO() { return getTokens(initParser.TO); }
		public TerminalNode TO(int i) {
			return getToken(initParser.TO, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConfigContext(ConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterConfig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitConfig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitConfig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigurationContext configuration() throws RecognitionException {
		ConfigurationContext _localctx = new ConfigurationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_configuration);
		int _la;
		try {
			_localctx = new ConfigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(78);
				match(ID);
				setState(79);
				match(TO);
				setState(80);
				expression();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ImpliesExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public TerminalNode IMPLIES() { return getToken(initParser.IMPLIES, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ImpliesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterImpliesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitImpliesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitImpliesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquivExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public TerminalNode EQUIV() { return getToken(initParser.EQUIV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EquivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEquivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEquivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEquivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForallExprContext extends ExpressionContext {
		public TerminalNode FORALL() { return getToken(initParser.FORALL, 0); }
		public TerminalNode QUANTIFIER_SEPARATOR() { return getToken(initParser.QUANTIFIER_SEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(initParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(initParser.ID, i);
		}
		public List<TerminalNode> DPOINT() { return getTokens(initParser.DPOINT); }
		public TerminalNode DPOINT(int i) {
			return getToken(initParser.DPOINT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public ForallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterForallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitForallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitForallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FolToExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public FolToExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFolToExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFolToExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFolToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsExprContext extends ExpressionContext {
		public TerminalNode EXISTS() { return getToken(initParser.EXISTS, 0); }
		public TerminalNode QUANTIFIER_SEPARATOR() { return getToken(initParser.QUANTIFIER_SEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(initParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(initParser.ID, i);
		}
		public List<TerminalNode> DPOINT() { return getTokens(initParser.DPOINT); }
		public TerminalNode DPOINT(int i) {
			return getToken(initParser.DPOINT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public ExistsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterExistsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitExistsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitExistsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ImpliesExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				assign_expression();
				setState(89);
				match(IMPLIES);
				setState(90);
				expression();
				}
				break;
			case 2:
				_localctx = new EquivExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				assign_expression();
				setState(93);
				match(EQUIV);
				setState(94);
				expression();
				}
				break;
			case 3:
				_localctx = new ForallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(FORALL);
				{
				setState(97);
				match(ID);
				setState(98);
				match(DPOINT);
				setState(99);
				dataType();
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(100);
					match(COMMA);
					setState(101);
					match(ID);
					setState(102);
					match(DPOINT);
					setState(103);
					dataType();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(109);
				match(QUANTIFIER_SEPARATOR);
				setState(110);
				expression();
				}
				break;
			case 4:
				_localctx = new ExistsExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(EXISTS);
				{
				setState(113);
				match(ID);
				setState(114);
				match(DPOINT);
				setState(115);
				dataType();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(116);
					match(COMMA);
					setState(117);
					match(ID);
					setState(118);
					match(DPOINT);
					setState(119);
					dataType();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(125);
				match(QUANTIFIER_SEPARATOR);
				setState(126);
				expression();
				}
				break;
			case 5:
				_localctx = new FolToExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				assign_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_expressionContext extends ParserRuleContext {
		public Assign_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expression; }
	 
		public Assign_expressionContext() { }
		public void copyFrom(Assign_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignExpressionContext extends Assign_expressionContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(initParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignExpressionContext(Assign_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitAssignExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToConditionalExprContext extends Assign_expressionContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ToConditionalExprContext(Assign_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterToConditionalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitToConditionalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitToConditionalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_expressionContext assign_expression() throws RecognitionException {
		Assign_expressionContext _localctx = new Assign_expressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assign_expression);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AssignExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				factor(0);
				setState(132);
				match(ASSIGNMENT_OPERATOR);
				setState(133);
				expression();
				}
				break;
			case 2:
				_localctx = new ToConditionalExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				conditional_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
	 
		public Conditional_expressionContext() { }
		public void copyFrom(Conditional_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionalExpressionContext extends Conditional_expressionContext {
		public Logical_or_expressionContext logical_or_expression() {
			return getRuleContext(Logical_or_expressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(initParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DPOINT() { return getToken(initParser.DPOINT, 0); }
		public ConditionalExpressionContext(Conditional_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conditional_expression);
		try {
			_localctx = new ConditionalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			logical_or_expression();
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(139);
				match(QUESTION);
				setState(140);
				expression();
				setState(141);
				match(DPOINT);
				setState(142);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_or_expressionContext extends ParserRuleContext {
		public Logical_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expression; }
	 
		public Logical_or_expressionContext() { }
		public void copyFrom(Logical_or_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalOrExpressionContext extends Logical_or_expressionContext {
		public List<Logical_and_expressionContext> logical_and_expression() {
			return getRuleContexts(Logical_and_expressionContext.class);
		}
		public Logical_and_expressionContext logical_and_expression(int i) {
			return getRuleContext(Logical_and_expressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(initParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(initParser.OR, i);
		}
		public LogicalOrExpressionContext(Logical_or_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitLogicalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_expressionContext logical_or_expression() throws RecognitionException {
		Logical_or_expressionContext _localctx = new Logical_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logical_or_expression);
		int _la;
		try {
			_localctx = new LogicalOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			logical_and_expression();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(147);
				match(OR);
				setState(148);
				logical_and_expression();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_and_expressionContext extends ParserRuleContext {
		public Logical_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expression; }
	 
		public Logical_and_expressionContext() { }
		public void copyFrom(Logical_and_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalAndExpressionContext extends Logical_and_expressionContext {
		public List<In_expressionContext> in_expression() {
			return getRuleContexts(In_expressionContext.class);
		}
		public In_expressionContext in_expression(int i) {
			return getRuleContext(In_expressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(initParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(initParser.AND, i);
		}
		public LogicalAndExpressionContext(Logical_and_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitLogicalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_expressionContext logical_and_expression() throws RecognitionException {
		Logical_and_expressionContext _localctx = new Logical_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logical_and_expression);
		int _la;
		try {
			_localctx = new LogicalAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			in_expression();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(155);
				match(AND);
				setState(156);
				in_expression();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class In_expressionContext extends ParserRuleContext {
		public In_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_expression; }
	 
		public In_expressionContext() { }
		public void copyFrom(In_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InExpressionContext extends In_expressionContext {
		public List<Equality_expressionContext> equality_expression() {
			return getRuleContexts(Equality_expressionContext.class);
		}
		public Equality_expressionContext equality_expression(int i) {
			return getRuleContext(Equality_expressionContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(initParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(initParser.IN, i);
		}
		public InExpressionContext(In_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterInExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitInExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitInExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_expressionContext in_expression() throws RecognitionException {
		In_expressionContext _localctx = new In_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_in_expression);
		int _la;
		try {
			_localctx = new InExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			equality_expression();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN) {
				{
				{
				setState(163);
				match(IN);
				setState(164);
				equality_expression();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
	 
		public Equality_expressionContext() { }
		public void copyFrom(Equality_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualityExpressionContext extends Equality_expressionContext {
		public List<Relational_expressionContext> relational_expression() {
			return getRuleContexts(Relational_expressionContext.class);
		}
		public Relational_expressionContext relational_expression(int i) {
			return getRuleContext(Relational_expressionContext.class,i);
		}
		public List<TerminalNode> ISEQUAL() { return getTokens(initParser.ISEQUAL); }
		public TerminalNode ISEQUAL(int i) {
			return getToken(initParser.ISEQUAL, i);
		}
		public List<TerminalNode> NOTEQUAL() { return getTokens(initParser.NOTEQUAL); }
		public TerminalNode NOTEQUAL(int i) {
			return getToken(initParser.NOTEQUAL, i);
		}
		public EqualityExpressionContext(Equality_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_equality_expression);
		int _la;
		try {
			_localctx = new EqualityExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			relational_expression();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ISEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(171);
				_la = _input.LA(1);
				if ( !(_la==ISEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(172);
				relational_expression();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Relational_expressionContext extends ParserRuleContext {
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
	 
		public Relational_expressionContext() { }
		public void copyFrom(Relational_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationalExpressionContext extends Relational_expressionContext {
		public List<Set_expressionContext> set_expression() {
			return getRuleContexts(Set_expressionContext.class);
		}
		public Set_expressionContext set_expression(int i) {
			return getRuleContext(Set_expressionContext.class,i);
		}
		public List<TerminalNode> LOWER() { return getTokens(initParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(initParser.LOWER, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(initParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(initParser.GREATER, i);
		}
		public List<TerminalNode> LOWEREQ() { return getTokens(initParser.LOWEREQ); }
		public TerminalNode LOWEREQ(int i) {
			return getToken(initParser.LOWEREQ, i);
		}
		public List<TerminalNode> GREATEREQ() { return getTokens(initParser.GREATEREQ); }
		public TerminalNode GREATEREQ(int i) {
			return getToken(initParser.GREATEREQ, i);
		}
		public RelationalExpressionContext(Relational_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relational_expression);
		int _la;
		try {
			int _alt;
			_localctx = new RelationalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			set_expression();
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					_la = _input.LA(1);
					if ( !(((((_la - 113)) & ~0x3f) == 0 && ((1L << (_la - 113)) & ((1L << (LOWER - 113)) | (1L << (GREATER - 113)) | (1L << (LOWEREQ - 113)) | (1L << (GREATEREQ - 113)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(180);
					set_expression();
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_expressionContext extends ParserRuleContext {
		public Set_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_expression; }
	 
		public Set_expressionContext() { }
		public void copyFrom(Set_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetExpressionContext extends Set_expressionContext {
		public List<Bitwise_orContext> bitwise_or() {
			return getRuleContexts(Bitwise_orContext.class);
		}
		public Bitwise_orContext bitwise_or(int i) {
			return getRuleContext(Bitwise_orContext.class,i);
		}
		public List<TerminalNode> UNION() { return getTokens(initParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(initParser.UNION, i);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(initParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(initParser.INTERSECT, i);
		}
		public List<TerminalNode> SUBTRACT() { return getTokens(initParser.SUBTRACT); }
		public TerminalNode SUBTRACT(int i) {
			return getToken(initParser.SUBTRACT, i);
		}
		public SetExpressionContext(Set_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_expressionContext set_expression() throws RecognitionException {
		Set_expressionContext _localctx = new Set_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_set_expression);
		int _la;
		try {
			_localctx = new SetExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			bitwise_or();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (UNION - 99)) | (1L << (INTERSECT - 99)) | (1L << (SUBTRACT - 99)))) != 0)) {
				{
				{
				setState(187);
				_la = _input.LA(1);
				if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & ((1L << (UNION - 99)) | (1L << (INTERSECT - 99)) | (1L << (SUBTRACT - 99)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				bitwise_or();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitwise_orContext extends ParserRuleContext {
		public Bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or; }
	 
		public Bitwise_orContext() { }
		public void copyFrom(Bitwise_orContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BitwiseOrExpressionContext extends Bitwise_orContext {
		public List<Bitwise_andContext> bitwise_and() {
			return getRuleContexts(Bitwise_andContext.class);
		}
		public Bitwise_andContext bitwise_and(int i) {
			return getRuleContext(Bitwise_andContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(initParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(initParser.VBAR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(initParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(initParser.XOR, i);
		}
		public BitwiseOrExpressionContext(Bitwise_orContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBitwiseOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBitwiseOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBitwiseOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_orContext bitwise_or() throws RecognitionException {
		Bitwise_orContext _localctx = new Bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bitwise_or);
		int _la;
		try {
			int _alt;
			_localctx = new BitwiseOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			bitwise_and();
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(195);
					_la = _input.LA(1);
					if ( !(_la==XOR || _la==VBAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(196);
					bitwise_and();
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bitwise_andContext extends ParserRuleContext {
		public Bitwise_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and; }
	 
		public Bitwise_andContext() { }
		public void copyFrom(Bitwise_andContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BitwiseAndExpressionContext extends Bitwise_andContext {
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
		}
		public List<TerminalNode> BITWISE_AND() { return getTokens(initParser.BITWISE_AND); }
		public TerminalNode BITWISE_AND(int i) {
			return getToken(initParser.BITWISE_AND, i);
		}
		public BitwiseAndExpressionContext(Bitwise_andContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBitwiseAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBitwiseAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBitwiseAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_andContext bitwise_and() throws RecognitionException {
		Bitwise_andContext _localctx = new Bitwise_andContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bitwise_and);
		int _la;
		try {
			_localctx = new BitwiseAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			shift_expression();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_AND) {
				{
				{
				setState(203);
				match(BITWISE_AND);
				setState(204);
				shift_expression();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_expressionContext extends ParserRuleContext {
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
	 
		public Shift_expressionContext() { }
		public void copyFrom(Shift_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShiftExpressionContext extends Shift_expressionContext {
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
		}
		public List<TerminalNode> LEFTSHIFT() { return getTokens(initParser.LEFTSHIFT); }
		public TerminalNode LEFTSHIFT(int i) {
			return getToken(initParser.LEFTSHIFT, i);
		}
		public List<TerminalNode> RIGHTSHIFT() { return getTokens(initParser.RIGHTSHIFT); }
		public TerminalNode RIGHTSHIFT(int i) {
			return getToken(initParser.RIGHTSHIFT, i);
		}
		public ShiftExpressionContext(Shift_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_shift_expression);
		int _la;
		try {
			_localctx = new ShiftExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			additive_expression();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTSHIFT || _la==RIGHTSHIFT) {
				{
				{
				setState(211);
				_la = _input.LA(1);
				if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(212);
				additive_expression();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Additive_expressionContext extends ParserRuleContext {
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
	 
		public Additive_expressionContext() { }
		public void copyFrom(Additive_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AdditiveExpressionContext extends Additive_expressionContext {
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
		}
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(initParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(initParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(initParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(initParser.MINUS, i);
		}
		public List<TerminalNode> PLUSMOD() { return getTokens(initParser.PLUSMOD); }
		public TerminalNode PLUSMOD(int i) {
			return getToken(initParser.PLUSMOD, i);
		}
		public List<TerminalNode> MINUSMOD() { return getTokens(initParser.MINUSMOD); }
		public TerminalNode MINUSMOD(int i) {
			return getToken(initParser.MINUSMOD, i);
		}
		public AdditiveExpressionContext(Additive_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_additive_expression);
		int _la;
		try {
			int _alt;
			_localctx = new AdditiveExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			multiplicative_expression();
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(219);
					_la = _input.LA(1);
					if ( !(((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & ((1L << (PLUSMOD - 109)) | (1L << (MINUSMOD - 109)) | (1L << (MINUS - 109)) | (1L << (PLUS - 109)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(220);
					multiplicative_expression();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
	 
		public Multiplicative_expressionContext() { }
		public void copyFrom(Multiplicative_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicativeExpressionContext extends Multiplicative_expressionContext {
		public List<Unary_expressionContext> unary_expression() {
			return getRuleContexts(Unary_expressionContext.class);
		}
		public Unary_expressionContext unary_expression(int i) {
			return getRuleContext(Unary_expressionContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(initParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(initParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(initParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(initParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(initParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(initParser.MOD, i);
		}
		public MultiplicativeExpressionContext(Multiplicative_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiplicative_expression);
		int _la;
		try {
			int _alt;
			_localctx = new MultiplicativeExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			unary_expression();
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(227);
					_la = _input.LA(1);
					if ( !(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & ((1L << (MUL - 122)) | (1L << (DIV - 122)) | (1L << (MOD - 122)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(228);
					unary_expression();
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_expressionContext extends ParserRuleContext {
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	 
		public Unary_expressionContext() { }
		public void copyFrom(Unary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToPostfixExpressionContext extends Unary_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public ToPostfixExpressionContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterToPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitToPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitToPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpressionContext extends Unary_expressionContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(initParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(initParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(initParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(initParser.MINUSMINUSMOD, 0); }
		public PrefixExpressionContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitPrefixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionContext extends Unary_expressionContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(initParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(initParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(initParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(initParser.NOT, 0); }
		public UnaryExpressionContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_expression);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUSPLUSMOD:
			case MINUSMINUSMOD:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				_la = _input.LA(1);
				if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (PLUSPLUS - 106)) | (1L << (MINUSMINUS - 106)) | (1L << (PLUSPLUSMOD - 106)) | (1L << (MINUSMINUSMOD - 106)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(235);
				unary_expression();
				}
				break;
			case MINUS:
			case PLUS:
			case MUL:
			case NOT:
				_localctx = new UnaryExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				_la = _input.LA(1);
				if ( !(((((_la - 120)) & ~0x3f) == 0 && ((1L << (_la - 120)) & ((1L << (MINUS - 120)) | (1L << (PLUS - 120)) | (1L << (MUL - 120)) | (1L << (NOT - 120)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				unary_expression();
				}
				break;
			case RESULT:
			case OLD:
			case EMPTYARRAY:
			case EMPTYMAP:
			case EMPTYSET:
			case EMPTYLIST:
			case EMPTYSTRUCTURE:
			case ABS:
			case ACOS:
			case ASIN:
			case ATAN:
			case COS:
			case LOG:
			case PI:
			case POW:
			case SIN:
			case SQRT:
			case TAN:
			case LEN:
			case FLOAT:
			case INTEGER:
			case PRINT:
			case SINGLETONSET:
			case UNIFORMNAT:
			case FLIP:
			case UNIFORMFLOAT:
			case UNIFORMPERM:
			case SYM:
			case ANNO:
			case INT:
			case DOUBLE:
			case BOOL:
			case ID:
			case LOWER:
			case LPAR:
			case LCB:
			case LBRA:
			case QUESTION:
			case STRING:
				_localctx = new ToPostfixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				postfix_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	 
		public Postfix_expressionContext() { }
		public void copyFrom(Postfix_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixExpressionContext extends Postfix_expressionContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<TerminalNode> PLUSPLUS() { return getTokens(initParser.PLUSPLUS); }
		public TerminalNode PLUSPLUS(int i) {
			return getToken(initParser.PLUSPLUS, i);
		}
		public List<TerminalNode> MINUSMINUS() { return getTokens(initParser.MINUSMINUS); }
		public TerminalNode MINUSMINUS(int i) {
			return getToken(initParser.MINUSMINUS, i);
		}
		public PostfixExpressionContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_postfix_expression);
		int _la;
		try {
			int _alt;
			_localctx = new PostfixExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			factor(0);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(242);
					_la = _input.LA(1);
					if ( !(_la==PLUSPLUS || _la==MINUSMINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactorPointIDContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode POINT() { return getToken(initParser.POINT, 0); }
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public FactorPointIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFactorPointID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFactorPointID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFactorPointID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorArrayContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode LBRA() { return getToken(initParser.LBRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(initParser.RBRA, 0); }
		public FactorArrayContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFactorArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFactorArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFactorArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToBaseFactorContext extends FactorContext {
		public Base_factorContext base_factor() {
			return getRuleContext(Base_factorContext.class,0);
		}
		public ToBaseFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterToBaseFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitToBaseFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitToBaseFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorPointMethodContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode POINT() { return getToken(initParser.POINT, 0); }
		public Builtin_methodContext builtin_method() {
			return getRuleContext(Builtin_methodContext.class,0);
		}
		public FactorPointMethodContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFactorPointMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFactorPointMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFactorPointMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToBaseFactorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(249);
			base_factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new FactorPointMethodContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(251);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(252);
						match(POINT);
						setState(253);
						builtin_method();
						}
						break;
					case 2:
						{
						_localctx = new FactorPointIDContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(254);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(255);
						match(POINT);
						setState(256);
						match(ID);
						}
						break;
					case 3:
						{
						_localctx = new FactorArrayContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(257);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(258);
						match(LBRA);
						setState(259);
						expression();
						setState(260);
						match(RBRA);
						}
						break;
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Base_factorContext extends ParserRuleContext {
		public Base_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_factor; }
	 
		public Base_factorContext() { }
		public void copyFrom(Base_factorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OldFactorContext extends Base_factorContext {
		public TerminalNode OLD() { return getToken(initParser.OLD, 0); }
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public OldFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterOldFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitOldFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitOldFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnnoFactorContext extends Base_factorContext {
		public TerminalNode ANNO() { return getToken(initParser.ANNO, 0); }
		public AnnoContext anno() {
			return getRuleContext(AnnoContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public AnnoFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterAnnoFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitAnnoFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitAnnoFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefNameFactorContext extends Base_factorContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public RefNameFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterRefNameFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitRefNameFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitRefNameFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ResultFactorContext extends Base_factorContext {
		public TerminalNode RESULT() { return getToken(initParser.RESULT, 0); }
		public ResultFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterResultFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitResultFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitResultFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanthesesFactorContext extends Base_factorContext {
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public ParanthesesFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterParanthesesFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitParanthesesFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitParanthesesFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueFactorContext extends Base_factorContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterValueFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitValueFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitValueFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_factorContext base_factor() throws RecognitionException {
		Base_factorContext _localctx = new Base_factorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_base_factor);
		try {
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RESULT:
				_localctx = new ResultFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(RESULT);
				}
				break;
			case OLD:
				_localctx = new OldFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(OLD);
				setState(269);
				match(LPAR);
				setState(270);
				match(ID);
				setState(271);
				match(RPAR);
				}
				break;
			case ABS:
			case ACOS:
			case ASIN:
			case ATAN:
			case COS:
			case LOG:
			case PI:
			case POW:
			case SIN:
			case SQRT:
			case TAN:
			case LEN:
			case FLOAT:
			case INTEGER:
			case PRINT:
			case SINGLETONSET:
			case UNIFORMNAT:
			case FLIP:
			case UNIFORMFLOAT:
			case UNIFORMPERM:
			case SYM:
			case ID:
				_localctx = new RefNameFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				ref_name();
				}
				break;
			case EMPTYARRAY:
			case EMPTYMAP:
			case EMPTYSET:
			case EMPTYLIST:
			case EMPTYSTRUCTURE:
			case INT:
			case DOUBLE:
			case BOOL:
			case LOWER:
			case LCB:
			case LBRA:
			case QUESTION:
			case STRING:
				_localctx = new ValueFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(273);
				value();
				}
				break;
			case LPAR:
				_localctx = new ParanthesesFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				match(LPAR);
				setState(275);
				expression();
				setState(276);
				match(RPAR);
				}
				break;
			case ANNO:
				_localctx = new AnnoFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(278);
				match(ANNO);
				setState(279);
				anno();
				setState(280);
				match(LPAR);
				setState(281);
				expression();
				setState(282);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnoContext extends ParserRuleContext {
		public AnnoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anno; }
	 
		public AnnoContext() { }
		public void copyFrom(AnnoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CountAnnoContext extends AnnoContext {
		public TerminalNode COUNT() { return getToken(initParser.COUNT, 0); }
		public CountAnnoContext(AnnoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterCountAnno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitCountAnno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitCountAnno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnoContext anno() throws RecognitionException {
		AnnoContext _localctx = new AnnoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_anno);
		try {
			_localctx = new CountAnnoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(COUNT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Scalar_valueContext scalar_value() {
			return getRuleContext(Scalar_valueContext.class,0);
		}
		public Data_structureContext data_structure() {
			return getRuleContext(Data_structureContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case BOOL:
			case QUESTION:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				scalar_value();
				}
				break;
			case EMPTYARRAY:
			case EMPTYMAP:
			case EMPTYSET:
			case EMPTYLIST:
			case EMPTYSTRUCTURE:
			case LOWER:
			case LCB:
			case LBRA:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				data_structure();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_valueContext extends ParserRuleContext {
		public Scalar_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_value; }
	 
		public Scalar_valueContext() { }
		public void copyFrom(Scalar_valueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoubleValueContext extends Scalar_valueContext {
		public TerminalNode DOUBLE() { return getToken(initParser.DOUBLE, 0); }
		public DoubleValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterDoubleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitDoubleValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitDoubleValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnknownValueContext extends Scalar_valueContext {
		public TerminalNode QUESTION() { return getToken(initParser.QUESTION, 0); }
		public UnknownValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterUnknownValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitUnknownValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitUnknownValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValueContext extends Scalar_valueContext {
		public TerminalNode BOOL() { return getToken(initParser.BOOL, 0); }
		public BoolValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValueContext extends Scalar_valueContext {
		public TerminalNode STRING() { return getToken(initParser.STRING, 0); }
		public StringValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValueContext extends Scalar_valueContext {
		public TerminalNode INT() { return getToken(initParser.INT, 0); }
		public IntValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitIntValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_valueContext scalar_value() throws RecognitionException {
		Scalar_valueContext _localctx = new Scalar_valueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_scalar_value);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(DOUBLE);
				}
				break;
			case BOOL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(295);
				match(STRING);
				}
				break;
			case QUESTION:
				_localctx = new UnknownValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(296);
				match(QUESTION);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ref_nameContext extends ParserRuleContext {
		public Ref_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name; }
	 
		public Ref_nameContext() { }
		public void copyFrom(Ref_nameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RefFunctionCallContext extends Ref_nameContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public RefFunctionCallContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterRefFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitRefFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitRefFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymIDContext extends Ref_nameContext {
		public TerminalNode SYM() { return getToken(initParser.SYM, 0); }
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public SymIDContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSymID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSymID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSymID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefIDContext extends Ref_nameContext {
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public RefIDContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterRefID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitRefID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitRefID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_nameContext ref_name() throws RecognitionException {
		Ref_nameContext _localctx = new Ref_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ref_name);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new RefFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				function_call();
				}
				break;
			case 2:
				_localctx = new RefIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(ID);
				}
				break;
			case 3:
				_localctx = new SymIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				match(SYM);
				setState(302);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_structureContext extends ParserRuleContext {
		public Data_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_structure; }
	 
		public Data_structureContext() { }
		public void copyFrom(Data_structureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ListValueContext extends Data_structureContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterListValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitListValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructureValueContext extends Data_structureContext {
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public StructureValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterStructureValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitStructureValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitStructureValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueContext extends Data_structureContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MappingValueContext extends Data_structureContext {
		public MappingContext mapping() {
			return getRuleContext(MappingContext.class,0);
		}
		public MappingValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterMappingValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitMappingValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitMappingValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetValueContext extends Data_structureContext {
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public SetValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_structureContext data_structure() throws RecognitionException {
		Data_structureContext _localctx = new Data_structureContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_data_structure);
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				array();
				}
				break;
			case 2:
				_localctx = new ListValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				list();
				}
				break;
			case 3:
				_localctx = new MappingValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				mapping();
				}
				break;
			case 4:
				_localctx = new SetValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				set();
				}
				break;
			case 5:
				_localctx = new StructureValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(309);
				structure();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
	 
		public IntervalContext() { }
		public void copyFrom(IntervalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntervalDefinitionContext extends IntervalContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> POINT() { return getTokens(initParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(initParser.POINT, i);
		}
		public IntervalDefinitionContext(IntervalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterIntervalDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitIntervalDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitIntervalDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_interval);
		try {
			_localctx = new IntervalDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			expression();
			setState(313);
			match(POINT);
			setState(314);
			match(POINT);
			setState(315);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecContext extends ParserRuleContext {
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
	 
		public SpecContext() { }
		public void copyFrom(SpecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FilterSpecDefinitionContext extends SpecContext {
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public TerminalNode FROM() { return getToken(initParser.FROM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode VBAR() { return getToken(initParser.VBAR, 0); }
		public FilterSpecDefinitionContext(SpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFilterSpecDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFilterSpecDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFilterSpecDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectSpecDefinitionContext extends SpecContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode VBAR() { return getToken(initParser.VBAR, 0); }
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public TerminalNode FROM() { return getToken(initParser.FROM, 0); }
		public SelectSpecDefinitionContext(SpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSelectSpecDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSelectSpecDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSelectSpecDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_spec);
		try {
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new FilterSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(ID);
				setState(318);
				match(FROM);
				setState(319);
				expression();
				setState(320);
				match(VBAR);
				setState(321);
				expression();
				}
				break;
			case 2:
				_localctx = new SelectSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				expression();
				setState(324);
				match(VBAR);
				setState(325);
				match(ID);
				setState(326);
				match(FROM);
				setState(327);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentContext extends ParserRuleContext {
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
	 
		public ComponentContext() { }
		public void copyFrom(ComponentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComponentDefinitionContext extends ComponentContext {
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(initParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComponentDefinitionContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterComponentDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitComponentDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitComponentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_component);
		try {
			_localctx = new ComponentDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(ID);
			setState(332);
			match(ARROW);
			setState(333);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mapping_componentContext extends ParserRuleContext {
		public Mapping_componentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_component; }
	 
		public Mapping_componentContext() { }
		public void copyFrom(Mapping_componentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MappingComponentDefinitionContext extends Mapping_componentContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TO() { return getToken(initParser.TO, 0); }
		public MappingComponentDefinitionContext(Mapping_componentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterMappingComponentDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitMappingComponentDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitMappingComponentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mapping_componentContext mapping_component() throws RecognitionException {
		Mapping_componentContext _localctx = new Mapping_componentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mapping_component);
		try {
			_localctx = new MappingComponentDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			expression();
			setState(336);
			match(TO);
			setState(337);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	 
		public ArrayContext() { }
		public void copyFrom(ArrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayWithSpecContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(initParser.LBRA, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(initParser.RBRA, 0); }
		public ArrayWithSpecContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterArrayWithSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitArrayWithSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitArrayWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithExpressionsContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(initParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(initParser.RBRA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public ArrayWithExpressionsContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterArrayWithExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitArrayWithExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitArrayWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyArrayContext extends ArrayContext {
		public TerminalNode EMPTYARRAY() { return getToken(initParser.EMPTYARRAY, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public EmptyArrayContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEmptyArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEmptyArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEmptyArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithIntervalContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(initParser.LBRA, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(initParser.RBRA, 0); }
		public ArrayWithIntervalContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterArrayWithInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitArrayWithInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitArrayWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_array);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new EmptyArrayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(EMPTYARRAY);
				setState(344);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(340);
					match(LOWER);
					setState(341);
					dataType();
					setState(342);
					match(GREATER);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new ArrayWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(LBRA);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(347);
					expression();
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(348);
						match(COMMA);
						setState(349);
						expression();
						}
						}
						setState(354);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(357);
				match(RBRA);
				}
				break;
			case 3:
				_localctx = new ArrayWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				match(LBRA);
				setState(359);
				interval();
				setState(360);
				match(RBRA);
				}
				break;
			case 4:
				_localctx = new ArrayWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(362);
				match(LBRA);
				setState(363);
				spec();
				setState(364);
				match(RBRA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
	 
		public ListContext() { }
		public void copyFrom(ListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyListContext extends ListContext {
		public TerminalNode EMPTYLIST() { return getToken(initParser.EMPTYLIST, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public EmptyListContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEmptyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEmptyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEmptyList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithIntervalContext extends ListContext {
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public ListWithIntervalContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterListWithInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitListWithInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitListWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithExpressionsContext extends ListContext {
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public ListWithExpressionsContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterListWithExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitListWithExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitListWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithSpecContext extends ListContext {
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public ListWithSpecContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterListWithSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitListWithSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitListWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_list);
		int _la;
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new EmptyListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(EMPTYLIST);
				setState(373);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(369);
					match(LOWER);
					setState(370);
					dataType();
					setState(371);
					match(GREATER);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new ListWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				match(LOWER);
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(376);
					expression();
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(377);
						match(COMMA);
						setState(378);
						expression();
						}
						}
						setState(383);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(386);
				match(GREATER);
				}
				break;
			case 3:
				_localctx = new ListWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
				match(LOWER);
				setState(388);
				interval();
				setState(389);
				match(GREATER);
				}
				break;
			case 4:
				_localctx = new ListWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(391);
				match(LOWER);
				setState(392);
				spec();
				setState(393);
				match(GREATER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MappingContext extends ParserRuleContext {
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
	 
		public MappingContext() { }
		public void copyFrom(MappingContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MappingWithComponentsContext extends MappingContext {
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public List<Mapping_componentContext> mapping_component() {
			return getRuleContexts(Mapping_componentContext.class);
		}
		public Mapping_componentContext mapping_component(int i) {
			return getRuleContext(Mapping_componentContext.class,i);
		}
		public MappingWithComponentsContext(MappingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterMappingWithComponents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitMappingWithComponents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitMappingWithComponents(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyMappingContext extends MappingContext {
		public TerminalNode EMPTYMAP() { return getToken(initParser.EMPTYMAP, 0); }
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public TerminalNode TO() { return getToken(initParser.TO, 0); }
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public EmptyMappingContext(MappingContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEmptyMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEmptyMapping(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEmptyMapping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_mapping);
		int _la;
		try {
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new EmptyMappingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EMPTYMAP:
					{
					setState(397);
					match(EMPTYMAP);
					}
					break;
				case LCB:
					{
					setState(398);
					match(LCB);
					setState(399);
					match(TO);
					setState(400);
					match(RCB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new MappingWithComponentsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				match(LCB);
				setState(405); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(404);
					mapping_component();
					}
					}
					setState(407); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0) );
				setState(409);
				match(RCB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructureContext extends ParserRuleContext {
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
	 
		public StructureContext() { }
		public void copyFrom(StructureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyStructureContext extends StructureContext {
		public TerminalNode EMPTYSTRUCTURE() { return getToken(initParser.EMPTYSTRUCTURE, 0); }
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public TerminalNode ARROW() { return getToken(initParser.ARROW, 0); }
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public EmptyStructureContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEmptyStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEmptyStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEmptyStructure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructureWithComponentsContext extends StructureContext {
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public StructureWithComponentsContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterStructureWithComponents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitStructureWithComponents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitStructureWithComponents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_structure);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new EmptyStructureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EMPTYSTRUCTURE:
					{
					setState(413);
					match(EMPTYSTRUCTURE);
					}
					break;
				case LCB:
					{
					setState(414);
					match(LCB);
					setState(415);
					match(ARROW);
					setState(416);
					match(RCB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new StructureWithComponentsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				match(LCB);
				setState(421); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(420);
					component();
					}
					}
					setState(423); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(425);
				match(RCB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
	 
		public SetContext() { }
		public void copyFrom(SetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SetWithSpeclContext extends SetContext {
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public SetWithSpeclContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetWithSpecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetWithSpecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetWithSpecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetWithIntervaContext extends SetContext {
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public SetWithIntervaContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetWithInterva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetWithInterva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetWithInterva(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptySetContext extends SetContext {
		public TerminalNode EMPTYSET() { return getToken(initParser.EMPTYSET, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public EmptySetContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterEmptySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitEmptySet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitEmptySet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetWithExpressionsContext extends SetContext {
		public TerminalNode LCB() { return getToken(initParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(initParser.RCB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public SetWithExpressionsContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetWithExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetWithExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_set);
		int _la;
		try {
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new EmptySetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				match(EMPTYSET);
				setState(434);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(430);
					match(LOWER);
					setState(431);
					dataType();
					setState(432);
					match(GREATER);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new SetWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				match(LCB);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(437);
					expression();
					setState(442);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(438);
						match(COMMA);
						setState(439);
						expression();
						}
						}
						setState(444);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(447);
				match(RCB);
				}
				break;
			case 3:
				_localctx = new SetWithIntervaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(448);
				match(LCB);
				setState(449);
				interval();
				setState(450);
				match(RCB);
				}
				break;
			case 4:
				_localctx = new SetWithSpeclContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(452);
				match(LCB);
				setState(453);
				spec();
				setState(454);
				match(RCB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_callContext extends ParserRuleContext {
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	 
		public Function_callContext() { }
		public void copyFrom(Function_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefinedFunctionCallContext extends Function_callContext {
		public TerminalNode ID() { return getToken(initParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public DefinedFunctionCallContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterDefinedFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitDefinedFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitDefinedFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToBuiltinFunctionContext extends Function_callContext {
		public Builtin_functionContext builtin_function() {
			return getRuleContext(Builtin_functionContext.class,0);
		}
		public ToBuiltinFunctionContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterToBuiltinFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitToBuiltinFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitToBuiltinFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function_call);
		int _la;
		try {
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABS:
			case ACOS:
			case ASIN:
			case ATAN:
			case COS:
			case LOG:
			case PI:
			case POW:
			case SIN:
			case SQRT:
			case TAN:
			case LEN:
			case FLOAT:
			case INTEGER:
			case PRINT:
			case SINGLETONSET:
			case UNIFORMNAT:
			case FLIP:
			case UNIFORMFLOAT:
			case UNIFORMPERM:
				_localctx = new ToBuiltinFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(458);
				builtin_function();
				}
				break;
			case ID:
				_localctx = new DefinedFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(459);
				match(ID);
				setState(460);
				match(LPAR);
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
					{
					setState(461);
					expression();
					setState(466);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(462);
						match(COMMA);
						setState(463);
						expression();
						}
						}
						setState(468);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(471);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_functionContext extends ParserRuleContext {
		public Builtin_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_function; }
	 
		public Builtin_functionContext() { }
		public void copyFrom(Builtin_functionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BuiltinFunctionContext extends Builtin_functionContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public BuiltinFunctionContext(Builtin_functionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBuiltinFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBuiltinFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBuiltinFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_functionContext builtin_function() throws RecognitionException {
		Builtin_functionContext _localctx = new Builtin_functionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_builtin_function);
		int _la;
		try {
			_localctx = new BuiltinFunctionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			function_name();
			setState(475);
			match(LPAR);
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
				{
				setState(476);
				expression();
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(477);
					match(COMMA);
					setState(478);
					expression();
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(486);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_methodContext extends ParserRuleContext {
		public Builtin_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_method; }
	 
		public Builtin_methodContext() { }
		public void copyFrom(Builtin_methodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BuiltinMethodContext extends Builtin_methodContext {
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(initParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(initParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(initParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(initParser.COMMA, i);
		}
		public BuiltinMethodContext(Builtin_methodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBuiltinMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBuiltinMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBuiltinMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_methodContext builtin_method() throws RecognitionException {
		Builtin_methodContext _localctx = new Builtin_methodContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_builtin_method);
		int _la;
		try {
			_localctx = new BuiltinMethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			method_name();
			setState(489);
			match(LPAR);
			setState(498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYARRAY - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (SINGLETONSET - 83)) | (1L << (UNIFORMNAT - 83)) | (1L << (FLIP - 83)) | (1L << (UNIFORMFLOAT - 83)) | (1L << (UNIFORMPERM - 83)) | (1L << (SYM - 83)) | (1L << (ANNO - 83)) | (1L << (INT - 83)) | (1L << (DOUBLE - 83)) | (1L << (BOOL - 83)) | (1L << (ID - 83)) | (1L << (PLUSPLUS - 83)) | (1L << (MINUSMINUS - 83)) | (1L << (PLUSPLUSMOD - 83)) | (1L << (MINUSMINUSMOD - 83)) | (1L << (LOWER - 83)) | (1L << (MINUS - 83)) | (1L << (PLUS - 83)) | (1L << (MUL - 83)) | (1L << (LPAR - 83)) | (1L << (NOT - 83)) | (1L << (LCB - 83)) | (1L << (LBRA - 83)) | (1L << (QUESTION - 83)) | (1L << (STRING - 83)))) != 0)) {
				{
				setState(490);
				expression();
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(491);
					match(COMMA);
					setState(492);
					expression();
					}
					}
					setState(497);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(500);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends DataTypeContext {
		public TerminalNode ARRAY() { return getToken(initParser.ARRAY, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public ArrayTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends DataTypeContext {
		public TerminalNode BOOLEAN() { return getToken(initParser.BOOLEAN, 0); }
		public BoolTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTypeContext extends DataTypeContext {
		public TerminalNode SET() { return getToken(initParser.SET, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public SetTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListTypeContext extends DataTypeContext {
		public TerminalNode LIST() { return getToken(initParser.LIST, 0); }
		public TerminalNode LOWER() { return getToken(initParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(initParser.GREATER, 0); }
		public ListTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends DataTypeContext {
		public TerminalNode INTEGER() { return getToken(initParser.INTEGER, 0); }
		public IntTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatTypeContext extends DataTypeContext {
		public TerminalNode FLOAT() { return getToken(initParser.FLOAT, 0); }
		public FloatTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFloatType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFloatType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_dataType);
		try {
			setState(520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(502);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				match(BOOLEAN);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				match(FLOAT);
				}
				break;
			case ARRAY:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(505);
				match(ARRAY);
				setState(506);
				match(LOWER);
				setState(507);
				dataType();
				setState(508);
				match(GREATER);
				}
				break;
			case LIST:
				_localctx = new ListTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(510);
				match(LIST);
				setState(511);
				match(LOWER);
				setState(512);
				dataType();
				setState(513);
				match(GREATER);
				}
				break;
			case SET:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(515);
				match(SET);
				setState(516);
				match(LOWER);
				setState(517);
				dataType();
				setState(518);
				match(GREATER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public TerminalNode ABS() { return getToken(initParser.ABS, 0); }
		public TerminalNode ASIN() { return getToken(initParser.ASIN, 0); }
		public TerminalNode ACOS() { return getToken(initParser.ACOS, 0); }
		public TerminalNode ATAN() { return getToken(initParser.ATAN, 0); }
		public TerminalNode COS() { return getToken(initParser.COS, 0); }
		public TerminalNode FLIP() { return getToken(initParser.FLIP, 0); }
		public TerminalNode FLOAT() { return getToken(initParser.FLOAT, 0); }
		public TerminalNode INTEGER() { return getToken(initParser.INTEGER, 0); }
		public TerminalNode LEN() { return getToken(initParser.LEN, 0); }
		public TerminalNode LOG() { return getToken(initParser.LOG, 0); }
		public TerminalNode PI() { return getToken(initParser.PI, 0); }
		public TerminalNode PRINT() { return getToken(initParser.PRINT, 0); }
		public TerminalNode POW() { return getToken(initParser.POW, 0); }
		public TerminalNode SIN() { return getToken(initParser.SIN, 0); }
		public TerminalNode SINGLETONSET() { return getToken(initParser.SINGLETONSET, 0); }
		public TerminalNode SQRT() { return getToken(initParser.SQRT, 0); }
		public TerminalNode TAN() { return getToken(initParser.TAN, 0); }
		public TerminalNode UNIFORMFLOAT() { return getToken(initParser.UNIFORMFLOAT, 0); }
		public TerminalNode UNIFORMNAT() { return getToken(initParser.UNIFORMNAT, 0); }
		public TerminalNode UNIFORMPERM() { return getToken(initParser.UNIFORMPERM, 0); }
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_function_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			_la = _input.LA(1);
			if ( !(((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (ABS - 49)) | (1L << (ACOS - 49)) | (1L << (ASIN - 49)) | (1L << (ATAN - 49)) | (1L << (COS - 49)) | (1L << (LOG - 49)) | (1L << (PI - 49)) | (1L << (POW - 49)) | (1L << (SIN - 49)) | (1L << (SQRT - 49)) | (1L << (TAN - 49)) | (1L << (LEN - 49)) | (1L << (FLOAT - 49)) | (1L << (INTEGER - 49)) | (1L << (PRINT - 49)) | (1L << (SINGLETONSET - 49)) | (1L << (UNIFORMNAT - 49)) | (1L << (FLIP - 49)) | (1L << (UNIFORMFLOAT - 49)) | (1L << (UNIFORMPERM - 49)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(initParser.AT, 0); }
		public TerminalNode DELETE() { return getToken(initParser.DELETE, 0); }
		public TerminalNode END() { return getToken(initParser.END, 0); }
		public TerminalNode FIRST() { return getToken(initParser.FIRST, 0); }
		public TerminalNode INSERT() { return getToken(initParser.INSERT, 0); }
		public TerminalNode KEYS() { return getToken(initParser.KEYS, 0); }
		public TerminalNode POPBACK() { return getToken(initParser.POPBACK, 0); }
		public TerminalNode POPFRONT() { return getToken(initParser.POPFRONT, 0); }
		public TerminalNode PUSHBACK() { return getToken(initParser.PUSHBACK, 0); }
		public TerminalNode PUSHFRONT() { return getToken(initParser.PUSHFRONT, 0); }
		public TerminalNode REMOVE() { return getToken(initParser.REMOVE, 0); }
		public TerminalNode REMOVEALLEQTO() { return getToken(initParser.REMOVEALLEQTO, 0); }
		public TerminalNode REMOVEAT() { return getToken(initParser.REMOVEAT, 0); }
		public TerminalNode SIZE() { return getToken(initParser.SIZE, 0); }
		public TerminalNode SPLIT() { return getToken(initParser.SPLIT, 0); }
		public TerminalNode TOPBACK() { return getToken(initParser.TOPBACK, 0); }
		public TerminalNode TOPFRONT() { return getToken(initParser.TOPFRONT, 0); }
		public TerminalNode UPDATE() { return getToken(initParser.UPDATE, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).enterMethod_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof initListener ) ((initListener)listener).exitMethod_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof initVisitor ) return ((initVisitor<? extends T>)visitor).visitMethod_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_method_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_la = _input.LA(1);
			if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (AT - 64)) | (1L << (DELETE - 64)) | (1L << (END - 64)) | (1L << (FIRST - 64)) | (1L << (INSERT - 64)) | (1L << (KEYS - 64)) | (1L << (POPBACK - 64)) | (1L << (POPFRONT - 64)) | (1L << (PUSHBACK - 64)) | (1L << (PUSHFRONT - 64)) | (1L << (REMOVE - 64)) | (1L << (REMOVEALLEQTO - 64)) | (1L << (REMOVEAT - 64)) | (1L << (SIZE - 64)) | (1L << (SPLIT - 64)) | (1L << (TOPBACK - 64)) | (1L << (TOPFRONT - 64)) | (1L << (UPDATE - 64)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return factor_sempred((FactorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u008f\u020f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000R\b\u0000\n\u0000\f\u0000U\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001i\b\u0001\n\u0001\f\u0001l\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001y\b\u0001\n\u0001\f\u0001"+
		"|\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0082\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u0089\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0091\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004\u0096\b\u0004\n\u0004\f\u0004\u0099\t\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u009e\b\u0005\n\u0005\f\u0005"+
		"\u00a1\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00a6\b"+
		"\u0006\n\u0006\f\u0006\u00a9\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u00ae\b\u0007\n\u0007\f\u0007\u00b1\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00b6\b\b\n\b\f\b\u00b9\t\b\u0001\t\u0001\t\u0001\t"+
		"\u0005\t\u00be\b\t\n\t\f\t\u00c1\t\t\u0001\n\u0001\n\u0001\n\u0005\n\u00c6"+
		"\b\n\n\n\f\n\u00c9\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00ce\b\u000b\n\u000b\f\u000b\u00d1\t\u000b\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u00d6\b\f\n\f\f\f\u00d9\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u00de\b"+
		"\r\n\r\f\r\u00e1\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00e6"+
		"\b\u000e\n\u000e\f\u000e\u00e9\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00f0\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00f4\b\u0010\n\u0010\f\u0010\u00f7\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u0107\b\u0011\n\u0011\f\u0011\u010a\t\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u011d\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u0123\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u012a\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0130\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0137\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u014a\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0159\b\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u015f\b\u001c"+
		"\n\u001c\f\u001c\u0162\t\u001c\u0003\u001c\u0164\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u016f\b\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0176\b\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u017c\b\u001d\n\u001d\f\u001d"+
		"\u017f\t\u001d\u0003\u001d\u0181\b\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u018c\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u0192\b\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u0196"+
		"\b\u001e\u000b\u001e\f\u001e\u0197\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u019c\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u01a2\b\u001f\u0001\u001f\u0001\u001f\u0004\u001f\u01a6\b\u001f\u000b"+
		"\u001f\f\u001f\u01a7\u0001\u001f\u0001\u001f\u0003\u001f\u01ac\b\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01b3\b \u0001 \u0001 \u0001"+
		" \u0001 \u0005 \u01b9\b \n \f \u01bc\t \u0003 \u01be\b \u0001 \u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01c9\b \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u01d1\b!\n!\f!\u01d4\t!\u0003"+
		"!\u01d6\b!\u0001!\u0003!\u01d9\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0005\"\u01e0\b\"\n\"\f\"\u01e3\t\"\u0003\"\u01e5\b\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0005#\u01ee\b#\n#\f#\u01f1\t#\u0003"+
		"#\u01f3\b#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u0209\b$\u0001%\u0001%\u0001&\u0001&\u0001&\u0000\u0001"+
		"\"\'\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJL\u0000\f\u0001\u0000uv\u0001"+
		"\u0000qt\u0001\u0000ce\u0002\u000000\u0086\u0086\u0001\u0000\u007f\u0080"+
		"\u0002\u0000mnxy\u0001\u0000z|\u0002\u0000jkop\u0002\u0000xz\u0083\u0083"+
		"\u0001\u0000jk\u0006\u00001<FFIIKKSSY\\\u0006\u0000@@BBDEGHLRTX\u0236"+
		"\u0000S\u0001\u0000\u0000\u0000\u0002\u0081\u0001\u0000\u0000\u0000\u0004"+
		"\u0088\u0001\u0000\u0000\u0000\u0006\u008a\u0001\u0000\u0000\u0000\b\u0092"+
		"\u0001\u0000\u0000\u0000\n\u009a\u0001\u0000\u0000\u0000\f\u00a2\u0001"+
		"\u0000\u0000\u0000\u000e\u00aa\u0001\u0000\u0000\u0000\u0010\u00b2\u0001"+
		"\u0000\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000\u0014\u00c2\u0001"+
		"\u0000\u0000\u0000\u0016\u00ca\u0001\u0000\u0000\u0000\u0018\u00d2\u0001"+
		"\u0000\u0000\u0000\u001a\u00da\u0001\u0000\u0000\u0000\u001c\u00e2\u0001"+
		"\u0000\u0000\u0000\u001e\u00ef\u0001\u0000\u0000\u0000 \u00f1\u0001\u0000"+
		"\u0000\u0000\"\u00f8\u0001\u0000\u0000\u0000$\u011c\u0001\u0000\u0000"+
		"\u0000&\u011e\u0001\u0000\u0000\u0000(\u0122\u0001\u0000\u0000\u0000*"+
		"\u0129\u0001\u0000\u0000\u0000,\u012f\u0001\u0000\u0000\u0000.\u0136\u0001"+
		"\u0000\u0000\u00000\u0138\u0001\u0000\u0000\u00002\u0149\u0001\u0000\u0000"+
		"\u00004\u014b\u0001\u0000\u0000\u00006\u014f\u0001\u0000\u0000\u00008"+
		"\u016e\u0001\u0000\u0000\u0000:\u018b\u0001\u0000\u0000\u0000<\u019b\u0001"+
		"\u0000\u0000\u0000>\u01ab\u0001\u0000\u0000\u0000@\u01c8\u0001\u0000\u0000"+
		"\u0000B\u01d8\u0001\u0000\u0000\u0000D\u01da\u0001\u0000\u0000\u0000F"+
		"\u01e8\u0001\u0000\u0000\u0000H\u0208\u0001\u0000\u0000\u0000J\u020a\u0001"+
		"\u0000\u0000\u0000L\u020c\u0001\u0000\u0000\u0000NO\u0005i\u0000\u0000"+
		"OP\u0005\u0013\u0000\u0000PR\u0003\u0002\u0001\u0000QN\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005"+
		"\u0000\u0000\u0001W\u0001\u0001\u0000\u0000\u0000XY\u0003\u0004\u0002"+
		"\u0000YZ\u0005\u000e\u0000\u0000Z[\u0003\u0002\u0001\u0000[\u0082\u0001"+
		"\u0000\u0000\u0000\\]\u0003\u0004\u0002\u0000]^\u0005\u000f\u0000\u0000"+
		"^_\u0003\u0002\u0001\u0000_\u0082\u0001\u0000\u0000\u0000`a\u0005\u0010"+
		"\u0000\u0000ab\u0005i\u0000\u0000bc\u0005\u0085\u0000\u0000cj\u0003H$"+
		"\u0000de\u0005\u0089\u0000\u0000ef\u0005i\u0000\u0000fg\u0005\u0085\u0000"+
		"\u0000gi\u0003H$\u0000hd\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000mn\u0005\u0012\u0000\u0000no\u0003\u0002"+
		"\u0001\u0000o\u0082\u0001\u0000\u0000\u0000pq\u0005\u0011\u0000\u0000"+
		"qr\u0005i\u0000\u0000rs\u0005\u0085\u0000\u0000sz\u0003H$\u0000tu\u0005"+
		"\u0089\u0000\u0000uv\u0005i\u0000\u0000vw\u0005\u0085\u0000\u0000wy\u0003"+
		"H$\u0000xt\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000}~\u0005\u0012\u0000\u0000~\u007f\u0003\u0002\u0001"+
		"\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080\u0082\u0003\u0004\u0002"+
		"\u0000\u0081X\u0001\u0000\u0000\u0000\u0081\\\u0001\u0000\u0000\u0000"+
		"\u0081`\u0001\u0000\u0000\u0000\u0081p\u0001\u0000\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0003\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0003\"\u0011\u0000\u0084\u0085\u0005w\u0000\u0000\u0085\u0086\u0003"+
		"\u0002\u0001\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0089\u0003"+
		"\u0006\u0003\u0000\u0088\u0083\u0001\u0000\u0000\u0000\u0088\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u0005\u0001\u0000\u0000\u0000\u008a\u0090\u0003"+
		"\b\u0004\u0000\u008b\u008c\u0005\u008e\u0000\u0000\u008c\u008d\u0003\u0002"+
		"\u0001\u0000\u008d\u008e\u0005\u0085\u0000\u0000\u008e\u008f\u0003\u0002"+
		"\u0001\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008b\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0007\u0001\u0000"+
		"\u0000\u0000\u0092\u0097\u0003\n\u0005\u0000\u0093\u0094\u0005\u0081\u0000"+
		"\u0000\u0094\u0096\u0003\n\u0005\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\t\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u009a\u009f\u0003\f\u0006\u0000\u009b\u009c"+
		"\u0005\u0082\u0000\u0000\u009c\u009e\u0003\f\u0006\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u000b\u0001"+
		"\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a7\u0003"+
		"\u000e\u0007\u0000\u00a3\u00a4\u0005\u001a\u0000\u0000\u00a4\u00a6\u0003"+
		"\u000e\u0007\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\r\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00af\u0003\u0010\b\u0000\u00ab\u00ac\u0007\u0000\u0000"+
		"\u0000\u00ac\u00ae\u0003\u0010\b\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u000f\u0001\u0000\u0000\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b7\u0003\u0012\t\u0000\u00b3"+
		"\u00b4\u0007\u0001\u0000\u0000\u00b4\u00b6\u0003\u0012\t\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u0011"+
		"\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bf"+
		"\u0003\u0014\n\u0000\u00bb\u00bc\u0007\u0002\u0000\u0000\u00bc\u00be\u0003"+
		"\u0014\n\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000"+
		"\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u0013\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c7\u0003\u0016\u000b\u0000\u00c3\u00c4\u0007\u0003"+
		"\u0000\u0000\u00c4\u00c6\u0003\u0016\u000b\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u0015\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cf\u0003\u0018"+
		"\f\u0000\u00cb\u00cc\u0005l\u0000\u0000\u00cc\u00ce\u0003\u0018\f\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u0017\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d7\u0003\u001a\r\u0000\u00d3\u00d4\u0007\u0004\u0000\u0000\u00d4"+
		"\u00d6\u0003\u001a\r\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u0019\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00da\u00df\u0003\u001c\u000e\u0000\u00db\u00dc"+
		"\u0007\u0005\u0000\u0000\u00dc\u00de\u0003\u001c\u000e\u0000\u00dd\u00db"+
		"\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u001b"+
		"\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e7"+
		"\u0003\u001e\u000f\u0000\u00e3\u00e4\u0007\u0006\u0000\u0000\u00e4\u00e6"+
		"\u0003\u001e\u000f\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e8\u001d\u0001\u0000\u0000\u0000\u00e9\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0007\u0007\u0000\u0000\u00eb\u00f0"+
		"\u0003\u001e\u000f\u0000\u00ec\u00ed\u0007\b\u0000\u0000\u00ed\u00f0\u0003"+
		"\u001e\u000f\u0000\u00ee\u00f0\u0003 \u0010\u0000\u00ef\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ec\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u001f\u0001\u0000\u0000\u0000\u00f1\u00f5\u0003\"\u0011"+
		"\u0000\u00f2\u00f4\u0007\t\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6!\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0006\u0011\uffff\uffff\u0000"+
		"\u00f9\u00fa\u0003$\u0012\u0000\u00fa\u0108\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\n\u0004\u0000\u0000\u00fc\u00fd\u0005\u008a\u0000\u0000\u00fd\u0107"+
		"\u0003F#\u0000\u00fe\u00ff\n\u0003\u0000\u0000\u00ff\u0100\u0005\u008a"+
		"\u0000\u0000\u0100\u0107\u0005i\u0000\u0000\u0101\u0102\n\u0002\u0000"+
		"\u0000\u0102\u0103\u0005\u008b\u0000\u0000\u0103\u0104\u0003\u0002\u0001"+
		"\u0000\u0104\u0105\u0005\u008c\u0000\u0000\u0105\u0107\u0001\u0000\u0000"+
		"\u0000\u0106\u00fb\u0001\u0000\u0000\u0000\u0106\u00fe\u0001\u0000\u0000"+
		"\u0000\u0106\u0101\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000"+
		"\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000"+
		"\u0000\u0109#\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000"+
		"\u010b\u011d\u0005\f\u0000\u0000\u010c\u010d\u0005\r\u0000\u0000\u010d"+
		"\u010e\u0005}\u0000\u0000\u010e\u010f\u0005i\u0000\u0000\u010f\u011d\u0005"+
		"~\u0000\u0000\u0110\u011d\u0003,\u0016\u0000\u0111\u011d\u0003(\u0014"+
		"\u0000\u0112\u0113\u0005}\u0000\u0000\u0113\u0114\u0003\u0002\u0001\u0000"+
		"\u0114\u0115\u0005~\u0000\u0000\u0115\u011d\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0005a\u0000\u0000\u0117\u0118\u0003&\u0013\u0000\u0118\u0119\u0005"+
		"}\u0000\u0000\u0119\u011a\u0003\u0002\u0001\u0000\u011a\u011b\u0005~\u0000"+
		"\u0000\u011b\u011d\u0001\u0000\u0000\u0000\u011c\u010b\u0001\u0000\u0000"+
		"\u0000\u011c\u010c\u0001\u0000\u0000\u0000\u011c\u0110\u0001\u0000\u0000"+
		"\u0000\u011c\u0111\u0001\u0000\u0000\u0000\u011c\u0112\u0001\u0000\u0000"+
		"\u0000\u011c\u0116\u0001\u0000\u0000\u0000\u011d%\u0001\u0000\u0000\u0000"+
		"\u011e\u011f\u0005b\u0000\u0000\u011f\'\u0001\u0000\u0000\u0000\u0120"+
		"\u0123\u0003*\u0015\u0000\u0121\u0123\u0003.\u0017\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0123)\u0001\u0000"+
		"\u0000\u0000\u0124\u012a\u0005f\u0000\u0000\u0125\u012a\u0005g\u0000\u0000"+
		"\u0126\u012a\u0005h\u0000\u0000\u0127\u012a\u0005\u008f\u0000\u0000\u0128"+
		"\u012a\u0005\u008e\u0000\u0000\u0129\u0124\u0001\u0000\u0000\u0000\u0129"+
		"\u0125\u0001\u0000\u0000\u0000\u0129\u0126\u0001\u0000\u0000\u0000\u0129"+
		"\u0127\u0001\u0000\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a"+
		"+\u0001\u0000\u0000\u0000\u012b\u0130\u0003B!\u0000\u012c\u0130\u0005"+
		"i\u0000\u0000\u012d\u012e\u0005^\u0000\u0000\u012e\u0130\u0005i\u0000"+
		"\u0000\u012f\u012b\u0001\u0000\u0000\u0000\u012f\u012c\u0001\u0000\u0000"+
		"\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130-\u0001\u0000\u0000\u0000"+
		"\u0131\u0137\u00038\u001c\u0000\u0132\u0137\u0003:\u001d\u0000\u0133\u0137"+
		"\u0003<\u001e\u0000\u0134\u0137\u0003@ \u0000\u0135\u0137\u0003>\u001f"+
		"\u0000\u0136\u0131\u0001\u0000\u0000\u0000\u0136\u0132\u0001\u0000\u0000"+
		"\u0000\u0136\u0133\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137/\u0001\u0000\u0000\u0000"+
		"\u0138\u0139\u0003\u0002\u0001\u0000\u0139\u013a\u0005\u008a\u0000\u0000"+
		"\u013a\u013b\u0005\u008a\u0000\u0000\u013b\u013c\u0003\u0002\u0001\u0000"+
		"\u013c1\u0001\u0000\u0000\u0000\u013d\u013e\u0005i\u0000\u0000\u013e\u013f"+
		"\u0005\u001b\u0000\u0000\u013f\u0140\u0003\u0002\u0001\u0000\u0140\u0141"+
		"\u0005\u0086\u0000\u0000\u0141\u0142\u0003\u0002\u0001\u0000\u0142\u014a"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0003\u0002\u0001\u0000\u0144\u0145"+
		"\u0005\u0086\u0000\u0000\u0145\u0146\u0005i\u0000\u0000\u0146\u0147\u0005"+
		"\u001b\u0000\u0000\u0147\u0148\u0003\u0002\u0001\u0000\u0148\u014a\u0001"+
		"\u0000\u0000\u0000\u0149\u013d\u0001\u0000\u0000\u0000\u0149\u0143\u0001"+
		"\u0000\u0000\u0000\u014a3\u0001\u0000\u0000\u0000\u014b\u014c\u0005i\u0000"+
		"\u0000\u014c\u014d\u0005_\u0000\u0000\u014d\u014e\u0003\u0002\u0001\u0000"+
		"\u014e5\u0001\u0000\u0000\u0000\u014f\u0150\u0003\u0002\u0001\u0000\u0150"+
		"\u0151\u0005\u0013\u0000\u0000\u0151\u0152\u0003\u0002\u0001\u0000\u0152"+
		"7\u0001\u0000\u0000\u0000\u0153\u0158\u0005(\u0000\u0000\u0154\u0155\u0005"+
		"q\u0000\u0000\u0155\u0156\u0003H$\u0000\u0156\u0157\u0005r\u0000\u0000"+
		"\u0157\u0159\u0001\u0000\u0000\u0000\u0158\u0154\u0001\u0000\u0000\u0000"+
		"\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u016f\u0001\u0000\u0000\u0000"+
		"\u015a\u0163\u0005\u008b\u0000\u0000\u015b\u0160\u0003\u0002\u0001\u0000"+
		"\u015c\u015d\u0005\u0089\u0000\u0000\u015d\u015f\u0003\u0002\u0001\u0000"+
		"\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000"+
		"\u0160\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000"+
		"\u0161\u0164\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000"+
		"\u0163\u015b\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000"+
		"\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u016f\u0005\u008c\u0000\u0000"+
		"\u0166\u0167\u0005\u008b\u0000\u0000\u0167\u0168\u00030\u0018\u0000\u0168"+
		"\u0169\u0005\u008c\u0000\u0000\u0169\u016f\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\u0005\u008b\u0000\u0000\u016b\u016c\u00032\u0019\u0000\u016c\u016d"+
		"\u0005\u008c\u0000\u0000\u016d\u016f\u0001\u0000\u0000\u0000\u016e\u0153"+
		"\u0001\u0000\u0000\u0000\u016e\u015a\u0001\u0000\u0000\u0000\u016e\u0166"+
		"\u0001\u0000\u0000\u0000\u016e\u016a\u0001\u0000\u0000\u0000\u016f9\u0001"+
		"\u0000\u0000\u0000\u0170\u0175\u0005+\u0000\u0000\u0171\u0172\u0005q\u0000"+
		"\u0000\u0172\u0173\u0003H$\u0000\u0173\u0174\u0005r\u0000\u0000\u0174"+
		"\u0176\u0001\u0000\u0000\u0000\u0175\u0171\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\u0001\u0000\u0000\u0000\u0176\u018c\u0001\u0000\u0000\u0000\u0177"+
		"\u0180\u0005q\u0000\u0000\u0178\u017d\u0003\u0002\u0001\u0000\u0179\u017a"+
		"\u0005\u0089\u0000\u0000\u017a\u017c\u0003\u0002\u0001\u0000\u017b\u0179"+
		"\u0001\u0000\u0000\u0000\u017c\u017f\u0001\u0000\u0000\u0000\u017d\u017b"+
		"\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u0181"+
		"\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180\u0178"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0182"+
		"\u0001\u0000\u0000\u0000\u0182\u018c\u0005r\u0000\u0000\u0183\u0184\u0005"+
		"q\u0000\u0000\u0184\u0185\u00030\u0018\u0000\u0185\u0186\u0005r\u0000"+
		"\u0000\u0186\u018c\u0001\u0000\u0000\u0000\u0187\u0188\u0005q\u0000\u0000"+
		"\u0188\u0189\u00032\u0019\u0000\u0189\u018a\u0005r\u0000\u0000\u018a\u018c"+
		"\u0001\u0000\u0000\u0000\u018b\u0170\u0001\u0000\u0000\u0000\u018b\u0177"+
		"\u0001\u0000\u0000\u0000\u018b\u0183\u0001\u0000\u0000\u0000\u018b\u0187"+
		"\u0001\u0000\u0000\u0000\u018c;\u0001\u0000\u0000\u0000\u018d\u0192\u0005"+
		")\u0000\u0000\u018e\u018f\u0005\u0087\u0000\u0000\u018f\u0190\u0005\u0013"+
		"\u0000\u0000\u0190\u0192\u0005\u0088\u0000\u0000\u0191\u018d\u0001\u0000"+
		"\u0000\u0000\u0191\u018e\u0001\u0000\u0000\u0000\u0192\u019c\u0001\u0000"+
		"\u0000\u0000\u0193\u0195\u0005\u0087\u0000\u0000\u0194\u0196\u00036\u001b"+
		"\u0000\u0195\u0194\u0001\u0000\u0000\u0000\u0196\u0197\u0001\u0000\u0000"+
		"\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000"+
		"\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019a\u0005\u0088\u0000"+
		"\u0000\u019a\u019c\u0001\u0000\u0000\u0000\u019b\u0191\u0001\u0000\u0000"+
		"\u0000\u019b\u0193\u0001\u0000\u0000\u0000\u019c=\u0001\u0000\u0000\u0000"+
		"\u019d\u01a2\u0005,\u0000\u0000\u019e\u019f\u0005\u0087\u0000\u0000\u019f"+
		"\u01a0\u0005_\u0000\u0000\u01a0\u01a2\u0005\u0088\u0000\u0000\u01a1\u019d"+
		"\u0001\u0000\u0000\u0000\u01a1\u019e\u0001\u0000\u0000\u0000\u01a2\u01ac"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a5\u0005\u0087\u0000\u0000\u01a4\u01a6"+
		"\u00034\u001a\u0000\u01a5\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001"+
		"\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u0005"+
		"\u0088\u0000\u0000\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a1\u0001"+
		"\u0000\u0000\u0000\u01ab\u01a3\u0001\u0000\u0000\u0000\u01ac?\u0001\u0000"+
		"\u0000\u0000\u01ad\u01b2\u0005*\u0000\u0000\u01ae\u01af\u0005q\u0000\u0000"+
		"\u01af\u01b0\u0003H$\u0000\u01b0\u01b1\u0005r\u0000\u0000\u01b1\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b2\u01ae\u0001\u0000\u0000\u0000\u01b2\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b3\u01c9\u0001\u0000\u0000\u0000\u01b4\u01bd"+
		"\u0005\u0087\u0000\u0000\u01b5\u01ba\u0003\u0002\u0001\u0000\u01b6\u01b7"+
		"\u0005\u0089\u0000\u0000\u01b7\u01b9\u0003\u0002\u0001\u0000\u01b8\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01b8"+
		"\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01be"+
		"\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bd\u01b5"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01bf"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c9\u0005\u0088\u0000\u0000\u01c0\u01c1"+
		"\u0005\u0087\u0000\u0000\u01c1\u01c2\u00030\u0018\u0000\u01c2\u01c3\u0005"+
		"\u0088\u0000\u0000\u01c3\u01c9\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005"+
		"\u0087\u0000\u0000\u01c5\u01c6\u00032\u0019\u0000\u01c6\u01c7\u0005\u0088"+
		"\u0000\u0000\u01c7\u01c9\u0001\u0000\u0000\u0000\u01c8\u01ad\u0001\u0000"+
		"\u0000\u0000\u01c8\u01b4\u0001\u0000\u0000\u0000\u01c8\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c4\u0001\u0000\u0000\u0000\u01c9A\u0001\u0000\u0000"+
		"\u0000\u01ca\u01d9\u0003D\"\u0000\u01cb\u01cc\u0005i\u0000\u0000\u01cc"+
		"\u01d5\u0005}\u0000\u0000\u01cd\u01d2\u0003\u0002\u0001\u0000\u01ce\u01cf"+
		"\u0005\u0089\u0000\u0000\u01cf\u01d1\u0003\u0002\u0001\u0000\u01d0\u01ce"+
		"\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0"+
		"\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d6"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01cd"+
		"\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d9\u0005~\u0000\u0000\u01d8\u01ca\u0001"+
		"\u0000\u0000\u0000\u01d8\u01cb\u0001\u0000\u0000\u0000\u01d9C\u0001\u0000"+
		"\u0000\u0000\u01da\u01db\u0003J%\u0000\u01db\u01e4\u0005}\u0000\u0000"+
		"\u01dc\u01e1\u0003\u0002\u0001\u0000\u01dd\u01de\u0005\u0089\u0000\u0000"+
		"\u01de\u01e0\u0003\u0002\u0001\u0000\u01df\u01dd\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e3\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4\u01dc\u0001\u0000\u0000\u0000"+
		"\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e7\u0005~\u0000\u0000\u01e7E\u0001\u0000\u0000\u0000\u01e8\u01e9"+
		"\u0003L&\u0000\u01e9\u01f2\u0005}\u0000\u0000\u01ea\u01ef\u0003\u0002"+
		"\u0001\u0000\u01eb\u01ec\u0005\u0089\u0000\u0000\u01ec\u01ee\u0003\u0002"+
		"\u0001\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ee\u01f1\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f3\u0001\u0000\u0000\u0000\u01f1\u01ef\u0001\u0000"+
		"\u0000\u0000\u01f2\u01ea\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f3\u01f4\u0001\u0000\u0000\u0000\u01f4\u01f5\u0005~\u0000"+
		"\u0000\u01f5G\u0001\u0000\u0000\u0000\u01f6\u0209\u0005I\u0000\u0000\u01f7"+
		"\u0209\u0005J\u0000\u0000\u01f8\u0209\u0005F\u0000\u0000\u01f9\u01fa\u0005"+
		"=\u0000\u0000\u01fa\u01fb\u0005q\u0000\u0000\u01fb\u01fc\u0003H$\u0000"+
		"\u01fc\u01fd\u0005r\u0000\u0000\u01fd\u0209\u0001\u0000\u0000\u0000\u01fe"+
		"\u01ff\u0005>\u0000\u0000\u01ff\u0200\u0005q\u0000\u0000\u0200\u0201\u0003"+
		"H$\u0000\u0201\u0202\u0005r\u0000\u0000\u0202\u0209\u0001\u0000\u0000"+
		"\u0000\u0203\u0204\u0005?\u0000\u0000\u0204\u0205\u0005q\u0000\u0000\u0205"+
		"\u0206\u0003H$\u0000\u0206\u0207\u0005r\u0000\u0000\u0207\u0209\u0001"+
		"\u0000\u0000\u0000\u0208\u01f6\u0001\u0000\u0000\u0000\u0208\u01f7\u0001"+
		"\u0000\u0000\u0000\u0208\u01f8\u0001\u0000\u0000\u0000\u0208\u01f9\u0001"+
		"\u0000\u0000\u0000\u0208\u01fe\u0001\u0000\u0000\u0000\u0208\u0203\u0001"+
		"\u0000\u0000\u0000\u0209I\u0001\u0000\u0000\u0000\u020a\u020b\u0007\n"+
		"\u0000\u0000\u020bK\u0001\u0000\u0000\u0000\u020c\u020d\u0007\u000b\u0000"+
		"\u0000\u020dM\u0001\u0000\u0000\u00005Sjz\u0081\u0088\u0090\u0097\u009f"+
		"\u00a7\u00af\u00b7\u00bf\u00c7\u00cf\u00d7\u00df\u00e7\u00ef\u00f5\u0106"+
		"\u0108\u011c\u0122\u0129\u012f\u0136\u0149\u0158\u0160\u0163\u016e\u0175"+
		"\u017d\u0180\u018b\u0191\u0197\u019b\u01a1\u01a7\u01ab\u01b2\u01ba\u01bd"+
		"\u01c8\u01d2\u01d5\u01d8\u01e1\u01e4\u01ef\u01f2\u0208";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
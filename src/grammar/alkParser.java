// Generated from /home/alex/work/Alk/script/../src/grammar/parts/alk.g4 by ANTLR 4.7.1

    package grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class alkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, TO=4, IF=5, ELSE=6, WHILE=7, DO=8, FOR=9, 
		FORALL=10, IN=11, FROM=12, OUT=13, CHOOSE=14, UNIFORM=15, REPEAT=16, RETURN=17, 
		SUCCESS=18, UNTIL=19, FAILURE=20, EMPTYSET=21, EMPTYLIST=22, MODIFIES=23, 
		XOR=24, ABS=25, ACOS=26, ASIN=27, ATAN=28, COS=29, LOG=30, PI=31, POW=32, 
		SIN=33, SQRT=34, TAN=35, LEN=36, AT=37, BELONGSTO=38, DELETE=39, EMPTY=40, 
		END=41, FIRST=42, FLOAT=43, INSERT=44, INTEGER=45, PRINT=46, POPBACK=47, 
		POPFRONT=48, PUSHBACK=49, PUSHFRONT=50, REMOVE=51, REMOVEALLEQTO=52, REMOVEAT=53, 
		SINGLETONSET=54, SIZE=55, SPLIT=56, TOPBACK=57, TOPFRONT=58, UPDATE=59, 
		RANDOM=60, SOTHAT=61, ARROW=62, UNION=63, INTERSECT=64, SUBTRACT=65, INT=66, 
		DOUBLE=67, BOOL=68, ID=69, PLUSPLUS=70, MINUSMINUS=71, BITWISE_AND=72, 
		PLUSMOD=73, MINUSMOD=74, PLUSPLUSMOD=75, MINUSMINUSMOD=76, LOWER=77, GREATER=78, 
		LOWEREQ=79, GREATEREQ=80, ISEQUAL=81, NOTEQUAL=82, ASSIGNMENT_OPERATOR=83, 
		MINUS=84, PLUS=85, MUL=86, DIV=87, MOD=88, LPAR=89, RPAR=90, LEFTSHIFT=91, 
		RIGHTSHIFT=92, OR=93, AND=94, NOT=95, SEMICOLON=96, DPOINT=97, VBAR=98, 
		LCB=99, RCB=100, COMMA=101, POINT=102, LBRA=103, RBRA=104, QUOTE=105, 
		QUESTION=106, STRING=107;
	public static final int
		RULE_main = 0, RULE_statement_sequence = 1, RULE_statement = 2, RULE_repeat_struct = 3, 
		RULE_statement_block = 4, RULE_uniform = 5, RULE_choose = 6, RULE_increase_decrease = 7, 
		RULE_assignment = 8, RULE_while_struct = 9, RULE_do_while_struct = 10, 
		RULE_if_struct = 11, RULE_for_struct = 12, RULE_start_assignment = 13, 
		RULE_forall_struct = 14, RULE_function_decl = 15, RULE_param = 16, RULE_expression = 17, 
		RULE_logical_or_expression = 18, RULE_logical_and_expression = 19, RULE_in_expression = 20, 
		RULE_equality_expression = 21, RULE_relational_expression = 22, RULE_set_expression = 23, 
		RULE_bitwise_or = 24, RULE_bitwise_and = 25, RULE_shift_expression = 26, 
		RULE_additive_expression = 27, RULE_multiplicative_expression = 28, RULE_unary_expression = 29, 
		RULE_postfix_expression = 30, RULE_factor = 31, RULE_value = 32, RULE_scalar_value = 33, 
		RULE_ref_name = 34, RULE_ref_name_chunk = 35, RULE_data_structure = 36, 
		RULE_interval = 37, RULE_spec = 38, RULE_array = 39, RULE_list = 40, RULE_structure = 41, 
		RULE_component = 42, RULE_set = 43, RULE_function_call = 44, RULE_builtin_method = 45, 
		RULE_method_name = 46, RULE_configuration = 47, RULE_variable = 48;
	public static final String[] ruleNames = {
		"main", "statement_sequence", "statement", "repeat_struct", "statement_block", 
		"uniform", "choose", "increase_decrease", "assignment", "while_struct", 
		"do_while_struct", "if_struct", "for_struct", "start_assignment", "forall_struct", 
		"function_decl", "param", "expression", "logical_or_expression", "logical_and_expression", 
		"in_expression", "equality_expression", "relational_expression", "set_expression", 
		"bitwise_or", "bitwise_and", "shift_expression", "additive_expression", 
		"multiplicative_expression", "unary_expression", "postfix_expression", 
		"factor", "value", "scalar_value", "ref_name", "ref_name_chunk", "data_structure", 
		"interval", "spec", "array", "list", "structure", "component", "set", 
		"function_call", "builtin_method", "method_name", "configuration", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'|->'", "'if'", "'else'", "'while'", "'do'", 
		"'for'", "'forall'", "'in'", "'from'", "'out'", "'choose'", "'uniform'", 
		"'repeat'", "'return'", "'success'", "'until'", "'failure'", "'emptySet'", 
		"'emptyList'", "'modifies'", "'xor'", "'abs'", "'acos'", "'asin'", "'atan'", 
		"'cos'", "'log'", "'pi'", "'pow'", "'sin'", "'sqrt'", "'tan'", "'len'", 
		"'at'", "'belongsTo'", "'delete'", "'empty'", "'end'", "'first'", "'float'", 
		"'insert'", "'int'", "'print'", "'popBack'", "'popFront'", "'pushBack'", 
		"'pushFront'", "'remove'", "'removeAllEqTo'", "'removeAt'", "'singletonSet'", 
		"'size'", "'split'", "'topBack'", "'topFront'", "'update'", "'random'", 
		"'s.t.'", "'->'", "'U'", "'^'", "'\\'", null, null, null, null, "'++'", 
		"'--'", "'&'", "'+%'", "'-%'", "'++%'", "'--%'", "'<'", "'>'", "'<='", 
		"'>='", "'=='", "'!='", null, "'-'", "'+'", "'*'", "'/'", "'%'", "'('", 
		"')'", "'<<'", "'>>'", "'||'", "'&&'", "'!'", "';'", "':'", "'|'", "'{'", 
		"'}'", "','", "'.'", "'['", "']'", "'\"'", "'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "TO", "IF", "ELSE", "WHILE", "DO", 
		"FOR", "FORALL", "IN", "FROM", "OUT", "CHOOSE", "UNIFORM", "REPEAT", "RETURN", 
		"SUCCESS", "UNTIL", "FAILURE", "EMPTYSET", "EMPTYLIST", "MODIFIES", "XOR", 
		"ABS", "ACOS", "ASIN", "ATAN", "COS", "LOG", "PI", "POW", "SIN", "SQRT", 
		"TAN", "LEN", "AT", "BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", "FLOAT", 
		"INSERT", "INTEGER", "PRINT", "POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", 
		"REMOVE", "REMOVEALLEQTO", "REMOVEAT", "SINGLETONSET", "SIZE", "SPLIT", 
		"TOPBACK", "TOPFRONT", "UPDATE", "RANDOM", "SOTHAT", "ARROW", "UNION", 
		"INTERSECT", "SUBTRACT", "INT", "DOUBLE", "BOOL", "ID", "PLUSPLUS", "MINUSMINUS", 
		"BITWISE_AND", "PLUSMOD", "MINUSMOD", "PLUSPLUSMOD", "MINUSMINUSMOD", 
		"LOWER", "GREATER", "LOWEREQ", "GREATEREQ", "ISEQUAL", "NOTEQUAL", "ASSIGNMENT_OPERATOR", 
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

	@Override
	public String getGrammarFileName() { return "alk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public alkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	 
		public MainContext() { }
		public void copyFrom(MainContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StartPointContext extends MainContext {
		public TerminalNode EOF() { return getToken(alkParser.EOF, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public StartPointContext(MainContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStartPoint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			_localctx = new StartPointContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FORALL) | (1L << CHOOSE) | (1L << UNIFORM) | (1L << REPEAT) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ID - 69)) | (1L << (PLUSPLUS - 69)) | (1L << (MINUSMINUS - 69)) | (1L << (PLUSPLUSMOD - 69)) | (1L << (MINUSMINUSMOD - 69)) | (1L << (LCB - 69)))) != 0)) {
				{
				setState(98);
				statement_sequence();
				}
			}

			setState(101);
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

	public static class Statement_sequenceContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public Statement_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStatement_sequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_sequenceContext statement_sequence() throws RecognitionException {
		Statement_sequenceContext _localctx = new Statement_sequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_sequence);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				statement();
				setState(105);
				statement_sequence();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToWhileContext extends StatementContext {
		public While_structContext while_struct() {
			return getRuleContext(While_structContext.class,0);
		}
		public ToWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToDoWhileContext extends StatementContext {
		public Do_while_structContext do_while_struct() {
			return getRuleContext(Do_while_structContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToDoWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToForAllContext extends StatementContext {
		public Forall_structContext forall_struct() {
			return getRuleContext(Forall_structContext.class,0);
		}
		public ToForAllContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodCallContext extends StatementContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public Builtin_methodContext builtin_method() {
			return getRuleContext(Builtin_methodContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public TerminalNode POINT() { return getToken(alkParser.POINT, 0); }
		public TerminalNode ARROW() { return getToken(alkParser.ARROW, 0); }
		public MethodCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuccessContext extends StatementContext {
		public TerminalNode SUCCESS() { return getToken(alkParser.SUCCESS, 0); }
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public SuccessContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSuccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChooseStmContext extends StatementContext {
		public ChooseContext choose() {
			return getRuleContext(ChooseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ChooseStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitChooseStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToRepeatContext extends StatementContext {
		public Repeat_structContext repeat_struct() {
			return getRuleContext(Repeat_structContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToRepeatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToRepeat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToIncreaseDecreaseContext extends StatementContext {
		public Increase_decreaseContext increase_decrease() {
			return getRuleContext(Increase_decreaseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToIncreaseDecreaseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToIncreaseDecrease(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToBlockContext extends StatementContext {
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public ToBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends StatementContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public FunctionCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UniformStmContext extends StatementContext {
		public UniformContext uniform() {
			return getRuleContext(UniformContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public UniformStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUniformStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(alkParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToForContext extends StatementContext {
		public For_structContext for_struct() {
			return getRuleContext(For_structContext.class,0);
		}
		public ToForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToFunctionDeclContext extends StatementContext {
		public Function_declContext function_decl() {
			return getRuleContext(Function_declContext.class,0);
		}
		public ToFunctionDeclContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FailureContext extends StatementContext {
		public TerminalNode FAILURE() { return getToken(alkParser.FAILURE, 0); }
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public FailureContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFailure(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAssignmentStmtContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToAssignmentStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToIfContext extends StatementContext {
		public If_structContext if_struct() {
			return getRuleContext(If_structContext.class,0);
		}
		public ToIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new MethodCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				ref_name();
				setState(110);
				_la = _input.LA(1);
				if ( !(_la==ARROW || _la==POINT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(111);
				builtin_method();
				setState(112);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new FunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				function_call();
				setState(115);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ToFunctionDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				function_decl();
				}
				break;
			case 4:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(RETURN);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(119);
					expression();
					}
				}

				setState(122);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new ChooseStmContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				choose();
				setState(124);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new UniformStmContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				uniform();
				setState(127);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new SuccessContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				match(SUCCESS);
				setState(130);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new FailureContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(131);
				match(FAILURE);
				setState(132);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new ToAssignmentStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(133);
				assignment();
				setState(134);
				match(SEMICOLON);
				}
				break;
			case 10:
				_localctx = new ToIncreaseDecreaseContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(136);
				increase_decrease();
				setState(137);
				match(SEMICOLON);
				}
				break;
			case 11:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(139);
				statement_block();
				}
				break;
			case 12:
				_localctx = new ToRepeatContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(140);
				repeat_struct();
				setState(141);
				match(SEMICOLON);
				}
				break;
			case 13:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(143);
				while_struct();
				}
				break;
			case 14:
				_localctx = new ToDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(144);
				do_while_struct();
				setState(145);
				match(SEMICOLON);
				}
				break;
			case 15:
				_localctx = new ToIfContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(147);
				if_struct();
				}
				break;
			case 16:
				_localctx = new ToForContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(148);
				for_struct();
				}
				break;
			case 17:
				_localctx = new ToForAllContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(149);
				forall_struct();
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

	public static class Repeat_structContext extends ParserRuleContext {
		public Repeat_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat_struct; }
	 
		public Repeat_structContext() { }
		public void copyFrom(Repeat_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RepeatStructureContext extends Repeat_structContext {
		public TerminalNode REPEAT() { return getToken(alkParser.REPEAT, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(alkParser.UNTIL, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public RepeatStructureContext(Repeat_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRepeatStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Repeat_structContext repeat_struct() throws RecognitionException {
		Repeat_structContext _localctx = new Repeat_structContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_repeat_struct);
		try {
			_localctx = new RepeatStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(REPEAT);
			setState(153);
			statement();
			setState(154);
			match(UNTIL);
			setState(155);
			match(LPAR);
			setState(156);
			expression();
			setState(157);
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

	public static class Statement_blockContext extends ParserRuleContext {
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
	 
		public Statement_blockContext() { }
		public void copyFrom(Statement_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptyBlockContext extends Statement_blockContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public EmptyBlockContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEmptyBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends Statement_blockContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public BlockContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement_block);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(LCB);
				setState(160);
				statement_sequence();
				setState(161);
				match(RCB);
				}
				break;
			case 2:
				_localctx = new EmptyBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(LCB);
				setState(164);
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

	public static class UniformContext extends ParserRuleContext {
		public UniformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniform; }
	 
		public UniformContext() { }
		public void copyFrom(UniformContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UniformStmtContext extends UniformContext {
		public TerminalNode UNIFORM() { return getToken(alkParser.UNIFORM, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UniformStmtContext(UniformContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUniformStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniformContext uniform() throws RecognitionException {
		UniformContext _localctx = new UniformContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_uniform);
		try {
			_localctx = new UniformStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(UNIFORM);
			setState(168);
			match(ID);
			setState(169);
			match(IN);
			setState(170);
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

	public static class ChooseContext extends ParserRuleContext {
		public ChooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choose; }
	 
		public ChooseContext() { }
		public void copyFrom(ChooseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChooseStmtContext extends ChooseContext {
		public TerminalNode CHOOSE() { return getToken(alkParser.CHOOSE, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SOTHAT() { return getToken(alkParser.SOTHAT, 0); }
		public ChooseStmtContext(ChooseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitChooseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseContext choose() throws RecognitionException {
		ChooseContext _localctx = new ChooseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_choose);
		int _la;
		try {
			_localctx = new ChooseStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(CHOOSE);
			setState(173);
			match(ID);
			setState(174);
			match(IN);
			setState(175);
			expression();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SOTHAT) {
				{
				setState(176);
				match(SOTHAT);
				setState(177);
				expression();
				}
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

	public static class Increase_decreaseContext extends ParserRuleContext {
		public Increase_decreaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increase_decrease; }
	 
		public Increase_decreaseContext() { }
		public void copyFrom(Increase_decreaseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StmtMinusMinusContext extends Increase_decreaseContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode MINUSMINUS() { return getToken(alkParser.MINUSMINUS, 0); }
		public StmtMinusMinusContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStmtMinusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusPlusStmtContext extends Increase_decreaseContext {
		public TerminalNode PLUSPLUS() { return getToken(alkParser.PLUSPLUS, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public PlusPlusStmtContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitPlusPlusStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusPlusModStmtContext extends Increase_decreaseContext {
		public TerminalNode PLUSPLUSMOD() { return getToken(alkParser.PLUSPLUSMOD, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public PlusPlusModStmtContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitPlusPlusModStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusMinusStmtContext extends Increase_decreaseContext {
		public TerminalNode MINUSMINUS() { return getToken(alkParser.MINUSMINUS, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public MinusMinusStmtContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMinusMinusStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StmtPlusPlusContext extends Increase_decreaseContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(alkParser.PLUSPLUS, 0); }
		public StmtPlusPlusContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStmtPlusPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusMinusModStmtContext extends Increase_decreaseContext {
		public TerminalNode MINUSMINUSMOD() { return getToken(alkParser.MINUSMINUSMOD, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public MinusMinusModStmtContext(Increase_decreaseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMinusMinusModStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Increase_decreaseContext increase_decrease() throws RecognitionException {
		Increase_decreaseContext _localctx = new Increase_decreaseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_increase_decrease);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new PlusPlusStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(PLUSPLUS);
				setState(181);
				ref_name();
				}
				break;
			case 2:
				_localctx = new StmtPlusPlusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				ref_name();
				setState(183);
				match(PLUSPLUS);
				}
				break;
			case 3:
				_localctx = new MinusMinusStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(MINUSMINUS);
				setState(186);
				ref_name();
				}
				break;
			case 4:
				_localctx = new StmtMinusMinusContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				ref_name();
				setState(188);
				match(MINUSMINUS);
				}
				break;
			case 5:
				_localctx = new PlusPlusModStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				match(PLUSPLUSMOD);
				setState(191);
				ref_name();
				}
				break;
			case 6:
				_localctx = new MinusMinusModStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
				match(MINUSMINUSMOD);
				setState(193);
				ref_name();
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

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentStmtContext extends AssignmentContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(alkParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStmtContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			_localctx = new AssignmentStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			ref_name();
			setState(197);
			match(ASSIGNMENT_OPERATOR);
			setState(198);
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

	public static class While_structContext extends ParserRuleContext {
		public While_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_struct; }
	 
		public While_structContext() { }
		public void copyFrom(While_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStructureContext extends While_structContext {
		public TerminalNode WHILE() { return getToken(alkParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStructureContext(While_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitWhileStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_structContext while_struct() throws RecognitionException {
		While_structContext _localctx = new While_structContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_struct);
		try {
			_localctx = new WhileStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(WHILE);
			setState(201);
			match(LPAR);
			setState(202);
			expression();
			setState(203);
			match(RPAR);
			setState(204);
			statement();
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

	public static class Do_while_structContext extends ParserRuleContext {
		public Do_while_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_struct; }
	 
		public Do_while_structContext() { }
		public void copyFrom(Do_while_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DoWhileStructureContext extends Do_while_structContext {
		public TerminalNode DO() { return getToken(alkParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(alkParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public DoWhileStructureContext(Do_while_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDoWhileStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_structContext do_while_struct() throws RecognitionException {
		Do_while_structContext _localctx = new Do_while_structContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_do_while_struct);
		try {
			_localctx = new DoWhileStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(DO);
			setState(207);
			statement();
			setState(208);
			match(WHILE);
			setState(209);
			match(LPAR);
			setState(210);
			expression();
			setState(211);
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

	public static class If_structContext extends ParserRuleContext {
		public If_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_struct; }
	 
		public If_structContext() { }
		public void copyFrom(If_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStructureContext extends If_structContext {
		public TerminalNode IF() { return getToken(alkParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(alkParser.ELSE, 0); }
		public IfStructureContext(If_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIfStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_structContext if_struct() throws RecognitionException {
		If_structContext _localctx = new If_structContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_struct);
		try {
			_localctx = new IfStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(IF);
			setState(214);
			match(LPAR);
			setState(215);
			expression();
			setState(216);
			match(RPAR);
			setState(217);
			statement();
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(218);
				match(ELSE);
				setState(219);
				statement();
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

	public static class For_structContext extends ParserRuleContext {
		public For_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_struct; }
	 
		public For_structContext() { }
		public void copyFrom(For_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForStructureContext extends For_structContext {
		public TerminalNode FOR() { return getToken(alkParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(alkParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(alkParser.SEMICOLON, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Increase_decreaseContext increase_decrease() {
			return getRuleContext(Increase_decreaseContext.class,0);
		}
		public Start_assignmentContext start_assignment() {
			return getRuleContext(Start_assignmentContext.class,0);
		}
		public ForStructureContext(For_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_structContext for_struct() throws RecognitionException {
		For_structContext _localctx = new For_structContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_struct);
		int _la;
		try {
			_localctx = new ForStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(FOR);
			setState(223);
			match(LPAR);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (ABS - 25)) | (1L << (ACOS - 25)) | (1L << (ASIN - 25)) | (1L << (ATAN - 25)) | (1L << (COS - 25)) | (1L << (LOG - 25)) | (1L << (PI - 25)) | (1L << (POW - 25)) | (1L << (SIN - 25)) | (1L << (SQRT - 25)) | (1L << (TAN - 25)) | (1L << (LEN - 25)) | (1L << (AT - 25)) | (1L << (DELETE - 25)) | (1L << (END - 25)) | (1L << (FIRST - 25)) | (1L << (FLOAT - 25)) | (1L << (INSERT - 25)) | (1L << (INTEGER - 25)) | (1L << (PRINT - 25)) | (1L << (POPBACK - 25)) | (1L << (POPFRONT - 25)) | (1L << (PUSHBACK - 25)) | (1L << (PUSHFRONT - 25)) | (1L << (REMOVE - 25)) | (1L << (REMOVEALLEQTO - 25)) | (1L << (REMOVEAT - 25)) | (1L << (SINGLETONSET - 25)) | (1L << (SIZE - 25)) | (1L << (SPLIT - 25)) | (1L << (TOPBACK - 25)) | (1L << (TOPFRONT - 25)) | (1L << (UPDATE - 25)) | (1L << (RANDOM - 25)) | (1L << (ID - 25)))) != 0)) {
				{
				setState(224);
				start_assignment();
				}
			}

			setState(227);
			match(SEMICOLON);
			setState(228);
			expression();
			setState(229);
			match(SEMICOLON);
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(230);
				assignment();
				}
				break;
			case 2:
				{
				setState(231);
				increase_decrease();
				}
				break;
			}
			setState(234);
			match(RPAR);
			setState(235);
			statement();
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

	public static class Start_assignmentContext extends ParserRuleContext {
		public Start_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_assignment; }
	 
		public Start_assignmentContext() { }
		public void copyFrom(Start_assignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForStartContext extends Start_assignmentContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForStartContext(Start_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_assignmentContext start_assignment() throws RecognitionException {
		Start_assignmentContext _localctx = new Start_assignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_start_assignment);
		try {
			_localctx = new ForStartContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			assignment();
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

	public static class Forall_structContext extends ParserRuleContext {
		public Forall_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forall_struct; }
	 
		public Forall_structContext() { }
		public void copyFrom(Forall_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForAllStructureContext extends Forall_structContext {
		public TerminalNode FORALL() { return getToken(alkParser.FORALL, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForAllStructureContext(Forall_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForAllStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Forall_structContext forall_struct() throws RecognitionException {
		Forall_structContext _localctx = new Forall_structContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forall_struct);
		try {
			_localctx = new ForAllStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(FORALL);
			setState(240);
			match(ID);
			setState(241);
			match(IN);
			setState(242);
			expression();
			setState(243);
			statement();
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

	public static class Function_declContext extends ParserRuleContext {
		public Function_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl; }
	 
		public Function_declContext() { }
		public void copyFrom(Function_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionDeclContext extends Function_declContext {
		public List<TerminalNode> ID() { return getTokens(alkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alkParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode MODIFIES() { return getToken(alkParser.MODIFIES, 0); }
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public FunctionDeclContext(Function_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declContext function_decl() throws RecognitionException {
		Function_declContext _localctx = new Function_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_function_decl);
		int _la;
		try {
			_localctx = new FunctionDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(ID);
			setState(246);
			match(LPAR);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT || _la==ID) {
				{
				setState(247);
				param();
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(248);
					match(COMMA);
					setState(249);
					param();
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(257);
			match(RPAR);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIES) {
				{
				setState(258);
				match(MODIFIES);
				setState(259);
				match(ID);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(260);
					match(COMMA);
					setState(261);
					match(ID);
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(269);
			statement_block();
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

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamDefinitionContext extends ParamContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode OUT() { return getToken(alkParser.OUT, 0); }
		public ParamDefinitionContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitParamDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		int _la;
		try {
			_localctx = new ParamDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT) {
				{
				setState(271);
				match(OUT);
				}
			}

			setState(274);
			match(ID);
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
	public static class ConditionalExpressionContext extends ExpressionContext {
		public Logical_or_expressionContext logical_or_expression() {
			return getRuleContext(Logical_or_expressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(alkParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DPOINT() { return getToken(alkParser.DPOINT, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expression);
		int _la;
		try {
			_localctx = new ConditionalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			logical_or_expression();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(277);
				match(QUESTION);
				setState(278);
				expression();
				setState(279);
				match(DPOINT);
				setState(280);
				expression();
				}
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
		public List<TerminalNode> OR() { return getTokens(alkParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(alkParser.OR, i);
		}
		public LogicalOrExpressionContext(Logical_or_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitLogicalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_expressionContext logical_or_expression() throws RecognitionException {
		Logical_or_expressionContext _localctx = new Logical_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logical_or_expression);
		int _la;
		try {
			_localctx = new LogicalOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			logical_and_expression();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(285);
				match(OR);
				setState(286);
				logical_and_expression();
				}
				}
				setState(291);
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
		public List<TerminalNode> AND() { return getTokens(alkParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(alkParser.AND, i);
		}
		public LogicalAndExpressionContext(Logical_and_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitLogicalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_expressionContext logical_and_expression() throws RecognitionException {
		Logical_and_expressionContext _localctx = new Logical_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_logical_and_expression);
		int _la;
		try {
			_localctx = new LogicalAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			in_expression();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(293);
				match(AND);
				setState(294);
				in_expression();
				}
				}
				setState(299);
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
		public List<TerminalNode> IN() { return getTokens(alkParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(alkParser.IN, i);
		}
		public InExpressionContext(In_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitInExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_expressionContext in_expression() throws RecognitionException {
		In_expressionContext _localctx = new In_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_in_expression);
		int _la;
		try {
			_localctx = new InExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			equality_expression();
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN) {
				{
				{
				setState(301);
				match(IN);
				setState(302);
				equality_expression();
				}
				}
				setState(307);
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
		public List<TerminalNode> ISEQUAL() { return getTokens(alkParser.ISEQUAL); }
		public TerminalNode ISEQUAL(int i) {
			return getToken(alkParser.ISEQUAL, i);
		}
		public List<TerminalNode> NOTEQUAL() { return getTokens(alkParser.NOTEQUAL); }
		public TerminalNode NOTEQUAL(int i) {
			return getToken(alkParser.NOTEQUAL, i);
		}
		public EqualityExpressionContext(Equality_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_equality_expression);
		int _la;
		try {
			_localctx = new EqualityExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			relational_expression();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ISEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(309);
				_la = _input.LA(1);
				if ( !(_la==ISEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(310);
				relational_expression();
				}
				}
				setState(315);
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
		public List<TerminalNode> LOWER() { return getTokens(alkParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(alkParser.LOWER, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(alkParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(alkParser.GREATER, i);
		}
		public List<TerminalNode> LOWEREQ() { return getTokens(alkParser.LOWEREQ); }
		public TerminalNode LOWEREQ(int i) {
			return getToken(alkParser.LOWEREQ, i);
		}
		public List<TerminalNode> GREATEREQ() { return getTokens(alkParser.GREATEREQ); }
		public TerminalNode GREATEREQ(int i) {
			return getToken(alkParser.GREATEREQ, i);
		}
		public RelationalExpressionContext(Relational_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relational_expression);
		int _la;
		try {
			int _alt;
			_localctx = new RelationalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			set_expression();
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(317);
					_la = _input.LA(1);
					if ( !(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (LOWER - 77)) | (1L << (GREATER - 77)) | (1L << (LOWEREQ - 77)) | (1L << (GREATEREQ - 77)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(318);
					set_expression();
					}
					} 
				}
				setState(323);
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
		public List<TerminalNode> UNION() { return getTokens(alkParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(alkParser.UNION, i);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(alkParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(alkParser.INTERSECT, i);
		}
		public List<TerminalNode> SUBTRACT() { return getTokens(alkParser.SUBTRACT); }
		public TerminalNode SUBTRACT(int i) {
			return getToken(alkParser.SUBTRACT, i);
		}
		public SetExpressionContext(Set_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_expressionContext set_expression() throws RecognitionException {
		Set_expressionContext _localctx = new Set_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_set_expression);
		int _la;
		try {
			_localctx = new SetExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			bitwise_or();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (UNION - 63)) | (1L << (INTERSECT - 63)) | (1L << (SUBTRACT - 63)))) != 0)) {
				{
				{
				setState(325);
				_la = _input.LA(1);
				if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (UNION - 63)) | (1L << (INTERSECT - 63)) | (1L << (SUBTRACT - 63)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(326);
				bitwise_or();
				}
				}
				setState(331);
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
		public List<TerminalNode> VBAR() { return getTokens(alkParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(alkParser.VBAR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(alkParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(alkParser.XOR, i);
		}
		public BitwiseOrExpressionContext(Bitwise_orContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBitwiseOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_orContext bitwise_or() throws RecognitionException {
		Bitwise_orContext _localctx = new Bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bitwise_or);
		int _la;
		try {
			int _alt;
			_localctx = new BitwiseOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			bitwise_and();
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(333);
					_la = _input.LA(1);
					if ( !(_la==XOR || _la==VBAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(334);
					bitwise_and();
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public List<TerminalNode> BITWISE_AND() { return getTokens(alkParser.BITWISE_AND); }
		public TerminalNode BITWISE_AND(int i) {
			return getToken(alkParser.BITWISE_AND, i);
		}
		public BitwiseAndExpressionContext(Bitwise_andContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBitwiseAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_andContext bitwise_and() throws RecognitionException {
		Bitwise_andContext _localctx = new Bitwise_andContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_bitwise_and);
		int _la;
		try {
			_localctx = new BitwiseAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			shift_expression();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_AND) {
				{
				{
				setState(341);
				match(BITWISE_AND);
				setState(342);
				shift_expression();
				}
				}
				setState(347);
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
		public List<TerminalNode> LEFTSHIFT() { return getTokens(alkParser.LEFTSHIFT); }
		public TerminalNode LEFTSHIFT(int i) {
			return getToken(alkParser.LEFTSHIFT, i);
		}
		public List<TerminalNode> RIGHTSHIFT() { return getTokens(alkParser.RIGHTSHIFT); }
		public TerminalNode RIGHTSHIFT(int i) {
			return getToken(alkParser.RIGHTSHIFT, i);
		}
		public ShiftExpressionContext(Shift_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_shift_expression);
		int _la;
		try {
			_localctx = new ShiftExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			additive_expression();
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTSHIFT || _la==RIGHTSHIFT) {
				{
				{
				setState(349);
				_la = _input.LA(1);
				if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(350);
				additive_expression();
				}
				}
				setState(355);
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
		public List<TerminalNode> PLUS() { return getTokens(alkParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(alkParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(alkParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(alkParser.MINUS, i);
		}
		public List<TerminalNode> PLUSMOD() { return getTokens(alkParser.PLUSMOD); }
		public TerminalNode PLUSMOD(int i) {
			return getToken(alkParser.PLUSMOD, i);
		}
		public List<TerminalNode> MINUSMOD() { return getTokens(alkParser.MINUSMOD); }
		public TerminalNode MINUSMOD(int i) {
			return getToken(alkParser.MINUSMOD, i);
		}
		public AdditiveExpressionContext(Additive_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_additive_expression);
		int _la;
		try {
			_localctx = new AdditiveExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			multiplicative_expression();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (PLUSMOD - 73)) | (1L << (MINUSMOD - 73)) | (1L << (MINUS - 73)) | (1L << (PLUS - 73)))) != 0)) {
				{
				{
				setState(357);
				_la = _input.LA(1);
				if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (PLUSMOD - 73)) | (1L << (MINUSMOD - 73)) | (1L << (MINUS - 73)) | (1L << (PLUS - 73)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(358);
				multiplicative_expression();
				}
				}
				setState(363);
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
		public List<TerminalNode> MUL() { return getTokens(alkParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(alkParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(alkParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(alkParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(alkParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(alkParser.MOD, i);
		}
		public MultiplicativeExpressionContext(Multiplicative_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiplicative_expression);
		int _la;
		try {
			_localctx = new MultiplicativeExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			unary_expression();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (MUL - 86)) | (1L << (DIV - 86)) | (1L << (MOD - 86)))) != 0)) {
				{
				{
				setState(365);
				_la = _input.LA(1);
				if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (MUL - 86)) | (1L << (DIV - 86)) | (1L << (MOD - 86)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(366);
				unary_expression();
				}
				}
				setState(371);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpressionContext extends Unary_expressionContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(alkParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(alkParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(alkParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(alkParser.MINUSMINUSMOD, 0); }
		public PrefixExpressionContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionContext extends Unary_expressionContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(alkParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(alkParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(alkParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(alkParser.NOT, 0); }
		public UnaryExpressionContext(Unary_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unary_expression);
		int _la;
		try {
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUSPLUSMOD:
			case MINUSMINUSMOD:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				_la = _input.LA(1);
				if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (PLUSPLUS - 70)) | (1L << (MINUSMINUS - 70)) | (1L << (PLUSPLUSMOD - 70)) | (1L << (MINUSMINUSMOD - 70)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(373);
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
				setState(374);
				_la = _input.LA(1);
				if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MINUS - 84)) | (1L << (PLUS - 84)) | (1L << (MUL - 84)) | (1L << (NOT - 84)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(375);
				unary_expression();
				}
				break;
			case EMPTYSET:
			case EMPTYLIST:
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
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case FLOAT:
			case INSERT:
			case INTEGER:
			case PRINT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case SPLIT:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
			case RANDOM:
			case INT:
			case DOUBLE:
			case BOOL:
			case ID:
			case LOWER:
			case LPAR:
			case LCB:
			case LBRA:
			case STRING:
				_localctx = new ToPostfixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
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
		public List<TerminalNode> PLUSPLUS() { return getTokens(alkParser.PLUSPLUS); }
		public TerminalNode PLUSPLUS(int i) {
			return getToken(alkParser.PLUSPLUS, i);
		}
		public List<TerminalNode> MINUSMINUS() { return getTokens(alkParser.MINUSMINUS); }
		public TerminalNode MINUSMINUS(int i) {
			return getToken(alkParser.MINUSMINUS, i);
		}
		public PostfixExpressionContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_postfix_expression);
		int _la;
		try {
			int _alt;
			_localctx = new PostfixExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			factor();
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(380);
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
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
	public static class FunctionCallFactorContext extends FactorContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public FunctionCallFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunctionCallFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefNameFactorContext extends FactorContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public RefNameFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRefNameFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanthesesFactorContext extends FactorContext {
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public ParanthesesFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitParanthesesFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueFactorContext extends FactorContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitValueFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_factor);
		try {
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new FunctionCallFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				function_call();
				}
				break;
			case 2:
				_localctx = new RefNameFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				ref_name();
				}
				break;
			case 3:
				_localctx = new ValueFactorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(388);
				value();
				}
				break;
			case 4:
				_localctx = new ParanthesesFactorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(389);
				match(LPAR);
				setState(390);
				expression();
				setState(391);
				match(RPAR);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_value);
		try {
			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case BOOL:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				scalar_value();
				}
				break;
			case EMPTYSET:
			case EMPTYLIST:
			case LOWER:
			case LCB:
			case LBRA:
				enterOuterAlt(_localctx, 2);
				{
				setState(396);
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
		public TerminalNode DOUBLE() { return getToken(alkParser.DOUBLE, 0); }
		public DoubleValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDoubleValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValueContext extends Scalar_valueContext {
		public TerminalNode BOOL() { return getToken(alkParser.BOOL, 0); }
		public BoolValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValueContext extends Scalar_valueContext {
		public TerminalNode STRING() { return getToken(alkParser.STRING, 0); }
		public StringValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValueContext extends Scalar_valueContext {
		public TerminalNode INT() { return getToken(alkParser.INT, 0); }
		public IntValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_valueContext scalar_value() throws RecognitionException {
		Scalar_valueContext _localctx = new Scalar_valueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_scalar_value);
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				match(DOUBLE);
				}
				break;
			case BOOL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(401);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(402);
				match(STRING);
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
	public static class RefNameContext extends Ref_nameContext {
		public List<Ref_name_chunkContext> ref_name_chunk() {
			return getRuleContexts(Ref_name_chunkContext.class);
		}
		public Ref_name_chunkContext ref_name_chunk(int i) {
			return getRuleContext(Ref_name_chunkContext.class,i);
		}
		public List<TerminalNode> POINT() { return getTokens(alkParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(alkParser.POINT, i);
		}
		public List<TerminalNode> ARROW() { return getTokens(alkParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(alkParser.ARROW, i);
		}
		public RefNameContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRefName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_nameContext ref_name() throws RecognitionException {
		Ref_nameContext _localctx = new Ref_nameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ref_name);
		int _la;
		try {
			int _alt;
			_localctx = new RefNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			ref_name_chunk();
			setState(410);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(406);
					_la = _input.LA(1);
					if ( !(_la==ARROW || _la==POINT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(407);
					ref_name_chunk();
					}
					} 
				}
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class Ref_name_chunkContext extends ParserRuleContext {
		public Ref_name_chunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name_chunk; }
	 
		public Ref_name_chunkContext() { }
		public void copyFrom(Ref_name_chunkContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionChunkContext extends Ref_name_chunkContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public List<TerminalNode> LBRA() { return getTokens(alkParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(alkParser.LBRA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRA() { return getTokens(alkParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(alkParser.RBRA, i);
		}
		public FunctionChunkContext(Ref_name_chunkContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunctionChunk(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDChunkContext extends Ref_name_chunkContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public List<TerminalNode> LBRA() { return getTokens(alkParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(alkParser.LBRA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRA() { return getTokens(alkParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(alkParser.RBRA, i);
		}
		public IDChunkContext(Ref_name_chunkContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIDChunk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_name_chunkContext ref_name_chunk() throws RecognitionException {
		Ref_name_chunkContext _localctx = new Ref_name_chunkContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ref_name_chunk);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new FunctionChunkContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				function_call();
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(414);
					match(LBRA);
					setState(415);
					expression();
					setState(416);
					match(RBRA);
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new IDChunkContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(ID);
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(424);
					match(LBRA);
					setState(425);
					expression();
					setState(426);
					match(RBRA);
					}
					}
					setState(432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitListValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructureValueContext extends Data_structureContext {
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public StructureValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStructureValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueContext extends Data_structureContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetValueContext extends Data_structureContext {
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public SetValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_structureContext data_structure() throws RecognitionException {
		Data_structureContext _localctx = new Data_structureContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_data_structure);
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				array();
				}
				break;
			case 2:
				_localctx = new ListValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				list();
				}
				break;
			case 3:
				_localctx = new SetValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(437);
				set();
				}
				break;
			case 4:
				_localctx = new StructureValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(438);
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
		public List<TerminalNode> POINT() { return getTokens(alkParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(alkParser.POINT, i);
		}
		public IntervalDefinitionContext(IntervalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIntervalDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_interval);
		try {
			_localctx = new IntervalDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			expression();
			setState(442);
			match(POINT);
			setState(443);
			match(POINT);
			setState(444);
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
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode FROM() { return getToken(alkParser.FROM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode VBAR() { return getToken(alkParser.VBAR, 0); }
		public FilterSpecDefinitionContext(SpecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFilterSpecDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeprecatedSpecDefinitionContext extends SpecContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode VBAR() { return getToken(alkParser.VBAR, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public DeprecatedSpecDefinitionContext(SpecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDeprecatedSpecDefinition(this);
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
		public TerminalNode VBAR() { return getToken(alkParser.VBAR, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode FROM() { return getToken(alkParser.FROM, 0); }
		public SelectSpecDefinitionContext(SpecContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSelectSpecDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_spec);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new DeprecatedSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				expression();
				setState(447);
				match(VBAR);
				setState(448);
				match(ID);
				setState(449);
				match(IN);
				setState(450);
				expression();
				}
				break;
			case 2:
				_localctx = new FilterSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				match(ID);
				setState(453);
				match(FROM);
				setState(454);
				expression();
				setState(455);
				match(VBAR);
				setState(456);
				expression();
				}
				break;
			case 3:
				_localctx = new SelectSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(458);
				expression();
				setState(459);
				match(VBAR);
				setState(460);
				match(ID);
				setState(461);
				match(FROM);
				setState(462);
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
		public TerminalNode LBRA() { return getToken(alkParser.LBRA, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(alkParser.RBRA, 0); }
		public ArrayWithSpecContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitArrayWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithExpressionsContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(alkParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(alkParser.RBRA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public ArrayWithExpressionsContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitArrayWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithIntervalContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(alkParser.LBRA, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(alkParser.RBRA, 0); }
		public ArrayWithIntervalContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitArrayWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_array);
		int _la;
		try {
			setState(486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new ArrayWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				match(LBRA);
				setState(467);
				spec();
				setState(468);
				match(RBRA);
				}
				break;
			case 2:
				_localctx = new ArrayWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				match(LBRA);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(471);
					expression();
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(472);
						match(COMMA);
						setState(473);
						expression();
						}
						}
						setState(478);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(481);
				match(RBRA);
				}
				break;
			case 3:
				_localctx = new ArrayWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				match(LBRA);
				setState(483);
				interval();
				setState(484);
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
		public TerminalNode EMPTYLIST() { return getToken(alkParser.EMPTYLIST, 0); }
		public EmptyListContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEmptyList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithIntervalContext extends ListContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public ListWithIntervalContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitListWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithExpressionsContext extends ListContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public ListWithExpressionsContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitListWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListWithSpecContext extends ListContext {
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public ListWithSpecContext(ListContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitListWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_list);
		int _la;
		try {
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new EmptyListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(488);
				match(EMPTYLIST);
				}
				break;
			case 2:
				_localctx = new ListWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				match(LOWER);
				setState(490);
				spec();
				setState(491);
				match(GREATER);
				}
				break;
			case 3:
				_localctx = new ListWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(493);
				match(LOWER);
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(494);
					expression();
					setState(499);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(495);
						match(COMMA);
						setState(496);
						expression();
						}
						}
						setState(501);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(504);
				match(GREATER);
				}
				break;
			case 4:
				_localctx = new ListWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(505);
				match(LOWER);
				setState(506);
				interval();
				setState(507);
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
	public static class StructureWithComponentsContext extends StructureContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public StructureWithComponentsContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStructureWithComponents(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_structure);
		int _la;
		try {
			_localctx = new StructureWithComponentsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(LCB);
			setState(513); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(512);
				component();
				}
				}
				setState(515); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(517);
			match(RCB);
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
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(alkParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComponentDefinitionContext(ComponentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitComponentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_component);
		try {
			_localctx = new ComponentDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			match(ID);
			setState(520);
			match(ARROW);
			setState(521);
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
	public static class SetWithIntervalContext extends SetContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public SetWithIntervalContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptySetContext extends SetContext {
		public TerminalNode EMPTYSET() { return getToken(alkParser.EMPTYSET, 0); }
		public EmptySetContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEmptySet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetWithSpecContext extends SetContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public SetWithSpecContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetWithExpressionsContext extends SetContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public SetWithExpressionsContext(SetContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_set);
		int _la;
		try {
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new EmptySetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				match(EMPTYSET);
				}
				break;
			case 2:
				_localctx = new SetWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				match(LCB);
				setState(525);
				spec();
				setState(526);
				match(RCB);
				}
				break;
			case 3:
				_localctx = new SetWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(528);
				match(LCB);
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(529);
					expression();
					setState(534);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(530);
						match(COMMA);
						setState(531);
						expression();
						}
						}
						setState(536);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(539);
				match(RCB);
				}
				break;
			case 4:
				_localctx = new SetWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(540);
				match(LCB);
				setState(541);
				interval();
				setState(542);
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
	public static class ToBuiltinMethodContext extends Function_callContext {
		public Builtin_methodContext builtin_method() {
			return getRuleContext(Builtin_methodContext.class,0);
		}
		public ToBuiltinMethodContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToBuiltinMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinedFunctionCallContext extends Function_callContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public DefinedFunctionCallContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDefinedFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_function_call);
		int _la;
		try {
			setState(560);
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
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case FLOAT:
			case INSERT:
			case INTEGER:
			case PRINT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case SPLIT:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
			case RANDOM:
				_localctx = new ToBuiltinMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				builtin_method();
				}
				break;
			case ID:
				_localctx = new DefinedFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				match(ID);
				setState(548);
				match(LPAR);
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(549);
					expression();
					setState(554);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(550);
						match(COMMA);
						setState(551);
						expression();
						}
						}
						setState(556);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(559);
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
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public BuiltinMethodContext(Builtin_methodContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBuiltinMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_methodContext builtin_method() throws RecognitionException {
		Builtin_methodContext _localctx = new Builtin_methodContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_builtin_method);
		int _la;
		try {
			_localctx = new BuiltinMethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			method_name();
			setState(563);
			match(LPAR);
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (INT - 66)) | (1L << (DOUBLE - 66)) | (1L << (BOOL - 66)) | (1L << (ID - 66)) | (1L << (PLUSPLUS - 66)) | (1L << (MINUSMINUS - 66)) | (1L << (PLUSPLUSMOD - 66)) | (1L << (MINUSMINUSMOD - 66)) | (1L << (LOWER - 66)) | (1L << (MINUS - 66)) | (1L << (PLUS - 66)) | (1L << (MUL - 66)) | (1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(564);
				expression();
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(565);
					match(COMMA);
					setState(566);
					expression();
					}
					}
					setState(571);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(574);
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

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ABS() { return getToken(alkParser.ABS, 0); }
		public TerminalNode ASIN() { return getToken(alkParser.ASIN, 0); }
		public TerminalNode ACOS() { return getToken(alkParser.ACOS, 0); }
		public TerminalNode ATAN() { return getToken(alkParser.ATAN, 0); }
		public TerminalNode AT() { return getToken(alkParser.AT, 0); }
		public TerminalNode COS() { return getToken(alkParser.COS, 0); }
		public TerminalNode DELETE() { return getToken(alkParser.DELETE, 0); }
		public TerminalNode END() { return getToken(alkParser.END, 0); }
		public TerminalNode FIRST() { return getToken(alkParser.FIRST, 0); }
		public TerminalNode FLOAT() { return getToken(alkParser.FLOAT, 0); }
		public TerminalNode INSERT() { return getToken(alkParser.INSERT, 0); }
		public TerminalNode INTEGER() { return getToken(alkParser.INTEGER, 0); }
		public TerminalNode LEN() { return getToken(alkParser.LEN, 0); }
		public TerminalNode LOG() { return getToken(alkParser.LOG, 0); }
		public TerminalNode PI() { return getToken(alkParser.PI, 0); }
		public TerminalNode PRINT() { return getToken(alkParser.PRINT, 0); }
		public TerminalNode POPBACK() { return getToken(alkParser.POPBACK, 0); }
		public TerminalNode POPFRONT() { return getToken(alkParser.POPFRONT, 0); }
		public TerminalNode POW() { return getToken(alkParser.POW, 0); }
		public TerminalNode PUSHBACK() { return getToken(alkParser.PUSHBACK, 0); }
		public TerminalNode PUSHFRONT() { return getToken(alkParser.PUSHFRONT, 0); }
		public TerminalNode RANDOM() { return getToken(alkParser.RANDOM, 0); }
		public TerminalNode REMOVE() { return getToken(alkParser.REMOVE, 0); }
		public TerminalNode REMOVEALLEQTO() { return getToken(alkParser.REMOVEALLEQTO, 0); }
		public TerminalNode REMOVEAT() { return getToken(alkParser.REMOVEAT, 0); }
		public TerminalNode SIN() { return getToken(alkParser.SIN, 0); }
		public TerminalNode SINGLETONSET() { return getToken(alkParser.SINGLETONSET, 0); }
		public TerminalNode SIZE() { return getToken(alkParser.SIZE, 0); }
		public TerminalNode SPLIT() { return getToken(alkParser.SPLIT, 0); }
		public TerminalNode SQRT() { return getToken(alkParser.SQRT, 0); }
		public TerminalNode TAN() { return getToken(alkParser.TAN, 0); }
		public TerminalNode TOPBACK() { return getToken(alkParser.TOPBACK, 0); }
		public TerminalNode TOPFRONT() { return getToken(alkParser.TOPFRONT, 0); }
		public TerminalNode UPDATE() { return getToken(alkParser.UPDATE, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMethod_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_method_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << FLOAT) | (1L << INSERT) | (1L << INTEGER) | (1L << PRINT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << SPLIT) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << RANDOM))) != 0)) ) {
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
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ConfigContext(ConfigurationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitConfig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConfigurationContext configuration() throws RecognitionException {
		ConfigurationContext _localctx = new ConfigurationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_configuration);
		int _la;
		try {
			_localctx = new ConfigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(578);
				variable();
				}
				}
				setState(583);
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

	public static class VariableContext extends ParserRuleContext {
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	 
		public VariableContext() { }
		public void copyFrom(VariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarContext extends VariableContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode TO() { return getToken(alkParser.TO, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarContext(VariableContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_variable);
		try {
			_localctx = new VarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			match(ID);
			setState(585);
			match(TO);
			setState(586);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3m\u024f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\5\2f\n\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\5\3n\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4{\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0099\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a8\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b5\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c5\n\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00df\n\r\3\16\3\16\3\16\5\16\u00e4\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00eb\n\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00fd\n\21\f\21\16\21\u0100"+
		"\13\21\5\21\u0102\n\21\3\21\3\21\3\21\3\21\3\21\7\21\u0109\n\21\f\21\16"+
		"\21\u010c\13\21\5\21\u010e\n\21\3\21\3\21\3\22\5\22\u0113\n\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u011d\n\23\3\24\3\24\3\24\7\24"+
		"\u0122\n\24\f\24\16\24\u0125\13\24\3\25\3\25\3\25\7\25\u012a\n\25\f\25"+
		"\16\25\u012d\13\25\3\26\3\26\3\26\7\26\u0132\n\26\f\26\16\26\u0135\13"+
		"\26\3\27\3\27\3\27\7\27\u013a\n\27\f\27\16\27\u013d\13\27\3\30\3\30\3"+
		"\30\7\30\u0142\n\30\f\30\16\30\u0145\13\30\3\31\3\31\3\31\7\31\u014a\n"+
		"\31\f\31\16\31\u014d\13\31\3\32\3\32\3\32\7\32\u0152\n\32\f\32\16\32\u0155"+
		"\13\32\3\33\3\33\3\33\7\33\u015a\n\33\f\33\16\33\u015d\13\33\3\34\3\34"+
		"\3\34\7\34\u0162\n\34\f\34\16\34\u0165\13\34\3\35\3\35\3\35\7\35\u016a"+
		"\n\35\f\35\16\35\u016d\13\35\3\36\3\36\3\36\7\36\u0172\n\36\f\36\16\36"+
		"\u0175\13\36\3\37\3\37\3\37\3\37\3\37\5\37\u017c\n\37\3 \3 \7 \u0180\n"+
		" \f \16 \u0183\13 \3!\3!\3!\3!\3!\3!\3!\5!\u018c\n!\3\"\3\"\5\"\u0190"+
		"\n\"\3#\3#\3#\3#\5#\u0196\n#\3$\3$\3$\7$\u019b\n$\f$\16$\u019e\13$\3%"+
		"\3%\3%\3%\3%\7%\u01a5\n%\f%\16%\u01a8\13%\3%\3%\3%\3%\3%\7%\u01af\n%\f"+
		"%\16%\u01b2\13%\5%\u01b4\n%\3&\3&\3&\3&\5&\u01ba\n&\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01d3\n(\3"+
		")\3)\3)\3)\3)\3)\3)\3)\7)\u01dd\n)\f)\16)\u01e0\13)\5)\u01e2\n)\3)\3)"+
		"\3)\3)\3)\5)\u01e9\n)\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u01f4\n*\f*\16*\u01f7"+
		"\13*\5*\u01f9\n*\3*\3*\3*\3*\3*\5*\u0200\n*\3+\3+\6+\u0204\n+\r+\16+\u0205"+
		"\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0217\n-\f-\16-\u021a"+
		"\13-\5-\u021c\n-\3-\3-\3-\3-\3-\5-\u0223\n-\3.\3.\3.\3.\3.\3.\7.\u022b"+
		"\n.\f.\16.\u022e\13.\5.\u0230\n.\3.\5.\u0233\n.\3/\3/\3/\3/\3/\7/\u023a"+
		"\n/\f/\16/\u023d\13/\5/\u023f\n/\3/\3/\3\60\3\60\3\61\7\61\u0246\n\61"+
		"\f\61\16\61\u0249\13\61\3\62\3\62\3\62\3\62\3\62\2\2\63\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2"+
		"\16\4\2@@hh\3\2ST\3\2OR\3\2AC\4\2\32\32dd\3\2]^\4\2KLVW\3\2XZ\4\2HIMN"+
		"\4\2VXaa\3\2HI\5\2\33\'))+>\2\u0273\2e\3\2\2\2\4m\3\2\2\2\6\u0098\3\2"+
		"\2\2\b\u009a\3\2\2\2\n\u00a7\3\2\2\2\f\u00a9\3\2\2\2\16\u00ae\3\2\2\2"+
		"\20\u00c4\3\2\2\2\22\u00c6\3\2\2\2\24\u00ca\3\2\2\2\26\u00d0\3\2\2\2\30"+
		"\u00d7\3\2\2\2\32\u00e0\3\2\2\2\34\u00ef\3\2\2\2\36\u00f1\3\2\2\2 \u00f7"+
		"\3\2\2\2\"\u0112\3\2\2\2$\u0116\3\2\2\2&\u011e\3\2\2\2(\u0126\3\2\2\2"+
		"*\u012e\3\2\2\2,\u0136\3\2\2\2.\u013e\3\2\2\2\60\u0146\3\2\2\2\62\u014e"+
		"\3\2\2\2\64\u0156\3\2\2\2\66\u015e\3\2\2\28\u0166\3\2\2\2:\u016e\3\2\2"+
		"\2<\u017b\3\2\2\2>\u017d\3\2\2\2@\u018b\3\2\2\2B\u018f\3\2\2\2D\u0195"+
		"\3\2\2\2F\u0197\3\2\2\2H\u01b3\3\2\2\2J\u01b9\3\2\2\2L\u01bb\3\2\2\2N"+
		"\u01d2\3\2\2\2P\u01e8\3\2\2\2R\u01ff\3\2\2\2T\u0201\3\2\2\2V\u0209\3\2"+
		"\2\2X\u0222\3\2\2\2Z\u0232\3\2\2\2\\\u0234\3\2\2\2^\u0242\3\2\2\2`\u0247"+
		"\3\2\2\2b\u024a\3\2\2\2df\5\4\3\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\2"+
		"\2\3h\3\3\2\2\2in\5\6\4\2jk\5\6\4\2kl\5\4\3\2ln\3\2\2\2mi\3\2\2\2mj\3"+
		"\2\2\2n\5\3\2\2\2op\5F$\2pq\t\2\2\2qr\5\\/\2rs\7b\2\2s\u0099\3\2\2\2t"+
		"u\5Z.\2uv\7b\2\2v\u0099\3\2\2\2w\u0099\5 \21\2xz\7\23\2\2y{\5$\23\2zy"+
		"\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0099\7b\2\2}~\5\16\b\2~\177\7b\2\2\177"+
		"\u0099\3\2\2\2\u0080\u0081\5\f\7\2\u0081\u0082\7b\2\2\u0082\u0099\3\2"+
		"\2\2\u0083\u0084\7\24\2\2\u0084\u0099\7b\2\2\u0085\u0086\7\26\2\2\u0086"+
		"\u0099\7b\2\2\u0087\u0088\5\22\n\2\u0088\u0089\7b\2\2\u0089\u0099\3\2"+
		"\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7b\2\2\u008c\u0099\3\2\2\2\u008d"+
		"\u0099\5\n\6\2\u008e\u008f\5\b\5\2\u008f\u0090\7b\2\2\u0090\u0099\3\2"+
		"\2\2\u0091\u0099\5\24\13\2\u0092\u0093\5\26\f\2\u0093\u0094\7b\2\2\u0094"+
		"\u0099\3\2\2\2\u0095\u0099\5\30\r\2\u0096\u0099\5\32\16\2\u0097\u0099"+
		"\5\36\20\2\u0098o\3\2\2\2\u0098t\3\2\2\2\u0098w\3\2\2\2\u0098x\3\2\2\2"+
		"\u0098}\3\2\2\2\u0098\u0080\3\2\2\2\u0098\u0083\3\2\2\2\u0098\u0085\3"+
		"\2\2\2\u0098\u0087\3\2\2\2\u0098\u008a\3\2\2\2\u0098\u008d\3\2\2\2\u0098"+
		"\u008e\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0095\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\7\3\2\2\2\u009a\u009b"+
		"\7\22\2\2\u009b\u009c\5\6\4\2\u009c\u009d\7\25\2\2\u009d\u009e\7[\2\2"+
		"\u009e\u009f\5$\23\2\u009f\u00a0\7\\\2\2\u00a0\t\3\2\2\2\u00a1\u00a2\7"+
		"e\2\2\u00a2\u00a3\5\4\3\2\u00a3\u00a4\7f\2\2\u00a4\u00a8\3\2\2\2\u00a5"+
		"\u00a6\7e\2\2\u00a6\u00a8\7f\2\2\u00a7\u00a1\3\2\2\2\u00a7\u00a5\3\2\2"+
		"\2\u00a8\13\3\2\2\2\u00a9\u00aa\7\21\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac"+
		"\7\r\2\2\u00ac\u00ad\5$\23\2\u00ad\r\3\2\2\2\u00ae\u00af\7\20\2\2\u00af"+
		"\u00b0\7G\2\2\u00b0\u00b1\7\r\2\2\u00b1\u00b4\5$\23\2\u00b2\u00b3\7?\2"+
		"\2\u00b3\u00b5\5$\23\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\17"+
		"\3\2\2\2\u00b6\u00b7\7H\2\2\u00b7\u00c5\5F$\2\u00b8\u00b9\5F$\2\u00b9"+
		"\u00ba\7H\2\2\u00ba\u00c5\3\2\2\2\u00bb\u00bc\7I\2\2\u00bc\u00c5\5F$\2"+
		"\u00bd\u00be\5F$\2\u00be\u00bf\7I\2\2\u00bf\u00c5\3\2\2\2\u00c0\u00c1"+
		"\7M\2\2\u00c1\u00c5\5F$\2\u00c2\u00c3\7N\2\2\u00c3\u00c5\5F$\2\u00c4\u00b6"+
		"\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4\u00bd\3\2\2\2\u00c4"+
		"\u00c0\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\21\3\2\2\2\u00c6\u00c7\5F$\2"+
		"\u00c7\u00c8\7U\2\2\u00c8\u00c9\5$\23\2\u00c9\23\3\2\2\2\u00ca\u00cb\7"+
		"\t\2\2\u00cb\u00cc\7[\2\2\u00cc\u00cd\5$\23\2\u00cd\u00ce\7\\\2\2\u00ce"+
		"\u00cf\5\6\4\2\u00cf\25\3\2\2\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\5\6\4"+
		"\2\u00d2\u00d3\7\t\2\2\u00d3\u00d4\7[\2\2\u00d4\u00d5\5$\23\2\u00d5\u00d6"+
		"\7\\\2\2\u00d6\27\3\2\2\2\u00d7\u00d8\7\7\2\2\u00d8\u00d9\7[\2\2\u00d9"+
		"\u00da\5$\23\2\u00da\u00db\7\\\2\2\u00db\u00de\5\6\4\2\u00dc\u00dd\7\b"+
		"\2\2\u00dd\u00df\5\6\4\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\31\3\2\2\2\u00e0\u00e1\7\13\2\2\u00e1\u00e3\7[\2\2\u00e2\u00e4\5\34\17"+
		"\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6"+
		"\7b\2\2\u00e6\u00e7\5$\23\2\u00e7\u00ea\7b\2\2\u00e8\u00eb\5\22\n\2\u00e9"+
		"\u00eb\5\20\t\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3"+
		"\2\2\2\u00ec\u00ed\7\\\2\2\u00ed\u00ee\5\6\4\2\u00ee\33\3\2\2\2\u00ef"+
		"\u00f0\5\22\n\2\u00f0\35\3\2\2\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\7G\2"+
		"\2\u00f3\u00f4\7\r\2\2\u00f4\u00f5\5$\23\2\u00f5\u00f6\5\6\4\2\u00f6\37"+
		"\3\2\2\2\u00f7\u00f8\7G\2\2\u00f8\u0101\7[\2\2\u00f9\u00fe\5\"\22\2\u00fa"+
		"\u00fb\7g\2\2\u00fb\u00fd\5\"\22\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u00f9\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u010d\7\\\2\2\u0104\u0105\7\31\2\2\u0105\u010a\7G\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0109\7G\2\2\u0108\u0106\3\2\2\2\u0109\u010c\3\2\2"+
		"\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010d\u0104\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0110\5\n\6\2\u0110!\3\2\2\2\u0111\u0113\7\17\2\2\u0112\u0111\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7G\2\2\u0115#\3\2"+
		"\2\2\u0116\u011c\5&\24\2\u0117\u0118\7l\2\2\u0118\u0119\5$\23\2\u0119"+
		"\u011a\7c\2\2\u011a\u011b\5$\23\2\u011b\u011d\3\2\2\2\u011c\u0117\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d%\3\2\2\2\u011e\u0123\5(\25\2\u011f\u0120"+
		"\7_\2\2\u0120\u0122\5(\25\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\'\3\2\2\2\u0125\u0123\3\2\2\2"+
		"\u0126\u012b\5*\26\2\u0127\u0128\7`\2\2\u0128\u012a\5*\26\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		")\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0133\5,\27\2\u012f\u0130\7\r\2\2"+
		"\u0130\u0132\5,\27\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134+\3\2\2\2\u0135\u0133\3\2\2\2\u0136"+
		"\u013b\5.\30\2\u0137\u0138\t\3\2\2\u0138\u013a\5.\30\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"-\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u0143\5\60\31\2\u013f\u0140\t\4\2"+
		"\2\u0140\u0142\5\60\31\2\u0141\u013f\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144/\3\2\2\2\u0145\u0143\3\2\2\2"+
		"\u0146\u014b\5\62\32\2\u0147\u0148\t\5\2\2\u0148\u014a\5\62\32\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\61\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0153\5\64\33\2\u014f"+
		"\u0150\t\6\2\2\u0150\u0152\5\64\33\2\u0151\u014f\3\2\2\2\u0152\u0155\3"+
		"\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\63\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\u0156\u015b\5\66\34\2\u0157\u0158\7J\2\2\u0158\u015a\5"+
		"\66\34\2\u0159\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\65\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0163\58\35"+
		"\2\u015f\u0160\t\7\2\2\u0160\u0162\58\35\2\u0161\u015f\3\2\2\2\u0162\u0165"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\67\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u016b\5:\36\2\u0167\u0168\t\b\2\2\u0168\u016a\5:"+
		"\36\2\u0169\u0167\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c9\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u0173\5<\37\2"+
		"\u016f\u0170\t\t\2\2\u0170\u0172\5<\37\2\u0171\u016f\3\2\2\2\u0172\u0175"+
		"\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174;\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0176\u0177\t\n\2\2\u0177\u017c\5<\37\2\u0178\u0179\t\13"+
		"\2\2\u0179\u017c\5<\37\2\u017a\u017c\5> \2\u017b\u0176\3\2\2\2\u017b\u0178"+
		"\3\2\2\2\u017b\u017a\3\2\2\2\u017c=\3\2\2\2\u017d\u0181\5@!\2\u017e\u0180"+
		"\t\f\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182?\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u018c\5Z.\2\u0185"+
		"\u018c\5F$\2\u0186\u018c\5B\"\2\u0187\u0188\7[\2\2\u0188\u0189\5$\23\2"+
		"\u0189\u018a\7\\\2\2\u018a\u018c\3\2\2\2\u018b\u0184\3\2\2\2\u018b\u0185"+
		"\3\2\2\2\u018b\u0186\3\2\2\2\u018b\u0187\3\2\2\2\u018cA\3\2\2\2\u018d"+
		"\u0190\5D#\2\u018e\u0190\5J&\2\u018f\u018d\3\2\2\2\u018f\u018e\3\2\2\2"+
		"\u0190C\3\2\2\2\u0191\u0196\7D\2\2\u0192\u0196\7E\2\2\u0193\u0196\7F\2"+
		"\2\u0194\u0196\7m\2\2\u0195\u0191\3\2\2\2\u0195\u0192\3\2\2\2\u0195\u0193"+
		"\3\2\2\2\u0195\u0194\3\2\2\2\u0196E\3\2\2\2\u0197\u019c\5H%\2\u0198\u0199"+
		"\t\2\2\2\u0199\u019b\5H%\2\u019a\u0198\3\2\2\2\u019b\u019e\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019dG\3\2\2\2\u019e\u019c\3\2\2\2"+
		"\u019f\u01a6\5Z.\2\u01a0\u01a1\7i\2\2\u01a1\u01a2\5$\23\2\u01a2\u01a3"+
		"\7j\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01b4\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a9\u01b0\7G\2\2\u01aa\u01ab\7i\2\2\u01ab\u01ac\5$\23\2\u01ac\u01ad"+
		"\7j\2\2\u01ad\u01af\3\2\2\2\u01ae\u01aa\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2"+
		"\2\2\u01b3\u019f\3\2\2\2\u01b3\u01a9\3\2\2\2\u01b4I\3\2\2\2\u01b5\u01ba"+
		"\5P)\2\u01b6\u01ba\5R*\2\u01b7\u01ba\5X-\2\u01b8\u01ba\5T+\2\u01b9\u01b5"+
		"\3\2\2\2\u01b9\u01b6\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba"+
		"K\3\2\2\2\u01bb\u01bc\5$\23\2\u01bc\u01bd\7h\2\2\u01bd\u01be\7h\2\2\u01be"+
		"\u01bf\5$\23\2\u01bfM\3\2\2\2\u01c0\u01c1\5$\23\2\u01c1\u01c2\7d\2\2\u01c2"+
		"\u01c3\7G\2\2\u01c3\u01c4\7\r\2\2\u01c4\u01c5\5$\23\2\u01c5\u01d3\3\2"+
		"\2\2\u01c6\u01c7\7G\2\2\u01c7\u01c8\7\16\2\2\u01c8\u01c9\5$\23\2\u01c9"+
		"\u01ca\7d\2\2\u01ca\u01cb\5$\23\2\u01cb\u01d3\3\2\2\2\u01cc\u01cd\5$\23"+
		"\2\u01cd\u01ce\7d\2\2\u01ce\u01cf\7G\2\2\u01cf\u01d0\7\16\2\2\u01d0\u01d1"+
		"\5$\23\2\u01d1\u01d3\3\2\2\2\u01d2\u01c0\3\2\2\2\u01d2\u01c6\3\2\2\2\u01d2"+
		"\u01cc\3\2\2\2\u01d3O\3\2\2\2\u01d4\u01d5\7i\2\2\u01d5\u01d6\5N(\2\u01d6"+
		"\u01d7\7j\2\2\u01d7\u01e9\3\2\2\2\u01d8\u01e1\7i\2\2\u01d9\u01de\5$\23"+
		"\2\u01da\u01db\7g\2\2\u01db\u01dd\5$\23\2\u01dc\u01da\3\2\2\2\u01dd\u01e0"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e2\3\2\2\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01d9\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u01e9\7j\2\2\u01e4\u01e5\7i\2\2\u01e5\u01e6\5L\'\2\u01e6\u01e7"+
		"\7j\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01d4\3\2\2\2\u01e8\u01d8\3\2\2\2\u01e8"+
		"\u01e4\3\2\2\2\u01e9Q\3\2\2\2\u01ea\u0200\7\30\2\2\u01eb\u01ec\7O\2\2"+
		"\u01ec\u01ed\5N(\2\u01ed\u01ee\7P\2\2\u01ee\u0200\3\2\2\2\u01ef\u01f8"+
		"\7O\2\2\u01f0\u01f5\5$\23\2\u01f1\u01f2\7g\2\2\u01f2\u01f4\5$\23\2\u01f3"+
		"\u01f1\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6\3\2"+
		"\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f0\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u0200\7P\2\2\u01fb\u01fc\7O\2"+
		"\2\u01fc\u01fd\5L\'\2\u01fd\u01fe\7P\2\2\u01fe\u0200\3\2\2\2\u01ff\u01ea"+
		"\3\2\2\2\u01ff\u01eb\3\2\2\2\u01ff\u01ef\3\2\2\2\u01ff\u01fb\3\2\2\2\u0200"+
		"S\3\2\2\2\u0201\u0203\7e\2\2\u0202\u0204\5V,\2\u0203\u0202\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0207\3\2"+
		"\2\2\u0207\u0208\7f\2\2\u0208U\3\2\2\2\u0209\u020a\7G\2\2\u020a\u020b"+
		"\7@\2\2\u020b\u020c\5$\23\2\u020cW\3\2\2\2\u020d\u0223\7\27\2\2\u020e"+
		"\u020f\7e\2\2\u020f\u0210\5N(\2\u0210\u0211\7f\2\2\u0211\u0223\3\2\2\2"+
		"\u0212\u021b\7e\2\2\u0213\u0218\5$\23\2\u0214\u0215\7g\2\2\u0215\u0217"+
		"\5$\23\2\u0216\u0214\3\2\2\2\u0217\u021a\3\2\2\2\u0218\u0216\3\2\2\2\u0218"+
		"\u0219\3\2\2\2\u0219\u021c\3\2\2\2\u021a\u0218\3\2\2\2\u021b\u0213\3\2"+
		"\2\2\u021b\u021c\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0223\7f\2\2\u021e"+
		"\u021f\7e\2\2\u021f\u0220\5L\'\2\u0220\u0221\7f\2\2\u0221\u0223\3\2\2"+
		"\2\u0222\u020d\3\2\2\2\u0222\u020e\3\2\2\2\u0222\u0212\3\2\2\2\u0222\u021e"+
		"\3\2\2\2\u0223Y\3\2\2\2\u0224\u0233\5\\/\2\u0225\u0226\7G\2\2\u0226\u022f"+
		"\7[\2\2\u0227\u022c\5$\23\2\u0228\u0229\7g\2\2\u0229\u022b\5$\23\2\u022a"+
		"\u0228\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2"+
		"\2\2\u022d\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0227\3\2\2\2\u022f"+
		"\u0230\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\7\\\2\2\u0232\u0224\3\2"+
		"\2\2\u0232\u0225\3\2\2\2\u0233[\3\2\2\2\u0234\u0235\5^\60\2\u0235\u023e"+
		"\7[\2\2\u0236\u023b\5$\23\2\u0237\u0238\7g\2\2\u0238\u023a\5$\23\2\u0239"+
		"\u0237\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u0236\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\7\\\2\2\u0241]\3\2\2\2"+
		"\u0242\u0243\t\r\2\2\u0243_\3\2\2\2\u0244\u0246\5b\62\2\u0245\u0244\3"+
		"\2\2\2\u0246\u0249\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"a\3\2\2\2\u0249\u0247\3\2\2\2\u024a\u024b\7G\2\2\u024b\u024c\7\6\2\2\u024c"+
		"\u024d\5$\23\2\u024dc\3\2\2\28emz\u0098\u00a7\u00b4\u00c4\u00de\u00e3"+
		"\u00ea\u00fe\u0101\u010a\u010d\u0112\u011c\u0123\u012b\u0133\u013b\u0143"+
		"\u014b\u0153\u015b\u0163\u016b\u0173\u017b\u0181\u018b\u018f\u0195\u019c"+
		"\u01a6\u01b0\u01b3\u01b9\u01d2\u01de\u01e1\u01e8\u01f5\u01f8\u01ff\u0205"+
		"\u0218\u021b\u0222\u022c\u022f\u0232\u023b\u023e\u0247";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
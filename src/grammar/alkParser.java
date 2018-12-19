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
	public static final int
		RULE_main = 0, RULE_statement_sequence = 1, RULE_statement = 2, RULE_statement_block = 3, 
		RULE_choose = 4, RULE_increase_decrease = 5, RULE_assignment = 6, RULE_while_struct = 7, 
		RULE_do_while_struct = 8, RULE_if_struct = 9, RULE_for_struct = 10, RULE_forall_struct = 11, 
		RULE_function_decl = 12, RULE_param = 13, RULE_set_expression = 14, RULE_set_atom = 15, 
		RULE_expression = 16, RULE_logical_or_expression = 17, RULE_logical_and_expression = 18, 
		RULE_in_expression = 19, RULE_equality_expression = 20, RULE_relational_expression = 21, 
		RULE_shift_expression = 22, RULE_additive_expression = 23, RULE_multiplicative_expression = 24, 
		RULE_unary_expression = 25, RULE_postfix_expression = 26, RULE_factor = 27, 
		RULE_value = 28, RULE_scalar_value = 29, RULE_ref_name = 30, RULE_ref_name_chunk = 31, 
		RULE_data_structure = 32, RULE_interval = 33, RULE_spec = 34, RULE_array = 35, 
		RULE_list = 36, RULE_structure = 37, RULE_component = 38, RULE_set = 39, 
		RULE_function_call = 40, RULE_builtin_method = 41, RULE_method_name = 42;
	public static final String[] ruleNames = {
		"main", "statement_sequence", "statement", "statement_block", "choose", 
		"increase_decrease", "assignment", "while_struct", "do_while_struct", 
		"if_struct", "for_struct", "forall_struct", "function_decl", "param", 
		"set_expression", "set_atom", "expression", "logical_or_expression", "logical_and_expression", 
		"in_expression", "equality_expression", "relational_expression", "shift_expression", 
		"additive_expression", "multiplicative_expression", "unary_expression", 
		"postfix_expression", "factor", "value", "scalar_value", "ref_name", "ref_name_chunk", 
		"data_structure", "interval", "spec", "array", "list", "structure", "component", 
		"set", "function_call", "builtin_method", "method_name"
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
		public TerminalNode EOF() { return getToken(alkParser.EOF, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FORALL) | (1L << CHOOSE) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD))) != 0) || _la==LCB) {
				{
				setState(86);
				statement_sequence();
				}
			}

			setState(89);
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
		public Statement_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_sequence; }
	 
		public Statement_sequenceContext() { }
		public void copyFrom(Statement_sequenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ToInstructionContext extends Statement_sequenceContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ToInstructionContext(Statement_sequenceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToInstruction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstructionSeqContext extends Statement_sequenceContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public InstructionSeqContext(Statement_sequenceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitInstructionSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_sequenceContext statement_sequence() throws RecognitionException {
		Statement_sequenceContext _localctx = new Statement_sequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_sequence);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ToInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				statement();
				}
				break;
			case 2:
				_localctx = new InstructionSeqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				statement();
				setState(93);
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
	public static class ToAssignContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(alkParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
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
	public static class ForContext extends StatementContext {
		public For_structContext for_struct() {
			return getRuleContext(For_structContext.class,0);
		}
		public ForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToFContext extends StatementContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public TerminalNode POINT() { return getToken(alkParser.POINT, 0); }
		public TerminalNode ARROW() { return getToken(alkParser.ARROW, 0); }
		public ToFContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToF(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileContext extends StatementContext {
		public Do_while_structContext do_while_struct() {
			return getRuleContext(Do_while_structContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public DoWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDoWhile(this);
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
	public static class ToFunContext extends StatementContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToFunContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToFun(this);
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
	public static class IDContext extends StatementContext {
		public Increase_decreaseContext increase_decrease() {
			return getRuleContext(Increase_decreaseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public IDContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForAllContext extends StatementContext {
		public Forall_structContext forall_struct() {
			return getRuleContext(Forall_structContext.class,0);
		}
		public ForAllContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TOFDContext extends StatementContext {
		public Function_declContext function_decl() {
			return getRuleContext(Function_declContext.class,0);
		}
		public TOFDContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitTOFD(this);
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
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ToFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				ref_name();
				setState(98);
				_la = _input.LA(1);
				if ( !(_la==ARROW || _la==POINT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(99);
				function_call();
				setState(100);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ToFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				function_call();
				setState(103);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new TOFDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				function_decl();
				}
				break;
			case 4:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(RETURN);
				setState(107);
				expression();
				setState(108);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new ChooseStmContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				choose();
				setState(111);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new SuccessContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				match(SUCCESS);
				setState(114);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new FailureContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				match(FAILURE);
				setState(116);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new ToAssignContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(117);
				assignment();
				setState(118);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new IDContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(120);
				increase_decrease();
				setState(121);
				match(SEMICOLON);
				}
				break;
			case 10:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(123);
				statement_block();
				}
				break;
			case 11:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(124);
				while_struct();
				}
				break;
			case 12:
				_localctx = new DoWhileContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(125);
				do_while_struct();
				setState(126);
				match(SEMICOLON);
				}
				break;
			case 13:
				_localctx = new ToIfContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(128);
				if_struct();
				}
				break;
			case 14:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(129);
				for_struct();
				}
				break;
			case 15:
				_localctx = new ForAllContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(130);
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
		enterRule(_localctx, 6, RULE_statement_block);
		try {
			_localctx = new BlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LCB);
			setState(134);
			statement_sequence();
			setState(135);
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

	public static class ChooseContext extends ParserRuleContext {
		public TerminalNode CHOOSE() { return getToken(alkParser.CHOOSE, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choose; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitChoose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseContext choose() throws RecognitionException {
		ChooseContext _localctx = new ChooseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_choose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(CHOOSE);
			setState(138);
			match(ID);
			setState(139);
			match(IN);
			setState(140);
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

	public static class Increase_decreaseContext extends ParserRuleContext {
		public TerminalNode PLUSPLUS() { return getToken(alkParser.PLUSPLUS, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode MINUSMINUS() { return getToken(alkParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(alkParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(alkParser.MINUSMINUSMOD, 0); }
		public Increase_decreaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increase_decrease; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIncrease_decrease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Increase_decreaseContext increase_decrease() throws RecognitionException {
		Increase_decreaseContext _localctx = new Increase_decreaseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_increase_decrease);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(PLUSPLUS);
				setState(143);
				ref_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				ref_name();
				setState(145);
				match(PLUSPLUS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(MINUSMINUS);
				setState(148);
				ref_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				ref_name();
				setState(150);
				match(MINUSMINUS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(PLUSPLUSMOD);
				setState(153);
				ref_name();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(MINUSMINUSMOD);
				setState(155);
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
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(alkParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			ref_name();
			setState(159);
			match(ASSIGNMENT_OPERATOR);
			setState(160);
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
	public static class WhileContext extends While_structContext {
		public TerminalNode WHILE() { return getToken(alkParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(While_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_structContext while_struct() throws RecognitionException {
		While_structContext _localctx = new While_structContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while_struct);
		try {
			_localctx = new WhileContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WHILE);
			setState(163);
			match(LPAR);
			setState(164);
			expression();
			setState(165);
			match(RPAR);
			setState(166);
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
		public Do_while_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDo_while_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_structContext do_while_struct() throws RecognitionException {
		Do_while_structContext _localctx = new Do_while_structContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_do_while_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(DO);
			setState(169);
			statement();
			setState(170);
			match(WHILE);
			setState(171);
			match(LPAR);
			setState(172);
			expression();
			setState(173);
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
		public If_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIf_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_structContext if_struct() throws RecognitionException {
		If_structContext _localctx = new If_structContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(IF);
			setState(176);
			match(LPAR);
			setState(177);
			expression();
			setState(178);
			match(RPAR);
			setState(179);
			statement();
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(180);
				match(ELSE);
				setState(181);
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
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public Increase_decreaseContext increase_decrease() {
			return getRuleContext(Increase_decreaseContext.class,0);
		}
		public For_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFor_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_structContext for_struct() throws RecognitionException {
		For_structContext _localctx = new For_structContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(FOR);
			setState(185);
			match(LPAR);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << ID))) != 0)) {
				{
				setState(186);
				assignment();
				}
			}

			setState(189);
			match(SEMICOLON);
			setState(190);
			expression();
			setState(191);
			match(SEMICOLON);
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(192);
				assignment();
				}
				break;
			case 2:
				{
				setState(193);
				increase_decrease();
				}
				break;
			}
			setState(196);
			match(RPAR);
			setState(197);
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

	public static class Forall_structContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(alkParser.FORALL, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Forall_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forall_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForall_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Forall_structContext forall_struct() throws RecognitionException {
		Forall_structContext _localctx = new Forall_structContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forall_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(FORALL);
			setState(200);
			match(ID);
			setState(201);
			match(IN);
			setState(202);
			expression();
			setState(203);
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
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public Function_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunction_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declContext function_decl() throws RecognitionException {
		Function_declContext _localctx = new Function_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(ID);
			setState(206);
			match(LPAR);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT || _la==ID) {
				{
				setState(207);
				param();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(208);
					match(COMMA);
					setState(209);
					param();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(217);
			match(RPAR);
			setState(218);
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode OUT() { return getToken(alkParser.OUT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT) {
				{
				setState(220);
				match(OUT);
				}
			}

			setState(223);
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

	public static class Set_expressionContext extends ParserRuleContext {
		public List<Set_atomContext> set_atom() {
			return getRuleContexts(Set_atomContext.class);
		}
		public Set_atomContext set_atom(int i) {
			return getRuleContext(Set_atomContext.class,i);
		}
		public List<TerminalNode> UNION() { return getTokens(alkParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(alkParser.UNION, i);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(alkParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(alkParser.INTERSECT, i);
		}
		public List<TerminalNode> SUBSTRACT() { return getTokens(alkParser.SUBSTRACT); }
		public TerminalNode SUBSTRACT(int i) {
			return getToken(alkParser.SUBSTRACT, i);
		}
		public Set_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSet_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_expressionContext set_expression() throws RecognitionException {
		Set_expressionContext _localctx = new Set_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_set_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			set_atom();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << INTERSECT) | (1L << SUBSTRACT))) != 0)) {
				{
				{
				setState(226);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << INTERSECT) | (1L << SUBSTRACT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				set_atom();
				}
				}
				setState(232);
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

	public static class Set_atomContext extends ParserRuleContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public Set_expressionContext set_expression() {
			return getRuleContext(Set_expressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public Set_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSet_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_atomContext set_atom() throws RecognitionException {
		Set_atomContext _localctx = new Set_atomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_set_atom);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case INSERT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				ref_name();
				}
				break;
			case EMPTYSET:
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				set();
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(LPAR);
				setState(236);
				set_expression();
				setState(237);
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

	public static class ExpressionContext extends ParserRuleContext {
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			logical_or_expression();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(242);
				match(QUESTION);
				setState(243);
				expression();
				setState(244);
				match(DPOINT);
				setState(245);
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
		public Logical_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitLogical_or_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_expressionContext logical_or_expression() throws RecognitionException {
		Logical_or_expressionContext _localctx = new Logical_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logical_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			logical_and_expression();
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(250);
				match(OR);
				setState(251);
				logical_and_expression();
				}
				}
				setState(256);
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
		public Logical_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitLogical_and_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_expressionContext logical_and_expression() throws RecognitionException {
		Logical_and_expressionContext _localctx = new Logical_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logical_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			in_expression();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(258);
				match(AND);
				setState(259);
				in_expression();
				}
				}
				setState(264);
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
		public In_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIn_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_expressionContext in_expression() throws RecognitionException {
		In_expressionContext _localctx = new In_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_in_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			equality_expression();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN) {
				{
				{
				setState(266);
				match(IN);
				setState(267);
				equality_expression();
				}
				}
				setState(272);
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
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEquality_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			relational_expression();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ISEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(274);
				_la = _input.LA(1);
				if ( !(_la==ISEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(275);
				relational_expression();
				}
				}
				setState(280);
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
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
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
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRelational_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_relational_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			shift_expression();
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(282);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOWER) | (1L << GREATER) | (1L << LOWEREQ) | (1L << GREATEREQ))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(283);
					shift_expression();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitShift_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			additive_expression();
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTSHIFT || _la==RIGHTSHIFT) {
				{
				{
				setState(290);
				_la = _input.LA(1);
				if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291);
				additive_expression();
				}
				}
				setState(296);
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
		enterRule(_localctx, 46, RULE_additive_expression);
		int _la;
		try {
			_localctx = new AdditiveExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			multiplicative_expression();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSMOD) | (1L << MINUSMOD) | (1L << MINUS) | (1L << PLUS))) != 0)) {
				{
				{
				setState(298);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSMOD) | (1L << MINUSMOD) | (1L << MINUS) | (1L << PLUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(299);
				multiplicative_expression();
				}
				}
				setState(304);
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
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMultiplicative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			unary_expression();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (MUL - 62)) | (1L << (DIV - 62)) | (1L << (MOD - 62)))) != 0)) {
				{
				{
				setState(306);
				_la = _input.LA(1);
				if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (MUL - 62)) | (1L << (DIV - 62)) | (1L << (MOD - 62)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(307);
				unary_expression();
				}
				}
				setState(312);
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
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode PLUSPLUS() { return getToken(alkParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(alkParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(alkParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(alkParser.MINUSMINUSMOD, 0); }
		public TerminalNode MUL() { return getToken(alkParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(alkParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(alkParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(alkParser.NOT, 0); }
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unary_expression);
		int _la;
		try {
			setState(318);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUSPLUSMOD:
			case MINUSMINUSMOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(314);
				unary_expression();
				}
				break;
			case MINUS:
			case PLUS:
			case MUL:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				_la = _input.LA(1);
				if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (MINUS - 60)) | (1L << (PLUS - 60)) | (1L << (MUL - 60)) | (1L << (NOT - 60)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(316);
				unary_expression();
				}
				break;
			case EMPTYSET:
			case EMPTYLIST:
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case INSERT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
			case INT:
			case DOUBLE:
			case BOOL:
			case ID:
			case LOWER:
			case LPAR:
			case LCB:
			case LBRA:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
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
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitPostfix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_postfix_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			factor();
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(321);
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
				setState(326);
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

	public static class FactorContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_factor);
		try {
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				ref_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
				match(LPAR);
				setState(331);
				expression();
				setState(332);
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
		enterRule(_localctx, 56, RULE_value);
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case BOOL:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				scalar_value();
				}
				break;
			case EMPTYSET:
			case EMPTYLIST:
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case INSERT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
			case ID:
			case LOWER:
			case LPAR:
			case LCB:
			case LBRA:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
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
		enterRule(_localctx, 58, RULE_scalar_value);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				match(DOUBLE);
				}
				break;
			case BOOL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(343);
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
		public Ref_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRef_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_nameContext ref_name() throws RecognitionException {
		Ref_nameContext _localctx = new Ref_nameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_ref_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			ref_name_chunk();
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(347);
					_la = _input.LA(1);
					if ( !(_la==ARROW || _la==POINT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(348);
					ref_name_chunk();
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public Ref_name_chunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name_chunk; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRef_name_chunk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_name_chunkContext ref_name_chunk() throws RecognitionException {
		Ref_name_chunkContext _localctx = new Ref_name_chunkContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ref_name_chunk);
		int _la;
		try {
			setState(374);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				function_call();
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(355);
					match(LBRA);
					setState(356);
					expression();
					setState(357);
					match(RBRA);
					}
					}
					setState(363);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				match(ID);
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(365);
					match(LBRA);
					setState(366);
					expression();
					setState(367);
					match(RBRA);
					}
					}
					setState(373);
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Set_expressionContext set_expression() {
			return getRuleContext(Set_expressionContext.class,0);
		}
		public StructureContext structure() {
			return getRuleContext(StructureContext.class,0);
		}
		public Data_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_structure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitData_structure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_structureContext data_structure() throws RecognitionException {
		Data_structureContext _localctx = new Data_structureContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_data_structure);
		try {
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				set_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
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
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_interval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			expression();
			setState(383);
			match(POINT);
			setState(384);
			match(POINT);
			setState(385);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VBAR() { return getToken(alkParser.VBAR, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode IN() { return getToken(alkParser.IN, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			expression();
			setState(388);
			match(VBAR);
			setState(389);
			match(ID);
			setState(390);
			match(IN);
			setState(391);
			interval();
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
		enterRule(_localctx, 70, RULE_array);
		int _la;
		try {
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ArrayWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				match(LBRA);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LPAR - 65)) | (1L << (NOT - 65)) | (1L << (LCB - 65)) | (1L << (LBRA - 65)) | (1L << (STRING - 65)))) != 0)) {
					{
					setState(394);
					expression();
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(395);
						match(COMMA);
						setState(396);
						expression();
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(404);
				match(RBRA);
				}
				break;
			case 2:
				_localctx = new ArrayWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(405);
				match(LBRA);
				setState(406);
				interval();
				setState(407);
				match(RBRA);
				}
				break;
			case 3:
				_localctx = new ArrayWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(409);
				match(LBRA);
				setState(410);
				spec();
				setState(411);
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
		public TerminalNode EMPTYLIST() { return getToken(alkParser.EMPTYLIST, 0); }
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
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_list);
		int _la;
		try {
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				match(EMPTYLIST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(416);
				match(LOWER);
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LPAR - 65)) | (1L << (NOT - 65)) | (1L << (LCB - 65)) | (1L << (LBRA - 65)) | (1L << (STRING - 65)))) != 0)) {
					{
					setState(417);
					expression();
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(418);
						match(COMMA);
						setState(419);
						expression();
						}
						}
						setState(424);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(427);
				match(GREATER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(428);
				match(LOWER);
				setState(429);
				interval();
				setState(430);
				match(GREATER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(432);
				match(LOWER);
				setState(433);
				spec();
				setState(434);
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
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public StructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(LCB);
			setState(440); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(439);
				component();
				}
				}
				setState(442); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(444);
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
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(alkParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_component);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(ID);
			setState(447);
			match(ARROW);
			setState(448);
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
		public TerminalNode EMPTYSET() { return getToken(alkParser.EMPTYSET, 0); }
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
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_set);
		int _la;
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(450);
				match(EMPTYSET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(451);
				match(LCB);
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LPAR - 65)) | (1L << (NOT - 65)) | (1L << (LCB - 65)) | (1L << (LBRA - 65)) | (1L << (STRING - 65)))) != 0)) {
					{
					setState(452);
					expression();
					setState(457);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(453);
						match(COMMA);
						setState(454);
						expression();
						}
						}
						setState(459);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(462);
				match(RCB);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(463);
				match(LCB);
				setState(464);
				interval();
				setState(465);
				match(RCB);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(467);
				match(LCB);
				setState(468);
				spec();
				setState(469);
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
		public Builtin_methodContext builtin_method() {
			return getRuleContext(Builtin_methodContext.class,0);
		}
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
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_function_call);
		int _la;
		try {
			setState(487);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
			case DELETE:
			case END:
			case FIRST:
			case INSERT:
			case POPBACK:
			case POPFRONT:
			case PUSHBACK:
			case PUSHFRONT:
			case REMOVE:
			case REMOVEALLEQTO:
			case REMOVEAT:
			case SINGLETONSET:
			case SIZE:
			case TOPBACK:
			case TOPFRONT:
			case UPDATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				builtin_method();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				match(ID);
				setState(475);
				match(LPAR);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LPAR - 65)) | (1L << (NOT - 65)) | (1L << (LCB - 65)) | (1L << (LBRA - 65)) | (1L << (STRING - 65)))) != 0)) {
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
		public Builtin_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBuiltin_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_methodContext builtin_method() throws RecognitionException {
		Builtin_methodContext _localctx = new Builtin_methodContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_builtin_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			method_name();
			setState(490);
			match(LPAR);
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (LPAR - 65)) | (1L << (NOT - 65)) | (1L << (LCB - 65)) | (1L << (LBRA - 65)) | (1L << (STRING - 65)))) != 0)) {
				{
				setState(491);
				expression();
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(492);
					match(COMMA);
					setState(493);
					expression();
					}
					}
					setState(498);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(501);
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
		public TerminalNode AT() { return getToken(alkParser.AT, 0); }
		public TerminalNode DELETE() { return getToken(alkParser.DELETE, 0); }
		public TerminalNode END() { return getToken(alkParser.END, 0); }
		public TerminalNode FIRST() { return getToken(alkParser.FIRST, 0); }
		public TerminalNode INSERT() { return getToken(alkParser.INSERT, 0); }
		public TerminalNode POPBACK() { return getToken(alkParser.POPBACK, 0); }
		public TerminalNode POPFRONT() { return getToken(alkParser.POPFRONT, 0); }
		public TerminalNode PUSHBACK() { return getToken(alkParser.PUSHBACK, 0); }
		public TerminalNode PUSHFRONT() { return getToken(alkParser.PUSHFRONT, 0); }
		public TerminalNode REMOVE() { return getToken(alkParser.REMOVE, 0); }
		public TerminalNode REMOVEALLEQTO() { return getToken(alkParser.REMOVEALLEQTO, 0); }
		public TerminalNode REMOVEAT() { return getToken(alkParser.REMOVEAT, 0); }
		public TerminalNode SINGLETONSET() { return getToken(alkParser.SINGLETONSET, 0); }
		public TerminalNode SIZE() { return getToken(alkParser.SIZE, 0); }
		public TerminalNode TOPFRONT() { return getToken(alkParser.TOPFRONT, 0); }
		public TerminalNode TOPBACK() { return getToken(alkParser.TOPBACK, 0); }
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
		enterRule(_localctx, 84, RULE_method_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3U\u01fc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\5\2Z\n\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3b\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0086\n\4\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u009f\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b9"+
		"\n\13\3\f\3\f\3\f\5\f\u00be\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c5\n\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u00d5\n"+
		"\16\f\16\16\16\u00d8\13\16\5\16\u00da\n\16\3\16\3\16\3\16\3\17\5\17\u00e0"+
		"\n\17\3\17\3\17\3\20\3\20\3\20\7\20\u00e7\n\20\f\20\16\20\u00ea\13\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f2\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u00fa\n\22\3\23\3\23\3\23\7\23\u00ff\n\23\f\23\16\23\u0102"+
		"\13\23\3\24\3\24\3\24\7\24\u0107\n\24\f\24\16\24\u010a\13\24\3\25\3\25"+
		"\3\25\7\25\u010f\n\25\f\25\16\25\u0112\13\25\3\26\3\26\3\26\7\26\u0117"+
		"\n\26\f\26\16\26\u011a\13\26\3\27\3\27\3\27\7\27\u011f\n\27\f\27\16\27"+
		"\u0122\13\27\3\30\3\30\3\30\7\30\u0127\n\30\f\30\16\30\u012a\13\30\3\31"+
		"\3\31\3\31\7\31\u012f\n\31\f\31\16\31\u0132\13\31\3\32\3\32\3\32\7\32"+
		"\u0137\n\32\f\32\16\32\u013a\13\32\3\33\3\33\3\33\3\33\3\33\5\33\u0141"+
		"\n\33\3\34\3\34\7\34\u0145\n\34\f\34\16\34\u0148\13\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u0151\n\35\3\36\3\36\5\36\u0155\n\36\3\37\3"+
		"\37\3\37\3\37\5\37\u015b\n\37\3 \3 \3 \7 \u0160\n \f \16 \u0163\13 \3"+
		"!\3!\3!\3!\3!\7!\u016a\n!\f!\16!\u016d\13!\3!\3!\3!\3!\3!\7!\u0174\n!"+
		"\f!\16!\u0177\13!\5!\u0179\n!\3\"\3\"\3\"\3\"\5\"\u017f\n\"\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\7%\u0190\n%\f%\16%\u0193\13%\5%\u0195"+
		"\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01a0\n%\3&\3&\3&\3&\3&\7&\u01a7\n&"+
		"\f&\16&\u01aa\13&\5&\u01ac\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01b7\n&\3"+
		"\'\3\'\6\'\u01bb\n\'\r\'\16\'\u01bc\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3"+
		")\7)\u01ca\n)\f)\16)\u01cd\13)\5)\u01cf\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\5)\u01da\n)\3*\3*\3*\3*\3*\3*\7*\u01e2\n*\f*\16*\u01e5\13*\5*\u01e7\n"+
		"*\3*\5*\u01ea\n*\3+\3+\3+\3+\3+\7+\u01f1\n+\f+\16+\u01f4\13+\5+\u01f6"+
		"\n+\3+\3+\3,\3,\3,\2\2-\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BDFHJLNPRTV\2\r\4\2((PP\3\2)+\3\2;<\3\2\67:\3\2EF\4"+
		"\2\63\64>?\3\2@B\4\2\60\61\65\66\4\2>@II\3\2\60\61\5\2\24\24\26\26\30"+
		"&\2\u021c\2Y\3\2\2\2\4a\3\2\2\2\6\u0085\3\2\2\2\b\u0087\3\2\2\2\n\u008b"+
		"\3\2\2\2\f\u009e\3\2\2\2\16\u00a0\3\2\2\2\20\u00a4\3\2\2\2\22\u00aa\3"+
		"\2\2\2\24\u00b1\3\2\2\2\26\u00ba\3\2\2\2\30\u00c9\3\2\2\2\32\u00cf\3\2"+
		"\2\2\34\u00df\3\2\2\2\36\u00e3\3\2\2\2 \u00f1\3\2\2\2\"\u00f3\3\2\2\2"+
		"$\u00fb\3\2\2\2&\u0103\3\2\2\2(\u010b\3\2\2\2*\u0113\3\2\2\2,\u011b\3"+
		"\2\2\2.\u0123\3\2\2\2\60\u012b\3\2\2\2\62\u0133\3\2\2\2\64\u0140\3\2\2"+
		"\2\66\u0142\3\2\2\28\u0150\3\2\2\2:\u0154\3\2\2\2<\u015a\3\2\2\2>\u015c"+
		"\3\2\2\2@\u0178\3\2\2\2B\u017e\3\2\2\2D\u0180\3\2\2\2F\u0185\3\2\2\2H"+
		"\u019f\3\2\2\2J\u01b6\3\2\2\2L\u01b8\3\2\2\2N\u01c0\3\2\2\2P\u01d9\3\2"+
		"\2\2R\u01e9\3\2\2\2T\u01eb\3\2\2\2V\u01f9\3\2\2\2XZ\5\4\3\2YX\3\2\2\2"+
		"YZ\3\2\2\2Z[\3\2\2\2[\\\7\2\2\3\\\3\3\2\2\2]b\5\6\4\2^_\5\6\4\2_`\5\4"+
		"\3\2`b\3\2\2\2a]\3\2\2\2a^\3\2\2\2b\5\3\2\2\2cd\5> \2de\t\2\2\2ef\5R*"+
		"\2fg\7J\2\2g\u0086\3\2\2\2hi\5R*\2ij\7J\2\2j\u0086\3\2\2\2k\u0086\5\32"+
		"\16\2lm\7\17\2\2mn\5\"\22\2no\7J\2\2o\u0086\3\2\2\2pq\5\n\6\2qr\7J\2\2"+
		"r\u0086\3\2\2\2st\7\20\2\2t\u0086\7J\2\2uv\7\21\2\2v\u0086\7J\2\2wx\5"+
		"\16\b\2xy\7J\2\2y\u0086\3\2\2\2z{\5\f\7\2{|\7J\2\2|\u0086\3\2\2\2}\u0086"+
		"\5\b\5\2~\u0086\5\20\t\2\177\u0080\5\22\n\2\u0080\u0081\7J\2\2\u0081\u0086"+
		"\3\2\2\2\u0082\u0086\5\24\13\2\u0083\u0086\5\26\f\2\u0084\u0086\5\30\r"+
		"\2\u0085c\3\2\2\2\u0085h\3\2\2\2\u0085k\3\2\2\2\u0085l\3\2\2\2\u0085p"+
		"\3\2\2\2\u0085s\3\2\2\2\u0085u\3\2\2\2\u0085w\3\2\2\2\u0085z\3\2\2\2\u0085"+
		"}\3\2\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0084\3\2\2\2\u0086\7\3\2\2\2\u0087\u0088\7M\2\2\u0088"+
		"\u0089\5\4\3\2\u0089\u008a\7N\2\2\u008a\t\3\2\2\2\u008b\u008c\7\16\2\2"+
		"\u008c\u008d\7/\2\2\u008d\u008e\7\f\2\2\u008e\u008f\5\"\22\2\u008f\13"+
		"\3\2\2\2\u0090\u0091\7\60\2\2\u0091\u009f\5> \2\u0092\u0093\5> \2\u0093"+
		"\u0094\7\60\2\2\u0094\u009f\3\2\2\2\u0095\u0096\7\61\2\2\u0096\u009f\5"+
		"> \2\u0097\u0098\5> \2\u0098\u0099\7\61\2\2\u0099\u009f\3\2\2\2\u009a"+
		"\u009b\7\65\2\2\u009b\u009f\5> \2\u009c\u009d\7\66\2\2\u009d\u009f\5>"+
		" \2\u009e\u0090\3\2\2\2\u009e\u0092\3\2\2\2\u009e\u0095\3\2\2\2\u009e"+
		"\u0097\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f\r\3\2\2\2"+
		"\u00a0\u00a1\5> \2\u00a1\u00a2\7=\2\2\u00a2\u00a3\5\"\22\2\u00a3\17\3"+
		"\2\2\2\u00a4\u00a5\7\b\2\2\u00a5\u00a6\7C\2\2\u00a6\u00a7\5\"\22\2\u00a7"+
		"\u00a8\7D\2\2\u00a8\u00a9\5\6\4\2\u00a9\21\3\2\2\2\u00aa\u00ab\7\t\2\2"+
		"\u00ab\u00ac\5\6\4\2\u00ac\u00ad\7\b\2\2\u00ad\u00ae\7C\2\2\u00ae\u00af"+
		"\5\"\22\2\u00af\u00b0\7D\2\2\u00b0\23\3\2\2\2\u00b1\u00b2\7\6\2\2\u00b2"+
		"\u00b3\7C\2\2\u00b3\u00b4\5\"\22\2\u00b4\u00b5\7D\2\2\u00b5\u00b8\5\6"+
		"\4\2\u00b6\u00b7\7\7\2\2\u00b7\u00b9\5\6\4\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\7\n\2\2\u00bb\u00bd\7C\2\2"+
		"\u00bc\u00be\5\16\b\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf\u00c0\7J\2\2\u00c0\u00c1\5\"\22\2\u00c1\u00c4\7J\2\2\u00c2"+
		"\u00c5\5\16\b\2\u00c3\u00c5\5\f\7\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7D\2\2\u00c7\u00c8\5\6\4\2\u00c8"+
		"\27\3\2\2\2\u00c9\u00ca\7\13\2\2\u00ca\u00cb\7/\2\2\u00cb\u00cc\7\f\2"+
		"\2\u00cc\u00cd\5\"\22\2\u00cd\u00ce\5\6\4\2\u00ce\31\3\2\2\2\u00cf\u00d0"+
		"\7/\2\2\u00d0\u00d9\7C\2\2\u00d1\u00d6\5\34\17\2\u00d2\u00d3\7O\2\2\u00d3"+
		"\u00d5\5\34\17\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00d1\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7D"+
		"\2\2\u00dc\u00dd\5\6\4\2\u00dd\33\3\2\2\2\u00de\u00e0\7\r\2\2\u00df\u00de"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2"+
		"\35\3\2\2\2\u00e3\u00e8\5 \21\2\u00e4\u00e5\t\3\2\2\u00e5\u00e7\5 \21"+
		"\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\37\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00f2\5> \2\u00ec"+
		"\u00f2\5P)\2\u00ed\u00ee\7C\2\2\u00ee\u00ef\5\36\20\2\u00ef\u00f0\7D\2"+
		"\2\u00f0\u00f2\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ed"+
		"\3\2\2\2\u00f2!\3\2\2\2\u00f3\u00f9\5$\23\2\u00f4\u00f5\7T\2\2\u00f5\u00f6"+
		"\5\"\22\2\u00f6\u00f7\7K\2\2\u00f7\u00f8\5\"\22\2\u00f8\u00fa\3\2\2\2"+
		"\u00f9\u00f4\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa#\3\2\2\2\u00fb\u0100\5"+
		"&\24\2\u00fc\u00fd\7G\2\2\u00fd\u00ff\5&\24\2\u00fe\u00fc\3\2\2\2\u00ff"+
		"\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101%\3\2\2\2"+
		"\u0102\u0100\3\2\2\2\u0103\u0108\5(\25\2\u0104\u0105\7H\2\2\u0105\u0107"+
		"\5(\25\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\'\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0110\5*\26\2"+
		"\u010c\u010d\7\f\2\2\u010d\u010f\5*\26\2\u010e\u010c\3\2\2\2\u010f\u0112"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111)\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0118\5,\27\2\u0114\u0115\t\4\2\2\u0115\u0117\5,"+
		"\27\2\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119+\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u0120\5.\30\2"+
		"\u011c\u011d\t\5\2\2\u011d\u011f\5.\30\2\u011e\u011c\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121-\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0128\5\60\31\2\u0124\u0125\t\6\2\2\u0125\u0127\5"+
		"\60\31\2\u0126\u0124\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129/\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0130\5\62\32"+
		"\2\u012c\u012d\t\7\2\2\u012d\u012f\5\62\32\2\u012e\u012c\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\61\3\2\2"+
		"\2\u0132\u0130\3\2\2\2\u0133\u0138\5\64\33\2\u0134\u0135\t\b\2\2\u0135"+
		"\u0137\5\64\33\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3"+
		"\2\2\2\u0138\u0139\3\2\2\2\u0139\63\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013c\t\t\2\2\u013c\u0141\5\64\33\2\u013d\u013e\t\n\2\2\u013e\u0141\5"+
		"\64\33\2\u013f\u0141\5\66\34\2\u0140\u013b\3\2\2\2\u0140\u013d\3\2\2\2"+
		"\u0140\u013f\3\2\2\2\u0141\65\3\2\2\2\u0142\u0146\58\35\2\u0143\u0145"+
		"\t\13\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2"+
		"\u0146\u0147\3\2\2\2\u0147\67\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u0151"+
		"\5R*\2\u014a\u0151\5> \2\u014b\u0151\5:\36\2\u014c\u014d\7C\2\2\u014d"+
		"\u014e\5\"\22\2\u014e\u014f\7D\2\2\u014f\u0151\3\2\2\2\u0150\u0149\3\2"+
		"\2\2\u0150\u014a\3\2\2\2\u0150\u014b\3\2\2\2\u0150\u014c\3\2\2\2\u0151"+
		"9\3\2\2\2\u0152\u0155\5<\37\2\u0153\u0155\5B\"\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0153\3\2\2\2\u0155;\3\2\2\2\u0156\u015b\7,\2\2\u0157\u015b\7-\2\2\u0158"+
		"\u015b\7.\2\2\u0159\u015b\7U\2\2\u015a\u0156\3\2\2\2\u015a\u0157\3\2\2"+
		"\2\u015a\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b=\3\2\2\2\u015c\u0161"+
		"\5@!\2\u015d\u015e\t\2\2\2\u015e\u0160\5@!\2\u015f\u015d\3\2\2\2\u0160"+
		"\u0163\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162?\3\2\2\2"+
		"\u0163\u0161\3\2\2\2\u0164\u016b\5R*\2\u0165\u0166\7Q\2\2\u0166\u0167"+
		"\5\"\22\2\u0167\u0168\7R\2\2\u0168\u016a\3\2\2\2\u0169\u0165\3\2\2\2\u016a"+
		"\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u0179\3\2"+
		"\2\2\u016d\u016b\3\2\2\2\u016e\u0175\7/\2\2\u016f\u0170\7Q\2\2\u0170\u0171"+
		"\5\"\22\2\u0171\u0172\7R\2\2\u0172\u0174\3\2\2\2\u0173\u016f\3\2\2\2\u0174"+
		"\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2"+
		"\2\2\u0177\u0175\3\2\2\2\u0178\u0164\3\2\2\2\u0178\u016e\3\2\2\2\u0179"+
		"A\3\2\2\2\u017a\u017f\5H%\2\u017b\u017f\5J&\2\u017c\u017f\5\36\20\2\u017d"+
		"\u017f\5L\'\2\u017e\u017a\3\2\2\2\u017e\u017b\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017e\u017d\3\2\2\2\u017fC\3\2\2\2\u0180\u0181\5\"\22\2\u0181\u0182"+
		"\7P\2\2\u0182\u0183\7P\2\2\u0183\u0184\5\"\22\2\u0184E\3\2\2\2\u0185\u0186"+
		"\5\"\22\2\u0186\u0187\7L\2\2\u0187\u0188\7/\2\2\u0188\u0189\7\f\2\2\u0189"+
		"\u018a\5D#\2\u018aG\3\2\2\2\u018b\u0194\7Q\2\2\u018c\u0191\5\"\22\2\u018d"+
		"\u018e\7O\2\2\u018e\u0190\5\"\22\2\u018f\u018d\3\2\2\2\u0190\u0193\3\2"+
		"\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0195\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194\u018c\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2"+
		"\2\2\u0196\u01a0\7R\2\2\u0197\u0198\7Q\2\2\u0198\u0199\5D#\2\u0199\u019a"+
		"\7R\2\2\u019a\u01a0\3\2\2\2\u019b\u019c\7Q\2\2\u019c\u019d\5F$\2\u019d"+
		"\u019e\7R\2\2\u019e\u01a0\3\2\2\2\u019f\u018b\3\2\2\2\u019f\u0197\3\2"+
		"\2\2\u019f\u019b\3\2\2\2\u01a0I\3\2\2\2\u01a1\u01b7\7\23\2\2\u01a2\u01ab"+
		"\7\67\2\2\u01a3\u01a8\5\"\22\2\u01a4\u01a5\7O\2\2\u01a5\u01a7\5\"\22\2"+
		"\u01a6\u01a4\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9"+
		"\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01a3\3\2\2\2\u01ab"+
		"\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b7\78\2\2\u01ae\u01af\7\67"+
		"\2\2\u01af\u01b0\5D#\2\u01b0\u01b1\78\2\2\u01b1\u01b7\3\2\2\2\u01b2\u01b3"+
		"\7\67\2\2\u01b3\u01b4\5F$\2\u01b4\u01b5\78\2\2\u01b5\u01b7\3\2\2\2\u01b6"+
		"\u01a1\3\2\2\2\u01b6\u01a2\3\2\2\2\u01b6\u01ae\3\2\2\2\u01b6\u01b2\3\2"+
		"\2\2\u01b7K\3\2\2\2\u01b8\u01ba\7M\2\2\u01b9\u01bb\5N(\2\u01ba\u01b9\3"+
		"\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01be\u01bf\7N\2\2\u01bfM\3\2\2\2\u01c0\u01c1\7/\2\2\u01c1"+
		"\u01c2\7(\2\2\u01c2\u01c3\5\"\22\2\u01c3O\3\2\2\2\u01c4\u01da\7\22\2\2"+
		"\u01c5\u01ce\7M\2\2\u01c6\u01cb\5\"\22\2\u01c7\u01c8\7O\2\2\u01c8\u01ca"+
		"\5\"\22\2\u01c9\u01c7\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2"+
		"\u01cb\u01cc\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01c6"+
		"\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01da\7N\2\2\u01d1"+
		"\u01d2\7M\2\2\u01d2\u01d3\5D#\2\u01d3\u01d4\7N\2\2\u01d4\u01da\3\2\2\2"+
		"\u01d5\u01d6\7M\2\2\u01d6\u01d7\5F$\2\u01d7\u01d8\7N\2\2\u01d8\u01da\3"+
		"\2\2\2\u01d9\u01c4\3\2\2\2\u01d9\u01c5\3\2\2\2\u01d9\u01d1\3\2\2\2\u01d9"+
		"\u01d5\3\2\2\2\u01daQ\3\2\2\2\u01db\u01ea\5T+\2\u01dc\u01dd\7/\2\2\u01dd"+
		"\u01e6\7C\2\2\u01de\u01e3\5\"\22\2\u01df\u01e0\7O\2\2\u01e0\u01e2\5\""+
		"\22\2\u01e1\u01df\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01de\3\2"+
		"\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01ea\7D\2\2\u01e9"+
		"\u01db\3\2\2\2\u01e9\u01dc\3\2\2\2\u01eaS\3\2\2\2\u01eb\u01ec\5V,\2\u01ec"+
		"\u01f5\7C\2\2\u01ed\u01f2\5\"\22\2\u01ee\u01ef\7O\2\2\u01ef\u01f1\5\""+
		"\22\2\u01f0\u01ee\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01ed\3\2"+
		"\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f8\7D\2\2\u01f8"+
		"U\3\2\2\2\u01f9\u01fa\t\f\2\2\u01faW\3\2\2\2\60Ya\u0085\u009e\u00b8\u00bd"+
		"\u00c4\u00d6\u00d9\u00df\u00e8\u00f1\u00f9\u0100\u0108\u0110\u0118\u0120"+
		"\u0128\u0130\u0138\u0140\u0146\u0150\u0154\u015a\u0161\u016b\u0175\u0178"+
		"\u017e\u0191\u0194\u019f\u01a8\u01ab\u01b6\u01bc\u01cb\u01ce\u01d9\u01e3"+
		"\u01e6\u01e9\u01f2\u01f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
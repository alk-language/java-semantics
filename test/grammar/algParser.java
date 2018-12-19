// Generated from /home/alex/work/Alk/test/grammar/parts/alg.g4 by ANTLR 4.7.1

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
public class algParser extends Parser {
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
	public static final int
		RULE_main = 0, RULE_statement_sequence = 1, RULE_statement = 2, RULE_statement_block = 3, 
		RULE_choose = 4, RULE_increase_decrease = 5, RULE_assignment = 6, RULE_while_struct = 7, 
		RULE_do_while_struct = 8, RULE_if_struct = 9, RULE_for_struct = 10, RULE_forall_struct = 11, 
		RULE_function_decl = 12, RULE_param = 13, RULE_set_expression = 14, RULE_set_atom = 15, 
		RULE_expression = 16, RULE_logical_or_expression = 17, RULE_logical_and_expression = 18, 
		RULE_in_expression = 19, RULE_equality_expression = 20, RULE_relational_expression = 21, 
		RULE_bitwise_or = 22, RULE_bitwise_and = 23, RULE_shift_expression = 24, 
		RULE_additive_expression = 25, RULE_multiplicative_expression = 26, RULE_unary_expression = 27, 
		RULE_postfix_expression = 28, RULE_factor = 29, RULE_value = 30, RULE_scalar_value = 31, 
		RULE_ref_name = 32, RULE_ref_name_chunk = 33, RULE_data_structure = 34, 
		RULE_interval = 35, RULE_spec = 36, RULE_array = 37, RULE_list = 38, RULE_structure = 39, 
		RULE_component = 40, RULE_set = 41, RULE_function_call = 42, RULE_builtin_method = 43, 
		RULE_method_name = 44;
	public static final String[] ruleNames = {
		"main", "statement_sequence", "statement", "statement_block", "choose", 
		"increase_decrease", "assignment", "while_struct", "do_while_struct", 
		"if_struct", "for_struct", "forall_struct", "function_decl", "param", 
		"set_expression", "set_atom", "expression", "logical_or_expression", "logical_and_expression", 
		"in_expression", "equality_expression", "relational_expression", "bitwise_or", 
		"bitwise_and", "shift_expression", "additive_expression", "multiplicative_expression", 
		"unary_expression", "postfix_expression", "factor", "value", "scalar_value", 
		"ref_name", "ref_name_chunk", "data_structure", "interval", "spec", "array", 
		"list", "structure", "component", "set", "function_call", "builtin_method", 
		"method_name"
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

	@Override
	public String getGrammarFileName() { return "alg.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public algParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(algParser.EOF, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitMain(this);
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FORALL) | (1L << CHOOSE) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD))) != 0) || _la==LCB) {
				{
				setState(90);
				statement_sequence();
				}
			}

			setState(93);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToInstruction(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitInstructionSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_sequenceContext statement_sequence() throws RecognitionException {
		Statement_sequenceContext _localctx = new Statement_sequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_sequence);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ToInstructionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				statement();
				}
				break;
			case 2:
				_localctx = new InstructionSeqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				statement();
				setState(97);
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
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public ToAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(algParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitReturn(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToWhile(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFor(this);
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
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public TerminalNode POINT() { return getToken(algParser.POINT, 0); }
		public TerminalNode ARROW() { return getToken(algParser.ARROW, 0); }
		public ToFContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToF(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileContext extends StatementContext {
		public Do_while_structContext do_while_struct() {
			return getRuleContext(Do_while_structContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public DoWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuccessContext extends StatementContext {
		public TerminalNode SUCCESS() { return getToken(algParser.SUCCESS, 0); }
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public SuccessContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitSuccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChooseStmContext extends StatementContext {
		public ChooseContext choose() {
			return getRuleContext(ChooseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public ChooseStmContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitChooseStm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToFunContext extends StatementContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public ToFunContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToFun(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDContext extends StatementContext {
		public Increase_decreaseContext increase_decrease() {
			return getRuleContext(Increase_decreaseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public IDContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitID(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitForAll(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitTOFD(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FailureContext extends StatementContext {
		public TerminalNode FAILURE() { return getToken(algParser.FAILURE, 0); }
		public TerminalNode SEMICOLON() { return getToken(algParser.SEMICOLON, 0); }
		public FailureContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFailure(this);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitToIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ToFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				ref_name();
				setState(102);
				_la = _input.LA(1);
				if ( !(_la==ARROW || _la==POINT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(103);
				function_call();
				setState(104);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ToFunContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				function_call();
				setState(107);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new TOFDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				function_decl();
				}
				break;
			case 4:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(RETURN);
				setState(111);
				expression();
				setState(112);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new ChooseStmContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(114);
				choose();
				setState(115);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new SuccessContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				match(SUCCESS);
				setState(118);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new FailureContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(119);
				match(FAILURE);
				setState(120);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new ToAssignContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(121);
				assignment();
				setState(122);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new IDContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(124);
				increase_decrease();
				setState(125);
				match(SEMICOLON);
				}
				break;
			case 10:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(127);
				statement_block();
				}
				break;
			case 11:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(128);
				while_struct();
				}
				break;
			case 12:
				_localctx = new DoWhileContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(129);
				do_while_struct();
				setState(130);
				match(SEMICOLON);
				}
				break;
			case 13:
				_localctx = new ToIfContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
				if_struct();
				}
				break;
			case 14:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(133);
				for_struct();
				}
				break;
			case 15:
				_localctx = new ForAllContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(134);
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
		public TerminalNode LCB() { return getToken(algParser.LCB, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public TerminalNode RCB() { return getToken(algParser.RCB, 0); }
		public BlockContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitBlock(this);
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
			setState(137);
			match(LCB);
			setState(138);
			statement_sequence();
			setState(139);
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
		public TerminalNode CHOOSE() { return getToken(algParser.CHOOSE, 0); }
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode IN() { return getToken(algParser.IN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choose; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitChoose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseContext choose() throws RecognitionException {
		ChooseContext _localctx = new ChooseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_choose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(CHOOSE);
			setState(142);
			match(ID);
			setState(143);
			match(IN);
			setState(144);
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
		public TerminalNode PLUSPLUS() { return getToken(algParser.PLUSPLUS, 0); }
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public TerminalNode MINUSMINUS() { return getToken(algParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(algParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(algParser.MINUSMINUSMOD, 0); }
		public Increase_decreaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increase_decrease; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitIncrease_decrease(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Increase_decreaseContext increase_decrease() throws RecognitionException {
		Increase_decreaseContext _localctx = new Increase_decreaseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_increase_decrease);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(PLUSPLUS);
				setState(147);
				ref_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				ref_name();
				setState(149);
				match(PLUSPLUS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(MINUSMINUS);
				setState(152);
				ref_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				ref_name();
				setState(154);
				match(MINUSMINUS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				match(PLUSPLUSMOD);
				setState(157);
				ref_name();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(158);
				match(MINUSMINUSMOD);
				setState(159);
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
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(algParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			ref_name();
			setState(163);
			match(ASSIGNMENT_OPERATOR);
			setState(164);
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
		public TerminalNode WHILE() { return getToken(algParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(While_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitWhile(this);
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
			setState(166);
			match(WHILE);
			setState(167);
			match(LPAR);
			setState(168);
			expression();
			setState(169);
			match(RPAR);
			setState(170);
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
		public TerminalNode DO() { return getToken(algParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(algParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public Do_while_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitDo_while_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_structContext do_while_struct() throws RecognitionException {
		Do_while_structContext _localctx = new Do_while_structContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_do_while_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(DO);
			setState(173);
			statement();
			setState(174);
			match(WHILE);
			setState(175);
			match(LPAR);
			setState(176);
			expression();
			setState(177);
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
		public TerminalNode IF() { return getToken(algParser.IF, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(algParser.ELSE, 0); }
		public If_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_struct; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitIf_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_structContext if_struct() throws RecognitionException {
		If_structContext _localctx = new If_structContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(IF);
			setState(180);
			match(LPAR);
			setState(181);
			expression();
			setState(182);
			match(RPAR);
			setState(183);
			statement();
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(184);
				match(ELSE);
				setState(185);
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
		public TerminalNode FOR() { return getToken(algParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(algParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(algParser.SEMICOLON, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFor_struct(this);
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
			setState(188);
			match(FOR);
			setState(189);
			match(LPAR);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << ID))) != 0)) {
				{
				setState(190);
				assignment();
				}
			}

			setState(193);
			match(SEMICOLON);
			setState(194);
			expression();
			setState(195);
			match(SEMICOLON);
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(196);
				assignment();
				}
				break;
			case 2:
				{
				setState(197);
				increase_decrease();
				}
				break;
			}
			setState(200);
			match(RPAR);
			setState(201);
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
		public TerminalNode FORALL() { return getToken(algParser.FORALL, 0); }
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode IN() { return getToken(algParser.IN, 0); }
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitForall_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Forall_structContext forall_struct() throws RecognitionException {
		Forall_structContext _localctx = new Forall_structContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forall_struct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(FORALL);
			setState(204);
			match(ID);
			setState(205);
			match(IN);
			setState(206);
			expression();
			setState(207);
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
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public Function_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFunction_decl(this);
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
			setState(209);
			match(ID);
			setState(210);
			match(LPAR);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT || _la==ID) {
				{
				setState(211);
				param();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(212);
					match(COMMA);
					setState(213);
					param();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(221);
			match(RPAR);
			setState(222);
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
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode OUT() { return getToken(algParser.OUT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitParam(this);
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
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT) {
				{
				setState(224);
				match(OUT);
				}
			}

			setState(227);
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
		public List<TerminalNode> UNION() { return getTokens(algParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(algParser.UNION, i);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(algParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(algParser.INTERSECT, i);
		}
		public List<TerminalNode> SUBSTRACT() { return getTokens(algParser.SUBSTRACT); }
		public TerminalNode SUBSTRACT(int i) {
			return getToken(algParser.SUBSTRACT, i);
		}
		public Set_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitSet_expression(this);
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
			setState(229);
			set_atom();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << INTERSECT) | (1L << SUBSTRACT))) != 0)) {
				{
				{
				setState(230);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNION) | (1L << INTERSECT) | (1L << SUBSTRACT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(231);
				set_atom();
				}
				}
				setState(236);
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
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public Set_expressionContext set_expression() {
			return getRuleContext(Set_expressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public Set_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitSet_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_atomContext set_atom() throws RecognitionException {
		Set_atomContext _localctx = new Set_atomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_set_atom);
		try {
			setState(243);
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
				setState(237);
				ref_name();
				}
				break;
			case EMPTYSET:
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				set();
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(LPAR);
				setState(240);
				set_expression();
				setState(241);
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
		public TerminalNode QUESTION() { return getToken(algParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DPOINT() { return getToken(algParser.DPOINT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitExpression(this);
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
			setState(245);
			logical_or_expression();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(246);
				match(QUESTION);
				setState(247);
				expression();
				setState(248);
				match(DPOINT);
				setState(249);
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
		public List<TerminalNode> OR() { return getTokens(algParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(algParser.OR, i);
		}
		public Logical_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitLogical_or_expression(this);
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
			setState(253);
			logical_and_expression();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(254);
				match(OR);
				setState(255);
				logical_and_expression();
				}
				}
				setState(260);
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
		public List<TerminalNode> AND() { return getTokens(algParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(algParser.AND, i);
		}
		public Logical_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitLogical_and_expression(this);
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
			setState(261);
			in_expression();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(262);
				match(AND);
				setState(263);
				in_expression();
				}
				}
				setState(268);
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
		public List<TerminalNode> IN() { return getTokens(algParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(algParser.IN, i);
		}
		public In_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitIn_expression(this);
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
			setState(269);
			equality_expression();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN) {
				{
				{
				setState(270);
				match(IN);
				setState(271);
				equality_expression();
				}
				}
				setState(276);
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
		public List<TerminalNode> ISEQUAL() { return getTokens(algParser.ISEQUAL); }
		public TerminalNode ISEQUAL(int i) {
			return getToken(algParser.ISEQUAL, i);
		}
		public List<TerminalNode> NOTEQUAL() { return getTokens(algParser.NOTEQUAL); }
		public TerminalNode NOTEQUAL(int i) {
			return getToken(algParser.NOTEQUAL, i);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitEquality_expression(this);
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
			setState(277);
			relational_expression();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ISEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==ISEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(279);
				relational_expression();
				}
				}
				setState(284);
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
		public List<Bitwise_orContext> bitwise_or() {
			return getRuleContexts(Bitwise_orContext.class);
		}
		public Bitwise_orContext bitwise_or(int i) {
			return getRuleContext(Bitwise_orContext.class,i);
		}
		public List<TerminalNode> LOWER() { return getTokens(algParser.LOWER); }
		public TerminalNode LOWER(int i) {
			return getToken(algParser.LOWER, i);
		}
		public List<TerminalNode> GREATER() { return getTokens(algParser.GREATER); }
		public TerminalNode GREATER(int i) {
			return getToken(algParser.GREATER, i);
		}
		public List<TerminalNode> LOWEREQ() { return getTokens(algParser.LOWEREQ); }
		public TerminalNode LOWEREQ(int i) {
			return getToken(algParser.LOWEREQ, i);
		}
		public List<TerminalNode> GREATEREQ() { return getTokens(algParser.GREATEREQ); }
		public TerminalNode GREATEREQ(int i) {
			return getToken(algParser.GREATEREQ, i);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitRelational_expression(this);
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
			setState(285);
			bitwise_or();
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(286);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOWER) | (1L << GREATER) | (1L << LOWEREQ) | (1L << GREATEREQ))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(287);
					bitwise_or();
					}
					} 
				}
				setState(292);
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

	public static class Bitwise_orContext extends ParserRuleContext {
		public List<Bitwise_andContext> bitwise_and() {
			return getRuleContexts(Bitwise_andContext.class);
		}
		public Bitwise_andContext bitwise_and(int i) {
			return getRuleContext(Bitwise_andContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(algParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(algParser.VBAR, i);
		}
		public List<TerminalNode> XOR() { return getTokens(algParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(algParser.XOR, i);
		}
		public Bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitBitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_orContext bitwise_or() throws RecognitionException {
		Bitwise_orContext _localctx = new Bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bitwise_or);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			bitwise_and();
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(294);
					_la = _input.LA(1);
					if ( !(_la==XOR || _la==VBAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(295);
					bitwise_and();
					}
					} 
				}
				setState(300);
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

	public static class Bitwise_andContext extends ParserRuleContext {
		public List<Shift_expressionContext> shift_expression() {
			return getRuleContexts(Shift_expressionContext.class);
		}
		public Shift_expressionContext shift_expression(int i) {
			return getRuleContext(Shift_expressionContext.class,i);
		}
		public List<TerminalNode> BITWISE_AND() { return getTokens(algParser.BITWISE_AND); }
		public TerminalNode BITWISE_AND(int i) {
			return getToken(algParser.BITWISE_AND, i);
		}
		public Bitwise_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitBitwise_and(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_andContext bitwise_and() throws RecognitionException {
		Bitwise_andContext _localctx = new Bitwise_andContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bitwise_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			shift_expression();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_AND) {
				{
				{
				setState(302);
				match(BITWISE_AND);
				setState(303);
				shift_expression();
				}
				}
				setState(308);
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
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
		}
		public List<TerminalNode> LEFTSHIFT() { return getTokens(algParser.LEFTSHIFT); }
		public TerminalNode LEFTSHIFT(int i) {
			return getToken(algParser.LEFTSHIFT, i);
		}
		public List<TerminalNode> RIGHTSHIFT() { return getTokens(algParser.RIGHTSHIFT); }
		public TerminalNode RIGHTSHIFT(int i) {
			return getToken(algParser.RIGHTSHIFT, i);
		}
		public Shift_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitShift_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_expressionContext shift_expression() throws RecognitionException {
		Shift_expressionContext _localctx = new Shift_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_shift_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			additive_expression();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTSHIFT || _la==RIGHTSHIFT) {
				{
				{
				setState(310);
				_la = _input.LA(1);
				if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(311);
				additive_expression();
				}
				}
				setState(316);
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
		public List<TerminalNode> PLUS() { return getTokens(algParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(algParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(algParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(algParser.MINUS, i);
		}
		public List<TerminalNode> PLUSMOD() { return getTokens(algParser.PLUSMOD); }
		public TerminalNode PLUSMOD(int i) {
			return getToken(algParser.PLUSMOD, i);
		}
		public List<TerminalNode> MINUSMOD() { return getTokens(algParser.MINUSMOD); }
		public TerminalNode MINUSMOD(int i) {
			return getToken(algParser.MINUSMOD, i);
		}
		public AdditiveExpressionContext(Additive_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_additive_expression);
		int _la;
		try {
			_localctx = new AdditiveExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			multiplicative_expression();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSMOD) | (1L << MINUSMOD) | (1L << MINUS) | (1L << PLUS))) != 0)) {
				{
				{
				setState(318);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSMOD) | (1L << MINUSMOD) | (1L << MINUS) | (1L << PLUS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(319);
				multiplicative_expression();
				}
				}
				setState(324);
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
		public List<TerminalNode> MUL() { return getTokens(algParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(algParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(algParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(algParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(algParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(algParser.MOD, i);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitMultiplicative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_multiplicative_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			unary_expression();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (MUL - 63)) | (1L << (DIV - 63)) | (1L << (MOD - 63)))) != 0)) {
				{
				{
				setState(326);
				_la = _input.LA(1);
				if ( !(((((_la - 63)) & ~0x3f) == 0 && ((1L << (_la - 63)) & ((1L << (MUL - 63)) | (1L << (DIV - 63)) | (1L << (MOD - 63)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(327);
				unary_expression();
				}
				}
				setState(332);
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
		public TerminalNode PLUSPLUS() { return getToken(algParser.PLUSPLUS, 0); }
		public TerminalNode MINUSMINUS() { return getToken(algParser.MINUSMINUS, 0); }
		public TerminalNode PLUSPLUSMOD() { return getToken(algParser.PLUSPLUSMOD, 0); }
		public TerminalNode MINUSMINUSMOD() { return getToken(algParser.MINUSMINUSMOD, 0); }
		public TerminalNode MUL() { return getToken(algParser.MUL, 0); }
		public TerminalNode PLUS() { return getToken(algParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(algParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(algParser.NOT, 0); }
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unary_expression);
		int _la;
		try {
			setState(338);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUSPLUSMOD:
			case MINUSMINUSMOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(334);
				unary_expression();
				}
				break;
			case MINUS:
			case PLUS:
			case MUL:
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				_la = _input.LA(1);
				if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (MINUS - 61)) | (1L << (PLUS - 61)) | (1L << (MUL - 61)) | (1L << (NOT - 61)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(336);
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
				setState(337);
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
		public List<TerminalNode> PLUSPLUS() { return getTokens(algParser.PLUSPLUS); }
		public TerminalNode PLUSPLUS(int i) {
			return getToken(algParser.PLUSPLUS, i);
		}
		public List<TerminalNode> MINUSMINUS() { return getTokens(algParser.MINUSMINUS); }
		public TerminalNode MINUSMINUS(int i) {
			return getToken(algParser.MINUSMINUS, i);
		}
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitPostfix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_postfix_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			factor();
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(341);
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
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_factor);
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				ref_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				match(LPAR);
				setState(351);
				expression();
				setState(352);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_value);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case BOOL:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
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
				setState(357);
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
		public TerminalNode DOUBLE() { return getToken(algParser.DOUBLE, 0); }
		public DoubleValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitDoubleValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValueContext extends Scalar_valueContext {
		public TerminalNode BOOL() { return getToken(algParser.BOOL, 0); }
		public BoolValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringValueContext extends Scalar_valueContext {
		public TerminalNode STRING() { return getToken(algParser.STRING, 0); }
		public StringValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValueContext extends Scalar_valueContext {
		public TerminalNode INT() { return getToken(algParser.INT, 0); }
		public IntValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_valueContext scalar_value() throws RecognitionException {
		Scalar_valueContext _localctx = new Scalar_valueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_scalar_value);
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(DOUBLE);
				}
				break;
			case BOOL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
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
		public List<TerminalNode> POINT() { return getTokens(algParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(algParser.POINT, i);
		}
		public List<TerminalNode> ARROW() { return getTokens(algParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(algParser.ARROW, i);
		}
		public Ref_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitRef_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_nameContext ref_name() throws RecognitionException {
		Ref_nameContext _localctx = new Ref_nameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ref_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			ref_name_chunk();
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(367);
					_la = _input.LA(1);
					if ( !(_la==ARROW || _la==POINT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(368);
					ref_name_chunk();
					}
					} 
				}
				setState(373);
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

	public static class Ref_name_chunkContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public List<TerminalNode> LBRA() { return getTokens(algParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(algParser.LBRA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRA() { return getTokens(algParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(algParser.RBRA, i);
		}
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public Ref_name_chunkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref_name_chunk; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitRef_name_chunk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_name_chunkContext ref_name_chunk() throws RecognitionException {
		Ref_name_chunkContext _localctx = new Ref_name_chunkContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ref_name_chunk);
		int _la;
		try {
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				function_call();
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(375);
					match(LBRA);
					setState(376);
					expression();
					setState(377);
					match(RBRA);
					}
					}
					setState(383);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				match(ID);
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRA) {
					{
					{
					setState(385);
					match(LBRA);
					setState(386);
					expression();
					setState(387);
					match(RBRA);
					}
					}
					setState(393);
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitData_structure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_structureContext data_structure() throws RecognitionException {
		Data_structureContext _localctx = new Data_structureContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_data_structure);
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				array();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				set_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
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
		public List<TerminalNode> POINT() { return getTokens(algParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(algParser.POINT, i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_interval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			expression();
			setState(403);
			match(POINT);
			setState(404);
			match(POINT);
			setState(405);
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
		public TerminalNode VBAR() { return getToken(algParser.VBAR, 0); }
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode IN() { return getToken(algParser.IN, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			expression();
			setState(408);
			match(VBAR);
			setState(409);
			match(ID);
			setState(410);
			match(IN);
			setState(411);
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
		public TerminalNode LBRA() { return getToken(algParser.LBRA, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(algParser.RBRA, 0); }
		public ArrayWithSpecContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitArrayWithSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithExpressionsContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(algParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(algParser.RBRA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public ArrayWithExpressionsContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitArrayWithExpressions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayWithIntervalContext extends ArrayContext {
		public TerminalNode LBRA() { return getToken(algParser.LBRA, 0); }
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(algParser.RBRA, 0); }
		public ArrayWithIntervalContext(ArrayContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitArrayWithInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_array);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new ArrayWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(LBRA);
				setState(414);
				spec();
				setState(415);
				match(RBRA);
				}
				break;
			case 2:
				_localctx = new ArrayWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(417);
				match(LBRA);
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(418);
					expression();
					setState(423);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(419);
						match(COMMA);
						setState(420);
						expression();
						}
						}
						setState(425);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(428);
				match(RBRA);
				}
				break;
			case 3:
				_localctx = new ArrayWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(429);
				match(LBRA);
				setState(430);
				interval();
				setState(431);
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
		public TerminalNode EMPTYLIST() { return getToken(algParser.EMPTYLIST, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_list);
		int _la;
		try {
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(EMPTYLIST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				match(LOWER);
				setState(437);
				spec();
				setState(438);
				match(GREATER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(440);
				match(LOWER);
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(441);
					expression();
					setState(446);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(442);
						match(COMMA);
						setState(443);
						expression();
						}
						}
						setState(448);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(451);
				match(GREATER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(452);
				match(LOWER);
				setState(453);
				interval();
				setState(454);
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
		public TerminalNode LCB() { return getToken(algParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(algParser.RCB, 0); }
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
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureContext structure() throws RecognitionException {
		StructureContext _localctx = new StructureContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(LCB);
			setState(460); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(459);
				component();
				}
				}
				setState(462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(464);
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
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(algParser.ARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_component);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(ID);
			setState(467);
			match(ARROW);
			setState(468);
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
		public TerminalNode EMPTYSET() { return getToken(algParser.EMPTYSET, 0); }
		public TerminalNode LCB() { return getToken(algParser.LCB, 0); }
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public TerminalNode RCB() { return getToken(algParser.RCB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_set);
		int _la;
		try {
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(EMPTYSET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				match(LCB);
				setState(472);
				spec();
				setState(473);
				match(RCB);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				match(LCB);
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
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
				match(RCB);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(487);
				match(LCB);
				setState(488);
				interval();
				setState(489);
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
		public TerminalNode ID() { return getToken(algParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_function_call);
		int _la;
		try {
			setState(507);
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
				setState(493);
				builtin_method();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				match(ID);
				setState(495);
				match(LPAR);
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
					{
					setState(496);
					expression();
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(497);
						match(COMMA);
						setState(498);
						expression();
						}
						}
						setState(503);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(506);
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
		public TerminalNode LPAR() { return getToken(algParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(algParser.RPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(algParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(algParser.COMMA, i);
		}
		public Builtin_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitBuiltin_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_methodContext builtin_method() throws RecognitionException {
		Builtin_methodContext _localctx = new Builtin_methodContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_builtin_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			method_name();
			setState(510);
			match(LPAR);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << AT) | (1L << DELETE) | (1L << END) | (1L << FIRST) | (1L << INSERT) | (1L << POPBACK) | (1L << POPFRONT) | (1L << PUSHBACK) | (1L << PUSHFRONT) | (1L << REMOVE) | (1L << REMOVEALLEQTO) | (1L << REMOVEAT) | (1L << SINGLETONSET) | (1L << SIZE) | (1L << TOPBACK) | (1L << TOPFRONT) | (1L << UPDATE) | (1L << INT) | (1L << DOUBLE) | (1L << BOOL) | (1L << ID) | (1L << PLUSPLUS) | (1L << MINUSMINUS) | (1L << PLUSPLUSMOD) | (1L << MINUSMINUSMOD) | (1L << LOWER) | (1L << MINUS) | (1L << PLUS) | (1L << MUL))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (LPAR - 66)) | (1L << (NOT - 66)) | (1L << (LCB - 66)) | (1L << (LBRA - 66)) | (1L << (STRING - 66)))) != 0)) {
				{
				setState(511);
				expression();
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(512);
					match(COMMA);
					setState(513);
					expression();
					}
					}
					setState(518);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(521);
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
		public TerminalNode AT() { return getToken(algParser.AT, 0); }
		public TerminalNode DELETE() { return getToken(algParser.DELETE, 0); }
		public TerminalNode END() { return getToken(algParser.END, 0); }
		public TerminalNode FIRST() { return getToken(algParser.FIRST, 0); }
		public TerminalNode INSERT() { return getToken(algParser.INSERT, 0); }
		public TerminalNode POPBACK() { return getToken(algParser.POPBACK, 0); }
		public TerminalNode POPFRONT() { return getToken(algParser.POPFRONT, 0); }
		public TerminalNode PUSHBACK() { return getToken(algParser.PUSHBACK, 0); }
		public TerminalNode PUSHFRONT() { return getToken(algParser.PUSHFRONT, 0); }
		public TerminalNode REMOVE() { return getToken(algParser.REMOVE, 0); }
		public TerminalNode REMOVEALLEQTO() { return getToken(algParser.REMOVEALLEQTO, 0); }
		public TerminalNode REMOVEAT() { return getToken(algParser.REMOVEAT, 0); }
		public TerminalNode SINGLETONSET() { return getToken(algParser.SINGLETONSET, 0); }
		public TerminalNode SIZE() { return getToken(algParser.SIZE, 0); }
		public TerminalNode TOPFRONT() { return getToken(algParser.TOPFRONT, 0); }
		public TerminalNode TOPBACK() { return getToken(algParser.TOPBACK, 0); }
		public TerminalNode UPDATE() { return getToken(algParser.UPDATE, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof algVisitor ) return ((algVisitor<? extends T>)visitor).visitMethod_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_method_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3V\u0210\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\5\2^\n\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3f\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u008a\n"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a3\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00bd\n\13\3\f\3\f\3\f\5\f\u00c2\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c9"+
		"\n\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00d9\n\16\f\16\16\16\u00dc\13\16\5\16\u00de\n\16\3\16\3\16\3\16\3\17"+
		"\5\17\u00e4\n\17\3\17\3\17\3\20\3\20\3\20\7\20\u00eb\n\20\f\20\16\20\u00ee"+
		"\13\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f6\n\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u00fe\n\22\3\23\3\23\3\23\7\23\u0103\n\23\f\23\16\23"+
		"\u0106\13\23\3\24\3\24\3\24\7\24\u010b\n\24\f\24\16\24\u010e\13\24\3\25"+
		"\3\25\3\25\7\25\u0113\n\25\f\25\16\25\u0116\13\25\3\26\3\26\3\26\7\26"+
		"\u011b\n\26\f\26\16\26\u011e\13\26\3\27\3\27\3\27\7\27\u0123\n\27\f\27"+
		"\16\27\u0126\13\27\3\30\3\30\3\30\7\30\u012b\n\30\f\30\16\30\u012e\13"+
		"\30\3\31\3\31\3\31\7\31\u0133\n\31\f\31\16\31\u0136\13\31\3\32\3\32\3"+
		"\32\7\32\u013b\n\32\f\32\16\32\u013e\13\32\3\33\3\33\3\33\7\33\u0143\n"+
		"\33\f\33\16\33\u0146\13\33\3\34\3\34\3\34\7\34\u014b\n\34\f\34\16\34\u014e"+
		"\13\34\3\35\3\35\3\35\3\35\3\35\5\35\u0155\n\35\3\36\3\36\7\36\u0159\n"+
		"\36\f\36\16\36\u015c\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0165"+
		"\n\37\3 \3 \5 \u0169\n \3!\3!\3!\3!\5!\u016f\n!\3\"\3\"\3\"\7\"\u0174"+
		"\n\"\f\"\16\"\u0177\13\"\3#\3#\3#\3#\3#\7#\u017e\n#\f#\16#\u0181\13#\3"+
		"#\3#\3#\3#\3#\7#\u0188\n#\f#\16#\u018b\13#\5#\u018d\n#\3$\3$\3$\3$\5$"+
		"\u0193\n$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\7\'\u01a8\n\'\f\'\16\'\u01ab\13\'\5\'\u01ad\n\'\3\'\3\'\3\'\3\'\3"+
		"\'\5\'\u01b4\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u01bf\n(\f(\16(\u01c2\13"+
		"(\5(\u01c4\n(\3(\3(\3(\3(\3(\5(\u01cb\n(\3)\3)\6)\u01cf\n)\r)\16)\u01d0"+
		"\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u01e2\n+\f+\16+\u01e5"+
		"\13+\5+\u01e7\n+\3+\3+\3+\3+\3+\5+\u01ee\n+\3,\3,\3,\3,\3,\3,\7,\u01f6"+
		"\n,\f,\16,\u01f9\13,\5,\u01fb\n,\3,\5,\u01fe\n,\3-\3-\3-\3-\3-\7-\u0205"+
		"\n-\f-\16-\u0208\13-\5-\u020a\n-\3-\3-\3.\3.\3.\2\2/\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2\16\4\2"+
		"))QQ\3\2*,\3\2<=\3\28;\4\2\24\24MM\3\2FG\4\2\64\65?@\3\2AC\4\2\61\62\66"+
		"\67\4\2?AJJ\3\2\61\62\5\2\25\25\27\27\31\'\2\u0230\2]\3\2\2\2\4e\3\2\2"+
		"\2\6\u0089\3\2\2\2\b\u008b\3\2\2\2\n\u008f\3\2\2\2\f\u00a2\3\2\2\2\16"+
		"\u00a4\3\2\2\2\20\u00a8\3\2\2\2\22\u00ae\3\2\2\2\24\u00b5\3\2\2\2\26\u00be"+
		"\3\2\2\2\30\u00cd\3\2\2\2\32\u00d3\3\2\2\2\34\u00e3\3\2\2\2\36\u00e7\3"+
		"\2\2\2 \u00f5\3\2\2\2\"\u00f7\3\2\2\2$\u00ff\3\2\2\2&\u0107\3\2\2\2(\u010f"+
		"\3\2\2\2*\u0117\3\2\2\2,\u011f\3\2\2\2.\u0127\3\2\2\2\60\u012f\3\2\2\2"+
		"\62\u0137\3\2\2\2\64\u013f\3\2\2\2\66\u0147\3\2\2\28\u0154\3\2\2\2:\u0156"+
		"\3\2\2\2<\u0164\3\2\2\2>\u0168\3\2\2\2@\u016e\3\2\2\2B\u0170\3\2\2\2D"+
		"\u018c\3\2\2\2F\u0192\3\2\2\2H\u0194\3\2\2\2J\u0199\3\2\2\2L\u01b3\3\2"+
		"\2\2N\u01ca\3\2\2\2P\u01cc\3\2\2\2R\u01d4\3\2\2\2T\u01ed\3\2\2\2V\u01fd"+
		"\3\2\2\2X\u01ff\3\2\2\2Z\u020d\3\2\2\2\\^\5\4\3\2]\\\3\2\2\2]^\3\2\2\2"+
		"^_\3\2\2\2_`\7\2\2\3`\3\3\2\2\2af\5\6\4\2bc\5\6\4\2cd\5\4\3\2df\3\2\2"+
		"\2ea\3\2\2\2eb\3\2\2\2f\5\3\2\2\2gh\5B\"\2hi\t\2\2\2ij\5V,\2jk\7K\2\2"+
		"k\u008a\3\2\2\2lm\5V,\2mn\7K\2\2n\u008a\3\2\2\2o\u008a\5\32\16\2pq\7\17"+
		"\2\2qr\5\"\22\2rs\7K\2\2s\u008a\3\2\2\2tu\5\n\6\2uv\7K\2\2v\u008a\3\2"+
		"\2\2wx\7\20\2\2x\u008a\7K\2\2yz\7\21\2\2z\u008a\7K\2\2{|\5\16\b\2|}\7"+
		"K\2\2}\u008a\3\2\2\2~\177\5\f\7\2\177\u0080\7K\2\2\u0080\u008a\3\2\2\2"+
		"\u0081\u008a\5\b\5\2\u0082\u008a\5\20\t\2\u0083\u0084\5\22\n\2\u0084\u0085"+
		"\7K\2\2\u0085\u008a\3\2\2\2\u0086\u008a\5\24\13\2\u0087\u008a\5\26\f\2"+
		"\u0088\u008a\5\30\r\2\u0089g\3\2\2\2\u0089l\3\2\2\2\u0089o\3\2\2\2\u0089"+
		"p\3\2\2\2\u0089t\3\2\2\2\u0089w\3\2\2\2\u0089y\3\2\2\2\u0089{\3\2\2\2"+
		"\u0089~\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083\3"+
		"\2\2\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\7\3\2\2\2\u008b\u008c\7N\2\2\u008c\u008d\5\4\3\2\u008d\u008e\7O\2\2\u008e"+
		"\t\3\2\2\2\u008f\u0090\7\16\2\2\u0090\u0091\7\60\2\2\u0091\u0092\7\f\2"+
		"\2\u0092\u0093\5\"\22\2\u0093\13\3\2\2\2\u0094\u0095\7\61\2\2\u0095\u00a3"+
		"\5B\"\2\u0096\u0097\5B\"\2\u0097\u0098\7\61\2\2\u0098\u00a3\3\2\2\2\u0099"+
		"\u009a\7\62\2\2\u009a\u00a3\5B\"\2\u009b\u009c\5B\"\2\u009c\u009d\7\62"+
		"\2\2\u009d\u00a3\3\2\2\2\u009e\u009f\7\66\2\2\u009f\u00a3\5B\"\2\u00a0"+
		"\u00a1\7\67\2\2\u00a1\u00a3\5B\"\2\u00a2\u0094\3\2\2\2\u00a2\u0096\3\2"+
		"\2\2\u00a2\u0099\3\2\2\2\u00a2\u009b\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\r\3\2\2\2\u00a4\u00a5\5B\"\2\u00a5\u00a6\7>\2\2\u00a6"+
		"\u00a7\5\"\22\2\u00a7\17\3\2\2\2\u00a8\u00a9\7\b\2\2\u00a9\u00aa\7D\2"+
		"\2\u00aa\u00ab\5\"\22\2\u00ab\u00ac\7E\2\2\u00ac\u00ad\5\6\4\2\u00ad\21"+
		"\3\2\2\2\u00ae\u00af\7\t\2\2\u00af\u00b0\5\6\4\2\u00b0\u00b1\7\b\2\2\u00b1"+
		"\u00b2\7D\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\7E\2\2\u00b4\23\3\2\2\2"+
		"\u00b5\u00b6\7\6\2\2\u00b6\u00b7\7D\2\2\u00b7\u00b8\5\"\22\2\u00b8\u00b9"+
		"\7E\2\2\u00b9\u00bc\5\6\4\2\u00ba\u00bb\7\7\2\2\u00bb\u00bd\5\6\4\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\25\3\2\2\2\u00be\u00bf\7\n\2"+
		"\2\u00bf\u00c1\7D\2\2\u00c0\u00c2\5\16\b\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7K\2\2\u00c4\u00c5\5\"\22\2\u00c5"+
		"\u00c8\7K\2\2\u00c6\u00c9\5\16\b\2\u00c7\u00c9\5\f\7\2\u00c8\u00c6\3\2"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7E\2\2\u00cb"+
		"\u00cc\5\6\4\2\u00cc\27\3\2\2\2\u00cd\u00ce\7\13\2\2\u00ce\u00cf\7\60"+
		"\2\2\u00cf\u00d0\7\f\2\2\u00d0\u00d1\5\"\22\2\u00d1\u00d2\5\6\4\2\u00d2"+
		"\31\3\2\2\2\u00d3\u00d4\7\60\2\2\u00d4\u00dd\7D\2\2\u00d5\u00da\5\34\17"+
		"\2\u00d6\u00d7\7P\2\2\u00d7\u00d9\5\34\17\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dd\u00d5\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\7E\2\2\u00e0\u00e1\5\6\4\2\u00e1\33\3\2\2\2"+
		"\u00e2\u00e4\7\r\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5"+
		"\3\2\2\2\u00e5\u00e6\7\60\2\2\u00e6\35\3\2\2\2\u00e7\u00ec\5 \21\2\u00e8"+
		"\u00e9\t\3\2\2\u00e9\u00eb\5 \21\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\37\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ef\u00f6\5B\"\2\u00f0\u00f6\5T+\2\u00f1\u00f2\7D\2\2\u00f2"+
		"\u00f3\5\36\20\2\u00f3\u00f4\7E\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00ef\3"+
		"\2\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f6!\3\2\2\2\u00f7\u00fd"+
		"\5$\23\2\u00f8\u00f9\7U\2\2\u00f9\u00fa\5\"\22\2\u00fa\u00fb\7L\2\2\u00fb"+
		"\u00fc\5\"\22\2\u00fc\u00fe\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fd\u00fe\3"+
		"\2\2\2\u00fe#\3\2\2\2\u00ff\u0104\5&\24\2\u0100\u0101\7H\2\2\u0101\u0103"+
		"\5&\24\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105%\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010c\5(\25\2"+
		"\u0108\u0109\7I\2\2\u0109\u010b\5(\25\2\u010a\u0108\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\'\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0114\5*\26\2\u0110\u0111\7\f\2\2\u0111\u0113\5*"+
		"\26\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115)\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011c\5,\27\2"+
		"\u0118\u0119\t\4\2\2\u0119\u011b\5,\27\2\u011a\u0118\3\2\2\2\u011b\u011e"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d+\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0124\5.\30\2\u0120\u0121\t\5\2\2\u0121\u0123\5."+
		"\30\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125-\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u012c\5\60\31"+
		"\2\u0128\u0129\t\6\2\2\u0129\u012b\5\60\31\2\u012a\u0128\3\2\2\2\u012b"+
		"\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d/\3\2\2\2"+
		"\u012e\u012c\3\2\2\2\u012f\u0134\5\62\32\2\u0130\u0131\7\63\2\2\u0131"+
		"\u0133\5\62\32\2\u0132\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3"+
		"\2\2\2\u0134\u0135\3\2\2\2\u0135\61\3\2\2\2\u0136\u0134\3\2\2\2\u0137"+
		"\u013c\5\64\33\2\u0138\u0139\t\7\2\2\u0139\u013b\5\64\33\2\u013a\u0138"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\63\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0144\5\66\34\2\u0140\u0141\t\b"+
		"\2\2\u0141\u0143\5\66\34\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\65\3\2\2\2\u0146\u0144\3\2\2"+
		"\2\u0147\u014c\58\35\2\u0148\u0149\t\t\2\2\u0149\u014b\58\35\2\u014a\u0148"+
		"\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\67\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\t\n\2\2\u0150\u0155\58\35"+
		"\2\u0151\u0152\t\13\2\2\u0152\u0155\58\35\2\u0153\u0155\5:\36\2\u0154"+
		"\u014f\3\2\2\2\u0154\u0151\3\2\2\2\u0154\u0153\3\2\2\2\u01559\3\2\2\2"+
		"\u0156\u015a\5<\37\2\u0157\u0159\t\f\2\2\u0158\u0157\3\2\2\2\u0159\u015c"+
		"\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b;\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015d\u0165\5V,\2\u015e\u0165\5B\"\2\u015f\u0165\5> \2"+
		"\u0160\u0161\7D\2\2\u0161\u0162\5\"\22\2\u0162\u0163\7E\2\2\u0163\u0165"+
		"\3\2\2\2\u0164\u015d\3\2\2\2\u0164\u015e\3\2\2\2\u0164\u015f\3\2\2\2\u0164"+
		"\u0160\3\2\2\2\u0165=\3\2\2\2\u0166\u0169\5@!\2\u0167\u0169\5F$\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169?\3\2\2\2\u016a\u016f\7-\2\2\u016b"+
		"\u016f\7.\2\2\u016c\u016f\7/\2\2\u016d\u016f\7V\2\2\u016e\u016a\3\2\2"+
		"\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016fA"+
		"\3\2\2\2\u0170\u0175\5D#\2\u0171\u0172\t\2\2\2\u0172\u0174\5D#\2\u0173"+
		"\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2"+
		"\2\2\u0176C\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u017f\5V,\2\u0179\u017a"+
		"\7R\2\2\u017a\u017b\5\"\22\2\u017b\u017c\7S\2\2\u017c\u017e\3\2\2\2\u017d"+
		"\u0179\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2"+
		"\2\2\u0180\u018d\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0189\7\60\2\2\u0183"+
		"\u0184\7R\2\2\u0184\u0185\5\"\22\2\u0185\u0186\7S\2\2\u0186\u0188\3\2"+
		"\2\2\u0187\u0183\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u0178\3\2"+
		"\2\2\u018c\u0182\3\2\2\2\u018dE\3\2\2\2\u018e\u0193\5L\'\2\u018f\u0193"+
		"\5N(\2\u0190\u0193\5\36\20\2\u0191\u0193\5P)\2\u0192\u018e\3\2\2\2\u0192"+
		"\u018f\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193G\3\2\2\2"+
		"\u0194\u0195\5\"\22\2\u0195\u0196\7Q\2\2\u0196\u0197\7Q\2\2\u0197\u0198"+
		"\5\"\22\2\u0198I\3\2\2\2\u0199\u019a\5\"\22\2\u019a\u019b\7M\2\2\u019b"+
		"\u019c\7\60\2\2\u019c\u019d\7\f\2\2\u019d\u019e\5H%\2\u019eK\3\2\2\2\u019f"+
		"\u01a0\7R\2\2\u01a0\u01a1\5J&\2\u01a1\u01a2\7S\2\2\u01a2\u01b4\3\2\2\2"+
		"\u01a3\u01ac\7R\2\2\u01a4\u01a9\5\"\22\2\u01a5\u01a6\7P\2\2\u01a6\u01a8"+
		"\5\"\22\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2"+
		"\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01a4"+
		"\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b4\7S\2\2\u01af"+
		"\u01b0\7R\2\2\u01b0\u01b1\5H%\2\u01b1\u01b2\7S\2\2\u01b2\u01b4\3\2\2\2"+
		"\u01b3\u019f\3\2\2\2\u01b3\u01a3\3\2\2\2\u01b3\u01af\3\2\2\2\u01b4M\3"+
		"\2\2\2\u01b5\u01cb\7\23\2\2\u01b6\u01b7\78\2\2\u01b7\u01b8\5J&\2\u01b8"+
		"\u01b9\79\2\2\u01b9\u01cb\3\2\2\2\u01ba\u01c3\78\2\2\u01bb\u01c0\5\"\22"+
		"\2\u01bc\u01bd\7P\2\2\u01bd\u01bf\5\"\22\2\u01be\u01bc\3\2\2\2\u01bf\u01c2"+
		"\3\2\2\2\u01c0\u01be\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c3\u01bb\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2"+
		"\2\2\u01c5\u01cb\79\2\2\u01c6\u01c7\78\2\2\u01c7\u01c8\5H%\2\u01c8\u01c9"+
		"\79\2\2\u01c9\u01cb\3\2\2\2\u01ca\u01b5\3\2\2\2\u01ca\u01b6\3\2\2\2\u01ca"+
		"\u01ba\3\2\2\2\u01ca\u01c6\3\2\2\2\u01cbO\3\2\2\2\u01cc\u01ce\7N\2\2\u01cd"+
		"\u01cf\5R*\2\u01ce\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01ce\3\2\2"+
		"\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\7O\2\2\u01d3Q\3"+
		"\2\2\2\u01d4\u01d5\7\60\2\2\u01d5\u01d6\7)\2\2\u01d6\u01d7\5\"\22\2\u01d7"+
		"S\3\2\2\2\u01d8\u01ee\7\22\2\2\u01d9\u01da\7N\2\2\u01da\u01db\5J&\2\u01db"+
		"\u01dc\7O\2\2\u01dc\u01ee\3\2\2\2\u01dd\u01e6\7N\2\2\u01de\u01e3\5\"\22"+
		"\2\u01df\u01e0\7P\2\2\u01e0\u01e2\5\"\22\2\u01e1\u01df\3\2\2\2\u01e2\u01e5"+
		"\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5"+
		"\u01e3\3\2\2\2\u01e6\u01de\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e8\3\2"+
		"\2\2\u01e8\u01ee\7O\2\2\u01e9\u01ea\7N\2\2\u01ea\u01eb\5H%\2\u01eb\u01ec"+
		"\7O\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01d8\3\2\2\2\u01ed\u01d9\3\2\2\2\u01ed"+
		"\u01dd\3\2\2\2\u01ed\u01e9\3\2\2\2\u01eeU\3\2\2\2\u01ef\u01fe\5X-\2\u01f0"+
		"\u01f1\7\60\2\2\u01f1\u01fa\7D\2\2\u01f2\u01f7\5\"\22\2\u01f3\u01f4\7"+
		"P\2\2\u01f4\u01f6\5\"\22\2\u01f5\u01f3\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7"+
		"\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7\3\2"+
		"\2\2\u01fa\u01f2\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u01fe\7E\2\2\u01fd\u01ef\3\2\2\2\u01fd\u01f0\3\2\2\2\u01feW\3\2\2\2\u01ff"+
		"\u0200\5Z.\2\u0200\u0209\7D\2\2\u0201\u0206\5\"\22\2\u0202\u0203\7P\2"+
		"\2\u0203\u0205\5\"\22\2\u0204\u0202\3\2\2\2\u0205\u0208\3\2\2\2\u0206"+
		"\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2"+
		"\2\2\u0209\u0201\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020c\7E\2\2\u020cY\3\2\2\2\u020d\u020e\t\r\2\2\u020e[\3\2\2\2\62]e\u0089"+
		"\u00a2\u00bc\u00c1\u00c8\u00da\u00dd\u00e3\u00ec\u00f5\u00fd\u0104\u010c"+
		"\u0114\u011c\u0124\u012c\u0134\u013c\u0144\u014c\u0154\u015a\u0164\u0168"+
		"\u016e\u0175\u017f\u0189\u018c\u0192\u01a9\u01ac\u01b3\u01c0\u01c3\u01ca"+
		"\u01d0\u01e3\u01e6\u01ed\u01f7\u01fa\u01fd\u0206\u0209";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
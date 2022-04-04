// Generated from ./../src/main/java/grammar/parts/alk.g4 by ANTLR 4.7.1

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
		WS=1, COMMENT=2, LINE_COMMENT=3, ASSERT=4, ASSUME=5, SYMBOLIC=6, INVARIANT=7, 
		REQURIES=8, ENSURES=9, LOOPASSESRT=10, WHILEMODIFIES=11, RESULT=12, OLD=13, 
		IMPLIES=14, EQUIV=15, FORALL=16, EXISTS=17, QUANTIFIER_SEPARATOR=18, TO=19, 
		IF=20, ELSE=21, WHILE=22, DO=23, FOR=24, FOREACH=25, IN=26, FROM=27, OUT=28, 
		HAVOC=29, CHOOSE=30, UNIFORM=31, REPEAT=32, RETURN=33, SUCCESS=34, UNTIL=35, 
		FAILURE=36, CONTINUE=37, BREAK=38, EMPTYMAP=39, EMPTYSET=40, EMPTYLIST=41, 
		EMPTYSTRUCTURE=42, MODIFIES=43, USES=44, INCLDUE=45, XOR=46, ABS=47, ACOS=48, 
		ASIN=49, ATAN=50, COS=51, LOG=52, PI=53, POW=54, SIN=55, SQRT=56, TAN=57, 
		LEN=58, ARRAY=59, SET=60, AT=61, BELONGSTO=62, DELETE=63, EMPTY=64, END=65, 
		FIRST=66, FLOAT=67, INSERT=68, KEYS=69, INTEGER=70, BOOLEAN=71, PRINT=72, 
		POPBACK=73, POPFRONT=74, PUSHBACK=75, PUSHFRONT=76, REMOVE=77, REMOVEALLEQTO=78, 
		REMOVEAT=79, SINGLETONSET=80, SIZE=81, SPLIT=82, TOPBACK=83, TOPFRONT=84, 
		UPDATE=85, UNIFORMNAT=86, FLIP=87, UNIFORMFLOAT=88, UNIFORMPERM=89, SOTHAT=90, 
		SYM=91, ARROW=92, NUMSIGN=93, ANNO=94, COUNT=95, UNION=96, INTERSECT=97, 
		SUBTRACT=98, INT=99, DOUBLE=100, BOOL=101, ID=102, PLUSPLUS=103, MINUSMINUS=104, 
		BITWISE_AND=105, PLUSMOD=106, MINUSMOD=107, PLUSPLUSMOD=108, MINUSMINUSMOD=109, 
		LOWER=110, GREATER=111, LOWEREQ=112, GREATEREQ=113, ISEQUAL=114, NOTEQUAL=115, 
		ASSIGNMENT_OPERATOR=116, MINUS=117, PLUS=118, MUL=119, DIV=120, MOD=121, 
		LPAR=122, RPAR=123, LEFTSHIFT=124, RIGHTSHIFT=125, OR=126, AND=127, NOT=128, 
		SEMICOLON=129, DPOINT=130, VBAR=131, LCB=132, RCB=133, COMMA=134, POINT=135, 
		LBRA=136, RBRA=137, QUOTE=138, QUESTION=139, STRING=140;
	public static final int
		RULE_main = 0, RULE_statement_sequence = 1, RULE_statement = 2, RULE_assumeStmt = 3, 
		RULE_assertStmt = 4, RULE_havocStmt = 5, RULE_declarator = 6, RULE_symbolicStmt = 7, 
		RULE_symbolicDeclarator = 8, RULE_directive = 9, RULE_repeat_struct = 10, 
		RULE_statement_block = 11, RULE_choose = 12, RULE_while_struct = 13, RULE_while_anno = 14, 
		RULE_modif_factor = 15, RULE_loop_assert = 16, RULE_do_while_struct = 17, 
		RULE_if_struct = 18, RULE_for_struct = 19, RULE_foreach_struct = 20, RULE_function_decl = 21, 
		RULE_req_expression = 22, RULE_ens_expression = 23, RULE_param = 24, RULE_expression = 25, 
		RULE_assign_expression = 26, RULE_conditional_expression = 27, RULE_logical_or_expression = 28, 
		RULE_logical_and_expression = 29, RULE_in_expression = 30, RULE_equality_expression = 31, 
		RULE_relational_expression = 32, RULE_set_expression = 33, RULE_bitwise_or = 34, 
		RULE_bitwise_and = 35, RULE_shift_expression = 36, RULE_additive_expression = 37, 
		RULE_multiplicative_expression = 38, RULE_unary_expression = 39, RULE_postfix_expression = 40, 
		RULE_factor = 41, RULE_base_factor = 42, RULE_anno = 43, RULE_value = 44, 
		RULE_scalar_value = 45, RULE_ref_name = 46, RULE_data_structure = 47, 
		RULE_interval = 48, RULE_spec = 49, RULE_array = 50, RULE_list = 51, RULE_structure = 52, 
		RULE_component = 53, RULE_set = 54, RULE_mapping = 55, RULE_mapping_component = 56, 
		RULE_function_call = 57, RULE_builtin_function = 58, RULE_builtin_method = 59, 
		RULE_dataType = 60, RULE_function_name = 61, RULE_method_name = 62, RULE_configuration = 63;
	public static final String[] ruleNames = {
		"main", "statement_sequence", "statement", "assumeStmt", "assertStmt", 
		"havocStmt", "declarator", "symbolicStmt", "symbolicDeclarator", "directive", 
		"repeat_struct", "statement_block", "choose", "while_struct", "while_anno", 
		"modif_factor", "loop_assert", "do_while_struct", "if_struct", "for_struct", 
		"foreach_struct", "function_decl", "req_expression", "ens_expression", 
		"param", "expression", "assign_expression", "conditional_expression", 
		"logical_or_expression", "logical_and_expression", "in_expression", "equality_expression", 
		"relational_expression", "set_expression", "bitwise_or", "bitwise_and", 
		"shift_expression", "additive_expression", "multiplicative_expression", 
		"unary_expression", "postfix_expression", "factor", "base_factor", "anno", 
		"value", "scalar_value", "ref_name", "data_structure", "interval", "spec", 
		"array", "list", "structure", "component", "set", "mapping", "mapping_component", 
		"function_call", "builtin_function", "builtin_method", "dataType", "function_name", 
		"method_name", "configuration"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'@assert'", "'@assume'", "'@symbolic'", "'@invariant'", 
		"'@requires'", "'@ensures'", "'@loopassert'", "'@modifies'", "'\\result'", 
		"'\\old'", "'==>'", "'<==>'", "'forall'", "'exists'", "'::'", "'|->'", 
		"'if'", "'else'", "'while'", "'do'", "'for'", "'foreach'", "'in'", "'from'", 
		"'out'", "'@havoc'", "'choose'", "'uniform'", "'repeat'", "'return'", 
		"'success'", "'until'", "'failure'", "'continue'", "'break'", "'emptyMap'", 
		"'emptySet'", "'emptyList'", "'emptyStructure'", "'modifies'", "'uses'", 
		"'include'", "'xor'", "'abs'", "'acos'", "'asin'", "'atan'", "'cos'", 
		"'log'", "'pi'", "'pow'", "'sin'", "'sqrt'", "'tan'", "'len'", "'array'", 
		"'set'", "'at'", "'belongsTo'", "'delete'", "'empty'", "'end'", "'first'", 
		"'float'", "'insert'", "'keys'", "'int'", "'boolean'", "'print'", "'popBack'", 
		"'popFront'", "'pushBack'", "'pushFront'", "'remove'", "'removeAllEqTo'", 
		"'removeAt'", "'singletonSet'", "'size'", "'split'", "'topBack'", "'topFront'", 
		"'update'", "'uniformNat'", "'flip'", "'uniformFloat'", "'uniformPerm'", 
		"'s.t.'", "'$'", "'->'", "'#'", "'@'", "'Count'", "'U'", "'^'", "'\\'", 
		null, null, null, null, "'++'", "'--'", "'&'", "'+%'", "'-%'", "'++%'", 
		"'--%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", null, "'-'", "'+'", 
		"'*'", "'/'", "'%'", "'('", "')'", "'<<'", "'>>'", "'||'", "'&&'", "'!'", 
		"';'", "':'", "'|'", "'{'", "'}'", "','", "'.'", "'['", "']'", "'\"'", 
		"'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LINE_COMMENT", "ASSERT", "ASSUME", "SYMBOLIC", 
		"INVARIANT", "REQURIES", "ENSURES", "LOOPASSESRT", "WHILEMODIFIES", "RESULT", 
		"OLD", "IMPLIES", "EQUIV", "FORALL", "EXISTS", "QUANTIFIER_SEPARATOR", 
		"TO", "IF", "ELSE", "WHILE", "DO", "FOR", "FOREACH", "IN", "FROM", "OUT", 
		"HAVOC", "CHOOSE", "UNIFORM", "REPEAT", "RETURN", "SUCCESS", "UNTIL", 
		"FAILURE", "CONTINUE", "BREAK", "EMPTYMAP", "EMPTYSET", "EMPTYLIST", "EMPTYSTRUCTURE", 
		"MODIFIES", "USES", "INCLDUE", "XOR", "ABS", "ACOS", "ASIN", "ATAN", "COS", 
		"LOG", "PI", "POW", "SIN", "SQRT", "TAN", "LEN", "ARRAY", "SET", "AT", 
		"BELONGSTO", "DELETE", "EMPTY", "END", "FIRST", "FLOAT", "INSERT", "KEYS", 
		"INTEGER", "BOOLEAN", "PRINT", "POPBACK", "POPFRONT", "PUSHBACK", "PUSHFRONT", 
		"REMOVE", "REMOVEALLEQTO", "REMOVEAT", "SINGLETONSET", "SIZE", "SPLIT", 
		"TOPBACK", "TOPFRONT", "UPDATE", "UNIFORMNAT", "FLIP", "UNIFORMFLOAT", 
		"UNIFORMPERM", "SOTHAT", "SYM", "ARROW", "NUMSIGN", "ANNO", "COUNT", "UNION", 
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
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSERT) | (1L << ASSUME) | (1L << SYMBOLIC) | (1L << RESULT) | (1L << OLD) | (1L << FORALL) | (1L << EXISTS) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FOREACH) | (1L << HAVOC) | (1L << CHOOSE) | (1L << UNIFORM) | (1L << REPEAT) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << CONTINUE) | (1L << BREAK) | (1L << EMPTYMAP) | (1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << EMPTYSTRUCTURE) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (FLOAT - 67)) | (1L << (INTEGER - 67)) | (1L << (PRINT - 67)) | (1L << (SINGLETONSET - 67)) | (1L << (UNIFORMNAT - 67)) | (1L << (FLIP - 67)) | (1L << (UNIFORMFLOAT - 67)) | (1L << (UNIFORMPERM - 67)) | (1L << (SYM - 67)) | (1L << (NUMSIGN - 67)) | (1L << (ANNO - 67)) | (1L << (INT - 67)) | (1L << (DOUBLE - 67)) | (1L << (BOOL - 67)) | (1L << (ID - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUSPLUSMOD - 67)) | (1L << (MINUSMINUSMOD - 67)) | (1L << (LOWER - 67)) | (1L << (MINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MUL - 67)) | (1L << (LPAR - 67)) | (1L << (NOT - 67)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (LCB - 132)) | (1L << (LBRA - 132)) | (1L << (QUESTION - 132)) | (1L << (STRING - 132)))) != 0)) {
				{
				setState(128);
				statement_sequence();
				}
			}

			setState(131);
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
	public static class StatementSeqContext extends Statement_sequenceContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementSeqContext(Statement_sequenceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitStatementSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_sequenceContext statement_sequence() throws RecognitionException {
		Statement_sequenceContext _localctx = new Statement_sequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement_sequence);
		int _la;
		try {
			_localctx = new StatementSeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				statement();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSERT) | (1L << ASSUME) | (1L << SYMBOLIC) | (1L << RESULT) | (1L << OLD) | (1L << FORALL) | (1L << EXISTS) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FOREACH) | (1L << HAVOC) | (1L << CHOOSE) | (1L << UNIFORM) | (1L << REPEAT) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << CONTINUE) | (1L << BREAK) | (1L << EMPTYMAP) | (1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << EMPTYSTRUCTURE) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (FLOAT - 67)) | (1L << (INTEGER - 67)) | (1L << (PRINT - 67)) | (1L << (SINGLETONSET - 67)) | (1L << (UNIFORMNAT - 67)) | (1L << (FLIP - 67)) | (1L << (UNIFORMFLOAT - 67)) | (1L << (UNIFORMPERM - 67)) | (1L << (SYM - 67)) | (1L << (NUMSIGN - 67)) | (1L << (ANNO - 67)) | (1L << (INT - 67)) | (1L << (DOUBLE - 67)) | (1L << (BOOL - 67)) | (1L << (ID - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUSPLUSMOD - 67)) | (1L << (MINUSMINUSMOD - 67)) | (1L << (LOWER - 67)) | (1L << (MINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MUL - 67)) | (1L << (LPAR - 67)) | (1L << (NOT - 67)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (LCB - 132)) | (1L << (LBRA - 132)) | (1L << (QUESTION - 132)) | (1L << (STRING - 132)))) != 0) );
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
	public static class ToDirectiveContext extends StatementContext {
		public DirectiveContext directive() {
			return getRuleContext(DirectiveContext.class,0);
		}
		public ToDirectiveContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToDirective(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAssumeStmtContext extends StatementContext {
		public AssumeStmtContext assumeStmt() {
			return getRuleContext(AssumeStmtContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToAssumeStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToAssumeStmt(this);
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
	public static class ToHavocStmtContext extends StatementContext {
		public HavocStmtContext havocStmt() {
			return getRuleContext(HavocStmtContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToHavocStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToHavocStmt(this);
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
	public static class ExpressionStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ExpressionStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToAssertStmtContext extends StatementContext {
		public AssertStmtContext assertStmt() {
			return getRuleContext(AssertStmtContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToAssertStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToAssertStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStmtContext extends StatementContext {
		public TerminalNode CONTINUE() { return getToken(alkParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ContinueStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitContinueStmt(this);
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
	public static class ToForEachContext extends StatementContext {
		public Foreach_structContext foreach_struct() {
			return getRuleContext(Foreach_structContext.class,0);
		}
		public ToForEachContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToForEach(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStmtContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(alkParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public BreakStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBreakStmt(this);
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
	public static class ToChooseStmtContext extends StatementContext {
		public ChooseContext choose() {
			return getRuleContext(ChooseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ToChooseStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToChooseStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymbolicDeclStmtContext extends StatementContext {
		public SymbolicStmtContext symbolicStmt() {
			return getRuleContext(SymbolicStmtContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public SymbolicDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSymbolicDeclStmt(this);
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
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new ToFunctionDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				function_decl();
				}
				break;
			case 2:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(RETURN);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
					{
					setState(140);
					expression();
					}
				}

				setState(143);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ToChooseStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				choose();
				setState(145);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new SuccessContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
				match(SUCCESS);
				setState(148);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new FailureContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(FAILURE);
				setState(150);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				match(CONTINUE);
				setState(152);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(153);
				match(BREAK);
				setState(154);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(155);
				statement_block();
				}
				break;
			case 9:
				_localctx = new ToDirectiveContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(156);
				directive();
				}
				break;
			case 10:
				_localctx = new ToRepeatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(157);
				repeat_struct();
				setState(158);
				match(SEMICOLON);
				}
				break;
			case 11:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(160);
				while_struct();
				}
				break;
			case 12:
				_localctx = new ToDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(161);
				do_while_struct();
				setState(162);
				match(SEMICOLON);
				}
				break;
			case 13:
				_localctx = new ToIfContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(164);
				if_struct();
				}
				break;
			case 14:
				_localctx = new ToForContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(165);
				for_struct();
				}
				break;
			case 15:
				_localctx = new ToForEachContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(166);
				foreach_struct();
				}
				break;
			case 16:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(167);
				expression();
				setState(168);
				match(SEMICOLON);
				}
				break;
			case 17:
				_localctx = new SymbolicDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(170);
				symbolicStmt();
				setState(171);
				match(SEMICOLON);
				}
				break;
			case 18:
				_localctx = new ToHavocStmtContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(173);
				havocStmt();
				setState(174);
				match(SEMICOLON);
				}
				break;
			case 19:
				_localctx = new ToAssumeStmtContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(176);
				assumeStmt();
				setState(177);
				match(SEMICOLON);
				}
				break;
			case 20:
				_localctx = new ToAssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(179);
				assertStmt();
				setState(180);
				match(SEMICOLON);
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

	public static class AssumeStmtContext extends ParserRuleContext {
		public AssumeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assumeStmt; }
	 
		public AssumeStmtContext() { }
		public void copyFrom(AssumeStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssumeContext extends AssumeStmtContext {
		public TerminalNode ASSUME() { return getToken(alkParser.ASSUME, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssumeContext(AssumeStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAssume(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssumeStmtContext assumeStmt() throws RecognitionException {
		AssumeStmtContext _localctx = new AssumeStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assumeStmt);
		try {
			_localctx = new AssumeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(ASSUME);
			setState(185);
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

	public static class AssertStmtContext extends ParserRuleContext {
		public AssertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStmt; }
	 
		public AssertStmtContext() { }
		public void copyFrom(AssertStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssertContext extends AssertStmtContext {
		public TerminalNode ASSERT() { return getToken(alkParser.ASSERT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssertContext(AssertStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAssert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStmtContext assertStmt() throws RecognitionException {
		AssertStmtContext _localctx = new AssertStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assertStmt);
		try {
			_localctx = new AssertContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ASSERT);
			setState(188);
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

	public static class HavocStmtContext extends ParserRuleContext {
		public HavocStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havocStmt; }
	 
		public HavocStmtContext() { }
		public void copyFrom(HavocStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HavocContext extends HavocStmtContext {
		public TerminalNode HAVOC() { return getToken(alkParser.HAVOC, 0); }
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public HavocContext(HavocStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitHavoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HavocStmtContext havocStmt() throws RecognitionException {
		HavocStmtContext _localctx = new HavocStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_havocStmt);
		int _la;
		try {
			_localctx = new HavocContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(HAVOC);
			setState(191);
			declarator();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(192);
				match(COMMA);
				setState(193);
				declarator();
				}
				}
				setState(198);
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

	public static class DeclaratorContext extends ParserRuleContext {
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	 
		public DeclaratorContext() { }
		public void copyFrom(DeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclContext extends DeclaratorContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode DPOINT() { return getToken(alkParser.DPOINT, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public DeclContext(DeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarator);
		int _la;
		try {
			_localctx = new DeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(ID);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DPOINT) {
				{
				setState(200);
				match(DPOINT);
				setState(201);
				dataType();
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

	public static class SymbolicStmtContext extends ParserRuleContext {
		public SymbolicStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolicStmt; }
	 
		public SymbolicStmtContext() { }
		public void copyFrom(SymbolicStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SymbolicDeclsContext extends SymbolicStmtContext {
		public TerminalNode SYMBOLIC() { return getToken(alkParser.SYMBOLIC, 0); }
		public List<SymbolicDeclaratorContext> symbolicDeclarator() {
			return getRuleContexts(SymbolicDeclaratorContext.class);
		}
		public SymbolicDeclaratorContext symbolicDeclarator(int i) {
			return getRuleContext(SymbolicDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public SymbolicDeclsContext(SymbolicStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSymbolicDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolicStmtContext symbolicStmt() throws RecognitionException {
		SymbolicStmtContext _localctx = new SymbolicStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_symbolicStmt);
		int _la;
		try {
			_localctx = new SymbolicDeclsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(SYMBOLIC);
			setState(205);
			symbolicDeclarator();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(206);
				match(COMMA);
				setState(207);
				symbolicDeclarator();
				}
				}
				setState(212);
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

	public static class SymbolicDeclaratorContext extends ParserRuleContext {
		public SymbolicDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbolicDeclarator; }
	 
		public SymbolicDeclaratorContext() { }
		public void copyFrom(SymbolicDeclaratorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SymbolicIdDeclContext extends SymbolicDeclaratorContext {
		public TerminalNode SYM() { return getToken(alkParser.SYM, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode DPOINT() { return getToken(alkParser.DPOINT, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public SymbolicIdDeclContext(SymbolicDeclaratorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSymbolicIdDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolicDeclaratorContext symbolicDeclarator() throws RecognitionException {
		SymbolicDeclaratorContext _localctx = new SymbolicDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_symbolicDeclarator);
		try {
			_localctx = new SymbolicIdDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(SYM);
			setState(214);
			match(ID);
			setState(215);
			match(DPOINT);
			setState(216);
			dataType();
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

	public static class DirectiveContext extends ParserRuleContext {
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
	 
		public DirectiveContext() { }
		public void copyFrom(DirectiveContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IncludeContext extends DirectiveContext {
		public TerminalNode NUMSIGN() { return getToken(alkParser.NUMSIGN, 0); }
		public TerminalNode INCLDUE() { return getToken(alkParser.INCLDUE, 0); }
		public TerminalNode STRING() { return getToken(alkParser.STRING, 0); }
		public IncludeContext(DirectiveContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_directive);
		try {
			_localctx = new IncludeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(NUMSIGN);
			setState(219);
			match(INCLDUE);
			setState(220);
			match(STRING);
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
		enterRule(_localctx, 20, RULE_repeat_struct);
		try {
			_localctx = new RepeatStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(REPEAT);
			setState(223);
			statement();
			setState(224);
			match(UNTIL);
			setState(225);
			match(LPAR);
			setState(226);
			expression();
			setState(227);
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
	public static class BlockContext extends Statement_blockContext {
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public Statement_sequenceContext statement_sequence() {
			return getRuleContext(Statement_sequenceContext.class,0);
		}
		public BlockContext(Statement_blockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement_block);
		int _la;
		try {
			_localctx = new BlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(LCB);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSERT) | (1L << ASSUME) | (1L << SYMBOLIC) | (1L << RESULT) | (1L << OLD) | (1L << FORALL) | (1L << EXISTS) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << FOREACH) | (1L << HAVOC) | (1L << CHOOSE) | (1L << UNIFORM) | (1L << REPEAT) | (1L << RETURN) | (1L << SUCCESS) | (1L << FAILURE) | (1L << CONTINUE) | (1L << BREAK) | (1L << EMPTYMAP) | (1L << EMPTYSET) | (1L << EMPTYLIST) | (1L << EMPTYSTRUCTURE) | (1L << ABS) | (1L << ACOS) | (1L << ASIN) | (1L << ATAN) | (1L << COS) | (1L << LOG) | (1L << PI) | (1L << POW) | (1L << SIN) | (1L << SQRT) | (1L << TAN) | (1L << LEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (FLOAT - 67)) | (1L << (INTEGER - 67)) | (1L << (PRINT - 67)) | (1L << (SINGLETONSET - 67)) | (1L << (UNIFORMNAT - 67)) | (1L << (FLIP - 67)) | (1L << (UNIFORMFLOAT - 67)) | (1L << (UNIFORMPERM - 67)) | (1L << (SYM - 67)) | (1L << (NUMSIGN - 67)) | (1L << (ANNO - 67)) | (1L << (INT - 67)) | (1L << (DOUBLE - 67)) | (1L << (BOOL - 67)) | (1L << (ID - 67)) | (1L << (PLUSPLUS - 67)) | (1L << (MINUSMINUS - 67)) | (1L << (PLUSPLUSMOD - 67)) | (1L << (MINUSMINUSMOD - 67)) | (1L << (LOWER - 67)) | (1L << (MINUS - 67)) | (1L << (PLUS - 67)) | (1L << (MUL - 67)) | (1L << (LPAR - 67)) | (1L << (NOT - 67)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (LCB - 132)) | (1L << (LBRA - 132)) | (1L << (QUESTION - 132)) | (1L << (STRING - 132)))) != 0)) {
				{
				setState(230);
				statement_sequence();
				}
			}

			setState(233);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(alkParser.FROM, 0); }
		public TerminalNode SOTHAT() { return getToken(alkParser.SOTHAT, 0); }
		public ChooseStmtContext(ChooseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitChooseStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UniformStmtContext extends ChooseContext {
		public TerminalNode UNIFORM() { return getToken(alkParser.UNIFORM, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(alkParser.FROM, 0); }
		public UniformStmtContext(ChooseContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUniformStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseContext choose() throws RecognitionException {
		ChooseContext _localctx = new ChooseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_choose);
		int _la;
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHOOSE:
				_localctx = new ChooseStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(CHOOSE);
				setState(236);
				expression();
				setState(237);
				match(FROM);
				setState(238);
				expression();
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SOTHAT) {
					{
					setState(239);
					match(SOTHAT);
					setState(240);
					expression();
					}
				}

				}
				break;
			case UNIFORM:
				_localctx = new UniformStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(UNIFORM);
				setState(244);
				expression();
				setState(245);
				match(FROM);
				setState(246);
				expression();
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
		public List<While_annoContext> while_anno() {
			return getRuleContexts(While_annoContext.class);
		}
		public While_annoContext while_anno(int i) {
			return getRuleContext(While_annoContext.class,i);
		}
		public Loop_assertContext loop_assert() {
			return getRuleContext(Loop_assertContext.class,0);
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
		enterRule(_localctx, 26, RULE_while_struct);
		int _la;
		try {
			_localctx = new WhileStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(WHILE);
			setState(251);
			match(LPAR);
			setState(252);
			expression();
			setState(253);
			match(RPAR);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INVARIANT || _la==WHILEMODIFIES) {
				{
				{
				setState(254);
				while_anno();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
			statement();
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(261);
				loop_assert();
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

	public static class While_annoContext extends ParserRuleContext {
		public While_annoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_anno; }
	 
		public While_annoContext() { }
		public void copyFrom(While_annoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InvariantAnnoContext extends While_annoContext {
		public TerminalNode INVARIANT() { return getToken(alkParser.INVARIANT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public InvariantAnnoContext(While_annoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitInvariantAnno(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModifiesAnnoContext extends While_annoContext {
		public TerminalNode WHILEMODIFIES() { return getToken(alkParser.WHILEMODIFIES, 0); }
		public List<Modif_factorContext> modif_factor() {
			return getRuleContexts(Modif_factorContext.class);
		}
		public Modif_factorContext modif_factor(int i) {
			return getRuleContext(Modif_factorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public ModifiesAnnoContext(While_annoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitModifiesAnno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_annoContext while_anno() throws RecognitionException {
		While_annoContext _localctx = new While_annoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_anno);
		int _la;
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INVARIANT:
				_localctx = new InvariantAnnoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(INVARIANT);
				setState(265);
				expression();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(266);
					match(SEMICOLON);
					}
				}

				}
				break;
			case WHILEMODIFIES:
				_localctx = new ModifiesAnnoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(WHILEMODIFIES);
				setState(270);
				modif_factor();
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(271);
					match(COMMA);
					setState(272);
					modif_factor();
					}
					}
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(278);
					match(SEMICOLON);
					}
				}

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

	public static class Modif_factorContext extends ParserRuleContext {
		public Modif_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modif_factor; }
	 
		public Modif_factorContext() { }
		public void copyFrom(Modif_factorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SizeModifContext extends Modif_factorContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode POINT() { return getToken(alkParser.POINT, 0); }
		public TerminalNode SIZE() { return getToken(alkParser.SIZE, 0); }
		public SizeModifContext(Modif_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSizeModif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdModifContext extends Modif_factorContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public IdModifContext(Modif_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIdModif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Modif_factorContext modif_factor() throws RecognitionException {
		Modif_factorContext _localctx = new Modif_factorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_modif_factor);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new IdModifContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(ID);
				}
				break;
			case 2:
				_localctx = new SizeModifContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(ID);
				setState(285);
				match(POINT);
				setState(286);
				match(SIZE);
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

	public static class Loop_assertContext extends ParserRuleContext {
		public Loop_assertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_assert; }
	 
		public Loop_assertContext() { }
		public void copyFrom(Loop_assertContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LoopAssertAnnoContext extends Loop_assertContext {
		public TerminalNode LOOPASSESRT() { return getToken(alkParser.LOOPASSESRT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(alkParser.SEMICOLON, 0); }
		public LoopAssertAnnoContext(Loop_assertContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitLoopAssertAnno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_assertContext loop_assert() throws RecognitionException {
		Loop_assertContext _localctx = new Loop_assertContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loop_assert);
		int _la;
		try {
			_localctx = new LoopAssertAnnoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(LOOPASSESRT);
			setState(290);
			expression();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(291);
				match(SEMICOLON);
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
		enterRule(_localctx, 34, RULE_do_while_struct);
		try {
			_localctx = new DoWhileStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(DO);
			setState(295);
			statement();
			setState(296);
			match(WHILE);
			setState(297);
			match(LPAR);
			setState(298);
			expression();
			setState(299);
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
		enterRule(_localctx, 36, RULE_if_struct);
		try {
			_localctx = new IfStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(IF);
			setState(302);
			match(LPAR);
			setState(303);
			expression();
			setState(304);
			match(RPAR);
			setState(305);
			statement();
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(306);
				match(ELSE);
				setState(307);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(alkParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(alkParser.SEMICOLON, i);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 38, RULE_for_struct);
		try {
			_localctx = new ForStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(FOR);
			setState(311);
			match(LPAR);
			setState(312);
			expression();
			setState(313);
			match(SEMICOLON);
			setState(314);
			expression();
			setState(315);
			match(SEMICOLON);
			setState(316);
			expression();
			setState(317);
			match(RPAR);
			setState(318);
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

	public static class Foreach_structContext extends ParserRuleContext {
		public Foreach_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_struct; }
	 
		public Foreach_structContext() { }
		public void copyFrom(Foreach_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForEachStructureContext extends Foreach_structContext {
		public TerminalNode FOREACH() { return getToken(alkParser.FOREACH, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode FROM() { return getToken(alkParser.FROM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForEachStructureContext(Foreach_structContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForEachStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreach_structContext foreach_struct() throws RecognitionException {
		Foreach_structContext _localctx = new Foreach_structContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_foreach_struct);
		try {
			_localctx = new ForEachStructureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(FOREACH);
			setState(321);
			match(ID);
			setState(322);
			match(FROM);
			setState(323);
			expression();
			setState(324);
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
		public List<TerminalNode> REQURIES() { return getTokens(alkParser.REQURIES); }
		public TerminalNode REQURIES(int i) {
			return getToken(alkParser.REQURIES, i);
		}
		public List<Req_expressionContext> req_expression() {
			return getRuleContexts(Req_expressionContext.class);
		}
		public Req_expressionContext req_expression(int i) {
			return getRuleContext(Req_expressionContext.class,i);
		}
		public List<TerminalNode> ENSURES() { return getTokens(alkParser.ENSURES); }
		public TerminalNode ENSURES(int i) {
			return getToken(alkParser.ENSURES, i);
		}
		public List<Ens_expressionContext> ens_expression() {
			return getRuleContexts(Ens_expressionContext.class);
		}
		public Ens_expressionContext ens_expression(int i) {
			return getRuleContext(Ens_expressionContext.class,i);
		}
		public TerminalNode MODIFIES() { return getToken(alkParser.MODIFIES, 0); }
		public TerminalNode USES() { return getToken(alkParser.USES, 0); }
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(alkParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(alkParser.SEMICOLON, i);
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
		enterRule(_localctx, 42, RULE_function_decl);
		int _la;
		try {
			_localctx = new FunctionDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(ID);
			setState(327);
			match(LPAR);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT || _la==ID) {
				{
				setState(328);
				param();
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(329);
					match(COMMA);
					setState(330);
					param();
					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(338);
			match(RPAR);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIES || _la==USES) {
				{
				setState(339);
				_la = _input.LA(1);
				if ( !(_la==MODIFIES || _la==USES) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(340);
				match(ID);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(341);
					match(COMMA);
					setState(342);
					match(ID);
					}
					}
					setState(347);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==REQURIES) {
				{
				{
				setState(350);
				match(REQURIES);
				setState(351);
				req_expression();
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(352);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ENSURES) {
				{
				{
				setState(360);
				match(ENSURES);
				setState(361);
				ens_expression();
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(362);
					match(SEMICOLON);
					}
				}

				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
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

	public static class Req_expressionContext extends ParserRuleContext {
		public Req_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_req_expression; }
	 
		public Req_expressionContext() { }
		public void copyFrom(Req_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReqExpressionContext extends Req_expressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReqExpressionContext(Req_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitReqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeAssertReqContext extends Req_expressionContext {
		public List<TerminalNode> ID() { return getTokens(alkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alkParser.ID, i);
		}
		public List<TerminalNode> DPOINT() { return getTokens(alkParser.DPOINT); }
		public TerminalNode DPOINT(int i) {
			return getToken(alkParser.DPOINT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(alkParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(alkParser.AND, i);
		}
		public TypeAssertReqContext(Req_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitTypeAssertReq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Req_expressionContext req_expression() throws RecognitionException {
		Req_expressionContext _localctx = new Req_expressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_req_expression);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ReqExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				expression();
				}
				break;
			case 2:
				_localctx = new TypeAssertReqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(ID);
				setState(374);
				match(DPOINT);
				setState(375);
				dataType();
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND) {
					{
					{
					setState(376);
					match(AND);
					{
					setState(377);
					match(ID);
					setState(378);
					match(DPOINT);
					setState(379);
					dataType();
					}
					}
					}
					setState(384);
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

	public static class Ens_expressionContext extends ParserRuleContext {
		public Ens_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ens_expression; }
	 
		public Ens_expressionContext() { }
		public void copyFrom(Ens_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeAssertEnsContext extends Ens_expressionContext {
		public TerminalNode RESULT() { return getToken(alkParser.RESULT, 0); }
		public TerminalNode DPOINT() { return getToken(alkParser.DPOINT, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TypeAssertEnsContext(Ens_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitTypeAssertEns(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EnsExpressionContext extends Ens_expressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnsExpressionContext(Ens_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEnsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ens_expressionContext ens_expression() throws RecognitionException {
		Ens_expressionContext _localctx = new Ens_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_ens_expression);
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new EnsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				expression();
				}
				break;
			case 2:
				_localctx = new TypeAssertEnsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				match(RESULT);
				setState(389);
				match(DPOINT);
				setState(390);
				dataType();
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
		enterRule(_localctx, 48, RULE_param);
		int _la;
		try {
			_localctx = new ParamDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUT) {
				{
				setState(393);
				match(OUT);
				}
			}

			setState(396);
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
	public static class ImpliesExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public TerminalNode IMPLIES() { return getToken(alkParser.IMPLIES, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ImpliesExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitImpliesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquivExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public TerminalNode EQUIV() { return getToken(alkParser.EQUIV, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EquivExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEquivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForallExprContext extends ExpressionContext {
		public TerminalNode FORALL() { return getToken(alkParser.FORALL, 0); }
		public TerminalNode QUANTIFIER_SEPARATOR() { return getToken(alkParser.QUANTIFIER_SEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(alkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alkParser.ID, i);
		}
		public List<TerminalNode> DPOINT() { return getTokens(alkParser.DPOINT); }
		public TerminalNode DPOINT(int i) {
			return getToken(alkParser.DPOINT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public ForallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitForallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FolToExprContext extends ExpressionContext {
		public Assign_expressionContext assign_expression() {
			return getRuleContext(Assign_expressionContext.class,0);
		}
		public FolToExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFolToExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsExprContext extends ExpressionContext {
		public TerminalNode EXISTS() { return getToken(alkParser.EXISTS, 0); }
		public TerminalNode QUANTIFIER_SEPARATOR() { return getToken(alkParser.QUANTIFIER_SEPARATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(alkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alkParser.ID, i);
		}
		public List<TerminalNode> DPOINT() { return getTokens(alkParser.DPOINT); }
		public TerminalNode DPOINT(int i) {
			return getToken(alkParser.DPOINT, i);
		}
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(alkParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(alkParser.COMMA, i);
		}
		public ExistsExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitExistsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expression);
		int _la;
		try {
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ImpliesExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(398);
				assign_expression();
				setState(399);
				match(IMPLIES);
				setState(400);
				expression();
				}
				break;
			case 2:
				_localctx = new EquivExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				assign_expression();
				setState(403);
				match(EQUIV);
				setState(404);
				expression();
				}
				break;
			case 3:
				_localctx = new ForallExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(406);
				match(FORALL);
				{
				setState(407);
				match(ID);
				setState(408);
				match(DPOINT);
				setState(409);
				dataType();
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(410);
					match(COMMA);
					setState(411);
					match(ID);
					setState(412);
					match(DPOINT);
					setState(413);
					dataType();
					}
					}
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(419);
				match(QUANTIFIER_SEPARATOR);
				setState(420);
				expression();
				}
				break;
			case 4:
				_localctx = new ExistsExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				match(EXISTS);
				{
				setState(423);
				match(ID);
				setState(424);
				match(DPOINT);
				setState(425);
				dataType();
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(426);
					match(COMMA);
					setState(427);
					match(ID);
					setState(428);
					match(DPOINT);
					setState(429);
					dataType();
					}
					}
					setState(434);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(435);
				match(QUANTIFIER_SEPARATOR);
				setState(436);
				expression();
				}
				break;
			case 5:
				_localctx = new FolToExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(438);
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
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(alkParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignExpressionContext(Assign_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAssignExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToConditionalExprContext extends Assign_expressionContext {
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public ToConditionalExprContext(Assign_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToConditionalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_expressionContext assign_expression() throws RecognitionException {
		Assign_expressionContext _localctx = new Assign_expressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_assign_expression);
		try {
			setState(446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new AssignExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(441);
				factor(0);
				setState(442);
				match(ASSIGNMENT_OPERATOR);
				setState(443);
				expression();
				}
				break;
			case 2:
				_localctx = new ToConditionalExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
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
		public TerminalNode QUESTION() { return getToken(alkParser.QUESTION, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DPOINT() { return getToken(alkParser.DPOINT, 0); }
		public ConditionalExpressionContext(Conditional_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_conditional_expression);
		try {
			_localctx = new ConditionalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			logical_or_expression();
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(449);
				match(QUESTION);
				setState(450);
				expression();
				setState(451);
				match(DPOINT);
				setState(452);
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
		enterRule(_localctx, 56, RULE_logical_or_expression);
		int _la;
		try {
			_localctx = new LogicalOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			logical_and_expression();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(457);
				match(OR);
				setState(458);
				logical_and_expression();
				}
				}
				setState(463);
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
		enterRule(_localctx, 58, RULE_logical_and_expression);
		int _la;
		try {
			_localctx = new LogicalAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			in_expression();
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(465);
				match(AND);
				setState(466);
				in_expression();
				}
				}
				setState(471);
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
		enterRule(_localctx, 60, RULE_in_expression);
		int _la;
		try {
			_localctx = new InExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			equality_expression();
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IN) {
				{
				{
				setState(473);
				match(IN);
				setState(474);
				equality_expression();
				}
				}
				setState(479);
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
		enterRule(_localctx, 62, RULE_equality_expression);
		int _la;
		try {
			_localctx = new EqualityExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			relational_expression();
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ISEQUAL || _la==NOTEQUAL) {
				{
				{
				setState(481);
				_la = _input.LA(1);
				if ( !(_la==ISEQUAL || _la==NOTEQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(482);
				relational_expression();
				}
				}
				setState(487);
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
		enterRule(_localctx, 64, RULE_relational_expression);
		int _la;
		try {
			int _alt;
			_localctx = new RelationalExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			set_expression();
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(489);
					_la = _input.LA(1);
					if ( !(((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & ((1L << (LOWER - 110)) | (1L << (GREATER - 110)) | (1L << (LOWEREQ - 110)) | (1L << (GREATEREQ - 110)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(490);
					set_expression();
					}
					} 
				}
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
		enterRule(_localctx, 66, RULE_set_expression);
		int _la;
		try {
			_localctx = new SetExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			bitwise_or();
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (UNION - 96)) | (1L << (INTERSECT - 96)) | (1L << (SUBTRACT - 96)))) != 0)) {
				{
				{
				setState(497);
				_la = _input.LA(1);
				if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (UNION - 96)) | (1L << (INTERSECT - 96)) | (1L << (SUBTRACT - 96)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(498);
				bitwise_or();
				}
				}
				setState(503);
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
		enterRule(_localctx, 68, RULE_bitwise_or);
		int _la;
		try {
			int _alt;
			_localctx = new BitwiseOrExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			bitwise_and();
			setState(509);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(505);
					_la = _input.LA(1);
					if ( !(_la==XOR || _la==VBAR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(506);
					bitwise_and();
					}
					} 
				}
				setState(511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		enterRule(_localctx, 70, RULE_bitwise_and);
		int _la;
		try {
			_localctx = new BitwiseAndExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			shift_expression();
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITWISE_AND) {
				{
				{
				setState(513);
				match(BITWISE_AND);
				setState(514);
				shift_expression();
				}
				}
				setState(519);
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
		enterRule(_localctx, 72, RULE_shift_expression);
		int _la;
		try {
			_localctx = new ShiftExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			additive_expression();
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LEFTSHIFT || _la==RIGHTSHIFT) {
				{
				{
				setState(521);
				_la = _input.LA(1);
				if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(522);
				additive_expression();
				}
				}
				setState(527);
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
		enterRule(_localctx, 74, RULE_additive_expression);
		int _la;
		try {
			int _alt;
			_localctx = new AdditiveExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			multiplicative_expression();
			setState(533);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(529);
					_la = _input.LA(1);
					if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & ((1L << (PLUSMOD - 106)) | (1L << (MINUSMOD - 106)) | (1L << (MINUS - 106)) | (1L << (PLUS - 106)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(530);
					multiplicative_expression();
					}
					} 
				}
				setState(535);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		enterRule(_localctx, 76, RULE_multiplicative_expression);
		int _la;
		try {
			int _alt;
			_localctx = new MultiplicativeExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			unary_expression();
			setState(541);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(537);
					_la = _input.LA(1);
					if ( !(((((_la - 119)) & ~0x3f) == 0 && ((1L << (_la - 119)) & ((1L << (MUL - 119)) | (1L << (DIV - 119)) | (1L << (MOD - 119)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(538);
					unary_expression();
					}
					} 
				}
				setState(543);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		enterRule(_localctx, 78, RULE_unary_expression);
		int _la;
		try {
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUSPLUS:
			case MINUSMINUS:
			case PLUSPLUSMOD:
			case MINUSMINUSMOD:
				_localctx = new PrefixExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				_la = _input.LA(1);
				if ( !(((((_la - 103)) & ~0x3f) == 0 && ((1L << (_la - 103)) & ((1L << (PLUSPLUS - 103)) | (1L << (MINUSMINUS - 103)) | (1L << (PLUSPLUSMOD - 103)) | (1L << (MINUSMINUSMOD - 103)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(545);
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
				setState(546);
				_la = _input.LA(1);
				if ( !(((((_la - 117)) & ~0x3f) == 0 && ((1L << (_la - 117)) & ((1L << (MINUS - 117)) | (1L << (PLUS - 117)) | (1L << (MUL - 117)) | (1L << (NOT - 117)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(547);
				unary_expression();
				}
				break;
			case RESULT:
			case OLD:
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
				setState(548);
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
		enterRule(_localctx, 80, RULE_postfix_expression);
		int _la;
		try {
			int _alt;
			_localctx = new PostfixExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			factor(0);
			setState(555);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(552);
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
				setState(557);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		public TerminalNode POINT() { return getToken(alkParser.POINT, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public FactorPointIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFactorPointID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorArrayContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode LBRA() { return getToken(alkParser.LBRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRA() { return getToken(alkParser.RBRA, 0); }
		public FactorArrayContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFactorArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ToBaseFactorContext extends FactorContext {
		public Base_factorContext base_factor() {
			return getRuleContext(Base_factorContext.class,0);
		}
		public ToBaseFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToBaseFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorPointMethodContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode POINT() { return getToken(alkParser.POINT, 0); }
		public Builtin_methodContext builtin_method() {
			return getRuleContext(Builtin_methodContext.class,0);
		}
		public FactorPointMethodContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFactorPointMethod(this);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToBaseFactorContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(559);
			base_factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(574);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(572);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new FactorPointMethodContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(561);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(562);
						match(POINT);
						setState(563);
						builtin_method();
						}
						break;
					case 2:
						{
						_localctx = new FactorPointIDContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(564);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(565);
						match(POINT);
						setState(566);
						match(ID);
						}
						break;
					case 3:
						{
						_localctx = new FactorArrayContext(new FactorContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_factor);
						setState(567);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(568);
						match(LBRA);
						setState(569);
						expression();
						setState(570);
						match(RBRA);
						}
						break;
					}
					} 
				}
				setState(576);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		public TerminalNode OLD() { return getToken(alkParser.OLD, 0); }
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public OldFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitOldFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AnnoFactorContext extends Base_factorContext {
		public TerminalNode ANNO() { return getToken(alkParser.ANNO, 0); }
		public AnnoContext anno() {
			return getRuleContext(AnnoContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public AnnoFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitAnnoFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefNameFactorContext extends Base_factorContext {
		public Ref_nameContext ref_name() {
			return getRuleContext(Ref_nameContext.class,0);
		}
		public RefNameFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRefNameFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ResultFactorContext extends Base_factorContext {
		public TerminalNode RESULT() { return getToken(alkParser.RESULT, 0); }
		public ResultFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitResultFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanthesesFactorContext extends Base_factorContext {
		public TerminalNode LPAR() { return getToken(alkParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(alkParser.RPAR, 0); }
		public ParanthesesFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitParanthesesFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueFactorContext extends Base_factorContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueFactorContext(Base_factorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitValueFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_factorContext base_factor() throws RecognitionException {
		Base_factorContext _localctx = new Base_factorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_base_factor);
		try {
			setState(594);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RESULT:
				_localctx = new ResultFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				match(RESULT);
				}
				break;
			case OLD:
				_localctx = new OldFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				match(OLD);
				setState(579);
				match(LPAR);
				setState(580);
				match(ID);
				setState(581);
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
				setState(582);
				ref_name();
				}
				break;
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
				setState(583);
				value();
				}
				break;
			case LPAR:
				_localctx = new ParanthesesFactorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(584);
				match(LPAR);
				setState(585);
				expression();
				setState(586);
				match(RPAR);
				}
				break;
			case ANNO:
				_localctx = new AnnoFactorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(588);
				match(ANNO);
				setState(589);
				anno();
				setState(590);
				match(LPAR);
				setState(591);
				expression();
				setState(592);
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
		public TerminalNode COUNT() { return getToken(alkParser.COUNT, 0); }
		public CountAnnoContext(AnnoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitCountAnno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnoContext anno() throws RecognitionException {
		AnnoContext _localctx = new AnnoContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_anno);
		try {
			_localctx = new CountAnnoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_value);
		try {
			setState(600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case BOOL:
			case QUESTION:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(598);
				scalar_value();
				}
				break;
			case EMPTYMAP:
			case EMPTYSET:
			case EMPTYLIST:
			case EMPTYSTRUCTURE:
			case LOWER:
			case LCB:
			case LBRA:
				enterOuterAlt(_localctx, 2);
				{
				setState(599);
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
	public static class UnknownValueContext extends Scalar_valueContext {
		public TerminalNode QUESTION() { return getToken(alkParser.QUESTION, 0); }
		public UnknownValueContext(Scalar_valueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitUnknownValue(this);
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
		enterRule(_localctx, 90, RULE_scalar_value);
		try {
			setState(607);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(602);
				match(INT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(603);
				match(DOUBLE);
				}
				break;
			case BOOL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(605);
				match(STRING);
				}
				break;
			case QUESTION:
				_localctx = new UnknownValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(606);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRefFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymIDContext extends Ref_nameContext {
		public TerminalNode SYM() { return getToken(alkParser.SYM, 0); }
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public SymIDContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSymID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RefIDContext extends Ref_nameContext {
		public TerminalNode ID() { return getToken(alkParser.ID, 0); }
		public RefIDContext(Ref_nameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitRefID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ref_nameContext ref_name() throws RecognitionException {
		Ref_nameContext _localctx = new Ref_nameContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_ref_name);
		try {
			setState(613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				_localctx = new RefFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				function_call();
				}
				break;
			case 2:
				_localctx = new RefIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				match(ID);
				}
				break;
			case 3:
				_localctx = new SymIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(611);
				match(SYM);
				setState(612);
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
	public static class MappingValueContext extends Data_structureContext {
		public MappingContext mapping() {
			return getRuleContext(MappingContext.class,0);
		}
		public MappingValueContext(Data_structureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMappingValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_structureContext data_structure() throws RecognitionException {
		Data_structureContext _localctx = new Data_structureContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_data_structure);
		try {
			setState(620);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(615);
				array();
				}
				break;
			case 2:
				_localctx = new ListValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
				list();
				}
				break;
			case 3:
				_localctx = new SetValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(617);
				set();
				}
				break;
			case 4:
				_localctx = new StructureValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(618);
				structure();
				}
				break;
			case 5:
				_localctx = new MappingValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(619);
				mapping();
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
		enterRule(_localctx, 96, RULE_interval);
		try {
			_localctx = new IntervalDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			expression();
			setState(623);
			match(POINT);
			setState(624);
			match(POINT);
			setState(625);
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
		enterRule(_localctx, 98, RULE_spec);
		try {
			setState(639);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				_localctx = new FilterSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(627);
				match(ID);
				setState(628);
				match(FROM);
				setState(629);
				expression();
				setState(630);
				match(VBAR);
				setState(631);
				expression();
				}
				break;
			case 2:
				_localctx = new SelectSpecDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(633);
				expression();
				setState(634);
				match(VBAR);
				setState(635);
				match(ID);
				setState(636);
				match(FROM);
				setState(637);
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
		enterRule(_localctx, 100, RULE_array);
		int _la;
		try {
			setState(661);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new ArrayWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				match(LBRA);
				setState(642);
				spec();
				setState(643);
				match(RBRA);
				}
				break;
			case 2:
				_localctx = new ArrayWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(645);
				match(LBRA);
				setState(654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
					{
					setState(646);
					expression();
					setState(651);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(647);
						match(COMMA);
						setState(648);
						expression();
						}
						}
						setState(653);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(656);
				match(RBRA);
				}
				break;
			case 3:
				_localctx = new ArrayWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(657);
				match(LBRA);
				setState(658);
				interval();
				setState(659);
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
		enterRule(_localctx, 102, RULE_list);
		int _la;
		try {
			setState(684);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				_localctx = new EmptyListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(663);
				match(EMPTYLIST);
				}
				break;
			case 2:
				_localctx = new ListWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(664);
				match(LOWER);
				setState(665);
				spec();
				setState(666);
				match(GREATER);
				}
				break;
			case 3:
				_localctx = new ListWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(668);
				match(LOWER);
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
					{
					setState(669);
					expression();
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(670);
						match(COMMA);
						setState(671);
						expression();
						}
						}
						setState(676);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(679);
				match(GREATER);
				}
				break;
			case 4:
				_localctx = new ListWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(680);
				match(LOWER);
				setState(681);
				interval();
				setState(682);
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
	public static class EmptyStructureContext extends StructureContext {
		public TerminalNode EMPTYSTRUCTURE() { return getToken(alkParser.EMPTYSTRUCTURE, 0); }
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode ARROW() { return getToken(alkParser.ARROW, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public EmptyStructureContext(StructureContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEmptyStructure(this);
			else return visitor.visitChildren(this);
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
		enterRule(_localctx, 104, RULE_structure);
		int _la;
		try {
			setState(700);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				_localctx = new StructureWithComponentsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				match(LCB);
				setState(688); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(687);
					component();
					}
					}
					setState(690); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(692);
				match(RCB);
				}
				break;
			case 2:
				_localctx = new EmptyStructureContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(698);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EMPTYSTRUCTURE:
					{
					setState(694);
					match(EMPTYSTRUCTURE);
					}
					break;
				case LCB:
					{
					setState(695);
					match(LCB);
					setState(696);
					match(ARROW);
					setState(697);
					match(RCB);
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		enterRule(_localctx, 106, RULE_component);
		try {
			_localctx = new ComponentDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			match(ID);
			setState(703);
			match(ARROW);
			setState(704);
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
		enterRule(_localctx, 108, RULE_set);
		int _la;
		try {
			setState(727);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				_localctx = new EmptySetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(706);
				match(EMPTYSET);
				}
				break;
			case 2:
				_localctx = new SetWithSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				match(LCB);
				setState(708);
				spec();
				setState(709);
				match(RCB);
				}
				break;
			case 3:
				_localctx = new SetWithExpressionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(711);
				match(LCB);
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
					{
					setState(712);
					expression();
					setState(717);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(713);
						match(COMMA);
						setState(714);
						expression();
						}
						}
						setState(719);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(722);
				match(RCB);
				}
				break;
			case 4:
				_localctx = new SetWithIntervalContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(723);
				match(LCB);
				setState(724);
				interval();
				setState(725);
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
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public List<Mapping_componentContext> mapping_component() {
			return getRuleContexts(Mapping_componentContext.class);
		}
		public Mapping_componentContext mapping_component(int i) {
			return getRuleContext(Mapping_componentContext.class,i);
		}
		public MappingWithComponentsContext(MappingContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMappingWithComponents(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyMappingContext extends MappingContext {
		public TerminalNode EMPTYMAP() { return getToken(alkParser.EMPTYMAP, 0); }
		public TerminalNode LCB() { return getToken(alkParser.LCB, 0); }
		public TerminalNode TO() { return getToken(alkParser.TO, 0); }
		public TerminalNode RCB() { return getToken(alkParser.RCB, 0); }
		public EmptyMappingContext(MappingContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitEmptyMapping(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_mapping);
		int _la;
		try {
			setState(743);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				_localctx = new EmptyMappingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EMPTYMAP:
					{
					setState(729);
					match(EMPTYMAP);
					}
					break;
				case LCB:
					{
					setState(730);
					match(LCB);
					setState(731);
					match(TO);
					setState(732);
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
				setState(735);
				match(LCB);
				setState(737); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(736);
					mapping_component();
					}
					}
					setState(739); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0) );
				setState(741);
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
		public TerminalNode TO() { return getToken(alkParser.TO, 0); }
		public MappingComponentDefinitionContext(Mapping_componentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitMappingComponentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mapping_componentContext mapping_component() throws RecognitionException {
		Mapping_componentContext _localctx = new Mapping_componentContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_mapping_component);
		try {
			_localctx = new MappingComponentDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			expression();
			setState(746);
			match(TO);
			setState(747);
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
	public static class ToBuiltinFunctionContext extends Function_callContext {
		public Builtin_functionContext builtin_function() {
			return getRuleContext(Builtin_functionContext.class,0);
		}
		public ToBuiltinFunctionContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitToBuiltinFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_function_call);
		int _la;
		try {
			setState(763);
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
				setState(749);
				builtin_function();
				}
				break;
			case ID:
				_localctx = new DefinedFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(750);
				match(ID);
				setState(751);
				match(LPAR);
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
					{
					setState(752);
					expression();
					setState(757);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(753);
						match(COMMA);
						setState(754);
						expression();
						}
						}
						setState(759);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(762);
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
		public BuiltinFunctionContext(Builtin_functionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBuiltinFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_functionContext builtin_function() throws RecognitionException {
		Builtin_functionContext _localctx = new Builtin_functionContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_builtin_function);
		int _la;
		try {
			_localctx = new BuiltinFunctionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			function_name();
			setState(766);
			match(LPAR);
			setState(775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
				{
				setState(767);
				expression();
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(768);
					match(COMMA);
					setState(769);
					expression();
					}
					}
					setState(774);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(777);
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
		enterRule(_localctx, 118, RULE_builtin_method);
		int _la;
		try {
			_localctx = new BuiltinMethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			method_name();
			setState(780);
			match(LPAR);
			setState(789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (RESULT - 12)) | (1L << (OLD - 12)) | (1L << (FORALL - 12)) | (1L << (EXISTS - 12)) | (1L << (EMPTYMAP - 12)) | (1L << (EMPTYSET - 12)) | (1L << (EMPTYLIST - 12)) | (1L << (EMPTYSTRUCTURE - 12)) | (1L << (ABS - 12)) | (1L << (ACOS - 12)) | (1L << (ASIN - 12)) | (1L << (ATAN - 12)) | (1L << (COS - 12)) | (1L << (LOG - 12)) | (1L << (PI - 12)) | (1L << (POW - 12)) | (1L << (SIN - 12)) | (1L << (SQRT - 12)) | (1L << (TAN - 12)) | (1L << (LEN - 12)) | (1L << (FLOAT - 12)) | (1L << (INTEGER - 12)) | (1L << (PRINT - 12)))) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (SINGLETONSET - 80)) | (1L << (UNIFORMNAT - 80)) | (1L << (FLIP - 80)) | (1L << (UNIFORMFLOAT - 80)) | (1L << (UNIFORMPERM - 80)) | (1L << (SYM - 80)) | (1L << (ANNO - 80)) | (1L << (INT - 80)) | (1L << (DOUBLE - 80)) | (1L << (BOOL - 80)) | (1L << (ID - 80)) | (1L << (PLUSPLUS - 80)) | (1L << (MINUSMINUS - 80)) | (1L << (PLUSPLUSMOD - 80)) | (1L << (MINUSMINUSMOD - 80)) | (1L << (LOWER - 80)) | (1L << (MINUS - 80)) | (1L << (PLUS - 80)) | (1L << (MUL - 80)) | (1L << (LPAR - 80)) | (1L << (NOT - 80)) | (1L << (LCB - 80)) | (1L << (LBRA - 80)) | (1L << (QUESTION - 80)) | (1L << (STRING - 80)))) != 0)) {
				{
				setState(781);
				expression();
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(782);
					match(COMMA);
					setState(783);
					expression();
					}
					}
					setState(788);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(791);
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
		public TerminalNode ARRAY() { return getToken(alkParser.ARRAY, 0); }
		public TerminalNode LOWER() { return getToken(alkParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(alkParser.GREATER, 0); }
		public ArrayTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends DataTypeContext {
		public TerminalNode BOOLEAN() { return getToken(alkParser.BOOLEAN, 0); }
		public BoolTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetTypeContext extends DataTypeContext {
		public TerminalNode SET() { return getToken(alkParser.SET, 0); }
		public TerminalNode LOWER() { return getToken(alkParser.LOWER, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(alkParser.GREATER, 0); }
		public SetTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends DataTypeContext {
		public TerminalNode INTEGER() { return getToken(alkParser.INTEGER, 0); }
		public IntTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatTypeContext extends DataTypeContext {
		public TerminalNode FLOAT() { return getToken(alkParser.FLOAT, 0); }
		public FloatTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_dataType);
		try {
			setState(806);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(793);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(794);
				match(BOOLEAN);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(795);
				match(FLOAT);
				}
				break;
			case ARRAY:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(796);
				match(ARRAY);
				setState(797);
				match(LOWER);
				setState(798);
				dataType();
				setState(799);
				match(GREATER);
				}
				break;
			case SET:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(801);
				match(SET);
				setState(802);
				match(LOWER);
				setState(803);
				dataType();
				setState(804);
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
		public TerminalNode ABS() { return getToken(alkParser.ABS, 0); }
		public TerminalNode ASIN() { return getToken(alkParser.ASIN, 0); }
		public TerminalNode ACOS() { return getToken(alkParser.ACOS, 0); }
		public TerminalNode ATAN() { return getToken(alkParser.ATAN, 0); }
		public TerminalNode COS() { return getToken(alkParser.COS, 0); }
		public TerminalNode FLIP() { return getToken(alkParser.FLIP, 0); }
		public TerminalNode FLOAT() { return getToken(alkParser.FLOAT, 0); }
		public TerminalNode INTEGER() { return getToken(alkParser.INTEGER, 0); }
		public TerminalNode LEN() { return getToken(alkParser.LEN, 0); }
		public TerminalNode LOG() { return getToken(alkParser.LOG, 0); }
		public TerminalNode PI() { return getToken(alkParser.PI, 0); }
		public TerminalNode PRINT() { return getToken(alkParser.PRINT, 0); }
		public TerminalNode POW() { return getToken(alkParser.POW, 0); }
		public TerminalNode SIN() { return getToken(alkParser.SIN, 0); }
		public TerminalNode SINGLETONSET() { return getToken(alkParser.SINGLETONSET, 0); }
		public TerminalNode SQRT() { return getToken(alkParser.SQRT, 0); }
		public TerminalNode TAN() { return getToken(alkParser.TAN, 0); }
		public TerminalNode UNIFORMFLOAT() { return getToken(alkParser.UNIFORMFLOAT, 0); }
		public TerminalNode UNIFORMNAT() { return getToken(alkParser.UNIFORMNAT, 0); }
		public TerminalNode UNIFORMPERM() { return getToken(alkParser.UNIFORMPERM, 0); }
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof alkVisitor ) return ((alkVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_function_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & ((1L << (ABS - 47)) | (1L << (ACOS - 47)) | (1L << (ASIN - 47)) | (1L << (ATAN - 47)) | (1L << (COS - 47)) | (1L << (LOG - 47)) | (1L << (PI - 47)) | (1L << (POW - 47)) | (1L << (SIN - 47)) | (1L << (SQRT - 47)) | (1L << (TAN - 47)) | (1L << (LEN - 47)) | (1L << (FLOAT - 47)) | (1L << (INTEGER - 47)) | (1L << (PRINT - 47)) | (1L << (SINGLETONSET - 47)) | (1L << (UNIFORMNAT - 47)) | (1L << (FLIP - 47)) | (1L << (UNIFORMFLOAT - 47)) | (1L << (UNIFORMPERM - 47)))) != 0)) ) {
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
		public TerminalNode AT() { return getToken(alkParser.AT, 0); }
		public TerminalNode DELETE() { return getToken(alkParser.DELETE, 0); }
		public TerminalNode END() { return getToken(alkParser.END, 0); }
		public TerminalNode FIRST() { return getToken(alkParser.FIRST, 0); }
		public TerminalNode INSERT() { return getToken(alkParser.INSERT, 0); }
		public TerminalNode KEYS() { return getToken(alkParser.KEYS, 0); }
		public TerminalNode POPBACK() { return getToken(alkParser.POPBACK, 0); }
		public TerminalNode POPFRONT() { return getToken(alkParser.POPFRONT, 0); }
		public TerminalNode PUSHBACK() { return getToken(alkParser.PUSHBACK, 0); }
		public TerminalNode PUSHFRONT() { return getToken(alkParser.PUSHFRONT, 0); }
		public TerminalNode REMOVE() { return getToken(alkParser.REMOVE, 0); }
		public TerminalNode REMOVEALLEQTO() { return getToken(alkParser.REMOVEALLEQTO, 0); }
		public TerminalNode REMOVEAT() { return getToken(alkParser.REMOVEAT, 0); }
		public TerminalNode SIZE() { return getToken(alkParser.SIZE, 0); }
		public TerminalNode SPLIT() { return getToken(alkParser.SPLIT, 0); }
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
		enterRule(_localctx, 124, RULE_method_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (AT - 61)) | (1L << (DELETE - 61)) | (1L << (END - 61)) | (1L << (FIRST - 61)) | (1L << (INSERT - 61)) | (1L << (KEYS - 61)) | (1L << (POPBACK - 61)) | (1L << (POPFRONT - 61)) | (1L << (PUSHBACK - 61)) | (1L << (PUSHFRONT - 61)) | (1L << (REMOVE - 61)) | (1L << (REMOVEALLEQTO - 61)) | (1L << (REMOVEAT - 61)) | (1L << (SIZE - 61)) | (1L << (SPLIT - 61)) | (1L << (TOPBACK - 61)) | (1L << (TOPFRONT - 61)) | (1L << (UPDATE - 61)))) != 0)) ) {
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
		public TerminalNode EOF() { return getToken(alkParser.EOF, 0); }
		public List<TerminalNode> ID() { return getTokens(alkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(alkParser.ID, i);
		}
		public List<TerminalNode> TO() { return getTokens(alkParser.TO); }
		public TerminalNode TO(int i) {
			return getToken(alkParser.TO, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 126, RULE_configuration);
		int _la;
		try {
			_localctx = new ConfigContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(812);
				match(ID);
				setState(813);
				match(TO);
				setState(814);
				expression();
				}
				}
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(820);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 41:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008e\u0339\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\5\2\u0084\n\2\3\2\3\2\3\3\6\3\u0089\n\3\r"+
		"\3\16\3\u008a\3\4\3\4\3\4\5\4\u0090\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00b9\n\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u00c5\n\7\f\7\16\7\u00c8"+
		"\13\7\3\b\3\b\3\b\5\b\u00cd\n\b\3\t\3\t\3\t\3\t\7\t\u00d3\n\t\f\t\16\t"+
		"\u00d6\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\5\r\u00ea\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00f4\n\16\3\16\3\16\3\16\3\16\3\16\5\16\u00fb\n\16\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u0102\n\17\f\17\16\17\u0105\13\17\3\17\3\17\5\17\u0109"+
		"\n\17\3\20\3\20\3\20\5\20\u010e\n\20\3\20\3\20\3\20\3\20\7\20\u0114\n"+
		"\20\f\20\16\20\u0117\13\20\3\20\5\20\u011a\n\20\5\20\u011c\n\20\3\21\3"+
		"\21\3\21\3\21\5\21\u0122\n\21\3\22\3\22\3\22\5\22\u0127\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0137"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u014e\n\27\f\27\16\27\u0151"+
		"\13\27\5\27\u0153\n\27\3\27\3\27\3\27\3\27\3\27\7\27\u015a\n\27\f\27\16"+
		"\27\u015d\13\27\5\27\u015f\n\27\3\27\3\27\3\27\5\27\u0164\n\27\7\27\u0166"+
		"\n\27\f\27\16\27\u0169\13\27\3\27\3\27\3\27\5\27\u016e\n\27\7\27\u0170"+
		"\n\27\f\27\16\27\u0173\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\7\30\u017f\n\30\f\30\16\30\u0182\13\30\5\30\u0184\n\30\3\31\3"+
		"\31\3\31\3\31\5\31\u018a\n\31\3\32\5\32\u018d\n\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u01a1\n\33\f\33\16\33\u01a4\13\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u01b1\n\33\f\33\16\33\u01b4\13\33\3\33"+
		"\3\33\3\33\3\33\5\33\u01ba\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u01c1\n"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01c9\n\35\3\36\3\36\3\36\7\36"+
		"\u01ce\n\36\f\36\16\36\u01d1\13\36\3\37\3\37\3\37\7\37\u01d6\n\37\f\37"+
		"\16\37\u01d9\13\37\3 \3 \3 \7 \u01de\n \f \16 \u01e1\13 \3!\3!\3!\7!\u01e6"+
		"\n!\f!\16!\u01e9\13!\3\"\3\"\3\"\7\"\u01ee\n\"\f\"\16\"\u01f1\13\"\3#"+
		"\3#\3#\7#\u01f6\n#\f#\16#\u01f9\13#\3$\3$\3$\7$\u01fe\n$\f$\16$\u0201"+
		"\13$\3%\3%\3%\7%\u0206\n%\f%\16%\u0209\13%\3&\3&\3&\7&\u020e\n&\f&\16"+
		"&\u0211\13&\3\'\3\'\3\'\7\'\u0216\n\'\f\'\16\'\u0219\13\'\3(\3(\3(\7("+
		"\u021e\n(\f(\16(\u0221\13(\3)\3)\3)\3)\3)\5)\u0228\n)\3*\3*\7*\u022c\n"+
		"*\f*\16*\u022f\13*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u023f"+
		"\n+\f+\16+\u0242\13+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\5,\u0255\n,\3-\3-\3.\3.\5.\u025b\n.\3/\3/\3/\3/\3/\5/\u0262\n/\3\60"+
		"\3\60\3\60\3\60\5\60\u0268\n\60\3\61\3\61\3\61\3\61\3\61\5\61\u026f\n"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\5\63\u0282\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\7\64\u028c\n\64\f\64\16\64\u028f\13\64\5\64\u0291\n\64\3\64\3\64"+
		"\3\64\3\64\3\64\5\64\u0298\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\7\65\u02a3\n\65\f\65\16\65\u02a6\13\65\5\65\u02a8\n\65\3\65\3\65"+
		"\3\65\3\65\3\65\5\65\u02af\n\65\3\66\3\66\6\66\u02b3\n\66\r\66\16\66\u02b4"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u02bd\n\66\5\66\u02bf\n\66\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\38\38\38\38\78\u02ce\n8\f8\168\u02d1\138"+
		"\58\u02d3\n8\38\38\38\38\38\58\u02da\n8\39\39\39\39\59\u02e0\n9\39\39"+
		"\69\u02e4\n9\r9\169\u02e5\39\39\59\u02ea\n9\3:\3:\3:\3:\3;\3;\3;\3;\3"+
		";\3;\7;\u02f6\n;\f;\16;\u02f9\13;\5;\u02fb\n;\3;\5;\u02fe\n;\3<\3<\3<"+
		"\3<\3<\7<\u0305\n<\f<\16<\u0308\13<\5<\u030a\n<\3<\3<\3=\3=\3=\3=\3=\7"+
		"=\u0313\n=\f=\16=\u0316\13=\5=\u0318\n=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\5>\u0329\n>\3?\3?\3@\3@\3A\3A\3A\7A\u0332\nA\fA\16A\u0335"+
		"\13A\3A\3A\3A\2\3TB\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\2\17\3\2-.\3\2tu"+
		"\3\2ps\3\2bd\4\2\60\60\u0085\u0085\3\2~\177\4\2lmwx\3\2y{\4\2ijno\4\2"+
		"wy\u0082\u0082\3\2ij\b\2\61<EEHHJJRRX[\b\2??AACDFGKQSW\2\u0373\2\u0083"+
		"\3\2\2\2\4\u0088\3\2\2\2\6\u00b8\3\2\2\2\b\u00ba\3\2\2\2\n\u00bd\3\2\2"+
		"\2\f\u00c0\3\2\2\2\16\u00c9\3\2\2\2\20\u00ce\3\2\2\2\22\u00d7\3\2\2\2"+
		"\24\u00dc\3\2\2\2\26\u00e0\3\2\2\2\30\u00e7\3\2\2\2\32\u00fa\3\2\2\2\34"+
		"\u00fc\3\2\2\2\36\u011b\3\2\2\2 \u0121\3\2\2\2\"\u0123\3\2\2\2$\u0128"+
		"\3\2\2\2&\u012f\3\2\2\2(\u0138\3\2\2\2*\u0142\3\2\2\2,\u0148\3\2\2\2."+
		"\u0183\3\2\2\2\60\u0189\3\2\2\2\62\u018c\3\2\2\2\64\u01b9\3\2\2\2\66\u01c0"+
		"\3\2\2\28\u01c2\3\2\2\2:\u01ca\3\2\2\2<\u01d2\3\2\2\2>\u01da\3\2\2\2@"+
		"\u01e2\3\2\2\2B\u01ea\3\2\2\2D\u01f2\3\2\2\2F\u01fa\3\2\2\2H\u0202\3\2"+
		"\2\2J\u020a\3\2\2\2L\u0212\3\2\2\2N\u021a\3\2\2\2P\u0227\3\2\2\2R\u0229"+
		"\3\2\2\2T\u0230\3\2\2\2V\u0254\3\2\2\2X\u0256\3\2\2\2Z\u025a\3\2\2\2\\"+
		"\u0261\3\2\2\2^\u0267\3\2\2\2`\u026e\3\2\2\2b\u0270\3\2\2\2d\u0281\3\2"+
		"\2\2f\u0297\3\2\2\2h\u02ae\3\2\2\2j\u02be\3\2\2\2l\u02c0\3\2\2\2n\u02d9"+
		"\3\2\2\2p\u02e9\3\2\2\2r\u02eb\3\2\2\2t\u02fd\3\2\2\2v\u02ff\3\2\2\2x"+
		"\u030d\3\2\2\2z\u0328\3\2\2\2|\u032a\3\2\2\2~\u032c\3\2\2\2\u0080\u0333"+
		"\3\2\2\2\u0082\u0084\5\4\3\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\7\2\2\3\u0086\3\3\2\2\2\u0087\u0089\5\6\4\2"+
		"\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\5\3\2\2\2\u008c\u00b9\5,\27\2\u008d\u008f\7#\2\2\u008e"+
		"\u0090\5\64\33\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u00b9\7\u0083\2\2\u0092\u0093\5\32\16\2\u0093\u0094\7\u0083"+
		"\2\2\u0094\u00b9\3\2\2\2\u0095\u0096\7$\2\2\u0096\u00b9\7\u0083\2\2\u0097"+
		"\u0098\7&\2\2\u0098\u00b9\7\u0083\2\2\u0099\u009a\7\'\2\2\u009a\u00b9"+
		"\7\u0083\2\2\u009b\u009c\7(\2\2\u009c\u00b9\7\u0083\2\2\u009d\u00b9\5"+
		"\30\r\2\u009e\u00b9\5\24\13\2\u009f\u00a0\5\26\f\2\u00a0\u00a1\7\u0083"+
		"\2\2\u00a1\u00b9\3\2\2\2\u00a2\u00b9\5\34\17\2\u00a3\u00a4\5$\23\2\u00a4"+
		"\u00a5\7\u0083\2\2\u00a5\u00b9\3\2\2\2\u00a6\u00b9\5&\24\2\u00a7\u00b9"+
		"\5(\25\2\u00a8\u00b9\5*\26\2\u00a9\u00aa\5\64\33\2\u00aa\u00ab\7\u0083"+
		"\2\2\u00ab\u00b9\3\2\2\2\u00ac\u00ad\5\20\t\2\u00ad\u00ae\7\u0083\2\2"+
		"\u00ae\u00b9\3\2\2\2\u00af\u00b0\5\f\7\2\u00b0\u00b1\7\u0083\2\2\u00b1"+
		"\u00b9\3\2\2\2\u00b2\u00b3\5\b\5\2\u00b3\u00b4\7\u0083\2\2\u00b4\u00b9"+
		"\3\2\2\2\u00b5\u00b6\5\n\6\2\u00b6\u00b7\7\u0083\2\2\u00b7\u00b9\3\2\2"+
		"\2\u00b8\u008c\3\2\2\2\u00b8\u008d\3\2\2\2\u00b8\u0092\3\2\2\2\u00b8\u0095"+
		"\3\2\2\2\u00b8\u0097\3\2\2\2\u00b8\u0099\3\2\2\2\u00b8\u009b\3\2\2\2\u00b8"+
		"\u009d\3\2\2\2\u00b8\u009e\3\2\2\2\u00b8\u009f\3\2\2\2\u00b8\u00a2\3\2"+
		"\2\2\u00b8\u00a3\3\2\2\2\u00b8\u00a6\3\2\2\2\u00b8\u00a7\3\2\2\2\u00b8"+
		"\u00a8\3\2\2\2\u00b8\u00a9\3\2\2\2\u00b8\u00ac\3\2\2\2\u00b8\u00af\3\2"+
		"\2\2\u00b8\u00b2\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9\7\3\2\2\2\u00ba\u00bb"+
		"\7\7\2\2\u00bb\u00bc\5\64\33\2\u00bc\t\3\2\2\2\u00bd\u00be\7\6\2\2\u00be"+
		"\u00bf\5\64\33\2\u00bf\13\3\2\2\2\u00c0\u00c1\7\37\2\2\u00c1\u00c6\5\16"+
		"\b\2\u00c2\u00c3\7\u0088\2\2\u00c3\u00c5\5\16\b\2\u00c4\u00c2\3\2\2\2"+
		"\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\r\3"+
		"\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\7h\2\2\u00ca\u00cb\7\u0084\2\2"+
		"\u00cb\u00cd\5z>\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\17\3"+
		"\2\2\2\u00ce\u00cf\7\b\2\2\u00cf\u00d4\5\22\n\2\u00d0\u00d1\7\u0088\2"+
		"\2\u00d1\u00d3\5\22\n\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\21\3\2\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d7\u00d8\7]\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7\u0084\2\2\u00da"+
		"\u00db\5z>\2\u00db\23\3\2\2\2\u00dc\u00dd\7_\2\2\u00dd\u00de\7/\2\2\u00de"+
		"\u00df\7\u008e\2\2\u00df\25\3\2\2\2\u00e0\u00e1\7\"\2\2\u00e1\u00e2\5"+
		"\6\4\2\u00e2\u00e3\7%\2\2\u00e3\u00e4\7|\2\2\u00e4\u00e5\5\64\33\2\u00e5"+
		"\u00e6\7}\2\2\u00e6\27\3\2\2\2\u00e7\u00e9\7\u0086\2\2\u00e8\u00ea\5\4"+
		"\3\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\7\u0087\2\2\u00ec\31\3\2\2\2\u00ed\u00ee\7 \2\2\u00ee\u00ef\5\64"+
		"\33\2\u00ef\u00f0\7\35\2\2\u00f0\u00f3\5\64\33\2\u00f1\u00f2\7\\\2\2\u00f2"+
		"\u00f4\5\64\33\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00fb\3"+
		"\2\2\2\u00f5\u00f6\7!\2\2\u00f6\u00f7\5\64\33\2\u00f7\u00f8\7\35\2\2\u00f8"+
		"\u00f9\5\64\33\2\u00f9\u00fb\3\2\2\2\u00fa\u00ed\3\2\2\2\u00fa\u00f5\3"+
		"\2\2\2\u00fb\33\3\2\2\2\u00fc\u00fd\7\30\2\2\u00fd\u00fe\7|\2\2\u00fe"+
		"\u00ff\5\64\33\2\u00ff\u0103\7}\2\2\u0100\u0102\5\36\20\2\u0101\u0100"+
		"\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0108\5\6\4\2\u0107\u0109\5\""+
		"\22\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\35\3\2\2\2\u010a\u010b"+
		"\7\t\2\2\u010b\u010d\5\64\33\2\u010c\u010e\7\u0083\2\2\u010d\u010c\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u011c\3\2\2\2\u010f\u0110\7\r\2\2\u0110"+
		"\u0115\5 \21\2\u0111\u0112\7\u0088\2\2\u0112\u0114\5 \21\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011a\7\u0083\2\2\u0119\u0118"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u010a\3\2\2\2\u011b"+
		"\u010f\3\2\2\2\u011c\37\3\2\2\2\u011d\u0122\7h\2\2\u011e\u011f\7h\2\2"+
		"\u011f\u0120\7\u0089\2\2\u0120\u0122\7S\2\2\u0121\u011d\3\2\2\2\u0121"+
		"\u011e\3\2\2\2\u0122!\3\2\2\2\u0123\u0124\7\f\2\2\u0124\u0126\5\64\33"+
		"\2\u0125\u0127\7\u0083\2\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"#\3\2\2\2\u0128\u0129\7\31\2\2\u0129\u012a\5\6\4\2\u012a\u012b\7\30\2"+
		"\2\u012b\u012c\7|\2\2\u012c\u012d\5\64\33\2\u012d\u012e\7}\2\2\u012e%"+
		"\3\2\2\2\u012f\u0130\7\26\2\2\u0130\u0131\7|\2\2\u0131\u0132\5\64\33\2"+
		"\u0132\u0133\7}\2\2\u0133\u0136\5\6\4\2\u0134\u0135\7\27\2\2\u0135\u0137"+
		"\5\6\4\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\'\3\2\2\2\u0138"+
		"\u0139\7\32\2\2\u0139\u013a\7|\2\2\u013a\u013b\5\64\33\2\u013b\u013c\7"+
		"\u0083\2\2\u013c\u013d\5\64\33\2\u013d\u013e\7\u0083\2\2\u013e\u013f\5"+
		"\64\33\2\u013f\u0140\7}\2\2\u0140\u0141\5\6\4\2\u0141)\3\2\2\2\u0142\u0143"+
		"\7\33\2\2\u0143\u0144\7h\2\2\u0144\u0145\7\35\2\2\u0145\u0146\5\64\33"+
		"\2\u0146\u0147\5\6\4\2\u0147+\3\2\2\2\u0148\u0149\7h\2\2\u0149\u0152\7"+
		"|\2\2\u014a\u014f\5\62\32\2\u014b\u014c\7\u0088\2\2\u014c\u014e\5\62\32"+
		"\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u014a\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u015e\7}\2\2\u0155\u0156\t\2"+
		"\2\2\u0156\u015b\7h\2\2\u0157\u0158\7\u0088\2\2\u0158\u015a\7h\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u0155\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0167\3\2\2\2\u0160\u0161\7\n\2\2\u0161\u0163\5."+
		"\30\2\u0162\u0164\7\u0083\2\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2"+
		"\u0164\u0166\3\2\2\2\u0165\u0160\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0171\3\2\2\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016b\7\13\2\2\u016b\u016d\5\60\31\2\u016c\u016e\7\u0083\2\2\u016d\u016c"+
		"\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u0170\3\2\2\2\u016f\u016a\3\2\2\2\u0170"+
		"\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2"+
		"\2\2\u0173\u0171\3\2\2\2\u0174\u0175\5\30\r\2\u0175-\3\2\2\2\u0176\u0184"+
		"\5\64\33\2\u0177\u0178\7h\2\2\u0178\u0179\7\u0084\2\2\u0179\u0180\5z>"+
		"\2\u017a\u017b\7\u0081\2\2\u017b\u017c\7h\2\2\u017c\u017d\7\u0084\2\2"+
		"\u017d\u017f\5z>\2\u017e\u017a\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0183"+
		"\u0176\3\2\2\2\u0183\u0177\3\2\2\2\u0184/\3\2\2\2\u0185\u018a\5\64\33"+
		"\2\u0186\u0187\7\16\2\2\u0187\u0188\7\u0084\2\2\u0188\u018a\5z>\2\u0189"+
		"\u0185\3\2\2\2\u0189\u0186\3\2\2\2\u018a\61\3\2\2\2\u018b\u018d\7\36\2"+
		"\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f"+
		"\7h\2\2\u018f\63\3\2\2\2\u0190\u0191\5\66\34\2\u0191\u0192\7\20\2\2\u0192"+
		"\u0193\5\64\33\2\u0193\u01ba\3\2\2\2\u0194\u0195\5\66\34\2\u0195\u0196"+
		"\7\21\2\2\u0196\u0197\5\64\33\2\u0197\u01ba\3\2\2\2\u0198\u0199\7\22\2"+
		"\2\u0199\u019a\7h\2\2\u019a\u019b\7\u0084\2\2\u019b\u01a2\5z>\2\u019c"+
		"\u019d\7\u0088\2\2\u019d\u019e\7h\2\2\u019e\u019f\7\u0084\2\2\u019f\u01a1"+
		"\5z>\2\u01a0\u019c\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\7\24"+
		"\2\2\u01a6\u01a7\5\64\33\2\u01a7\u01ba\3\2\2\2\u01a8\u01a9\7\23\2\2\u01a9"+
		"\u01aa\7h\2\2\u01aa\u01ab\7\u0084\2\2\u01ab\u01b2\5z>\2\u01ac\u01ad\7"+
		"\u0088\2\2\u01ad\u01ae\7h\2\2\u01ae\u01af\7\u0084\2\2\u01af\u01b1\5z>"+
		"\2\u01b0\u01ac\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3"+
		"\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\7\24\2\2"+
		"\u01b6\u01b7\5\64\33\2\u01b7\u01ba\3\2\2\2\u01b8\u01ba\5\66\34\2\u01b9"+
		"\u0190\3\2\2\2\u01b9\u0194\3\2\2\2\u01b9\u0198\3\2\2\2\u01b9\u01a8\3\2"+
		"\2\2\u01b9\u01b8\3\2\2\2\u01ba\65\3\2\2\2\u01bb\u01bc\5T+\2\u01bc\u01bd"+
		"\7v\2\2\u01bd\u01be\5\64\33\2\u01be\u01c1\3\2\2\2\u01bf\u01c1\58\35\2"+
		"\u01c0\u01bb\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1\67\3\2\2\2\u01c2\u01c8"+
		"\5:\36\2\u01c3\u01c4\7\u008d\2\2\u01c4\u01c5\5\64\33\2\u01c5\u01c6\7\u0084"+
		"\2\2\u01c6\u01c7\5\64\33\2\u01c7\u01c9\3\2\2\2\u01c8\u01c3\3\2\2\2\u01c8"+
		"\u01c9\3\2\2\2\u01c99\3\2\2\2\u01ca\u01cf\5<\37\2\u01cb\u01cc\7\u0080"+
		"\2\2\u01cc\u01ce\5<\37\2\u01cd\u01cb\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf"+
		"\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0;\3\2\2\2\u01d1\u01cf\3\2\2\2"+
		"\u01d2\u01d7\5> \2\u01d3\u01d4\7\u0081\2\2\u01d4\u01d6\5> \2\u01d5\u01d3"+
		"\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8"+
		"=\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01df\5@!\2\u01db\u01dc\7\34\2\2\u01dc"+
		"\u01de\5@!\2\u01dd\u01db\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2"+
		"\2\u01df\u01e0\3\2\2\2\u01e0?\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01e7"+
		"\5B\"\2\u01e3\u01e4\t\3\2\2\u01e4\u01e6\5B\"\2\u01e5\u01e3\3\2\2\2\u01e6"+
		"\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3\2\2\2\u01e8A\3\2\2\2"+
		"\u01e9\u01e7\3\2\2\2\u01ea\u01ef\5D#\2\u01eb\u01ec\t\4\2\2\u01ec\u01ee"+
		"\5D#\2\u01ed\u01eb\3\2\2\2\u01ee\u01f1\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef"+
		"\u01f0\3\2\2\2\u01f0C\3\2\2\2\u01f1\u01ef\3\2\2\2\u01f2\u01f7\5F$\2\u01f3"+
		"\u01f4\t\5\2\2\u01f4\u01f6\5F$\2\u01f5\u01f3\3\2\2\2\u01f6\u01f9\3\2\2"+
		"\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8E\3\2\2\2\u01f9\u01f7"+
		"\3\2\2\2\u01fa\u01ff\5H%\2\u01fb\u01fc\t\6\2\2\u01fc\u01fe\5H%\2\u01fd"+
		"\u01fb\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200G\3\2\2\2\u0201\u01ff\3\2\2\2\u0202\u0207\5J&\2\u0203\u0204"+
		"\7k\2\2\u0204\u0206\5J&\2\u0205\u0203\3\2\2\2\u0206\u0209\3\2\2\2\u0207"+
		"\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208I\3\2\2\2\u0209\u0207\3\2\2\2"+
		"\u020a\u020f\5L\'\2\u020b\u020c\t\7\2\2\u020c\u020e\5L\'\2\u020d\u020b"+
		"\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"K\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0217\5N(\2\u0213\u0214\t\b\2\2\u0214"+
		"\u0216\5N(\2\u0215\u0213\3\2\2\2\u0216\u0219\3\2\2\2\u0217\u0215\3\2\2"+
		"\2\u0217\u0218\3\2\2\2\u0218M\3\2\2\2\u0219\u0217\3\2\2\2\u021a\u021f"+
		"\5P)\2\u021b\u021c\t\t\2\2\u021c\u021e\5P)\2\u021d\u021b\3\2\2\2\u021e"+
		"\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220O\3\2\2\2"+
		"\u0221\u021f\3\2\2\2\u0222\u0223\t\n\2\2\u0223\u0228\5P)\2\u0224\u0225"+
		"\t\13\2\2\u0225\u0228\5P)\2\u0226\u0228\5R*\2\u0227\u0222\3\2\2\2\u0227"+
		"\u0224\3\2\2\2\u0227\u0226\3\2\2\2\u0228Q\3\2\2\2\u0229\u022d\5T+\2\u022a"+
		"\u022c\t\f\2\2\u022b\u022a\3\2\2\2\u022c\u022f\3\2\2\2\u022d\u022b\3\2"+
		"\2\2\u022d\u022e\3\2\2\2\u022eS\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0231"+
		"\b+\1\2\u0231\u0232\5V,\2\u0232\u0240\3\2\2\2\u0233\u0234\f\6\2\2\u0234"+
		"\u0235\7\u0089\2\2\u0235\u023f\5x=\2\u0236\u0237\f\5\2\2\u0237\u0238\7"+
		"\u0089\2\2\u0238\u023f\7h\2\2\u0239\u023a\f\4\2\2\u023a\u023b\7\u008a"+
		"\2\2\u023b\u023c\5\64\33\2\u023c\u023d\7\u008b\2\2\u023d\u023f\3\2\2\2"+
		"\u023e\u0233\3\2\2\2\u023e\u0236\3\2\2\2\u023e\u0239\3\2\2\2\u023f\u0242"+
		"\3\2\2\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241U\3\2\2\2\u0242"+
		"\u0240\3\2\2\2\u0243\u0255\7\16\2\2\u0244\u0245\7\17\2\2\u0245\u0246\7"+
		"|\2\2\u0246\u0247\7h\2\2\u0247\u0255\7}\2\2\u0248\u0255\5^\60\2\u0249"+
		"\u0255\5Z.\2\u024a\u024b\7|\2\2\u024b\u024c\5\64\33\2\u024c\u024d\7}\2"+
		"\2\u024d\u0255\3\2\2\2\u024e\u024f\7`\2\2\u024f\u0250\5X-\2\u0250\u0251"+
		"\7|\2\2\u0251\u0252\5\64\33\2\u0252\u0253\7}\2\2\u0253\u0255\3\2\2\2\u0254"+
		"\u0243\3\2\2\2\u0254\u0244\3\2\2\2\u0254\u0248\3\2\2\2\u0254\u0249\3\2"+
		"\2\2\u0254\u024a\3\2\2\2\u0254\u024e\3\2\2\2\u0255W\3\2\2\2\u0256\u0257"+
		"\7a\2\2\u0257Y\3\2\2\2\u0258\u025b\5\\/\2\u0259\u025b\5`\61\2\u025a\u0258"+
		"\3\2\2\2\u025a\u0259\3\2\2\2\u025b[\3\2\2\2\u025c\u0262\7e\2\2\u025d\u0262"+
		"\7f\2\2\u025e\u0262\7g\2\2\u025f\u0262\7\u008e\2\2\u0260\u0262\7\u008d"+
		"\2\2\u0261\u025c\3\2\2\2\u0261\u025d\3\2\2\2\u0261\u025e\3\2\2\2\u0261"+
		"\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262]\3\2\2\2\u0263\u0268\5t;\2\u0264"+
		"\u0268\7h\2\2\u0265\u0266\7]\2\2\u0266\u0268\7h\2\2\u0267\u0263\3\2\2"+
		"\2\u0267\u0264\3\2\2\2\u0267\u0265\3\2\2\2\u0268_\3\2\2\2\u0269\u026f"+
		"\5f\64\2\u026a\u026f\5h\65\2\u026b\u026f\5n8\2\u026c\u026f\5j\66\2\u026d"+
		"\u026f\5p9\2\u026e\u0269\3\2\2\2\u026e\u026a\3\2\2\2\u026e\u026b\3\2\2"+
		"\2\u026e\u026c\3\2\2\2\u026e\u026d\3\2\2\2\u026fa\3\2\2\2\u0270\u0271"+
		"\5\64\33\2\u0271\u0272\7\u0089\2\2\u0272\u0273\7\u0089\2\2\u0273\u0274"+
		"\5\64\33\2\u0274c\3\2\2\2\u0275\u0276\7h\2\2\u0276\u0277\7\35\2\2\u0277"+
		"\u0278\5\64\33\2\u0278\u0279\7\u0085\2\2\u0279\u027a\5\64\33\2\u027a\u0282"+
		"\3\2\2\2\u027b\u027c\5\64\33\2\u027c\u027d\7\u0085\2\2\u027d\u027e\7h"+
		"\2\2\u027e\u027f\7\35\2\2\u027f\u0280\5\64\33\2\u0280\u0282\3\2\2\2\u0281"+
		"\u0275\3\2\2\2\u0281\u027b\3\2\2\2\u0282e\3\2\2\2\u0283\u0284\7\u008a"+
		"\2\2\u0284\u0285\5d\63\2\u0285\u0286\7\u008b\2\2\u0286\u0298\3\2\2\2\u0287"+
		"\u0290\7\u008a\2\2\u0288\u028d\5\64\33\2\u0289\u028a\7\u0088\2\2\u028a"+
		"\u028c\5\64\33\2\u028b\u0289\3\2\2\2\u028c\u028f\3\2\2\2\u028d\u028b\3"+
		"\2\2\2\u028d\u028e\3\2\2\2\u028e\u0291\3\2\2\2\u028f\u028d\3\2\2\2\u0290"+
		"\u0288\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0298\7\u008b"+
		"\2\2\u0293\u0294\7\u008a\2\2\u0294\u0295\5b\62\2\u0295\u0296\7\u008b\2"+
		"\2\u0296\u0298\3\2\2\2\u0297\u0283\3\2\2\2\u0297\u0287\3\2\2\2\u0297\u0293"+
		"\3\2\2\2\u0298g\3\2\2\2\u0299\u02af\7+\2\2\u029a\u029b\7p\2\2\u029b\u029c"+
		"\5d\63\2\u029c\u029d\7q\2\2\u029d\u02af\3\2\2\2\u029e\u02a7\7p\2\2\u029f"+
		"\u02a4\5\64\33\2\u02a0\u02a1\7\u0088\2\2\u02a1\u02a3\5\64\33\2\u02a2\u02a0"+
		"\3\2\2\2\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u02a8\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u029f\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02af\7q\2\2\u02aa\u02ab\7p\2\2\u02ab\u02ac"+
		"\5b\62\2\u02ac\u02ad\7q\2\2\u02ad\u02af\3\2\2\2\u02ae\u0299\3\2\2\2\u02ae"+
		"\u029a\3\2\2\2\u02ae\u029e\3\2\2\2\u02ae\u02aa\3\2\2\2\u02afi\3\2\2\2"+
		"\u02b0\u02b2\7\u0086\2\2\u02b1\u02b3\5l\67\2\u02b2\u02b1\3\2\2\2\u02b3"+
		"\u02b4\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b6\3\2"+
		"\2\2\u02b6\u02b7\7\u0087\2\2\u02b7\u02bf\3\2\2\2\u02b8\u02bd\7,\2\2\u02b9"+
		"\u02ba\7\u0086\2\2\u02ba\u02bb\7^\2\2\u02bb\u02bd\7\u0087\2\2\u02bc\u02b8"+
		"\3\2\2\2\u02bc\u02b9\3\2\2\2\u02bd\u02bf\3\2\2\2\u02be\u02b0\3\2\2\2\u02be"+
		"\u02bc\3\2\2\2\u02bfk\3\2\2\2\u02c0\u02c1\7h\2\2\u02c1\u02c2\7^\2\2\u02c2"+
		"\u02c3\5\64\33\2\u02c3m\3\2\2\2\u02c4\u02da\7*\2\2\u02c5\u02c6\7\u0086"+
		"\2\2\u02c6\u02c7\5d\63\2\u02c7\u02c8\7\u0087\2\2\u02c8\u02da\3\2\2\2\u02c9"+
		"\u02d2\7\u0086\2\2\u02ca\u02cf\5\64\33\2\u02cb\u02cc\7\u0088\2\2\u02cc"+
		"\u02ce\5\64\33\2\u02cd\u02cb\3\2\2\2\u02ce\u02d1\3\2\2\2\u02cf\u02cd\3"+
		"\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d3\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2"+
		"\u02ca\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02da\7\u0087"+
		"\2\2\u02d5\u02d6\7\u0086\2\2\u02d6\u02d7\5b\62\2\u02d7\u02d8\7\u0087\2"+
		"\2\u02d8\u02da\3\2\2\2\u02d9\u02c4\3\2\2\2\u02d9\u02c5\3\2\2\2\u02d9\u02c9"+
		"\3\2\2\2\u02d9\u02d5\3\2\2\2\u02dao\3\2\2\2\u02db\u02e0\7)\2\2\u02dc\u02dd"+
		"\7\u0086\2\2\u02dd\u02de\7\25\2\2\u02de\u02e0\7\u0087\2\2\u02df\u02db"+
		"\3\2\2\2\u02df\u02dc\3\2\2\2\u02e0\u02ea\3\2\2\2\u02e1\u02e3\7\u0086\2"+
		"\2\u02e2\u02e4\5r:\2\u02e3\u02e2\3\2\2\2\u02e4\u02e5\3\2\2\2\u02e5\u02e3"+
		"\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7\u02e8\7\u0087\2"+
		"\2\u02e8\u02ea\3\2\2\2\u02e9\u02df\3\2\2\2\u02e9\u02e1\3\2\2\2\u02eaq"+
		"\3\2\2\2\u02eb\u02ec\5\64\33\2\u02ec\u02ed\7\25\2\2\u02ed\u02ee\5\64\33"+
		"\2\u02ees\3\2\2\2\u02ef\u02fe\5v<\2\u02f0\u02f1\7h\2\2\u02f1\u02fa\7|"+
		"\2\2\u02f2\u02f7\5\64\33\2\u02f3\u02f4\7\u0088\2\2\u02f4\u02f6\5\64\33"+
		"\2\u02f5\u02f3\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5\3\2\2\2\u02f7\u02f8"+
		"\3\2\2\2\u02f8\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa\u02f2\3\2\2\2\u02fa"+
		"\u02fb\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fe\7}\2\2\u02fd\u02ef\3\2"+
		"\2\2\u02fd\u02f0\3\2\2\2\u02feu\3\2\2\2\u02ff\u0300\5|?\2\u0300\u0309"+
		"\7|\2\2\u0301\u0306\5\64\33\2\u0302\u0303\7\u0088\2\2\u0303\u0305\5\64"+
		"\33\2\u0304\u0302\3\2\2\2\u0305\u0308\3\2\2\2\u0306\u0304\3\2\2\2\u0306"+
		"\u0307\3\2\2\2\u0307\u030a\3\2\2\2\u0308\u0306\3\2\2\2\u0309\u0301\3\2"+
		"\2\2\u0309\u030a\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030c\7}\2\2\u030c"+
		"w\3\2\2\2\u030d\u030e\5~@\2\u030e\u0317\7|\2\2\u030f\u0314\5\64\33\2\u0310"+
		"\u0311\7\u0088\2\2\u0311\u0313\5\64\33\2\u0312\u0310\3\2\2\2\u0313\u0316"+
		"\3\2\2\2\u0314\u0312\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0318\3\2\2\2\u0316"+
		"\u0314\3\2\2\2\u0317\u030f\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0319\3\2"+
		"\2\2\u0319\u031a\7}\2\2\u031ay\3\2\2\2\u031b\u0329\7H\2\2\u031c\u0329"+
		"\7I\2\2\u031d\u0329\7E\2\2\u031e\u031f\7=\2\2\u031f\u0320\7p\2\2\u0320"+
		"\u0321\5z>\2\u0321\u0322\7q\2\2\u0322\u0329\3\2\2\2\u0323\u0324\7>\2\2"+
		"\u0324\u0325\7p\2\2\u0325\u0326\5z>\2\u0326\u0327\7q\2\2\u0327\u0329\3"+
		"\2\2\2\u0328\u031b\3\2\2\2\u0328\u031c\3\2\2\2\u0328\u031d\3\2\2\2\u0328"+
		"\u031e\3\2\2\2\u0328\u0323\3\2\2\2\u0329{\3\2\2\2\u032a\u032b\t\r\2\2"+
		"\u032b}\3\2\2\2\u032c\u032d\t\16\2\2\u032d\177\3\2\2\2\u032e\u032f\7h"+
		"\2\2\u032f\u0330\7\25\2\2\u0330\u0332\5\64\33\2\u0331\u032e\3\2\2\2\u0332"+
		"\u0335\3\2\2\2\u0333\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0336\3\2"+
		"\2\2\u0335\u0333\3\2\2\2\u0336\u0337\7\2\2\3\u0337\u0081\3\2\2\2S\u0083"+
		"\u008a\u008f\u00b8\u00c6\u00cc\u00d4\u00e9\u00f3\u00fa\u0103\u0108\u010d"+
		"\u0115\u0119\u011b\u0121\u0126\u0136\u014f\u0152\u015b\u015e\u0163\u0167"+
		"\u016d\u0171\u0180\u0183\u0189\u018c\u01a2\u01b2\u01b9\u01c0\u01c8\u01cf"+
		"\u01d7\u01df\u01e7\u01ef\u01f7\u01ff\u0207\u020f\u0217\u021f\u0227\u022d"+
		"\u023e\u0240\u0254\u025a\u0261\u0267\u026e\u0281\u028d\u0290\u0297\u02a4"+
		"\u02a7\u02ae\u02b4\u02bc\u02be\u02cf\u02d2\u02d9\u02df\u02e5\u02e9\u02f7"+
		"\u02fa\u02fd\u0306\u0309\u0314\u0317\u0328\u0333";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
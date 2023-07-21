// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/java/grammar/parts/AlkStatements.g4 by ANTLR 4.10.1
package grammar.parts;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link statementParser}.
 */
public interface statementListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link statementParser#statement_sequence}.
	 * @param ctx the parse tree
	 */
	void enterStatementSeq(statementParser.StatementSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link statementParser#statement_sequence}.
	 * @param ctx the parse tree
	 */
	void exitStatementSeq(statementParser.StatementSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToFunctionDecl(statementParser.ToFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToFunctionDecl(statementParser.ToFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToSpecification(statementParser.ToSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToSpecification(statementParser.ToSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(statementParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(statementParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToChooseStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToChooseStmt(statementParser.ToChooseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToChooseStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToChooseStmt(statementParser.ToChooseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Success}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSuccess(statementParser.SuccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSuccess(statementParser.SuccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFailure(statementParser.FailureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFailure(statementParser.FailureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(statementParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(statementParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(statementParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(statementParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToBlock(statementParser.ToBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToBlock(statementParser.ToBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToDirective(statementParser.ToDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToDirective(statementParser.ToDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToRepeat}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToRepeat(statementParser.ToRepeatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToRepeat}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToRepeat(statementParser.ToRepeatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToWhile(statementParser.ToWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToWhile(statementParser.ToWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToDoWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToDoWhile(statementParser.ToDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToDoWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToDoWhile(statementParser.ToDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToIf}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToIf(statementParser.ToIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToIf}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToIf(statementParser.ToIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToFor}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToFor(statementParser.ToForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToFor}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToFor(statementParser.ToForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToForEach}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToForEach(statementParser.ToForEachContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToForEach}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToForEach(statementParser.ToForEachContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(statementParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(statementParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicDeclStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicDeclStmt(statementParser.SymbolicDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicDeclStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicDeclStmt(statementParser.SymbolicDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToHavocStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToHavocStmt(statementParser.ToHavocStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToHavocStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToHavocStmt(statementParser.ToHavocStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAssumeStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToAssumeStmt(statementParser.ToAssumeStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAssumeStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToAssumeStmt(statementParser.ToAssumeStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAssertStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToAssertStmt(statementParser.ToAssertStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAssertStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToAssertStmt(statementParser.ToAssertStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToVarStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToVarStmt(statementParser.ToVarStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToVarStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToVarStmt(statementParser.ToVarStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterMainReqSpec(statementParser.MainReqSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitMainReqSpec(statementParser.MainReqSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterMainEnsSpec(statementParser.MainEnsSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitMainEnsSpec(statementParser.MainEnsSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link statementParser#assumeStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssume(statementParser.AssumeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link statementParser#assumeStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssume(statementParser.AssumeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link statementParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssert(statementParser.AssertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link statementParser#assertStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssert(statementParser.AssertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link statementParser#varStmt}.
	 * @param ctx the parse tree
	 */
	void enterVar(statementParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link statementParser#varStmt}.
	 * @param ctx the parse tree
	 */
	void exitVar(statementParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link statementParser#havocStmt}.
	 * @param ctx the parse tree
	 */
	void enterHavoc(statementParser.HavocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link statementParser#havocStmt}.
	 * @param ctx the parse tree
	 */
	void exitHavoc(statementParser.HavocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link statementParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDecl(statementParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link statementParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDecl(statementParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link statementParser#symbolicStmt}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicDecls(statementParser.SymbolicDeclsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link statementParser#symbolicStmt}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicDecls(statementParser.SymbolicDeclsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link statementParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicIdDecl(statementParser.SymbolicIdDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link statementParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicIdDecl(statementParser.SymbolicIdDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Include}
	 * labeled alternative in {@link statementParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterInclude(statementParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Include}
	 * labeled alternative in {@link statementParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitInclude(statementParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link statementParser#repeat_struct}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStructure(statementParser.RepeatStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link statementParser#repeat_struct}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStructure(statementParser.RepeatStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Block}
	 * labeled alternative in {@link statementParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(statementParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link statementParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(statementParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 */
	void enterChooseStmt(statementParser.ChooseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 */
	void exitChooseStmt(statementParser.ChooseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 */
	void enterUniformStmt(statementParser.UniformStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 */
	void exitUniformStmt(statementParser.UniformStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link statementParser#while_struct}.
	 * @param ctx the parse tree
	 */
	void enterWhileStructure(statementParser.WhileStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link statementParser#while_struct}.
	 * @param ctx the parse tree
	 */
	void exitWhileStructure(statementParser.WhileStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void enterInvariantAnno(statementParser.InvariantAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void exitInvariantAnno(statementParser.InvariantAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void enterModifiesAnno(statementParser.ModifiesAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void exitModifiesAnno(statementParser.ModifiesAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void enterIdModif(statementParser.IdModifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void exitIdModif(statementParser.IdModifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void enterSizeModif(statementParser.SizeModifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void exitSizeModif(statementParser.SizeModifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link statementParser#loop_assert}.
	 * @param ctx the parse tree
	 */
	void enterLoopAssertAnno(statementParser.LoopAssertAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link statementParser#loop_assert}.
	 * @param ctx the parse tree
	 */
	void exitLoopAssertAnno(statementParser.LoopAssertAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link statementParser#do_while_struct}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStructure(statementParser.DoWhileStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link statementParser#do_while_struct}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStructure(statementParser.DoWhileStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link statementParser#if_struct}.
	 * @param ctx the parse tree
	 */
	void enterIfStructure(statementParser.IfStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link statementParser#if_struct}.
	 * @param ctx the parse tree
	 */
	void exitIfStructure(statementParser.IfStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link statementParser#for_struct}.
	 * @param ctx the parse tree
	 */
	void enterForStructure(statementParser.ForStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link statementParser#for_struct}.
	 * @param ctx the parse tree
	 */
	void exitForStructure(statementParser.ForStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link statementParser#foreach_struct}.
	 * @param ctx the parse tree
	 */
	void enterForEachStructure(statementParser.ForEachStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link statementParser#foreach_struct}.
	 * @param ctx the parse tree
	 */
	void exitForEachStructure(statementParser.ForEachStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link statementParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(statementParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link statementParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(statementParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void enterReqExpression(statementParser.ReqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void exitReqExpression(statementParser.ReqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertReq(statementParser.TypeAssertReqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertReq(statementParser.TypeAssertReqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void enterEnsExpression(statementParser.EnsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void exitEnsExpression(statementParser.EnsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertEns(statementParser.TypeAssertEnsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertEns(statementParser.TypeAssertEnsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link statementParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParamDefinition(statementParser.ParamDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link statementParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParamDefinition(statementParser.ParamDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(statementParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(statementParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivExpr(statementParser.EquivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivExpr(statementParser.EquivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(statementParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(statementParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(statementParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(statementParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFolToExpr(statementParser.FolToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFolToExpr(statementParser.FolToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(statementParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(statementParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterToConditionalExpr(statementParser.ToConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitToConditionalExpr(statementParser.ToConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link statementParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(statementParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link statementParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(statementParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link statementParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(statementParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link statementParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(statementParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link statementParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(statementParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link statementParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(statementParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link statementParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(statementParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link statementParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(statementParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link statementParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(statementParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link statementParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(statementParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link statementParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(statementParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link statementParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(statementParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link statementParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpression(statementParser.SetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link statementParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpression(statementParser.SetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link statementParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(statementParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link statementParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(statementParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link statementParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(statementParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link statementParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(statementParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link statementParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(statementParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link statementParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(statementParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link statementParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(statementParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link statementParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(statementParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link statementParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(statementParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link statementParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(statementParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(statementParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(statementParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(statementParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(statementParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterToPostfixExpression(statementParser.ToPostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitToPostfixExpression(statementParser.ToPostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link statementParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(statementParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link statementParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(statementParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointID(statementParser.FactorPointIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointID(statementParser.FactorPointIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorArray(statementParser.FactorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorArray(statementParser.FactorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterToBaseFactor(statementParser.ToBaseFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitToBaseFactor(statementParser.ToBaseFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointMethod(statementParser.FactorPointMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointMethod(statementParser.FactorPointMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterResultFactor(statementParser.ResultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitResultFactor(statementParser.ResultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterOldFactor(statementParser.OldFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitOldFactor(statementParser.OldFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterRefNameFactor(statementParser.RefNameFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitRefNameFactor(statementParser.RefNameFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterValueFactor(statementParser.ValueFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitValueFactor(statementParser.ValueFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesFactor(statementParser.ParanthesesFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesFactor(statementParser.ParanthesesFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterAnnoFactor(statementParser.AnnoFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitAnnoFactor(statementParser.AnnoFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link statementParser#anno}.
	 * @param ctx the parse tree
	 */
	void enterCountAnno(statementParser.CountAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link statementParser#anno}.
	 * @param ctx the parse tree
	 */
	void exitCountAnno(statementParser.CountAnnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(statementParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(statementParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(statementParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(statementParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(statementParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(statementParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(statementParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(statementParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(statementParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(statementParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterUnknownValue(statementParser.UnknownValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitUnknownValue(statementParser.UnknownValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefFunctionCall(statementParser.RefFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefFunctionCall(statementParser.RefFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefID(statementParser.RefIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefID(statementParser.RefIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterSymID(statementParser.SymIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitSymID(statementParser.SymIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(statementParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(statementParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterListValue(statementParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitListValue(statementParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(statementParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(statementParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureValue(statementParser.StructureValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureValue(statementParser.StructureValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterMappingValue(statementParser.MappingValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitMappingValue(statementParser.MappingValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link statementParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterIntervalDefinition(statementParser.IntervalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link statementParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitIntervalDefinition(statementParser.IntervalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterFilterSpecDefinition(statementParser.FilterSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitFilterSpecDefinition(statementParser.FilterSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpecDefinition(statementParser.SelectSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpecDefinition(statementParser.SelectSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithSpec(statementParser.ArrayWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithSpec(statementParser.ArrayWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithExpressions(statementParser.ArrayWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithExpressions(statementParser.ArrayWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithInterval(statementParser.ArrayWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithInterval(statementParser.ArrayWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(statementParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(statementParser.EmptyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithSpec(statementParser.ListWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithSpec(statementParser.ListWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithExpressions(statementParser.ListWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithExpressions(statementParser.ListWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithInterval(statementParser.ListWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithInterval(statementParser.ListWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureWithComponents(statementParser.StructureWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureWithComponents(statementParser.StructureWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStructure(statementParser.EmptyStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStructure(statementParser.EmptyStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link statementParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponentDefinition(statementParser.ComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link statementParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponentDefinition(statementParser.ComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEmptySet(statementParser.EmptySetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEmptySet(statementParser.EmptySetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithSpec(statementParser.SetWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithSpec(statementParser.SetWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithExpressions(statementParser.SetWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithExpressions(statementParser.SetWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithInterval(statementParser.SetWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithInterval(statementParser.SetWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterEmptyMapping(statementParser.EmptyMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitEmptyMapping(statementParser.EmptyMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMappingWithComponents(statementParser.MappingWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMappingWithComponents(statementParser.MappingWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link statementParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void enterMappingComponentDefinition(statementParser.MappingComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link statementParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void exitMappingComponentDefinition(statementParser.MappingComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterToBuiltinFunction(statementParser.ToBuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitToBuiltinFunction(statementParser.ToBuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDefinedFunctionCall(statementParser.DefinedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDefinedFunctionCall(statementParser.DefinedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link statementParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunction(statementParser.BuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link statementParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunction(statementParser.BuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link statementParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinMethod(statementParser.BuiltinMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link statementParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinMethod(statementParser.BuiltinMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(statementParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(statementParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(statementParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(statementParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(statementParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(statementParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(statementParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(statementParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterListType(statementParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitListType(statementParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(statementParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(statementParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(statementParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(statementParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(statementParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(statementParser.Method_nameContext ctx);
}
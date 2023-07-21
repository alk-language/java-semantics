// Generated from ro.uaic.info.alk.parser/Alk.g4 by ANTLR 4.9.3
package ro.uaic.info.alk.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlkParser}.
 */
public interface AlkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code StartPoint}
	 * labeled alternative in {@link AlkParser#main}.
	 * @param ctx the parse tree
	 */
	void enterStartPoint(AlkParser.StartPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StartPoint}
	 * labeled alternative in {@link AlkParser#main}.
	 * @param ctx the parse tree
	 */
	void exitStartPoint(AlkParser.StartPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Config}
	 * labeled alternative in {@link AlkParser#configuration}.
	 * @param ctx the parse tree
	 */
	void enterConfig(AlkParser.ConfigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Config}
	 * labeled alternative in {@link AlkParser#configuration}.
	 * @param ctx the parse tree
	 */
	void exitConfig(AlkParser.ConfigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link AlkParser#statement_sequence}.
	 * @param ctx the parse tree
	 */
	void enterStatementSeq(AlkParser.StatementSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link AlkParser#statement_sequence}.
	 * @param ctx the parse tree
	 */
	void exitStatementSeq(AlkParser.StatementSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToFunctionDecl(AlkParser.ToFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToFunctionDecl(AlkParser.ToFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToSpecification(AlkParser.ToSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToSpecification(AlkParser.ToSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(AlkParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(AlkParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterChooseStmt(AlkParser.ChooseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitChooseStmt(AlkParser.ChooseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterUniformStmt(AlkParser.UniformStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitUniformStmt(AlkParser.UniformStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Success}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSuccess(AlkParser.SuccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSuccess(AlkParser.SuccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFailure(AlkParser.FailureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFailure(AlkParser.FailureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(AlkParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(AlkParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(AlkParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(AlkParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Block}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock(AlkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock(AlkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterToDirective(AlkParser.ToDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitToDirective(AlkParser.ToDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStructure(AlkParser.RepeatStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStructure(AlkParser.RepeatStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStructure(AlkParser.WhileStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStructure(AlkParser.WhileStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStructure(AlkParser.DoWhileStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStructure(AlkParser.DoWhileStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStructure(AlkParser.IfStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStructure(AlkParser.IfStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStructure(AlkParser.ForStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStructure(AlkParser.ForStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStructure(AlkParser.ForEachStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStructure(AlkParser.ForEachStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(AlkParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(AlkParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicDecls(AlkParser.SymbolicDeclsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicDecls(AlkParser.SymbolicDeclsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterHavoc(AlkParser.HavocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitHavoc(AlkParser.HavocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssume(AlkParser.AssumeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssume(AlkParser.AssumeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssert(AlkParser.AssertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssert(AlkParser.AssertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVar(AlkParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVar(AlkParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterMainReqSpec(AlkParser.MainReqSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitMainReqSpec(AlkParser.MainReqSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterMainEnsSpec(AlkParser.MainEnsSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitMainEnsSpec(AlkParser.MainEnsSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link AlkParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDecl(AlkParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link AlkParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDecl(AlkParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link AlkParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterSymbolicIdDecl(AlkParser.SymbolicIdDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link AlkParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitSymbolicIdDecl(AlkParser.SymbolicIdDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Include}
	 * labeled alternative in {@link AlkParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterInclude(AlkParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Include}
	 * labeled alternative in {@link AlkParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitInclude(AlkParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void enterInvariantAnno(AlkParser.InvariantAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void exitInvariantAnno(AlkParser.InvariantAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void enterModifiesAnno(AlkParser.ModifiesAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 */
	void exitModifiesAnno(AlkParser.ModifiesAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void enterIdModif(AlkParser.IdModifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void exitIdModif(AlkParser.IdModifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void enterSizeModif(AlkParser.SizeModifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 */
	void exitSizeModif(AlkParser.SizeModifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link AlkParser#loop_assert}.
	 * @param ctx the parse tree
	 */
	void enterLoopAssertAnno(AlkParser.LoopAssertAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link AlkParser#loop_assert}.
	 * @param ctx the parse tree
	 */
	void exitLoopAssertAnno(AlkParser.LoopAssertAnnoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionUsesList}
	 * labeled alternative in {@link AlkParser#function_uses_list}.
	 * @param ctx the parse tree
	 */
	void enterFunctionUsesList(AlkParser.FunctionUsesListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionUsesList}
	 * labeled alternative in {@link AlkParser#function_uses_list}.
	 * @param ctx the parse tree
	 */
	void exitFunctionUsesList(AlkParser.FunctionUsesListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionModifiesList}
	 * labeled alternative in {@link AlkParser#function_modifies_list}.
	 * @param ctx the parse tree
	 */
	void enterFunctionModifiesList(AlkParser.FunctionModifiesListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionModifiesList}
	 * labeled alternative in {@link AlkParser#function_modifies_list}.
	 * @param ctx the parse tree
	 */
	void exitFunctionModifiesList(AlkParser.FunctionModifiesListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link AlkParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(AlkParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link AlkParser#function_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(AlkParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void enterReqExpression(AlkParser.ReqExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void exitReqExpression(AlkParser.ReqExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertReq(AlkParser.TypeAssertReqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertReq(AlkParser.TypeAssertReqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void enterEnsExpression(AlkParser.EnsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void exitEnsExpression(AlkParser.EnsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssertEns(AlkParser.TypeAssertEnsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssertEns(AlkParser.TypeAssertEnsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link AlkParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParamDefinition(AlkParser.ParamDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link AlkParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParamDefinition(AlkParser.ParamDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(AlkParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(AlkParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivExpr(AlkParser.EquivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivExpr(AlkParser.EquivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(AlkParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(AlkParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(AlkParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(AlkParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFolToExpr(AlkParser.FolToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFolToExpr(AlkParser.FolToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(AlkParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(AlkParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterToConditionalExpr(AlkParser.ToConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitToConditionalExpr(AlkParser.ToConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(AlkParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(AlkParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(AlkParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(AlkParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(AlkParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(AlkParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(AlkParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(AlkParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(AlkParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(AlkParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(AlkParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(AlkParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpression(AlkParser.SetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpression(AlkParser.SetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(AlkParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(AlkParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(AlkParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(AlkParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(AlkParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(AlkParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(AlkParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(AlkParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(AlkParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(AlkParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(AlkParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(AlkParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(AlkParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(AlkParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterToPostfixExpression(AlkParser.ToPostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitToPostfixExpression(AlkParser.ToPostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(AlkParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(AlkParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointID(AlkParser.FactorPointIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointID(AlkParser.FactorPointIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorArray(AlkParser.FactorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorArray(AlkParser.FactorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterToBaseFactor(AlkParser.ToBaseFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitToBaseFactor(AlkParser.ToBaseFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointMethod(AlkParser.FactorPointMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointMethod(AlkParser.FactorPointMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterResultFactor(AlkParser.ResultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitResultFactor(AlkParser.ResultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterOldFactor(AlkParser.OldFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitOldFactor(AlkParser.OldFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterRefNameFactor(AlkParser.RefNameFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitRefNameFactor(AlkParser.RefNameFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterValueFactor(AlkParser.ValueFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitValueFactor(AlkParser.ValueFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesFactor(AlkParser.ParanthesesFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesFactor(AlkParser.ParanthesesFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterAnnoFactor(AlkParser.AnnoFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitAnnoFactor(AlkParser.AnnoFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkParser#anno}.
	 * @param ctx the parse tree
	 */
	void enterCountAnno(AlkParser.CountAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkParser#anno}.
	 * @param ctx the parse tree
	 */
	void exitCountAnno(AlkParser.CountAnnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(AlkParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(AlkParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(AlkParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(AlkParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(AlkParser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(AlkParser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(AlkParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(AlkParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(AlkParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(AlkParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefFunctionCall(AlkParser.RefFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefFunctionCall(AlkParser.RefFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefID(AlkParser.RefIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefID(AlkParser.RefIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterSymID(AlkParser.SymIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitSymID(AlkParser.SymIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(AlkParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(AlkParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterListValue(AlkParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitListValue(AlkParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterMappingValue(AlkParser.MappingValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitMappingValue(AlkParser.MappingValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(AlkParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(AlkParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureValue(AlkParser.StructureValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureValue(AlkParser.StructureValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterIntervalDefinition(AlkParser.IntervalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitIntervalDefinition(AlkParser.IntervalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterFilterSpecDefinition(AlkParser.FilterSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitFilterSpecDefinition(AlkParser.FilterSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpecDefinition(AlkParser.SelectSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpecDefinition(AlkParser.SelectSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponentDefinition(AlkParser.ComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponentDefinition(AlkParser.ComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void enterMappingComponentDefinition(AlkParser.MappingComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void exitMappingComponentDefinition(AlkParser.MappingComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(AlkParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(AlkParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithExpressions(AlkParser.ArrayWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithExpressions(AlkParser.ArrayWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithInterval(AlkParser.ArrayWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithInterval(AlkParser.ArrayWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithSpec(AlkParser.ArrayWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithSpec(AlkParser.ArrayWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(AlkParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(AlkParser.EmptyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithExpressions(AlkParser.ListWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithExpressions(AlkParser.ListWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithInterval(AlkParser.ListWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithInterval(AlkParser.ListWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithSpec(AlkParser.ListWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithSpec(AlkParser.ListWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterEmptyMapping(AlkParser.EmptyMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitEmptyMapping(AlkParser.EmptyMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMappingWithComponents(AlkParser.MappingWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMappingWithComponents(AlkParser.MappingWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEmptySet(AlkParser.EmptySetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEmptySet(AlkParser.EmptySetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithExpressions(AlkParser.SetWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithExpressions(AlkParser.SetWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithInterval(AlkParser.SetWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithInterval(AlkParser.SetWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithSpec(AlkParser.SetWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithSpec(AlkParser.SetWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStructure(AlkParser.EmptyStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStructure(AlkParser.EmptyStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureWithComponents(AlkParser.StructureWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureWithComponents(AlkParser.StructureWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterToBuiltinFunction(AlkParser.ToBuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitToBuiltinFunction(AlkParser.ToBuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDefinedFunctionCall(AlkParser.DefinedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDefinedFunctionCall(AlkParser.DefinedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunction(AlkParser.BuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunction(AlkParser.BuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinMethod(AlkParser.BuiltinMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinMethod(AlkParser.BuiltinMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(AlkParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(AlkParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(AlkParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(AlkParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(AlkParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(AlkParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(AlkParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(AlkParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(AlkParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(AlkParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterListType(AlkParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitListType(AlkParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MapType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterMapType(AlkParser.MapTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MapType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitMapType(AlkParser.MapTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(AlkParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(AlkParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterStructType(AlkParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitStructType(AlkParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(AlkParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(AlkParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(AlkParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(AlkParser.Method_nameContext ctx);
}
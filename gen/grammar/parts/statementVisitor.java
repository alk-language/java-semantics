// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/java/grammar/parts/AlkStatements.g4 by ANTLR 4.10.1
package grammar.parts;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link statementParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface statementVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link statementParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSeq(statementParser.StatementSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFunctionDecl(statementParser.ToFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToSpecification(statementParser.ToSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(statementParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToChooseStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToChooseStmt(statementParser.ToChooseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccess(statementParser.SuccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailure(statementParser.FailureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(statementParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(statementParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBlock(statementParser.ToBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToDirective(statementParser.ToDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToRepeat}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToRepeat(statementParser.ToRepeatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToWhile(statementParser.ToWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToDoWhile}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToDoWhile(statementParser.ToDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToIf}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToIf(statementParser.ToIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFor}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFor(statementParser.ToForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToForEach}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToForEach(statementParser.ToForEachContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(statementParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicDeclStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicDeclStmt(statementParser.SymbolicDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToHavocStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToHavocStmt(statementParser.ToHavocStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssumeStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssumeStmt(statementParser.ToAssumeStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssertStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssertStmt(statementParser.ToAssertStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToVarStmt}
	 * labeled alternative in {@link statementParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToVarStmt(statementParser.ToVarStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainReqSpec(statementParser.MainReqSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link statementParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainEnsSpec(statementParser.MainEnsSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link statementParser#assumeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssume(statementParser.AssumeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link statementParser#assertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert(statementParser.AssertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link statementParser#varStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(statementParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link statementParser#havocStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavoc(statementParser.HavocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link statementParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(statementParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link statementParser#symbolicStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicDecls(statementParser.SymbolicDeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link statementParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicIdDecl(statementParser.SymbolicIdDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Include}
	 * labeled alternative in {@link statementParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(statementParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link statementParser#repeat_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStructure(statementParser.RepeatStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link statementParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(statementParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseStmt(statementParser.ChooseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link statementParser#choose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniformStmt(statementParser.UniformStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link statementParser#while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStructure(statementParser.WhileStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantAnno(statementParser.InvariantAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link statementParser#while_anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiesAnno(statementParser.ModifiesAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdModif(statementParser.IdModifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link statementParser#modif_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeModif(statementParser.SizeModifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link statementParser#loop_assert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopAssertAnno(statementParser.LoopAssertAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link statementParser#do_while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStructure(statementParser.DoWhileStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link statementParser#if_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStructure(statementParser.IfStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link statementParser#for_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStructure(statementParser.ForStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link statementParser#foreach_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStructure(statementParser.ForEachStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link statementParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(statementParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqExpression(statementParser.ReqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link statementParser#req_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertReq(statementParser.TypeAssertReqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnsExpression(statementParser.EnsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link statementParser#ens_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertEns(statementParser.TypeAssertEnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link statementParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDefinition(statementParser.ParamDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(statementParser.ImpliesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivExpr(statementParser.EquivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallExpr(statementParser.ForallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(statementParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link statementParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolToExpr(statementParser.FolToExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(statementParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link statementParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToConditionalExpr(statementParser.ToConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link statementParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(statementParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link statementParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(statementParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link statementParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(statementParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link statementParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(statementParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link statementParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(statementParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link statementParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(statementParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link statementParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpression(statementParser.SetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link statementParser#bitwise_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(statementParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link statementParser#bitwise_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(statementParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link statementParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(statementParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link statementParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(statementParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link statementParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(statementParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(statementParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(statementParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link statementParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPostfixExpression(statementParser.ToPostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link statementParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(statementParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointID(statementParser.FactorPointIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorArray(statementParser.FactorArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBaseFactor(statementParser.ToBaseFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link statementParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointMethod(statementParser.FactorPointMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultFactor(statementParser.ResultFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldFactor(statementParser.OldFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefNameFactor(statementParser.RefNameFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueFactor(statementParser.ValueFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesFactor(statementParser.ParanthesesFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link statementParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnoFactor(statementParser.AnnoFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link statementParser#anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountAnno(statementParser.CountAnnoContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(statementParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(statementParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(statementParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(statementParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(statementParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link statementParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknownValue(statementParser.UnknownValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefFunctionCall(statementParser.RefFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefID(statementParser.RefIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link statementParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymID(statementParser.SymIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(statementParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(statementParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(statementParser.SetValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureValue(statementParser.StructureValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link statementParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingValue(statementParser.MappingValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link statementParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDefinition(statementParser.IntervalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterSpecDefinition(statementParser.FilterSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link statementParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSpecDefinition(statementParser.SelectSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(statementParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(statementParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link statementParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(statementParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyList(statementParser.EmptyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithSpec(statementParser.ListWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithExpressions(statementParser.ListWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link statementParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithInterval(statementParser.ListWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureWithComponents(statementParser.StructureWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link statementParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStructure(statementParser.EmptyStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link statementParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDefinition(statementParser.ComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySet(statementParser.EmptySetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithSpec(statementParser.SetWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithExpressions(statementParser.SetWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link statementParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithInterval(statementParser.SetWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyMapping(statementParser.EmptyMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link statementParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingWithComponents(statementParser.MappingWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link statementParser#mapping_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingComponentDefinition(statementParser.MappingComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBuiltinFunction(statementParser.ToBuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link statementParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedFunctionCall(statementParser.DefinedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link statementParser#builtin_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunction(statementParser.BuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link statementParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinMethod(statementParser.BuiltinMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(statementParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(statementParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(statementParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(statementParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(statementParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link statementParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(statementParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(statementParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(statementParser.Method_nameContext ctx);
}
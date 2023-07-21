// Generated from ro.uaic.info.alk.parser/Alk.g4 by ANTLR 4.9.3
package ro.uaic.info.alk.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code StartPoint}
	 * labeled alternative in {@link AlkParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartPoint(AlkParser.StartPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Config}
	 * labeled alternative in {@link AlkParser#configuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(AlkParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementSeq}
	 * labeled alternative in {@link AlkParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSeq(AlkParser.StatementSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFunctionDecl}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFunctionDecl(AlkParser.ToFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToSpecification}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToSpecification(AlkParser.ToSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(AlkParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChooseStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseStmt(AlkParser.ChooseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UniformStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniformStmt(AlkParser.UniformStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccess(AlkParser.SuccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailure(AlkParser.FailureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(AlkParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(AlkParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(AlkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToDirective}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToDirective(AlkParser.ToDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RepeatStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStructure(AlkParser.RepeatStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStructure(AlkParser.WhileStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStructure(AlkParser.DoWhileStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStructure(AlkParser.IfStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStructure(AlkParser.ForStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForEachStructure}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStructure(AlkParser.ForEachStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(AlkParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicDecls}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicDecls(AlkParser.SymbolicDeclsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Havoc}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHavoc(AlkParser.HavocContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assume}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssume(AlkParser.AssumeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assert}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert(AlkParser.AssertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link AlkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(AlkParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainReqSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainReqSpec(AlkParser.MainReqSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MainEnsSpec}
	 * labeled alternative in {@link AlkParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainEnsSpec(AlkParser.MainEnsSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Decl}
	 * labeled alternative in {@link AlkParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(AlkParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolicIdDecl}
	 * labeled alternative in {@link AlkParser#symbolicDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolicIdDecl(AlkParser.SymbolicIdDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Include}
	 * labeled alternative in {@link AlkParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(AlkParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InvariantAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantAnno(AlkParser.InvariantAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModifiesAnno}
	 * labeled alternative in {@link AlkParser#while_anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiesAnno(AlkParser.ModifiesAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdModif(AlkParser.IdModifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SizeModif}
	 * labeled alternative in {@link AlkParser#modif_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizeModif(AlkParser.SizeModifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopAssertAnno}
	 * labeled alternative in {@link AlkParser#loop_assert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopAssertAnno(AlkParser.LoopAssertAnnoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionUsesList}
	 * labeled alternative in {@link AlkParser#function_uses_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionUsesList(AlkParser.FunctionUsesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionModifiesList}
	 * labeled alternative in {@link AlkParser#function_modifies_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionModifiesList(AlkParser.FunctionModifiesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link AlkParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(AlkParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReqExpression}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReqExpression(AlkParser.ReqExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAssertReq}
	 * labeled alternative in {@link AlkParser#req_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertReq(AlkParser.TypeAssertReqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnsExpression}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnsExpression(AlkParser.EnsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeAssertEns}
	 * labeled alternative in {@link AlkParser#ens_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertEns(AlkParser.TypeAssertEnsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParamDefinition}
	 * labeled alternative in {@link AlkParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDefinition(AlkParser.ParamDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(AlkParser.ImpliesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivExpr(AlkParser.EquivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallExpr(AlkParser.ForallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(AlkParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolToExpr(AlkParser.FolToExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(AlkParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToConditionalExpr(AlkParser.ToConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(AlkParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(AlkParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(AlkParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(AlkParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(AlkParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(AlkParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpression(AlkParser.SetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkParser#bitwise_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(AlkParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkParser#bitwise_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(AlkParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(AlkParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(AlkParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(AlkParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(AlkParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(AlkParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPostfixExpression(AlkParser.ToPostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(AlkParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointID(AlkParser.FactorPointIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorArray(AlkParser.FactorArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBaseFactor(AlkParser.ToBaseFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointMethod(AlkParser.FactorPointMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultFactor(AlkParser.ResultFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldFactor(AlkParser.OldFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefNameFactor(AlkParser.RefNameFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueFactor(AlkParser.ValueFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesFactor(AlkParser.ParanthesesFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnoFactor(AlkParser.AnnoFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkParser#anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountAnno(AlkParser.CountAnnoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(AlkParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(AlkParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(AlkParser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(AlkParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(AlkParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefFunctionCall(AlkParser.RefFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefID(AlkParser.RefIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymID(AlkParser.SymIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(AlkParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(AlkParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingValue(AlkParser.MappingValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(AlkParser.SetValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureValue(AlkParser.StructureValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDefinition(AlkParser.IntervalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterSpecDefinition(AlkParser.FilterSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSpecDefinition(AlkParser.SelectSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDefinition(AlkParser.ComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkParser#mapping_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingComponentDefinition(AlkParser.MappingComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(AlkParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(AlkParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(AlkParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(AlkParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyList(AlkParser.EmptyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithExpressions(AlkParser.ListWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithInterval(AlkParser.ListWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithSpec(AlkParser.ListWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyMapping(AlkParser.EmptyMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingWithComponents(AlkParser.MappingWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySet(AlkParser.EmptySetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithExpressions(AlkParser.SetWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithInterval}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithInterval(AlkParser.SetWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithSpec}
	 * labeled alternative in {@link AlkParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithSpec(AlkParser.SetWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStructure(AlkParser.EmptyStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureWithComponents(AlkParser.StructureWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBuiltinFunction(AlkParser.ToBuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedFunctionCall(AlkParser.DefinedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkParser#builtin_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunction(AlkParser.BuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinMethod(AlkParser.BuiltinMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(AlkParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(AlkParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(AlkParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(AlkParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(AlkParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(AlkParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MapType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapType(AlkParser.MapTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(AlkParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructType}
	 * labeled alternative in {@link AlkParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(AlkParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(AlkParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(AlkParser.Method_nameContext ctx);
}
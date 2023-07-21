// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkExpressions.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlkExpressionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlkExpressionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(AlkExpressionsParser.ImpliesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivExpr(AlkExpressionsParser.EquivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallExpr(AlkExpressionsParser.ForallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(AlkExpressionsParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolToExpr(AlkExpressionsParser.FolToExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(AlkExpressionsParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToConditionalExpr(AlkExpressionsParser.ToConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(AlkExpressionsParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(AlkExpressionsParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(AlkExpressionsParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkExpressionsParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(AlkExpressionsParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkExpressionsParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(AlkExpressionsParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(AlkExpressionsParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkExpressionsParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpression(AlkExpressionsParser.SetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(AlkExpressionsParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(AlkExpressionsParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkExpressionsParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(AlkExpressionsParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkExpressionsParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(AlkExpressionsParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkExpressionsParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(AlkExpressionsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(AlkExpressionsParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(AlkExpressionsParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPostfixExpression(AlkExpressionsParser.ToPostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(AlkExpressionsParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointID(AlkExpressionsParser.FactorPointIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorArray(AlkExpressionsParser.FactorArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBaseFactor(AlkExpressionsParser.ToBaseFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointMethod(AlkExpressionsParser.FactorPointMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultFactor(AlkExpressionsParser.ResultFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldFactor(AlkExpressionsParser.OldFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefNameFactor(AlkExpressionsParser.RefNameFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueFactor(AlkExpressionsParser.ValueFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesFactor(AlkExpressionsParser.ParanthesesFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnoFactor(AlkExpressionsParser.AnnoFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkExpressionsParser#anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountAnno(AlkExpressionsParser.CountAnnoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkExpressionsParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(AlkExpressionsParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(AlkExpressionsParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(AlkExpressionsParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(AlkExpressionsParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(AlkExpressionsParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknownValue(AlkExpressionsParser.UnknownValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefFunctionCall(AlkExpressionsParser.RefFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefID(AlkExpressionsParser.RefIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymID(AlkExpressionsParser.SymIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(AlkExpressionsParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(AlkExpressionsParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingValue(AlkExpressionsParser.MappingValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(AlkExpressionsParser.SetValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureValue(AlkExpressionsParser.StructureValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDefinition(AlkExpressionsParser.IntervalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterSpecDefinition(AlkExpressionsParser.FilterSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSpecDefinition(AlkExpressionsParser.SelectSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDefinition(AlkExpressionsParser.ComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#mapping_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingComponentDefinition(AlkExpressionsParser.MappingComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(AlkExpressionsParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(AlkExpressionsParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(AlkExpressionsParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(AlkExpressionsParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyList(AlkExpressionsParser.EmptyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithExpressions(AlkExpressionsParser.ListWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithInterval(AlkExpressionsParser.ListWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithSpec(AlkExpressionsParser.ListWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyMapping(AlkExpressionsParser.EmptyMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingWithComponents(AlkExpressionsParser.MappingWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStructure(AlkExpressionsParser.EmptyStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureWithComponents(AlkExpressionsParser.StructureWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySet(AlkExpressionsParser.EmptySetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithExpressions(AlkExpressionsParser.SetWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithInterva(AlkExpressionsParser.SetWithIntervaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithSpecl(AlkExpressionsParser.SetWithSpeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBuiltinFunction(AlkExpressionsParser.ToBuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedFunctionCall(AlkExpressionsParser.DefinedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunction(AlkExpressionsParser.BuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinMethod(AlkExpressionsParser.BuiltinMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(AlkExpressionsParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(AlkExpressionsParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(AlkExpressionsParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(AlkExpressionsParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(AlkExpressionsParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(AlkExpressionsParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkExpressionsParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(AlkExpressionsParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlkExpressionsParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(AlkExpressionsParser.Method_nameContext ctx);
}
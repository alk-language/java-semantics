// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkInit.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link initParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface initVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Config}
	 * labeled alternative in {@link initParser#configuration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(initParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliesExpr(initParser.ImpliesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivExpr(initParser.EquivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallExpr(initParser.ForallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsExpr(initParser.ExistsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFolToExpr(initParser.FolToExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(initParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToConditionalExpr(initParser.ToConditionalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link initParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(initParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link initParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(initParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link initParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(initParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link initParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(initParser.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link initParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(initParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link initParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(initParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link initParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetExpression(initParser.SetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link initParser#bitwise_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(initParser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link initParser#bitwise_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(initParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link initParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(initParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link initParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(initParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link initParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(initParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(initParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(initParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPostfixExpression(initParser.ToPostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link initParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(initParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointID(initParser.FactorPointIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorArray(initParser.FactorArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBaseFactor(initParser.ToBaseFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorPointMethod(initParser.FactorPointMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultFactor(initParser.ResultFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOldFactor(initParser.OldFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefNameFactor(initParser.RefNameFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueFactor(initParser.ValueFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesFactor(initParser.ParanthesesFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnoFactor(initParser.AnnoFactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link initParser#anno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountAnno(initParser.CountAnnoContext ctx);
	/**
	 * Visit a parse tree produced by {@link initParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(initParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(initParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(initParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(initParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(initParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknownValue(initParser.UnknownValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefFunctionCall(initParser.RefFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefID(initParser.RefIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymID(initParser.SymIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(initParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListValue(initParser.ListValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingValue(initParser.MappingValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(initParser.SetValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureValue(initParser.StructureValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link initParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntervalDefinition(initParser.IntervalDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterSpecDefinition(initParser.FilterSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSpecDefinition(initParser.SelectSpecDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link initParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDefinition(initParser.ComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link initParser#mapping_component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingComponentDefinition(initParser.MappingComponentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyArray(initParser.EmptyArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(initParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(initParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(initParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyList(initParser.EmptyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithExpressions(initParser.ListWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithInterval(initParser.ListWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListWithSpec(initParser.ListWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyMapping(initParser.EmptyMappingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMappingWithComponents(initParser.MappingWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStructure(initParser.EmptyStructureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureWithComponents(initParser.StructureWithComponentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySet(initParser.EmptySetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithExpressions(initParser.SetWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithInterva(initParser.SetWithIntervaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetWithSpecl(initParser.SetWithSpeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBuiltinFunction(initParser.ToBuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedFunctionCall(initParser.DefinedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link initParser#builtin_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunction(initParser.BuiltinFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link initParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinMethod(initParser.BuiltinMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(initParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(initParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(initParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(initParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(initParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(initParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link initParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(initParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link initParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(initParser.Method_nameContext ctx);
}
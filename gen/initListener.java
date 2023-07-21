// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkInit.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link initParser}.
 */
public interface initListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Config}
	 * labeled alternative in {@link initParser#configuration}.
	 * @param ctx the parse tree
	 */
	void enterConfig(initParser.ConfigContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Config}
	 * labeled alternative in {@link initParser#configuration}.
	 * @param ctx the parse tree
	 */
	void exitConfig(initParser.ConfigContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(initParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(initParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivExpr(initParser.EquivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivExpr(initParser.EquivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(initParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(initParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(initParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(initParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFolToExpr(initParser.FolToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link initParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFolToExpr(initParser.FolToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(initParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(initParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterToConditionalExpr(initParser.ToConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link initParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitToConditionalExpr(initParser.ToConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link initParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(initParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link initParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(initParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link initParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(initParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link initParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(initParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link initParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(initParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link initParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(initParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link initParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(initParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link initParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(initParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link initParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(initParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link initParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(initParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link initParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(initParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link initParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(initParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link initParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpression(initParser.SetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link initParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpression(initParser.SetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link initParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(initParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link initParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(initParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link initParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(initParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link initParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(initParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link initParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(initParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link initParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(initParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link initParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(initParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link initParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(initParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link initParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(initParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link initParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(initParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(initParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(initParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(initParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(initParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterToPostfixExpression(initParser.ToPostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link initParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitToPostfixExpression(initParser.ToPostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link initParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(initParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link initParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(initParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointID(initParser.FactorPointIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointID(initParser.FactorPointIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorArray(initParser.FactorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorArray(initParser.FactorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterToBaseFactor(initParser.ToBaseFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitToBaseFactor(initParser.ToBaseFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointMethod(initParser.FactorPointMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link initParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointMethod(initParser.FactorPointMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterResultFactor(initParser.ResultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitResultFactor(initParser.ResultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterOldFactor(initParser.OldFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitOldFactor(initParser.OldFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterRefNameFactor(initParser.RefNameFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitRefNameFactor(initParser.RefNameFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterValueFactor(initParser.ValueFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitValueFactor(initParser.ValueFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesFactor(initParser.ParanthesesFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesFactor(initParser.ParanthesesFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterAnnoFactor(initParser.AnnoFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link initParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitAnnoFactor(initParser.AnnoFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link initParser#anno}.
	 * @param ctx the parse tree
	 */
	void enterCountAnno(initParser.CountAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link initParser#anno}.
	 * @param ctx the parse tree
	 */
	void exitCountAnno(initParser.CountAnnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link initParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(initParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link initParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(initParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(initParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(initParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(initParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(initParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(initParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(initParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(initParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(initParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterUnknownValue(initParser.UnknownValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link initParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitUnknownValue(initParser.UnknownValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefFunctionCall(initParser.RefFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefFunctionCall(initParser.RefFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefID(initParser.RefIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefID(initParser.RefIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterSymID(initParser.SymIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link initParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitSymID(initParser.SymIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(initParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(initParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterListValue(initParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitListValue(initParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterMappingValue(initParser.MappingValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitMappingValue(initParser.MappingValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(initParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(initParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureValue(initParser.StructureValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link initParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureValue(initParser.StructureValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link initParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterIntervalDefinition(initParser.IntervalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link initParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitIntervalDefinition(initParser.IntervalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterFilterSpecDefinition(initParser.FilterSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitFilterSpecDefinition(initParser.FilterSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpecDefinition(initParser.SelectSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link initParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpecDefinition(initParser.SelectSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link initParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponentDefinition(initParser.ComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link initParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponentDefinition(initParser.ComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link initParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void enterMappingComponentDefinition(initParser.MappingComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link initParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void exitMappingComponentDefinition(initParser.MappingComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(initParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(initParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithExpressions(initParser.ArrayWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithExpressions(initParser.ArrayWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithInterval(initParser.ArrayWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithInterval(initParser.ArrayWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithSpec(initParser.ArrayWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link initParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithSpec(initParser.ArrayWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(initParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(initParser.EmptyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithExpressions(initParser.ListWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithExpressions(initParser.ListWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithInterval(initParser.ListWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithInterval(initParser.ListWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithSpec(initParser.ListWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link initParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithSpec(initParser.ListWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterEmptyMapping(initParser.EmptyMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitEmptyMapping(initParser.EmptyMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMappingWithComponents(initParser.MappingWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link initParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMappingWithComponents(initParser.MappingWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStructure(initParser.EmptyStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStructure(initParser.EmptyStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureWithComponents(initParser.StructureWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link initParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureWithComponents(initParser.StructureWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEmptySet(initParser.EmptySetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEmptySet(initParser.EmptySetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithExpressions(initParser.SetWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithExpressions(initParser.SetWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithInterva(initParser.SetWithIntervaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithInterva(initParser.SetWithIntervaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithSpecl(initParser.SetWithSpeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link initParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithSpecl(initParser.SetWithSpeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterToBuiltinFunction(initParser.ToBuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitToBuiltinFunction(initParser.ToBuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDefinedFunctionCall(initParser.DefinedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link initParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDefinedFunctionCall(initParser.DefinedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link initParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunction(initParser.BuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link initParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunction(initParser.BuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link initParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinMethod(initParser.BuiltinMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link initParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinMethod(initParser.BuiltinMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(initParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(initParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(initParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(initParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(initParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(initParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(initParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(initParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterListType(initParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitListType(initParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(initParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link initParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(initParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link initParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(initParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link initParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(initParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link initParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(initParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link initParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(initParser.Method_nameContext ctx);
}
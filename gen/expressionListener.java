// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkExpressions.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link expressionParser}.
 */
public interface expressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(expressionParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(expressionParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivExpr(expressionParser.EquivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivExpr(expressionParser.EquivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(expressionParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(expressionParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(expressionParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(expressionParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFolToExpr(expressionParser.FolToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link expressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFolToExpr(expressionParser.FolToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link expressionParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(expressionParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link expressionParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(expressionParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link expressionParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterToConditionalExpr(expressionParser.ToConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link expressionParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitToConditionalExpr(expressionParser.ToConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link expressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(expressionParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link expressionParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(expressionParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link expressionParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(expressionParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link expressionParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(expressionParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link expressionParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(expressionParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link expressionParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(expressionParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link expressionParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(expressionParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link expressionParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(expressionParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link expressionParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(expressionParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link expressionParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(expressionParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link expressionParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(expressionParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link expressionParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(expressionParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link expressionParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpression(expressionParser.SetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link expressionParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpression(expressionParser.SetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link expressionParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(expressionParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link expressionParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(expressionParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link expressionParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(expressionParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link expressionParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(expressionParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link expressionParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(expressionParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link expressionParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(expressionParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link expressionParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(expressionParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link expressionParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(expressionParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link expressionParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(expressionParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link expressionParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(expressionParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(expressionParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(expressionParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(expressionParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(expressionParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterToPostfixExpression(expressionParser.ToPostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link expressionParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitToPostfixExpression(expressionParser.ToPostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link expressionParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(expressionParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link expressionParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(expressionParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointID(expressionParser.FactorPointIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointID(expressionParser.FactorPointIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorArray(expressionParser.FactorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorArray(expressionParser.FactorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterToBaseFactor(expressionParser.ToBaseFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitToBaseFactor(expressionParser.ToBaseFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointMethod(expressionParser.FactorPointMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link expressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointMethod(expressionParser.FactorPointMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterResultFactor(expressionParser.ResultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitResultFactor(expressionParser.ResultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterOldFactor(expressionParser.OldFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitOldFactor(expressionParser.OldFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterRefNameFactor(expressionParser.RefNameFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitRefNameFactor(expressionParser.RefNameFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterValueFactor(expressionParser.ValueFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitValueFactor(expressionParser.ValueFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesFactor(expressionParser.ParanthesesFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesFactor(expressionParser.ParanthesesFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterAnnoFactor(expressionParser.AnnoFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link expressionParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitAnnoFactor(expressionParser.AnnoFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link expressionParser#anno}.
	 * @param ctx the parse tree
	 */
	void enterCountAnno(expressionParser.CountAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link expressionParser#anno}.
	 * @param ctx the parse tree
	 */
	void exitCountAnno(expressionParser.CountAnnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressionParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(expressionParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressionParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(expressionParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(expressionParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(expressionParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(expressionParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(expressionParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(expressionParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(expressionParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(expressionParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(expressionParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterUnknownValue(expressionParser.UnknownValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link expressionParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitUnknownValue(expressionParser.UnknownValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefFunctionCall(expressionParser.RefFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefFunctionCall(expressionParser.RefFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefID(expressionParser.RefIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefID(expressionParser.RefIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterSymID(expressionParser.SymIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link expressionParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitSymID(expressionParser.SymIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(expressionParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(expressionParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterListValue(expressionParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitListValue(expressionParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterMappingValue(expressionParser.MappingValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitMappingValue(expressionParser.MappingValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(expressionParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(expressionParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureValue(expressionParser.StructureValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link expressionParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureValue(expressionParser.StructureValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link expressionParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterIntervalDefinition(expressionParser.IntervalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link expressionParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitIntervalDefinition(expressionParser.IntervalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link expressionParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterFilterSpecDefinition(expressionParser.FilterSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link expressionParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitFilterSpecDefinition(expressionParser.FilterSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link expressionParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpecDefinition(expressionParser.SelectSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link expressionParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpecDefinition(expressionParser.SelectSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link expressionParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponentDefinition(expressionParser.ComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link expressionParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponentDefinition(expressionParser.ComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link expressionParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void enterMappingComponentDefinition(expressionParser.MappingComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link expressionParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void exitMappingComponentDefinition(expressionParser.MappingComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(expressionParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(expressionParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithExpressions(expressionParser.ArrayWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithExpressions(expressionParser.ArrayWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithInterval(expressionParser.ArrayWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithInterval(expressionParser.ArrayWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithSpec(expressionParser.ArrayWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link expressionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithSpec(expressionParser.ArrayWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(expressionParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(expressionParser.EmptyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithExpressions(expressionParser.ListWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithExpressions(expressionParser.ListWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithInterval(expressionParser.ListWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithInterval(expressionParser.ListWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithSpec(expressionParser.ListWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link expressionParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithSpec(expressionParser.ListWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link expressionParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterEmptyMapping(expressionParser.EmptyMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link expressionParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitEmptyMapping(expressionParser.EmptyMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link expressionParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMappingWithComponents(expressionParser.MappingWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link expressionParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMappingWithComponents(expressionParser.MappingWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link expressionParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStructure(expressionParser.EmptyStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link expressionParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStructure(expressionParser.EmptyStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link expressionParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureWithComponents(expressionParser.StructureWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link expressionParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureWithComponents(expressionParser.StructureWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEmptySet(expressionParser.EmptySetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEmptySet(expressionParser.EmptySetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithExpressions(expressionParser.SetWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithExpressions(expressionParser.SetWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithInterva(expressionParser.SetWithIntervaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithInterva(expressionParser.SetWithIntervaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithSpecl(expressionParser.SetWithSpeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link expressionParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithSpecl(expressionParser.SetWithSpeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link expressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterToBuiltinFunction(expressionParser.ToBuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link expressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitToBuiltinFunction(expressionParser.ToBuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link expressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDefinedFunctionCall(expressionParser.DefinedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link expressionParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDefinedFunctionCall(expressionParser.DefinedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link expressionParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunction(expressionParser.BuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link expressionParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunction(expressionParser.BuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link expressionParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinMethod(expressionParser.BuiltinMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link expressionParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinMethod(expressionParser.BuiltinMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(expressionParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(expressionParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(expressionParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(expressionParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(expressionParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(expressionParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(expressionParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(expressionParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterListType(expressionParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitListType(expressionParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(expressionParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link expressionParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(expressionParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressionParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(expressionParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressionParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(expressionParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressionParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(expressionParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressionParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(expressionParser.Method_nameContext ctx);
}
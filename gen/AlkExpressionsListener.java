// Generated from /Users/alexandrulungu/Work/atek/java-semantics/src/main/antlr4/AlkExpressions.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlkExpressionsParser}.
 */
public interface AlkExpressionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpr(AlkExpressionsParser.ImpliesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImpliesExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpr(AlkExpressionsParser.ImpliesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivExpr(AlkExpressionsParser.EquivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivExpr(AlkExpressionsParser.EquivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterForallExpr(AlkExpressionsParser.ForallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForallExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitForallExpr(AlkExpressionsParser.ForallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExistsExpr(AlkExpressionsParser.ExistsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExistsExpr(AlkExpressionsParser.ExistsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFolToExpr(AlkExpressionsParser.FolToExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FolToExpr}
	 * labeled alternative in {@link AlkExpressionsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFolToExpr(AlkExpressionsParser.FolToExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(AlkExpressionsParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignExpression}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(AlkExpressionsParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void enterToConditionalExpr(AlkExpressionsParser.ToConditionalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToConditionalExpr}
	 * labeled alternative in {@link AlkExpressionsParser#assign_expression}.
	 * @param ctx the parse tree
	 */
	void exitToConditionalExpr(AlkExpressionsParser.ToConditionalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(AlkExpressionsParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(AlkExpressionsParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(AlkExpressionsParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(AlkExpressionsParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(AlkExpressionsParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(AlkExpressionsParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkExpressionsParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(AlkExpressionsParser.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link AlkExpressionsParser#in_expression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(AlkExpressionsParser.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkExpressionsParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(AlkExpressionsParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link AlkExpressionsParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(AlkExpressionsParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(AlkExpressionsParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link AlkExpressionsParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(AlkExpressionsParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkExpressionsParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void enterSetExpression(AlkExpressionsParser.SetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetExpression}
	 * labeled alternative in {@link AlkExpressionsParser#set_expression}.
	 * @param ctx the parse tree
	 */
	void exitSetExpression(AlkExpressionsParser.SetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseOrExpression(AlkExpressionsParser.BitwiseOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseOrExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_or}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseOrExpression(AlkExpressionsParser.BitwiseOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(AlkExpressionsParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitwiseAndExpression}
	 * labeled alternative in {@link AlkExpressionsParser#bitwise_and}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(AlkExpressionsParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkExpressionsParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(AlkExpressionsParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShiftExpression}
	 * labeled alternative in {@link AlkExpressionsParser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(AlkExpressionsParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkExpressionsParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(AlkExpressionsParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link AlkExpressionsParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(AlkExpressionsParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkExpressionsParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(AlkExpressionsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link AlkExpressionsParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(AlkExpressionsParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(AlkExpressionsParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrefixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(AlkExpressionsParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(AlkExpressionsParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(AlkExpressionsParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterToPostfixExpression(AlkExpressionsParser.ToPostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitToPostfixExpression(AlkExpressionsParser.ToPostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(AlkExpressionsParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostfixExpression}
	 * labeled alternative in {@link AlkExpressionsParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(AlkExpressionsParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointID(AlkExpressionsParser.FactorPointIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointID}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointID(AlkExpressionsParser.FactorPointIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorArray(AlkExpressionsParser.FactorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorArray}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorArray(AlkExpressionsParser.FactorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterToBaseFactor(AlkExpressionsParser.ToBaseFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBaseFactor}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitToBaseFactor(AlkExpressionsParser.ToBaseFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorPointMethod(AlkExpressionsParser.FactorPointMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FactorPointMethod}
	 * labeled alternative in {@link AlkExpressionsParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorPointMethod(AlkExpressionsParser.FactorPointMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterResultFactor(AlkExpressionsParser.ResultFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ResultFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitResultFactor(AlkExpressionsParser.ResultFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterOldFactor(AlkExpressionsParser.OldFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OldFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitOldFactor(AlkExpressionsParser.OldFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterRefNameFactor(AlkExpressionsParser.RefNameFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefNameFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitRefNameFactor(AlkExpressionsParser.RefNameFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterValueFactor(AlkExpressionsParser.ValueFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitValueFactor(AlkExpressionsParser.ValueFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesFactor(AlkExpressionsParser.ParanthesesFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParanthesesFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesFactor(AlkExpressionsParser.ParanthesesFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void enterAnnoFactor(AlkExpressionsParser.AnnoFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnnoFactor}
	 * labeled alternative in {@link AlkExpressionsParser#base_factor}.
	 * @param ctx the parse tree
	 */
	void exitAnnoFactor(AlkExpressionsParser.AnnoFactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkExpressionsParser#anno}.
	 * @param ctx the parse tree
	 */
	void enterCountAnno(AlkExpressionsParser.CountAnnoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CountAnno}
	 * labeled alternative in {@link AlkExpressionsParser#anno}.
	 * @param ctx the parse tree
	 */
	void exitCountAnno(AlkExpressionsParser.CountAnnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkExpressionsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(AlkExpressionsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkExpressionsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(AlkExpressionsParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(AlkExpressionsParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(AlkExpressionsParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterDoubleValue(AlkExpressionsParser.DoubleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitDoubleValue(AlkExpressionsParser.DoubleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(AlkExpressionsParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(AlkExpressionsParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(AlkExpressionsParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(AlkExpressionsParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void enterUnknownValue(AlkExpressionsParser.UnknownValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnknownValue}
	 * labeled alternative in {@link AlkExpressionsParser#scalar_value}.
	 * @param ctx the parse tree
	 */
	void exitUnknownValue(AlkExpressionsParser.UnknownValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefFunctionCall(AlkExpressionsParser.RefFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefFunctionCall(AlkExpressionsParser.RefFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterRefID(AlkExpressionsParser.RefIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RefID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitRefID(AlkExpressionsParser.RefIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void enterSymID(AlkExpressionsParser.SymIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SymID}
	 * labeled alternative in {@link AlkExpressionsParser#ref_name}.
	 * @param ctx the parse tree
	 */
	void exitSymID(AlkExpressionsParser.SymIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(AlkExpressionsParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(AlkExpressionsParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterListValue(AlkExpressionsParser.ListValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitListValue(AlkExpressionsParser.ListValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterMappingValue(AlkExpressionsParser.MappingValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitMappingValue(AlkExpressionsParser.MappingValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(AlkExpressionsParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(AlkExpressionsParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureValue(AlkExpressionsParser.StructureValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureValue}
	 * labeled alternative in {@link AlkExpressionsParser#data_structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureValue(AlkExpressionsParser.StructureValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterIntervalDefinition(AlkExpressionsParser.IntervalDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntervalDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitIntervalDefinition(AlkExpressionsParser.IntervalDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterFilterSpecDefinition(AlkExpressionsParser.FilterSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitFilterSpecDefinition(AlkExpressionsParser.FilterSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 */
	void enterSelectSpecDefinition(AlkExpressionsParser.SelectSpecDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelectSpecDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#spec}.
	 * @param ctx the parse tree
	 */
	void exitSelectSpecDefinition(AlkExpressionsParser.SelectSpecDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#component}.
	 * @param ctx the parse tree
	 */
	void enterComponentDefinition(AlkExpressionsParser.ComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#component}.
	 * @param ctx the parse tree
	 */
	void exitComponentDefinition(AlkExpressionsParser.ComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void enterMappingComponentDefinition(AlkExpressionsParser.MappingComponentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingComponentDefinition}
	 * labeled alternative in {@link AlkExpressionsParser#mapping_component}.
	 * @param ctx the parse tree
	 */
	void exitMappingComponentDefinition(AlkExpressionsParser.MappingComponentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void enterEmptyArray(AlkExpressionsParser.EmptyArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyArray}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void exitEmptyArray(AlkExpressionsParser.EmptyArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithExpressions(AlkExpressionsParser.ArrayWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithExpressions(AlkExpressionsParser.ArrayWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithInterval(AlkExpressionsParser.ArrayWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithInterval(AlkExpressionsParser.ArrayWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArrayWithSpec(AlkExpressionsParser.ArrayWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArrayWithSpec(AlkExpressionsParser.ArrayWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(AlkExpressionsParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyList}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(AlkExpressionsParser.EmptyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithExpressions(AlkExpressionsParser.ListWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithExpressions(AlkExpressionsParser.ListWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithInterval(AlkExpressionsParser.ListWithIntervalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithInterval}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithInterval(AlkExpressionsParser.ListWithIntervalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListWithSpec(AlkExpressionsParser.ListWithSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListWithSpec}
	 * labeled alternative in {@link AlkExpressionsParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListWithSpec(AlkExpressionsParser.ListWithSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterEmptyMapping(AlkExpressionsParser.EmptyMappingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyMapping}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitEmptyMapping(AlkExpressionsParser.EmptyMappingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 */
	void enterMappingWithComponents(AlkExpressionsParser.MappingWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MappingWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#mapping}.
	 * @param ctx the parse tree
	 */
	void exitMappingWithComponents(AlkExpressionsParser.MappingWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStructure(AlkExpressionsParser.EmptyStructureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStructure}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStructure(AlkExpressionsParser.EmptyStructureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructureWithComponents(AlkExpressionsParser.StructureWithComponentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructureWithComponents}
	 * labeled alternative in {@link AlkExpressionsParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructureWithComponents(AlkExpressionsParser.StructureWithComponentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void enterEmptySet(AlkExpressionsParser.EmptySetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySet}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void exitEmptySet(AlkExpressionsParser.EmptySetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithExpressions(AlkExpressionsParser.SetWithExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithExpressions}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithExpressions(AlkExpressionsParser.SetWithExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithInterva(AlkExpressionsParser.SetWithIntervaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithInterva}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithInterva(AlkExpressionsParser.SetWithIntervaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSetWithSpecl(AlkExpressionsParser.SetWithSpeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetWithSpecl}
	 * labeled alternative in {@link AlkExpressionsParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSetWithSpecl(AlkExpressionsParser.SetWithSpeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterToBuiltinFunction(AlkExpressionsParser.ToBuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToBuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitToBuiltinFunction(AlkExpressionsParser.ToBuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterDefinedFunctionCall(AlkExpressionsParser.DefinedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinedFunctionCall}
	 * labeled alternative in {@link AlkExpressionsParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitDefinedFunctionCall(AlkExpressionsParser.DefinedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinFunction(AlkExpressionsParser.BuiltinFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinFunction}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_function}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinFunction(AlkExpressionsParser.BuiltinFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinMethod(AlkExpressionsParser.BuiltinMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BuiltinMethod}
	 * labeled alternative in {@link AlkExpressionsParser#builtin_method}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinMethod(AlkExpressionsParser.BuiltinMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(AlkExpressionsParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(AlkExpressionsParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(AlkExpressionsParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(AlkExpressionsParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterFloatType(AlkExpressionsParser.FloatTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitFloatType(AlkExpressionsParser.FloatTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(AlkExpressionsParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(AlkExpressionsParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterListType(AlkExpressionsParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitListType(AlkExpressionsParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(AlkExpressionsParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link AlkExpressionsParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(AlkExpressionsParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkExpressionsParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(AlkExpressionsParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkExpressionsParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(AlkExpressionsParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlkExpressionsParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(AlkExpressionsParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlkExpressionsParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(AlkExpressionsParser.Method_nameContext ctx);
}
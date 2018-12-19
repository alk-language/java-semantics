// Generated from /home/alex/work/Alk/test/grammar/parts/alg.g4 by ANTLR 4.7.1

    package grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link algParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface algVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link algParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(algParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToInstruction}
	 * labeled alternative in {@link algParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToInstruction(algParser.ToInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionSeq}
	 * labeled alternative in {@link algParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionSeq(algParser.InstructionSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToF}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToF(algParser.ToFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFun}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFun(algParser.ToFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TOFD}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTOFD(algParser.TOFDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(algParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChooseStm}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseStm(algParser.ChooseStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccess(algParser.SuccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailure(algParser.FailureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssign}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssign(algParser.ToAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(algParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBlock(algParser.ToBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToWhile(algParser.ToWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhile}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(algParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToIf}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToIf(algParser.ToIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(algParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAll}
	 * labeled alternative in {@link algParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAll(algParser.ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link algParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(algParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#choose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoose(algParser.ChooseContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#increase_decrease}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrease_decrease(algParser.Increase_decreaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(algParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link algParser#while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(algParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#do_while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_while_struct(algParser.Do_while_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#if_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_struct(algParser.If_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#for_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_struct(algParser.For_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#forall_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForall_struct(algParser.Forall_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_decl(algParser.Function_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(algParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_expression(algParser.Set_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#set_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_atom(algParser.Set_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(algParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_expression(algParser.Logical_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_expression(algParser.Logical_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_expression(algParser.In_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(algParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(algParser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#bitwise_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_or(algParser.Bitwise_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#bitwise_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_and(algParser.Bitwise_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(algParser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link algParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(algParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(algParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(algParser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(algParser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(algParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(algParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link algParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(algParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link algParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(algParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link algParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(algParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link algParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(algParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRef_name(algParser.Ref_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#ref_name_chunk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRef_name_chunk(algParser.Ref_name_chunkContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_structure(algParser.Data_structureContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval(algParser.IntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(algParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link algParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(algParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link algParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(algParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link algParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(algParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(algParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(algParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(algParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(algParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(algParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_method(algParser.Builtin_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link algParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(algParser.Method_nameContext ctx);
}
// Generated from /home/alex/work/Alk/script/../src/grammar/parts/alk.g4 by ANTLR 4.7.1

    package grammar;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link alkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface alkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link alkParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(alkParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToInstruction}
	 * labeled alternative in {@link alkParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToInstruction(alkParser.ToInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstructionSeq}
	 * labeled alternative in {@link alkParser#statement_sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionSeq(alkParser.InstructionSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToF}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToF(alkParser.ToFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFun}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFun(alkParser.ToFunContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TOFD}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTOFD(alkParser.TOFDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(alkParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ChooseStm}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseStm(alkParser.ChooseStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Success}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccess(alkParser.SuccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Failure}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFailure(alkParser.FailureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssign}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssign(alkParser.ToAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(alkParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBlock(alkParser.ToBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToWhile(alkParser.ToWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhile}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(alkParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToIf}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToIf(alkParser.ToIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code For}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(alkParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAll}
	 * labeled alternative in {@link alkParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAll(alkParser.ForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link alkParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(alkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#choose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoose(alkParser.ChooseContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#increase_decrease}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrease_decrease(alkParser.Increase_decreaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(alkParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link alkParser#while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(alkParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#do_while_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDo_while_struct(alkParser.Do_while_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#if_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_struct(alkParser.If_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#for_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_struct(alkParser.For_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#forall_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForall_struct(alkParser.Forall_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_decl(alkParser.Function_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(alkParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#set_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_expression(alkParser.Set_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#set_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_atom(alkParser.Set_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(alkParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_expression(alkParser.Logical_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_expression(alkParser.Logical_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#in_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_expression(alkParser.In_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(alkParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(alkParser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(alkParser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link alkParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(alkParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(alkParser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(alkParser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(alkParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(alkParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link alkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(alkParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleValue}
	 * labeled alternative in {@link alkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleValue(alkParser.DoubleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolValue}
	 * labeled alternative in {@link alkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(alkParser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link alkParser#scalar_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(alkParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#ref_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRef_name(alkParser.Ref_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#ref_name_chunk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRef_name_chunk(alkParser.Ref_name_chunkContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#data_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_structure(alkParser.Data_structureContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#interval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterval(alkParser.IntervalContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpec(alkParser.SpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithExpressions}
	 * labeled alternative in {@link alkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithInterval}
	 * labeled alternative in {@link alkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayWithSpec}
	 * labeled alternative in {@link alkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(alkParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(alkParser.StructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#component}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponent(alkParser.ComponentContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(alkParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(alkParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#builtin_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin_method(alkParser.Builtin_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link alkParser#method_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_name(alkParser.Method_nameContext ctx);
}
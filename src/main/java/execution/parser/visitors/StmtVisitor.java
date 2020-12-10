package execution.parser.visitors;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import ast.StateFactory;
import execution.state.function.FunctionCallState;
import execution.state.function.FunctionDeclState;
import execution.state.function.ParamDefinitionState;
import execution.state.function.ReturnState;
import execution.state.main.StatementSeqState;
import execution.state.statement.*;
import grammar.*;
import execution.parser.env.Environment;
import execution.types.AlkValue;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;

/**
 * This class is responsible for the visiting of the statements.
 * TODO: generify visitor
 */
public class StmtVisitor extends alkBaseVisitor {

    /**
     * The environment over which this visitor will work.
     */
    private Environment env;

    private ExecutionPayload executionPayload;

    /**
     * Creates a new statement visitor with a specified environment and a flag for deciding the inFunction variable.
     * @param env The environment over which the statements will be executed
     * @param inFunction The inFunction flag
     */
    public StmtVisitor(Environment env, boolean inFunction)
    {
        this.env=env;
    }

    // TODO: in function to be added
    public StmtVisitor(Environment env, ExecutionPayload executionPayload)
    {
        this.env=env;
        this.executionPayload = executionPayload;
    }


    /**
     * Handles the context reffering to a declaration of a new function. It takes in account the inFunction flag to
     * determine if this kind of statement is legal here. It parses the statement to compute the in/out/modifies params
     * and also the statement block (the context/node in the visitor tree) and finally adds the new generated
     * AlkFunction in the static collection of all AlkFunctions. In case there is another function with another name,
     * an AlkExeption will be thrown.
     * @param ctx A Function Declaration node in the execution tree meant to be parsed.
     */
    @Override public Object visitFunctionDecl(alkParser.FunctionDeclContext ctx) {
        return StateFactory.create(FunctionDeclState.class, ctx, executionPayload, env);
    }




    /**
     * Handles the context reffering to a declaration of a new function. It takes in account the inFunction flag to
     * determine if this kind of statement is legal here. It parses the statement to compute the in/out/modifies params
     * and also the statement block (the context/node in the visitor tree) and finally adds the new generated
     * AlkFunction in the static collection of all AlkFunctions. In case there is another function with another name,
     * an AlkExeption will be thrown.
     * @param ctx A Function Declaration node in the execution tree meant to be parsed.
     */
    @Override
    public Object visitBlock(alkParser.BlockContext ctx)
    {
        return StateFactory.create(BlockState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a function call context. The implementation is assigned to a FunctionCallVisitor.
     * @param ctx A Function Call node in the execution tree meant to be parsed.
     */
    @Override public Object visitFunctionCall(alkParser.FunctionCallContext ctx) {
        return StateFactory.create(FunctionCallState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a parameter definition context. It extracts the name and the type(in/out) of the parameter.
     * @param ctx A Parameter Definition node in the execution tree meant to be parsed.
     * @return A pair containing the name of the parameter and a flag used to determine if it is about an output parameter.
     */
    @Override public Object visitParamDefinition(alkParser.ParamDefinitionContext ctx) {
        return StateFactory.create(ParamDefinitionState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a returning statement. It checks if the visitor is inside a function, so the
     * returning statement can be used, otherwise an AlkException is thrown. After this, it makes use of an
     * ExpressionVisitor to compute the value to be returned and sets the returnValue to this value. In case
     * there is no expression, a AlkNotAValue will be returned. From this point until the end of the statement visitor,
     * no other statement will be executed.
     * @param ctx A Return Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitReturnStmt(alkParser.ReturnStmtContext ctx) {
        return StateFactory.create(ReturnState.class, ctx, executionPayload, env);
    }


    @Override
    public ExecutionState visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        return StateFactory.create(StatementSeqState.class, ctx, executionPayload, env);
    }

    @Override public ExecutionState visitToAssignmentStmt(alkParser.ToAssignmentStmtContext ctx)
    {
        return StateFactory.create(ToAssignmentStmtState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of an assignment statement. The right side of the assignment will be evaluated with an
     * ExpressionVisitor. In case the operator used is an equal, an AssignedVisitor will be used to visit the left
     * side of the assignment and assign the value obtained at the location determined. Otherwise, meaning in case
     * of a compound assignment operator, the left side will be also evaluated. The values from the left and right side
     * will be part of an expression defined by the compound operator, and the overall value will be given to an
     * AssignedVisitor in order to put value obtained in the location needed.
     * @param ctx An Assignment Statement node in the execution tree meant to be parsed.
     */
    @Override public ExecutionState visitAssignmentStmt(alkParser.AssignmentStmtContext ctx)
    {
        return StateFactory.create(AssignmentStmtState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Method Call. Firstly, the the reference name will be parsed by a ReferenceVisitor,
     * and afterwards the same ReferenceVisitor will continue the parsing of the builtin method.
     * @param ctx A Method Call node in the execution tree meant to be parsed.
     */
    @Override public Object visitMethodCall(alkParser.MethodCallContext ctx) {
        return StateFactory.create(MethodCallState.class, ctx, executionPayload, env);
    }

    @Override public Object visitToRepeat(alkParser.ToRepeatContext ctx) {
        return StateFactory.create(ToRepeatState.class, ctx, executionPayload, env);
    }

    @Override public Object visitToForEach(alkParser.ToForEachContext ctx) {
        return StateFactory.create(ToForAllState.class, ctx, executionPayload, env);
    }

    /**
     * Handles the visiting of a Repeat Structure. Making use of an ExpressionVisitor, after each iteration we check if
     * the expression after the while keyword is still true. If it does, the statement inside will be visited, otherwise
     * the loop ends. After each iteration, it is check if the returnValue is set, so that the loop execution might
     * be interrupted.
     * @param ctx A Repeat Structure node in the execution tree meant to be parsed.
     */
    @Override public Object visitRepeatStructure(alkParser.RepeatStructureContext ctx) {
        return StateFactory.create(RepeatUntilState.class, ctx, executionPayload, env);
    }

    @Override public Object visitToDoWhile(alkParser.ToDoWhileContext ctx) {
        return StateFactory.create(ToDoWhileState.class, ctx, executionPayload, env);
    }

    /**
     * The same semantic as the repeat until structure.
     * @param ctx A Do While Structure node in the execution tree meant to be parsed.
     */
    @Override public Object visitDoWhileStructure(alkParser.DoWhileStructureContext ctx) {
        return StateFactory.create(DoWhileState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a While Structure. Using an ExpressionVisitor, we first check the validity of the
     * expression after the while keyword. If it is false the loop doesn't even start, otherwise the statement inside
     * will be executed until the verification will fail. Note that after each iteration, it is checked if the
     * returnValue is set. If it is the execution of the loop will be instantly terminated.
     * @param ctx A While Structure node in the execution tree meant to be parsed.
     */
    @Override public Object visitWhileStructure(alkParser.WhileStructureContext ctx) {
        return StateFactory.create(WhileState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of the If Structure. Making use of the ExpressionVisitor, it is checked if
     * the condition provided is true or false. Depending on the result, the corresponding statement will be executed.
     * In case there is no else keyword, and the condition returns false, the execution continues normally
     * @param ctx
     * @return An If Structure node in the execution tree meant to be parsed.
     */
    @Override public Object visitIfStructure(alkParser.IfStructureContext ctx) {
        return StateFactory.create(IfStmtState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Success Statement. At this point the program will instantly terminate, by throwing
     * an AlkException with a message representative for this kind of termination.
     * @param ctx A Success node in the execution tree meant to be parsed.
     */
    @Override public Object visitSuccess(alkParser.SuccessContext ctx) {
        return StateFactory.create(SuccessState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Failure Statement. At this point the program will instantly terminate, by throwing
     * an AlkException with a message representative for this kind of termination.
     * @param ctx A Failure node in the execution tree meant to be parsed.
     */
    @Override public Object visitFailure(alkParser.FailureContext ctx) {
        return StateFactory.create(FailureState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a For Structure. The Assignment Statement will be used several times inside the for header.
     * Also an ExpressionVisitor is used to check each time the condition. If after an iteration, the statement to be
     * executed in the for body sets the returnValue, than the loop is terminated, and the execution continues.
     * @param ctx A For Strcuture node in the execution tree meant to be parsed.
     */
    @Override public Object visitForStructure(alkParser.ForStructureContext ctx) {
        return StateFactory.create(ForState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a ForAll Structure. Firstly, a verification is made in order to ensure that the
     * second parameter inside the header is an Iterable Structure. If it is so, for each value inside the structure,
     * the statement inside will be executed. If after an iteration the returnValue is set, the execution terminates instantly.
     * @param ctx A ForAll Strcuture node in the execution tree meant to be parsed.
     */
    @Override public Object visitForEachStructure(alkParser.ForEachStructureContext ctx) {
        return StateFactory.create(ForEachState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Plus Plus Statement. This kind of statement is meant to increase one's value. Thus
     * A ReferenceVisitor is needed in order to obtain the value referenced and increase it by one. In case the
     * reference is invalid, an AlkException will be thrown.
     * @param ctx A PlusPlus Statement node in the execution tree meant to be parsed.
     */
    @Override
    public Object visitPlusPlusStmt(alkParser.PlusPlusStmtContext ctx) {
        return StateFactory.create(PlusPlusStmtState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Minus Minus Statement. This kind of statement is meant to decrease one's value. Thus
     * A ReferenceVisitor is needed in order to obtain the value referenced and decrease it by one. In case the
     * reference is invalid, an AlkException will be thrown.
     * @param ctx A MinusMinus Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitMinusMinusStmt(alkParser.MinusMinusStmtContext ctx) {
        return StateFactory.create(MinusMinusStmtState.class, ctx, executionPayload, env);
    }

    @Override
    public ExecutionState visitToChooseStmt(alkParser.ToChooseStmtContext ctx)
    {
        return StateFactory.create(ToChooseStmtState.class, ctx, executionPayload, env);
    }

    /**
     * Handles the visiting of a Choose Statement. At first some checks are done as: if the second parameter is an
     * iterable structure. In case it isn't an AlkException is thrown. Another check is related to size of the structure.
     * If it is an empty structure, an AlkException will be thrown. Finally, depending on the presence of the SOTHAT,
     * the execution follows. In case there is no SOTHAT, the NonDeterministic Helper will choose a value from the
     * iterable structure, one which will be inserted in the environment in the end. If there is a SOTHAT, the
     * NonDeterministic helper will also be used in order to choose a value in the ireable structure which fits the
     * condition provided. In case there is no such number, an AlkException will be thrown. If the chooseST will succeed,
     * the value obtained will be inserted in the environment.
     * @param ctx A Choose Statement node in the execution tree meant to be parsed.
     */
    @Override
    public ExecutionState visitChooseStmt(alkParser.ChooseStmtContext ctx)
    {
        return StateFactory.create(ChooseStmtState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Uniform Statement. The implementation is similar to the one of a choose statement, in
     * which we are not required to check for the SOTHAT condition.
     * @param ctx An Uniform Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitUniformStmt(alkParser.UniformStmtContext ctx)
    {
        alkParser.ChooseStmtContext cctx = new alkParser.ChooseStmtContext(ctx);
        for (int i=0; i<ctx.getChildCount(); i++)
            cctx.addAnyChild(ctx.getChild(i));
        return StateFactory.create(ChooseStmtState.class, cctx, executionPayload, env);
    }

    @Override public Object visitToIncreaseDecrease(alkParser.ToIncreaseDecreaseContext ctx) {
        return StateFactory.create(ToIncreaseDecreaseState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Statement PlusPlus. Similar to the PlusPlus Statement.
     * @param ctx An Statement PlusPlus node in the execution tree meant to be parsed.
     */
    @Override
    public Object visitStmtPlusPlus(alkParser.StmtPlusPlusContext ctx) {
        return StateFactory.create(StmtPlusPlusState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a Statement MinusMinus. Similar to the MinusMinus Statement.
     * @param ctx An Statement MinusMinus node in the execution tree meant to be parsed.
     */
    @Override public Object visitStmtMinusMinus(alkParser.StmtMinusMinusContext ctx) {
        return StateFactory.create(StmtMinusMinusState.class, ctx, executionPayload, env);
    }


    /**
     * Handles the visiting of a MinusMinusMod Statement. This will only work on iterators and its main goal is to ensure
     * that the iterators won't point towards unwanted values, by redirecting them to the other end. In other words, the
     * iteration with such operator will be circular relatively to the structure iterated.
     * @param ctx An MinusMinusMod Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitMinusMinusModStmt(alkParser.MinusMinusModStmtContext ctx) {
        //return StateFactory.create(MinusMinusStmtState.class, ctx, payload, env);
        return null;
    }


    /**
     * Handles the visiting of a PlusPlusMod Statement. This will only work on iterators and its main goal is to ensure
     * that the iterators won't point towards unwanted values, by redirecting them to the other end. In other words, the
     * iteration with such operator will be circular relatively to the structure iterated.
     * @param ctx An PlusPlusMod Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitPlusPlusModStmt(alkParser.PlusPlusModStmtContext ctx) {
        return null;
    }

    /**
     * Handles the visiting of a ContinueStmt Statement. This will set a continueFlag which will be parsed by the next
     * loop statement executed. This will work only if the execution is in a loop.
     * @param ctx An ContinueStmt Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitContinueStmt(alkParser.ContinueStmtContext ctx) {
        return StateFactory.create(ContinueState.class, ctx, executionPayload, env);
    }

    /**
     * Handles the visiting of a ContinueStmt Statement. This will set a continueFlag which will be parsed by the next
     * loop statement executed. This will work only if the execution is in a loop.
     * @param ctx An ContinueStmt Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitBreakStmt(alkParser.BreakStmtContext ctx) {
        return StateFactory.create(BreakState.class, ctx, executionPayload, env);
    }

    @Override public Object visitToDirective(alkParser.ToDirectiveContext ctx) {
        return new PrimitiveState(ctx.directive(), executionPayload, null) {
            @Override
            public ExecutionState clone(SplitMapper sm) {
                throw new InternalException("Can't clone ToDirective state.");
            }
        };
    }

    public Environment getEnvironment() {
        return env;
    }
}
package execution.interpreter;

import ast.AST;
import execution.ExecutionPayload;
import execution.state.ExecutionState;
import execution.state.function.FunctionDeclState;
import execution.state.function.ReturnState;
import execution.state.statement.StatementSeqState;
import execution.state.statement.*;
import visitor.stateful.StatefulStmtInterpreter;

public class BaseStatefulStmtInterpreter
implements StatefulStmtInterpreter<ExecutionPayload, ExecutionState>
{

    @Override
    public ExecutionState interpretBlock(AST ast, ExecutionPayload payload)
    {
        return new BlockState(ast, payload);
    }

    @Override
    public ExecutionState interpretBreak(AST ast, ExecutionPayload payload)
    {
        return new BreakState(ast, payload);
    }

    @Override
    public ExecutionState interpretChoose(AST ast, ExecutionPayload payload)
    {
        return new ChooseStmtState(ast, payload, false);
    }

    @Override
    public ExecutionState interpretContinue(AST ast, ExecutionPayload payload)
    {
        return new ContinueState(ast, payload);
    }

    @Override
    public ExecutionState interpretDoWhile(AST ast, ExecutionPayload payload)
    {
        return new DoWhileState(ast, payload);
    }

    @Override
    public ExecutionState interpretExprStmt(AST ast, ExecutionPayload payload)
    {
        return new ExprStmtState(ast, payload);
    }

    @Override
    public ExecutionState interpretFailure(AST ast, ExecutionPayload payload)
    {
        return new FailureState(ast, payload);
    }

    @Override
    public ExecutionState interpretFor(AST ast, ExecutionPayload payload)
    {
        return new ForState(ast, payload);
    }

    @Override
    public ExecutionState interpretForEach(AST ast, ExecutionPayload payload)
    {
        return new ForEachState(ast, payload);
    }

    @Override
    public ExecutionState interpretFunctionDecl(AST ast, ExecutionPayload payload)
    {
        return new FunctionDeclState(ast, payload);
    }

    @Override
    public ExecutionState interpretIfThen(AST ast, ExecutionPayload payload)
    {
        return new IfStmtState(ast, payload);
    }

    @Override
    public ExecutionState interpretRepeatUntil(AST ast, ExecutionPayload payload)
    {
        return new RepeatUntilState(ast, payload);
    }

    @Override
    public ExecutionState interpretReturn(AST ast, ExecutionPayload payload)
    {
        return new ReturnState(ast, payload);
    }

    @Override
    public ExecutionState interpretStmtSeq(AST ast, ExecutionPayload payload)
    {
        return new StatementSeqState(ast, payload);
    }

    @Override
    public ExecutionState interpretSuccess(AST ast, ExecutionPayload payload)
    {
        return new SuccessState(ast, payload);
    }

    @Override
    public ExecutionState interpretUniform(AST ast, ExecutionPayload payload)
    {
        return new ChooseStmtState(ast, payload, true);
    }

    @Override
    public ExecutionState interpretWhile(AST ast, ExecutionPayload payload)
    {
        return new WhileState(ast, payload);
    }
}

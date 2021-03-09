package execution.interpreter;

import ast.AST;
import execution.ExecutionPayload;
import execution.parser.exceptions.NotImplementedException;
import execution.state.ExecutionState;
import execution.state.symbolic.SymIfStmtState;
import visitor.stateful.StatefulStmtInterpreter;

public class SymbolicStatefulStmtInterpreter
implements StatefulStmtInterpreter<ExecutionPayload, ExecutionState>
{
    private final StatefulStmtInterpreter<ExecutionPayload, ExecutionState> baseDelegate = new BaseStatefulStmtInterpreter();

    @Override
    public ExecutionState interpretBlock(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretBlock(ast, payload);
    }

    @Override
    public ExecutionState interpretBreak(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretChoose(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretContinue(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretDoWhile(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretExprStmt(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretExprStmt(ast, payload);
    }

    @Override
    public ExecutionState interpretFailure(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretFailure(ast, payload);
    }

    @Override
    public ExecutionState interpretFor(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretForEach(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretFunctionDecl(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretFunctionDecl(ast, payload);
    }

    @Override
    public ExecutionState interpretIfThen(AST ast, ExecutionPayload payload)
    {
        return new SymIfStmtState(ast, payload);
    }

    @Override
    public ExecutionState interpretRepeatUntil(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretReturn(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretStmtSeq(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretStmtSeq(ast, payload);
    }

    @Override
    public ExecutionState interpretSuccess(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretSuccess(ast, payload);
    }

    @Override
    public ExecutionState interpretUniform(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }

    @Override
    public ExecutionState interpretWhile(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretReturn(ast, payload);
    }
}

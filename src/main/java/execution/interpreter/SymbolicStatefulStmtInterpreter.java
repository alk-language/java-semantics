package execution.interpreter;

import ast.AST;
import ast.stmt.FunctionDeclAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.NotImplementedException;
import execution.state.ExecutionState;
import execution.state.symbolic.*;
import visitor.stateful.StatefulStmtInterpreter;

public class SymbolicStatefulStmtInterpreter
implements StatefulStmtInterpreter<ExecutionPayload, ExecutionState>
{
    private final StatefulStmtInterpreter<ExecutionPayload, ExecutionState> baseDelegate
            = new BaseStatefulStmtInterpreter();

    @Override
    public ExecutionState interpretAssume(AST ast, ExecutionPayload payload)
    {
        return new SymbolicAssumeState(ast, payload);
    }

    @Override
    public ExecutionState interpretAssert(AST ast, ExecutionPayload payload)
    {
        return new SymbolicAssertState(ast, payload);
    }

    @Override
    public ExecutionState interpretBlock(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretBlock(ast, payload);
    }

    @Override
    public ExecutionState interpretBreak(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretBreak(ast, payload);
    }

    @Override
    public ExecutionState interpretChoose(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretChoose(ast, payload);
    }

    @Override
    public ExecutionState interpretContinue(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretContinue(ast, payload);
    }

    @Override
    public ExecutionState interpretDoWhile(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretDoWhile(ast, payload); // TODO: do symbolic
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
        return new SymbolicForState(ast, payload);
    }

    @Override
    public ExecutionState interpretForEach(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretForEach(ast, payload); // TODO: do symbolic
    }

    @Override
    public ExecutionState interpretFunctionDecl(AST ast, ExecutionPayload payload)
    {
        if (ast instanceof FunctionDeclAST && ((FunctionDeclAST) ast).getEnsures().isEmpty())
        {
            return baseDelegate.interpretFunctionDecl(ast, payload);
        }

        return new ExecutionState(ast, payload)
        {
            @Override
            public ExecutionState makeStep()
            {
                return null;
            }

            @Override
            public ExecutionState clone(SplitMapper sm)
            {
                return null;
            }

            @Override
            public void assign(ExecutionResult result)
            {

            }
        };
        //return baseDelegate.interpretFunctionDecl(ast, payload);
    }

    @Override
    public ExecutionState interpretIfThen(AST ast, ExecutionPayload payload)
    {
        return new SymIfStmtState(ast, payload);
    }

    @Override
    public ExecutionState interpretHavoc(AST ast, ExecutionPayload payload)
    {
        return new SymHavocState(ast, payload);
    }

    @Override
    public ExecutionState interpretRepeatUntil(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretRepeatUntil(ast, payload); // TODO: do symbolic
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
    public ExecutionState interpretSymbolicDecls(AST ast, ExecutionPayload payload)
    {
        return new SymbolicDeclsState(ast, payload);
    }

    @Override
    public ExecutionState interpretSymbolicIdDecl(AST ast, ExecutionPayload payload)
    {
        return new SymbolicIdDeclState(ast, payload);
    }

    @Override
    public ExecutionState interpretUniform(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretUniform(ast, payload);
    }

    @Override
    public ExecutionState interpretWhile(AST ast, ExecutionPayload payload)
    {
        return new SymbolicWhileState(ast, payload);
    }
}

package ro.uaic.info.alk.execution.interpreter;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.function.FunctionDeclState;
import ro.uaic.info.alk.execution.state.function.ReturnState;
import ro.uaic.info.alk.execution.state.statement.StatementSeqState;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.statement.*;
import ro.uaic.info.alk.visitor.stateful.ExecutionStmtInterpreter;

public class BaseStatefulStmtInterpreter
implements ExecutionStmtInterpreter
{
    @Override
    public ExecutionState interpretAssume(AST ast, ExecutionPayload payload)
    {
        return new AssumeState(ast, payload);
    }

    @Override
    public ExecutionState interpretAssert(AST ast, ExecutionPayload payload)
    {
        return new AssertState(ast, payload);
    }

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
    public ExecutionState interpretHavoc(AST ast, ExecutionPayload payload)
    {
        throw new AlkException("Can't interpret havoc statement in concrete execution!");
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
    public ExecutionState interpretSkip(AST ast, ExecutionPayload payload)
    {
        return new ExecutionState(ast, payload)
        {
            @Override
            public ExecutionState makeStep()
            {
                return null;
            }

            @Override
            public void assign(ExecutionResult result)
            {

            }

            @Override
            public ExecutionState clone(SplitMapper sm)
            {
                return null;
            }
        };
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
    public ExecutionState interpretSymbolicDecls(AST ast, ExecutionPayload payload)
    {
        throw new AlkException("Can't interpret symbolic value declaration in concrete execution!");
    }

    @Override
    public ExecutionState interpretSymbolicIdDecl(AST ast, ExecutionPayload payload)
    {
        throw new AlkException("Can't interpret symbolic value declaration in concrete execution!");
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

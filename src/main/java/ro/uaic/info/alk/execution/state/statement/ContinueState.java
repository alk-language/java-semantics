package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.exeptions.ContinueException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

public class ContinueState
   extends ExecutionState
{
    public ContinueState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new ContinueException("Can't continue while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ContinueState copy = new ContinueState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package execution.state.statement;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.parser.exceptions.ContinueException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

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

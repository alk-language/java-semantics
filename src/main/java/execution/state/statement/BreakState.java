package execution.state.statement;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.parser.exceptions.BreakException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class BreakState
extends ExecutionState
{

    public BreakState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new BreakException("Can't break while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BreakState copy = new BreakState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

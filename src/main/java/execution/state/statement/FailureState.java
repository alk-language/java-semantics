package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.parser.exceptions.FailureException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public class FailureState
extends PrimitiveState
{
    public FailureState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        throw new FailureException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FailureState copy = new FailureState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

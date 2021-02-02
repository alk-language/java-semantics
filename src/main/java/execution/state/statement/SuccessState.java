package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.parser.exceptions.SuccessException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public class SuccessState
extends PrimitiveState
{

    public SuccessState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        throw new SuccessException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SuccessState copy = new SuccessState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.exeptions.FailureException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

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

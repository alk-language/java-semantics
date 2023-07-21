package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class SymbolicIdState
   extends PrimitiveState
{
    public SymbolicIdState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        // TODO: should this return a location?
        return new SymbolicValue(tree);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return super.decorate(new SymbolicIdState(tree, payload.clone(sm)), sm);
    }
}

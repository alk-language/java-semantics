package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import symbolic.SymbolicValue;
import util.types.Storable;

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
        return generator.generate(new SymbolicValue(tree));
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return super.decorate(new SymbolicIdState(tree, payload.clone(sm)), sm);
    }
}

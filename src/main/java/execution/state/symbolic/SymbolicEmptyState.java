package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkSet.AlkSet;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicEmptyState
extends PrimitiveState
{
    public SymbolicEmptyState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        if (tree.getChildCount() == 0)
        {
            return new AlkSet();
        }

        return new SymbolicValue(tree);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicEmptyState copy = new SymbolicEmptyState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

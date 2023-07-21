package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

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

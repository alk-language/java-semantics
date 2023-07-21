package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.function.OldState;

public class SymbolicOldState
   extends OldState
{
    public SymbolicOldState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicOldState copy = new SymbolicOldState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

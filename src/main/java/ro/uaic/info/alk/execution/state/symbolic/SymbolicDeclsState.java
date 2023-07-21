package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.IndependentGeneratorState;

public class SymbolicDeclsState
   extends IndependentGeneratorState
{
    public SymbolicDeclsState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicDeclsState copy = new SymbolicDeclsState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

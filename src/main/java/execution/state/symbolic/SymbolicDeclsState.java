package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;

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
        SymbolicDeclsState copy = new SymbolicDeclsState(tree, payload);
        return super.decorate(copy, sm);
    }
}

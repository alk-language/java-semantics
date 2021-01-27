package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class BlockState
extends IndependentSingleState
{

    public BlockState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BlockState copy = new BlockState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

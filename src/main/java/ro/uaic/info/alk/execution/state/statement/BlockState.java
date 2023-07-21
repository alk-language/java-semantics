package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.IndependentSingleState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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

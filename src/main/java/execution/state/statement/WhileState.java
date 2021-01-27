package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class WhileState
extends LoopingState
{
    public WhileState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0), tree.getChild(1));
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        WhileState copy = new WhileState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

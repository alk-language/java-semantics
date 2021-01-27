package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class DoWhileState
extends FinalCheckLoopingState
{

    public DoWhileState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(1), tree.getChild(0));
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        DoWhileState copy = new DoWhileState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
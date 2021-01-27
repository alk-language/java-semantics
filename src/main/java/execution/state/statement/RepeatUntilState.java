package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class RepeatUntilState
extends FinalCheckLoopingState
{
    public RepeatUntilState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(1), tree.getChild(0));
    }

    @Override
    protected boolean processValidity(boolean validCondition)
    {
        return !validCondition;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RepeatUntilState copy = new RepeatUntilState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
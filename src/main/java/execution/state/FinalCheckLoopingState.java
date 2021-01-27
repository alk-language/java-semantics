package execution.state;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public abstract class FinalCheckLoopingState
extends LoopingState
{
    private boolean firstTime = true;

    public FinalCheckLoopingState(AST tree, ExecutionPayload executionPayload, AST condition, AST body)
    {
        super(tree, executionPayload, condition, body);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (firstTime)
        {
            checkedCondition = true;
            validCondition = processValidity(true);
            firstTime = false;
        }

        return super.makeStep();
    }

    protected FinalCheckLoopingState decorate(FinalCheckLoopingState copy, SplitMapper sm)
    {
        copy.firstTime = firstTime;
        return (FinalCheckLoopingState) super.decorate(copy, sm);
    }
}

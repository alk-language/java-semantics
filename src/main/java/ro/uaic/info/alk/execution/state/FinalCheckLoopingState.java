package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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
            firstTime = false;
            checkedCondition = true;
            return request(body);
        }

        return super.makeStep();
    }

    protected FinalCheckLoopingState decorate(FinalCheckLoopingState copy, SplitMapper sm)
    {
        copy.firstTime = firstTime;
        return (FinalCheckLoopingState) super.decorate(copy, sm);
    }

    public boolean getFirstTime() {
        return firstTime;
    }
}

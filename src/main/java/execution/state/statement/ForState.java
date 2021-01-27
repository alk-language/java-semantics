package execution.state.statement;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class ForState
extends LoopingState
{
    private boolean visitedStart = false;
    private boolean incrementalStep = false;
    private boolean incrementing = false;

    public ForState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(1), tree.getChild(3));
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (tree.getChild(0) != null && !visitedStart)
        {
            return request(tree.getChild(0));
        }

        if (incrementalStep)
        {
            incrementalStep = false;
            incrementing = true;
            return request(tree.getChild(2));
        }
        else
        {
            if (checkedCondition)
            {
                incrementalStep = true;
            }
            return super.makeStep();
        }
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!visitedStart)
        {
            visitedStart = true;
            return;
        }

        if (incrementing)
            incrementing = false;
        else
            super.assign(executionResult);
    }


    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ForState copy = new ForState(tree, payload.clone(sm));
        copy.visitedStart = visitedStart;
        copy.incrementalStep = incrementalStep;
        copy.incrementing = incrementing;
        return super.decorate(copy, sm);
    }
}
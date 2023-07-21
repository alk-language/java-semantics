package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.LoopingState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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

        if (!visitedStart)
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

    public ExecutionState decorate(ForState copy, SplitMapper sm)
    {
        copy.visitedStart = visitedStart;
        copy.incrementalStep = incrementalStep;
        copy.incrementing = incrementing;
        return super.decorate(copy, sm);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return this.decorate(new ForState(tree, payload.clone(sm)), sm);
    }
}
package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public abstract class FinalCheckLoopingState extends LoopingState
{
    private boolean firstTime = true;

    public FinalCheckLoopingState(ParseTree tree,
                                  ExecutionPayload executionPayload,
                                  Class<? extends alkBaseVisitor> conditionVisitor,
                                  Class<? extends alkBaseVisitor> bodyVisitor,
                                  ParseTree condition,
                                  ParseTree body)
    {
        super(tree, executionPayload, conditionVisitor, bodyVisitor, condition, body);
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

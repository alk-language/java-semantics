package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.FinalCheckLoopingState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

public class RepeatUntilState
   extends FinalCheckLoopingState
{
    public RepeatUntilState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(1), tree.getChild(0));
    }

    @Override
    protected boolean processValidity(Storable validCondition)
    {
        return !super.processValidity(validCondition);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RepeatUntilState copy = new RepeatUntilState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
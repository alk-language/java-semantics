package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.FinalCheckLoopingState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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
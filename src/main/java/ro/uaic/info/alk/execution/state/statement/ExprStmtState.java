package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.IndependentSingleState;

public class ExprStmtState
   extends IndependentSingleState
{
    public ExprStmtState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ExprStmtState copy = new ExprStmtState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

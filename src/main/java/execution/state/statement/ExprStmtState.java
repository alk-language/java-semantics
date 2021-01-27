package execution.state.statement;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.IndependentSingleState;

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

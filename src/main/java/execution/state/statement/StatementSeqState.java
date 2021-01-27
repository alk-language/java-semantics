package execution.state.statement;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class StatementSeqState
extends IndependentGeneratorState
{
    public StatementSeqState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        StatementSeqState copy = new StatementSeqState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.IndependentGeneratorState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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

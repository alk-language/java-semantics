package execution.state.main;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.StatementSeqContext.class)
public class StatementSeqState extends IndependentGeneratorState
{
    public StatementSeqState(alkParser.StatementSeqContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.statement(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        StatementSeqState copy = new StatementSeqState((alkParser.StatementSeqContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

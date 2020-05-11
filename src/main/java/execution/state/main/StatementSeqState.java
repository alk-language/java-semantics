package execution.state.main;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.StatementSeqContext.class)
public class StatementSeqState extends IndependentGeneratorState
{
    public StatementSeqState(alkParser.StatementSeqContext tree, Payload payload)
    {
        super(tree, payload, tree.statement(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        StatementSeqState copy = new StatementSeqState((alkParser.StatementSeqContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

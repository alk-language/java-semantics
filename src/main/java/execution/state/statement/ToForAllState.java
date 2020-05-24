package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ToForEachContext.class)
public class ToForAllState extends IndependentSingleState
{
    public ToForAllState(alkParser.ToForEachContext tree, Payload payload)
    {
        super(tree, payload, tree.foreach_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToForAllState copy = new ToForAllState((alkParser.ToForEachContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

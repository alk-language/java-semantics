package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ToChooseStmtContext.class)
public class ToChooseStmtState extends IndependentSingleState
{

    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, Payload payload) {
        super(ctx, payload, ctx.choose(), StmtVisitor.class);
        visitor = StmtVisitor.class;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToChooseStmtState copy = new ToChooseStmtState((alkParser.ToChooseStmtContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

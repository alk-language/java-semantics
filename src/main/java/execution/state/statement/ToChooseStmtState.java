package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToChooseStmtContext.class)
public class ToChooseStmtState extends IndependentSingleState
{

    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, Payload payload) {
        super(ctx, payload, ctx.choose(), StmtVisitor.class);
        visitor = StmtVisitor.class;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ToChooseStmtState copy = new ToChooseStmtState((alkParser.ToChooseStmtContext) tree, payload);
        return super.decorate(copy);
    }
}

package execution.state.statement;

import execution.state.IndependentSingleState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToChooseStmtContext.class)
public class ToChooseStmtState extends IndependentSingleState {
    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, Payload payload) {
        super(ctx, payload, ctx.choose(), StmtVisitor.class);
        visitor = StmtVisitor.class;
    }
}

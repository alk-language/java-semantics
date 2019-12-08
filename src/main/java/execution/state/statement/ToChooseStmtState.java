package execution.state.statement;

import execution.state.IndependentSingleState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.Payload;

public class ToChooseStmtState extends IndependentSingleState {
    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, Payload payload) {
        super(ctx, payload, ctx.choose());
        visitor = StmtVisitor.class;
    }
}

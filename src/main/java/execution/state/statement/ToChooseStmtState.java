package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import execution.state.SingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.types.Value;

public class ToChooseStmtState extends IndependentSingleState {
    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, StmtVisitor stmtVisitor) {
        super(ctx, stmtVisitor, ctx.choose());
    }
}

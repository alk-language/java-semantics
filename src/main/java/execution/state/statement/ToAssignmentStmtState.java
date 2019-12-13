package execution.state.statement;

import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToAssignmentStmtContext.class)
public class ToAssignmentStmtState extends IndependentSingleState {
    public ToAssignmentStmtState(alkParser.ToAssignmentStmtContext tree, Payload payload)
    {
        super(tree, payload, tree.assignment(), StmtVisitor.class);
    }
}

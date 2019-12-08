package execution.state.statement;

import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.Payload;

public class ToAssignmentStmtState extends IndependentSingleState {
    public ToAssignmentStmtState(alkParser.ToAssignmentStmtContext tree, Payload payload)
    {
        super(tree, payload, tree.assignment());
        this.visitor = StmtVisitor.class;
    }
}

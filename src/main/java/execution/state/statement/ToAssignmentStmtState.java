package execution.state.statement;

import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;

public class ToAssignmentStmtState extends IndependentSingleState {
    public ToAssignmentStmtState(alkParser.ToAssignmentStmtContext tree, StmtVisitor visitor)
    {
        super(tree, visitor, tree.assignment());
    }
}

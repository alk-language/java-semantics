package execution.state.main;

import execution.state.IndividualGeneratorState;
import grammar.alkParser;
import parser.visitors.MainVisitor;
import parser.visitors.StmtVisitor;
import util.Payload;

public class StatementSeqState extends IndividualGeneratorState {
    public StatementSeqState(alkParser.StatementSeqContext tree, Payload payload)
    {
        // TODO: to be rethinked
        super(tree, payload, tree.statement());
        visitor = StmtVisitor.class;
    }
}

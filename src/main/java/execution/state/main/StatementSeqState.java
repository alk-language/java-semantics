package execution.state.main;

import execution.state.IndividualGeneratorState;
import grammar.alkParser;
import parser.visitors.MainVisitor;
import parser.visitors.StmtVisitor;

public class StatementSeqState extends IndividualGeneratorState {
    public StatementSeqState(alkParser.StatementSeqContext tree, MainVisitor visitor) {
        super(tree, new StmtVisitor(MainVisitor.global, false), tree.statement());
    }
}

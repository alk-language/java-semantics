package execution.state.main;

import execution.state.IndependentSingleState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.visitors.MainVisitor;
import parser.visitors.StmtVisitor;
import util.Payload;

public class MainState extends IndependentSingleState
{
    public MainState(alkParser.StartPointContext tree, Payload payload) {
        super(tree, payload, tree.statement_sequence());
        visitor = StmtVisitor.class;
    }
}

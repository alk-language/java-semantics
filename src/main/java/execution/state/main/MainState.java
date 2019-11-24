package execution.state.main;

import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.MainVisitor;

public class MainState extends IndependentSingleState
{
    public MainState(alkParser.StartPointContext tree, MainVisitor visitor) {
        super(tree, visitor, tree.statement_sequence());
    }
}

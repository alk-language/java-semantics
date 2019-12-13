package execution.state.main;

import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.MainVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.StartPointContext.class)
public class MainState extends IndependentSingleState
{
    public MainState(alkParser.StartPointContext tree, Payload payload) {
        super(tree, payload, tree.statement_sequence(), MainVisitor.class);
    }
}

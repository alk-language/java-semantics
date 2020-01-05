package execution.state.main;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import execution.state.function.BuiltInMethodState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.MainVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.StartPointContext.class)
public class MainState extends IndependentSingleState
{
    public MainState(alkParser.StartPointContext tree, Payload payload) {
        super(tree, payload, tree.statement_sequence(), MainVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        MainState copy = new MainState((alkParser.StartPointContext) tree, payload);
        return super.decorate(copy);
    }
}

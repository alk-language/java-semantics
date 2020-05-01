package execution.state.init;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import grammar.alkParser;
import parser.visitors.InitVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ConfigContext.class)
public class InitState extends IndependentGeneratorState {

    public InitState(alkParser.ConfigContext tree,
                        Payload payload)
    {
        super(tree, payload, tree.variable(), InitVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        return null;
    }
}

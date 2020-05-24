package execution.state.init;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.InitVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.ConfigContext.class)
public class InitState extends IndependentSingleState {

    public InitState(alkParser.ConfigContext tree,
                        Payload payload)
    {
        super(tree, payload, tree.var_def_seq(), InitVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        throw new InternalException("The InitState shouldn't be cloned.");
    }
}

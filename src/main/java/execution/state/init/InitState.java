package execution.state.init;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.InitVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.ConfigContext.class)
public class InitState extends IndependentSingleState {

    public InitState(alkParser.ConfigContext tree,
                        ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.var_def_seq(), InitVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        throw new InternalException("The InitState shouldn't be cloned.");
    }
}

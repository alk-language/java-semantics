package execution.state.function;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.function.FunctionCallVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.FunctionCallContext.class)
public class FunctionCallState extends IndependentSingleState {

    alkParser.FunctionCallContext tree;

    public FunctionCallState(alkParser.FunctionCallContext tree, Payload payload) {
        super(tree, payload, tree.function_call(), FunctionCallVisitor.class);
        this.tree = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return super.decorate(new FunctionCallState(tree, sm.getPayload()), sm);
    }
}

package execution.state.function;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.function.FunctionCallVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.FunctionCallContext.class)
public class FunctionCallState extends IndependentSingleState {

    public FunctionCallState(alkParser.FunctionCallContext tree, Payload payload) {
        super(tree, payload, tree.function_call(), FunctionCallVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        return null;
    }
}

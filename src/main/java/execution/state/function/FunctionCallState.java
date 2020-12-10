package execution.state.function;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.function.FunctionCallVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.FunctionCallContext.class)
public class FunctionCallState extends IndependentSingleState {

    alkParser.FunctionCallContext tree;

    public FunctionCallState(alkParser.FunctionCallContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.function_call(), FunctionCallVisitor.class);
        this.tree = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return super.decorate(new FunctionCallState(tree, sm.getExecutionPayload()), sm);
    }
}

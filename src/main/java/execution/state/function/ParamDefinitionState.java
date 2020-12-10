package execution.state.function;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.functions.Parameter;

@CtxState(ctxClass = alkParser.ParamDefinitionContext.class)
public class ParamDefinitionState extends PrimitiveState {

    alkParser.ParamDefinitionContext ctx;

    public ParamDefinitionState(alkParser.ParamDefinitionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, new Parameter(tree.ID().getText(), tree.OUT() != null));
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ParamDefinitionState copy = new ParamDefinitionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

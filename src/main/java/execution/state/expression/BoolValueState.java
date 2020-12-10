package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkBool.AlkBool;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.BoolValueContext.class)
public class BoolValueState extends PrimitiveState {
    public BoolValueState(alkParser.BoolValueContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, new AlkBool(ctx.BOOL().toString().equals("true")));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BoolValueState copy = new BoolValueState((alkParser.BoolValueContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

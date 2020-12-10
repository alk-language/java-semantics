package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkString.AlkString;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.StringValueContext.class)
public class StringValueState extends PrimitiveState {
    public StringValueState(alkParser.StringValueContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, new AlkString(ctx.STRING().toString().substring(1, ctx.STRING().toString().length()-1)));
    }


    @Override
    public ExecutionState clone(SplitMapper sm) {
        StringValueState copy = new StringValueState((alkParser.StringValueContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

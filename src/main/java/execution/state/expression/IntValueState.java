package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkInt.AlkInt;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

import java.math.BigInteger;

@CtxState(ctxClass = alkParser.IntValueContext.class)
public class IntValueState extends PrimitiveState {

    public IntValueState(alkParser.IntValueContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, new AlkInt(new BigInteger(ctx.INT().toString())));
    }
    @Override
    public ExecutionState clone(SplitMapper sm) {
        IntValueState copy = new IntValueState((alkParser.IntValueContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }

}

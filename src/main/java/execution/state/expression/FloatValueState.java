package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkFloat.AlkFloat;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

import java.math.BigDecimal;

@CtxState(ctxClass = alkParser.DoubleValueContext.class)
public class FloatValueState extends PrimitiveState
{
    public FloatValueState(alkParser.DoubleValueContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload, new AlkFloat(new BigDecimal(ctx.DOUBLE().toString())));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FloatValueState copy = new FloatValueState((alkParser.DoubleValueContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkFloat.AlkFloat;
import util.CtxState;
import util.Payload;

import java.math.BigDecimal;

@CtxState(ctxClass = alkParser.DoubleValueContext.class)
public class FloatValueState extends PrimitiveState
{
    public FloatValueState(alkParser.DoubleValueContext ctx, Payload payload)
    {
        super(ctx, payload, new AlkFloat(new BigDecimal(ctx.DOUBLE().toString())));
    }

    @Override
    public ExecutionState clone(Payload payload) {
        FloatValueState copy = new FloatValueState((alkParser.DoubleValueContext) tree, payload);
        return super.decorate(copy);
    }
}

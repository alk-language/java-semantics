package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkFloat.AlkFloat;
import parser.env.LocationMapper;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

import java.math.BigDecimal;

@CtxState(ctxClass = alkParser.DoubleValueContext.class)
public class FloatValueState extends PrimitiveState
{
    public FloatValueState(alkParser.DoubleValueContext ctx, Payload payload)
    {
        super(ctx, payload, new AlkFloat(new BigDecimal(ctx.DOUBLE().toString())));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FloatValueState copy = new FloatValueState((alkParser.DoubleValueContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

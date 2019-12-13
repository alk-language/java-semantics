package execution.state.expression;

import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.types.alkFloat.AlkFloat;
import util.CtxState;
import util.Payload;

import java.math.BigDecimal;

@CtxState(ctxClass = alkParser.DoubleValueContext.class)
public class FloatValueState extends PrimitiveState {
    public FloatValueState(alkParser.DoubleValueContext ctx, Payload payload)
    {
        super(ctx, payload, new AlkFloat(new BigDecimal(ctx.DOUBLE().toString())));
    }
}

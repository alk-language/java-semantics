package execution.state.expression;

import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.types.alkInt.AlkInt;
import util.CtxState;
import util.Payload;

import java.math.BigInteger;

@CtxState(ctxClass = alkParser.IntValueContext.class)
public class IntValueState extends PrimitiveState {

    public IntValueState(alkParser.IntValueContext ctx, Payload payload) {
        super(ctx, payload, new AlkInt(new BigInteger(ctx.INT().toString())));
    }

}

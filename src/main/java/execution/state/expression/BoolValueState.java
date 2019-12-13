package execution.state.expression;

import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.types.alkBool.AlkBool;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.BoolValueContext.class)
public class BoolValueState extends PrimitiveState {
    public BoolValueState(alkParser.BoolValueContext ctx, Payload payload) {
        super(ctx, payload, new AlkBool(ctx.BOOL().toString().equals("true")));
    }
}

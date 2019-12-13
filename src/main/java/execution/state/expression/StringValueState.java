package execution.state.expression;

import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.types.alkString.AlkString;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.StringValueContext.class)
public class StringValueState extends PrimitiveState {
    public StringValueState(alkParser.StringValueContext ctx, Payload payload) {
        super(ctx, payload, new AlkString(ctx.STRING().toString().substring(1, ctx.STRING().toString().length()-1)));
    }
}

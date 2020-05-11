package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkInt.AlkInt;
import parser.env.LocationMapper;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

import java.math.BigInteger;

@CtxState(ctxClass = alkParser.IntValueContext.class)
public class IntValueState extends PrimitiveState {

    public IntValueState(alkParser.IntValueContext ctx, Payload payload) {
        super(ctx, payload, new AlkInt(new BigInteger(ctx.INT().toString())));
    }
    @Override
    public ExecutionState clone(SplitMapper sm) {
        IntValueState copy = new IntValueState((alkParser.IntValueContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }

}

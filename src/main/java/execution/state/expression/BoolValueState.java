package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.types.alkBool.AlkBool;
import parser.env.LocationMapper;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.BoolValueContext.class)
public class BoolValueState extends PrimitiveState {
    public BoolValueState(alkParser.BoolValueContext ctx, Payload payload) {
        super(ctx, payload, new AlkBool(ctx.BOOL().toString().equals("true")));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BoolValueState copy = new BoolValueState((alkParser.BoolValueContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

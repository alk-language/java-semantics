package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.exceptions.SuccessException;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.SuccessContext.class)
public class SuccessState extends PrimitiveState {

    alkParser.SuccessContext ctx;

    public SuccessState(alkParser.SuccessContext ctx, Payload payload) {
        super(ctx, payload, null);
        this.ctx = ctx;
        throw new SuccessException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        SuccessState copy = new SuccessState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

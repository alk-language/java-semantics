package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.exceptions.FailureException;
import parser.exceptions.SuccessException;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.FailureContext.class)
public class FailureState extends PrimitiveState {

    alkParser.FailureContext ctx;

    public FailureState(alkParser.FailureContext ctx, Payload payload) {
        super(ctx, payload, null);
        this.ctx = ctx;
        throw new FailureException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FailureState copy = new FailureState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

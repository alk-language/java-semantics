package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import parser.exceptions.FailureException;
import parser.exceptions.SuccessException;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.FailureContext.class)
public class FailureState extends PrimitiveState {

    alkParser.FailureContext ctx;

    public FailureState(alkParser.FailureContext ctx, Payload payload) {
        super(ctx, payload, null);
        getConfig().getIOManager().write("failure");
        this.ctx = ctx;
        throw new FailureException();
    }

    @Override
    public ExecutionState clone(Payload payload) {
        FailureState copy = new FailureState(ctx, payload);
        return super.decorate(copy);
    }
}

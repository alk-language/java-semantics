package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.parser.exceptions.FailureException;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.FailureContext.class)
public class FailureState extends PrimitiveState {

    alkParser.FailureContext ctx;

    public FailureState(alkParser.FailureContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, null);
        this.ctx = ctx;
        throw new FailureException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FailureState copy = new FailureState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import execution.parser.exceptions.SuccessException;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.SuccessContext.class)
public class SuccessState extends PrimitiveState {

    alkParser.SuccessContext ctx;

    public SuccessState(alkParser.SuccessContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, null);
        this.ctx = ctx;
        throw new SuccessException();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        SuccessState copy = new SuccessState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkSet.AlkSet;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.EmptySetContext.class)
public class EmptySetState extends PrimitiveState {

    alkParser.EmptySetContext ctx;

    public EmptySetState(alkParser.EmptySetContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, new AlkSet());
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptySetState copy =  new EmptySetState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

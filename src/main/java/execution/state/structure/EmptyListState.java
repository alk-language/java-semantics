package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkList.AlkList;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.EmptyListContext.class)
public class EmptyListState extends PrimitiveState {

    alkParser.EmptyListContext ctx;

    public EmptyListState(alkParser.EmptyListContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, new AlkList());
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptyListState copy =  new EmptyListState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

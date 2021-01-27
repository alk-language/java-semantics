package execution.state.structure;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkList.AlkList;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.EmptyListContext.class)
public class EmptyListState
extends PrimitiveState
{
    public EmptyListState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
    }

    @Override
    protected Value requireResult()
    {
        return new AlkList();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptyListState copy =  new EmptyListState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

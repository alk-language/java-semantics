package execution.state.structure;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.alkSet.AlkSet;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.EmptySetContext.class)
public class EmptySetState
extends PrimitiveState
{
    public EmptySetState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
    }

    @Override
    protected Value requireResult()
    {
        return new AlkSet();
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptySetState copy =  new EmptySetState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

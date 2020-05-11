package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.AlkValue;
import execution.types.alkSet.AlkSet;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.EmptySetContext.class)
public class EmptySetState extends PrimitiveState {

    alkParser.EmptySetContext ctx;

    public EmptySetState(alkParser.EmptySetContext ctx, Payload payload) {
        super(ctx, payload, new AlkSet());
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        EmptySetState copy =  new EmptySetState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

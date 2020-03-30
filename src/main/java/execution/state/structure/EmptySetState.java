package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.AlkValue;
import execution.types.alkSet.AlkSet;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.EmptySetContext.class)
public class EmptySetState extends PrimitiveState {

    alkParser.EmptySetContext ctx;

    public EmptySetState(alkParser.EmptySetContext ctx, Payload payload) {
        super(ctx, payload, new AlkSet());
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        EmptySetState copy =  new EmptySetState(ctx, payload);
        return super.decorate(copy);
    }
}

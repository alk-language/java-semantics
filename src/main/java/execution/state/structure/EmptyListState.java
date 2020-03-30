package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.AlkValue;
import execution.types.alkList.AlkList;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.EmptyListContext.class)
public class EmptyListState extends PrimitiveState {

    alkParser.EmptyListContext ctx;

    public EmptyListState(alkParser.EmptyListContext ctx, Payload payload) {
        super(ctx, payload, new AlkList());
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        EmptyListState copy =  new EmptyListState(ctx, payload);
        return super.decorate(copy);
    }
}

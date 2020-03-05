package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.types.AlkValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.EmptyListContext.class)
public class EmptyListState extends PrimitiveState {

    public EmptyListState(alkParser.EmptyListContext tree, Payload payload, AlkValue value) {
        super(tree, payload, value);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        return null;
    }
}

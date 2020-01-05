package execution.state;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
import util.CtxState;
import util.Payload;
import util.types.Value;

public abstract class PrimitiveState extends ExecutionState<AlkValue, AlkValue> {

    public PrimitiveState(ParseTree tree, Payload payload, AlkValue value) {
        super(tree, payload);
        result = new ExecutionResult<>(value);
    }

    @Override
    public ExecutionState<AlkValue, Value> makeStep()
    {
        return null;
    }

    @Override
    public void assign(ExecutionResult result) {
        // no - op
    }
}

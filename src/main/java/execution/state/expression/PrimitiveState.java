package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
import util.types.Value;

public abstract class PrimitiveState extends ExecutionState<AlkValue, AlkValue> {

    PrimitiveState(ParseTree tree, alkBaseVisitor visitor, AlkValue value) {
        super(tree, visitor);
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

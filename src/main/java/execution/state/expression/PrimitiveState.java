package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;

public abstract class PrimitiveState extends ExecutionState {

    public PrimitiveState(ParseTree tree, alkBaseVisitor visitor, AlkValue value) {
        super(tree, visitor);
        result = new ExecutionResult(value);
    }

    @Override
    public ExecutionState makeStep()
    {
        return null;
    }

    @Override
    public void assign(ExecutionResult result) {
        // no - op
    }
}

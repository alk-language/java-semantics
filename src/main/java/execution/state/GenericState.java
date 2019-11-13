package execution.state;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class GenericState extends ExecutionState {

    public GenericState(ParseTree tree, alkBaseVisitor visitor) {
        super(tree, visitor);
    }

    @Override
    public ExecutionState makeStep() {
        if (result != null)
            return null;
        return (ExecutionState) visitor.visit(tree);
    }

    @Override
    public void assign(ExecutionResult result) {
        this.result = result;
    }
}

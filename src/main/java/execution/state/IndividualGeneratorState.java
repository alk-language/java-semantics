package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.alkInt.AlkInt;
import util.types.Value;

import java.util.List;

public abstract class IndividualGeneratorState extends GeneratorState {

    protected IndividualGeneratorState(ParseTree tree, alkBaseVisitor visitor, List<? extends ParseTree> children) {
        super(tree, visitor, children);
    }

    @Override
    public void assign(ExecutionResult result) {
        // no-op
    }

    @Override
    public Value getFinalResult() {
        return null;
    }
}

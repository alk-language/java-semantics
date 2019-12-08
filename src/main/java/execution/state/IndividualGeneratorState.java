package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.alkInt.AlkInt;
import util.Payload;
import util.types.Value;

import java.util.List;

public abstract class IndividualGeneratorState extends GeneratorState {

    protected Class<? extends alkBaseVisitor> visitor;

    protected IndividualGeneratorState(ParseTree tree, Payload payload, List<? extends ParseTree> children) {
        super(tree, payload, children);
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

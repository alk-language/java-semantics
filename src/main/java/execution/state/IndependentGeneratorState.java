package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import java.util.List;

public abstract class IndependentGeneratorState extends GeneratorState {

    protected IndependentGeneratorState(ParseTree tree,
                                        Payload payload,
                                        List<? extends ParseTree> children,
                                        Class<? extends alkBaseVisitor> visitor)
    {
        super(tree, payload, children, visitor);
    }

    @Override
    public void assign(ExecutionResult result) {
        // no-op
    }

    @Override
    public Value getFinalResult() {
        return null;
    }

    protected IndependentGeneratorState decorate(IndependentGeneratorState copy, SplitMapper sm)
    {
        return (IndependentGeneratorState) super.decorate(copy, sm);
    }
}

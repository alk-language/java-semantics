package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import java.util.List;

public abstract class IndependentGeneratorState extends GeneratorState<Value, Value> {

    protected IndependentGeneratorState(ParseTree tree,
                                        ExecutionPayload executionPayload,
                                        List<? extends ParseTree> children,
                                        Class<? extends alkBaseVisitor> visitor)
    {
        super(tree, executionPayload, children, visitor);
    }

    @Override
    public void assign(ExecutionResult executionResult) {
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

package execution.state;

import ast.AST;
import execution.ExecutionResult;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class IndependentGeneratorState extends GeneratorState
{

    protected IndependentGeneratorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
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

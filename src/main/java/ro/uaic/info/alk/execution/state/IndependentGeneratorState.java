package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

public abstract class IndependentGeneratorState
extends GeneratorState
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
    public Storable getFinalResult() {
        return null;
    }

    protected IndependentGeneratorState decorate(IndependentGeneratorState copy, SplitMapper sm)
    {
        return (IndependentGeneratorState) super.decorate(copy, sm);
    }
}

package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

public abstract class PrimitiveState extends ExecutionState
{

    public PrimitiveState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        setResult(new ExecutionResult(requireResult()));
        return null;
    }

    protected abstract Storable requireResult();

    @Override
    public void assign(ExecutionResult executionResult)
    {
        // no - op
    }

    protected PrimitiveState decorate(PrimitiveState copy, SplitMapper sm)
    {
        return (PrimitiveState) super.decorate(copy, sm);
    }
}

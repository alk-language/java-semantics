package execution.state;

import ast.AST;
import execution.ExecutionResult;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

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

    protected abstract Value requireResult();

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

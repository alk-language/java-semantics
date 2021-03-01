package execution.state;

import ast.AST;
import execution.ExecutionResult;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import util.types.Storable;

public abstract class SingleState
extends ExecutionState
{
    private final AST dependency;
    private Storable localResult;
    private boolean visited = false;

    public SingleState(AST tree, ExecutionPayload executionPayload, AST dependency)
    {
        super(tree, executionPayload);
        this.dependency = dependency;
    }

    protected abstract Storable interpretResult(Storable value);

    @Override
    public ExecutionState makeStep()
    {
        if (visited)
        {
            setResult(new ExecutionResult(localResult));
            return null;
        }

        return super.request(dependency);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (executionResult != null)
        {
            try
            {
                localResult = interpretResult(executionResult.getValue());
            }
            catch (AlkException e)
            {
                super.handle(e);
            }
        }
        visited = true;
    }

    public SingleState decorate(SingleState copy, SplitMapper sm)
    {
        if (this.localResult != null)
        {
            copy.localResult = this.localResult.weakClone(sm.getLocationMapper());
        }
        copy.visited = this.visited;
        return (SingleState) super.decorate(copy, sm);
    }
}

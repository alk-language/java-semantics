package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

/**
 *
 * @param <T>
 *        The type of value which will be returned
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class SingleState<T extends Value, S extends Value> extends ExecutionState<T, S>
{
    private T localResult;
    private boolean visited = false;
    private ParseTree dependency;
    protected Class<? extends alkBaseVisitor> visitor;

    public SingleState(ParseTree tree, ExecutionPayload executionPayload, ParseTree dependency, Class<? extends alkBaseVisitor> visitor) {
        super(tree, executionPayload);
        if (dependency == null)
        {
            int virga2 = 0;
        }
        this.dependency = dependency;
        this.visitor = visitor;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (visited)
        {
            setResult(new ExecutionResult<>(localResult));
            return null;
        }

        return (ExecutionState) super.request(visitor, dependency);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (executionResult != null)
            localResult = interpretResult(executionResult.getValue());
        visited = true;
    }

    protected abstract T interpretResult(Value value);

    public SingleState decorate(SingleState copy, SplitMapper sm) {
        if (this.localResult != null)
            copy.localResult = this.localResult.weakClone(sm.getLocationMapper());
        copy.visited = this.visited;
        return (SingleState) super.decorate(copy, sm);
    }
}

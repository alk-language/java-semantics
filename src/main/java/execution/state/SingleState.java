package execution.state;

import execution.ExecutionResult;
import execution.state.structure.IterableWithIntervalState;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
import util.Payload;
import util.VisitorFactory;
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

    protected T localResult;
    private boolean visited = false;
    private ParseTree dependency;
    protected Class<? extends alkBaseVisitor> visitor;

    public SingleState(ParseTree tree, Payload payload, ParseTree dependency, Class<? extends alkBaseVisitor> visitor) {
        super(tree, payload);
        this.dependency = dependency;
        this.visitor = visitor;
    }

    @Override
    public ExecutionState<S, Value> makeStep()
    {
        if (visited)
        {
            result = new ExecutionResult<>(localResult);
            return null;
        }

        return super.request(visitor, dependency);
    }

    @Override
    public void assign(ExecutionResult<S> result)
    {
        if (result != null)
            localResult = interpretResult(result.getValue());
        visited = true;
    }

    protected abstract T interpretResult(S value);

    public SingleState decorate(SingleState copy) {
        if (localResult != null)
        {
            copy.localResult = this.localResult.clone();
        }
        copy.visited = visited;
        copy.dependency = dependency;
        return (SingleState) super.decorate(copy);
    }
}

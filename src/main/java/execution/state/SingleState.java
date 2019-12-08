package execution.state;

import execution.ExecutionResult;
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
    boolean visited = false;
    private final ParseTree dependency;
    protected Class<? extends alkBaseVisitor> visitor;

    public SingleState(ParseTree tree, Payload payload, ParseTree dependency) {
        super(tree, payload);
        this.dependency = dependency;
    }

    @Override
    public ExecutionState<S, Value> makeStep()
    {
        if (visited)
        {
            result = new ExecutionResult<>(localResult);
            return null;
        }

        return (ExecutionState<S, Value>) VisitorFactory.create(visitor, getEnv(), payload).visit(dependency);
    }

    @Override
    public void assign(ExecutionResult<S> result)
    {
        if (result != null)
            localResult = interpretResult(result.getValue());
        visited = true;
    }

    protected abstract T interpretResult(S value);
}

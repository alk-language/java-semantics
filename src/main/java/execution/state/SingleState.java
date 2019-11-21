package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
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
    private final ParseTree dependency;

    public SingleState(ParseTree tree, alkBaseVisitor visitor, ParseTree dependency) {
        super(tree, visitor);
        this.dependency = dependency;
    }

    @Override
    public ExecutionState<S, Value> makeStep() {
        if (localResult != null)
        {
            result = new ExecutionResult<>(localResult);
            return null;
        }

        return (ExecutionState) visitor.visit(dependency);
    }

    @Override
    public void assign(ExecutionResult<S> result)
    {
        localResult = interpretResult(result.getValue());
    }

    protected abstract T interpretResult(S value);
}

package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
import util.Payload;
import util.exception.AlkFatalException;
import util.exception.InternalException;
import util.types.Value;

import java.util.List;

/**
 * TODO: reimplement so that the children can exploit more restrictive generic
 * @param <T>
 *        The type of value which will be returned
 */
public abstract class GuardedGeneratorState<T extends Value> extends GeneratorState<T, T>
{
    private T localResult;

    public GuardedGeneratorState(ParseTree tree,
                                 Payload payload,
                                 List<? extends ParseTree> children,
                                 Class<? extends alkBaseVisitor> visitor)
    {
        super(tree, payload, children, visitor);
    }

    @Override
    public void assign(ExecutionResult<T> result)
    {
        if (step == 1)
            localResult = result.getValue();
        else
            localResult = interpretResult(localResult, result.getValue());
    }

    @Override
    public T getFinalResult() {
        return localResult;
    }

    protected abstract T interpretResult(T current, T next);

    protected int getSignPos()
    {
        return (step-1)*2-1;
    }

    protected T getLocalResult()
    {
        return localResult;
    }

}

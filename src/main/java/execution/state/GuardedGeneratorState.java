package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.LocationMapper;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import java.util.List;

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
        T value = result.getValue();
        if (step == 1)
            localResult = value;
        else
            localResult = interpretResult((T) localResult.toRValue(), (T) value.toRValue());
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

    protected GuardedGeneratorState decorate(GuardedGeneratorState copy, SplitMapper sm)
    {
        if (localResult != null)
            copy.localResult = localResult.weakClone(sm.getLocationMapper());
        return (GuardedGeneratorState) super.decorate(copy, sm);
    }

}

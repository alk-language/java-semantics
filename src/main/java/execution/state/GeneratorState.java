package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.lambda.Validator;
import util.types.Value;

import java.util.List;

/**
 *
 * @param <T>
 *        The type of value which will be returned
 * @param <S>
 *        The type of value which will be dependent upon
 */
public abstract class GeneratorState<T extends Value, S extends Value> extends ExecutionState<T, S>
{

    protected int step = 0;
    private List<? extends ParseTree> children;
    private Validator preValidator;
    protected Class<? extends alkBaseVisitor> visitor;

    protected GeneratorState(ParseTree tree,
                             ExecutionPayload executionPayload,
                             List<? extends ParseTree> children,
                             Class<? extends alkBaseVisitor> visitor)
    {
        super(tree, executionPayload);
        this.children = children;
        this.visitor = visitor;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step == children.size() ||
            preValidator != null && !preValidator.isValid())
        {
            setResult(new ExecutionResult<>(getFinalResult()));
            return null;
        }

        return super.request(visitor, children.get(step++));
    }

    @Override
    public abstract void assign(ExecutionResult<T> executionResult);

    public abstract T getFinalResult();

    protected void setPreValidator(Validator preValidator) {
        this.preValidator = preValidator;
    }

    protected GeneratorState decorate(GeneratorState copy, SplitMapper sm)
    {
        copy.step = step;
        copy.preValidator = preValidator;
        return (GeneratorState) super.decorate(copy, sm);
    }

}

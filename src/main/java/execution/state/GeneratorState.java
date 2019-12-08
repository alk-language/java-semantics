package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.alkInt.AlkInt;
import util.Payload;
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
public abstract class GeneratorState<T extends Value, S extends Value> extends ExecutionState<T, S> {

    int step = 0;
    private List<? extends ParseTree> children;
    private Validator preValidator;

    @Deprecated
    protected GeneratorState(ParseTree tree, alkBaseVisitor visitor, List<? extends ParseTree> children) {
        super(tree, visitor);
        this.children = children;
    }

    protected GeneratorState(ParseTree tree, Payload payload, List<? extends ParseTree> children) {
        super(tree, payload);
        this.children = children;
    }

    @Override
    public ExecutionState<S, Value> makeStep()
    {
        if (step == children.size() ||
            preValidator != null && !preValidator.isValid())
        {
            result = new ExecutionResult<>(getFinalResult());
            return null;
        }

        return (ExecutionState) visitor.visit(children.get(step++));
    }

    @Override
    public abstract void assign(ExecutionResult<S> result);

    public abstract T getFinalResult();

    protected void setPreValidator(Validator preValidator) {
        this.preValidator = preValidator;
    }

}

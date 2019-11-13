package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;
import util.lambda.Validator;

import java.util.List;

public abstract class GeneratorState extends ExecutionState {

    protected int step = 0;
    protected AlkValue localResult;
    private List<? extends ParseTree> children;
    private Validator preValidator;

    public GeneratorState(ParseTree tree, alkBaseVisitor visitor, List<? extends ParseTree> children) {
        super(tree, visitor);
        this.children = children;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step == children.size())
        {
            result = new ExecutionResult(localResult);
            return null;
        }

        if (preValidator != null && !preValidator.isValid())
            return null;

        return (ExecutionState) visitor.visit(children.get(step));
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (step == 0)
            localResult = result.getValue();
        else
            localResult = interpretResult(result);
        step++;
    }

    protected void setPreValidator(Validator preValidator) {
        this.preValidator = preValidator;
    }

    protected abstract AlkValue interpretResult(ExecutionResult result);

    protected int getSignPos()
    {
        return step*2-1;
    }

}

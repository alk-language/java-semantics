package execution.state;

import ast.AST;
import execution.ExecutionResult;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.lambda.Validator;
import util.types.Storable;

import java.util.List;

public abstract class GeneratorState
extends ExecutionState
{
    protected final List<AST> children;
    private boolean stopped = false;
    protected int step = 0;

    protected GeneratorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.children = tree.getChildren();
    }

    protected void stopGenerator()
    {
        stopped = true;
    }

    public abstract Storable getFinalResult();

    @Override
    public abstract void assign(ExecutionResult executionResult);

    @Override
    public ExecutionState makeStep()
    {
        if (stopped || step == children.size())
        {
            setResult(new ExecutionResult(getFinalResult()));
            return null;
        }

        return super.request(children.get(step++));
    }

    protected GeneratorState decorate(GeneratorState copy, SplitMapper sm)
    {
        copy.step = step;
        copy.stopped = stopped;
        return (GeneratorState) super.decorate(copy, sm);
    }

}

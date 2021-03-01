package execution.state;

import ast.AST;
import ast.attr.OpsASTAttr;
import ast.enums.Operator;
import execution.ExecutionResult;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public abstract class GuardedGeneratorState
extends GeneratorState
{
    private Storable localResult;

    public GuardedGeneratorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    protected abstract Storable interpretResult(Operator op, Storable current, Storable next);
    protected abstract Storable firstAssign(Operator op, Storable current);

    @Override
    public void assign(ExecutionResult executionResult)
    {
        Storable value = executionResult.getValue();
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        if (step == 1)
        {
            localResult = firstAssign(attr.getOp(0), value);
        }
        else
        {
            localResult = interpretResult(attr.getOp(step - 2), localResult, value);
        }
    }

    @Override
    public Storable getFinalResult() {
        return localResult;
    }

    protected GuardedGeneratorState decorate(GuardedGeneratorState copy, SplitMapper sm)
    {
        if (localResult != null)
            copy.localResult = localResult.weakClone(sm.getLocationMapper());
        return (GuardedGeneratorState) super.decorate(copy, sm);
    }

}

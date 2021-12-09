package execution.state.expression;

import ast.AST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.types.alkBool.AlkBool;
import util.types.Storable;

public class BaseImpliesState
extends ExecutionState
{
    protected Storable lft;
    protected Storable rgh;

    public BaseImpliesState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (lft == null)
        {
            return request(tree.getChild(0));
        }
        if (!checkValue(lft))
        {
            super.handle(new AlkException("Left side of implication is not boolean!"));
        }
        if (rgh == null)
        {
            return request(tree.getChild(1));
        }
        if (!checkValue(rgh))
        {
            super.handle(new AlkException("Right side of implication is not boolean!"));
        }

        setResult(new ExecutionResult(getImplication()));
        return null;
    }

    protected boolean checkValue(Storable value)
    {
        return value instanceof AlkBool;
    }

    protected Storable getImplication()
    {
        AlkBool lftBool = (AlkBool) lft;
        AlkBool rghBool = (AlkBool) rgh;

        return new AlkBool(!lftBool.isTrue() || (lftBool.isTrue() && rghBool.isTrue()));
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (lft == null)
        {
            lft = result.getValue().toRValue();
            checkNotNull(lft, false);
        }
        else if (rgh == null)
        {
            rgh = result.getValue().toRValue();
            checkNotNull(rgh, false);
        }
    }

    public ExecutionState decorate(BaseImpliesState copy, SplitMapper sm)
    {
        copy.lft = lft == null ? null : lft.weakClone(sm.getLocationMapper());
        copy.rgh = rgh == null ? null : rgh.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseImpliesState copy = new BaseImpliesState(tree, payload.clone(sm));
        copy.lft = lft == null ? null : lft.weakClone(sm.getLocationMapper());
        copy.rgh = rgh == null ? null : rgh.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}

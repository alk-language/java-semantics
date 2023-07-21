package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.util.types.Storable;

public class BaseEquivState
   extends ExecutionState
{
    protected Storable lft;
    protected Storable rgh;

    public BaseEquivState(AST tree, ExecutionPayload executionPayload)
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
            super.handle(new AlkException("Left side of equivalence is not boolean!"));
        }
        if (rgh == null)
        {
            return request(tree.getChild(1));
        }
        if (!checkValue(rgh))
        {
            super.handle(new AlkException("Right side of equivalence is not boolean!"));
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

        return AlkBool.get(lftBool.isTrue() == rghBool.isTrue());
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

    public ExecutionState decorate(BaseEquivState copy, SplitMapper sm)
    {
        copy.lft = lft == null ? null : lft.weakClone(sm.getLocationMapper());
        copy.rgh = rgh == null ? null : rgh.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseEquivState copy = new BaseEquivState(tree, payload.clone(sm));
        copy.lft = lft == null ? null : lft.weakClone(sm.getLocationMapper());
        copy.rgh = rgh == null ? null : rgh.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}

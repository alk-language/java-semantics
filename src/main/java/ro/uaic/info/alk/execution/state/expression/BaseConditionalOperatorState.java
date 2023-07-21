package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

import static ro.uaic.info.alk.exeptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

public class BaseConditionalOperatorState
   extends ExecutionState
{
    protected Storable queryExpression;
    protected boolean checkedQuery = false;

    public BaseConditionalOperatorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (getResult() != null)
        {
            return null;
        }

        if (queryExpression == null)
        {
            if (!checkedQuery)
            {
                return request(tree.getChild(0));
            }
            else
            {
                throw new InternalException("Null value caught at ternary operator!");
            }
        }

        queryExpression = queryExpression.toRValue();
        if (!(queryExpression instanceof AlkBool))
        {
            super.handle(new AlkException(ERR_CONDITIONAL_NO_BOOL));
        }

        if (((AlkBool) queryExpression).isTrue())
        {
            return request(tree.getChild(1));
        }
        else
        {
            return request(tree.getChild(2));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (queryExpression == null)
        {
            checkedQuery = true;
            queryExpression = result.getValue();
        }
        else
        {
            setResult(new ExecutionResult(result.getValue().toRValue()));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseConditionalOperatorState copy = new BaseConditionalOperatorState(tree, payload.clone(sm));
        if (queryExpression != null)
        {
            copy.queryExpression = queryExpression.weakClone(sm.getLocationMapper());
        }
        return super.decorate(copy, sm);
    }
}

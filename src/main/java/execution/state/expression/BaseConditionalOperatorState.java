package execution.state.expression;

import ast.AST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.types.alkBool.AlkBool;
import util.exception.InternalException;
import util.types.Storable;

import static execution.parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

public class BaseConditionalOperatorState
extends ExecutionState
{
    private Storable queryExpression;
    private boolean checkedQuery = false;

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

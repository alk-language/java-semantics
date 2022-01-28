package execution.state.function;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.symbolic.SymbolicResultState;
import execution.types.AlkValue;
import execution.parser.exceptions.ReturnException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public class ReturnState
extends ExecutionState
{
    private Storable value;

    public ReturnState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (tree.getChildCount() > 0 && value == null)
        {
            return request(tree.getChild(0));
        }

        throw new ReturnException("Can't use return outside function scope.", value);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        checkNotNull(executionResult.getValue(), true);
        value = executionResult.getValue().toRValue().clone(generator);
        if (!getEnv().has(SymbolicResultState.resultName))
        {
            getEnv().define(SymbolicResultState.resultName);
        }
        getEnv().getLocation(SymbolicResultState.resultName).setValue(value);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ReturnState copy = new ReturnState(tree, payload.clone(sm));
        copy.value = value.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
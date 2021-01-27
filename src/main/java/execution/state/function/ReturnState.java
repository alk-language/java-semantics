package execution.state.function;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import execution.parser.exceptions.ReturnException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

public class ReturnState
extends ExecutionState
{
    private AlkValue value;

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
        value = (AlkValue) executionResult.getValue().toRValue().clone(generator);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ReturnState copy = new ReturnState(tree, payload.clone(sm));
        copy.value = value.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
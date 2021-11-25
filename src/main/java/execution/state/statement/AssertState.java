package execution.state.statement;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.alkBool.AlkBool;
import util.types.Storable;

public class AssertState
extends SingleState
{
    public AssertState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();

        if (value instanceof AlkBool)
        {
            if (!((AlkBool) value).isTrue())
            {
                throw new AlkException("Assert failed.");
            }
        }
        else
        {
            throw new AlkException("Assert expression doesn't evaluate to boolean.");
        }

        return new AlkBool(true);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssertState copy = new AssertState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

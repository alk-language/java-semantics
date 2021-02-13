package execution.state.expression;

import ast.AST;
import ast.enums.Operator;
import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.Storable;

public class BasePostfixOperatorState
extends SingleState
{
    private final Operator op;

    public BasePostfixOperatorState(Operator op, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
        this.op = op;
    }

    @Override
    protected Storable interpretResult(Storable value) {

        try
        {
            Storable result = value;

            if (result.toRValue() == null)
            {
                super.handle(new AlkException("Undefined variable used in postfix expression."));
            }

            switch (op)
            {
                case PLUSPLUSRIGHT:
                    result = ((AlkValue) result.toRValue()).plusplusright();
                    break;
                case MINUSMINUSRIGHT:
                    result = ((AlkValue) result.toRValue()).minusminusright();
                    break;
                default:
                    throw new InternalException("Unknown postfix operator used.");
            }

            return result;
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BasePostfixOperatorState copy = new BasePostfixOperatorState(op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }

}

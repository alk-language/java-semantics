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

public class BaseUnaryOperatorState
extends SingleState
{
    private final Operator op;

    public BaseUnaryOperatorState(Operator op, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
        this.op = op;
    }

    @Override
    protected Storable interpretResult(Storable value) {

        if (value.toRValue() == null)
        {
            super.handle(new AlkException("Undefined variable used in relational expression."));
        }

        try
        {
            AlkValue alkValue = (AlkValue) value.toRValue();
            switch (op)
            {
                case POSITIVE:
                    return alkValue.positive();
                case NEGATIVE:
                    return alkValue.negative();
                case NOT:
                    return alkValue.not();
                default:
                    throw new InternalException("Unrecognized unary operator: " + op);
            }
        }
        catch(AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseUnaryOperatorState copy = new BaseUnaryOperatorState(op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }

}

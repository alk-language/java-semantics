package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.SingleState;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

public class BaseUnaryOperatorState
   extends SingleState
{
    protected final Operator op;

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

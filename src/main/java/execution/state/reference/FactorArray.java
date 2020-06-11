package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkArray.AlkArray;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.FactorArrayContext.class)
public class FactorArray extends ExecutionState
{
    private alkParser.FactorArrayContext ctx;
    private AlkInt index;
    private Location reference;

    public FactorArray(alkParser.FactorArrayContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.factor());
        }

        if (index == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        if (reference.isUnknown())
        {
            reference.assign(new AlkArray());
        }

        try
        {
            Location loc = reference.toRValue().bracket(index.value.intValueExact(), generator);
            result = new ExecutionResult(loc);
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (reference == null)
        {
            reference = result.getValue().toLValue();
            return;
        }

        if (index == null)
        {
            Value value = result.getValue().toRValue();
            if (!(value instanceof AlkInt))
            {
                super.handle(new AlkException("Array index should be an integer."));
                return;
            }
            index = (AlkInt) value;
        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FactorArray copy = new FactorArray(ctx, sm.getPayload());
        copy.index = (AlkInt) index.weakClone(sm.getLocationMapper());
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}

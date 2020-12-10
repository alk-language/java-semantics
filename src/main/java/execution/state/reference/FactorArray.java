package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.alkInt.AlkInt;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.FactorArrayContext.class)
public class FactorArray extends ExecutionState<Value, Value>
{
    private alkParser.FactorArrayContext ctx;
    private AlkInt index;
    private Location reference;

    public FactorArray(alkParser.FactorArrayContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
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
            Location loc = ((AlkValue) reference.toRValue()).bracket(index.value.intValueExact(), generator);
            setResult(new ExecutionResult(loc));
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
            return;
        }

        if (index == null)
        {
            Value value = executionResult.getValue().toRValue();
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
        FactorArray copy = new FactorArray(ctx, sm.getExecutionPayload());
        copy.index = (AlkInt) index.weakClone(sm.getLocationMapper());
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}

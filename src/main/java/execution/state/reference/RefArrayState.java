package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

@CtxState(ctxClass = alkParser.RefArrayContext.class)
public class RefArrayState extends ExecutionState
{
    private alkParser.RefArrayContext ctx;
    private AlkInt index;
    private Location reference;

    public RefArrayState(alkParser.RefArrayContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.ref_name());
        }
        if (index == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        if (reference.isEmpty())
        {

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
                throw new AlkException("Array index should be an integer.");
            }
            index = (AlkInt) value;
        }

    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}

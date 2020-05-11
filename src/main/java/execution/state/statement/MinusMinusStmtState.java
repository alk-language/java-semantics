package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.MinusMinusStmtContext.class)
public class MinusMinusStmtState extends ExecutionState
{
    alkParser.MinusMinusStmtContext ctx;
    Location ref;

    public MinusMinusStmtState(alkParser.MinusMinusStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (ref == null)
        {
            return request(ExpressionVisitor.class, ctx.ref_name());
        }
        try
        {
            ref.toRValue().minusminusleft();
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
        ref = result.getValue().toLValue();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        MinusMinusStmtState copy = new MinusMinusStmtState(ctx, sm.getPayload());
        copy.ref = sm.getLocationMapper().get(ref);
        return super.decorate(copy, sm);
    }
}

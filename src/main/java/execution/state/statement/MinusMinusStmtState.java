package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
        ref.toRValue().minusminusleft();
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        ref = result.getValue().toLValue();
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}

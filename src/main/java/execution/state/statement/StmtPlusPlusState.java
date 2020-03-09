package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.StmtPlusPlusContext.class)
public class StmtPlusPlusState extends ExecutionState
{

    private alkParser.StmtPlusPlusContext ctx;
    private Location ref;

    public StmtPlusPlusState(alkParser.StmtPlusPlusContext ctx, Payload payload)
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
        ref.toRValue().plusplusleft();
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

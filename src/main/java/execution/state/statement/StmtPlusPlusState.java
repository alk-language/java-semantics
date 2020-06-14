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
            return request(ExpressionVisitor.class, ctx.factor());
        }
        try {
            ref.toRValue().plusplusright();
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
        StmtPlusPlusState copy = new StmtPlusPlusState(ctx, sm.getPayload());
        copy.ref = sm.getLocationMapper().get(ref);
        return super.decorate(copy, sm);
    }
}

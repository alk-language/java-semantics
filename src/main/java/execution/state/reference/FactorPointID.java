package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkStructure.AlkStructure;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.FactorPointIDContext.class)
public class FactorPointID extends ExecutionState {

    alkParser.FactorPointIDContext ctx;
    private Location reference;

    public FactorPointID(alkParser.FactorPointIDContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.factor());
        }

        if (reference.isUnknown())
        {
            reference.assign(new AlkStructure());
        }

        try
        {
            Location loc = reference.toRValue().dot(ctx.ID().toString(), generator);
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
        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FactorPointID copy = new FactorPointID(ctx, sm.getPayload());
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}

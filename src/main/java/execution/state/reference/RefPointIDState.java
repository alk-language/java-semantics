package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkArray.AlkArray;
import execution.types.alkStructure.AlkStructure;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.RefPointIDContext.class)
public class RefPointIDState extends ExecutionState {

    alkParser.RefPointIDContext ctx;
    private Location reference;

    public RefPointIDState(alkParser.RefPointIDContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.ref_name());
        }

        if (reference.isEmpty())
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
        RefPointIDState copy = new RefPointIDState(ctx, sm.getPayload());
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}

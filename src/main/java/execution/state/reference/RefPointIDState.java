package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkArray.AlkArray;
import execution.types.alkStructure.AlkStructure;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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

        Location loc = reference.toRValue().dot(ctx.ID().toString(), generator);
        result = new ExecutionResult(loc);
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
    public ExecutionState clone(Payload payload) {
        return null;
    }
}

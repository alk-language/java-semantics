package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.PlusPlusStmtContext.class)
public class PlusPlusStmtState extends ExecutionState
{

    private alkParser.PlusPlusStmtContext ctx;
    private Location ref;

    public PlusPlusStmtState(alkParser.PlusPlusStmtContext ctx, Payload payload)
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
        PlusPlusStmtState copy = new PlusPlusStmtState(ctx, payload);
        copy.ref = ref; //mapping should be done
        return super.decorate(copy);
    }
}

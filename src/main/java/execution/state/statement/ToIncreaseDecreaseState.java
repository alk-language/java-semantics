package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ToIncreaseDecreaseContext.class)
public class ToIncreaseDecreaseState extends IndependentSingleState
{

    alkParser.ToIncreaseDecreaseContext ctx;

    public ToIncreaseDecreaseState(alkParser.ToIncreaseDecreaseContext ctx, Payload payload)
    {
        super(ctx, payload, ctx.increase_decrease(), StmtVisitor.class);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ToIncreaseDecreaseState copy = new ToIncreaseDecreaseState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

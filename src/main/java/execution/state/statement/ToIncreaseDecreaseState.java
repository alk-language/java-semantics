package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToIncreaseDecreaseContext.class)
public class ToIncreaseDecreaseState extends IndependentSingleState
{

    alkParser.ToIncreaseDecreaseContext ctx;

    public ToIncreaseDecreaseState(alkParser.ToIncreaseDecreaseContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload, ctx.increase_decrease(), StmtVisitor.class);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ToIncreaseDecreaseState copy = new ToIncreaseDecreaseState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

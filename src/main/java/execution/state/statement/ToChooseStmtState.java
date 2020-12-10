package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToChooseStmtContext.class)
public class ToChooseStmtState extends IndependentSingleState
{

    public ToChooseStmtState(alkParser.ToChooseStmtContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, ctx.choose(), StmtVisitor.class);
        visitor = StmtVisitor.class;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToChooseStmtState copy = new ToChooseStmtState((alkParser.ToChooseStmtContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

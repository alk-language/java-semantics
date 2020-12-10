package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToForEachContext.class)
public class ToForAllState extends IndependentSingleState
{
    public ToForAllState(alkParser.ToForEachContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.foreach_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToForAllState copy = new ToForAllState((alkParser.ToForEachContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToAssignmentStmtContext.class)
public class ToAssignmentStmtState extends IndependentSingleState
{
    public ToAssignmentStmtState(alkParser.ToAssignmentStmtContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.assignment(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToAssignmentStmtState copy = new ToAssignmentStmtState((alkParser.ToAssignmentStmtContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }

}

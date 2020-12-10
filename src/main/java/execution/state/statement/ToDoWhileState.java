package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToDoWhileContext.class)
public class ToDoWhileState extends IndependentSingleState
{
    public ToDoWhileState(alkParser.ToDoWhileContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.do_while_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToDoWhileState copy = new ToDoWhileState((alkParser.ToDoWhileContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

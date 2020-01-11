package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToDoWhileContext.class)
public class ToDoWhileState extends IndependentSingleState
{
    public ToDoWhileState(alkParser.ToDoWhileContext tree, Payload payload)
    {
        super(tree, payload, tree.do_while_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ToDoWhileState copy = new ToDoWhileState((alkParser.ToDoWhileContext) tree, payload);
        return super.decorate(copy);
    }
}

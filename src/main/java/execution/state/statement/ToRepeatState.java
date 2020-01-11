package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToRepeatContext.class)
public class ToRepeatState extends IndependentSingleState
{
    public ToRepeatState(alkParser.ToRepeatContext tree, Payload payload)
    {
        super(tree, payload, tree.repeat_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ToRepeatState copy = new ToRepeatState((alkParser.ToRepeatContext) tree, payload);
        return super.decorate(copy);
    }
}
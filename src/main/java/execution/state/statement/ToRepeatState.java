package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ToRepeatContext.class)
public class ToRepeatState extends IndependentSingleState
{
    public ToRepeatState(alkParser.ToRepeatContext tree, Payload payload)
    {
        super(tree, payload, tree.repeat_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToRepeatState copy = new ToRepeatState((alkParser.ToRepeatContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
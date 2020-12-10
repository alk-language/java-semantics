package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToRepeatContext.class)
public class ToRepeatState extends IndependentSingleState
{
    public ToRepeatState(alkParser.ToRepeatContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.repeat_struct(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToRepeatState copy = new ToRepeatState((alkParser.ToRepeatContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
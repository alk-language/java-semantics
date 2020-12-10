package execution.state.main;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.MainVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.StartPointContext.class)
public class MainState extends IndependentSingleState
{
    public MainState(alkParser.StartPointContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.statement_sequence(), MainVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        MainState copy = new MainState((alkParser.StartPointContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.init;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import grammar.alkParser;
import execution.parser.visitors.InitVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;


@CtxState(ctxClass = alkParser.VarSeqContext.class)
public class VarSeqState extends IndependentGeneratorState {
    public VarSeqState(alkParser.VarSeqContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.variable(), InitVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        return null;
    }
}

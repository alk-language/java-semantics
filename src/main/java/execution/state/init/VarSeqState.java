package execution.state.init;

import execution.state.ExecutionState;
import execution.state.IndependentGeneratorState;
import grammar.alkParser;
import parser.visitors.InitVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;


@CtxState(ctxClass = alkParser.VarSeqContext.class)
public class VarSeqState extends IndependentGeneratorState {
    public VarSeqState(alkParser.VarSeqContext tree, Payload payload) {
        super(tree, payload, tree.variable(), InitVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        return null;
    }
}

package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.BlockContext.class)
public class BlockState extends IndependentSingleState
{

    private alkParser.BlockContext ctx;

    public BlockState(alkParser.BlockContext tree, Payload payload)
    {
        super(tree, payload, tree.statement_sequence(), StmtVisitor.class);
        ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BlockState copy = new BlockState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

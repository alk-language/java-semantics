package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

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
    public ExecutionState clone(Payload payload)
    {
        BlockState copy = new BlockState(ctx, payload);
        return super.decorate(copy);
    }
}

package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.BlockContext.class)
public class BlockState extends IndependentSingleState
{

    private alkParser.BlockContext ctx;

    public BlockState(alkParser.BlockContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.statement_sequence(), StmtVisitor.class);
        ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BlockState copy = new BlockState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

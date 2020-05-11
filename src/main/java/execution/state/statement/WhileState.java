package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.WhileStructureContext.class)
public class WhileState extends LoopingState
{
    private alkParser.WhileStructureContext ctx;

    public WhileState(alkParser.WhileStructureContext tree, Payload payload)
    {
        super(tree, payload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        WhileState copy = new WhileState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

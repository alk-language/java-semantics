package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.DoWhileStructureContext.class)
public class DoWhileState extends FinalCheckLoopingState
{
    private alkParser.DoWhileStructureContext ctx;

    public DoWhileState(alkParser.DoWhileStructureContext tree, Payload payload)
    {
        super(tree, payload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        DoWhileState copy = new DoWhileState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}
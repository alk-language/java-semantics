package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.RepeatStructureContext.class)
public class RepeatUntilState extends FinalCheckLoopingState
{
    private alkParser.RepeatStructureContext ctx;

    public RepeatUntilState(alkParser.RepeatStructureContext tree, Payload payload)
    {
        super(tree, payload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RepeatUntilState copy = new RepeatUntilState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }

    @Override
    protected boolean processValidity(boolean validCondition)
    {
        return !validCondition;
    }
}
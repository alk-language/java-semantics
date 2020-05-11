package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ForStructureContext.class)
public class ForState extends LoopingState
{
    private alkParser.ForStructureContext ctx;
    private boolean visitedStart = false;
    private boolean incrementalStep = false;
    private boolean incrementing = false;

    public ForState(alkParser.ForStructureContext tree, Payload payload)
    {
        super(tree, payload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }
        if (!visitedStart)
        {
            return request(StmtVisitor.class, ctx.start_assignment());
        }

        if (incrementalStep)
        {
            incrementalStep = false;
            incrementing = true;
            if (ctx.assignment() != null)
                return request(StmtVisitor.class, ctx.assignment());
            else
                return request(StmtVisitor.class, ctx.increase_decrease());
        }
        else
        {
            if (checkedCondition)
            {
                incrementalStep = true;
            }
            return super.makeStep();
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (!visitedStart)
        {
            visitedStart = true;
            return;
        }

        if (incrementing)
            incrementing = false;
        else
            super.assign(result);
    }


    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ForState copy = new ForState(ctx, sm.getPayload());
        copy.visitedStart = visitedStart;
        copy.incrementalStep = incrementalStep;
        copy.incrementing = incrementing;
        return super.decorate(copy, sm);
    }
}
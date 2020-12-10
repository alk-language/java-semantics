package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ForStructureContext.class)
public class ForState extends LoopingState
{
    private alkParser.ForStructureContext ctx;
    private boolean visitedStart = false;
    private boolean incrementalStep = false;
    private boolean incrementing = false;

    public ForState(alkParser.ForStructureContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (ctx.start_assignment() != null && !visitedStart)
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
    public void assign(ExecutionResult executionResult)
    {
        if (!visitedStart)
        {
            visitedStart = true;
            return;
        }

        if (incrementing)
            incrementing = false;
        else
            super.assign(executionResult);
    }


    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ForState copy = new ForState(ctx, sm.getExecutionPayload());
        copy.visitedStart = visitedStart;
        copy.incrementalStep = incrementalStep;
        copy.incrementing = incrementing;
        return super.decorate(copy, sm);
    }
}
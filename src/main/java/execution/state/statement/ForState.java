package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
    public ExecutionState clone(Payload payload)
    {
        ForState copy = new ForState(ctx, payload);
        copy.visitedStart = visitedStart;
        copy.incrementalStep = incrementalStep;
        copy.incrementing = incrementing;
        return super.decorate(copy);
    }
}

/*if (returnValue != null || breakFlag || continueFlag) return null;
        if (ctx.start_assignment()!=null)
            visit(ctx.start_assignment());

        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_FOR_NOT_BOOL);
            e.printException(ctx.start.getLine());
            return null;
        }
        loopLevel++;
        breakFlag = continueFlag = false;
        while (((AlkBool)value).getValue())
        {
            visit(ctx.statement());
            continueFlag = false;
            if (returnValue != null || breakFlag)
            {
                breakFlag = false;
                loopLevel--;
                return null;
            }

            if (ctx.assignment()!=null)
                visit(ctx.assignment());
            else
                visit(ctx.increase_decrease());

            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_FOR_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        }
        loopLevel--;
        return null;*/
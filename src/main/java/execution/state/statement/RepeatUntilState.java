package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
    public ExecutionState clone(Payload payload)
    {
        RepeatUntilState copy = new RepeatUntilState(ctx, payload);
        return super.decorate(copy);
    }

    @Override
    protected boolean processValidity(boolean validCondition)
    {
        return !validCondition;
    }
}

/*
        if (returnValue != null || breakFlag || continueFlag) return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value;
        loopLevel++;
        breakFlag = continueFlag = false;
        do
        {
            visit(ctx.statement());
            continueFlag = false;
            if (returnValue != null || breakFlag)
            {
                breakFlag = false;
                loopLevel--;
                return 0;
            }

            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_DOWHILE_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        } while (((AlkBool)value).getValue());
        loopLevel--;
        return null;*/
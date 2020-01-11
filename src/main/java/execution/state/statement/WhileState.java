package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
    public ExecutionState clone(Payload payload)
    {
        WhileState copy = new WhileState(ctx, payload);
        return super.decorate(copy);
    }
}

/*
        if (returnValue != null || breakFlag || continueFlag)
            return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_WHILE_NOT_BOOL);
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
            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_WHILE_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        }
        loopLevel--;
        return null;*/
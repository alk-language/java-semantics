package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

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
    public ExecutionState clone(Payload payload)
    {
        DoWhileState copy = new DoWhileState(ctx, payload);
        return super.decorate(copy);
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
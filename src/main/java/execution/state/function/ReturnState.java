package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.exceptions.ReturnException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

@CtxState(ctxClass = alkParser.ReturnStmtContext.class)
public class ReturnState extends ExecutionState
{
    alkParser.ReturnStmtContext ctx;
    AlkValue value;

    public ReturnState(alkParser.ReturnStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (ctx.expression() != null && value == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        throw new ReturnException("Can't use return without scope.", value);
    }

    @Override
    public void assign(ExecutionResult result)
    {
        value = ((AlkValue)result.getValue().toRValue()).clone(generator);
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}

/*
        if (returnValue != null || breakFlag || continueFlag) return null;
        if (!inFunction)
        {
            AlkException e = new AlkException(ERR_RETURN);
            e.printException(ctx.start.getLine());
            return null;
        }
        if (ctx.expression() == null)
        {
            returnValue = new AlkNotAValue(NO_RETURN);
        }
        else
        {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
            returnValue = (AlkValue) expressionVisitor.visit(ctx.expression());
        }
        return null;*/
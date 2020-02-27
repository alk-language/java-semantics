package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

import static parser.exceptions.AlkException.ERR_IF_NOT_BOOL;

@CtxState(ctxClass = alkParser.IfStructureContext.class)
public class IfStmtState extends ExecutionState {

    private alkParser.IfStructureContext ctx;
    private AlkBool condition;
    private boolean executed = false;

    public IfStmtState(alkParser.IfStructureContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (executed)
        {
            return null;
        }

        if (condition == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        executed = true;
        if (condition.isTrue())
        {
            return request(StmtVisitor.class, ctx.statement(0));
        }
        else
        {
            if (ctx.statement().size() > 1)
            {
                return request(StmtVisitor.class, ctx.statement(1));
            }
            else
            {
                return null;
            }
        }
    }

    @Override
    public void assign(ExecutionResult result) {
        if (condition == null)
        {
            Value value = result.getValue();
            if (!(value instanceof AlkBool))
            {
                throw new AlkException(ERR_IF_NOT_BOOL);
            }

            condition = (AlkBool) value;
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        IfStmtState copy = new IfStmtState(ctx, payload);
        copy.condition = (AlkBool) condition.clone();
        copy.executed = executed;
        return super.decorate(copy);
    }
}

/*
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {

            AlkException e = new AlkException(ERR_IF_NOT_BOOL);
            e.printException(ctx.start.getLine());
            return null;
        }
        if (((AlkBool)value).getValue())
            return visit(ctx.statement(0));
        else
        {
            if (ctx.statement().size()>1)
            {
                return visit(ctx.statement(1));
            }
        }
        return null;
*/
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
import util.SplitMapper;
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
            Value value = result.getValue().toRValue();
            if (!(value instanceof AlkBool))
            {
                super.handle(new AlkException(ERR_IF_NOT_BOOL));
            }

            condition = (AlkBool) value;
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IfStmtState copy = new IfStmtState(ctx, sm.getPayload());
        copy.condition = (AlkBool) condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        return super.decorate(copy, sm);
    }
}
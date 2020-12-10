package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import static execution.parser.exceptions.AlkException.ERR_IF_NOT_BOOL;

@CtxState(ctxClass = alkParser.IfStructureContext.class)
public class IfStmtState extends ExecutionState<Value, Value> {

    private alkParser.IfStructureContext ctx;
    private AlkBool condition;
    private boolean executed = false;

    public IfStmtState(alkParser.IfStructureContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
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
    public void assign(ExecutionResult executionResult) {
        if (condition == null)
        {
            Value value = executionResult.getValue().toRValue();
            if (!(value instanceof AlkBool))
            {
                super.handle(new AlkException(ERR_IF_NOT_BOOL));
            }

            condition = (AlkBool) value;
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IfStmtState copy = new IfStmtState(ctx, sm.getExecutionPayload());
        copy.condition = (AlkBool) condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        return super.decorate(copy, sm);
    }
}
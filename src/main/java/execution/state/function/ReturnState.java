package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.exceptions.ReturnException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.ReturnStmtContext.class)
public class ReturnState extends ExecutionState<Value, Value>
{
    alkParser.ReturnStmtContext ctx;
    AlkValue value;

    public ReturnState(alkParser.ReturnStmtContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
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
    public void assign(ExecutionResult executionResult)
    {
        value = (AlkValue) executionResult.getValue().toRValue().clone(generator);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ReturnState copy = new ReturnState(ctx, sm.getExecutionPayload());
        copy.value = value.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
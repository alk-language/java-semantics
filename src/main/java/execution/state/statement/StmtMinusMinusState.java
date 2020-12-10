package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.StmtMinusMinusContext.class)
public class StmtMinusMinusState extends ExecutionState<Value, Value>
{
    private alkParser.StmtMinusMinusContext ctx;
    private Location ref;

    public StmtMinusMinusState(alkParser.StmtMinusMinusContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (ref == null)
        {
            return request(ExpressionVisitor.class, ctx.factor());
        }
        try {
            ((AlkValue) ref.toRValue()).minusminusright();
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        ref = executionResult.getValue().toLValue();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        StmtMinusMinusState copy = new StmtMinusMinusState(ctx, sm.getExecutionPayload());
        copy.ref = sm.getLocationMapper().get(ref);
        return super.decorate(copy, sm);
    }
}

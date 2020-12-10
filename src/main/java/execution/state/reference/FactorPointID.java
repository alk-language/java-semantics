package execution.state.reference;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import execution.types.alkStructure.AlkStructure;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.FactorPointIDContext.class)
public class FactorPointID extends ExecutionState<Value, Value>
{

    alkParser.FactorPointIDContext ctx;
    private Location reference;

    public FactorPointID(alkParser.FactorPointIDContext ctx, ExecutionPayload executionPayload)
    {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (reference == null)
        {
            return request(ExpressionVisitor.class, ctx.factor());
        }

        if (reference.isUnknown())
        {
            reference.assign(new AlkStructure());
        }

        try
        {
            Location loc = ((AlkValue) reference.toRValue()).dot(ctx.ID().toString(), generator);
            setResult(new ExecutionResult(loc));
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
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FactorPointID copy = new FactorPointID(ctx, sm.getExecutionPayload());
        copy.reference = sm.getLocationMapper().get(reference);
        return super.decorate(copy, sm);
    }
}

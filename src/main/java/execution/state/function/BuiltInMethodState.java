package execution.state.function;

import ast.CtxState;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import util.*;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

@CtxState(ctxClass = alkParser.BuiltinMethodContext.class)
public class BuiltInMethodState extends GeneratorState<Location, Value>
{
    private alkParser.BuiltinMethodContext ctx;
    private Location loc;
    private String methodName;
    private List<AlkValue> params = new ArrayList<>();

    public BuiltInMethodState(alkParser.BuiltinMethodContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload, ctx.expression(), ExpressionVisitor.class);
        this.ctx = ctx;
        this.loc = (Location) executionPayload.getValue();
        this.methodName = ctx.method_name().getText();
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        params.add((AlkValue) executionResult.getValue().toRValue());
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BuiltInMethodState copy = new BuiltInMethodState(ctx, sm.getExecutionPayload());
        copy.loc = sm.getLocationMapper().get(this.loc);
        copy.methodName = methodName;
        for (AlkValue value : params)
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        return super.decorate(copy, sm);
    }

    @Override
    public Location getFinalResult()
    {
        try {
            return (Location) Invoker.invokeMethod(methodName, loc, params, generator);
        }
        catch (AlkException e) {
            super.handle(new AlkException(ctx.start.getLine(), e.getMessage()));
        }
        return null;
    }
}

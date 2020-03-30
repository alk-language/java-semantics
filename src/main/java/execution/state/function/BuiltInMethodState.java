package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkValue;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.env.Store;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Invoker;
import util.NameMapper;
import util.Payload;
import util.exception.InternalException;
import util.functions.BuiltInFunction;
import util.functions.BuiltInMethod;
import util.functions.Functions;
import util.functions.Methods;
import util.lambda.LocationGenerator;
import util.types.Value;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;
import static parser.exceptions.AlkException.ERR_PARAM_NUMBER;

@CtxState(ctxClass = alkParser.BuiltinMethodContext.class)
public class BuiltInMethodState extends GeneratorState<Location, Value>
{
    private alkParser.BuiltinMethodContext ctx;
    private Location loc;
    private String methodName;
    private List<AlkValue> params = new ArrayList<>();

    public BuiltInMethodState(alkParser.BuiltinMethodContext ctx, Payload payload) {
        super(ctx, payload, ctx.expression(), ExpressionVisitor.class);
        this.ctx = ctx;
        this.loc = (Location) payload.getValue();
        this.methodName = ctx.method_name().getText();
    }

    @Override
    public void assign(ExecutionResult<Value> result)
    {
        params.add((AlkValue)result.getValue().toRValue());
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        Store store = payload.getExecution().getStore();
        BuiltInMethodState copy = new BuiltInMethodState(ctx, payload);
        copy.loc = loc; // this should be mapped
        copy.methodName = methodName;
        for (AlkValue value : params)
            copy.params.add(value.clone(store));
        return super.decorate(copy);
    }

    @Override
    public Location getFinalResult()
    {
        try {
            return (Location) Invoker.invokeMethod(methodName, loc, params, generator);
        }
        catch (AlkException e) {
            throw new AlkException(ctx.start.getLine(), e.getMessage());
        }
    }
}

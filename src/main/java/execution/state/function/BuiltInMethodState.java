package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.AlkValue;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.NameMapper;
import util.Payload;
import util.exception.InternalException;
import util.functions.BuiltInFunction;
import util.functions.BuiltInMethod;
import util.functions.Functions;
import util.functions.Methods;
import util.lambda.LocationGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;
import static parser.exceptions.AlkException.ERR_PARAM_NUMBER;

@CtxState(ctxClass = alkParser.BuiltinMethodContext.class)
public class BuiltInMethodState extends GeneratorState<Location, AlkValue>
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
    public void assign(ExecutionResult<AlkValue> result)
    {
        params.add(result.getValue());
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }

    @Override
    public Location getFinalResult()
    {
        try
        {
            methodName = NameMapper.processBuiltInName(methodName);
            Method method = Methods.class.getMethod(methodName, Location.class, List.class, LocationGenerator.class);

            if (method.getAnnotation(BuiltInMethod.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated method.");

            if (method.getAnnotation(BuiltInMethod.class).paramNumber() != params.size())
                throw new AlkException(ERR_PARAM_NUMBER);

            return (Location) method.invoke(null, loc, params, generator);
        } catch (NoSuchMethodException e) {
            throw new AlkException(ERR_FUNCTION_UNDEFINED);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalException(e);
        }
    }
}

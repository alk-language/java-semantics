package execution.state.function;

import execution.ExecutionResult;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.function.FunctionCallVisitor;
import util.NameMapper;
import util.exception.InternalException;
import util.functions.BuiltInFunction;
import util.functions.Functions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;
import static parser.exceptions.AlkException.ERR_PARAM_NUMBER;

public class BuiltInMethodState extends GeneratorState<AlkValue, AlkValue>
{
    private List<AlkValue> params = new ArrayList<>();

    private String functionName;

    public BuiltInMethodState(alkParser.BuiltinMethodContext tree, FunctionCallVisitor visitor) {
        super(tree, new ExpressionVisitor(visitor.getEnvironment()), tree.expression());
        functionName = tree.method_name().getText();
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        params.add(result.getValue());
    }

    @Override
    public AlkValue getFinalResult()
    {
        try
        {
            functionName = NameMapper.processBuiltInName(functionName);
            Method method = Functions.class.getMethod(functionName, List.class);

            if (method.getAnnotation(BuiltInFunction.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated function.");

            if (method.getAnnotation(BuiltInFunction.class).paramNumber() != params.size())
                throw new AlkException(ERR_PARAM_NUMBER);

            return (AlkValue) method.invoke(null, params);
        } catch (NoSuchMethodException e) {
            throw new AlkException(ERR_FUNCTION_UNDEFINED);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalException(e);
        }
    }
}
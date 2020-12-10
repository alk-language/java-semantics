package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.exhaustive.NameMapper;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.functions.BuiltInFunction;
import util.functions.Functions;
import util.types.Value;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;
import static execution.parser.exceptions.AlkException.ERR_PARAM_NUMBER;

@CtxState(ctxClass = alkParser.BuiltinFunctionContext.class)
public class BuiltInFunctionState extends GeneratorState<AlkValue, Value>
{
    private List<AlkValue> params = new ArrayList<>();
    private String functionName;
    private Functions functions;

    public BuiltInFunctionState(alkParser.BuiltinFunctionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.expression(), ExpressionVisitor.class);
        functionName = tree.function_name().getText();
        functions = new Functions(executionPayload.getConfiguration(), generator);
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        params.add((AlkValue) executionResult.getValue().toRValue());
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

            return (AlkValue) method.invoke(functions, params);
        } catch (NoSuchMethodException e) {
            super.handle(new AlkException(ERR_FUNCTION_UNDEFINED));
        }
        catch (IllegalAccessException | InvocationTargetException e )
        {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                super.handle((AlkException) cause);
            throw new InternalException((Exception) e.getCause());
        }
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {

        BuiltInFunctionState copy = new BuiltInFunctionState((alkParser.BuiltinFunctionContext) tree, sm.getExecutionPayload());

        for (AlkValue value : this.params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        copy.functionName = functionName;

        return super.decorate(copy, sm);
    }
}
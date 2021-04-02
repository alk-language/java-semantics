package execution.state.function;

import ast.AST;
import ast.attr.BuiltInFunctionASTAttr;
import ast.enums.BuiltInFunction;
import execution.ExecutionResult;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.exhaustive.NameMapper;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.types.alkNotAValue.AlkNotAValue;
import util.exception.InternalException;
import util.functions.BuiltInFunctionImpl;
import util.functions.Functions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_PARAM_NUMBER;

public class BuiltInFunctionState
extends GeneratorState
{
    private final List<AlkValue> params = new ArrayList<>();
    private final BuiltInFunction function;
    private final Functions functions;

    public BuiltInFunctionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        function = tree.getAttribute(BuiltInFunctionASTAttr.class).getFunction();
        functions = new Functions(executionPayload.getConfiguration(), generator);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        checkNotNull(executionResult.getValue());
        params.add((AlkValue) executionResult.getValue().toRValue());
    }

    @Override
    public AlkValue getFinalResult()
    {
        String functionName = NameMapper.processBuiltInName(function.toString());
        try
        {
            Method method = Functions.class.getMethod(functionName, List.class);

            if (method.getAnnotation(BuiltInFunctionImpl.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated function.");

            if (method.getAnnotation(BuiltInFunctionImpl.class).paramNumber() != params.size())
                throw new AlkException(ERR_PARAM_NUMBER);

            return (AlkValue) method.invoke(functions, params);
        }
        catch (NoSuchMethodException e)
        {
            super.handle(new NoSuchFunctionException(functionName));
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

        BuiltInFunctionState copy = new BuiltInFunctionState(tree, payload.clone(sm));
        for (AlkValue value : this.params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }
}
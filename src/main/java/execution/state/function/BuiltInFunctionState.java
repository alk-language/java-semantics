package execution.state.function;

import ast.AST;
import ast.attr.BuiltInFunctionASTAttr;
import ast.enums.BuiltInFunction;
import execution.ExecutionResult;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.parser.exceptions.AlkException;
import execution.exhaustive.NameMapper;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.FunctionsSolver;
import util.exception.InternalException;
import util.functions.BuiltInFunctionImpl;
import util.functions.Functions;
import util.types.Storable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_PARAM_NUMBER;

public class BuiltInFunctionState
extends GeneratorState
{
    protected final List<Storable> params = new ArrayList<>();
    protected final BuiltInFunction function;
    protected final Functions functions;
    protected FunctionsSolver fSolver;

    public BuiltInFunctionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        function = tree.getAttribute(BuiltInFunctionASTAttr.class).getFunction();
        functions = new Functions(executionPayload.getConfiguration(), generator);
    }

    public BuiltInFunctionState(BuiltInFunctionState copy, SplitMapper sm)
    {
        super(copy, sm);
        for (Storable value : this.params)
        {
            params.add(value.weakClone(sm.getLocationMapper()));
        }
        this.function = copy.function;
        functions = new Functions(payload.getConfiguration(), generator);
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        checkNotNull(executionResult.getValue());
        params.add(executionResult.getValue().toRValue());
    }

    protected void setDefaultSolver()
    {
        fSolver = (functionName) ->
        {
            try
            {
                return Functions.class.getMethod(functionName, List.class);
            }
            catch (NoSuchMethodException e)
            {
                super.handle(new NoSuchFunctionException(functionName));
            }
            return null;
        };
    }

    @Override
    public Storable getFinalResult()
    {
        String functionName = NameMapper.processBuiltInName(function.toString());
        try
        {
            if (fSolver == null)
            {
                setDefaultSolver();
            }
            Method method = fSolver.solve(functionName);

            if (method.getAnnotation(BuiltInFunctionImpl.class) == null)
                throw new InternalException("Reflection is calling upon a not built-in annotated function.");

            if (method.getAnnotation(BuiltInFunctionImpl.class).paramNumber() != params.size())
                super.handle(new AlkException(ERR_PARAM_NUMBER));

            return (Storable) method.invoke(functions, params);
        }
        catch (IllegalAccessException | InvocationTargetException e )
        {
            Exception cause = (Exception) e.getCause();
            if (cause instanceof AlkException)
                super.handle((AlkException) cause);
            throw new InternalException((Exception) e.getCause());
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {

        BuiltInFunctionState copy = new BuiltInFunctionState(tree, payload.clone(sm));
        for (Storable value : this.params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }
}
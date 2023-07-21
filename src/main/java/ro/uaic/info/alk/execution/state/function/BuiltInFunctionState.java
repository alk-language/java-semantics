package ro.uaic.info.alk.execution.state.function;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInFunctionASTAttr;
import ro.uaic.info.alk.enums.AlkBuiltInFunction;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.GeneratorState;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.exhaustive.NameMapper;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.FunctionsSolver;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.functions.BuiltInFunctionImpl;
import ro.uaic.info.alk.util.functions.FunctionsIface;
import ro.uaic.info.alk.util.functions.Functions;
import ro.uaic.info.alk.util.types.Storable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static ro.uaic.info.alk.exeptions.AlkException.ERR_PARAM_NUMBER;

public class BuiltInFunctionState
extends GeneratorState
{
    protected final List<Storable> params = new ArrayList<>();
    protected final AlkBuiltInFunction function;
    protected FunctionsIface functions;
    protected FunctionsSolver fSolver;

    public BuiltInFunctionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        function = tree.getAttribute(BuiltInFunctionASTAttr.class).getFunction();
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        checkNotNull(executionResult.getValue(), true);
        params.add(executionResult.getValue().toRValue());
    }

    protected void setDefaultSolver()
    {
        functions = new Functions(payload.getConfiguration(), generator);
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

    public ExecutionState decorate(BuiltInFunctionState copy, SplitMapper sm)
    {
        for (Storable value : this.params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
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
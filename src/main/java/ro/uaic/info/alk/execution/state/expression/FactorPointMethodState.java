package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInMethodASTAttr;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.GeneratorState;
import ro.uaic.info.alk.util.FunctionsSolver;
import ro.uaic.info.alk.util.Invoker;
import ro.uaic.info.alk.util.functions.Methods;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class FactorPointMethodState
   extends GeneratorState
{
    protected final List<Storable> params = new ArrayList<>();
    protected final String methodName;
    protected Location reference;
    protected FunctionsSolver methodSolver;

    public FactorPointMethodState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.methodName = tree.getAttribute(BuiltInMethodASTAttr.class).getMethod().toString();
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (reference == null)
        {
            reference = executionResult.getValue().toLValue();
        }
        else
        {
            params.add(executionResult.getValue().toRValue());
        }
    }

    protected void setMethodSolver()
    {
        methodSolver = (methodName) ->
        {
            try
            {
                return Methods.class.getMethod(methodName, Location.class, List.class, LocationGenerator.class);
            }
            catch (NoSuchMethodException e)
            {
                super.handle(new NoSuchFunctionException(methodName));
            }
            return null;
        };
    }

    @Override
    public Storable getFinalResult()
    {
        try
        {
            if (methodSolver == null)
            {
                setMethodSolver();
            }
            return Invoker.invokeMethod(methodName, reference, params, generator, methodSolver, getExec());
        }
        catch (AlkException e)
        {
            super.handle(new AlkException(e.getMessage()));
        }
        return null;
    }

    public ExecutionState decorate(FactorPointMethodState copy, SplitMapper sm)
    {
        copy.reference = sm.getLocationMapper().get(reference);
        for (Storable value : params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FactorPointMethodState copy = new FactorPointMethodState(tree, payload.clone(sm));
        copy.reference = sm.getLocationMapper().get(reference);
        for (Storable value : params)
        {
            copy.params.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }
}

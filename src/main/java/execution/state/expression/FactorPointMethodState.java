package execution.state.expression;

import ast.AST;
import ast.attr.BuiltInMethodASTAttr;
import execution.ExecutionResult;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.parser.env.Location;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.GeneratorState;
import util.FunctionsSolver;
import util.Invoker;
import util.exception.InternalException;
import util.functions.Methods;
import util.lambda.LocationGenerator;
import util.types.Storable;

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
    public Location getFinalResult()
    {
        try
        {
            if (methodSolver == null)
            {
                setMethodSolver();
            }
            return (Location) Invoker.invokeMethod(methodName, reference, params, generator, methodSolver);
        }
        catch (AlkException e)
        {
            super.handle(new AlkException(e.getMessage()));
        }
        return null;
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

package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.FactorPointMethodState;
import ro.uaic.info.alk.symbolic.ExclusiveSymbolicValue;
import ro.uaic.info.alk.util.functions.SymbolicMethods;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class SymbolicFactorPointMethodState
   extends FactorPointMethodState
{
    public SymbolicFactorPointMethodState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected void setMethodSolver()
    {
        boolean symbolic = false;
        for (Storable value : params)
        {
            if (value instanceof ExclusiveSymbolicValue)
            {
                symbolic = true;
                break;
            }
        }
        if (reference.toRValue() instanceof ExclusiveSymbolicValue)
        {
            symbolic = true;
        }
        if (symbolic)
        {
            methodSolver = (methodName) ->
            {
                try
                {
                    return SymbolicMethods.class.getMethod(methodName, Location.class, List.class, LocationGenerator.class);
                }
                catch (NoSuchMethodException e)
                {
                    // maybe it is a stateful method
                    try
                    {
                        return SymbolicMethods.class.getMethod(methodName, Location.class, List.class, LocationGenerator.class,
                                AlkExecution.class);
                    }
                    catch (NoSuchMethodException noSuchMethodException)
                    {
                        super.handle(new NoSuchFunctionException(methodName));
                    }
                }
                return null;
            };
        }
        else
        {
            super.setMethodSolver();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicFactorPointMethodState copy = new SymbolicFactorPointMethodState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

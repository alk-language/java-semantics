package execution.state.symbolic;

import ast.AST;
import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.state.expression.FactorPointMethodState;
import symbolic.ExclusiveSymbolicValue;
import util.functions.SymbolicMethods;
import util.lambda.LocationGenerator;
import util.types.Storable;

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
                                Execution.class);
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

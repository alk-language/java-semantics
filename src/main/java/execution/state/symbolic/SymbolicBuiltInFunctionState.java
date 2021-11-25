package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.NoSuchFunctionException;
import execution.state.ExecutionState;
import execution.state.function.BuiltInFunctionState;
import symbolic.ExclusiveSymbolicValue;
import util.functions.Functions;
import util.functions.SymbolicFunctions;
import util.types.Storable;

import java.util.List;

public class SymbolicBuiltInFunctionState
extends BuiltInFunctionState
{
    public SymbolicBuiltInFunctionState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected void setDefaultSolver()
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

        if (symbolic)
        {
            functions = new SymbolicFunctions(payload.getConfiguration(), generator);
            fSolver = (functionName) ->
            {
                try
                {
                    return SymbolicFunctions.class.getMethod(functionName, List.class);
                }
                catch (NoSuchMethodException e)
                {
                    super.handle(new NoSuchFunctionException(functionName));
                }
                return null;
            };
        }
        else
        {
            super.setDefaultSolver();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicBuiltInFunctionState copy = new SymbolicBuiltInFunctionState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

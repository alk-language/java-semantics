package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.NoSuchFunctionException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.function.BuiltInFunctionState;
import ro.uaic.info.alk.symbolic.ExclusiveSymbolicValue;
import ro.uaic.info.alk.util.functions.SymbolicFunctions;
import ro.uaic.info.alk.util.types.Storable;

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

package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import util.types.Storable;

public class SymbolicResultState
extends PrimitiveState
{
    public static final String resultName = "[result]";

    public SymbolicResultState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        if (!getEnv().has(resultName))
        {
            super.handle(new AlkException("Invalid use of result context variable!"));
        }
        return getEnv().getLocation(resultName);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return null;
    }
}
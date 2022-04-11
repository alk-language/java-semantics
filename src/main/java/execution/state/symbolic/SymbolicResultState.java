package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.state.function.*;
import util.types.Storable;

public class SymbolicResultState
extends ResultState
{
    public SymbolicResultState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicResultState copy = new SymbolicResultState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

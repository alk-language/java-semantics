package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import execution.state.function.*;
import util.types.Storable;

public class SymbolicOldState
extends OldState
{
    public SymbolicOldState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicOldState copy = new SymbolicOldState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

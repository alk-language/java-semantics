package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.attr.TypeASTAttr;
import ast.type.DataTypeAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import util.types.Storable;

public class SymbolicIdDeclState
extends PrimitiveState
{
    public SymbolicIdDeclState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        String symId = tree.getAttribute(IdASTAttr.class).getId();
        AST type = tree.getChild(0);
        getExec().getPathCondition().setType(symId, (DataTypeAST) type, true);
        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicIdDeclState copy = new SymbolicIdDeclState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

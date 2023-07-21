package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.util.types.Storable;

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

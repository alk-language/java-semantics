package execution.state.symbolic;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import util.types.Storable;

public class SymbolicOldState
extends PrimitiveState
{
    public static final String oldName = "\\old";

    public SymbolicOldState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable requireResult()
    {
        String varName = oldName + "(" + tree.getAttribute(IdASTAttr.class).getId() + ")";
        if (!getEnv().has(varName))
        {
            super.handle(new AlkException("Invalid use of " + varName + " context variable: " +
                    "\\old should be used in a post-condition!"));
        }
        return getEnv().getLocation(varName);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicResultState copy = new SymbolicResultState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

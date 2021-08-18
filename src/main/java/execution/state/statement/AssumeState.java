package execution.state.statement;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.types.alkBool.AlkBool;
import util.types.Storable;

public class AssumeState
extends SingleState
{
    public AssumeState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        return new AlkBool(true);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssumeState copy = new AssumeState(tree, payload);
        return super.decorate(copy, sm);
    }

}

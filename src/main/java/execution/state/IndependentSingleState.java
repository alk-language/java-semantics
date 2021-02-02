package execution.state;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public abstract class IndependentSingleState extends SingleState
{

    public IndependentSingleState(AST tree, ExecutionPayload executionPayload, AST dependency) {
        super(tree, executionPayload, dependency);
    }

    @Override
    protected Storable interpretResult(Storable value) {
        return null;
    }

    protected IndependentSingleState decorate(IndependentSingleState copy, SplitMapper sm)
    {
        return (IndependentSingleState) super.decorate(copy, sm);
    }
}

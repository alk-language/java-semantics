package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

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

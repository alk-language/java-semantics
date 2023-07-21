package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

public abstract class GatewaySingleState extends SingleState {

    public GatewaySingleState(AST tree, ExecutionPayload executionPayload, AST dependency) {
        super(tree, executionPayload, dependency);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        return value;
    }

    protected GatewaySingleState decorate(GatewaySingleState copy, SplitMapper sm)
    {
        return (GatewaySingleState) super.decorate(copy, sm);
    }
}

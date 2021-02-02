package execution.state;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

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

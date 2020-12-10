package execution.state;

import execution.ExecutionResult;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.types.AlkValue;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class PrimitiveState extends ExecutionState<Value, Value> {

    public PrimitiveState(ParseTree tree, ExecutionPayload executionPayload, Value value) {
        super(tree, executionPayload);
        setResult(new ExecutionResult<>(value));
    }

    @Override
    public ExecutionState<Value, Value> makeStep()
    {
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        // no - op
    }

    protected PrimitiveState decorate(PrimitiveState copy, SplitMapper sm)
    {
        return (PrimitiveState) super.decorate(copy, sm);
    }
}

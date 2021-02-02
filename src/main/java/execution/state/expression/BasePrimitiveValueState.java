package execution.state.expression;

import ast.AST;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import util.types.Storable;
import visitor.interpreter.InterpreterHelper;

public class BasePrimitiveValueState
extends PrimitiveState
{
    private final Primitive primitive;

    public BasePrimitiveValueState(Primitive primitive, AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        this.primitive = primitive;
    }

    @Override
    protected Storable requireResult()
    {
        return InterpreterHelper.interpretAsValue(primitive, tree.getText());
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        return super.decorate(new BasePrimitiveValueState(primitive, tree, payload.clone(sm)), sm);
    }
}

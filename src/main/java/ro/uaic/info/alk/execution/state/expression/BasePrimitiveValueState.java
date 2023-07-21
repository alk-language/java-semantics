package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.interpreter.InterpreterHelper;

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

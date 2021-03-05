package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BaseUnaryOperatorState;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicUnaryOperatorState
extends BaseUnaryOperatorState
{
    public SymbolicUnaryOperatorState(Operator op, AST tree, ExecutionPayload executionPayload)
    {
        super(op, tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        if (value.toRValue() instanceof SymbolicValue)
        {
            return new SymbolicValue(UnaryAST.createUnary(op, ((SymbolicValue) value.toRValue()).toAST()));
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicUnaryOperatorState copy = new SymbolicUnaryOperatorState(super.op, tree, payload);
        return super.decorate(copy, sm);
    }
}

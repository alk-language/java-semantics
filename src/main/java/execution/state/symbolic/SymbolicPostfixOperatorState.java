package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BasePostfixOperatorState;
import execution.state.expression.BasePrefixOperatorState;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicPostfixOperatorState
extends BasePostfixOperatorState
{
    public SymbolicPostfixOperatorState(Operator op, AST tree, ExecutionPayload executionPayload)
    {
        super(op, tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        if (value.toRValue() instanceof SymbolicValue)
        {
            return new SymbolicValue(UnaryAST.createUnary(op, ((SymbolicValue) value.toRValue()).getAst()));
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicPostfixOperatorState copy = new SymbolicPostfixOperatorState(super.op, tree, payload);
        return super.decorate(copy, sm);
    }
}

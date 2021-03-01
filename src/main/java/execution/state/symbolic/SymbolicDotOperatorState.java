package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BaseDotOperatorState;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicDotOperatorState
extends BaseDotOperatorState
{
    public SymbolicDotOperatorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        if (value.toRValue() instanceof SymbolicValue)
        {
            return new SymbolicValue(UnaryAST.createUnary(Operator.DOT, ((SymbolicValue) value.toRValue()).getAst()));
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicDotOperatorState copy = new SymbolicDotOperatorState(tree, payload);
        return super.decorate(copy, sm);
    }
}

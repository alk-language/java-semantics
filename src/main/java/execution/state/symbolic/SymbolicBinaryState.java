package execution.state.symbolic;

import ast.AST;
import ast.OperatorUtils;
import ast.enums.Operator;
import ast.expr.AdditiveAST;
import ast.expr.LogicalAndAST;
import ast.expr.LogicalOrAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BaseBinaryOperatorState;
import symbolic.SymbolicValue;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicBinaryState
extends BaseBinaryOperatorState
{
    public SymbolicBinaryState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Operator op, Storable current, Storable next)
    {
        if (current.toRValue() instanceof SymbolicValue || next.toRValue() instanceof SymbolicValue)
        {
            SymbolicValue left = SymbolicValue.toSymbolic(current.toRValue());
            SymbolicValue right = SymbolicValue.toSymbolic(next.toRValue());
            List<AST> children = new ArrayList<>();
            children.add(left.toAST());
            children.add(right.toAST());
            AST opTree = OperatorUtils.getOperatorAST(op, children);
            return new SymbolicValue(opTree);
        }
        else
        {
            return super.interpretResult(op, current, next);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicBinaryState copy = new SymbolicBinaryState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.AdditiveAST;
import ast.expr.IntAST;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BasePostfixOperatorState;
import symbolic.SymbolicValue;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

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
            Storable initial = value.toRValue();
            List<AST> children = new ArrayList<>();
            children.add(((SymbolicValue) initial).toAST());
            children.add(new IntAST("1"));

            SymbolicValue result = null;
            switch (op)
            {
                case PLUSPLUSRIGHT:
                    result = new SymbolicValue(AdditiveAST.createBinary(Operator.ADD, children)); break;
                case MINUSMINUSRIGHT:
                    result = new SymbolicValue(AdditiveAST.createBinary(Operator.SUBTRACT, children)); break;
            }
            value.toLValue().assign(result);
            return initial.clone(generator);
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicPostfixOperatorState copy = new SymbolicPostfixOperatorState(super.op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

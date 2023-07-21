package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.AdditiveAST;
import ro.uaic.info.alk.ast.expr.IntAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.BasePrefixOperatorState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class SymbolicPrefixOperatorState
   extends BasePrefixOperatorState
{
    public SymbolicPrefixOperatorState(Operator op, AST tree, ExecutionPayload executionPayload)
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
                case PLUSPLUSLEFT:
                    result = new SymbolicValue(AdditiveAST.createBinary(Operator.ADD, children)); break;
                case MINUSMINUSLEFT:
                    result = new SymbolicValue(AdditiveAST.createBinary(Operator.SUBTRACT, children)); break;
            }
            value.toLValue().setValue(result);
            return result;
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicPrefixOperatorState copy = new SymbolicPrefixOperatorState(super.op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

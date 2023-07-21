package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.BaseDotOperatorState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

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
            return new SymbolicValue(UnaryAST.createUnary(Operator.DOT, ((SymbolicValue) value.toRValue()).toAST()));
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicDotOperatorState copy = new SymbolicDotOperatorState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

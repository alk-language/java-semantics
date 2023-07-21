package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.expr.EquivAST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.expression.BaseEquivState;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class SymbolicEquivState
   extends BaseEquivState
{
    public SymbolicEquivState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    protected boolean checkValue(Storable value)
    {
        if (value instanceof SymbolicValue)
        {
            ExpressionAST expressionAST = ((ExpressionAST) ((SymbolicValue) value).toAST());
            return expressionAST.getDataType(getExec().getPathCondition()) instanceof BoolDataTypeAST;
        }
        return super.checkValue(value);
    }

    protected Storable getImplication()
    {
        if (lft instanceof SymbolicValue || rgh instanceof SymbolicValue)
        {
            SymbolicValue lftsym = SymbolicValue.toSymbolic(lft);
            SymbolicValue rghsym = SymbolicValue.toSymbolic(rgh);

            AST ast = new EquivAST(null);
            ast.addChild(lftsym.toAST());
            ast.addChild(rghsym.toAST());

            return new SymbolicValue(ast);
        }
        return super.getImplication();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicEquivState copy = new SymbolicEquivState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

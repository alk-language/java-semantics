package execution.state.symbolic;

import ast.AST;
import ast.expr.ExpressionAST;
import ast.expr.fol.ImpliesAST;
import ast.type.BoolDataTypeAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BaseImpliesState;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicImpliesState
extends BaseImpliesState
{
    public SymbolicImpliesState(AST tree, ExecutionPayload executionPayload)
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

            AST ast = new ImpliesAST(null);
            ast.addChild(lftsym.toAST());
            ast.addChild(rghsym.toAST());

            return new SymbolicValue(ast);
        }
        return super.getImplication();
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicImpliesState copy = new SymbolicImpliesState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

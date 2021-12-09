package execution.state.symbolic;

import ast.AST;
import ast.expr.ExpressionAST;
import ast.expr.fol.EquivAST;
import ast.expr.fol.ImpliesAST;
import ast.type.BoolDataType;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.expression.BaseEquivState;
import execution.state.expression.BaseImpliesState;
import symbolic.SymbolicValue;
import util.types.Storable;

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
            return expressionAST.getDataType(getExec().getPathCondition()) instanceof BoolDataType;
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

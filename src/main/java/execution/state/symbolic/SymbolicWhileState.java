package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.statement.WhileState;
import smt.SMTHelper;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicWhileState
extends WhileState
{
    public SymbolicWhileState(AST tree, ExecutionPayload payload)
    {
        super(tree, payload);
    }

    @Override
    protected boolean processValidity(Storable conditionValue)
    {
        conditionValue = conditionValue.toRValue();
        if (!(conditionValue instanceof SymbolicValue))
        {
            return super.processValidity(conditionValue);
        }
        broke = true;
        Execution outExec = getExec().clone();
        AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) conditionValue).toAST());
        outExec.getPathCondition().add(new SymbolicValue(ast));
        if (SMTHelper.validatePathCondition(outExec.getConfig(), outExec.getPathCondition()))
        {
            outExec.start();
        }
        broke = false;

        getExec().getPathCondition().add((SymbolicValue) conditionValue);
        if (!SMTHelper.validatePathCondition(getExec().getConfig(), getExec().getPathCondition()))
        {
            getExec().halt();
        }
        return true;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicWhileState copy = new SymbolicWhileState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

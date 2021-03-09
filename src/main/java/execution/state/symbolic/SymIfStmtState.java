package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.statement.IfStmtState;
import symbolic.SymbolicValue;

public class SymIfStmtState
extends IfStmtState
{

    private boolean shouldExecuteElse = false;

    public SymIfStmtState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (shouldExecuteElse)
        {
            shouldExecuteElse = false;
            executed = true;
            return super.request(tree.getChild(2));
        }

        if (!executed && condition != null && condition.toRValue() instanceof SymbolicValue)
        {
            boolean hasElse = tree.getChildCount() > 2;
            if (!hasElse)
            {
                executed = true;
                Execution elseExec = getExec().clone();
                AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) condition.toRValue()).toAST());
                elseExec.getConditionPath().add(new SymbolicValue(ast));
                elseExec.start();

                getExec().getConditionPath().add((SymbolicValue) condition.toRValue());
                return request(tree.getChild(1));
            }
            else
            {
                shouldExecuteElse = true;
                Execution elseExec = getExec().clone();
                AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) condition.toRValue()).toAST());
                elseExec.getConditionPath().add(new SymbolicValue(ast));
                elseExec.start();

                shouldExecuteElse = false;
                executed = true;
                getExec().getConditionPath().add((SymbolicValue) condition.toRValue());
                return request(tree.getChild(1));
            }
        }
        else
        {
            return super.makeStep();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymIfStmtState copy = new SymIfStmtState(tree, payload.clone(sm));
        copy.condition = condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        copy.shouldExecuteElse = shouldExecuteElse;
        return super.decorate(copy, sm);
    }
}

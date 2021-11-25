package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.Execution;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.state.ExecutionCloneContext;
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

                AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) condition.toRValue()).toAST());
                Location loc = getStore().generate(new SymbolicValue(ast));
                ExecutionCloneContext cloneCtx = getExec().clone();
                Execution elseExec = cloneCtx.exec;
                elseExec.getPathCondition().add((SymbolicValue) cloneCtx.locMapping.get(loc).getValue());

                if (elseExec.getPathCondition().isSatisfiable())
                {
                    elseExec.start();
                }

                getExec().getPathCondition().add((SymbolicValue) condition.toRValue().clone(generator));
                if (!getExec().getPathCondition().isSatisfiable())
                {
                    getExec().halt();
                }
                return request(tree.getChild(1));
            }
            else
            {
                shouldExecuteElse = true;

                AST ast = UnaryAST.createUnary(Operator.NOT, ((SymbolicValue) condition.toRValue()).toAST());
                Location loc = getStore().generate(new SymbolicValue(ast));
                ExecutionCloneContext cloneCtx = getExec().clone();
                Execution elseExec = cloneCtx.exec;
                elseExec.getPathCondition().add((SymbolicValue) cloneCtx.locMapping.get(loc).getValue());

                if (elseExec.getPathCondition().isSatisfiable())
                {
                    elseExec.start();
                }

                shouldExecuteElse = false;
                executed = true;
                getExec().getPathCondition().add((SymbolicValue) condition.toRValue().clone(generator));
                if (!getExec().getPathCondition().isSatisfiable())
                {
                    getExec().halt();
                }
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

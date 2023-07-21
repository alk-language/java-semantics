package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.execution.state.ExecutionCloneContext;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.IfStmtState;
import ro.uaic.info.alk.symbolic.SymbolicValue;

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
                AlkExecution elseExec = cloneCtx.exec;
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
                AlkExecution elseExec = cloneCtx.exec;
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
        copy.condition = condition == null ? null : condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        copy.shouldExecuteElse = shouldExecuteElse;
        return super.decorate(copy, sm);
    }
}

package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.util.types.Storable;

public class IfStmtState
   extends ExecutionState
{
    protected Storable condition;
    protected boolean executed = false;

    public IfStmtState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (executed)
        {
            return null;
        }

        if (condition == null)
        {
            return request(tree.getChild(0));
        }

        executed = true;
        if (!(condition instanceof AlkBool))
        {
            super.handle(new AlkException(AlkException.ERR_IF_NOT_BOOL));
        }
        if (((AlkBool) condition).isTrue())
        {
            return request(tree.getChild(1));
        }
        else
        {
            if (tree.getChildCount() > 2)
            {
                return request(tree.getChild(2));
            }
            else
            {
                return null;
            }
        }
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (condition == null)
        {
            condition = executionResult.getValue().toRValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        IfStmtState copy = new IfStmtState(tree, payload.clone(sm));
        copy.condition = condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        return super.decorate(copy, sm);
    }

    public boolean hasExecuted()
    {
        return executed;
    }
}
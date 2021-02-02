package execution.state.statement;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

import static execution.parser.exceptions.AlkException.ERR_IF_NOT_BOOL;

public class IfStmtState extends ExecutionState
{

    private AlkBool condition;
    private boolean executed = false;

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
        if (condition.isTrue())
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
    public void assign(ExecutionResult executionResult) {
        if (condition == null)
        {
            Storable value = executionResult.getValue().toRValue();
            if (value instanceof AlkBool)
            {
                condition = (AlkBool) value;
            }
            else
            {
                super.handle(new AlkException(ERR_IF_NOT_BOOL));
            }
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        IfStmtState copy = new IfStmtState(tree, payload.clone(sm));
        copy.condition = (AlkBool) condition.weakClone(sm.getLocationMapper());
        copy.executed = executed;
        return super.decorate(copy, sm);
    }
}
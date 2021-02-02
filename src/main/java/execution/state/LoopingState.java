package execution.state;

import ast.AST;
import execution.ExecutionResult;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.parser.exceptions.BreakException;
import execution.parser.exceptions.ContinueException;
import execution.parser.exceptions.UnwindException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Storable;

public abstract class LoopingState
extends ExecutionState
{
    protected final AST condition;
    protected final AST body;

    protected boolean checkedCondition = false;
    protected boolean validCondition = false;
    protected boolean broke = false;

    public LoopingState(AST tree,
                        ExecutionPayload executionPayload,
                        AST condition,
                        AST body)
    {
        super(tree, executionPayload);
        this.condition = condition;
        this.body = body;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (!checkedCondition)
        {
            return request(condition);
        }

        if (!processValidity(validCondition))
        {
            setResult(new ExecutionResult(null));
            return null;
        }

        return request(body);
    }

    protected boolean processValidity(boolean validCondition)
    {
        return validCondition;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!checkedCondition)
        {
            checkedCondition = true;
            Storable decide = executionResult.getValue().toRValue();
            if (decide instanceof AlkBool)
            {
                AlkBool bool = (AlkBool) decide;
                validCondition = bool.isTrue();
            }
            else
            {
                super.handle(new AlkException("Condition in loop must be boolean."));
            }
        }
        else
        {
            checkedCondition = false;
            validCondition = false;
        }
    }

    @Override
    public boolean handle(UnwindException e)
    {
        if (e instanceof BreakException)
        {
            assign(new ExecutionResult(null));
            broke = true;
            return true;
        }
        if (e instanceof ContinueException)
        {
            assign(new ExecutionResult(null));
            return true;
        }
        return false;
    }

    protected LoopingState decorate(LoopingState copy, SplitMapper sm)
    {
        copy.checkedCondition = checkedCondition;
        copy.validCondition = validCondition;
        copy.broke = broke;
        return (LoopingState) super.decorate(copy, sm);
    }
}

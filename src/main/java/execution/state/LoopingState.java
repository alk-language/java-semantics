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
    protected final AST invariant;
    protected final AST body;

    protected Storable conditionValue;
    protected Storable invariantValue;
    protected Storable preBodyValue;

    protected boolean checkedCondition = false;
    protected boolean checkedInvariant = false;
    protected boolean validCondition = false;
    protected boolean broke = false;

    public LoopingState(AST tree,
                        ExecutionPayload executionPayload,
                        AST condition,
                        AST body)
    {
        this(tree, executionPayload, condition, null, body);
    }

    public LoopingState(AST tree,
                        ExecutionPayload executionPayload,
                        AST condition,
                        AST invariant,
                        AST body)
    {
        super(tree, executionPayload);
        this.condition = condition;
        this.invariant = invariant;
        this.body = body;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            setResult(new ExecutionResult(null));
            return null;
        }

        if (invariant != null && !checkedInvariant)
        {
            return request(invariant);
        }

        if (invariant != null)
        {
            processInvariant(invariantValue);
        }

        if (!checkedCondition)
        {
            return request(condition);
        }

        if (!processValidity(conditionValue))
        {
            setResult(new ExecutionResult(null));
            return null;
        }

        return request(body);
    }

    protected boolean processValidity(Storable conditionValue)
    {
        if (conditionValue instanceof AlkBool)
        {
            AlkBool bool = (AlkBool) conditionValue;
            return bool.isTrue();
        }
        else
        {
            return super.handle(new AlkException("Condition in loop must be boolean."));
        }
    }

    protected boolean processInvariant(Storable invariantValue)
    {
        if (invariantValue instanceof AlkBool)
        {
            AlkBool bool = (AlkBool) invariantValue;
            if (!bool.isTrue())
            {
                super.handle(new AlkException("Invariant is not valid."));
                return false;
            }
        }
        else
        {
            super.handle(new AlkException("Invariant in loop must be boolean."));
            return false;
        }

        return true;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (invariant != null && !checkedInvariant)
        {
            checkedInvariant = true;
            invariantValue = executionResult.getValue().toRValue();
        }
        else if (!checkedCondition)
        {
            checkedCondition = true;
            conditionValue = executionResult.getValue().toRValue();
        }
        else
        {
            checkedCondition = false;
            checkedInvariant = false;
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
        copy.checkedInvariant = checkedInvariant;
        copy.validCondition = validCondition;
        copy.broke = broke;

        return (LoopingState) super.decorate(copy, sm);
    }
}

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

import java.util.ArrayList;
import java.util.List;

public abstract class LoopingState
extends ExecutionState
{
    protected final AST condition;
    protected final List<AST> invariants;
    protected final AST body;

    protected Storable conditionValue;
    protected List<Storable> invariantValues = new ArrayList<>();
    protected int stepInv = 0;

    protected boolean checkedCondition = false;
    protected boolean checkedInvariant = false;
    protected boolean validCondition = false;
    protected boolean broke = false;

    public LoopingState(AST tree,
                        ExecutionPayload executionPayload,
                        AST condition,
                        AST body)
    {
        this(tree, executionPayload, condition, new ArrayList<>(), body);
    }

    public LoopingState(AST tree,
                        ExecutionPayload executionPayload,
                        AST condition,
                        List<AST> invariants,
                        AST body)
    {
        super(tree, executionPayload);
        this.condition = condition;
        this.invariants = invariants;
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

        if (invariants != null && !checkedInvariant && stepInv < invariants.size())
        {
            return request(invariants.get(stepInv));
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

    protected boolean processInvariant(Storable invariantValue, AST invariant)
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
        if (invariants != null && !checkedInvariant && stepInv < invariants.size())
        {
            stepInv++;
            if (stepInv == invariants.size())
            {
                checkedInvariant = true;
            }
            Storable value = executionResult.getValue().toRValue();
            invariantValues.add(value);
            processInvariant(value, invariants.get(stepInv - 1));
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
        copy.stepInv = stepInv;

        copy.conditionValue = conditionValue == null ? null : conditionValue.weakClone(sm.getLocationMapper());
        if (invariantValues != null)
        {
            copy.invariantValues = new ArrayList<>();
            for (Storable storable : invariantValues)
            {
                copy.invariantValues.add(storable.weakClone(sm.getLocationMapper()));
            }
        }

        return (LoopingState) super.decorate(copy, sm);
    }

    public boolean getCheckedCondition() {
        return checkedCondition;
    }

    public Storable getConditionValue() {
        return conditionValue;
    }
}

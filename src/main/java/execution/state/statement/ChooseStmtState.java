package execution.state.statement;

import ast.AST;
import execution.Execution;
import execution.ExecutionResult;
import execution.parser.exceptions.FailureException;
import execution.state.ExecutionState;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.alkBool.AlkBool;
import execution.helpers.NonDeterministic;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static execution.parser.constants.Constants.MAX_DECIMALS;
import static execution.parser.exceptions.AlkException.ERR_CHOOSE_NOT_ITERABLE;
import static execution.parser.exceptions.AlkException.ERR_CHOSE_ST_BOOL;

public class ChooseStmtState
extends ExecutionState
{
    protected final boolean uniform;

    protected List<Location> source;
    private boolean checked = false;
    private boolean selected = false;
    protected Location target;
    private boolean firedExhaustive = false;


    public ChooseStmtState(AST tree, ExecutionPayload executionPayload, boolean uniform)
    {
        super(tree, executionPayload);
        if (uniform)
        {
            getAlgorithmTypeDetector().setProbabilistic(true);
        }
        else
        {
            getAlgorithmTypeDetector().setNonDeterministic(true);
        }

        this.uniform = uniform;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (target == null)
        {
            return super.request(tree.getChild(0));
        }
        if (source == null)
        {
            return super.request(tree.getChild(1));
        }

        if (!selected && !getConfig().hasExhaustive())
        {
            target.setValue(NonDeterministic.choose(source).toRValue().clone(generator));
            selected = true;
            if (tree.getChildCount() > 2 && !checked)
            {
                return super.request(tree.getChild(2));
            }
        }
        else if (!firedExhaustive && getConfig().hasExhaustive())
        {
            firedExhaustive = true;
            for (int i = 1; i < source.size(); i++)
            {
                Execution current = getExec();
                target.setValue(source.get(i).toRValue().clone(generator));
                Execution next = current.clone().exec;
                next.start();
            }
            target.setValue(source.get(0).toRValue().clone(generator));
        }

        if (uniform)
        {
            BigDecimal total = new BigDecimal(source.size());
            getConfig().interpretProbability(BigDecimal.ONE.divide(total, MAX_DECIMALS, RoundingMode.HALF_EVEN));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (target == null)
        {
            target = executionResult.getValue().toLValue();
        }
        else if (source == null)
        {
            if (executionResult.getValue().toRValue() instanceof AlkIterableValue)
            {
                source = ((AlkIterableValue) executionResult.getValue().toRValue()).toArray();
            }
            else
            {
                super.handle(new AlkException(ERR_CHOOSE_NOT_ITERABLE));
            }
        }
        else
        {
            if (executionResult.getValue().toRValue() instanceof AlkBool)
            {
                if (!((AlkBool) executionResult.getValue().toRValue()).isTrue())
                {
                    throw new FailureException();
                }
                checked = true;
            }
            else
            {
                super.handle(new AlkException(ERR_CHOSE_ST_BOOL));
            }
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ChooseStmtState copy = new ChooseStmtState(tree, getPayload().clone(sm), uniform);
        return this.decorate(copy, sm);
    }

    public ExecutionState clone(ChooseStmtState copy, SplitMapper sm)
    {
        if (this.source != null)
        {
            copy.source = new ArrayList<>();
            for (Location loc : source)
            {
                copy.source.add(sm.getLocationMapper().get(loc));
            }
        }

        copy.checked = this.checked;
        copy.selected = this.selected;
        copy.target = sm.getLocationMapper().get(this.target);
        copy.firedExhaustive = firedExhaustive;

        return super.decorate(copy, sm);
    }
}
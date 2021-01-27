package execution.state.statement;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.Execution;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.parser.env.EnvironmentProxy;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
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
    private final String id;
    private final boolean uniform;

    private List<Location> source;
    private List<Location> values = new ArrayList<>();
    private int step = 0;
    private EnvironmentProxy env;

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

        this.id = tree.getAttribute(IdASTAttr.class).getId();
        this.uniform = uniform;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (source == null)
        {
            return super.request(tree.getChild(0));
        }

        if (tree.getChildCount() > 1 && step < source.size())
        {
            env = new EnvironmentProxy(getEnv());
            env.addTempEntry(id, source.get(step).toRValue().clone(generator));
            return super.request(tree.getChild(1), env);
        }

        if (tree.getChildCount() == 1)
        {
            values = source;
        }

        AlkArray arr = new AlkArray();
        arr.addAll(values);

        AlkValue value = (AlkValue) NonDeterministic.choose(arr.toArray()).toRValue();

        if (!getConfig().hasExhaustive())
        {
            getEnv().update(id, value.clone(generator));
        }
        else
        {
            int size = ((AlkInt) arr.size()).value.intValueExact();
            for (int i = 1; i < size; i++)
            {
                Execution current = getExec();
                getEnv().update(id, arr.get(i, generator).toRValue().clone(generator));
                Execution next = current.clone(true);
                next.start();
            }
            getEnv().update(id, arr.get(0, generator).toRValue().clone(generator));
        }

        if (uniform)
        {
            BigDecimal total = new BigDecimal(((AlkInt) arr.size()).value);
            getConfig().interpretProbability(BigDecimal.ONE.divide(total, MAX_DECIMALS, RoundingMode.HALF_EVEN));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (source == null)
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
                if (((AlkBool) executionResult.getValue().toRValue()).isTrue())
                {
                    values.add(source.get(step));
                }
                step++;
            }
            else
            {
                super.handle(new AlkException(ERR_CHOSE_ST_BOOL));
            }
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ChooseStmtState copy = new ChooseStmtState(tree, payload.clone(sm), uniform);
        copy.step = step;

        if (this.source != null)
        {
            copy.source = new ArrayList<>();
            for (Location loc : source)
                copy.source.add(sm.getLocationMapper().get(loc));
        }

        if (values != null)
        {
            for (Location loc : values)
                copy.values.add(sm.getLocationMapper().get(loc));
        }

        copy.env = (EnvironmentProxy) sm.getEnvironmentMapper().get(this.env);

        return super.decorate(copy, sm);
    }
}
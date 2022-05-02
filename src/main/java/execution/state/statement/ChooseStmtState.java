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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private final boolean uniform;

    private List<Location> source;
    private boolean checked = false;
    private boolean selected = false;
    private Location target;
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

    private int printElements(int start)
    {
        int chooseTo = Math.min(source.size(), start + 10);
        if (start == chooseTo)
        {
            return -1;
        }
        else
        {
            for (int i = start; i < chooseTo; ++i)
            {
                BigDecimal prob = BigDecimal.ONE.divide(new BigDecimal(source.size()), MAX_DECIMALS, RoundingMode.HALF_EVEN);
                String message = i + ". " + source.get(i).toRValue().toString();
                if (uniform)
                    message += " (with probability " + prob + ")";
                getConfig().getIOManager().write(message);

            }
            if (chooseTo < source.size())
            {
                getConfig().getIOManager().write("There are " + (source.size() - chooseTo) + " other values to choose from. Use \"more\" to see the next " + Math.min(source.size() - chooseTo, 10) + ".");
            }
            getConfig().getIOManager().flush();
            return chooseTo == source.size() ? -1 : chooseTo;
        }
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

        // DEBUGGER PART
        if (!selected && getConfig().isDebugger())
        {
            if (getExec().getStack().isInContinue())
                getExec().getStack().printCurrentLine();
            getConfig().getIOManager().write("Select the index of the value you want for \"" + tree.getChild(0) + "\"");
            getConfig().getIOManager().flush();
            int chosenElements = printElements(0);

            String line = "";
            while (!selected)
            {
                try
                {
                    line = getConfig().getIOManager().readLine();
                }
                catch (IOException e)
                {
                    getConfig().getIOManager().write(e.getMessage());
                    getConfig().getIOManager().flush();
                }
                if (line.equals("more"))
                {
                    if (chosenElements == -1)
                    {
                        getConfig().getIOManager().write("No more elements to show");
                        getConfig().getIOManager().flush();
                    }
                    else
                    {
                        chosenElements = printElements(chosenElements);
                    }
                }
                else
                {
                    try
                    {
                        int index = Integer.parseInt(line);
                        if (index >= 0 && index < source.size())
                        {
                            getExec().getStack().makeCheckpoint();
                            target.setValue(source.get(index).toRValue().clone(generator));
                            selected = true;
                            if (tree.getChildCount() > 2 && !checked)
                            {
                                return super.request(tree.getChild(2));
                            }
                        }
                        else
                        {
                            getConfig().getIOManager().write("Index out of bounds");
                            getConfig().getIOManager().flush();
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        getConfig().getIOManager().write("Not a valid index or command");
                        getConfig().getIOManager().flush();
                    }
                }
            }
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
            if (getConfig().isDebugger())
            {
                getConfig().getIOManager().write("Probability of current execution is " + getConfig().getProbability());
            }
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
        else // such that
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
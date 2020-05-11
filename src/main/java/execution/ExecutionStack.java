package execution;

import execution.state.ExecutionState;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import parser.exceptions.UnwindException;
import util.*;
import util.exception.InternalException;
import util.types.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionStack implements Cloneable
{
    private EnvironmentManager envManager;

    private Configuration config;

    private Stack< ExecutionState<? extends Value, ? extends Value> > stack = new Stack<>();

    ExecutionStack(Configuration config, EnvironmentManager envManager) {
        this.config = config;
        this.envManager = envManager;
    }

    void push(ExecutionState<? extends Value, ? extends Value> state) {
        stack.push(state);
    }

    private void pop()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        envManager.unlink(top);
        stack.pop();
    }

    void run()
    {
        while (!stack.empty())
        {
            try
            {
                makeStep();
            }
            catch (UnwindException u)
            {
                propagate(u);
            }
        }
    }

    private void propagate(UnwindException u)
    {
        while (!stack.empty())
        {
            ExecutionState<? extends Value, ? extends Value> top = stack.peek();
            if (top.handle(u))
                break;
            pop();
        }

        if (stack.empty())
        {
            if (u.isError())
                throw new AlkException(u);
            else
                config.getIOManager().write(u.getMessage());
        }
    }

    private void makeStep()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        ExecutionState<? extends Value, ? extends Value> next = top.makeStep();

        if (next == null)
        {
            ExecutionResult result = top.getResult();
            pop();
            if (!stack.empty())
            {
                top = stack.peek();
                top.assign(result);
            }
        }
        else
        {
            push(next);
        }
    }

    void nullifyLast()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        ExecutionResult result = top.getResult();
        pop();
        if (!stack.empty())
        {
            top = stack.peek();
            top.assign(result);
        }
    }

    StateMapper cloneStates(Execution master, LocationMapper locMapping, EnvironmentMapper envMapper) {
        StateMapper mapping = new StateMapper();

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            SplitMapper sm = new SplitMapper(new Payload(master), locMapping, envMapper);
            mapping.put(state, state.clone(sm));
        }

        return mapping;
    }

    ExecutionStack makeClone(Execution master, StateMapper stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master.getConfiguration(), master.getEnvManager());

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            clone.push(stateMapping.get(state));
        }

        return clone;
    }
}

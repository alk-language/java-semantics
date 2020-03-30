package execution;

import execution.state.ExecutionState;
import parser.exceptions.AlkException;
import parser.exceptions.UnwindException;
import util.Configuration;
import util.EnvironmentManager;
import util.ErrorManager;
import util.Payload;
import util.exception.InternalException;
import util.types.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionStack implements Cloneable
{
    private EnvironmentManager envManager;

    private Configuration config;

    private ExecutionResult result;

    private Stack< ExecutionState<? extends Value, ? extends Value> > stack = new Stack<>();

    ExecutionStack(Configuration config, EnvironmentManager envManager) {
        this.config = config;
        this.envManager = envManager;
    }

    void push(ExecutionState<? extends Value, ? extends Value> state) {
        if (state == null)
        {
            int aci = 0;
        }
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
            else
            {
                this.result = result;
            }
        }
        else
        {
            push(next);
        }
    }

    public ExecutionResult getResult() {
        return result;
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
        else
        {
            this.result = result;
        }
    }

    Map<ExecutionState, ExecutionState> cloneStates(Execution master) {
        Map<ExecutionState, ExecutionState> mapping = new HashMap<>();

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            Payload payload = new Payload(master);
            if (state == null || mapping == null)
            {
                int aci = 0;
            }
            mapping.put(state, state.clone(payload));
        }

        return mapping;
    }

    ExecutionStack makeClone(Execution master, Map<ExecutionState, ExecutionState> stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master.getConfiguration(), master.getEnvManager());

        if (result != null)
            clone.result = result.clone();

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            clone.push(stateMapping.get(state));
        }

        return clone;
    }
}

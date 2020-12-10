package execution;

import ast.ASTStack;
import execution.exhaustive.EnvironmentMapper;
import execution.exhaustive.ExecutionStateMapper;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.parser.env.LocationMapper;
import util.*;
import util.types.Value;

public class ExecutionStack extends ASTStack<ExecutionState>
{
    private EnvironmentManager envManager;

    ExecutionStack(Configuration config, EnvironmentManager envManager)
    {
        super(config);
        this.envManager = envManager;
    }

    @Override
    public ExecutionState pop()
    {
        ExecutionState top = super.pop();
        envManager.unlink(top);
        return top;
    }

    void nullifyLast()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        ExecutionResult executionResult = top.getResult();
        pop();
        if (!stack.empty())
        {
            top = stack.peek();
            top.assign(executionResult);
        }
    }

    ExecutionStateMapper cloneStates(Execution master, LocationMapper locMapping, EnvironmentMapper envMapper) {
        ExecutionStateMapper mapping = new ExecutionStateMapper();

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            SplitMapper sm = new SplitMapper(new ExecutionPayload(master), locMapping, envMapper);
            mapping.put(state, state.clone(sm));
        }

        return mapping;
    }

    ExecutionStack makeClone(Execution master, ExecutionStateMapper stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master.getConfiguration(), master.getEnvManager());

        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            clone.push(stateMapping.get(state));
        }

        return clone;
    }
}

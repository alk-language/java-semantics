package execution;

import ast.ASTStack;
import execution.exhaustive.EnvironmentMapper;
import execution.exhaustive.ExecutionStateMapper;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.parser.env.LocationMapper;

public class ExecutionStack extends ASTStack<ExecutionState>
{
    Execution master;

    ExecutionStack(Execution master)
    {
        super(master.config);
        this.master = master;
    }

    @Override
    public ExecutionState pop()
    {
        ExecutionState top = super.pop();
        master.getEnvManager().unlink(top);
        return top;
    }

    void nullifyLast()
    {
        ExecutionState top = stack.peek();
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

        for (ExecutionState state : stack)
        {
            // TODO this is for sure not good, why give bad environment?
            SplitMapper sm = new SplitMapper(master, locMapping, envMapper);
            mapping.put(state, state.clone(sm));
        }

        return mapping;
    }

    ExecutionStack makeClone(Execution master, ExecutionStateMapper stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master);

        for (ExecutionState state : stack)
        {
            clone.push(stateMapping.get(state));
        }

        return clone;
    }
}

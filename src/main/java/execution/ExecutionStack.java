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

    public ExecutionStack(Execution master)
    {
        super(master.config);
        this.master = master;
    }

    @Override
    public ExecutionState pop()
    {
        return super.pop();
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

package execution;

import state.Result;
import execution.parser.env.LocationMapper;
import util.types.Storable;

public class ExecutionResult
extends Result<Storable>
{
    public ExecutionResult(Storable value)
    {
        super(value);
    }

    public ExecutionResult clone(LocationMapper locationMapper)
    {
        return new ExecutionResult(super.value.weakClone(locationMapper));
    }
}

package execution;

import ast.Result;
import execution.parser.env.LocationMapper;
import util.types.Value;

public class ExecutionResult<T extends Value> extends Result<T>
{
    public ExecutionResult(T value) {
        super(value);
    }

    public T getValue()
    {
        return value;
    }

    public ExecutionResult clone(LocationMapper locationMapper)
    {
        return new ExecutionResult(super.value.weakClone(locationMapper));
    }
}

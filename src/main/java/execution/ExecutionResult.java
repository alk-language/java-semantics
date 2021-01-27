package execution;

import ast.Result;
import execution.parser.env.LocationMapper;
import util.types.Value;

public class ExecutionResult
extends Result<Value>
{
    public ExecutionResult(Value value)
    {
        super(value);
    }

    public ExecutionResult clone(LocationMapper locationMapper)
    {
        return new ExecutionResult(super.value.weakClone(locationMapper));
    }
}

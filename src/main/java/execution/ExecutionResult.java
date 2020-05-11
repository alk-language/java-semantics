package execution;

import execution.types.AlkValue;
import parser.env.LocationMapper;
import util.lambda.LocationGenerator;
import util.types.Value;

public class ExecutionResult<T extends Value>
{
    private T value;

    public ExecutionResult(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == null)
            return "null";
        return value.toString();
    }

    public ExecutionResult clone(LocationMapper locationMapper)
    {
        return new ExecutionResult(this.value.weakClone(locationMapper));
    }
}

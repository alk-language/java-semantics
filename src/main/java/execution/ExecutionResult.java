package execution;

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
        return value.toString();
    }
}

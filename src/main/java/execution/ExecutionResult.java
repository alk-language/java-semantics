package execution;

import util.types.Value;

public class ExecutionResult<T extends Value> implements Cloneable
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

    public ExecutionResult clone()
    {
        try {
            ExecutionResult clone = (ExecutionResult) super.clone();
            clone.value = value;
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

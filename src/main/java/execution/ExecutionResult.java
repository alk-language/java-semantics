package execution;

import parser.types.AlkValue;

public class ExecutionResult {

    private AlkValue value;

    public ExecutionResult(AlkValue value) {
        this.value = value;
    }

    public AlkValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

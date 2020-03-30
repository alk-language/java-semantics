package parser.exceptions;

import execution.types.AlkValue;
import util.types.Value;

public class ReturnException extends UnwindException
{
    AlkValue value;

    public ReturnException(String text, AlkValue value)
    {
        super(text);
        this.value = value;
    }

    public Value getValue()
    {
        return value;
    }

    @Override
    public boolean isError() {
        return false;
    }
}

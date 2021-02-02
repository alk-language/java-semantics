package execution.parser.exceptions;

import execution.types.AlkValue;
import util.types.Storable;

public class ReturnException extends UnwindException
{
    AlkValue value;

    public ReturnException(String text, AlkValue value)
    {
        super(text);
        this.value = value;
    }

    public Storable getValue()
    {
        return value;
    }

    @Override
    public boolean isError() {
        return false;
    }
}

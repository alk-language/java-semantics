package execution.parser.exceptions;

import util.types.Storable;

public class ReturnException extends UnwindException
{
    Storable value;

    public ReturnException(String text, Storable value)
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

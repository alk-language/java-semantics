package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.util.types.Storable;

public class ReturnException extends UnwindException
{
    private final Storable value;

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

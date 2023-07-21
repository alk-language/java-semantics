package ro.uaic.info.alk.exeptions;

public class StopException
extends UnwindException
{
    public StopException(String text)
    {
        super(text);
    }

    @Override
    public boolean isError()
    {
        return false;
    }
}

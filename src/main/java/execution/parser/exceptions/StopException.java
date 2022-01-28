package execution.parser.exceptions;

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

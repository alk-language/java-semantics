package execution.parser.exceptions;

public class BreakException extends UnwindException
{
    public BreakException(String text)
    {
        super(text);
    }

    @Override
    public boolean isError() {
        return true;
    }
}

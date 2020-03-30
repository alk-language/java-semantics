package parser.exceptions;

public abstract class UnwindException extends RuntimeException
{
    public UnwindException(String text)
    {
        super(text);
    }

    public abstract boolean isError();
}

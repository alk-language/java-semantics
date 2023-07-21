package ro.uaic.info.alk.exeptions;

public class ContinueException extends UnwindException
{
    public ContinueException(String text)
    {
        super(text);
    }

    @Override
    public boolean isError() {
        return true;
    }
}

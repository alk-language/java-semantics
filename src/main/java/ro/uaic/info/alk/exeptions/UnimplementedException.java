package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.exeptions.InternalException;

public class UnimplementedException extends InternalException
{
    public UnimplementedException(String text)
    {
        super(text);
    }
}

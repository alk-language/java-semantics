package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.exeptions.InternalException;

public class SMTUnexpectedException
   extends InternalException
{
    public SMTUnexpectedException(String message)
    {
        super(message);
    }
}

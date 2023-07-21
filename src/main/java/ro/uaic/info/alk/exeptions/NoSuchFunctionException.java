package ro.uaic.info.alk.exeptions;

public class NoSuchFunctionException
extends AlkException
{
    public NoSuchFunctionException(String fncName)
    {
        super(ERR_FUNCTION_UNDEFINED + ": " + fncName);
    }
}

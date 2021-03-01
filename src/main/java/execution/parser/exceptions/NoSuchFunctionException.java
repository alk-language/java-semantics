package execution.parser.exceptions;

public class NoSuchFunctionException
extends AlkException
{
    public NoSuchFunctionException(String fncName)
    {
        super(ERR_FUNCTION_UNDEFINED + ": " + fncName);
    }
}

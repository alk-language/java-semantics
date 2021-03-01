package execution.parser.exceptions;

public class IdNotInEnvironmentException
extends AlkException
{
    public IdNotInEnvironmentException(String id)
    {
        super("Id '" + id + "' not in environment!");
    }
}

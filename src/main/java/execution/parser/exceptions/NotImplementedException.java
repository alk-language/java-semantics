package execution.parser.exceptions;

import util.exception.InternalException;

public class NotImplementedException
extends InternalException
{
    public NotImplementedException(String text)
    {
        super(text);
    }
}

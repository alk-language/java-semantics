package util.exception;

import execution.parser.exceptions.AlkException;

/**
 * Exeption which should be thrown in case a file was not found
 * This is a runtime exception, so it can be used to wrap IO exceptions
 */
public class AlkParseException
extends AlkException
{
    public AlkParseException(String text)
    {
        super(text);
    }
}

package util.exception;

import org.apache.commons.cli.ParseException;

/**
 * Exeption which should be thrown in case a file was not found
 * This is a runtime exception, so it can be used to wrap IO exceptions
 */
public class AlkParseException extends InternalException
{
    /**
     * Wrapper constructor
     *
     * @param e
     * The parsing exception which should be wrapped
     */
    public AlkParseException(ParseException e)
    {
        super(e);
    }
}

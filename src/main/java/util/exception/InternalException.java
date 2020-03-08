package util.exception;

/**
 * A type of exception used to generally wrap specific non-runtime exception
 */
public class InternalException extends RuntimeException
{

    /**
     * Implicit constructor
     */
    public InternalException()
    {
        // no-op
    }

    /**
     * Wrapper constructor
     *
     * @param e
     * The exception to bve wrapped
     */
    public InternalException(Exception e)
    {
        super(e);
    }

    /**
     * Constructor with given message
     *
     * @param text
     * The message with which the exception should be initialized
     */
    public InternalException(String text)
    {
        super(text);
    }
}

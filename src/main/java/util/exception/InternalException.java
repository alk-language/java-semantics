package util.exception;

/**
 * A type of exception used to generally wrap specific non-runtime exception
 */
public class InternalException extends RuntimeException
{

    /**
     * Implicit constructor
     */
    InternalException()
    {
        // no-op
    }

    /**
     * Wrapper constructor
     *
     * @param e
     * The exception to bve wrapped
     */
    InternalException(Exception e)
    {
        super(e);
    }
}

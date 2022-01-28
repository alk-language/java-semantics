package util.exception;

/**
 * A type of exception used to generally wrap specific non-runtime exception
 */
public class InternalException extends RuntimeException
{
    int line;
    int col;

    /**
     * Implicit constructor
     */
    public InternalException()
    {
        // no-op
    }

    /*@Override
    public String getMessage()
    {
        return "An unexpected exception occurred; enable trace mode for more details.";
    }*/

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

    public void sign(int line, int column)
    {
        this.line = line;
        this.col = column;
    }

    public String completeMessage() {
        return "Error at [" + line + ":" + col + "]: " + getMessage();
    }

    public int getLine()
    {
        return this.line;
    }

    public String formatMessage(String message)
    {
        return "Error at [" + line + ":" + col + "]: " + message;
    }
}

package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.execution.Environment;

/**
 * A type of exception used to generally wrap specific non-runtime exception
 */
public class InternalException
extends RuntimeException
{
    int line;
    int col;
    Environment env;

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

    public InternalException(String text, InternalException cause)
    {
        super(text, cause);
    }

    public void sign(int line, int column)
    {
        this.line = line;
        this.col = column;
    }

    public void setEnvironment(Environment env)
    {
        this.env = env;
    }

    public void setEnvironmentIfAbsent(Environment env)
    {
        if (this.env == null)
        {
            setEnvironment(env);
        }
    }


    public Environment getEnvironment()
    {
        return this.env;
    }

    public String completeMessage() {
        return "Error at line " + line + ", column " + col + ":\n   " + getMessage();
    }


    public String getCauseMessage()
    {
        return "Caused by:\n   " + getMessage();
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

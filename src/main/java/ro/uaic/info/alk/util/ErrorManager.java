package ro.uaic.info.alk.util;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.exeptions.AlkIOException;
import ro.uaic.info.alk.exeptions.InternalException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Responsible for handling different kind of exceptions
 */
public class ErrorManager
{
    private IOManager io;

    private OptionProvider op;

    public void attach(IOManager io) {
        this.io = io;
    }

    public void attach(OptionProvider op) {
        this.op = op;
    }

    /**
     * Specific error handling for IOException
     *
     * @param e
     * The specific IOException to be handled
     */
    public void handleError(IOException e, String path)
    {
        if (e instanceof FileNotFoundException)
            io.write("[ERROR]: " + path + " couldn't be found as a valid file.");
        else
            io.write("[ERROR]: unexpected IO exception has been encountered.");

        // rethrow runtime wrapped exception to force execution termination
        throw new AlkIOException(e);
    }

    public void handleError(AlkException ex)
    {
        boolean first = true;
        while (ex != null)
        {
            int line = ex.getLine();
            if (!first)
            {
                io.write(ex.getCauseMessage());
            }
            else
            {
                if (line == 0)
                {
                    io.write(ex.getMessage());
                }
                else
                {
                    io.write(ex.completeMessage());
                }
            }
            ex = (AlkException) ex.getCause();
            first = false;
        }
    }

    public ErrorManager getEndpoint()
    {
        ErrorManager em = new ErrorManager();
        em.attach(io);
        em.attach(op);
        return em;
    }

    public void handleError(InternalException e)
    {
        io.write(e.formatMessage("Internal exception detected. Please report the error!"));
    }
}

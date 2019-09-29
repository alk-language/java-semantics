package util;

import parser.exceptions.AlkException;
import io.IOManager;
import util.exception.AlkFatalException;
import util.exception.AlkIOException;

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

    public void handleError(AlkException ex) {
        ex.printException();
        throw new AlkFatalException();
    }
}

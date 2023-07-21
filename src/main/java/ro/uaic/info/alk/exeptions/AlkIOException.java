package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.exeptions.InternalException;

import java.io.IOException;

/**
 * Exeption which should be thrown in case of an IO exception
 * This is a runtime exception, so it can be used to wrap other IO exceptions
 */
public class AlkIOException extends InternalException
{
    /**
     * Wrapper constructor
     *
     * @param e
     * The IO exception which should be wrapped
     */
    public AlkIOException(IOException e) {
        super(e);
    }
}

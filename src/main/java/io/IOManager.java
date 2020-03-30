package io;

/**
 * Interface meant to be implemented by IO service providers, which can
 * deliver basic IO operations
 */
public interface IOManager {

    /**
     * Basic writing method
     *
     * @param text
     * The text meant to be written to a buffer depending to the implementation
     */
    void write(String text);

    void flush();

    IOManager getEndpoint();

}

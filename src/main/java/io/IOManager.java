package io;

/**
 * Interface meant to be implemented by IO service providers, which can
 * deliver basic IO operations
 */
public interface IOManager
extends Reader, Writer
{
    /** Should return a thread-safe endpoint to a IO manager. */
    IOManager getEndpoint();
}

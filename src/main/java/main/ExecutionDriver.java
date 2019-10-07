package main;

import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

/**
 * An entry point for a basic execution of one single alk file.
 * The configuration is provided by the command line.
 * The IO will also be handled by the console.
 */
public class ExecutionDriver
{
    /** The main IO Manager used for basic IO usage */
    private static IOManager io;

    /** The main Error Manager used for error handling*/
    private static ErrorManager em;

    /** A generated configuration based on other managers */
    private static Configuration config;


    /**
     * Main entry point into the ExecutionDriver
     *
     * @param args
     * The command line arguments
     */
    public static void main(String[] args)
    {
        initManagers(args);

        Execution exec = new Execution(config);
        exec.start();
    }

    /**
     * Method used for initializing and linking the managers
     * TODO: let the managers be enabled by each execution, avoid using static context
     *
     * @param args
     * The command line arguments. Useful when constructing the OptionProvider.
     */
    private static void initManagers(String[] args)
    {
        // setup the managers
        AlkConsole io = new AlkConsole(args);
        ErrorManager em = new ErrorManager();
        config = new Configuration();

        // attach interfaces to the managers
        em.attach((IOManager) io);
        em.attach((OptionProvider) io);
        config.attach(em);
        config.attach(io);
        config.importOptions(io);

        /*
         * setup the managers to static scope
         */
        ExecutionDriver.io = io;
        ExecutionDriver.em = em;
    }

}

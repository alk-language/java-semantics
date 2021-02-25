package main;

import execution.Execution;
import io.AlkConsole;
import io.BufferedIOWrapper;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;
import util.exception.AlkParseException;

/**
 * An entry point for a basic execution of one single alk file.
 * The configuration is provided by the command line.
 * The IO will also be handled by the console.
 */
public class ExecutionDriver
{

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
        try
        {
            for (String arg : args)
            {
                System.out.println(arg);
            }
            initManagers(args);
        }
        catch (AlkParseException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        Execution exec = new Execution(config);
        exec.start();
    }

    /**
     * Method used for initializing and linking the managers
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

        // setup buffered input
        IOManager bufferedIO = new BufferedIOWrapper(io);

        // attach interfaces to the managers
        em.attach(bufferedIO);
        em.attach((OptionProvider) io);
        config.attach(em);
        config.attach(bufferedIO);
        config.importOptions(io);
    }

}

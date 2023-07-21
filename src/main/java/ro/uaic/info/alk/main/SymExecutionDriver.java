package ro.uaic.info.alk.main;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulStmtInterpreter;
import ro.uaic.info.alk.io.AlkConsole;
import ro.uaic.info.alk.io.BufferedIOWrapper;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.OptionProvider;
import ro.uaic.info.alk.exeptions.AlkParseException;

public class SymExecutionDriver
{
    /** A generated configuration based on other managers */
    private static AlkConfiguration config;

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
            initManagers(args);
        }
        catch (AlkParseException e)
        {
            System.out.println(e.getMessage());
            return;
        }

        AlkExecution exec = new AlkExecution(config, new SymbolicStatefulExpressionInterpreter(), new SymbolicStatefulStmtInterpreter());
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
        config = new AlkConfiguration();

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

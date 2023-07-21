package ro.uaic.info.alk.main;

import ro.uaic.info.alk.io.AlkConsole;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.OptionProvider;

public class SymbolicExecutionDriver
{

    private static AlkConfiguration config;

    public static void main(String[] args)
    {
        initManagers(args);

        //SymbolicExecution evaluator = new SymbolicExecution(config);
        //evaluator.start();
    }

    private static void initManagers(String[] args)
    {
        // setup the managers
        AlkConsole console = new AlkConsole(args);

        ErrorManager em = new ErrorManager();
        config = new AlkConfiguration();

        // attach interfaces to the managers
        em.attach((IOManager) console);
        em.attach((OptionProvider) console);

        config.attach(em);
        config.attach(console);
        config.importOptions(console);
    }
}

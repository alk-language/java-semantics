package control;

import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

public class CFGDriver
{
    private static Configuration config;

    public static void main(String[] args)
    {
        initManagers(args);

        CFGBuilder cfgBuilder = new CFGBuilder(config);
        cfgBuilder.run();
    }

    private static void initManagers(String[] args)
    {
        // setup the managers
        AlkConsole console = new AlkConsole(args);

        ErrorManager em = new ErrorManager();
        config = new Configuration();

        // attach interfaces to the managers
        em.attach((IOManager) console);
        em.attach((OptionProvider) console);

        config.attach(em);
        config.attach(console);
        config.importOptions(console);
    }

}

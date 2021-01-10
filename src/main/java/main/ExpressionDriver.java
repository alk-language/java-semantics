package main;

import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;
import visitor.ExpressionEvaluator;

public class ExpressionDriver
{
    private static Configuration config;

    public static void main(String[] args)
    {
        initManagers(args);

        ExpressionEvaluator evaluator = new ExpressionEvaluator(config);
        evaluator.run();
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

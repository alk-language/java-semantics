package control;

import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.AlkParser;
import util.Configuration;
import util.exception.InternalException;

import java.io.File;

public class CFGBuilder extends Thread
{
    private Configuration config;
    private ControlFlowGraph cfg;

    public CFGBuilder(Configuration config)
    {
        this.config = config;
    }

    public ControlFlowGraph getCfg()
    {
        return cfg;
    }

    @Override
    public void run()
    {
        File file = config.getAlkFile();
        ParseTree root = AlkParser.execute(file);
        try
        {
            cfg = IntraproceduralCFG.generate(root, config);
            config.getIOManager().write(cfg.graphData());
        }
        catch(InternalException e)
        {
            if (config.hasDebugMode())
            {
                e.printStackTrace();
            }
        }
    }
}

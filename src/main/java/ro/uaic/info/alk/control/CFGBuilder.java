package ro.uaic.info.alk.control;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.tree.ParseTree;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.parser.ParseTreeGlobals;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.exeptions.InternalException;

import java.io.File;
import java.util.ArrayList;

public class CFGBuilder
extends Thread
{
    private final AlkConfiguration config;
    private ControlFlowGraph cfg;
    private boolean intraprocedural;
    private List<ASTProcessor> processorList = new ArrayList<>();

    public CFGBuilder(AlkConfiguration config)
    {
        this(config, true);
    }

    public CFGBuilder(AlkConfiguration config, boolean intraprocedural)
    {
        this.config = config;
        this.intraprocedural = intraprocedural;
    }

    public ControlFlowGraph getCfg()
    {
        return cfg;
    }

    @Override
    public void run()
    {
        File file = config.getAlkFile();
        ParseTree root = SimpleAlkParser.execute(file);
        AST tree = ParseTreeGlobals.PARSE_TREE_VISITOR.visit(root);
        for (ASTProcessor processor : processorList)
        {
            processor.visit(tree);
        }
        if (intraprocedural)
        {
            buildIntraprocedural(tree);
        }
        else
        {
            buildInterprocedural(tree);
        }
    }

    private void buildIntraprocedural(AST root)
    {
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

    private void buildInterprocedural(AST root)
    {
        try
        {
            cfg = InterproceduralCFG.generate(root, config);
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

    public void registerProcessor(ASTProcessor processor)
    {
        this.processorList.add(processor);
    }
}

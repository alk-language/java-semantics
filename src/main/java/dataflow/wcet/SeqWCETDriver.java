package dataflow.wcet;

import ast.VirtualAST;
import control.CFGBuilder;
import dataflow.*;
import dataflow.domain.ProgramContext;
import dataflow.lattice.LatticeBuilder;
import dataflow.worklist.WorklistFlow;
import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;
import util.Recurrence;

import java.util.List;
import java.util.Map;

public class SeqWCETDriver
{
    private static Configuration config;
    private static final int PADDING = 50;

    private static String getHeader(String str)
    {
        int left = (PADDING - str.length()) / 2;
        int right = PADDING - str.length() - left;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<left; i++)
            sb.append("=");
        sb.append(str);
        for (int i=0; i<right; i++)
            sb.append("=");
        sb.append("\n");
        return sb.toString();
    }


    public static CFGBuilder buildCFG()
    throws InterruptedException
    {
        config.getIOManager().write(getHeader("CFG"));

        CFGBuilder cfgBuilder = new CFGBuilder(config);
        cfgBuilder.start();
        cfgBuilder.join();

        config.getIOManager().write("\n");
        return cfgBuilder;
    }

    public static Dataflow<ProgramContext> doDataflow(CFGBuilder cfgBuilder)
    throws InterruptedException
    {
        config.getIOManager().write(getHeader("Dataflow"));

        LatticeBuilder<ProgramContext> latticeBuilder = new SeqWCETLatticeBuilder(cfgBuilder.getCfg());
        latticeBuilder.start();
        latticeBuilder.join();

        CFG cfg = cfgBuilder.getCfg();
        Lattice<ProgramContext> lattice = latticeBuilder.getLattice();
        Iota<ProgramContext> iota = ProgramContext::getInitialContext;
        TransferFunction<ProgramContext> fun = new SeqWCETTransferFunction();

        Dataflow<ProgramContext> dataflow = new WorklistFlow<>(lattice, cfg, iota, fun);
        dataflow.start();
        dataflow.join();

        for (Map.Entry<CFGNode, ProgramContext> entry : dataflow.getMapping().entrySet())
        {
            config.getIOManager().write(entry.getKey().toString() + " -> " + entry.getValue().toString());
        }

        return dataflow;
    }

    public static void writeMapping()
    {
        config.getIOManager().write(getHeader("Loop mapping"));
        config.getIOManager().write(VirtualAST.getMappingAsString());
    }

    public static void writeRecurrence(Dataflow<ProgramContext> dataflow)
    {
        config.getIOManager().write(getHeader("Recurrence"));
        for (CFGNode entry : dataflow.getMapping().keySet())
        {
            if (VirtualAST.hasLoop(entry.getTree()))
            {
                ProgramContext pc = dataflow.getMapping().get(entry);
                int id = VirtualAST.getASTId(entry.getTree());
                config.getIOManager().write("Loop " + id + ":");
                Map<String, Recurrence> recs = pc.getReccurences(entry.getTree());
                for (Map.Entry<String, Recurrence> rec : recs.entrySet())
                {
                    config.getIOManager().write("   " + rec.getKey() + ":");
                    config.getIOManager().write(rec.getValue().toString("_l" + id, 6));
                }
            }
        }
    }

    public static void main(String[] args)
    throws InterruptedException
    {
        initManagers(args);

        CFGBuilder cfgBuilder = buildCFG();
        Dataflow<ProgramContext> dataflow = doDataflow(cfgBuilder);
        writeMapping();
        writeRecurrence(dataflow);
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

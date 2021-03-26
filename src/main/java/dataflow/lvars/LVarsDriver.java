package dataflow.lvars;

import control.CFGBuilder;
import dataflow.*;
import dataflow.domain.VariableSet;
import dataflow.lattice.LatticeBuilder;
import dataflow.worklist.WorklistFlow;
import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

import java.util.Map;

/*
    Domeniu -> multime de variabile
 */
public class LVarsDriver
{
    private static Configuration config;

    public static void main(String[] args)
    throws InterruptedException
    {
        initManagers(args);

        CFGBuilder cfgBuilder = new CFGBuilder(config);
        cfgBuilder.start();
        cfgBuilder.join();

        LatticeBuilder<VariableSet> latticeBuilder = new LVarsLatticeBuilder(cfgBuilder.getCfg());
        latticeBuilder.start();
        latticeBuilder.join();

        CFG cfg = new ReversedCFG(cfgBuilder.getCfg());
        Lattice<VariableSet> lattice = latticeBuilder.getLattice();
        Iota<VariableSet> iota = VariableSet::getFullSet;
        TransferFunction<VariableSet> fun = new LVarsTransferFunction();

        Dataflow<VariableSet> dataflow = new WorklistFlow<>(lattice, cfg, iota, fun);
        dataflow.start();
        dataflow.join();

        for (Map.Entry<CFGNode, VariableSet> entry : dataflow.getMapping().entrySet())
        {
            config.getIOManager().write(entry.getKey().toString() + " -> " + entry.getValue().toString());
        }
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

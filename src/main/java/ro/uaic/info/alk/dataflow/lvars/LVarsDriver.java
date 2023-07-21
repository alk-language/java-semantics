package ro.uaic.info.alk.dataflow.lvars;

import ro.uaic.info.alk.control.CFGBuilder;
import ro.uaic.info.alk.dataflow.domain.VariableSet;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;
import ro.uaic.info.alk.dataflow.worklist.WorklistFlow;
import ro.uaic.info.alk.io.AlkConsole;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.dataflow.*;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.OptionProvider;

import java.util.Map;

/*
    Domeniu -> multime de variabile
 */
public class LVarsDriver
{
    private static AlkConfiguration config;

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
        config = new AlkConfiguration();

        // attach interfaces to the managers
        em.attach((IOManager) console);
        em.attach((OptionProvider) console);

        config.attach(em);
        config.attach(console);
        config.importOptions(console);
    }
}

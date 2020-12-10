package dataflow.cpropag;

import control.CFGBuilder;
import dataflow.*;
import dataflow.domain.VarValue;
import dataflow.domain.VariableSet;
import dataflow.lattice.LatticeBuilder;
import dataflow.lvars.LVarsLatticeBuilder;
import dataflow.lvars.LVarsTransferFunction;
import dataflow.lvars.ReversedCFG;
import dataflow.worklist.WorklistFlow;
import io.AlkConsole;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

import java.util.Map;

public class CPropagDriver
{

    private static Configuration config;

    public static void main(String[] args) throws InterruptedException
    {
        initManagers(args);

        CFGBuilder cfgBuilder = new CFGBuilder(config);
        cfgBuilder.start();
        cfgBuilder.join();

        LatticeBuilder<VarValue> latticeBuilder = new CPropagLatticeBuilder(cfgBuilder.getCfg());
        latticeBuilder.start();
        latticeBuilder.join();

        CFG cfg = cfgBuilder.getCfg();
        Lattice<VarValue> lattice = latticeBuilder.getLattice();
        Iota<VarValue> iota = VarValue::getAllUnderdefined;
        TransferFunction<VarValue> fun = new CPropagTransferFunction();

        Dataflow<VarValue> dataflow = new WorklistFlow<>(lattice, cfg, iota, fun);
        dataflow.start();
        dataflow.join();

        for (Map.Entry<CFGNode, VarValue> entry : dataflow.getMapping().entrySet())
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

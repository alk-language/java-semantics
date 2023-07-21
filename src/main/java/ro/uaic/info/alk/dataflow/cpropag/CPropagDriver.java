package ro.uaic.info.alk.dataflow.cpropag;

import ro.uaic.info.alk.control.CFGBuilder;
import ro.uaic.info.alk.dataflow.domain.VarValue;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;
import ro.uaic.info.alk.dataflow.worklist.WorklistFlow;
import ro.uaic.info.alk.io.AlkConsole;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.dataflow.*;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.OptionProvider;

import java.util.Map;

public class CPropagDriver
{

    private static AlkConfiguration config;

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
        config = new AlkConfiguration();

        // attach interfaces to the managers
        em.attach((IOManager) console);
        em.attach((OptionProvider) console);

        config.attach(em);
        config.attach(console);
        config.importOptions(console);
    }
}

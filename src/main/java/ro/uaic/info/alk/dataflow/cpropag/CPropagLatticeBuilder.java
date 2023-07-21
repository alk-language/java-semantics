package ro.uaic.info.alk.dataflow.cpropag;

import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFG;
import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.VarValue;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;

import java.util.Set;

public class CPropagLatticeBuilder extends LatticeBuilder<VarValue>
{
    private CFG cfg;
    private Lattice<VarValue> lattice;

    public CPropagLatticeBuilder(CFG cfg)
    {
        this.cfg = cfg;
    }

    @Override
    public void run()
    {
        Set<String> vars = new VarsBulkExtractor().extract(cfg);
        VarValue.build(vars);
        lattice = new VarValueLattice();
    }

    @Override
    public Lattice<VarValue> getLattice() {
        return lattice;
    }
}

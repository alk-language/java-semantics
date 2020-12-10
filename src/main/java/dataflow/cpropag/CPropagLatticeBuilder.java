package dataflow.cpropag;

import control.extractor.VarsBulkExtractor;
import dataflow.CFG;
import dataflow.Lattice;
import dataflow.domain.VarValue;
import dataflow.lattice.LatticeBuilder;

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

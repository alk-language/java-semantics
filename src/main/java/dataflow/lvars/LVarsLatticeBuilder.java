package dataflow.lvars;

import control.extractor.VarsBulkExtractor;
import dataflow.CFG;
import dataflow.Lattice;
import dataflow.domain.VariableSet;
import dataflow.lattice.LatticeBuilder;

import java.util.Set;

public class LVarsLatticeBuilder
extends LatticeBuilder<VariableSet>
{
    private final CFG cfg;
    private Lattice<VariableSet> lattice;

    public LVarsLatticeBuilder(CFG cfg)
    {
        this.cfg = cfg;
    }

    @Override
    public void run()
    {
        Set<String> vars = new VarsBulkExtractor().extract(cfg);
        VariableSet.build(vars);
        lattice = new VarSetLattice();
    }

    @Override
    public Lattice<VariableSet> getLattice() {
        return lattice;
    }
}

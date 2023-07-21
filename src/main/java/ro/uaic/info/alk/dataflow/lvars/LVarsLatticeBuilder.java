package ro.uaic.info.alk.dataflow.lvars;

import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFG;
import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.VariableSet;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;

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

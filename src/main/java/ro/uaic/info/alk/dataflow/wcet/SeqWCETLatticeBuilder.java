package ro.uaic.info.alk.dataflow.wcet;

import ro.uaic.info.alk.control.ControlFlowGraph;
import ro.uaic.info.alk.dataflow.CFG;
import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.ProgramContext;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;


public class SeqWCETLatticeBuilder
extends LatticeBuilder<ProgramContext>
{
    private final CFG cfg;
    private Lattice<ProgramContext> lattice;

    public SeqWCETLatticeBuilder(ControlFlowGraph cfg)
    {
        this.cfg = cfg;
    }

    @Override
    public void run()
    {
        lattice = new SeqWCETLattice();
    }

    @Override
    public Lattice<ProgramContext> getLattice()
    {
        return lattice;
    }
}

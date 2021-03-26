package dataflow.wcet;

import control.ControlFlowGraph;
import dataflow.CFG;
import dataflow.Lattice;
import dataflow.domain.ProgramContext;
import dataflow.lattice.LatticeBuilder;


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

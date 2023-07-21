package ro.uaic.info.alk.dataflow.lattice;

import ro.uaic.info.alk.dataflow.Domain;
import ro.uaic.info.alk.dataflow.Lattice;

public abstract class LatticeBuilder<T extends Domain> extends Thread
{
    public abstract Lattice<T> getLattice();
    public abstract void run();
}

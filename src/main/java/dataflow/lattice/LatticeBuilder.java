package dataflow.lattice;

import dataflow.Domain;
import dataflow.Lattice;

public abstract class LatticeBuilder<T extends Domain> extends Thread
{
    public abstract Lattice<T> getLattice();
    public abstract void run();
}

package dataflow;

import java.util.Map;

public abstract class Dataflow<T extends Domain>
extends Thread
{
    protected final Lattice<T> lattice;
    protected final CFG cfg;
    protected final Iota<T> iota;
    protected final TransferFunction<T> fun;

    protected Dataflow(Lattice<T> lattice, CFG cfg, Iota<T> iota, TransferFunction<T> fun)
    {
        this.lattice = lattice;
        this.cfg = cfg;
        this.iota = iota;
        this.fun = fun;
    }

    public abstract void execute();
    public abstract Map<CFGNode, T> getMapping();

    @Override
    public void run()
    {
        execute();
    }
}

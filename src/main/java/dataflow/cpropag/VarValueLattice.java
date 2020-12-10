package dataflow.cpropag;

import dataflow.Lattice;
import dataflow.domain.VarValue;

import java.util.Set;

public class VarValueLattice implements Lattice<VarValue>
{
    @Override
    public boolean compare(VarValue a, VarValue b)
    {
        return a.lower(b);
    }

    @Override
    public VarValue getLUB(Set<VarValue> set)
    {
        VarValue mapping = getBottom();
        for (VarValue varValue : set)
        {
            mapping = mapping.join(varValue);
        }
        return mapping;
    }

    @Override
    public VarValue getGLB(Set<VarValue> set)
    {
        VarValue mapping = getTop();
        for (VarValue varValue : set)
        {
            mapping = mapping.meet(varValue);
        }
        return mapping;
    }

    @Override
    public VarValue getTop() {
        return VarValue.getAllOverdefined();
    }

    @Override
    public VarValue getBottom() {
        return VarValue.getAllUnderdefined();
    }
}

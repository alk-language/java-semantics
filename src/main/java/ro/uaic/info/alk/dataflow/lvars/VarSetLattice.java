package ro.uaic.info.alk.dataflow.lvars;

import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.VariableSet;

import java.util.Set;

public class VarSetLattice implements Lattice<VariableSet>
{
    @Override
    public VariableSet getLUB(Set<VariableSet> set)
    {
        VariableSet ans = getBottom();
        for (VariableSet vs : set)
        {
            ans = ans.union(vs);
        }

        return ans;
    }

    @Override
    public VariableSet getGLB(Set<VariableSet> set)
    {
        VariableSet ans = getTop();
        for (VariableSet vs : set)
        {
            ans = ans.intersect(vs);
        }

        return ans;
    }

    @Override
    public boolean compare(VariableSet a, VariableSet b)
    {
        return b.includes(a);
    }

    @Override
    public VariableSet getTop()
    {
        return VariableSet.getFullSet();
    }

    @Override
    public VariableSet getBottom()
    {
        return VariableSet.getEmptySet();
    }
}

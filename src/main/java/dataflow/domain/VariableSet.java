package dataflow.domain;


import dataflow.Domain;

import java.util.HashSet;
import java.util.Set;

public class VariableSet
implements Domain
{
    private static Set<String> allVars = new HashSet<>();

    public static VariableSet getFullSet()
    {
        return new VariableSet(allVars);
    }

    public static VariableSet getEmptySet()
    {
        return new VariableSet();
    }

    public static void build(Set<String> vars)
    {
        allVars.addAll(vars);
    }

    private Set<String> vars;

    public VariableSet() {
        vars = new HashSet<>();
    }

    public VariableSet(Set<String> vars)
    {
        this.vars = vars;
    }

    public boolean includes(VariableSet a)
    {
        return vars.containsAll(a.vars);
    }

    public VariableSet union(VariableSet vs)
    {
        Set<String> temp = new HashSet<>(vars);
        temp.addAll(vs.vars);
        return new VariableSet(temp);
    }

    public VariableSet intersect(VariableSet vs)
    {
        Set<String> temp = new HashSet<>(vars);
        temp.retainAll(vs.vars);
        return new VariableSet(temp);
    }

    public VariableSet remove(VariableSet vs)
    {
        Set<String> temp = new HashSet<>(vars);
        temp.removeAll(vs.vars);
        return new VariableSet(temp);
    }

    public String toString()
    {
        if (vars.isEmpty())
            return "{ }";

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String string : vars)
        {
            sb.append(string).append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}

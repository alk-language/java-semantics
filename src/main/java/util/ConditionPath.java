package util;

import symbolic.SymbolicValue;

import java.util.ArrayList;
import java.util.List;

public class ConditionPath
{
    List<SymbolicValue> conditions = new ArrayList<>();

    public void add(SymbolicValue symbolicValue)
    {
        conditions.add(symbolicValue);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (SymbolicValue value : conditions)
        {
            sb.append(value.toString()).append(" && ");
        }
        return sb.toString();
    }
}

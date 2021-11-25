package util;

import util.pc.PathCondition;
import util.types.Storable;

import java.util.HashMap;
import java.util.Map;

public class Recurrence
{
    String id;
    Map<PathCondition, Storable> initial = new HashMap<>();
    Map<PathCondition, Storable> recurring = new HashMap<>();

    public Recurrence(String id)
    {
        this.id = id;
    }

    public void addInitial(Storable value, PathCondition pc)
    {
        this.initial.put(pc, value);
    }

    public void addRecurring(Storable value, PathCondition pc)
    {
        this.recurring.put(pc, value);
    }

    public String toString(String loop, int padding)
    {
        StringBuilder pad = new StringBuilder();
        for (int i=0; i<padding; i++)
        {
            pad.append(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<PathCondition, Storable> entry : initial.entrySet())
        {
            sb.append(pad).append(id).append(loop).append("(0)").append(" = ").append(entry.getValue()).append(" when ").append(entry.getKey().toString()).append("\n");
        }
        for (Map.Entry<PathCondition, Storable> entry : recurring.entrySet())
        {
            sb.append(pad).append(id).append(loop).append("(t").append(loop).append("+1)").append(" = ")
                    .append(entry.getValue()).append(" when ").append(entry.getKey().toString()).append("\n");
        }
        return sb.toString();
    }
}

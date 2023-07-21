package ro.uaic.info.alk.control;

public class ConditionalEdgeData
implements EdgeData
{
    boolean condition;

    public ConditionalEdgeData(boolean condition)
    {
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return condition ? "true-edge" : "false-edge";
    }

    @Override
    public boolean getCondition()
    {
        return condition;
    }
}

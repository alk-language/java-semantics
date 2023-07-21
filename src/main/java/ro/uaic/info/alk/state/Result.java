package ro.uaic.info.alk.state;

public class Result <T>
{
    protected T value;

    public Result(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        if (value == null)
            return "null";
        return value.toString();
    }
}

package util.functions;

public class Parameter
{
    String id;
    boolean out;

    public Parameter(String name, boolean out)
    {
        this.id = name;
        this.out = out;
    }

    public boolean isOut() {
        return out;
    }

    public String getName() {
        return id;
    }
}

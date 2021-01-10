package visitor;

public interface Visitable
{
    <T> T accept(VisitorIface<T> visitor);
}

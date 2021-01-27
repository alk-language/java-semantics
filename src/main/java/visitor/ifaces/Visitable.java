package visitor.ifaces;

public interface Visitable
{
    <T> T accept(VisitorIface<T> visitor);
}

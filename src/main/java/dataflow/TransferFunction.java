package dataflow;

public interface TransferFunction<T extends Domain>
{
    T get(CFGEdge node, T input);
}

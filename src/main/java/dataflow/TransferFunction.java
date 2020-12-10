package dataflow;

public interface TransferFunction<T extends Domain>
{
    T get(CFGNode node, T input);
}

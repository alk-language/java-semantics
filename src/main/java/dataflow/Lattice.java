package dataflow;

import java.util.Set;

public interface Lattice <T extends Domain>
{
    /* true if a <= b */
    boolean compare(T a, T b);
    T getLUB(Set<T> set);
    T getGLB(Set<T> set);
    T getTop();
    T getBottom();
}

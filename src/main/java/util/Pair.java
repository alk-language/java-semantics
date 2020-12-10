package util;

public class Pair<T, S> implements Comparable<Pair<T, S> >{
    public T x;
    public S y;

    public Pair(T x, S y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj)
    {
        Pair pair = (Pair) obj;
        return x.equals(pair.x) && y.equals(pair.y);
    }

    @Override
    public int compareTo(Pair<T, S> o) {
        if (equals(o)) return 0;
        if (x.equals(o.x))
            return y.toString().compareTo(o.y.toString());
        return x.toString().compareTo(o.x.toString());
    }
}

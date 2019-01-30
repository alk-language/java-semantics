package impl.types.AlkSet;

import impl.types.AlkIterableValue;
import impl.types.AlkValue;

import java.util.Iterator;
import java.util.TreeSet;

public class AlkSet extends AlkIterableValue {

    private TreeSet<AlkValue> set;

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
        isIterable = true;
        set = new TreeSet<>();;
    }

    @Override
    public String toString() {
        return set.toString();
    }

    @Override
    public Iterator<AlkValue> iterator() {
        return set.iterator();
    }
}

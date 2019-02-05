package impl.types.alkSet;

import impl.exceptions.AlkException;
import impl.types.AlkIterableValue;
import impl.types.AlkValue;

import java.util.Iterator;
import java.util.TreeSet;

import static impl.exceptions.AlkException.*;

public class AlkSet extends AlkIterableValue {

    private TreeSet<AlkValue> set;

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
        isIterable = true;
        set = new TreeSet<>();
    }

    public void insert(AlkValue value)
    {
        set.add(value);
    }

    @Override public AlkValue union(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_UNION_NO_SET);
        AlkSet union = new AlkSet();
        union.set.addAll(set);
        union.set.addAll(((AlkSet)operand).set);
        return union;
    }

    @Override public AlkValue intersect(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_INTERSECT_NO_SET);
        AlkSet intersect = new AlkSet();
        intersect.set.addAll(set);
        intersect.set.retainAll(((AlkSet)operand).set);
        return intersect;
    }

    @Override public AlkValue setSubtract(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_SET_SUBTRACT_NO_SET);
        AlkSet subtract = new AlkSet();
        subtract.set.addAll(set);
        subtract.set.removeAll(((AlkSet)operand).set);
        return subtract;
    }

    @Override
    public AlkValue clone() {
        AlkSet copy = new AlkSet();
        copy.set = (TreeSet<AlkValue>) set.clone();
        return copy;
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

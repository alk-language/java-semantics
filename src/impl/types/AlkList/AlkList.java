package impl.types.AlkList;

import impl.types.AlkIterableValue;
import impl.types.AlkValue;

import java.util.Iterator;
import java.util.LinkedList;

public class AlkList extends AlkIterableValue {

    private LinkedList<AlkValue> list;

    public AlkList() {
        type = "List";
        isDataStructure = true;
        isIterable = true;
        list = new LinkedList<>();;
    }


    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public Iterator<AlkValue> iterator() {
        return list.iterator();
    }

    public void push_back(AlkValue value) {
        list.addLast(value);
    }
}

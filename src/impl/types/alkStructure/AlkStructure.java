package impl.types.alkStructure;

import impl.Pair;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import java.util.TreeMap;

import static impl.exceptions.AlkException.ERR_NO_COMPONENT;

public class AlkStructure extends AlkValue {

    private TreeMap<String, AlkValue> map;

    public AlkStructure() {
        type = "Structure";
        isDataStructure = true;
        isIterable = false;
        map = new TreeMap<>();
    }

    public void insert(Pair pair)
    {
        map.put((String)pair.x, (AlkValue)pair.y);
    }

    public boolean has(String operand)
    {
        return map.containsKey(operand);
    }

    @Override
    public AlkValue dot(String operand) throws AlkException {
        if (!has(operand))
            throw new AlkException(ERR_NO_COMPONENT);
        return map.get(operand);
    }

    @Override
    public AlkValue clone() {
        AlkStructure copy = new AlkStructure();
        copy.map = (TreeMap<String, AlkValue>) map.clone();
        return copy;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}

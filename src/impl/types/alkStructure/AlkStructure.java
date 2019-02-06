package impl.types.alkStructure;

import impl.Pair;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.alkSet.AlkSet;

import java.util.TreeMap;

import static impl.exceptions.AlkException.*;

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
            map.put(operand, new AlkInt(0));
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

    @Override
    public AlkValue equal(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_EQUAL_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(map.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_LOWER_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(map.toString().compareTo(op.toString())<0);
    }
}

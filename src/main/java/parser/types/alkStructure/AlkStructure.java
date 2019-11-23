package parser.types.alkStructure;

import parser.Pair;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;
import util.types.ComponentValue;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static parser.exceptions.AlkException.*;

public class AlkStructure extends AlkValue implements Cloneable {

    private TreeMap<String, AlkValue> map;

    public AlkStructure() {
        type = "Structure";
        isDataStructure = true;
        isIterable = false;
        map = new TreeMap<>();
    }

    public void insert(ComponentValue pair)
    {
        map.put(pair.getIdentifier(), pair.getValue());
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
        String returnable = "{" ;
        Map.Entry<String, AlkValue> act = null;
        Iterator<Map.Entry<String, AlkValue> > it = map.entrySet().iterator();
        while (it.hasNext()) {
            act = it.next();
            if (!it.hasNext()) break;
            returnable = returnable + act.getKey()+"->"+act.getValue()+" ";
        }
        if (map.size()>0)
            returnable = returnable + act.getKey()+"->"+act.getValue();
        return returnable + "}";
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_EQUAL_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(this.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_LOWER_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(map.toString().compareTo(op.toString())<0);
    }
}

package parser.types.alkArray;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static parser.constants.Constants.MAX_ARRAY;
import static parser.exceptions.AlkException.*;

public class AlkArray extends AlkIterableValue implements Cloneable {

    private ArrayList<AlkValue> array;

    public AlkArray() {
        type = "Array";
        isDataStructure = true;
        isIterable = true;
        array = new ArrayList<>();;
    }

    public void push(AlkValue value)
    {
        array.add(value);
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Array"))
            throw new AlkException(ERR_EQUAL_ARR);
        AlkArray op = (AlkArray) operand;
        return new AlkBool(array.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Array"))
            throw new AlkException(ERR_LOWER_ARR);
        AlkArray op = (AlkArray) operand;
        return new AlkBool(array.toString().compareTo(op.toString())<0);
    }

    public AlkValue get(int index) throws AlkException {
        if (index<0 || index>=MAX_ARRAY)
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);
        while (array.size()<=index)
            array.add(new AlkInt(0));
        return array.get(index);
    }

    @Override
    public AlkValue size()
    {
        return new AlkInt(array.size());
    }

    public void put(int index, AlkValue value) throws AlkException {
        if (index<0 || index>=MAX_ARRAY)
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);
        while (array.size()<=index)
            array.add(new AlkInt(0));
        array.set(index, value);
    }

    public boolean has(AlkValue operator)
    {
        for (AlkValue alkValue : array) {
            try {
                if (((AlkBool) alkValue.equal(operator)).getValue())
                    return true;
            } catch (AlkException | InterpretorException ignored) {}
        }
        return false;
    }

    @Override
    public ArrayList toArray() {
        return (ArrayList) array.clone();
    }

    @Override
    public void addAll(List<AlkValue> values) {
        array.addAll(values);
    }

    @Override
    public AlkValue bracket(int operand) throws AlkException {
        return get(operand);
    }

    @Override
    public AlkValue clone() {
        AlkArray copy = new AlkArray();
        for (AlkValue i : array)
            copy.array.add(i.clone());
        return copy;
    }

    @Override
    public String toString() {
        String returnable = "[" ;
        for (int i=0; i<array.size()-1; i++)
        {
            returnable = returnable + array.get(i).toString() + ", ";
        }
        if (array.size()>0)
            returnable = returnable + array.get(array.size()-1);
        return returnable + "]";
    }

    @Override
    public Iterator<AlkValue> iterator() {
        return array.iterator();
    }
}

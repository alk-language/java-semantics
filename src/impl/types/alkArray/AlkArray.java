package impl.types.alkArray;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;

import java.util.ArrayList;

import static impl.exceptions.AlkException.ERR_ARRAY_OUT_OF_BOUNDS;

public class AlkArray extends AlkValue {

    public ArrayList<AlkValue> array;

    public AlkArray() {
        type = "Array";
        isDataStructure = true;
        array = new ArrayList<>();;
    }

    public void push(AlkValue value)
    {
        array.add(value);
    }
    public AlkValue get(int index) throws AlkException {
        if (index<0 || array.size()<=index)
        {
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);
        }
        return array.get(index);
    }
    public void put(int index, AlkValue value) throws AlkException {
        if (index<0 || array.size()<=index)
        {
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);
        }
        array.set(index, value);
    }

    public boolean has(AlkValue operator)
    {
        for (AlkValue alkValue : array) {
            try {
                if (((AlkBool) alkValue.equal(operator)).value)
                    return true;
            } catch (AlkException | InterpretorException ignored) {}
        }
        return false;
    }

    @Override
    public AlkValue bracket(int operand) throws AlkException {
        return get(operand);
    }

    @Override
    public String toString() {
        return array.toString();
    }

}

package parser.types.alkList;

import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;

import java.util.LinkedList;

import static parser.exceptions.AlkException.*;

public class FunctionListHelper {

    private LinkedList<AlkValue> list;

    FunctionListHelper(LinkedList<AlkValue> list)
    {
        this.list = list;
    }

    public AlkValue at(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt)operand).value.intValueExact();
            if (index<0 || list.size()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            AlkValue value = list.get(index);
            return value;
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_AT_TOOBIG);
        }
    }

    public void insert(AlkValue position, AlkValue value) throws AlkException {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || list.size()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.add(index, value);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_INSERT_TOOBIG);
        }
    }

    public void popBack() throws AlkException {
        if (list.size()==0)
            throw new AlkException(ERR_POPBACK_EMPTY);
        list.removeLast();
    }

    public void popFront() throws AlkException {
        if (list.size()==0)
            throw new AlkException(ERR_POPFRONT_EMPTY);
        list.removeFirst();
    }

    public void pushBack(AlkValue value) {
        list.addLast(value);
    }

    public void pushFront(AlkValue value) {
        list.addFirst(value);
    }

    public void removeAllEqTo(AlkValue value) {
        list.removeIf(value::equals);
    }

    public void removeAt(AlkValue position) throws AlkException {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || list.size()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.remove(index);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_REMOVEAT_TOOBIG);
        }
    }


    public AlkValue size() {
        return new AlkInt(list.size());
    }

    public AlkValue topFront() throws AlkException {
        if (list.size()==0)
            throw new AlkException(ERR_TOPFRONT_EMPTY);
        return list.getFirst();
    }

    public AlkValue topBack() throws AlkException {
        if (list.size()==0)
            throw new AlkException(ERR_TOPBACK_EMPTY);
        return list.getLast();
    }

    public void update(AlkValue position, AlkValue value) throws AlkException {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || list.size()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.set(index, value);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_REMOVEAT_TOOBIG);
        }
    }
}

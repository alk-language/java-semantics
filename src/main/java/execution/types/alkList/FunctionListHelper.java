package execution.types.alkList;

import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;

import java.util.LinkedList;

import static execution.parser.exceptions.AlkException.*;

public class FunctionListHelper {

    private LinkedList<Location> list;

    FunctionListHelper(LinkedList<Location> list)
    {
        this.list = list;
    }

    public Location at(AlkValue operand)
    {
        if (!operand.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt)operand).value.intValueExact();
            if (index < 0 || list.size() <= index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);

            return list.get(index);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_AT_TOOBIG);
        }
    }

    public void insert(AlkValue position, Location loc)
    {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index < 0 || list.size() <= index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.add(index, loc);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_INSERT_TOOBIG);
        }
    }

    public void popBack()
    {
        if (list.size() == 0)
            throw new AlkException(ERR_POPBACK_EMPTY);
        list.removeLast();
    }

    public void popFront()
    {
        if (list.size()==0)
            throw new AlkException(ERR_POPFRONT_EMPTY);
        list.removeFirst();
    }

    public void pushBack(Location value)
    {
        list.addLast(value);
    }

    public void pushFront(Location value)
    {
        list.addFirst(value);
    }

    public void removeAllEqTo(AlkValue value)
    {
        list.removeIf(x -> (((AlkValue)x.toRValue()).equal(value).isTrue()));
    }

    public void removeAt(AlkValue position)
    {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index < 0 || list.size() <= index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.remove(index);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_REMOVEAT_TOOBIG);
        }
    }


    public AlkValue size()
    {
        return new AlkInt(list.size());
    }

    public Location topFront()
    {
        if (list.size()==0)
            throw new AlkException(ERR_TOPFRONT_EMPTY);
        return list.getFirst();
    }

    public Location topBack()
    {
        if (list.size()==0)
            throw new AlkException(ERR_TOPBACK_EMPTY);
        return list.getLast();
    }

    public void update(AlkValue position, Location loc)
    {
        if (!position.type.equals("Int"))
            throw new AlkException(ERR_PARAM);
        try
        {
            int index = ((AlkInt) position).value.intValueExact();
            if (index<0 || list.size()<=index)
                throw new AlkException(ERR_LIST_OUT_OF_BOUNDS);
            list.set(index, loc);
        } catch (ArithmeticException e)
        {
            throw new AlkException(ERR_REMOVEAT_TOOBIG);
        }
    }
}

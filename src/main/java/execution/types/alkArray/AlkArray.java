package execution.types.alkArray;

import execution.types.alkNotAValue.AlkNotAValue;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static execution.parser.constants.Constants.MAX_ARRAY;
import static execution.parser.exceptions.AlkException.*;

public class AlkArray extends AlkIterableValue {

    private ArrayList<Location> array;

    public AlkArray() {
        type = "Array";
        isDataStructure = true;
        array = new ArrayList<>();
    }

    public void push(Location loc)
    {
        array.add(loc);
    }

    public void push(AlkValue value, LocationGenerator generator)
    {
        array.add(generator.generate(value));
    }

    @Override
    public Location at(AlkValue index, LocationGenerator generator)
    {
        if (!(index instanceof AlkInt) ||
            ((AlkInt) index).lower(new AlkInt(0)).isTrue() ||
            ((AlkInt) index).greater(new AlkInt(array.size() - 1)).isTrue())
            throw new AlkException("Can't get at non-integer position.");

        Location loc = get(((AlkInt)index).value.intValueExact(), generator);
        if (loc.toRValue() == null)
            throw new AlkException("Unknown value at this position.");
        return loc;
    }

    @Override
    public AlkValue insert(AlkValue index, Location loc)
    {
        if (!(index instanceof AlkInt) ||
            ((AlkInt) index).lower(new AlkInt(0)).isTrue() ||
            ((AlkInt) index).greater(new AlkInt(array.size() - 1)).isTrue())
            throw new AlkException("Can't insert at non-integer position.");

        int idx = ((AlkInt) index).value.intValueExact();
        array.add(idx, loc);
        return this;
    }

    @Override
    public AlkValue pushBack(Location loc)
    {
        array.add(loc);
        return this;
    }

    @Override
    public AlkValue popBack()
    {
        if (array.size() == 0)
            throw new AlkException("Can't pop back from an empty array");
        array.remove(array.size() - 1);
        return this;
    }

    @Override
    public AlkValue pushFront(Location loc)
    {
        array.add(0, loc);
        return this;
    }

    @Override
    public AlkValue popFront()
    {
        array.remove(0);
        return this;
    }

    @Override
    public AlkValue removeAt(AlkValue index)
    {
        if (!(index instanceof AlkInt) ||
            ((AlkInt) index).lower(new AlkInt(0)).isTrue() ||
            ((AlkInt) index).greater(new AlkInt(array.size() - 1)).isTrue())
            throw new AlkException("Can't remove from invalid position.");
        array.remove(((AlkInt) index).value.intValueExact());
        return this;
    }

    @Override
    public AlkValue removeAllEqTo(AlkValue value)
    {
        List<Location> in = new ArrayList<>();
        for (Location location : array) {
            try
            {
                if (((AlkValue) location.toRValue()).notequal(value).isTrue())
                    in.add(location);
            }
            catch (AlkException e)
            {
                in.add(location);
            }
        }
        array.clear();
        array.addAll(in);
        return this;
    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!operand.type.equals("Array"))
            throw new AlkException(ERR_EQUAL_ARR);
        AlkArray opArray = (AlkArray) operand;

        if (!size().equals(opArray.size()))
        {
            return new AlkBool(false);
        }

        boolean isEqual = true;
        int sz = array.size();
        for (int i = 0; i < sz; i++)
        {
            isEqual = isEqual && ((AlkValue) array.get(i).toRValue()).equal((AlkValue) opArray.array.get(i).toRValue()).isTrue();
        }

        return new AlkBool(isEqual);
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!operand.type.equals("Array"))
            throw new AlkException(ERR_LOWER_ARR);
        AlkArray op = (AlkArray) operand;
        return new AlkBool(this.toString().compareTo(op.toString()) < 0);
    }

    public Location get(int index, LocationGenerator generator)
    {
        if (index < 0 || index >= MAX_ARRAY)
        {
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);
        }

        while (array.size() <= index)
        {
            array.add(generator.generate(new AlkNotAValue()));
        }

        return array.get(index);
    }

    public void put(int index, Location loc, LocationGenerator generator)
    {
        if (index < 0 || index >= MAX_ARRAY)
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);

        while (array.size() <= index)
            array.add(generator.generate(new AlkNotAValue()));

        array.set(index, loc);
    }

    @Override
    public AlkValue size()
    {
        return new AlkInt(array.size());
    }

    public boolean has(AlkValue operator)
    {
        for (Location loc : array)
        {
            try {
                if (loc.toRValue().equals(operator))
                    return true;
                //TODO: Create can't compare exception
            }
            catch (AlkException ignored) {}
        }
        return false;
    }

    @Override
    public List<Location> toArray(LocationGenerator generator)
    {
        return new ArrayList<>(array);
    }

    @Override
    public void addAll(List<Location> locs) {
        array.addAll(locs);
    }

    @Override
    public Location bracket(AlkInt operand, LocationGenerator generator) {
        return get(operand.value.intValueExact(), generator);
    }

    @Override
    public AlkArray weakClone(LocationMapper locationMapper) {
        AlkArray copy = new AlkArray();
        for (Location i : array)
            copy.push(locationMapper.get(i));
        return copy;
    }

    @Override
    public AlkValue clone(LocationGenerator locationGenerator) {
        AlkArray copy = new AlkArray();
        for (Location i : array)
            copy.push(locationGenerator.generate(i.toRValue().clone(locationGenerator)));
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder returnable = new StringBuilder("[");
        for (int i = 0; i < array.size() - 1; i++)
        {
            String string;
            string = array.get(i).toRValue().toString();
            returnable.append(string).append(", ");
        }
        if (array.size() > 0)
            returnable.append(array.get(array.size() - 1).toRValue().toString());
        return returnable + "]";
    }

    @Override
    public Iterator<Location> iterator() {
        return array.iterator();
    }
}

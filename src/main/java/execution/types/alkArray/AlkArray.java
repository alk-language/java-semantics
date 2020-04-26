package execution.types.alkArray;

import execution.types.alkNotAValue.AlkNotAValue;
import parser.env.Location;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static parser.constants.Constants.MAX_ARRAY;
import static parser.exceptions.AlkException.*;

public class AlkArray extends AlkIterableValue {

    private ArrayList<Location> array;

    public AlkArray() {
        type = "Array";
        isDataStructure = true;
        isIterable = true;
        array = new ArrayList<>();
    }

    public void push(Location loc)
    {
        array.add(loc);
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
        // TODO: in-place to increase efficiency
        List<Location> copy = new ArrayList<>();
        copy.add(loc);
        copy.addAll(array);
        array.clear();
        array.addAll(copy);
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

    // TODO: Arrays are not homogeneous, so failed equals should be skipped
    @Override
    public AlkValue removeAllEqTo(AlkValue value)
    {
        List<Location> in = new ArrayList<>();
        for (Location location : array) {
            if (location.toRValue().notequal(value).isTrue())
                in.add(location);
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
        AlkArray op = (AlkArray) operand;
        return new AlkBool(this.toString().equals(op.toString()));
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
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);

        while (array.size() <= index)
            array.add(generator.generate(new AlkNotAValue()));

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

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        AlkArray copy = new AlkArray();
        for (Location loc : array)
            copy.push(locMapping.get(loc));
        return copy;
    }

    public boolean has(AlkValue operator)
    {
        for (Location loc : array)
        {
            if (loc.toRValue().getClass().equals(operator.getClass()) && loc.toRValue().equals(operator))
                return true;
        }
        return false;
    }

    @Override
    public List<Location> toArray(LocationGenerator generator) {
        return array;
    }

    @Override
    public void addAll(List<Location> locs) {
        array.addAll(locs);
    }

    @Override
    public Location bracket(int operand, LocationGenerator generator) {
        return get(operand, generator);
    }

    @Override
    public AlkArray clone(LocationGenerator generator) {
        AlkArray copy = new AlkArray();
        for (Location i : array)
            copy.push(generator.generate(i.toRValue().clone(generator)));
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

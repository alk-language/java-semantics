package execution.types.alkArray;

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
    public void pushBack(Location loc)
    {
        array.add(loc);
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

        while (array.size() < index)
            array.add(generator.generate(new AlkInt(0)));

        if (array.size() == index)
            array.add(generator.generate(null));

        return array.get(index);
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

    public void put(int index, Location loc, LocationGenerator generator)
    {
        if (index < 0 || index >= MAX_ARRAY)
            throw new AlkException(ERR_ARRAY_OUT_OF_BOUNDS);

        while (array.size() <= index)
            array.add(generator.generate(new AlkInt(0)));

        array.set(index, loc);
    }

    public boolean has(AlkValue operator)
    {
        for (Location loc : array)
        {
            if ((loc.toRValue().equal(operator)).isTrue())
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
            returnable.append(array.get(i).toRValue().toString()).append(", ");
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

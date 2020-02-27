package execution.types.alkSet;

import parser.env.Location;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import java.util.*;

import static parser.exceptions.AlkException.*;

public class AlkSet extends AlkIterableValue  {

    private TreeSet<Location> set;

    @Deprecated
    public String contains; //tipuri de date, seturile sunt omogene

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
        isIterable = true;
        set = new TreeSet<>(new SetComparator());
        contains = null;
    }

    @Override
    public AlkValue insert(Location value)
    {
        if (contains == null)
            contains = value.toRValue().type;
        else
        {
            if (!contains.equals(value.toRValue().type))
                throw new AlkException(ERR_NOT_HOMOGENEOUS);
        }
        set.add(value);
        return this;
    }

    @Override
    public AlkValue union(AlkValue operand)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_UNION_NO_SET);

        AlkSet union = new AlkSet();
        union.set.addAll(set);
        union.set.addAll(((AlkSet)operand).set);
        return union;
    }

    @Override
    public AlkValue intersect(AlkValue operand)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_INTERSECT_NO_SET);
        AlkSet intersect = new AlkSet();
        intersect.set.addAll(set);
        intersect.set.retainAll(((AlkSet)operand).set);
        return intersect;
    }

    @Override
    public AlkValue setSubtract(AlkValue operand)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_SET_SUBTRACT_NO_SET);
        AlkSet subtract = new AlkSet();
        subtract.set.addAll(set);
        subtract.set.removeAll(((AlkSet)operand).set);
        return subtract;
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        AlkSet copy = new AlkSet();
        for (Location loc : set)
            copy.set.add(generator.generate(loc.toRValue().clone(generator)));
        copy.contains = contains;
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder returnable = new StringBuilder("{");
        AlkValue act = new AlkBool(false);
        Iterator<Location> it = set.iterator();
        while (it.hasNext()) {
            act = it.next().toRValue();
            if (!it.hasNext()) break;
            returnable.append(act.toString()).append(", ");
        }
        if (set.size() > 0)
            returnable.append(act.toString());
        return returnable + "}";
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_EQUAL_SET);
        AlkSet op = (AlkSet) operand;
        return new AlkBool(this.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_LOWER_SET);
        AlkSet op = (AlkSet) operand;
        return new AlkBool(set.toString().compareTo(op.toString()) < 0);
    }

    @Override
    public AlkSet remove(AlkValue value)
    {
        if (!has(value))
            throw new AlkException(ERR_REMOVE_NO_SUCH_ELEMENT);

        Iterator<Location> it = set.iterator();
        while (it.hasNext()) {
            Location act = it.next();
            if (act.toRValue().equal(value).isTrue())
            {
                it.remove();
                break;
            }
        }
        return this;
    }

    @Override
    public AlkInt size()
    {
        return new AlkInt(set.size());
    }

    @Override
    public Iterator<Location> iterator()
    {
        return set.iterator();
    }

    @Override
    public boolean has(AlkValue operand)
    {
        for (Location loc : set)
        {
            if ((loc.toRValue().equal(operand)).isTrue())
                return true;
        }

        return false;
    }

    @Override
    public List<Location> toArray(LocationGenerator generator)
    {
        return new ArrayList<>(set);
    }

    @Override
    public void addAll(List<Location> values) {
        set.addAll(values);
    }

    @Override
    public AlkValue push(Location loc)
    {
        return insert(loc);
    }
}

class SetComparator implements Comparator<Location>
{
    public int compare(Location loc1, Location loc2)
    {
        return loc1.toRValue().compareTo(loc2.toRValue());
    }
}
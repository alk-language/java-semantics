package execution.types.alkSet;

import parser.env.Location;
import parser.env.LocationMapper;
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

    private Set<Location> set = new TreeSet<>(new SetComparator());

    @Deprecated
    public String contains; //tipuri de date, seturile sunt omogene

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
        isIterable = true;
    }

    @Override
    public AlkValue insert(Location value)
    {
        set.add(value);
        return this;
    }

    @Override
    public AlkValue union(AlkValue operand, LocationGenerator generator)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_UNION_NO_SET);

        AlkSet union = new AlkSet();
        for (Location loc : set)
        {
            union.insert(generator.generate(loc.toRValue().clone(generator)));
        }
        for (Location loc : (AlkSet)operand)
        {
            union.insert(generator.generate(loc.toRValue().clone(generator)));
        }
        return union;
    }

    @Override
    public AlkValue intersect(AlkValue operand, LocationGenerator generator)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_INTERSECT_NO_SET);

        AlkSet intersect = new AlkSet();
        for (Location loc : (AlkSet) operand)
        {
            if (this.has(loc.toRValue()))
            {
                intersect.insert(generator.generate(loc.toRValue().clone(generator)));
            }
        }
        return intersect;
    }

    @Override
    public AlkValue setSubtract(AlkValue operand, LocationGenerator generator)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_SET_SUBTRACT_NO_SET);
        AlkSet subtract = new AlkSet();
        for (Location loc : this)
        {
            if (!((AlkSet) operand).has(loc.toRValue()))
            {
                subtract.insert(generator.generate(loc.toRValue().clone(generator)));
            }
        }
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

    private List<AlkValue> getOrderedList()
    {
        Map<Class<? extends AlkValue>, Set<AlkValue>> mapper = new TreeMap<>(Comparator.comparing(Class::toString));
        for (Location loc : set)
        {
            Class<? extends AlkValue> valueType = loc.toRValue().getClass();
            if (!mapper.containsKey(valueType) || mapper.get(valueType) == null)
                mapper.put(valueType, new TreeSet<>(new ValueComparator()));
            AlkValue val = loc.toRValue();
            mapper.get(valueType).add(val);
        }

        List<AlkValue> list = new ArrayList<>();

        for (Map.Entry<Class<? extends AlkValue>, Set<AlkValue>> e : mapper.entrySet())
        {
            list.addAll(e.getValue());
        }

        return list;
    }

    @Override
    public String toString() {
        StringBuilder returnable = new StringBuilder("{");

        List<AlkValue> list = getOrderedList();

        for (int i=0; i<list.size(); i++)
        {
            returnable.append(list.get(i));
            if (i != list.size() - 1)
                returnable.append(", ");
        }

        returnable.append("}");
        return returnable.toString();
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException
    {
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
        return new AlkBool(this.toString().compareTo(op.toString()) < 0);
    }

    @Override
    public AlkSet remove(AlkValue value)
    {
        if (!has(value))
            throw new AlkException(ERR_REMOVE_NO_SUCH_ELEMENT);

        Iterator<Location> it = set.iterator();
        while (it.hasNext()) {
            Location act = it.next();
            if (act.toRValue().getClass().equals(value.getClass()) && act.toRValue().equals(value))
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
    public AlkValue weakClone(LocationMapper locMapping)
    {
        AlkSet copy = new AlkSet();
        for (Location loc : set)
            copy.set.add(locMapping.get(loc));
        copy.contains = contains;
        return copy;
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
            if (loc.toRValue().getClass().equals(operand.getClass()) && (loc.toRValue().equals(operand)))
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
    public void push(Location loc)
    {
        insert(loc);
    }
}

class ValueComparator implements Comparator<AlkValue>
{
    @Override
    public int compare(AlkValue a, AlkValue b) {
        if (a.equals(b))
            return 0;
        if (a.lower(b).isTrue())
            return -1;
        return 1;
    }
}

class SetComparator implements Comparator<Location>
{
    @Override
    public int compare(Location a, Location b) {
        AlkValue aVal = a.toRValue();
        AlkValue bVal = b.toRValue();

        if (aVal != null && bVal != null && aVal.getClass().equals(bVal.getClass()) && aVal.equals(bVal))
            return 0;
        return a.toString().compareTo(b.toString());
    }
}
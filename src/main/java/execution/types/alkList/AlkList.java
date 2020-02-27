package execution.types.alkList;

import parser.env.Location;
import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkIterator.AlkIterator;
import util.lambda.LocationGenerator;

import java.util.*;

import static parser.exceptions.AlkException.*;

public class AlkList extends AlkIterableValue
{

    private LinkedList<Location> list;

    public AlkList() {
        type = "List";
        isDataStructure = true;
        isIterable = true;
        list = new LinkedList<>();;
    }

    public Location at(AlkValue operand)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.at(operand);
    }

    public AlkIterator first()
    {
        ListIterator it = (ListIterator) this.iterator();
        return new AlkIterator(it, this);
    }

    public AlkIterator end()
    {
        return new AlkIterator(list.listIterator(list.size()), this); // TODO de optimizat
    }

    public AlkValue insert(AlkValue position, Location value)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.insert(position, value);
        return this;
    }

    public AlkValue popBack()
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.popBack();
        return this;
    }

    public AlkValue popFront()
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.popFront();
        return this;
    }

    public AlkValue push(Location value)
    {
        return pushBack(value);
    }

    public AlkValue pushBack(Location value)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.pushBack(value);
        return this;
    }

    public AlkValue pushFront(Location value)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.pushFront(value);
        return this;
    }

    public AlkValue removeAllEqTo(AlkValue value)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.removeAllEqTo(value);
        return this;
    }

    public AlkValue removeAt(AlkValue position)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.removeAt(position);
        return this;
    }

    public AlkValue size() throws AlkException
    {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.size();
    }

    public Location topBack() throws AlkException
    {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.topBack();
    }

    public Location topFront() throws AlkException
    {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.topFront();
    }

    public AlkValue update(AlkValue position, Location value)
    {
        FunctionListHelper help = new FunctionListHelper(list);
        help.update(position, value);
        return this;
    }



    @Override
    public AlkValue clone(LocationGenerator generator)
    {
        AlkList copy = new AlkList();
        for (Location loc : list)
            copy.list.add(generator.generate(loc.toRValue().clone(generator)));
        return copy;
    }

    @Override
    public String toString()
    {
        StringBuilder returnable = new StringBuilder("<");
        for (int i = 0; i < list.size() - 1; i++)
        {
            returnable.append(list.get(i).toRValue().toString()).append(", ");
        }
        if (list.size() > 0)
            returnable.append(list.get(list.size() - 1).toRValue());
        return returnable + ">";
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("List"))
            throw new AlkException(ERR_EQUAL_LIST);
        AlkList op = (AlkList) operand;
        return new AlkBool(this.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("List"))
            throw new AlkException(ERR_LOWER_LIST);
        AlkList op = (AlkList) operand;
        return new AlkBool(list.toString().compareTo(op.toString())<0);
    }

    @Override
    public Iterator<Location> iterator()
    {
        return list.iterator();
    }

    @Deprecated
    public void push_back(Location value)
    {
        list.addLast(value);
    } //TODO de modificat in functia default


    @Override
    public boolean has(AlkValue operand)
    {
        for (Location loc : list)
        {
            if ((loc.toRValue().equal(operand)).isTrue())
                return true;
        }

        return false;
    }

    @Override
    // TODO: location generator is not needed
    public ArrayList<Location> toArray(LocationGenerator generator)
    {
        return new ArrayList<>(list);
    }

    @Override
    public void addAll(List<Location> values)
    {
        list.addAll(values);
    }
}

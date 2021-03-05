package execution.types.alkList;

import ast.AST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NotImplementedException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkIterator.AlkIterator;
import util.lambda.LocationGenerator;

import java.util.*;

import static execution.parser.exceptions.AlkException.*;

//TODO: implement bracket operator
public class AlkList
extends AlkIterableValue
{
    private LinkedList<Location> list;

    public AlkList() {
        type = "List";
        isDataStructure = true;
        list = new LinkedList<>();
    }

    @Override
    public Location at(AlkValue operand, LocationGenerator generator)
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
        return new AlkIterator(list.listIterator(list.size()), this);
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

    public void push(Location value)
    {
        pushBack(value);
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
    public AlkValue weakClone(LocationMapper locMapping) {
        AlkList copy = new AlkList();
        for (Location loc : list)
            copy.list.add(locMapping.get(loc));
        return copy;
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
        StringBuilder returnable = new StringBuilder("< ");
        for (int i = 0; i < list.size() - 1; i++)
        {
            returnable.append(list.get(i).toRValue().toString()).append(", ");
        }
        if (list.size() > 0)
            returnable.append(list.get(list.size() - 1).toRValue());
        return returnable + " >";
    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!operand.type.equals("List"))
            throw new AlkException(ERR_EQUAL_LIST);

        AlkList opList = (AlkList) operand;

        if (!size().equals(opList.size()))
        {
            return new AlkBool(false);
        }

        boolean isEqual = true;
        int sz = list.size();
        for (int i = 0; i < sz; i++)
        {
            isEqual = isEqual && ((AlkValue) list.get(i).toRValue()).equal((AlkValue) opList.list.get(i).toRValue()).isTrue();
        }

        return new AlkBool(isEqual);
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException {
        if (!operand.type.equals("List"))
            throw new AlkException(ERR_LOWER_LIST);
        AlkList op = (AlkList) operand;
        return new AlkBool(this.toString().compareTo(op.toString())<0);
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
            try {
                if (loc.toRValue().equals(operand))
                    return true;
                //TODO: Create can't compare exception
            }
            catch (AlkException ignored) {}
        }
        return false;
    }

    @Override
    public ArrayList<Location> toArray()
    {
        return new ArrayList<>(list);
    }

    @Override
    public void addAll(List<Location> values)
    {
        list.addAll(values);
    }

    @Override
    public AST toAST()
    {
        throw new NotImplementedException("Can't convert to AST an AlkList");
    }
}

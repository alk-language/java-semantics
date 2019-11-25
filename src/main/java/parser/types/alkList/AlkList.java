package parser.types.alkList;

import parser.exceptions.AlkException;
import parser.exceptions.InterpretorException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.types.alkIterator.AlkIterator;

import java.util.*;

import static parser.exceptions.AlkException.*;

public class AlkList extends AlkIterableValue implements Cloneable{

    private LinkedList<AlkValue> list;

    public AlkList() {
        type = "List";
        isDataStructure = true;
        isIterable = true;
        list = new LinkedList<>();;
    }

    public AlkValue at(AlkValue operand) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.at(operand);
    }

    public AlkIterator first() {
        ListIterator it = (ListIterator) this.iterator();
        return new AlkIterator(it, this);
    }

    public AlkIterator end()
    {
        return new AlkIterator(list.listIterator(list.size()), this); // TODO de optimizat
    }

    public AlkValue insert(AlkValue position, AlkValue value) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.insert(position, value);
        return this;
    }

    public AlkValue popBack() throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.popBack();
        return this;
    }

    public AlkValue popFront() throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.popFront();
        return this;
    }

    public AlkValue pushBack(AlkValue value) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.pushBack(value);
        return this;
    }

    public AlkValue pushFront(AlkValue value) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.pushFront(value);
        return this;
    }

    public AlkValue removeAllEqTo(AlkValue value) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.removeAllEqTo(value);
        return this;
    }

    public AlkValue removeAt(AlkValue position) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.removeAt(position);
        return this;
    }

    public AlkValue size() throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.size();
    }

    public AlkValue topBack() throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.topBack();
    }

    public AlkValue topFront() throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        return help.topFront();
    }

    public AlkValue update(AlkValue position, AlkValue value) throws AlkException {
        FunctionListHelper help = new FunctionListHelper(list);
        help.update(position, value);
        return this;
    }



    @Override
    public AlkValue clone() {
        AlkList copy = new AlkList();
        for (AlkValue i : list)
            copy.list.add(i.clone());
        return copy;
    }

    @Override
    public String toString() {
        String returnable = "<" ;
        for (int i=0; i<list.size()-1; i++)
        {
            returnable = returnable + list.get(i).toString() + ", ";
        }
        if (list.size()>0)
            returnable = returnable + list.get(list.size()-1);
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
    public Iterator<AlkValue> iterator() {
        return list.iterator();
    }

    @Deprecated
    public void push_back(AlkValue value) {
        list.addLast(value);
    } //TODO de modificat in functia default


    @Override
    public boolean has(AlkValue operand) {
        return list.contains(operand);
    }

    @Override
    public ArrayList<AlkValue> toArray() {
        return new ArrayList<>(list);
    }

    @Override
    public void addAll(List<AlkValue> values) {
        list.addAll(values);
    }
}

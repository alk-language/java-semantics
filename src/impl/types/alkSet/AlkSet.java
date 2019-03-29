package impl.types.alkSet;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkIterableValue;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import static impl.exceptions.AlkException.*;

public class AlkSet extends AlkIterableValue {

    private TreeSet<AlkValue> set;
    public String contains; //tipuri de date, seturile sunt omogene

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
        isIterable = true;
        set = new TreeSet<>();
        contains = null;
    }

    @Override public AlkValue insert(AlkValue value) throws AlkException {
        if (contains == null)
            contains = value.type;
        else
            if (!contains.equals(value.type))
                throw new AlkException(ERR_NOT_HOMOGENEOUS);
        set.add(value);
        return this;
    }

    @Override public AlkValue union(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_UNION_NO_SET);
        AlkSet union = new AlkSet();
        union.set.addAll(set);
        union.set.addAll(((AlkSet)operand).set);
        return union;
    }

    @Override public AlkValue intersect(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_INTERSECT_NO_SET);
        AlkSet intersect = new AlkSet();
        intersect.set.addAll(set);
        intersect.set.retainAll(((AlkSet)operand).set);
        return intersect;
    }

    @Override public AlkValue setSubtract(AlkValue operand) throws AlkException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_SET_SUBTRACT_NO_SET);
        AlkSet subtract = new AlkSet();
        subtract.set.addAll(set);
        subtract.set.removeAll(((AlkSet)operand).set);
        return subtract;
    }

    @Override
    public AlkValue clone() {
        AlkSet copy = new AlkSet();
        copy.set = (TreeSet<AlkValue>) set.clone();
        return copy;
    }

    @Override
    public String toString() {
        String returnable = "{" ;
        AlkValue act = new AlkBool(false);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            act = (AlkValue) it.next();
            if (!it.hasNext()) break;
            returnable = returnable + act.toString() + ", ";
        }
        if (set.size()>0)
            returnable = returnable + act.toString();
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
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_LOWER_SET);
        AlkSet op = (AlkSet) operand;
        return new AlkBool(set.toString().compareTo(op.toString())<0);
    }

    @Override
    public AlkSet remove(AlkValue value) throws AlkException {
        if (!set.contains(value))
            throw new AlkException(ERR_REMOVE_NO_SUCH_ELEMENT);
        set.remove(value);
        return this;
    }

    @Override
    public AlkInt size()
    {
        return new AlkInt(set.size());
    }

    @Override
    public Iterator<AlkValue> iterator() {
        return set.iterator();
    }

    @Override
    public boolean has(AlkValue operand) {
        return set.contains(operand);
    }

    @Override
    public ArrayList toArray() {
        ArrayList ans = new ArrayList();
        for (AlkValue i : set)
            ans.add(i);
        return ans;
    }
}

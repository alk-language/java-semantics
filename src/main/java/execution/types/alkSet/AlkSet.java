package execution.types.alkSet;

import ast.AST;
import ast.attr.RepresentationASTAttr;
import ast.enums.CompoundValueRepresentation;
import ast.expr.ArrayAST;
import ast.expr.SetAST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NotImplementedException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.ConcreteValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;
import util.types.ASTRepresentable;
import util.types.Storable;

import java.util.*;

import static execution.parser.exceptions.AlkException.*;

public class AlkSet 
extends AlkIterableValue
{

    private Set<Location> set = new HashSet<>();

    @Deprecated
    public String contains; //tipuri de date, seturile sunt omogene

    public AlkSet() {
        type = "Set";
        isDataStructure = true;
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
            if (this.has((AlkValue) loc.toRValue()))
            {
                intersect.insert(generator.generate(loc.toRValue().clone(generator)));
            }
        }
        return intersect;
    }

    @Override
    public AlkValue setsubtract(AlkValue operand, LocationGenerator generator)
    {
        if (!operand.type.equals("Set"))
            throw new AlkException(ERR_SET_SUBTRACT_NO_SET);
        AlkSet subtract = new AlkSet();
        for (Location loc : this)
        {
            if (!((AlkSet) operand).has((AlkValue) loc.toRValue()))
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

    private List<Storable> getOrderedList()
    {
        Map<Class<? extends Storable>, Set<Storable>> mapper = new TreeMap<>(Comparator.comparing(Class::toString));
        for (Location loc : set)
        {
            Class<? extends Storable> valueType = loc.toRValue().getClass();
            if (!mapper.containsKey(valueType) || mapper.get(valueType) == null)
                mapper.put(valueType, new TreeSet<>(new ValueComparator()));
            Storable val = loc.toRValue();
            mapper.get(valueType).add(val);
        }

        List<Storable> list = new ArrayList<>();

        for (Map.Entry<Class<? extends Storable>, Set<Storable>> e : mapper.entrySet())
        {
            list.addAll(e.getValue());
        }

        return list;
    }

    @Override
    public String toString() {
        StringBuilder returnable = new StringBuilder("{");

        List<Storable> list = getOrderedList();

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

        AlkSet opSet = (AlkSet) operand;

        if (!size().equals(opSet.size()))
        {
            return new AlkBool(false);
        }

        boolean isEqual = true;
        for (Location loc : set)
        {
            isEqual = isEqual && opSet.has((AlkValue) loc.toRValue());
        }
        for (Location loc : opSet)
        {
            isEqual = isEqual && this.has((AlkValue) loc.toRValue());
        }

        return new AlkBool(isEqual);
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
    public List<Location> toArray()
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

    @Override
    public void shuffle()
    {
        throw new AlkException("Can't shuffle a set!");
    }

    @Override
    public AST toAST()
    {
        SetAST ast = new SetAST(null);
        RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
        ast.addAttribute(RepresentationASTAttr.class, attr);
        for (Location loc : set)
        {
            if (!(loc.toRValue() instanceof ASTRepresentable))
                throw new NotImplementedException("Can't convert to AST an AlkArray");
            ast.addChild(((ASTRepresentable) loc.toRValue()).toAST());
        }
        return ast;
    }

    @Override
    public boolean isFullConcrete()
    {
        for (Location loc : this)
        {
            if (loc.isUnknown()) continue;
            if (loc.toRValue() instanceof ConcreteValue && ((ConcreteValue) loc.toRValue()).isFullConcrete()) continue;
            return false;
        }
        return true;
    }
}

class ValueComparator implements Comparator<Storable>
{
    @Override
    public int compare(Storable a, Storable b) {
        if (a.equals(b))
            return 0;
        if (a instanceof AlkValue && b instanceof AlkValue)
        {
            if (((AlkValue) a).lower((AlkValue) b).isTrue())
                return -1;
        }
        return 1;
    }
}
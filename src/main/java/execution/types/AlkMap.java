package execution.types;

import ast.AST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.NotImplementedException;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import execution.types.alkSet.AlkSet;
import util.lambda.LocationGenerator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static execution.parser.exceptions.AlkException.ERR_EQUAL_STRUCT;

public class AlkMap
extends AlkValue
{
    private final Map<Location, Location> mapping = new HashMap<>();

    public AlkMap() {

    }

    @Override
    public String toString()
    {
        StringBuilder returnable = new StringBuilder("{");
        if (mapping.isEmpty())
        {
            return "{|->}";
        }

        Map.Entry<Location, Location> act = null;
        Iterator<Map.Entry<Location, Location> > it = mapping.entrySet().iterator();
        while (it.hasNext())
        {
            act = it.next();
            if (!it.hasNext()) break;
            returnable.append(act.getKey().toRValue().toString());
            returnable.append(" |-> ");
            returnable.append(act.getValue().toRValue().toString()).append(" ");
        }

        if (mapping.size() > 0 && act != null)
        {
            returnable.append(act.getKey().toRValue().toString());
            returnable.append(" |-> ");
            returnable.append(act.getValue().toRValue().toString());
        }
        return returnable + "}";
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping)
    {
        AlkMap copy = new AlkMap();
        for (Map.Entry<Location, Location> entry : mapping.entrySet())
        {
            copy.mapping.put(locMapping.get(entry.getKey()), locMapping.get(entry.getValue()));
        }
        return copy;
    }

    @Override
    public AlkValue clone(LocationGenerator generator)
    {
        AlkMap copy = new AlkMap();
        for (Map.Entry<Location, Location> entry : mapping.entrySet())
        {
            copy.mapping.put(
                generator.generate(entry.getKey().toRValue().clone(generator)),
                generator.generate(entry.getValue().toRValue().clone(generator))
            );
        }
        return copy;
    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!(operand instanceof AlkMap))
            throw new AlkException(ERR_EQUAL_STRUCT);

        AlkMap op = (AlkMap) operand;

        if (mapping.size() != op.mapping.size())
        {
            return new AlkBool(false);
        }

        for (Location key : mapping.keySet())
        {
            boolean has = false;
            for (Map.Entry<Location, Location> entry : op.mapping.entrySet())
            {
                if (((AlkValue) entry.getKey().toRValue()).equal((AlkValue) key.toRValue()).isTrue())
                {
                    has = true;
                    break;
                }
            }
            if (!has)
            {
                return new AlkBool(false);
            }

            AlkValue a = (AlkValue) mapping.get(key).toRValue();
            AlkValue b = (AlkValue) op.mapping.get(key).toRValue();

            try
            {
                if (!a.equal(b).isTrue())
                {
                    return new AlkBool(false);
                }
            }
            catch (AlkException e)
            {
                return new AlkBool(false);
            }
        }

        return new AlkBool(true);
    }

    @Override
    public AlkValue keys(LocationGenerator generator)
    {
        AlkSet set = new AlkSet();
        for (Location loc : mapping.keySet())
        {
            set.insert(generator.generate(loc.toRValue().clone(generator)));
        }
        return set;
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!(operand instanceof AlkMap))
            throw new AlkException("The map can be a value in a relational (<) expression only if the second operand is a map.");
        AlkMap op = (AlkMap) operand;
        return new AlkBool(this.toString().compareTo(op.toString()) < 0);
    }

    @Override
    public boolean isFullConcrete()
    {
        for (Location loc : mapping.keySet())
        {
            if (loc.isUnknown()) continue;
            if (loc.toRValue() instanceof ConcreteValue && ((ConcreteValue) loc.toRValue()).isFullConcrete()) continue;
            return false;
        }
        for (Location loc : mapping.values())
        {
            if (loc.isUnknown()) continue;
            if (loc.toRValue() instanceof ConcreteValue && ((ConcreteValue) loc.toRValue()).isFullConcrete()) continue;
            return false;
        }
        return true;
    }

    @Override
    public AST toAST()
    {
        throw new NotImplementedException("Can't convert to AST an AlkMap");
    }

    @Override
    public Location bracket(AlkValue operand, LocationGenerator generator)
    {
        return get(operand, generator);
    }

    public Location get(AlkValue operand, LocationGenerator generator)
    {
        for (Map.Entry<Location, Location> loc : mapping.entrySet())
        {
            try
            {
                if (((AlkValue) loc.getKey().toRValue()).equal(operand).isTrue())
                {
                    return loc.getValue();
                }
            }
            catch (AlkException ignored)
            {

            }
        }
        Location loc = generator.generate(null);
        put(generator.generate(operand.clone(generator)), loc);
        return loc;
    }

    public void put(Location key, Location value)
    {
        for (Location loc : mapping.keySet())
        {
            try
            {
                if (((AlkValue) loc.toRValue()).equal((AlkValue) key.toRValue()).isTrue())
                {
                    mapping.remove(loc);
                    mapping.put(key, value);
                    return;
                }
            }
            catch (AlkException ignored)
            {

            }
        }

        mapping.put(key, value);
    }
}

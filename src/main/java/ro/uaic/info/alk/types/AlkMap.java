package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.uaic.info.alk.exeptions.AlkException.ERR_EQUAL_STRUCT;

@TypeName("map")
public class AlkMap
extends AlkValue
{
    private final Map<Location, Location> mapping = new HashMap<>();

    public AlkMap()
    {

    }

    @Override
    public String toString()
    {
        if (mapping.isEmpty())
        {
            return "{|->}";
        }

        return "{" + mapping.keySet()
                            .stream()
                            .map((key) -> key.toRValue() + " |-> " + mapping.get(key).toRValue())
                            .collect(Collectors.joining(" ")) + "}";
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
            return AlkBool.FALSE;
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
                return AlkBool.FALSE;
            }

            AlkValue a = (AlkValue) mapping.get(key).toRValue();
            AlkValue b = (AlkValue) op.mapping.get(key).toRValue();

            try
            {
                if (!a.equal(b).isTrue())
                {
                    return AlkBool.FALSE;
                }
            }
            catch (AlkException e)
            {
                return AlkBool.FALSE;
            }
        }

        return AlkBool.TRUE;
    }

    @Override
    public AlkValue keys()
    {
        AlkSet set = new AlkSet();
        for (Location loc : mapping.keySet())
        {
            set.insert((AlkValue) loc.toRValue());
        }
        return set;
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!(operand instanceof AlkMap))
            throw new AlkException("The map can be a value in a relational (<) expression only if the second operand is a map.");
        AlkMap op = (AlkMap) operand;
        return AlkBool.get(this.toString().compareTo(op.toString()) < 0);
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

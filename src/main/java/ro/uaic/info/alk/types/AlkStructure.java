package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import ro.uaic.info.alk.util.Pair;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.uaic.info.alk.exeptions.AlkException.*;

@TypeName("structure")
public class AlkStructure
extends AlkValue
{
    private final Map<String, Location> map;

    public AlkStructure()
    {
        map = new LinkedHashMap<>();
    }

    @Override
    public Location dot(String operand, LocationGenerator generator)
    {
        if (!has(operand))
            map.put(operand, generator.generate(AlkNotAValue.INSTANCE));

        return map.get(operand);
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping)
    {
        AlkStructure copy = new AlkStructure();
        for (Map.Entry<String, Location> entry : map.entrySet())
        {
            copy.map.put(entry.getKey(), locMapping.get(entry.getValue()));
        }
        return copy;
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        AlkStructure copy = new AlkStructure();
        for (Map.Entry<String, Location> entry : map.entrySet())
        {
            copy.map.put(entry.getKey(), generator.generate(entry.getValue().toRValue()));
        }
        return copy;
    }

    @Override
    public String toString()
    {
        if (map.isEmpty())
        {
            return "{->}";
        }

        return "{" + map.keySet()
                        .stream()
                        .map((key) -> key + " -> " + map.get(key).toRValue())
                        .collect(Collectors.joining(" ")) + "}";
    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!(operand instanceof AlkStructure))
            throw new AlkException(ERR_EQUAL_STRUCT);

        AlkStructure op = (AlkStructure) operand;

        if (map.size() != op.map.size())
        {
            return AlkBool.FALSE;
        }

        for (String key : map.keySet())
        {
            // TODO this shuld have the other keys as well
            if (!op.has(key))
            {
                return AlkBool.FALSE;
            }

            AlkValue a = (AlkValue) map.get(key).toRValue();
            AlkValue b = (AlkValue) op.map.get(key).toRValue();

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
    public AlkBool lower(AlkValue operand)
    {
        // TODO redo
        if (!(operand instanceof AlkStructure))
            throw new AlkException(ERR_LOWER_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return AlkBool.get(this.toString().compareTo(op.toString())<0);
    }

    @Override
    public AST toAST()
    {
        throw new NotImplementedException("Can't convert to AST an AlkStructure");
    }

    @Override
    public boolean isFullConcrete()
    {
        for (Location loc : map.values())
        {
            if (loc.isUnknown()) continue;
            if (loc.toRValue() instanceof ConcreteValue && ((ConcreteValue) loc.toRValue()).isFullConcrete()) continue;
            return false;
        }
        return true;
    }


    public void put(Pair<String, Location> pair)
    {
        map.put(pair.x, pair.y);
    }

    private boolean has(String operand)
    {
        return map.containsKey(operand);
    }
}

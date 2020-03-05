package execution.types.alkStructure;

import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;
import util.types.ComponentValue;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static parser.exceptions.AlkException.*;

public class AlkStructure extends AlkValue
{
    private TreeMap<String, Location> map;

    public AlkStructure() {
        type = "Structure";
        isDataStructure = true;
        isIterable = false;
        map = new TreeMap<>();
    }

    public void insert(ComponentValue pair)
    {
        map.put(pair.getIdentifier(), pair.getLocation());
    }

    public boolean has(String operand)
    {
        return map.containsKey(operand);
    }

    @Override
    public Location dot(String operand, LocationGenerator generator) throws AlkException {
        if (!has(operand))
            map.put(operand, generator.generate(null));

        return map.get(operand);
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        AlkStructure copy = new AlkStructure();
        for (Map.Entry<String, Location> entry : map.entrySet())
        {
            copy.map.put(entry.getKey(), generator.generate(entry.getValue().toRValue().clone(generator)));
        }
        return copy;
    }

    @Override
    public String toString()
    {
        StringBuilder returnable = new StringBuilder("{");
        Map.Entry<String, Location> act = null;
        Iterator<Map.Entry<String, Location> > it = map.entrySet().iterator();
        while (it.hasNext()) {
            act = it.next();
            if (!it.hasNext()) break;
            returnable.append(act.getKey()).append("->").append(act.getValue().toRValue().toString()).append(" ");
        }

        //TODO: change in proper exception handling
        assert(act != null);

        if (map.size() > 0)
            returnable.append(act.getKey()).append("->").append(act.getValue().toRValue().toString());
        return returnable + "}";
    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_EQUAL_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(this.toString().equals(op.toString()));
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!operand.type.equals("Structure"))
            throw new AlkException(ERR_LOWER_STRUCT);
        AlkStructure op = (AlkStructure) operand;
        return new AlkBool(this.toString().compareTo(op.toString())<0);
    }
}

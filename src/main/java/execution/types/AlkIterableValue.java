package execution.types;

import execution.parser.env.Location;
import util.lambda.LocationGenerator;

import java.util.List;

public abstract class AlkIterableValue
extends AlkValue
implements Iterable<Location>
{
    public abstract boolean has(AlkValue operand);
    public abstract List<Location> toArray();
    public abstract void addAll(List<Location> locs);
    public abstract void push(Location loc);
    public abstract void shuffle();
}

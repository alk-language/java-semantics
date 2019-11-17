package parser.types;

import java.util.ArrayList;
import java.util.List;

public abstract class AlkIterableValue extends AlkValue implements Iterable<AlkValue> {

    public abstract boolean has(AlkValue operand);
    public abstract ArrayList<AlkValue> toArray();
    public abstract void addAll(List<AlkValue> values);
}

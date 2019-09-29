package parser.types;

import java.util.ArrayList;

public abstract class AlkIterableValue extends AlkValue implements Iterable<AlkValue> {

    public abstract boolean has(AlkValue operand);
    public abstract ArrayList toArray();
}

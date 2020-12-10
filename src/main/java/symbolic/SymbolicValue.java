package symbolic;

import util.types.Value;

public interface SymbolicValue extends Value
{
    boolean equals(SymbolicValue value);
}
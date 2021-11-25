package execution.types;

import symbolic.CPValue;
import symbolic.SymbolicValueIface;
import util.types.Storable;

public interface ConcreteValue
extends Storable,
        CPValue,
        SymbolicValueIface
{
    boolean isFullConcrete();
}

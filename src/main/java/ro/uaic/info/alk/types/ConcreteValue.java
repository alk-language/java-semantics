package ro.uaic.info.alk.types;

import ro.uaic.info.alk.symbolic.CPValue;
import ro.uaic.info.alk.symbolic.SymbolicValueIface;
import ro.uaic.info.alk.util.types.Storable;

public interface ConcreteValue
extends Storable,
        CPValue,
        SymbolicValueIface
{
    boolean isFullConcrete();
}

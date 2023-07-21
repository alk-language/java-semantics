package ro.uaic.info.alk.util.pc;

import ro.uaic.info.alk.symbolic.SymbolicValue;

public interface PathConditionListener
{
    void notifySelect(SymbolicValue root, SymbolicValue position);
    void notifyStore(SymbolicValue oldValue, SymbolicValue newValue, SymbolicValue position, SymbolicValue value);
}

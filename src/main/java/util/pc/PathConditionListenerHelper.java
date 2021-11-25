package util.pc;

import symbolic.SymbolicValue;

import java.util.ArrayList;
import java.util.List;

public class PathConditionListenerHelper
{
    List<PathConditionListener> listeners = new ArrayList<>();

    PathConditionListenerHelper(PathCondition condition)
    {
        listeners.add(new ArraySizeListener(condition));
    }

    public void notifySelect(SymbolicValue root, SymbolicValue position)
    {
        for (PathConditionListener listener : listeners)
        {
            listener.notifySelect(root, position);
        }
    }

    public void notifyStore(SymbolicValue oldValue, SymbolicValue newValue, SymbolicValue position, SymbolicValue value)
    {
        for (PathConditionListener listener : listeners)
        {
            listener.notifyStore(oldValue, newValue, position, value);
        }
    }
}

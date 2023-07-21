package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.util.types.Storable;

public class ExecutionResult
extends Result<Storable>
{
    public ExecutionResult(Storable value)
    {
        super(value);
    }

    public Location toLValue()
    {
        return value == null ? null : value.toLValue();
    }

    public Storable toRValue()
    {
        return value == null ? null : value.toRValue();
    }

    public ExecutionResult clone(LocationMapper locationMapper)
    {
        return new ExecutionResult(super.value.weakClone(locationMapper));
    }
}

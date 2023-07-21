package ro.uaic.info.alk.types;

import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public abstract class SimpleAlkValue
extends AlkValue
implements CachableValue
{
    /**
     * Check if this is a concrete value, including nested values.
     *
     * @return   Always {@code true}.
     */
    @Override
    public boolean isFullConcrete()
    {
        return true;
    }

    /**
     * Retrieve a clone that uses a location mapper to remap its nested locations.
     * For this kind of value, this is the same as the in-depth clone.
     *
     * @param   locationMapper
     *          The mapper that allows remapping nested locations.
     *
     * @return  A weak clone of this value
     */
    @Override
    public AlkValue weakClone(LocationMapper locationMapper)
    {
        return clone(null);
    }

    /**
     * Basic override of the clone method, imposed by the abstract parent
     *
     * @return   A copy of this value. As this type is immutable, this is returned.
     */
    @Override
    public AlkValue clone(LocationGenerator generator)
    {
        return this;
    }
}

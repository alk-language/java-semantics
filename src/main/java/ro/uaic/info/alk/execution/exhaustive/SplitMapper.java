package ro.uaic.info.alk.execution.exhaustive;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.storage.LocationMapper;

public class SplitMapper
{

    AlkExecution newExecution;
    LocationMapper locationMapper;
    EnvironmentMapper environmentMapper;

    public SplitMapper(AlkExecution newExecution, LocationMapper locMapping, EnvironmentMapper envMapper)
    {
        this.newExecution = newExecution;
        this.locationMapper = locMapping;
        this.environmentMapper = envMapper;
    }

    public AlkExecution getNewExecution()
    {
        return newExecution;
    }

    public LocationMapper getLocationMapper() {
        return locationMapper;
    }

    public EnvironmentMapper getEnvironmentMapper() {
        return environmentMapper;
    }
}

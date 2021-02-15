package execution.exhaustive;

import execution.Execution;
import execution.parser.env.LocationMapper;

public class SplitMapper
{

    Execution newExecution;
    LocationMapper locationMapper;
    EnvironmentMapper environmentMapper;

    public SplitMapper(Execution newExecution, LocationMapper locMapping, EnvironmentMapper envMapper)
    {
        this.newExecution = newExecution;
        this.locationMapper = locMapping;
        this.environmentMapper = envMapper;
    }

    public Execution getNewExecution()
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

package ro.uaic.info.alk.execution.state;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.storage.LocationMapper;

public class ExecutionCloneContext
{
    public AlkExecution exec;
    public LocationMapper locMapping;

    public ExecutionCloneContext(AlkExecution copy, LocationMapper locMapping)
    {
        this.exec = copy;
        this.locMapping = locMapping;
    }
}

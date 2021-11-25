package execution.state;

import execution.Execution;
import execution.parser.env.LocationMapper;

public class ExecutionCloneContext
{
    public Execution exec;
    public LocationMapper locMapping;

    public ExecutionCloneContext(Execution copy, LocationMapper locMapping)
    {
        this.exec = copy;
        this.locMapping = locMapping;
    }
}

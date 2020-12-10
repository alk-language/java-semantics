package execution.exhaustive;

import execution.parser.env.LocationMapper;
import execution.ExecutionPayload;

public class SplitMapper {

    ExecutionPayload executionPayload;
    LocationMapper locationMapper;
    EnvironmentMapper environmentMapper;

    public SplitMapper(ExecutionPayload executionPayload, LocationMapper locMapping, EnvironmentMapper envMapper) {
        this.executionPayload = executionPayload;
        this.locationMapper = locMapping;
        this.environmentMapper = envMapper;
    }

    public ExecutionPayload getExecutionPayload() {
        return executionPayload;
    }

    public LocationMapper getLocationMapper() {
        return locationMapper;
    }

    public EnvironmentMapper getEnvironmentMapper() {
        return environmentMapper;
    }
}

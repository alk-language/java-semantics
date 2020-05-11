package util;

import parser.env.LocationMapper;

public class SplitMapper {

    Payload payload;
    LocationMapper locationMapper;
    EnvironmentMapper environmentMapper;

    public SplitMapper(Payload payload, LocationMapper locMapping, EnvironmentMapper envMapper) {
        this.payload = payload;
        this.locationMapper = locMapping;
        this.environmentMapper = envMapper;
    }

    public Payload getPayload() {
        return payload;
    }

    public LocationMapper getLocationMapper() {
        return locationMapper;
    }

    public EnvironmentMapper getEnvironmentMapper() {
        return environmentMapper;
    }
}

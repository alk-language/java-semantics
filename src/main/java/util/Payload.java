package util;

import util.exception.InternalWarning;

public class Payload {

    EnvironmentManager envManager;

    public Payload (Object ... loads)
    {
        for (Object load : loads)
        {
            if (load instanceof EnvironmentManager)
                envManager = (EnvironmentManager) load;

            //TODO: log warning if the load is unknown
        }
    }

    public EnvironmentManager getEnvManager() {
        return envManager;
    }
}

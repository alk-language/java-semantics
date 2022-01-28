package util;

import io.IOManager;

public class DummyIOManager
implements IOManager
{
    @Override
    public IOManager getEndpoint()
    {
        return this;
    }

    @Override
    public void write(String text)
    {
        // no-op
    }

    @Override
    public void flush()
    {
        // no-op
    }
}

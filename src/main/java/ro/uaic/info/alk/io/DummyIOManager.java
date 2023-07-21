package ro.uaic.info.alk.io;

import java.io.IOException;

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

    @Override
    public String readLine() throws IOException
    {
        return null;
    }
}

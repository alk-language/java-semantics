package ro.uaic.info.alk.io;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BufferedIOWrapper
implements IOManager
{

    private final IOManager manager;
    private final List<String> buffer = new LinkedList<>();

    public BufferedIOWrapper(IOManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void write(String text)
    {
        buffer.add(text);
    }

    @Override
    public String readLine() throws IOException
    {
        return manager.readLine();
    }

    @Override
    public void flush()
    {
        synchronized (manager)
        {
            for (String text : buffer)
            {
                manager.write(text);
            }
            manager.flush();
            buffer.clear();
        }
    }

    public IOManager getEndpoint()
    {
        BufferedIOWrapper copy = new BufferedIOWrapper(manager);
        for (String text : buffer)
        {
            copy.write(text);
        }
        return copy;
    }
}

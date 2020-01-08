package io;

import java.util.LinkedList;
import java.util.List;

public class BufferedIOWrapper implements IOManager
{

    private final IOManager manager;
    private List<String> buffer = new LinkedList<>();

    public BufferedIOWrapper(IOManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void write(String text)
    {
        manager.write("Hi");
        buffer.add(text);
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
        }
        /*for (String text : buffer)
        {
            manager.write(text);
        }*/
        /*Mutex mutex = new Mutex(manager);
        mutex.lock();
        mutex.unlock();*/
    }
}

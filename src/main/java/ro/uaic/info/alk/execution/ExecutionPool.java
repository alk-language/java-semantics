package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.util.AlkConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ExecutionPool
{
    private final List<AlkExecution> execs = new ArrayList<>();
    private int active = 0;
    private Consumer<AlkExecution> finalCode;

    public ExecutionPool()
    {
        this((e) -> { });
    }

    public ExecutionPool(Consumer<AlkExecution> finalCode)
    {
        this.finalCode = finalCode;
    }

    public synchronized AlkExecution createExecution(AlkConfiguration config,
                                                     ExecutionInterpreter manager)
    {
        AlkExecution exec = new AlkExecution(config, manager);
        execs.add(exec);
        exec.setPool(this);
        return exec;
    }

    public synchronized void incrementActive(AlkExecution e)
    {
        active++;
    }

    public synchronized void decrementActive(AlkExecution e)
    {
        active--;
        finalCode.accept(e);
    }

    public List<ExecutionOutput> runAll()
    {
        for (AlkExecution e : execs)
        {
            e.start();
        }

        do
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } while (active > 0);

        List<ExecutionOutput> outputs = new ArrayList<>();
        for (AlkExecution e : execs)
        {
            outputs.add(e.getOutput());
        }
        return outputs;
    }
}

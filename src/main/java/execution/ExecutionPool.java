package execution;

import execution.state.ExecutionState;
import util.Configuration;
import visitor.stateful.StatefulInterpreterManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ExecutionPool
{
    private final List<Execution> execs = new ArrayList<>();
    private int active = 0;
    private Consumer<Execution> finalCode;

    public ExecutionPool()
    {
        this((e) -> { });
    }

    public ExecutionPool(Consumer<Execution> finalCode)
    {
        this.finalCode = finalCode;
    }

    public synchronized Execution createExecution(Configuration config,
                                                  StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        Execution exec = new Execution(config, manager);
        execs.add(exec);
        exec.setPool(this);
        return exec;
    }

    public synchronized void incrementActive(Execution e)
    {
        active++;
    }

    public synchronized void decrementActive(Execution e)
    {
        active--;
        finalCode.accept(e);
    }

    public List<ExecutionOutput> runAll()
    {
        for (Execution e : execs)
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
        for (Execution e : execs)
        {
            outputs.add(e.getOutput());
        }
        return outputs;
    }
}

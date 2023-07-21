package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.UnwindException;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.Stack;
import java.util.function.Consumer;

public class StatefulStack<T extends State<?, S>, S extends Result<?>>
extends Stack<T>
{
    protected AlkConfiguration conf;

    protected Consumer<UnwindException> handler;

    public StatefulStack(AlkConfiguration conf)
    {
        this(conf, null);
    }

    public StatefulStack(AlkConfiguration conf, Consumer<UnwindException> handler)
    {
        this.conf = conf;
        this.handler = handler;
    }

    public S run()
    {
        S result = null;
        while (!empty())
        {
            try
            {
                result = makeStep();
            }
            catch (UnwindException u)
            {
                propagate(u);
            }
        }
        return result;
    }

    protected void propagate(UnwindException u)
    {
        while (!empty() && !peek().handle(u))
        {
            pop();
        }

        if (empty())
        {
            if (u.isError())
            {
                throw new AlkException(u);
            }
            else
            {
                if (handler != null)
                {
                    handler.accept(u);
                }
            }
        }
    }

    protected S makeStep()
    {
        S result = null;
        T top = peek();
        T next;
        try
        {
            next = (T) top.makeStep();
        }
        catch (InternalException e)
        {
            top.handle(e);
            return null;
        }

        if (next != null)
        {
            push(next);
        }
        else
        {
            result = top.getResult();
            pop();
            if (!empty())
            {
                top = peek();
                try
                {
                    top.assign(result);
                }
                catch (InternalException e)
                {
                    top.handle(e);
                    return null;
                }
            }
        }

        return result;
    }
}

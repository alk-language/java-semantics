package ast;

import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.UnwindException;
import state.Result;
import state.State;
import util.Configuration;
import util.exception.InternalException;

import java.util.Stack;
import java.util.function.Consumer;

public class ASTStack<T extends State>
{
    protected Stack<T> stack = new Stack<>();

    protected Configuration conf;

    protected Consumer<UnwindException> handler;

    private boolean failure = false;

    public ASTStack(Configuration conf)
    {
        this.conf = conf;
        this.handler = null;
    }

    public ASTStack(Configuration conf, Consumer<UnwindException> handler)
    {
        this.conf = conf;
        this.handler = handler;
    }

    public void push(T state)
    {
        stack.push(state);
    }

    public T pop()
    {
        T top = stack.peek();
        stack.pop();
        return top;
    }

    public Result<?> run()
    {
        Result<?> result = null;
        while (!stack.empty())
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
        while (!stack.empty()) {
            T top = stack.peek();
            if (top.handle(u))
                break;
            pop();
        }

        if (stack.empty()) {
            if (u.isError())
                throw new AlkException(u);
            else
            {
                if (handler != null)
                    handler.accept(u);
            }
        }
    }

    protected Result<?> makeStep()
    {
        Result<?> result = null;
        T top = stack.peek();
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

        if (next == null)
        {
            result = top.getResult();
            pop();
            if (!stack.empty())
            {
                top = stack.peek();
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
        else
        {
            push(next);
        }

        return result;
    }
}

package ast;

import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.UnwindException;
import util.Configuration;
import util.exception.InternalException;
import util.types.Value;

import java.util.Stack;

public class ASTStack<T extends State>
{
    protected Stack<T> stack = new Stack<>();

    protected Configuration conf;

    public ASTStack(Configuration conf)
    {
        this.conf = conf;
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

    public void run()
    {
        while (!stack.empty())
        {
            try
            {
                makeStep();
            }
            catch (UnwindException u)
            {
                propagate(u);
            }
        }
    }

    private void propagate(UnwindException u)
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
                conf.getIOManager().write(u.getMessage());
        }
    }

    private void makeStep()
    {
        T top = stack.peek();
        T next = (T) top.makeStep();

        if (next == null)
        {
            Result<?> result = top.getResult();
            pop();
            if (!stack.empty())
            {
                top = stack.peek();
                top.assign(result);
            }
        }
        else
        {
            push(next);
        }
    }
}

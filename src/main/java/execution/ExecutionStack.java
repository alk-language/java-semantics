package execution;

import execution.state.ExecutionState;
import parser.exceptions.AlkException;
import util.Cloner;
import util.Configuration;
import util.ErrorManager;
import util.Payload;
import util.types.Value;

import java.util.Stack;

public class ExecutionStack implements Cloneable
{
    private Configuration config;

    private ExecutionResult result;

    private Stack< ExecutionState<? extends Value, ? extends Value> > stack = new Stack<>();

    ExecutionStack(Configuration config) {
        this.config = config;
    }

    void push(ExecutionState<? extends Value, ? extends Value> state) {
        stack.push(state);
    }

    private void pop()
    {
        stack.pop();
    }

    void run() {
        while (!stack.empty())
        {
            try {
                makeStep();
            } catch (AlkException e) {
                ErrorManager em = config.getErrorManager();
                em.handleError(e);
            }
        }
    }

    private void makeStep()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        ExecutionState<? extends Value, ? extends Value> next = top.makeStep();

        if (next == null)
        {
            ExecutionResult result = top.getResult();
            pop();
            if (!stack.empty())
            {
                top = stack.peek();
                top.assign(result);
            }
            else
            {
                this.result = result;
            }
        }
        else
        {
            push(next);
        }
    }

    public ExecutionResult getResult() {
        return result;
    }

    void nullifyLast()
    {
        ExecutionState<? extends Value, ? extends Value> top = stack.peek();
        ExecutionResult result = top.getResult();
        pop();
        if (!stack.empty())
        {
            top = stack.peek();
            top.assign(result);
        }
        else
        {
            this.result = result;
        }
    }
    
    public ExecutionStack clone(Execution master) {
        ExecutionStack clone = new ExecutionStack(null);
        clone.config = master.getConfiguration();
        if (result != null)
            clone.result = result.clone();
        for (ExecutionState<? extends Value, ? extends Value> state : stack)
        {
            ExecutionState copy = Cloner.clone(state, master);
            clone.stack.push(copy);
        }

        return clone;
    }
}

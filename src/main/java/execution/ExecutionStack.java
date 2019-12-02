package execution;

import execution.state.ExecutionState;
import parser.exceptions.AlkException;
import util.Configuration;
import util.ErrorManager;
import util.types.Value;

import java.util.Stack;

public class ExecutionStack
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
        top.setConfiguration(config);
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
}

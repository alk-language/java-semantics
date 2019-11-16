package execution;

import execution.state.ExecutionState;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import util.Configuration;
import util.ErrorManager;
import util.types.Value;

import java.util.Stack;

public class ExecutionStack
{
    private Configuration config;

    private Stack< ExecutionState<Value, Value> > stack = new Stack<>();

    private ExecutionResult result;

    ExecutionStack(Configuration config) {
        this.config = config;
    }

    void push(ExecutionState<Value, Value> state) {
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
        ExecutionState<Value, Value> top = stack.peek();
        ExecutionState<Value, Value> next = top.makeStep();

        if (next == null)
        {
            ExecutionResult<Value> result = top.getResult();
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

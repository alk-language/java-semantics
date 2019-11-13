package execution;

import execution.state.ExecutionState;

import java.util.Stack;

public class ExecutionStack {

    Stack<ExecutionState> stack = new Stack<>();
    private ExecutionResult result;

    public void push(ExecutionState state) {
        stack.push(state);
    }

    public void pop()
    {
        stack.pop();
    }

    public void run() {
        while (!stack.empty())
        {
            makeStep();
        }
    }

    public void makeStep()
    {
        ExecutionState top = stack.peek();
        ExecutionState next = top.makeStep();

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

package execution;

import execution.exhaustive.ExecutionStateMapper;
import execution.state.function.DefinedFunctionCallState;

import java.util.Stack;

public class CallStack
{
    private Execution master;
    private Stack<DefinedFunctionCallState> stack = new Stack<>();
    private Stack<String> messageStack = new Stack<>();

    public CallStack(Execution master)
    {
        this.master = master;
    }

    public void push(DefinedFunctionCallState f)
    {
        stack.push(f);
        messageStack.push("Entered function " + f.toString());
    }

    public void pop()
    {
        DefinedFunctionCallState f = stack.pop();
        if (!messageStack.empty())
            messageStack.pop();
        else
            messageStack.push("Exited function " + f.toString());
    }

    public void printMessages()
    {
        for (String s : messageStack)
            master.getConfig().getIOManager().write(s);
        master.getConfig().getIOManager().flush();
        messageStack.clear();
    }

    public int size()
    {
        return stack.size();
    }

    public DefinedFunctionCallState get(int index)
    {
        return stack.get(index);
    }

    public boolean empty()
    {
        return stack.empty();
    }

    public CallStack makeClone(Execution master, ExecutionStateMapper stateMapper)
    {
        CallStack clone = new CallStack(master);
        for (DefinedFunctionCallState f : stack)
            clone.stack.push((DefinedFunctionCallState) stateMapper.get(f));
        return clone;
    }
}

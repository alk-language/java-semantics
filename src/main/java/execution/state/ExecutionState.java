package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class ExecutionState
{

    protected ParseTree tree;
    protected alkBaseVisitor visitor;
    protected ExecutionResult result;

    public ExecutionState(ParseTree tree, alkBaseVisitor visitor)
    {
        this.tree = tree;
        this.visitor = visitor;
    }

    public ExecutionResult getResult()
    {
        return result;
    }

    public abstract ExecutionState makeStep();

    public abstract void assign(ExecutionResult result);
}

package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.types.AlkValue;

public abstract class SingleState extends ExecutionState
{

    protected AlkValue localResult;
    private final ParseTree dependency;

    public SingleState(ParseTree tree, alkBaseVisitor visitor, ParseTree dependency) {
        super(tree, visitor);
        this.dependency = dependency;
    }

    @Override
    public ExecutionState makeStep() {
        if (localResult != null)
        {
            result = new ExecutionResult(localResult);
            return null;
        }

        return (ExecutionState) visitor.visit(dependency);
    }

    @Override
    public void assign(ExecutionResult result) {
        localResult = result.getValue();
        localResult = interpretResult();
    }

    protected abstract AlkValue interpretResult();
}

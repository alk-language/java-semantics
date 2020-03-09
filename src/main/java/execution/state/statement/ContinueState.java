package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.exceptions.ContiuneException;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ContinueStmtContext.class)
public class ContinueState extends ExecutionState
{
    public ContinueState(alkParser.ContinueStmtContext tree, Payload payload)
    {
        super(tree, payload);
    }

    @Override
    public ExecutionState makeStep()
    {
        throw new ContiuneException("Can't continue while not in a looping scope.");
    }

    @Override
    public void assign(ExecutionResult result)
    {
        // no-op
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}

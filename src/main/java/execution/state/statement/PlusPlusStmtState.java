package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.PlusPlusStmtContext.class)
public class PlusPlusStmtState extends ExecutionState
{

    private alkParser.PlusPlusStmtContext ctx;

    public PlusPlusStmtState(alkParser.PlusPlusStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        // no - op
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}

package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.exceptions.ReturnException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

@CtxState(ctxClass = alkParser.ReturnStmtContext.class)
public class ReturnState extends ExecutionState
{
    alkParser.ReturnStmtContext ctx;
    AlkValue value;

    public ReturnState(alkParser.ReturnStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (ctx.expression() != null && value == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        throw new ReturnException("Can't use return without scope.", value);
    }

    @Override
    public void assign(ExecutionResult result)
    {
        value = (AlkValue) result.getValue().toRValue().clone(generator);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        ReturnState copy = new ReturnState(ctx, sm.getPayload());
        copy.value = value.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
package execution.state.init;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import parser.env.Location;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.exception.InternalException;

@CtxState(ctxClass = alkParser.VarContext.class)
public class VarState extends ExecutionState {

    private alkParser.VarContext ctx;
    private AlkValue rightSide;
    private Location leftSide;

    public VarState(alkParser.VarContext ctx, Payload payload) {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (rightSide == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression());
        }

        if (leftSide == null)
        {
            return super.request(ExpressionVisitor.class, ctx.ref_name());
        }

        leftSide.assign(rightSide.clone(generator));
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) result.getValue().toRValue();
        }
        else if (leftSide == null)
        {
            leftSide = result.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        throw new InternalException("The VarState shouldn't be cloned.");
    }
}

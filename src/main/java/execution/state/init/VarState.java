package execution.state.init;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.Value;

@CtxState(ctxClass = alkParser.VarContext.class)
public class VarState extends ExecutionState<Value, Value> {

    private alkParser.VarContext ctx;
    private AlkValue rightSide;
    private Location leftSide;

    public VarState(alkParser.VarContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (rightSide == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression());
        }

        getEnv().update(ctx.ID().getText(), rightSide.clone(generator));
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) executionResult.getValue().toRValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        throw new InternalException("The VarState shouldn't be cloned.");
    }
}

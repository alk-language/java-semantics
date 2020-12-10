package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.types.AlkIterableValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_FORALL_ITERABLE_REQUIRED;

@CtxState(ctxClass = alkParser.ForEachStructureContext.class)
public class ForEachState extends LoopingState
{
    private alkParser.ForEachStructureContext ctx;
    private List<Location> source;
    private int step = 0;

    public ForEachState(alkParser.ForEachStructureContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, null, null, null, null);
        this.ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (source == null)
        {
            return request(ExpressionVisitor.class, ctx.expression());
        }

        if (step == source.size())
        {
            return null;
        }

        getEnv().update(ctx.ID().getText(), source.get(step).toRValue().clone(generator));
        step++;
        return request(StmtVisitor.class, ctx.statement());
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (source == null)
        {
            Value value = executionResult.getValue().toRValue();
            if (value instanceof AlkIterableValue)
            {
                source = ((AlkIterableValue) value).toArray(generator);
            }
            else
            {
                super.handle(new AlkException(ERR_FORALL_ITERABLE_REQUIRED));
            }

        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ForEachState copy = new ForEachState(ctx, sm.getExecutionPayload());
        copy.step = this.step;
        for (Location loc : source)
            copy.source.add(sm.getLocationMapper().get(loc));
        return super.decorate(copy, sm);
    }
}

package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.types.AlkIterableValue;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import java.util.List;

import static parser.exceptions.AlkException.ERR_FORALL_ITERABLE_REQUIRED;

@CtxState(ctxClass = alkParser.ForEachStructureContext.class)
public class ForAllState extends LoopingState
{
    private alkParser.ForEachStructureContext ctx;
    private List<Location> source;
    private int step = 0;

    public ForAllState(alkParser.ForEachStructureContext tree, Payload payload) {
        super(tree, payload, null, null, null, null);
        this.ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
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
    public void assign(ExecutionResult result)
    {
        if (source == null)
        {
            Value value = result.getValue().toRValue();
            if (!(value instanceof AlkIterableValue))
                super.handle(new AlkException(ERR_FORALL_ITERABLE_REQUIRED));

            source = ((AlkIterableValue) value).toArray(generator);
        }

    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ForAllState copy = new ForAllState(ctx, sm.getPayload());
        copy.step = this.step;
        for (Location loc : source)
            copy.source.add(sm.getLocationMapper().get(loc));
        return super.decorate(copy, sm);
    }
}

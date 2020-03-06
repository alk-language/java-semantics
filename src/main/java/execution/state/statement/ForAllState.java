package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.AlkIterableValue;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

import java.util.List;

import static parser.exceptions.AlkException.ERR_FORALL_ITERABLE_REQUIRED;

@CtxState(ctxClass = alkParser.ForAllStructureContext.class)
public class ForAllState extends ExecutionState<Value, Value>
{
    alkParser.ForAllStructureContext ctx;
    private List<Location> source;
    int step = 0;

    public ForAllState(alkParser.ForAllStructureContext tree, Payload payload) {
        super(tree, payload);
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
                throw new AlkException(ERR_FORALL_ITERABLE_REQUIRED);

            source = ((AlkIterableValue) value).toArray(generator);
        }

    }

    @Override
    public ExecutionState clone(Payload payload) {
        return null;
    }
}

package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import java.util.List;

import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
@CtxState(ctxClass = alkParser.SelectSpecDefinitionContext.class)
public class SelectSpecDefinitionState extends ExecutionState<AlkArray, Value> {

    private List<Location> source;
    private alkParser.SelectSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private int step;

    public SelectSpecDefinitionState(alkParser.SelectSpecDefinitionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState<Value, Value> makeStep()
    {
        if (source == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression(1));
        }

        if (step == source.size())
        {
            result = new ExecutionResult<>(array);
            return null;
        }

        getEnv().update(ctx.ID().toString(), source.get(step++).toRValue());
        return super.request(ExpressionVisitor.class, ctx.expression(0));
    }

    @Override
    public void assign(ExecutionResult<Value> result) {
        Value resultVal = result.getValue().toRValue();
        if (source == null)
        {
            if (!(resultVal instanceof AlkIterableValue))
                super.handle(new AlkException(ERR_SPEC_ITERABLE_REQUIRED));

            source = ((AlkIterableValue) resultVal).toArray(generator);
            step = 0;
        }
        else
        {
            if (!(resultVal instanceof AlkValue))
                super.handle(new AlkException("An iterable should be filled only with AlkValues."));

            array.push(getStore().malloc().assign(((AlkValue) resultVal).clone(generator)));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        SelectSpecDefinitionState copy = new SelectSpecDefinitionState(ctx, sm.getPayload());
        for (Location value : source)
        {
            copy.source.add(sm.getLocationMapper().get(value));
        }
        copy.array = array.weakClone(sm.getLocationMapper());
        copy.step = step;
        return super.decorate(copy, sm);
    }
}
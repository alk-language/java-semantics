package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.env.EnvironmentProxy;
import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

@CtxState(ctxClass = alkParser.SelectSpecDefinitionContext.class)
public class MapSpecDefinitionState extends ExecutionState<AlkArray, Value> {

    private List<Location> source;
    private alkParser.SelectSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private int step;
    private EnvironmentProxy env;

    public MapSpecDefinitionState(alkParser.SelectSpecDefinitionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (source == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression(1));
        }

        if (step == source.size())
        {
            setResult(new ExecutionResult<>(array));
            return null;
        }

        env = new EnvironmentProxy(getEnv());
        env.addTempEntry(ctx.ID().toString(), source.get(step++).toRValue());
        return super.request(ExpressionVisitor.class, ctx.expression(0), env);
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        Value resultVal = executionResult.getValue().toRValue();
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
        MapSpecDefinitionState copy = new MapSpecDefinitionState(ctx, sm.getExecutionPayload());
        if (source != null)
        {
            for (Location value : source)
            {
                copy.source.add(sm.getLocationMapper().get(value));
            }
        }

        copy.array = array.weakClone(sm.getLocationMapper());
        copy.step = step;

        if (this.env != null)
        {
            copy.env = (EnvironmentProxy) sm.getEnvironmentMapper().get(env);
        }
        return super.decorate(copy, sm);
    }
}
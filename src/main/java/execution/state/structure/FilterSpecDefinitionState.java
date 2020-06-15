package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Environment;
import parser.env.EnvironmentProxy;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

import java.util.List;

import static parser.exceptions.AlkException.ERR_SPEC_BOOL;
import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
@CtxState(ctxClass = alkParser.FilterSpecDefinitionContext.class)
public class FilterSpecDefinitionState extends ExecutionState<AlkValue, Value> {

    private List<Location> source;
    private int step;
    private alkParser.FilterSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private AlkValue validatingValue;
    private EnvironmentProxy env;

    public FilterSpecDefinitionState(alkParser.FilterSpecDefinitionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (source == null)
            return super.request(ExpressionVisitor.class, ctx.expression(0));

        if (step == source.size())
        {
            result = new ExecutionResult<>(array);
            return null;
        }

        validatingValue = source.get(step++).toRValue();

        env = new EnvironmentProxy(getEnv());
        env.addTempEntry(ctx.ID().toString(), validatingValue);
        return super.request(ExpressionVisitor.class, ctx.expression(1), env);
    }

    @Override
    public void assign(ExecutionResult<Value> result) {
        if (source == null)
        {
            AlkValue resultVal = (AlkValue) result.getValue().toRValue();

            if (!(resultVal instanceof AlkIterableValue))
                super.handle(new AlkException(ERR_SPEC_ITERABLE_REQUIRED));

            source = ((AlkIterableValue) resultVal).toArray(generator);
            step = 0;
        }
        else
        {
            if (!(result.getValue().toRValue() instanceof AlkBool))
                super.handle(new AlkException(ERR_SPEC_BOOL));
            if (((AlkBool) result.getValue().toRValue()).isTrue())
                array.push(generator.generate(validatingValue));
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        FilterSpecDefinitionState copy = new FilterSpecDefinitionState((alkParser.FilterSpecDefinitionContext) tree, sm.getPayload());
        copy.step = step;

        if (source != null)
        {
            for (Location value : source)
            {
                copy.source.add(sm.getLocationMapper().get(value));
            }
        }


        if (array != null)
        {
            copy.array = array.weakClone(sm.getLocationMapper());
        }

        if (this.validatingValue != null)
        {
            copy.validatingValue = this.validatingValue.weakClone(sm.getLocationMapper());
        }

        if (this.env != null)
        {
            copy.env = (EnvironmentProxy) sm.getEnvironmentMapper().get(this.env);
        }
        return super.decorate(copy, sm);
    }
}
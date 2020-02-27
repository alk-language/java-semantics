package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

import java.util.List;

import static parser.exceptions.AlkException.ERR_SPEC_BOOL;
import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
@CtxState(ctxClass = alkParser.FilterSpecDefinitionContext.class)
public class FilterSpecDefinitionState extends ExecutionState<AlkValue, AlkValue> {

    private List<Location> source;
    private int step;
    private alkParser.FilterSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private AlkValue validatingValue;

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
        getEnv().update(ctx.ID().toString(), validatingValue);
        return super.request(ExpressionVisitor.class, ctx.expression(1));
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        if (source == null)
        {
            AlkValue resultVal = result.getValue();

            if (!(resultVal instanceof AlkIterableValue))
                throw new AlkException(ERR_SPEC_ITERABLE_REQUIRED);

            source = ((AlkIterableValue) resultVal).toArray(generator);
            step = 0;
        }
        else
        {
            if (!(result.getValue() instanceof AlkBool))
                throw new AlkException(ERR_SPEC_BOOL);
            if (((AlkBool) result.getValue()).isTrue())
                array.push(generator.generate(validatingValue));
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        FilterSpecDefinitionState copy = new FilterSpecDefinitionState((alkParser.FilterSpecDefinitionContext) tree, payload);
        for (Location value : source)
        {
            copy.source.add(generator.generate(value.toRValue().clone(generator)));
        }
        copy.step = step;
        for (Location value : array)
        {
            copy.array.push(generator.generate(value.toRValue().clone(generator)));
        }
        copy.validatingValue = this.validatingValue.clone(generator);
        return super.decorate(copy);
    }
}

/*
        String iterator = ctx.ID().toString();
        ArrayList<AlkValue> array = new ArrayList<>();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue source = (AlkValue) expVisitor.visit(ctx.expression(0));
        if (!source.isIterable)
        {
            AlkException e = new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            e.printException(ctx.start.getLine());
            return array;
        }

        ArrayList<AlkValue> src = ((AlkIterableValue)source).toArray();
        for (AlkValue x : src)
        {
            env.update(iterator, x);
            AlkValue result = (AlkValue) expVisitor.visit(ctx.expression(1));
            if (!result.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_SPEC_BOOL);
                e.printException(ctx.start.getLine());
                return array;
            }
            if (((AlkBool)result).getValue())
                array.add(x);
        }
        return array;*/
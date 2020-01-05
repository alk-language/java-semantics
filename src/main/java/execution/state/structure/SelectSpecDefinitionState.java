package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.CtxState;
import util.Payload;
import util.VisitorFactory;
import util.types.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
@CtxState(ctxClass = alkParser.SelectSpecDefinitionContext.class)
public class SelectSpecDefinitionState extends ExecutionState<AlkArray, AlkValue> {

    private List<AlkValue> source;
    private alkParser.SelectSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private int step;

    public SelectSpecDefinitionState(alkParser.SelectSpecDefinitionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState<AlkValue, Value> makeStep()
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

        getEnv().update(ctx.ID().toString(), source.get(step++));
        return super.request(ExpressionVisitor.class, ctx.expression(0));
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        if (source == null)
        {
            AlkValue resultVal = result.getValue();
            if (!(resultVal instanceof AlkIterableValue))
                throw new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            array.push(result.getValue());
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        SelectSpecDefinitionState copy = new SelectSpecDefinitionState(ctx, payload);
        for (AlkValue value : source)
        {
            copy.source.add(value.clone());
        }

        for (AlkValue value : array)
        {
            copy.array.add(value.clone());
        }
        copy.step = step;

        return super.decorate(copy);
    }
}

/*
        String iterator = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        ArrayList<AlkValue> array = new ArrayList<>();
        AlkValue source = (AlkValue) expVisitor.visit(ctx.expression(1));
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
            AlkValue result = (AlkValue) expVisitor.visit(ctx.expression(0));
            array.add(result);
        }
        return array;*/
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
    private Iterator<AlkValue> iterator;

    public SelectSpecDefinitionState(alkParser.SelectSpecDefinitionContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
    }

    @Override
    public ExecutionState<AlkValue, Value> makeStep()
    {
        alkBaseVisitor visitor = VisitorFactory.create(ExpressionVisitor.class, getEnv(), payload);
        if (source == null)
        {
            return (ExecutionState<AlkValue, Value>) visitor.visit(ctx.expression(1));
        }

        if (!iterator.hasNext())
        {
            result = new ExecutionResult<>(array);
            return null;
        }

        getEnv().update(ctx.ID().toString(), iterator.next());
        return (ExecutionState<AlkValue, Value>) visitor.visit(ctx.expression(0));
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        if (source == null)
        {
            AlkValue resultVal = result.getValue();
            if (!(resultVal instanceof AlkIterableValue))
                throw new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            source = ((AlkIterableValue) resultVal).toArray();
            iterator = source.iterator();
        }
        else
        {
            array.push(result.getValue());
        }
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
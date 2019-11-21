package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.types.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static parser.exceptions.AlkException.ERR_SPEC_BOOL;
import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
public class FilterSpecDefinitionState extends ExecutionState<AlkValue, AlkValue> {

    private List<AlkValue> source;
    private Iterator<AlkValue> iterator;
    private alkParser.FilterSpecDefinitionContext ctx;
    private AlkArray array = new AlkArray();
    private AlkValue validatingValue;

    public FilterSpecDefinitionState(alkParser.FilterSpecDefinitionContext tree, DataStructureVisitor visitor) {
        super(tree, new ExpressionVisitor(visitor.getEnvironment()));
        ctx = tree;
        setEnv(visitor.getEnvironment());
    }

    @Override
    public ExecutionState<AlkValue, ? extends Value> makeStep()
    {
        if (source == null)
            return (ExecutionState<AlkValue, Value>) visitor.visit(ctx.expression(0));

        if (!iterator.hasNext())
        {
            result = new ExecutionResult<>(array);
            return null;
        }

        validatingValue = iterator.next();
        getEnv().update(ctx.ID().toString(), validatingValue);
        return (ExecutionState<AlkValue, Value>) visitor.visit(ctx.expression(1));
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
            if (!(result.getValue() instanceof AlkBool))
                throw new AlkException(ERR_SPEC_BOOL);
            if (((AlkBool) result.getValue()).isTrue())
                array.push(validatingValue);
        }
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
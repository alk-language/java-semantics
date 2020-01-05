package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.statement.ToAssignmentStmtState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkBool.AlkBool;
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

import static parser.exceptions.AlkException.ERR_SPEC_BOOL;
import static parser.exceptions.AlkException.ERR_SPEC_ITERABLE_REQUIRED;

// TODO: make use of temporary environment once there exists an environment stack
@CtxState(ctxClass = alkParser.FilterSpecDefinitionContext.class)
public class FilterSpecDefinitionState extends ExecutionState<AlkValue, AlkValue> {

    private List<AlkValue> source;
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

        validatingValue = source.get(step++);
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

            source = ((AlkIterableValue) resultVal).toArray();
            step = 0;
        }
        else
        {
            if (!(result.getValue() instanceof AlkBool))
                throw new AlkException(ERR_SPEC_BOOL);
            if (((AlkBool) result.getValue()).isTrue())
                array.push(validatingValue);
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        FilterSpecDefinitionState copy = new FilterSpecDefinitionState((alkParser.FilterSpecDefinitionContext) tree, payload);
        for (AlkValue value : source)
        {
            copy.source.add(value.clone());
        }
        copy.step = step;
        for (AlkValue value : array)
        {
            copy.array.add(value.clone());
        }
        copy.validatingValue = this.validatingValue.clone();
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
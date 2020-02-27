package execution.state.statement;

import execution.Execution;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import execution.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import execution.helpers.NonDeterministic;
import util.Cloner;
import util.CtxState;
import util.Payload;

import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_CHOOSE_NOT_ITERABLE;
import static parser.exceptions.AlkException.ERR_CHOSE_ST_BOOL;

@CtxState(ctxClass = alkParser.ChooseStmtContext.class)
public class ChooseStmtState extends ExecutionState
{
    private alkParser.ChooseStmtContext ctx;
    private List<Location> array;
    private List<Location> values = new ArrayList<>();
    private int step = 0;

    public ChooseStmtState(alkParser.ChooseStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (array == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression(0));
        }

        if (ctx.SOTHAT() != null && step < array.size())
        {
            getEnv().update(ctx.ID().getText(), array.get(step).toRValue().clone(generator));
            return super.request(ExpressionVisitor.class, ctx.expression(1));
        }

        if (ctx.SOTHAT() == null)
        {
            values = array;
        }

        AlkArray arr = new AlkArray();
        arr.addAll(values);
        AlkValue value = NonDeterministic.choose(arr.toArray(generator)).toRValue();

        if (!getConfig().hasExhaustive())
        {
            getEnv().update(ctx.ID().getText(), value.clone(generator));
        }
        else
        {
            int size = ((AlkInt)arr.size()).value.intValueExact();
            for (int i = 0; i < size - 1; i++)
            {
                Execution current = getExec();
                getEnv().update(ctx.ID().getText(), arr.get(i, generator).toRValue().clone(generator));
                Execution next = current.clone(true);
                next.start();
            }
            getEnv().update(ctx.ID().getText(), arr.get(size-1, generator).toRValue().clone(generator));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (array == null)
        {
            if (result.getValue() instanceof AlkIterableValue)
            {
                array = ((AlkIterableValue) result.getValue()).toArray(generator);
            }
            else
            {
                throw new AlkException(ERR_CHOOSE_NOT_ITERABLE);
            }
        }
        else
        {
            assert(ctx.SOTHAT() != null);

            if (result.getValue() instanceof AlkBool)
            {
                if (((AlkBool)result.getValue()).isTrue())
                    values.add(array.get(step));
                step++;
            }
            else
            {
                throw new AlkException(ERR_CHOSE_ST_BOOL);
            }
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ChooseStmtState copy = new ChooseStmtState((alkParser.ChooseStmtContext) tree, payload);
        copy.step = step;
        //copy.array = Cloner.clone(array, generator);
        //copy.values = Cloner.clone(values, generator);
        return super.decorate(copy);
    }
}

/*
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
        AlkValue struct = (AlkValue)expressionVisitor.visit(ctx.expression(0));
        if (!struct.isIterable)
        {
            AlkException e = new AlkException(ERR_CHOOSE_NOT_ITERABLE);
            e.printException(ctx.start.getLine());
        }
        AlkIterableValue val = (AlkIterableValue) struct;

        if (val.toArray().size()==0)
        {
            AlkException e = new AlkException(ERR_CHOSE_RESULT);
            e.printException(ctx.start.getLine());
        }

        if (ctx.SOTHAT()==null)
        {
            AlkValue value = NonDeterministic.choose(val);
            env.update(ctx.ID().getText(), value.clone());
        }
        else
        {
            AlkValue value = null;
            try {
                value = NonDeterministic.chooseST(ctx.ID().getText(), val, ctx.expression(1), env);
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
            }
            env.update(ctx.ID().getText(), value.clone());
        }
        return null;*/
package execution.state.statement;

import execution.Execution;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.helpers.NonDeterministic;
import util.CtxState;
import util.Payload;

import java.util.ArrayList;

import static parser.exceptions.AlkException.ERR_CHOOSE_NOT_ITERABLE;
import static parser.exceptions.AlkException.ERR_CHOSE_ST_BOOL;

@CtxState(ctxClass = alkParser.ChooseStmtContext.class)
public class ChooseStmtState extends ExecutionState
{
    private alkParser.ChooseStmtContext ctx;
    private ArrayList<AlkValue> array;
    private ArrayList<AlkValue> values = new ArrayList<>();
    private int step = 0;

    public ChooseStmtState(alkParser.ChooseStmtContext ctx, Payload payload)
    {
        super(ctx, payload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        alkBaseVisitor visitor = new ExpressionVisitor(getEnv(), payload);

        if (array == null)
        {
            return (ExecutionState) visitor.visit(ctx.expression(0));
        }

        if (ctx.SOTHAT() != null && step < array.size())
        {
            getEnv().update(ctx.ID().getText(), array.get(step).clone());
            return (ExecutionState) visitor.visit(ctx.expression(1));
        }

        if (ctx.SOTHAT() == null)
        {
            values = array;
        }

        AlkArray arr = new AlkArray();
        arr.addAll(values);
        AlkValue value = NonDeterministic.choose(arr);

        if (!config.hasExhaustive())
        {
            getEnv().update(ctx.ID().getText(), value.clone());
        }
        else
        {
            int size = ((AlkInt)arr.size()).value.intValueExact();
            for (int i = 0; i < size - 1; i++)
            {
                Execution current = payload.getExecution();
                getEnv().update(ctx.ID().getText(), arr.get(i).clone());
                Execution next = current.clone(true);
                next.start();
            }
            getEnv().update(ctx.ID().getText(), arr.get(size-1).clone());
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
                array = ((AlkIterableValue) result.getValue()).toArray();
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
package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.helpers.NonDeterministic;

import static parser.exceptions.AlkException.ERR_CHOOSE_NOT_ITERABLE;

public class ChooseStmtState extends ExecutionState
{

    private alkParser.ChooseStmtContext ctx;
    private AlkIterableValue iterable;

    public ChooseStmtState(alkParser.ChooseStmtContext ctx, StmtVisitor visitor)
    {
        super(ctx, new ExpressionVisitor(visitor.getEnvironment()));
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (iterable == null)
        {
            return (ExecutionState) visitor.visit(ctx.expression(0));
        }

        // TODO: implement SoThat
        if (!config.hasExhaustive())
        {
            AlkValue value = NonDeterministic.choose(iterable);
            env.update(ctx.ID().getText(), value.clone());
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (iterable == null)
        {
            if (result.getValue() instanceof AlkIterableValue)
            {
                iterable = (AlkIterableValue) result.getValue();
            }
            else
            {
                throw new AlkException(ERR_CHOOSE_NOT_ITERABLE);
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
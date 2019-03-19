package impl.visitors.structure;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.Pair;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkIterableValue;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

import static impl.exceptions.AlkException.*;

public class DataStructureVisitor extends alkBaseVisitor {


    protected Environment env;

    public DataStructureVisitor(Environment env) {
        this.env = env;
    }

    public Pair visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue x = (AlkValue) expVisitor.visit(ctx.expression(0));
        AlkValue y = (AlkValue) expVisitor.visit(ctx.expression(1));
        try {
            if (!x.type.equals("Int") || !y.type.equals("Int")) {
                throw new AlkException(ERR_NOINT_INTERVAL);
            }
            if ((x.greater(y)).value) {
                throw new AlkException(ERR_LIMIT);
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new Pair<>(new AlkInt(new BigInteger("0")), new AlkInt(new BigInteger("0")));
        } catch (InterpretorException e) {
            e.printException(ctx.start.getLine());
            return new Pair<>(new AlkInt(new BigInteger("0")), new AlkInt(new BigInteger("0")));
        }
        return new Pair<>(x, y);
    }

    public ArrayList visitSpecDefinition(alkParser.SpecDefinitionContext ctx) {
        /*String iterator = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        Pair limits = (Pair) visit(ctx.interval());
        ArrayList<AlkValue> array = new ArrayList<>();
        for (BigInteger i = ((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1"))) {
            env.update(iterator, new AlkInt(i));
            array.add((AlkValue) expVisitor.visit(ctx.expression()));
        }*/
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
            if (((AlkBool)result).value)
                array.add(x);
        }
        return array;
    }

    public Pair visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        String comp = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) expVisitor.visit(ctx.expression());
        return new Pair<>(comp, value);
    }

}

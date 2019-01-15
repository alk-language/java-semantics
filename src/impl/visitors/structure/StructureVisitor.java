package impl.visitors.structure;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.Pair;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.math.BigDecimal;
import java.math.BigInteger;

import static impl.exceptions.AlkException.ERR_LIMIT;
import static impl.exceptions.AlkException.ERR_NOINT_INTERVAL;

public class StructureVisitor extends alkBaseVisitor {

    protected Environment env;

    public StructureVisitor(Environment env) {
        this.env = env;
    }


    @Override public AlkValue visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx) {
        int size = ctx.expression().size();
        AlkArray array = new AlkArray();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        for (int i=0; i<size; i++)
            array.push((AlkValue) expVisitor.visit(ctx.expression(i)));
        return array;
    }


    @Override public AlkValue visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx) {
        Pair limits = (Pair)visit(ctx.interval());
        try {
            if (((AlkBool)(((AlkInt)limits.x).greater(((AlkInt)limits.y)))).value)
            {
                throw new AlkException(ERR_LIMIT);
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        } catch (InterpretorException e) {
            e.printException(ctx.start.getLine());
        }
        AlkArray array = new AlkArray();
        for (BigInteger i=((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1")))
            array.push(new AlkInt(i));
        return array;
    }

    @Override public Pair visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue x = (AlkValue) expVisitor.visit(ctx.expression(0));
        AlkValue y = (AlkValue) expVisitor.visit(ctx.expression(1));
        if (!x.type.equals("Int") || !y.type.equals("Int"))
        {
            AlkException e = new AlkException(ERR_NOINT_INTERVAL);
            e.printException(ctx.start.getLine());
            return new Pair<>(new AlkInt(new BigInteger("0")), new AlkInt(new BigInteger("0")));
        }
        return new Pair<>(x, y);
    }
}

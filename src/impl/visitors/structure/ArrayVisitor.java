package impl.visitors.structure;

import grammar.alkParser;
import impl.Pair;
import impl.env.Environment;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

public class ArrayVisitor extends DataStructureVisitor {

    public ArrayVisitor(Environment env) {
        super(env);
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
        AlkArray array = new AlkArray();
        for (BigInteger i=((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1")))
            array.push(new AlkInt(i));
        return array;
    }

    @Override public AlkValue visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx) {
        ArrayList array = (ArrayList) visit(ctx.spec());
        AlkArray returnable = new AlkArray();
        for (Object value : array)
            returnable.push((AlkValue) value);
        return returnable;
    }
}

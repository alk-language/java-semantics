package impl.visitors.structure;

import grammar.alkParser;
import impl.Pair;
import impl.env.Environment;
import impl.types.alkSet.AlkSet;
import impl.types.AlkValue;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

public class SetVisitor extends DataStructureVisitor
{
    public SetVisitor(Environment env) {
        super(env);
    }


    public AlkValue visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx) {
        int size = ctx.expression().size();
        AlkSet set = new AlkSet();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        for (int i=0; i<size; i++)
            set.insert((AlkValue) expVisitor.visit(ctx.expression(i)));
        return set;
    }

    public AlkValue visitEmptySet(alkParser.EmptySetContext ctx) {
        return new AlkSet();
    }


    public AlkValue visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        Pair limits = (Pair)visit(ctx.interval());
        AlkSet set = new AlkSet();
        for (BigInteger i = ((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1")))
            set.insert(new AlkInt(i));
        return set;
    }


    public AlkValue visitSetWithSpec(alkParser.SetWithSpecContext ctx) {
        ArrayList set = (ArrayList) visit(ctx.spec());
        AlkSet returnable = new AlkSet();
        for (Object value : set)
            returnable.insert((AlkValue) value);
        return returnable;
    }
}

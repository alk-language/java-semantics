package parser.visitors.structure;

import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.exceptions.AlkException;
import parser.types.alkSet.AlkSet;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;

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
            try {
                set.insert((AlkValue) expVisitor.visit(ctx.expression(i)));
            } catch (AlkException e)
            {
                e.printException(ctx.start.getLine());
                return set;
            }
        return set;
    }

    public AlkValue visitEmptySet(alkParser.EmptySetContext ctx) {
        return new AlkSet();
    }


    public AlkValue visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        Pair limits = (Pair)visit(ctx.interval());
        AlkSet set = new AlkSet();
        for (BigInteger i = ((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1")))
            try {
                set.insert(new AlkInt(i));
            } catch (AlkException e)
            {
                e.printException(ctx.start.getLine());
                return set;
            }
        return set;
    }


    public AlkValue visitSetWithSpec(alkParser.SetWithSpecContext ctx) {
        ArrayList set = (ArrayList) visit(ctx.spec());
        AlkSet returnable = new AlkSet();
        for (Object value : set) {
            try {
                returnable.insert((AlkValue) value);
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
                return returnable;
            }
        }
        return returnable;
    }
}

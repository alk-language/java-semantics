package parser.visitors.structure;

import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.alkList.AlkList;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

public class ListVisitor extends DataStructureVisitor {

    public ListVisitor(Environment env) {
        super(env);
    }

    public AlkValue visitListWithExpressions(alkParser.ListWithExpressionsContext ctx) {
        int size = ctx.expression().size();
        AlkList list = new AlkList();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        for (int i=0; i<size; i++)
            list.push_back((AlkValue) expVisitor.visit(ctx.expression(i)));
        return list;
    }

    public AlkValue visitEmptyList(alkParser.EmptyListContext ctx) {
        return new AlkList();
    }


    public AlkValue visitListWithInterval(alkParser.ListWithIntervalContext ctx) {
        Pair limits = (Pair)visit(ctx.interval());
        AlkList list = new AlkList();
        for (BigInteger i = ((AlkInt) limits.x).value; i.compareTo(((AlkInt) limits.y).value) <= 0; i = i.add(new BigInteger("1")))
            list.push_back(new AlkInt(i));
        return list;
    }


    public AlkValue visitListWithSpec(alkParser.ListWithSpecContext ctx) {
        ArrayList array = (ArrayList) visit(ctx.spec());
        AlkList returnable = new AlkList();
        for (Object value : array)
            returnable.push_back((AlkValue) value);
        return returnable;
    }


}

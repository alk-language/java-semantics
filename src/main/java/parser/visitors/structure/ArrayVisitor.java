package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.ArrayWithExpressionsState;
import execution.state.structure.ArrayWithIntervalState;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

public class ArrayVisitor extends DataStructureVisitor {

    public ArrayVisitor(Environment env) {
        super(env);
    }

    @Override
    public ExecutionState visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
    {
        return new ArrayWithExpressionsState(ctx, this);
    }


    @Override
    public ExecutionState visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
    {
        return new ArrayWithIntervalState(ctx, this);
    }

    @Override public AlkValue visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx) {
        ArrayList array = (ArrayList) visit(ctx.spec());
        AlkArray returnable = new AlkArray();
        for (Object value : array)
            returnable.push((AlkValue) value);
        return returnable;
    }
}

package parser.visitors.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.alkArray.AlkArray;
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

    public ExecutionState visitListWithExpressions(alkParser.ListWithExpressionsContext ctx) {
        return new IterableWithExpressionsState(ctx, env, ctx.expression(), AlkList.class);
    }

    public ExecutionState visitEmptyList(alkParser.EmptyListContext ctx) {
        return new ExecutionState(ctx, this) {
            @Override
            public ExecutionState makeStep() {
                result = new ExecutionResult<>(new AlkList());
                return null;
            }

            @Override
            public void assign(ExecutionResult result) {
                // no-op
            }
        };
    }


    public ExecutionState visitListWithInterval(alkParser.ListWithIntervalContext ctx) {
        return new IterableWithIntervalState(ctx, this, ctx.interval(), AlkList.class);
    }


    public AlkValue visitListWithSpec(alkParser.ListWithSpecContext ctx) {
        ArrayList array = (ArrayList) visit(ctx.spec());
        AlkList returnable = new AlkList();
        for (Object value : array)
            returnable.push_back((AlkValue) value);
        return returnable;
    }


}

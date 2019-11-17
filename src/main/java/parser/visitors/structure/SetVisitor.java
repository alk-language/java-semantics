package parser.visitors.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.expression.PrimitiveState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
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


    public ExecutionState visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx) {
        return new IterableWithExpressionsState(ctx, env, ctx.expression(), AlkSet.class);
    }

    public ExecutionState visitEmptySet(alkParser.EmptySetContext ctx) {
        return new PrimitiveState(ctx, this, new AlkSet());
    }


    public ExecutionState visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        return new IterableWithIntervalState(ctx, this, ctx.interval(), AlkSet.class);
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

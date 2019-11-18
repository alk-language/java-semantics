package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.expression.PrimitiveState;
import grammar.alkParser;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;

public class IntValueState extends PrimitiveState {

    public IntValueState(alkParser.IntValueContext ctx, ExpressionVisitor visitor) {
        super(ctx, visitor, new AlkInt(new BigInteger(ctx.INT().toString())));
    }

}

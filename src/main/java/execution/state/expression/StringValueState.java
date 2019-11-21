package execution.state.expression;

import execution.state.ExecutionState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkString.AlkString;
import parser.visitors.expression.ExpressionVisitor;

public class StringValueState extends PrimitiveState {
    public StringValueState(alkParser.StringValueContext ctx, ExpressionVisitor visitor) {
        super(ctx, visitor, new AlkString(ctx.STRING().toString().substring(1, ctx.STRING().toString().length()-1)));
    }
}

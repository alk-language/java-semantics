package execution.state.expression;

import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.visitors.expression.ExpressionVisitor;

public class BoolValueState extends PrimitiveState {
    public BoolValueState(alkParser.BoolValueContext ctx, ExpressionVisitor visitor) {
        super(ctx, visitor, new AlkBool(ctx.BOOL().toString().equals("true")));
    }
}

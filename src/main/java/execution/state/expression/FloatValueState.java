package execution.state.expression;

import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkFloat.AlkFloat;
import parser.visitors.expression.ExpressionVisitor;

import java.math.BigDecimal;

public class FloatValueState extends PrimitiveState {
    public FloatValueState(alkParser.DoubleValueContext ctx, ExpressionVisitor visitor)
    {
        super(ctx, visitor, new AlkFloat(new BigDecimal(ctx.DOUBLE().toString())));
    }
}

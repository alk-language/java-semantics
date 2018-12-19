package impl.visitors.expression;
import impl.exceptions.AlkException;
import impl.env.Environment;
import grammar.*;
import impl.exceptions.InterpretorException;
import impl.helpers.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import static impl.constants.Constants.DEBUG;

public class ExpressionVisitor extends alkBaseVisitor {

    private Environment env;

    public ExpressionVisitor(Environment env) {
        this.env = env;
    }


    @Override public AlkValue visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx) {
        int size = ctx.multiplicative_expression().size();
        AlkValue result = (AlkValue)visit(ctx.multiplicative_expression(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "+":
                            result = result.add((AlkValue) visit(ctx.multiplicative_expression(i)));
                            break;
                    case "-":
                            result = result.subtract((AlkValue) visit(ctx.multiplicative_expression(i)));
                            break;
                }
            }
        }
        catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return result;
        }
        catch (InterpretorException e)
        {
            if (DEBUG)
                e.printException(ctx.start.getLine());
            return result;
        }
        return result;
    }


    /// Scalar values

    @Override public AlkValue visitIntValue(alkParser.IntValueContext ctx) {
        return new AlkInt(new BigInteger(ctx.INT().toString()));
    }

    @Override public AlkValue visitDoubleValue(alkParser.DoubleValueContext ctx) {
        return new AlkDouble(new BigDecimal(ctx.DOUBLE().toString()));
    }

    @Override public AlkValue visitBoolValue(alkParser.BoolValueContext ctx) {
        return new AlkBool(ctx.BOOL().toString().equals("true"));
    }

    @Override public AlkValue visitStringValue(alkParser.StringValueContext ctx) {
        String value = ctx.STRING().toString();
        value = value.substring(1, value.length()-1);
        return new AlkString(value);
    }

}

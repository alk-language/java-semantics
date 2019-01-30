package impl.visitors.expression;
import impl.exceptions.AlkException;
import impl.env.Environment;
import grammar.*;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkInt.AlkInt;
import impl.types.alkString.AlkString;
import impl.types.AlkValue;
import impl.visitors.ReferenceVisitor;
import impl.visitors.structure.ArrayVisitor;
import impl.visitors.structure.ListVisitor;

import java.math.BigDecimal;
import java.math.BigInteger;

import static impl.constants.Constants.DEBUG;
import static impl.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

public class ExpressionVisitor extends alkBaseVisitor {

    private Environment env;

    public ExpressionVisitor(Environment env) {
        this.env = env;
    }

    @Override public AlkValue visitConditionalExpression(alkParser.ConditionalExpressionContext ctx) {
        AlkValue result = (AlkValue)visit(ctx.logical_or_expression());
        if (ctx.expression().size()==0)
            return result;
        if (!result.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_CONDITIONAL_NO_BOOL);
            e.printException(ctx.start.getLine());
            return result;
        }
        if (((AlkBool)result).value)
            return (AlkValue) visit(ctx.expression(0));
        else
            return (AlkValue) visit(ctx.expression(1));
    }


    @Override public AlkValue visitLogicalOrExpression(alkParser.LogicalOrExpressionContext ctx) {
        int size = ctx.logical_and_expression().size();
        AlkValue result = (AlkValue)visit(ctx.logical_and_expression(0));
        try {
            for (int i = 1; i < size; i++)
                result = result.logicalOr((AlkValue) visit(ctx.logical_and_expression(i)));
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

    @Override public AlkValue visitLogicalAndExpression(alkParser.LogicalAndExpressionContext ctx) {
        int size = ctx.in_expression().size();
        AlkValue result = (AlkValue)visit(ctx.in_expression(0));
        try {
            for (int i = 1; i < size; i++)
                result = result.logicalAnd((AlkValue) visit(ctx.in_expression(i)));
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


    @Override public AlkValue visitInExpression(alkParser.InExpressionContext ctx) {
        int size = ctx.equality_expression().size();
        AlkValue result = (AlkValue)visit(ctx.equality_expression(0));
        try {
            for (int i = 1; i < size; i++)
                result = result.in((AlkValue) visit(ctx.equality_expression(i)));
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


    @Override public AlkValue visitEqualityExpression(alkParser.EqualityExpressionContext ctx) {
        int size = ctx.relational_expression().size();
        AlkValue result = (AlkValue)visit(ctx.relational_expression(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "==":
                        result = result.equal((AlkValue) visit(ctx.relational_expression(i)));
                        break;
                    case "!=":
                        result = result.notequal((AlkValue) visit(ctx.relational_expression(i)));
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

    @Override public AlkValue visitRelationalExpression(alkParser.RelationalExpressionContext ctx) {
        int size = ctx.bitwise_or().size();
        AlkValue result = (AlkValue)visit(ctx.bitwise_or(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "<=":
                        result = result.lowereq((AlkValue) visit(ctx.bitwise_or(i)));
                        break;
                    case "<":
                        result = result.lower((AlkValue) visit(ctx.bitwise_or(i)));
                        break;
                    case ">=":
                        result = result.greatereq((AlkValue) visit(ctx.bitwise_or(i)));
                        break;
                    case ">":
                        result = result.greater((AlkValue) visit(ctx.bitwise_or(i)));
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


    @Override public AlkValue visitBitwiseOrExpression(alkParser.BitwiseOrExpressionContext ctx) {
        int size = ctx.bitwise_and().size();
        AlkValue result = (AlkValue)visit(ctx.bitwise_and(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "|":
                        result = result.bitwiseOr((AlkValue) visit(ctx.bitwise_and(i)));
                        break;
                    case "xor":
                        result = result.bitwiseXor((AlkValue) visit(ctx.bitwise_and(i)));
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


    @Override public AlkValue visitBitwiseAndExpression(alkParser.BitwiseAndExpressionContext ctx) {
        int size = ctx.shift_expression().size();
        AlkValue result = (AlkValue)visit(ctx.shift_expression(0));
        try {
            for (int i = 1; i < size; i++)
                result = result.bitwiseAnd((AlkValue) visit(ctx.shift_expression(i)));
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


    @Override public AlkValue visitShiftExpression(alkParser.ShiftExpressionContext ctx) {
        int size = ctx.additive_expression().size();
        AlkValue result = (AlkValue)visit(ctx.additive_expression(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "<<":
                        result = result.shiftLeft((AlkValue) visit(ctx.additive_expression(i)));
                        break;
                    case ">>":
                        result = result.shiftRight((AlkValue) visit(ctx.additive_expression(i)));
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


    @Override public AlkValue visitMultiplicativeExpression(alkParser.MultiplicativeExpressionContext ctx) {
        int size = ctx.unary_expression().size();
        AlkValue result = (AlkValue)visit(ctx.unary_expression(0));
        try {
            for (int i = 1; i < size; i++) {
                switch (ctx.getChild(i * 2 - 1).getText()) {
                    case "*":
                        result = result.multiply((AlkValue) visit(ctx.unary_expression(i)));
                        break;
                    case "/":
                        result = result.divide((AlkValue) visit(ctx.unary_expression(i)));
                        break;
                    case "%":
                        result = result.mod((AlkValue) visit(ctx.unary_expression(i)));
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


    @Override public AlkValue visitUnaryExpression(alkParser.UnaryExpressionContext ctx) {
        AlkValue result = (AlkValue)visit(ctx.unary_expression());
        try {
                switch (ctx.getChild(0).getText()) {
                    case "*":
                        result = result.star();
                        break;
                    case "+":
                        result = result.positive();
                        break;
                    case "-":
                        result = result.negative();
                        break;
                    case "!":
                        result = result.not();
                        break;
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


    //Factor

    @Override public Object visitParanthesesFactor(alkParser.ParanthesesFactorContext ctx) {
        return visit(ctx.expression());
    }

    @Override public Object visitRefNameFactor(alkParser.RefNameFactorContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        AlkValue value = (AlkValue) refVisitor.visit(ctx.ref_name());
        return value;
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


    //Data Structures

    @Override public AlkValue visitArrayValue(alkParser.ArrayValueContext ctx) {
        ArrayVisitor structVisitator = new ArrayVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.array());
    }


    @Override public AlkValue visitListValue(alkParser.ListValueContext ctx) {
        ListVisitor structVisitator = new ListVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.list());
    }



}

package visitor;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ExpressionVisitor<T> extends alkBaseVisitor<T>
{
    ExpressionInterpreter<T> expressionInterpreter;
    private ArrayVisitor<T> arrayVisitor;
    private ListVisitor<T> listVisitor;
    private SetVisitor<T> setVisitor;
    private StructureVisitor<T> structureVisitor;

    public ExpressionVisitor(ExpressionInterpreter<T> expressionInterpreter)
    {
        this.expressionInterpreter = expressionInterpreter;
        this.arrayVisitor = new ArrayVisitor<>(this, expressionInterpreter);
        this.listVisitor = new ListVisitor<>(this, expressionInterpreter);
        this.setVisitor = new SetVisitor<>(this, expressionInterpreter);
        this.structureVisitor = new StructureVisitor<>(this, expressionInterpreter);
    }

    @Override
    public T visitConditionalExpression(alkParser.ConditionalExpressionContext ctx)
    {
        return visit(ctx.logical_or_expression());
    }

    @Override
    public T visitLogicalOrExpression(alkParser.LogicalOrExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.logical_and_expression(0));
        for (int i = 1; i < ctx.logical_and_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.logical_and_expression(i)));
            result = expressionInterpreter.evaluate(Operator.LOGICALOR, list);
        }
        return result;
    }

    @Override
    public T visitLogicalAndExpression(alkParser.LogicalAndExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.in_expression(0));
        for (int i = 1; i < ctx.in_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.in_expression(i)));
            result = expressionInterpreter.evaluate(Operator.LOGICALAND, list);
        }
        return result;
    }

    @Override
    public T visitInExpression(alkParser.InExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.equality_expression(0));
        for (int i = 1; i < ctx.equality_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.equality_expression(i)));
            result = expressionInterpreter.evaluate(Operator.IN, list);
        }
        return result;
    }

    @Override
    public T visitEqualityExpression(alkParser.EqualityExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.relational_expression(0));
        for (int i = 1; i < ctx.relational_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.relational_expression(i)));
            if (ctx.getChild(2 * i - 1).getText().equals("=="))
                result = expressionInterpreter.evaluate(Operator.EQUAL, list);
            else
                result = expressionInterpreter.evaluate(Operator.NOTEQUAL, list);
        }
        return result;
    }

    @Override
    public T visitRelationalExpression(alkParser.RelationalExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.set_expression(0));
        for (int i = 1; i < ctx.set_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.set_expression(i)));
            switch (ctx.getChild(2 * i - 1).getText())
            {
                case "<":
                    result = expressionInterpreter.evaluate(Operator.LOWER, list);
                    break;
                case "<=":
                    result = expressionInterpreter.evaluate(Operator.LOWEREQ, list);
                    break;
                case ">":
                    result = expressionInterpreter.evaluate(Operator.GREATER, list);
                    break;
                case ">=":
                    result = expressionInterpreter.evaluate(Operator.GREATEREQ, list);
                    break;
            }
        }
        return result;
    }

    @Override
    public T visitSetExpression(alkParser.SetExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.bitwise_or(0));
        for (int i = 1; i < ctx.bitwise_or().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.bitwise_or(i)));
            switch (ctx.getChild(2 * i - 1).getText())
            {
                case "^":
                    result = expressionInterpreter.evaluate(Operator.UNION, list);
                    break;
                case "\\":
                    result = expressionInterpreter.evaluate(Operator.INTERSECT, list);
                    break;
                case "U":
                    result = expressionInterpreter.evaluate(Operator.SETSUBTRACT, list);
                    break;
            }
        }
        return result;
    }

    @Override
    public T visitBitwiseOrExpression(alkParser.BitwiseOrExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.bitwise_and(0));
        for (int i = 1; i < ctx.bitwise_and().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.bitwise_and(i)));
            if (ctx.getChild(2 * i - 1).getText().equals("|"))
                result = expressionInterpreter.evaluate(Operator.BITWISEOR, list);
            else
                result = expressionInterpreter.evaluate(Operator.BITWISEXOR, list);
        }
        return result;
    }

    @Override
    public T visitBitwiseAndExpression(alkParser.BitwiseAndExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.shift_expression(0));
        for (int i = 1; i < ctx.shift_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.shift_expression(i)));
            result = expressionInterpreter.evaluate(Operator.BITWISEAND, list);
        }
        return result;
    }

    @Override
    public T visitShiftExpression(alkParser.ShiftExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.additive_expression(0));
        for (int i = 1; i < ctx.additive_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.additive_expression(i)));
            if (ctx.getChild(2 * i - 1).getText().equals("<<"))
                result = expressionInterpreter.evaluate(Operator.SHIFTLEFT, list);
            else
                result = expressionInterpreter.evaluate(Operator.SHIFTRIGHT, list);
        }
        return result;
    }

    @Override
    public T visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.multiplicative_expression(0));
        for (int i = 1; i < ctx.multiplicative_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.multiplicative_expression(i)));
            if (ctx.getChild(2 * i - 1).getText().equals("+"))
                result = expressionInterpreter.evaluate(Operator.ADD, list);
            else
                result = expressionInterpreter.evaluate(Operator.SUBTRACT, list);
        }
        return result;
    }

    @Override
    public T visitMultiplicativeExpression(alkParser.MultiplicativeExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.unary_expression(0));
        for (int i = 1; i < ctx.unary_expression().size(); i++)
        {
            list.clear();
            list.add(result);
            list.add(visit(ctx.unary_expression(i)));
            switch (ctx.getChild(2 * i - 1).getText())
            {
                case "*":
                    result = expressionInterpreter.evaluate(Operator.MULTIPLY, list);
                    break;
                case "/":
                    result = expressionInterpreter.evaluate(Operator.DIVIDE, list);
                    break;
                case "%":
                    result = expressionInterpreter.evaluate(Operator.MOD, list);
                    break;
            }
        }
        return result;
    }

    @Override
    public T visitPrefixExpression(alkParser.PrefixExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.unary_expression());
        list.add(result);
        switch (ctx.getChild(0).getText())
        {
            case "++":
                result = expressionInterpreter.evaluate(Operator.PLUSPLUSLEFT, list);
                break;
            case "--":
                result = expressionInterpreter.evaluate(Operator.MINUSMINUSLEFT, list);
                break;
        }
        return result;
    }

    @Override
    public T visitToPostfixExpression(alkParser.ToPostfixExpressionContext ctx)
    {
        return visit(ctx.postfix_expression());
    }

    @Override
    public T visitUnaryExpression(alkParser.UnaryExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.unary_expression());
        list.add(result);
        switch (ctx.getChild(0).getText())
        {
            case "+":
                result = expressionInterpreter.evaluate(Operator.POSITIVE, list);
                break;
            case "-":
                result = expressionInterpreter.evaluate(Operator.NEGATIVE, list);
                break;
            case "!":
                result = expressionInterpreter.evaluate(Operator.NOT, list);
                break;
        }
        return result;
    }

    @Override
    public T visitPostfixExpression(alkParser.PostfixExpressionContext ctx)
    {
        List<T> list = new ArrayList<>();
        T result = visit(ctx.factor());
        for (int i = 0; i < ctx.getChildCount() - 1; i++)
        {
            list.clear();
            list.add(result);
            switch (ctx.getChild(0).getText())
            {
                case "++":
                    result = expressionInterpreter.evaluate(Operator.PLUSPLUSRIGHT, list);
                    break;
                case "--":
                    result = expressionInterpreter.evaluate(Operator.MINUSMINUSRIGHT, list);
                    break;
            }
        }
        return result;
    }

    @Override
    public T visitParanthesesFactor(alkParser.ParanthesesFactorContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public T visitRefNameFactor(alkParser.RefNameFactorContext ctx) {
        return visit(ctx.ref_name());
    }

    @Override
    public T visitRefID(alkParser.RefIDContext ctx) {
        return expressionInterpreter.interpretVariable(ctx.ID().getText());
    }

    @Override
    public T visitFactorArray(alkParser.FactorArrayContext ctx) {
        List<T> list = new ArrayList<>();
        list.add(visit(ctx.factor()));
        list.add(visit(ctx.expression()));
        return expressionInterpreter.evaluate(Operator.BRACKET, list);
    }

    @Override
    public T visitToBaseFactor(alkParser.ToBaseFactorContext ctx) {
        return visit(ctx.base_factor());
    }

    @Override
    public T visitIntValue(alkParser.IntValueContext ctx)
    {
        String value = ctx.INT().toString();
        return expressionInterpreter.interpretPrimitive(Primitive.INT, value);
    }

    @Override
    public T visitBoolValue(alkParser.BoolValueContext ctx)
    {
        String value = ctx.BOOL().toString();
        return expressionInterpreter.interpretPrimitive(Primitive.BOOL, value);
    }

    @Override
    public T visitStringValue(alkParser.StringValueContext ctx)
    {
        String value = ctx.STRING().toString();
        return expressionInterpreter.interpretPrimitive(Primitive.STRING, value);
    }

    @Override
    public T visitDoubleValue(alkParser.DoubleValueContext ctx)
    {
        String value = ctx.DOUBLE().toString();
        return expressionInterpreter.interpretPrimitive(Primitive.FLOAT, value);
    }

    @Override
    public T visitArrayValue(alkParser.ArrayValueContext ctx)
    {
        return arrayVisitor.visit(ctx.array());
    }

    @Override
    public T visitListValue(alkParser.ListValueContext ctx)
    {
        return listVisitor.visit(ctx.list());
    }

    @Override
    public T visitSetValue(alkParser.SetValueContext ctx)
    {
        return setVisitor.visit(ctx.set());
    }

    @Override
    public T visitStructureValue(alkParser.StructureValueContext ctx)
    {
        return structureVisitor.visit(ctx.structure());
    }

    static class ArrayVisitor<T> extends alkBaseVisitor<T>
    {
        ExpressionVisitor<T> exprVisitor;
        ExpressionInterpreter<T> expressionInterpreter;
        DataStructureVisitor<T> dataStructureVisitor;

        ArrayVisitor (ExpressionVisitor<T> exprVisitor, ExpressionInterpreter<T> expressionInterpreter)
        {
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
            this.dataStructureVisitor = new DataStructureVisitor<T>(Primitive.ARRAY, exprVisitor, expressionInterpreter);
        }

        @Override
        public T visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
        {
            List<T> values = new ArrayList<>();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                values.add(exprVisitor.visit(ctx.expression(i)));
            }

            return expressionInterpreter.interpretComposite(Primitive.ARRAY, values);
        }

        @Override
        public T visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
        {
            return dataStructureVisitor.visit(ctx.interval());
        }

        @Override
        public T visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx)
        {
            return dataStructureVisitor.visit(ctx.spec());
        }
    }

    static class ListVisitor<T> extends alkBaseVisitor<T>
    {
        ExpressionVisitor<T> exprVisitor;
        ExpressionInterpreter<T> expressionInterpreter;
        DataStructureVisitor<T> dataStructureVisitor;

        ListVisitor (ExpressionVisitor<T> exprVisitor, ExpressionInterpreter<T> expressionInterpreter)
        {
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
            this.dataStructureVisitor = new DataStructureVisitor<T>(Primitive.LIST, exprVisitor, expressionInterpreter);
        }

        @Override
        public T visitEmptyList(alkParser.EmptyListContext ctx) // emptyList <==> < >
        {
            return expressionInterpreter.interpretComposite(Primitive.LIST, null);
        }

        @Override
        public T visitListWithExpressions(alkParser.ListWithExpressionsContext ctx)
        {
            List<T> values = new ArrayList<>();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                values.add(exprVisitor.visit(ctx.expression(i)));
            }

            return expressionInterpreter.interpretComposite(Primitive.LIST, values);
        }

        @Override
        public T visitListWithInterval(alkParser.ListWithIntervalContext ctx)
        {
            return dataStructureVisitor.visit(ctx.interval());
        }

        @Override
        public T visitListWithSpec(alkParser.ListWithSpecContext ctx)
        {
            return dataStructureVisitor.visit(ctx.spec());
        }
    }

    static class SetVisitor<T> extends alkBaseVisitor<T>
    {
        ExpressionVisitor<T> exprVisitor;
        ExpressionInterpreter<T> expressionInterpreter;
        DataStructureVisitor<T> dataStructureVisitor;

        SetVisitor (ExpressionVisitor<T> exprVisitor, ExpressionInterpreter<T> expressionInterpreter)
        {
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
            this.dataStructureVisitor = new DataStructureVisitor<T>(Primitive.SET, exprVisitor, expressionInterpreter);
        }

        @Override
        public T visitEmptySet(alkParser.EmptySetContext ctx) // emptySet <==> { }
        {
            return expressionInterpreter.interpretComposite(Primitive.SET, null);
        }

        @Override
        public T visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx)
        {
            List<T> values = new ArrayList<>();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                values.add(exprVisitor.visit(ctx.expression(i)));
            }

            return expressionInterpreter.interpretComposite(Primitive.SET, values);
        }

        @Override
        public T visitSetWithInterval(alkParser.SetWithIntervalContext ctx)
        {
            return dataStructureVisitor.visit(ctx.interval());
        }

        @Override
        public T visitSetWithSpec(alkParser.SetWithSpecContext ctx)
        {
            return dataStructureVisitor.visit(ctx.spec());
        }
    }

    static class StructureVisitor<T> extends alkBaseVisitor<T>
    {
        ExpressionVisitor<T> exprVisitor;
        ExpressionInterpreter<T> expressionInterpreter;
        List<Pair<String, T>> comps = new ArrayList<>();

        StructureVisitor (ExpressionVisitor<T> exprVisitor, ExpressionInterpreter<T> expressionInterpreter)
        {
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
        }

        @Override
        public T visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx)
        {
            for (int i = 0; i < ctx.component().size(); i++)
                visit(ctx.component(i));

            return expressionInterpreter.interpretCompositeComponents(Primitive.STRUCTURE, comps);
        }

        @Override
        public T visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
        {
            String id = ctx.ID().toString();
            T value = exprVisitor.visit(ctx.expression());
            comps.add(new Pair<>(id, value));
            return null;
        }
    }

    static class DataStructureVisitor<T> extends alkBaseVisitor<T>
    {
        ExpressionVisitor<T> exprVisitor;
        ExpressionInterpreter<T> expressionInterpreter;
        Primitive primitive;

        DataStructureVisitor (Primitive primitive, ExpressionVisitor<T> exprVisitor, ExpressionInterpreter<T> expressionInterpreter)
        {
            this.primitive = primitive;
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
        }

        public T visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
            T left = exprVisitor.visit(ctx.expression(0));
            T right = exprVisitor.visit(ctx.expression(1));
            return expressionInterpreter.interpretCompositeInterval(primitive, left, right);
        }

        public T visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx)
        {
            T fromExpr = exprVisitor.visit(ctx.expression(0));
            return expressionInterpreter.interpretCompositeFilterSpec(primitive, ctx.ID().toString(), fromExpr, (msg) ->
                exprVisitor.visit(ctx.expression(1))
            );
        }

        public T visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx)
        {
            T fromExpr = exprVisitor.visit(ctx.expression(1));
            return expressionInterpreter.interpretCompositeSelectSpec(primitive, ctx.ID().toString(), fromExpr, (msg) ->
                    exprVisitor.visit(ctx.expression(0))
            );
        }
    }

}

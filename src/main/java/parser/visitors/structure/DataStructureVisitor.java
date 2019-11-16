package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.IntervalDefinitionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.exceptions.AlkException;
import parser.exceptions.AlkWarning;
import parser.exceptions.InterpretorException;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

import static parser.exceptions.AlkException.*;
import static parser.exceptions.AlkWarning.WARR_DEPRECATED_SPECS;

public class DataStructureVisitor extends alkBaseVisitor {


    protected Environment env;

    public Environment getEnvironment() {
        return env;
    }

    public DataStructureVisitor(Environment env) {
        this.env = env;
    }

    public ExecutionState visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        return new IntervalDefinitionState(ctx, this);
    }

    @Deprecated
    public ArrayList visitDeprecatedSpecDefinition(alkParser.DeprecatedSpecDefinitionContext ctx) {
        AlkWarning.addWarning(WARR_DEPRECATED_SPECS, ctx.start.getLine());
        String iterator = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        ArrayList<AlkValue> array = new ArrayList<>();
        AlkValue source = (AlkValue) expVisitor.visit(ctx.expression(1));
        if (!source.isIterable)
        {
            AlkException e = new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            e.printException(ctx.start.getLine());
            return array;
        }
        ArrayList<AlkValue> src = ((AlkIterableValue)source).toArray();
        for (AlkValue x : src)
        {
            env.update(iterator, x);
            AlkValue result = (AlkValue) expVisitor.visit(ctx.expression(0));
            array.add(result);
        }
        return array;
    }

    public ArrayList visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx) {
        String iterator = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        ArrayList<AlkValue> array = new ArrayList<>();
        AlkValue source = (AlkValue) expVisitor.visit(ctx.expression(1));
        if (!source.isIterable)
        {
            AlkException e = new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            e.printException(ctx.start.getLine());
            return array;
        }
        ArrayList<AlkValue> src = ((AlkIterableValue)source).toArray();
        for (AlkValue x : src)
        {
            env.update(iterator, x);
            AlkValue result = (AlkValue) expVisitor.visit(ctx.expression(0));
            array.add(result);
        }
        return array;
    }

    public ArrayList visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx) {
        String iterator = ctx.ID().toString();
        ArrayList<AlkValue> array = new ArrayList<>();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue source = (AlkValue) expVisitor.visit(ctx.expression(0));
        if (!source.isIterable)
        {
            AlkException e = new AlkException(ERR_SPEC_ITERABLE_REQUIRED);
            e.printException(ctx.start.getLine());
            return array;
        }

        ArrayList<AlkValue> src = ((AlkIterableValue)source).toArray();
        for (AlkValue x : src)
        {
            env.update(iterator, x);
            AlkValue result = (AlkValue) expVisitor.visit(ctx.expression(1));
            if (!result.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_SPEC_BOOL);
                e.printException(ctx.start.getLine());
                return array;
            }
            if (((AlkBool)result).getValue())
                array.add(x);
        }
        return array;
    }

    public Pair visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        String comp = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) expVisitor.visit(ctx.expression());
        return new Pair<>(comp, value);
    }

}

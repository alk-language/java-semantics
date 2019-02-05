package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.alkBool.AlkBool;
import impl.types.AlkValue;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

import static impl.constants.Constants.param_number;
import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_PARAMS_UNDECLARED;

public class ReferenceVisitor extends alkBaseVisitor {

    private Environment env;
    private AlkValue value;

    public ReferenceVisitor(Environment env) {
        this.env = env;
    }

    @Override public Object visitRefName(alkParser.RefNameContext ctx) {
        int size = ctx.ref_name_chunk().size();
        visit(ctx.ref_name_chunk(0));
        for (int i=1; i<size; i++)
            visit(ctx.ref_name_chunk(i));
        return value;
    }

    @Override public Object visitFunctionChunk(alkParser.FunctionChunkContext ctx) {
        int size = ctx.expression().size();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        //String name = ctx.function_call();
        try {
            if (value == null) // cazul in care suntem inca in primul chunk
                return new AlkBool(false); // TODO de facut dupa ce se fac functiile
            else // cazul in care suntem intr-o componenta (. sau ->)
                visit(ctx.function_call());
            for (int i=0; i<size; i++)
            {
                AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(i));
                if (!idx.type.equals("Int"))
                    throw new AlkException(ERR_NOINT_ARRAY);
                value = value.bracket(((AlkInt)idx).value.intValueExact());
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            value = new AlkBool(false);
        } catch (ArithmeticException ea) {
            AlkException e = new AlkException(ERR_BRACKET_TOOBIG);
            e.printException(ctx.start.getLine());
            value = new AlkBool(false);
        }
        return null;
    }

    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        int size = ctx.expression().size();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        String name = ctx.ID().toString();
        try {
            if (value == null) // cazul in care suntem inca in primul chunk
                value = env.lookup(name);
            else // cazul in care suntem intr-o componenta (. sau ->)
                value = value.dot(name);

            for (int i=0; i<size; i++)
            {
                AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(i));
                if (!idx.type.equals("Int"))
                    throw new AlkException(ERR_NOINT_ARRAY);
                value = value.bracket(((AlkInt)idx).value.intValueExact());
            }
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            value = new AlkBool(false);
        } catch (ArithmeticException ea) {
            AlkException e = new AlkException(ERR_BRACKET_TOOBIG);
            e.printException(ctx.start.getLine());
            value = new AlkBool(false);
        }
        return null;
    }

    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        int size = ctx.expression().size();
        String name = ctx.method_name().start.getText();
        ArrayList<AlkValue> params = new ArrayList<>();
        for (int i=0; i<size; i++)
        {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
            params.add((AlkValue)expressionVisitor.visit(ctx.expression(i)));
        }
        if (!param_number.containsKey(name))
        {
            InterpretorException e = new InterpretorException(ERR_PARAMS_UNDECLARED);
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
        if ((int)param_number.get(name)!=ctx.expression().size())
        {
            AlkException e = new AlkException(ERR_PARAM_NUMBER);
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
        try{
            switch (name)
            {
                case "at": value = value.at(params.get(0)); break;
                case "delete": value = value.delete(); break;
                case "end": value = value.end(); break;
                case "first": value = value.first(); break;
                case "insert": value = value.insert(params.get(0), params.get(1)); break;
                case "popBack": value = value.popBack(); break;
                case "popFront": value = value.popFront(); break;
                case "pushBack": value = value.pushBack(params.get(0)); break;
                case "pushFront": value = value.pushFront(params.get(0)); break;
                case "removeAllEqTo": value = value.removeAllEqTo(params.get(0)); break;
                case "removeAt": value = value.removeAt(params.get(0)); break;
                case "size": value = value.size(); break;
                case "topBack": value = value.topBack(); break;
                case "topFront": value = value.topFront(); break;
                case "update": value = value.update(params.get(0), params.get(1)); break;
            }
        } catch (AlkException e)
        {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
        return new AlkBool(true);
    }
}

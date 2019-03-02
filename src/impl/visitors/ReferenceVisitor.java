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
import impl.visitors.function.FunctionCallVisitor;

import java.util.ArrayList;
import java.util.List;

import static impl.constants.Constants.builtin_methods_name;
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
            {
                FunctionCallVisitor visitor = new FunctionCallVisitor(env);
                value = (AlkValue) visitor.visit(ctx.function_call());
            }
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
            params.add(((AlkValue)expressionVisitor.visit(ctx.expression(i))).clone());
        }
        try{
            switch (name)
            {
                case "at": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.at(params.get(0)); break;
                case "delete": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.delete(); break;
                case "end": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.end(); break;
                case "first": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.first(); break;
                case "insert":
                    if (params.size()==2)
                        value = value.insert(params.get(0), params.get(1));
                    else if (params.size()==1)
                        value = value.insert(params.get(0));
                    else
                        throw new AlkException(ERR_PARAM_NUMBER);
                    break;
                case "popBack": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.popBack(); break;
                case "popFront": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.popFront(); break;
                case "pushBack": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.pushBack(params.get(0)); break;
                case "pushFront": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.pushFront(params.get(0)); break;
                case "remove": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.remove(params.get(0)); break;
                case "removeAllEqTo": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.removeAllEqTo(params.get(0)); break;
                case "removeAt": if (params.size()!=1) throw new AlkException(ERR_PARAM_NUMBER); value = value.removeAt(params.get(0)); break;
                case "size": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.size(); break;
                case "topBack": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.topBack(); break;
                case "topFront": if (params.size()!=0) throw new AlkException(ERR_PARAM_NUMBER); value = value.topFront(); break;
                case "update": if (params.size()!=2) throw new AlkException(ERR_PARAM_NUMBER); value = value.update(params.get(0), params.get(1)); break;
                default: throw new AlkException(ERR_METHOD);
            }
        } catch (AlkException e)
        {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
        return new AlkBool(true);
    }
}

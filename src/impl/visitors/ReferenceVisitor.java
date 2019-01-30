package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.alkArray.AlkArray;
import impl.types.alkBool.AlkBool;
import impl.types.AlkValue;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import static impl.exceptions.AlkException.*;

public class ReferenceVisitor extends alkBaseVisitor {

    private Environment env;

    public ReferenceVisitor(Environment env) {
        this.env = env;
    }



    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        int size = ctx.expression().size();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        String name = ctx.ID().toString();
        if (size>0 && !env.has(name))
        {
            AlkException e = new AlkException(ERR_DATASTRUCTURE_UNDEFINED);
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }

        if (size==0)
        {
            try {
                return env.lookup(name);
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
                return new AlkBool(false);
            }
        }

        AlkValue ref;
        try {
            ref = env.lookup(name);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine()); // Imposibil, am verificat deja mai sus conditiile pentru exceptie
            return new AlkBool(false);
        }

        for (int i=0; i<size-1; i++)
        {
            AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(i));
            if (!idx.type.equals("Int"))
            {
                AlkException e = new AlkException(ERR_NOINT_ARRAY);
                e.printException(ctx.start.getLine());
                return new AlkBool(false);
            }
            try {
                ref = ref.bracket(((AlkInt)idx).value.intValue());
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
                return new AlkBool(false);
            }
        }
        AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size-1));
        if (!idx.type.equals("Int"))
        {
            AlkException e = new AlkException(ERR_NOINT_ARRAY);
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
        try {
            return ref.bracket(((AlkInt)idx).value.intValue());
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }
    }

    /*
    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        String name = ctx.ID().toString();
        AlkValue value;
        try {
            value = env.lookup(name);
            return value;
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return new AlkBool(false);
    }*/
}

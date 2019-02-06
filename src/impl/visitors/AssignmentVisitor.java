package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkInt.AlkInt;
import impl.visitors.expression.ExpressionVisitor;

import static impl.exceptions.AlkException.*;

public class AssignmentVisitor extends alkBaseVisitor {

    private Environment env;
    private AlkValue value;

    /*public AssignmentVisitor(Environment env, AlkValue value) {
        this.env = env; this.value=value;
    }

    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        int size = ctx.expression().size();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        String name = ctx.ID().toString();
        if (size>0 && !env.has(name))
        {
            AlkException e = new AlkException(ERR_DATASTRUCTURE_UNDEFINED);
            e.printException(ctx.start.getLine());
            return null;
        }

        if (size==0)
        {
            AlkValue copy = value.clone();
            env.update(name, copy);
            return null;
        }

        AlkValue ref;
        try {
             ref = env.lookup(name);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine()); // Imposibil, am verificat deja mai sus conditiile pentru exceptie
            return null;
        }

        for (int i=0; i<size-1; i++)
        {
            AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(i));
            if (!idx.type.equals("Int"))
            {
                AlkException e = new AlkException(ERR_NOINT_ARRAY);
                e.printException(ctx.start.getLine());
                return null;
            }
            if (!ref.type.equals("Array"))
            {
                AlkException e = new AlkException(ERR_ARRAY);
                e.printException(ctx.start.getLine());
                return null;
            }
            try {
                ref = ref.bracket(((AlkInt)idx).value.intValue());
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
                return null;
            }
        }
        AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size-1));
        if (!idx.type.equals("Int"))
        {
            AlkException e = new AlkException(ERR_NOINT_ARRAY);
            e.printException(ctx.start.getLine());
            return null;
        }
        if (!ref.type.equals("Array"))
        {
            AlkException e = new AlkException(ERR_ARRAY);
            e.printException(ctx.start.getLine());
            return null;
        }
        try {
            AlkValue copy = value.clone();
            ((AlkArray)ref).put(((AlkInt)idx).value.intValue(), copy);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return null;
        }
        return null;
    }*/
}

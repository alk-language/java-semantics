package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.Pair;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.alkStructure.AlkStructure;
import impl.visitors.expression.ExpressionVisitor;

import static impl.exceptions.AlkException.ERR_BRACKET_TOOBIG;
import static impl.exceptions.AlkException.ERR_NOINT_ARRAY;

public class AssignedVisitor extends alkBaseVisitor {

    private Environment env;
    private AlkValue value;
    private AlkValue left_side;

    private int dot_size=0, dot_act;

    public AssignedVisitor(Environment env, AlkValue value) {
        this.env = env;
        this.value=value;
    }

    @Override public Object visitRefName(alkParser.RefNameContext ctx) {
        dot_size = ctx.ref_name_chunk().size();
        dot_act = 0;
        visit(ctx.ref_name_chunk(0));
        dot_act++;
        for (int i=1; i<dot_size; i++, dot_act++)
            visit(ctx.ref_name_chunk(i));
        return value;
    }

    @Override public Object visitIDChunk(alkParser.IDChunkContext ctx) {
        int size = ctx.expression().size();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        String name = ctx.ID().toString();
        try {
            if (dot_act + 1 == dot_size && size==0) {
                if (dot_size==1) {
                    env.update(name, value);
                    return null;
                }
                else
                {
                    AlkStructure struct = (AlkStructure) left_side;
                    struct.insert(new Pair<>(name, value));
                }
                return null;
            }
            if (left_side == null) // cazul in care suntem inca in primul chunk
            {
                if (!env.has(name))
                {
                    if (size>0)
                        env.update(name, new AlkArray());
                    else
                        env.update(name, new AlkStructure());
                }
                left_side = env.lookup(name);
            }
            else // cazul in care suntem intr-o componenta (. sau ->)
            {
                AlkStructure struct = (AlkStructure) left_side;
                if (!struct.has(name))
                {
                    if (size==0)
                        struct.insert(new Pair<>(name, new AlkStructure()));
                    else
                        struct.insert(new Pair<>(name, new AlkArray()));
                }
                left_side = struct.dot(name);
            }

            for (int i=0; i<size-1; i++) {
                AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(i));
                if (!idx.type.equals("Int"))
                    throw new AlkException(ERR_NOINT_ARRAY);
                int place = ((AlkInt) idx).value.intValueExact();
                AlkArray array = (AlkArray) left_side;
                if (((AlkInt)array.size()).value.intValue()>place)
                {
                    left_side.bracket(place);
                }
                else
                {
                    if (place>0)
                        left_side.bracket(place-1);
                    array = (AlkArray) left_side;
                    array.push(new AlkArray());
                    left_side = array.bracket(place);
                }
            }
            if (dot_act + 1 == dot_size) {
                    AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size - 1));
                    if (!idx.type.equals("Int"))
                        throw new AlkException(ERR_NOINT_ARRAY);
                    int place = ((AlkInt) idx).value.intValueExact();
                    if (place>0)
                        left_side.bracket(place-1);
                    AlkArray array = (AlkArray) left_side;
                    array.push(value);
            }
            else
            {
                if (size>0)
                {
                    AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size-1));
                    if (!idx.type.equals("Int"))
                        throw new AlkException(ERR_NOINT_ARRAY);
                    int place = ((AlkInt) idx).value.intValueExact();
                    AlkArray array = (AlkArray) left_side;
                    if (((AlkInt)array.size()).value.intValue()>place)
                    {
                        left_side.bracket(place);
                    }
                    else {
                        if (place>0)
                            left_side.bracket(place - 1);
                        array = (AlkArray) left_side;
                        array.push(new AlkStructure());
                        left_side = array.bracket(place);
                    }
                }
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
}

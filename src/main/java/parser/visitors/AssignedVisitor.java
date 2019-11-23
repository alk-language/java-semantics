package parser.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.types.alkBool.AlkBool;
import parser.types.alkInt.AlkInt;
import parser.types.alkStructure.AlkStructure;
import parser.visitors.expression.ExpressionVisitor;

import static parser.exceptions.AlkException.*;

// TODO: needs hard reformat

public class AssignedVisitor extends alkBaseVisitor {

    private Environment env;
    private AlkValue value;
    private AlkValue left_side;

    private int dot_size=0, dot_act;

    public AssignedVisitor(Environment env, AlkValue value) {
        this.env = env;
        this.value = value.clone();
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
            if (dot_act + 1 == dot_size && size==0) { // daca suntem la ultimul chunk si nu avem brackets
                if (dot_size==1) { // daca aveam doar un nume de variabila
                    env.update(name, value);
                }
                else
                {
                    if (!left_side.type.equals("Structure"))
                        throw new AlkException(ERR_STRUCT);
                    AlkStructure struct = (AlkStructure) left_side; // este ultima componenta
                    struct.insert(new Pair<>(name, value));
                }
                return null;
            }
            if (left_side == null) // cazul in care suntem inca in primul chunk
            {
                if (!env.has(name)) // nu este definita variabila
                {
                    if (size>0) // avem un tablou
                        env.update(name, new AlkArray());
                    else // avem o structura
                        env.update(name, new AlkStructure());
                }
                left_side = env.lookup(name);
            }
            else // cazul in care suntem intr-o componenta (. sau ->)
            {
                if (!left_side.type.equals("Structure"))
                    throw new AlkException(ERR_STRUCT);
                AlkStructure struct = (AlkStructure) left_side;
                if (!struct.has(name)) // ins structura nu exista o componenta cu numele respectivv
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
                if (!left_side.type.equals("Array"))
                    throw new AlkException(ERR_ARRAY);
                AlkArray array = (AlkArray) left_side;
                if (((AlkInt)array.size()).value.intValue()>place) // arrayul este suficient de mare
                {
                    left_side = left_side.bracket(place);
                }
                else // trebuie marit
                {
                    left_side.bracket(place);
                    array = (AlkArray) left_side;
                    array.put(place, new AlkArray());
                    left_side = array.bracket(place);
                }
            }
            if (dot_act + 1 == dot_size) { // suntem in ultimul chunk
                    AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size - 1));
                    if (!idx.type.equals("Int"))
                        throw new AlkException(ERR_NOINT_ARRAY);
                    int place = ((AlkInt) idx).value.intValueExact();
                    left_side.bracket(place); // TODO de facut si accessul prin liste cu bracket
                    AlkArray array = (AlkArray) left_side;
                    array.put(place, value);
            }
            else
            {
                if (size>0)
                {
                    AlkValue idx = (AlkValue) exprVisitor.visit(ctx.expression(size-1));
                    if (!idx.type.equals("Int"))
                        throw new AlkException(ERR_NOINT_ARRAY);
                    int place = ((AlkInt) idx).value.intValueExact();
                    if (!left_side.type.equals("Array"))
                        throw new AlkException(ERR_ARRAY);
                    AlkArray array = (AlkArray) left_side;
                    if (((AlkInt)array.size()).value.intValue()>place)
                    {
                        left_side = left_side.bracket(place);
                    }
                    else {
                        left_side.bracket(place);
                        array = (AlkArray) left_side;
                        array.put(place, new AlkStructure());
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

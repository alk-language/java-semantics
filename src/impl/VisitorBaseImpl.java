package impl;
import grammar.*;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkIterableValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.AlkValue;
import impl.visitors.AssignedVisitor;
import impl.visitors.AssignmentVisitor;
import impl.visitors.ReferenceVisitor;
import impl.visitors.expression.ExpressionVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

import static impl.constants.Constants.DEBUG;
import static impl.exceptions.AlkException.*;

public class VisitorBaseImpl extends alkBaseVisitor {

    private Environment env = new Environment();

    @Override public Object visitFunctionDecl(alkParser.FunctionDeclContext ctx) {
        String name = ctx.ID(0).getText();
        ArrayList<Pair<String, Boolean> > params = new ArrayList<>();
        ArrayList<String> modifies =  new ArrayList<>();
        for (int i=0; i<ctx.param().size(); i++)
        {
            Pair <String, Boolean> pair = (Pair<String, Boolean>) visit(ctx.param(i));
            params.add(pair);
        }
        for (int i=1; i<ctx.ID().size(); i++)
            modifies.add(ctx.ID(i).getText());
        try {
            new AlkFunction(name, params, modifies, ctx.statement_block());
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return null;
    }

    @Override public Object visitParamDefinition(alkParser.ParamDefinitionContext ctx) {
        Pair<String, Boolean> pair = new Pair<>(ctx.ID().getText(), ctx.OUT()==null);
        return pair;
    }

    @Override public Object visitAssignmentStmt(alkParser.AssignmentStmtContext ctx) {
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AssignedVisitor asgnVisitor = new AssignedVisitor(env, (AlkValue) exprVisitor.visit(ctx.expression()));
        return asgnVisitor.visit(ctx.ref_name());
    }


    @Override public Object visitMethodCall(alkParser.MethodCallContext ctx) {
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
        referenceVisitor.visit(ctx.ref_name());
        referenceVisitor.visit(ctx.builtin_method());
        return null;
    }


    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        if (ctx.expression().size()!=1)
        {
            AlkException e = new AlkException(ERR_PRINT_PARAM);
            e.printException(ctx.start.getLine());
            return null;
        }
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        System.out.println(((AlkValue)exprVisitor.visit(ctx.expression(0))).toString());
        return null;
    }

    @Override public Object visitDoWhileStructure(alkParser.DoWhileStructureContext ctx) {
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value;
        do
        {
            visit(ctx.statement());
            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_DOWHILE_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        } while (((AlkBool)value).value);
        return null;
    }

    @Override public Object visitWhileStructure(alkParser.WhileStructureContext ctx) {
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_WHILE_NOT_BOOL);
            e.printException(ctx.start.getLine());
            return null;
        }
        while (((AlkBool)value).value)
        {
            visit(ctx.statement());
            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_WHILE_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        }
        return null;
    }

    @Override public Object visitIfStructure(alkParser.IfStructureContext ctx) {
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_IF_NOT_BOOL);
            e.printException(ctx.start.getLine());
            return null;
        }
        if (((AlkBool)value).value)
            return visit(ctx.statement(0));
        else
        {
            if (ctx.statement().size()>1)
            {
                return visit(ctx.statement(1));
            }
        }
        return null;
    }



    @Override public Object visitForStructure(alkParser.ForStructureContext ctx) {
        if (ctx.start_assignment()!=null)
            visit(ctx.start_assignment());

        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!value.type.equals("Bool"))
        {
            AlkException e = new AlkException(ERR_FOR_NOT_BOOL);
            e.printException(ctx.start.getLine());
            return null;
        }
        while (((AlkBool)value).value)
        {
            visit(ctx.statement());

            if (ctx.assignment()!=null)
                visit(ctx.assignment());
            else
                visit(ctx.increase_decrease());

            value = (AlkValue) exprVisitor.visit(ctx.expression());
            if (!value.type.equals("Bool"))
            {
                AlkException e = new AlkException(ERR_FOR_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        }
        return null;
    }



    @Override public Object visitForAllStructure(alkParser.ForAllStructureContext ctx) {
        String iterator = ctx.ID().toString();
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue struct = (AlkValue) exprVisitor.visit(ctx.expression());
        if (!struct.isIterable)
        {
            AlkException e = new AlkException(ERR_FORALL_ITERABLE_REQUIRED);
            e.printException(ctx.start.getLine());
            return null;
        }
        AlkIterableValue iterablestruct = (AlkIterableValue) struct;
        for (AlkValue value : iterablestruct)
        {
            env.update(iterator, value);
            visit(ctx.statement());
        }
        return null;
    }


    @Override public Object visitPlusPlusStmt(alkParser.PlusPlusStmtContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AlkValue value = (AlkValue) refVisitor.visit(ctx.ref_name());
            value.plusplusleft();
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return null;
    }



    @Override public Object visitMinusMinusStmt(alkParser.MinusMinusStmtContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AlkValue value = (AlkValue) refVisitor.visit(ctx.ref_name());
            value.minusminusleft();
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return null;
    }



    @Override public Object visitStmtPlusPlus(alkParser.StmtPlusPlusContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AssignedVisitor asgnVisitor = new AssignedVisitor(env, ((AlkValue) refVisitor.visit(ctx.ref_name())).add(new AlkInt(new BigInteger("1")))); //TODO de modificat in functii proprii
            asgnVisitor.visit(ctx.ref_name());
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        } catch (InterpretorException e) {
            if (DEBUG)
                e.printException(ctx.start.getLine());
        }
        return null;
    }


    @Override public Object visitStmtMinusMinus(alkParser.StmtMinusMinusContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AssignedVisitor asgnVisitor = new AssignedVisitor(env, ((AlkValue) refVisitor.visit(ctx.ref_name())).subtract(new AlkInt(new BigInteger("1"))));
            asgnVisitor.visit(ctx.ref_name());
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        } catch (InterpretorException e) {
            if (DEBUG)
                e.printException(ctx.start.getLine());
        }
        return null;
    }


    @Override public Object visitMinusMinusModStmt(alkParser.MinusMinusModStmtContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AlkValue value = (AlkValue) refVisitor.visit(ctx.ref_name());
            value.minusminusmod();
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return null;
    }


    @Override public Object visitPlusPlusModStmt(alkParser.PlusPlusModStmtContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        try {
            AlkValue value = (AlkValue) refVisitor.visit(ctx.ref_name());
            value.plusplusmod();
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
        }
        return null;
    }
}
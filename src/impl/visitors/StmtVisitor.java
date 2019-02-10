package impl.visitors;
import grammar.*;
import impl.Pair;
import impl.env.AlkFunction;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkIterableValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkInt.AlkInt;
import impl.types.AlkValue;
import impl.types.alkNotAValue.AlkNotAValue;
import impl.visitors.expression.ExpressionVisitor;
import impl.visitors.function.FunctionCallVisitor;

import java.math.BigInteger;
import java.util.ArrayList;

import static impl.constants.Constants.DEBUG;
import static impl.exceptions.AlkException.*;
import static impl.types.alkNotAValue.AlkNotAValue.NO_RETURN;

public class StmtVisitor extends alkBaseVisitor {

    private Environment env;
    private Boolean inFunction;
    public AlkValue returnValue = null; // doar in cazul in care inFunction==true TODO de inlocuit cu NOTAVALUE

    public StmtVisitor(Environment env, boolean inFunction)
    {
        this.env=env;
        this.inFunction = inFunction;
    }

    @Override public Object visitFunctionDecl(alkParser.FunctionDeclContext ctx) {
        if (inFunction)
        {
            AlkException e = new AlkException(ERR_FUNCTION_DEFINITION);
            e.printException(ctx.start.getLine());
            return null;
        }
        String name = ctx.ID(0).getText();
        ArrayList<Pair<String, Boolean>> params = new ArrayList<>();
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

    @Override public Object visitFunctionCall(alkParser.FunctionCallContext ctx) {
        if (returnValue != null) return null;
        FunctionCallVisitor visitor = new FunctionCallVisitor(env);
        visitor.visit(ctx.function_call());
        return null;
    }

    @Override public Object visitParamDefinition(alkParser.ParamDefinitionContext ctx) {
        Pair<String, Boolean> pair = new Pair<>(ctx.ID().getText(), ctx.OUT()!=null);
        return pair;
    }

    @Override public Object visitReturnStmt(alkParser.ReturnStmtContext ctx) {
        if (!inFunction)
        {
            AlkException e = new AlkException(ERR_RETURN);
            e.printException(ctx.start.getLine());
            return null;
        }
        if (ctx.expression() == null)
        {
            returnValue = new AlkNotAValue(NO_RETURN);
        }
        else
        {
            ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
            returnValue = (AlkValue) expressionVisitor.visit(ctx.expression());
        }
        return null;
    }

    @Override public Object visitAssignmentStmt(alkParser.AssignmentStmtContext ctx) {
        if (returnValue != null) return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AssignedVisitor asgnVisitor = new AssignedVisitor(env, (AlkValue) exprVisitor.visit(ctx.expression()));
        return asgnVisitor.visit(ctx.ref_name());
    }


    @Override public Object visitMethodCall(alkParser.MethodCallContext ctx) {
        if (returnValue != null) return null;
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
        referenceVisitor.visit(ctx.ref_name());
        referenceVisitor.visit(ctx.builtin_method());
        return null;
    }

    @Override public Object visitDoWhileStructure(alkParser.DoWhileStructureContext ctx) {
        if (returnValue != null) return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        AlkValue value;
        do
        {
            visit(ctx.statement());
            if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
            if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
            if (returnValue != null) return null;

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
        if (returnValue != null) return null;
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
            if (returnValue != null) return null;
        }
        return null;
    }


    @Override public Object visitPlusPlusStmt(alkParser.PlusPlusStmtContext ctx) {
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
        if (returnValue != null) return null;
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
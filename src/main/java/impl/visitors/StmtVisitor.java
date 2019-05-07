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
import impl.visitors.helpers.NonDeterministic;

import java.math.BigInteger;
import java.util.ArrayList;

import static impl.constants.Constants.DEBUG;
import static impl.exceptions.AlkException.*;
import static impl.types.alkNotAValue.AlkNotAValue.NO_RETURN;

/**
 * This class is responsible for the visiting of the statements.
 */

public class StmtVisitor extends alkBaseVisitor {

    /**
     * The environment over which this visitor will work.
     */
    private Environment env;
    /**
     * A flag to be known if the execution is currently inside of a function.
     * It is used in order to allow/disallow using specific statements like declaring a function inside another function or
     * using the return statement outside a function.
     */
    private Boolean inFunction;
    /**
     * A value representing the return value after the visiting of this statement block.
     * In case it has a value, the following statements will be ignored in order to simulate the execution termination.
     */
    public AlkValue returnValue = null;


    /**
     * Creates a new statement visitor with a specified environment and a flag for deciding the inFunction variable.
     * @param env The environment over which the statements will be executed
     * @param inFunction The inFunction flag
     */
    public StmtVisitor(Environment env, boolean inFunction)
    {
        this.env=env;
        this.inFunction = inFunction;
    }


    /**
     * Handles the context reffering to a declaration of a new function. It takes in account the inFunction flag to
     * determine if this kind of statement is legal here. It parses the statement to compute the in/out/modifies params
     * and also the statement block (the context/node in the visitor tree) and finally adds the new generated
     * AlkFunction in the static collection of all AlkFunctions. In case there is another function with another name,
     * an AlkExeption will be thrown.
     * @param ctx A Function Declaration node in the execution tree meant to be parsed.
     */
    @Override public Object visitFunctionDecl(alkParser.FunctionDeclContext ctx) {
        if (inFunction)
        {
            AlkException e = new AlkException(ERR_FUNCTION_DEFINITION);
            e.printException(ctx.start.getLine());
            return null;
        }
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


    /**
     * Handles the visiting of a function call context. The implementation is assigned to a FunctionCallVisitor.
     * @param ctx A Function Call node in the execution tree meant to be parsed.
     */
    @Override public Object visitFunctionCall(alkParser.FunctionCallContext ctx) {
        if (returnValue != null) return null;
        FunctionCallVisitor visitor = new FunctionCallVisitor(env);
        visitor.visit(ctx.function_call());
        return null;
    }


    /**
     * Handles the visiting of a parameter definition context. It extracts the name and the type(in/out) of the parameter.
     * @param ctx A Parameter Definition node in the execution tree meant to be parsed.
     * @return A pair containing the name of the parameter and a flag used to determine if it is about an output parameter.
     */
    @Override public Object visitParamDefinition(alkParser.ParamDefinitionContext ctx) {
        Pair<String, Boolean> pair = new Pair<>(ctx.ID().getText(), ctx.OUT()!=null);
        return pair;
    }


    /**
     * Handles the visiting of a returning statement. It checks if the visitor is inside a function, so the
     * returning statement can be used, otherwise an AlkException is thrown. After this, it makes use of an
     * ExpressionVisitor to compute the value to be returned and sets the returnValue to this value. In case
     * there is no expression, a AlkNotAValue will be returned. From this point until the end of the statement visitor,
     * no other statement will be executed.
     * @param ctx A Return Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitReturnStmt(alkParser.ReturnStmtContext ctx) {
        if (returnValue != null) return null;
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


    /**
     * Handles the visiting of an assignment statement. The right side of the assignment will be evaluated with an
     * ExpressionVisitor. In case the operator used is an equal, an AssignedVisitor will be used to visit the left
     * side of the assignment and assign the value obtained at the location determined. Otherwise, meaning in case
     * of a compound assignment operator, the left side will be also evaluated. The values from the left and right side
     * will be part of an expression defined by the compound operator, and the overall value will be given to an
     * AssignedVisitor in order to put value obtained in the location needed.
     * @param ctx An Assignment Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitAssignmentStmt(alkParser.AssignmentStmtContext ctx) {
        if (returnValue != null) return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
        AlkValue right_side = ((AlkValue) exprVisitor.visit(ctx.expression())).clone();
        if (ctx.ASSIGNMENT_OPERATOR().getText().equals("="))
        {
            AssignedVisitor asgnVisitor = new AssignedVisitor(env, right_side);
            return asgnVisitor.visit(ctx.ref_name());
        }
        AlkValue left_side = ((AlkValue) referenceVisitor.visit(ctx.ref_name())).clone();
        try {
            switch (ctx.ASSIGNMENT_OPERATOR().getText())
            {
                case "+=": right_side = left_side.add(right_side); break;
                case "-=": right_side = left_side.subtract(right_side); break;
                case "*=": right_side = left_side.multiply(right_side); break;
                case "/=": right_side = left_side.divide(right_side); break;
                case "%=": right_side = left_side.mod(right_side); break;
                case "<<=": right_side = left_side.shiftLeft(right_side); break;
                case ">>=": right_side = left_side.shiftLeft(right_side); break;
                case "|=": right_side = left_side.bitwiseOr(right_side); break;
                case "&=": right_side = left_side.bitwiseAnd(right_side); break;
                default: ;
            }
        } catch (InterpretorException e) {
            e.printException(ctx.start.getLine());
            return null;
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return null;
        }
        AssignedVisitor asgnVisitor = new AssignedVisitor(env, right_side);
        return asgnVisitor.visit(ctx.ref_name());
    }


    /**
     * Handles the visiting of a Method Call. Firstly, the the reference name will be parsed by a ReferenceVisitor,
     * and afterwards the same ReferenceVisitor will continue the parsing of the builtin method.
     * @param ctx A Method Call node in the execution tree meant to be parsed.
     */
    @Override public Object visitMethodCall(alkParser.MethodCallContext ctx) {
        if (returnValue != null) return null;
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
        referenceVisitor.visit(ctx.ref_name());
        referenceVisitor.visit(ctx.builtin_method());
        return null;
    }


    /**
     * Handles the visiting of a Repeat Structure. Making use of an ExpressionVisitor, after each iteration we check if
     * the expression after the while keyword is still true. If it does, the statement inside will be visited, otherwise
     * the loop ends. After each iteration, it is check if the returnValue is set, so that the loop execution might
     * be interrupted.
     * @param ctx A Repeat Structure node in the execution tree meant to be parsed.
     */
    @Override public Object visitRepeatStructure(alkParser.RepeatStructureContext ctx) {
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
                AlkException e = new AlkException(ERR_REPEAT_NOT_BOOL);
                e.printException(ctx.start.getLine());
                return null;
            }
        } while (!((AlkBool)value).value);
        return null;
    }


    /**
     * The same semantic as the repeat until structure.
     * @param ctx A Do While Structure node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a While Structure. Using an ExpressionVisitor, we first check the validity of the
     * expression after the while keyword. If it is false the loop doesn't even start, otherwise the statement inside
     * will be executed until the verification will fail. Note that after each iteration, it is checked if the
     * returnValue is set. If it is the execution of the loop will be instantly terminated.
     * @param ctx A While Structure node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of the If Structure. Making use of the ExpressionVisitor, it is checked if
     * the condition provided is true or false. Depending on the result, the corresponding statement will be executed.
     * In case there is no else keyword, and the condition returns false, the execution continues normally
     * @param ctx
     * @return An If Structure node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a Success Statement. At this point the program will instantly terminate, by throwing
     * an AlkException with a message representative for this kind of termination.
     * @param ctx A Success node in the execution tree meant to be parsed.
     */
    @Override public Object visitSuccess(alkParser.SuccessContext ctx) {
        AlkException e = new AlkException(null);
        e.success();
        return null;
    }


    /**
     * Handles the visiting of a Failure Statement. At this point the program will instantly terminate, by throwing
     * an AlkException with a message representative for this kind of termination.
     * @param ctx A Failure node in the execution tree meant to be parsed.
     */
    @Override public Object visitFailure(alkParser.FailureContext ctx) {
        AlkException e = new AlkException(null);
        e.failure();
        return null;
    }


    /**
     * Handles the visiting of a For Structure. The Assignment Statement will be used several times inside the for header.
     * Also an ExpressionVisitor is used to check each time the condition. If after an iteration, the statement to be
     * executed in the for body sets the returnValue, than the loop is terminated, and the execution continues.
     * @param ctx A For Strcuture node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a ForAll Structure. Firstly, a verification is made in order to ensure that the
     * second parameter inside the header is an Iterable Structure. If it is so, for each value inside the structure,
     * the statement inside will be executed. If after an iteration the returnValue is set, the execution terminates instantly.
     * @param ctx A ForAll Strcuture node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a Plus Plus Statement. This kind of statement is meant to increase one's value. Thus
     * A ReferenceVisitor is needed in order to obtain the value referenced and increase it by one. In case the
     * reference is invalid, an AlkException will be thrown.
     * @param ctx A PlusPlus Statement node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a Minus Minus Statement. This kind of statement is meant to decrease one's value. Thus
     * A ReferenceVisitor is needed in order to obtain the value referenced and decrease it by one. In case the
     * reference is invalid, an AlkException will be thrown.
     * @param ctx A MinusMinus Statement node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a Choose Statement. At first some checks are done as: if the second parameter is an
     * iterable structure. In case it isn't an AlkException is thrown. Another check is related to size of the structure.
     * If it is an empty structure, an AlkException will be thrown. Finally, depending on the presence of the SOTHAT,
     * the execution follows. In case there is no SOTHAT, the NonDeterministic Helper will choose a value from the
     * iterable structure, one which will be inserted in the environment in the end. If there is a SOTHAT, the
     * NonDeterministic helper will also be used in order to choose a value in the ireable structure which fits the
     * condition provided. In case there is no such number, an AlkException will be thrown. If the chooseST will succeed,
     * the value obtained will be inserted in the environment.
     * @param ctx A Choose Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitChooseStmt(alkParser.ChooseStmtContext ctx) {
        if (returnValue != null) return null;
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
        AlkValue struct = (AlkValue)expressionVisitor.visit(ctx.expression(0));
        if (!struct.isIterable)
        {
            AlkException e = new AlkException(ERR_CHOOSE_NOT_ITERABLE);
            e.printException(ctx.start.getLine());
        }
        AlkIterableValue val = (AlkIterableValue) struct;

        if (val.toArray().size()==0)
        {
            AlkException e = new AlkException(ERR_CHOSE_RESULT);
            e.printException(ctx.start.getLine());
        }

        if (ctx.SOTHAT()==null)
        {
            AlkValue value = NonDeterministic.choose(val);
            env.update(ctx.ID().getText(), value.clone());
        }
        else
        {
            AlkValue value = null;
            try {
                value = NonDeterministic.chooseST(ctx.ID().getText(), val, ctx.expression(1), env);
            } catch (AlkException e) {
                e.printException(ctx.start.getLine());
            }
            env.update(ctx.ID().getText(), value.clone());
        }
        return null;
    }


    /**
     * Handles the visiting of a Uniform Statement. The implementation is similar to the one of a choose statement, in
     * which we are not required to check for the SOTHAT condition.
     * @param ctx An Uniform Statement node in the execution tree meant to be parsed.
     */
    @Override public Object visitUniformStmt(alkParser.UniformStmtContext ctx) {
        if (returnValue != null) return null;
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
        AlkValue struct = (AlkValue)expressionVisitor.visit(ctx.expression());
        if (!struct.isIterable)
        {
            AlkException e = new AlkException(ERR_UNIFORM_NOT_ITERABLE);
            e.printException(ctx.start.getLine());
        }
        AlkIterableValue val = (AlkIterableValue) struct;

        if (val.toArray().size()==0)
        {
            AlkException e = new AlkException(ERR_UNIFORM_RESULT);
            e.printException(ctx.start.getLine());
        }

        AlkValue value = NonDeterministic.choose(val);
        env.update(ctx.ID().getText(), value.clone());
        return null;
    }


    /**
     * Handles the visiting of a Statement PlusPlus. Similar to the PlusPlus Statement.
     * @param ctx An Statement PlusPlus node in the execution tree meant to be parsed.
     */
    //TODO reimplement the function
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


    /**
     * Handles the visiting of a Statement MinusMinus. Similar to the MinusMinus Statement.
     * @param ctx An Statement MinusMinus node in the execution tree meant to be parsed.
     */
    //TODO reimplement the function
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


    /**
     * Handles the visiting of a MinusMinusMod Statement. This will only work on iterators and its main goal is to ensure
     * that the iterators won't point towards unwanted values, by redirecting them to the other end. In other words, the
     * iteration with such operator will be circular relatively to the structure iterated.
     * @param ctx An MinusMinusMod Statement node in the execution tree meant to be parsed.
     */
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


    /**
     * Handles the visiting of a PlusPlusMod Statement. This will only work on iterators and its main goal is to ensure
     * that the iterators won't point towards unwanted values, by redirecting them to the other end. In other words, the
     * iteration with such operator will be circular relatively to the structure iterated.
     * @param ctx An PlusPlusMod Statement node in the execution tree meant to be parsed.
     */
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
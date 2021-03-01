package execution.state.expression;

import ast.AST;
import ast.enums.Operator;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import util.exception.InternalException;
import util.types.Storable;
import visitor.interpreter.RequiresGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseBinaryOperatorState
extends GuardedGeneratorState
{
    private static final Map<String, Method> ALK_VALUE_OPS = new HashMap<>();

    static
    {
        Method[] methods = AlkValue.class.getMethods();
        for (Method method : methods)
        {
            ALK_VALUE_OPS.put(method.getName(), method);
        }
    }

    public BaseBinaryOperatorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable firstAssign(Operator op, Storable current)
    {
        // Logical Or has separate behavior
        if (op.equals(Operator.LOGICALOR) && current instanceof AlkBool && ((AlkBool) current).isTrue())
        {
            super.stopGenerator();
        }

        // Logical And has separate behavior
        if (op.equals(Operator.LOGICALAND) && current instanceof AlkBool && !((AlkBool) current).isTrue())
        {
            super.stopGenerator();
        }

        return current;
    }

    @Override
    protected Storable interpretResult(Operator op, Storable current, Storable next)
    {
        String opName = op.toString().toLowerCase();

        if (op.equals(Operator.BRACKET) && current.toLValue().isUnknown())
        {
            current.toLValue().assign(new AlkArray());
        }

        if (current == null || next == null)
        {
            super.handle(new AlkException("One of operands can't be evaluated!"));
        }

        current = current.toRValue();
        next = next.toRValue();

        if (current == null || next == null)
        {
            super.handle(new AlkException("One of operands can't be evaluated!"));
        }

        // Logical Or has separate behavior
        if (op.equals(Operator.LOGICALOR) && current instanceof AlkBool && ((AlkBool) current).isTrue())
        {
            return current;
        }

        // Logical And has separate behavior
        if (op.equals(Operator.LOGICALAND) && current instanceof AlkBool && !((AlkBool) current).isTrue())
        {
            return current;
        }

        try
        {
            Method method = ALK_VALUE_OPS.get(opName);

            if (method == null)
            {
                throw new InternalException("Can't find desired operator for AlkValue through reflection: " + opName);
            }

            List<Object> params = new ArrayList<>();
            params.add(next);

            if (method.getAnnotation(RequiresGenerator.class) != null)
            {
                params.add(generator);
            }

            if (method.getParameterCount() != params.size())
            {
                throw new InternalException("Invalid number of operands for operator: " + opName);
            }

            return (Storable) method.invoke(current, params.toArray());
        }
        catch (InvocationTargetException e)
        {
            if (e.getCause() instanceof AlkException)
                super.handle(new AlkException(e.getCause().getMessage()));

            Throwable tr = e.getTargetException();
            if (tr instanceof AlkException)
                super.handle(new AlkException(tr.getMessage()));
        }
        catch (IllegalAccessException e)
        {
            throw new InternalException(e.getMessage());
        }

        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseBinaryOperatorState copy = new BaseBinaryOperatorState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
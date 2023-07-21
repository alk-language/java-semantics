package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.GuardedGeneratorState;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.interpreter.RequiresGenerator;

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
            ALK_VALUE_OPS.put(method.getName().toLowerCase(), method);
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
        if (op.equals(Operator.LOGICAL_OR) && current instanceof AlkBool && ((AlkBool) current).isTrue())
        {
            super.stopGenerator();
        }

        // Logical And has separate behavior
        if (op.equals(Operator.LOGICAL_AND) && current instanceof AlkBool && !((AlkBool) current).isTrue())
        {
            super.stopGenerator();
        }

        return current;
    }

    @Override
    protected Storable interpretResult(Operator op, Storable current, Storable next)
    {
        String opName = op.toString().toLowerCase();

        if (current == null || next == null)
        {
            super.handle(new AlkException("One of operands can't be evaluated!"));
        }

        if (op.equals(Operator.BRACKET) && current.toLValue().isUnknown())
        {
            current.toLValue().setValue(new AlkArray());
        }

        current = current.toRValue();
        next = next.toRValue();

        if (current == null || next == null)
        {
            super.handle(new AlkException("One of operands can't be evaluated!"));
        }

        // Logical Or has separate behavior
        if (op.equals(Operator.LOGICAL_OR) && current instanceof AlkBool && ((AlkBool) current).isTrue())
        {
            return current;
        }

        // Logical And has separate behavior
        if (op.equals(Operator.LOGICAL_AND) && current instanceof AlkBool && !((AlkBool) current).isTrue())
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
                super.handle((AlkException) e.getCause());

            Throwable tr = e.getTargetException();
            if (tr instanceof AlkException)
                super.handle(new AlkException(tr.getMessage()));

            throw new InternalException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseBinaryOperatorState copy = new BaseBinaryOperatorState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
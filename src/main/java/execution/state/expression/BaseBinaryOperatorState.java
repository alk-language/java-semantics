package execution.state.expression;

import ast.AST;
import ast.enums.Operator;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.GuardedGeneratorState;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import execution.types.alkBool.AlkBool;
import util.exception.InternalException;
import util.types.Value;
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

    public BaseBinaryOperatorState(AST ast, ExecutionPayload executionPayload)
    {
        super(ast, executionPayload);
    }

    @Override
    protected Value interpretResult(Operator op, Value current, Value next)
    {
        String opName = op.toString().toLowerCase();

        if (op.equals(Operator.BRACKET) && current.toRValue() == null)
        {
            // make auto-allocation
            current.toLValue().assign(new AlkArray());
        }

        current = current.toRValue();
        next = next.toRValue();

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

            return (Value) method.invoke(current, params.toArray());
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            throw new InternalException(e);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BaseBinaryOperatorState copy = new BaseBinaryOperatorState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}
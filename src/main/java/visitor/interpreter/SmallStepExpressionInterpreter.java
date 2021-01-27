package visitor.interpreter;

import ast.enums.BuiltInMethod;
import ast.enums.Operator;
import java.util.List;

public interface SmallStepExpressionInterpreter<T>
extends ExpressionInterpreter<T>
{
    T evaluate(Operator op, List<T> values);
    T evaluateBuiltIn(BuiltInMethod op, T factor, List<T> params);
}
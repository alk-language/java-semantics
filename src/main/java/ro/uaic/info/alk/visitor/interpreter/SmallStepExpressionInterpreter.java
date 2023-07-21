package ro.uaic.info.alk.visitor.interpreter;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.FOL;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.List;

public interface SmallStepExpressionInterpreter<T>
extends ExpressionInterpreter<T>
{
    T evaluate(Operator op, List<T> values);
    default T evaluate(FOL op, List<T> values) {
        throw new InternalException("To be implemented!");
    }
    T evaluateBuiltIn(AlkBuiltInMethod op, T factor, List<T> params);
    default T evaluateResult() {
        throw new InternalException("To be implemented!");
    }
}
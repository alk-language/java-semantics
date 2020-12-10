package visitor;

import util.Pair;

import javax.xml.ws.Provider;
import java.util.List;

public interface ExpressionInterpreter<T>
{
    T evaluate(Operator op, List<T> values);
    T interpretVariable(String id);
    T interpretPrimitive(Primitive primitive, String value);
    T interpretComposite(Primitive primitive, List<T> values);
    T interpretCompositeInterval(Primitive primitive, T left, T right);
    T interpretCompositeFilterSpec(Primitive primitive, String id, T fromExpr, Provider<T> suchThat);
    T interpretCompositeSelectSpec(Primitive primitive, String id, T fromExpr, Provider<T> suchThat);
    T interpretCompositeComponents(Primitive primitive, List<Pair<String, T>> comps);
}

// x + 2
// env: id -> loc
// store: loc -> Value
// 123

// old: Value >  AlkValue > AlkInt

// Value > SymbolicValue > AlkValue > AlkInt
// Value > SymbolicValue > UndefinedValue
// Value > SymbolicValue > OverdefinedValue
// Value > Location

// Value.toRValue: this -> Value
// Value.toLValue: this -> Location
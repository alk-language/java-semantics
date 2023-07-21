package ro.uaic.info.alk.visitor.interpreter;

import ro.uaic.info.alk.enums.ContextVar;
import ro.uaic.info.alk.enums.Primitive;
import ro.uaic.info.alk.util.Pair;

import java.util.List;
import java.util.function.Function;

public interface ExpressionInterpreter<T>
{
    T interpretVariable(String id);
    T interpretSymId(String id);
    T interpretContextVar(ContextVar old, String id);
    T interpretPrimitive(Primitive primitive, String value);
    T interpretComposite(Primitive primitive, List<T> values);
    T interpretCompositeInterval(Primitive primitive, T left, T right);
    T interpretCompositeFilterSpec(Primitive primitive, String id, T fromExpr, Function<T, Object> suchThat);
    T interpretCompositeSelectSpec(Primitive primitive, String id, T fromExpr, Function<T, Object> suchThat);
    T interpretCompositeComponents(Primitive primitive, List<Pair<String, T>> comps);
}

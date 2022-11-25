package visitor;

import ast.*;
import ast.enums.BuiltInMethod;
import ast.expr.*;
import execution.parser.env.Environment;
import execution.types.ConcreteValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;
import execution.types.alkString.AlkString;
import symbolic.SymbolicValue;
import symbolic.SymbolicValueIface;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import ast.enums.Operator;
import ast.enums.Primitive;
import visitor.interpreter.base.BaseExpressionInterpreter;
import visitor.interpreter.SmallStepExpressionInterpreter;
import visitor.interpreter.InterpreterHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SymbolicExpressionInterpreter
implements SmallStepExpressionInterpreter<SymbolicValueIface>
{
    private static final PrimitiveBuilder primitiveBuilder = new PrimitiveBuilder();

    private final SmallStepExpressionInterpreter<ConcreteValue> basicInterpreter;

    private final Environment env;
    private final LocationGenerator generator;

    public SymbolicExpressionInterpreter(Environment env, LocationGenerator generator)
    {
        this.env = env;
        this.generator = generator;
        this.basicInterpreter = new BaseExpressionInterpreter(env, generator);
    }

    @Override
    public SymbolicValueIface evaluate(Operator op, List<SymbolicValueIface> values)
    {
        if (!InterpreterHelper.containsSomeValue(values, SymbolicValue.class))
        {
            return basicInterpreter.evaluate(op, InterpreterHelper.castToBaseValues(values));
        }

        List<SymbolicValue> symbolicValues = castToSymbolicValues(values);
        List<AST> children = new ArrayList<>();
        for (SymbolicValue symbolicValue : symbolicValues)
        {
            children.add(symbolicValue.toAST());
        }

        AST root = OperatorUtils.getOperatorAST(op, children);
        return new SymbolicValue(root);
    }

    @Override
    public SymbolicValueIface evaluateBuiltIn(BuiltInMethod op, SymbolicValueIface factor, List<SymbolicValueIface> params)
    {
        // TODO add support
        return null;
    }

    @Override
    public SymbolicValueIface interpretVariable(String id) {
        return new SymbolicValue(new RefIDAST(id));
    }

    @Override
    public SymbolicValueIface interpretSymId(String id)
    {
        return null;
    }

    @Override
    public SymbolicValueIface interpretPrimitive(Primitive primitive, String value) {
        return basicInterpreter.interpretPrimitive(primitive, value);
    }

    @Override
    public SymbolicValueIface interpretComposite(Primitive primitive, List<SymbolicValueIface> values) {
        return null;
    }

    @Override
    public SymbolicValueIface interpretCompositeInterval(Primitive primitive, SymbolicValueIface left, SymbolicValueIface right) {
        return null;
    }

    @Override
    public SymbolicValueIface interpretCompositeFilterSpec(Primitive primitive, String id, SymbolicValueIface fromExpr, Function<SymbolicValueIface, Object> suchThat) {
        return null;
    }

    @Override
    public SymbolicValueIface interpretCompositeSelectSpec(Primitive primitive,
                                                           String id,
                                                           SymbolicValueIface fromExpr,
                                                           Function<SymbolicValueIface, Object> suchThat) {
        return null;
    }

    @Override
    public SymbolicValueIface interpretCompositeComponents(Primitive primitive, List<Pair<String, SymbolicValueIface>> comps) {
        return null;
    }

    private List<SymbolicValue> castToSymbolicValues(List<SymbolicValueIface> values)
    {
        List<SymbolicValue> result = new ArrayList<>();
        for (SymbolicValueIface value : values)
        {
            if (value instanceof SymbolicValue)
                result.add((SymbolicValue) value);
            else
                result.add(primitiveBuilder.accept(value));
        }
        return result;
    }
}

class PrimitiveBuilder
{
    SymbolicValue accept(SymbolicValueIface value)
    {
        // simple data types
        if (value instanceof AlkBool)
            return new SymbolicValue(new BoolAST(value.toString()));
        if (value instanceof AlkInt)
            return new SymbolicValue(new IntAST(value.toString()));
        if (value instanceof AlkString)
            return new SymbolicValue(new StringAST(value.toString()));
        if (value instanceof AlkFloat)
            return new SymbolicValue(new FloatAST(value.toString()));

        // TODO: implement compound data types
        /*if (value instanceof AlkBool)
            return castToSymbolicValue((AlkBool) value);
        if (value instanceof AlkInt)
            return castToSymbolicValue((AlkInt) value);
        if (value instanceof AlkString)
            return castToSymbolicValue((AlkString) value);
        if (value instanceof AlkFloat)
            return castToSymbolicValue((AlkFloat) value);*/

        throw new InternalException("Unrecognized value type when converting to symbolic value.");
    }

}
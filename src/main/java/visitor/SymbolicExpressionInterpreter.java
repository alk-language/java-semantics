package visitor;

import ast.*;
import execution.parser.env.Environment;
import execution.types.BaseValue;
import execution.types.alkBool.AlkBool;
import execution.types.alkFloat.AlkFloat;
import execution.types.alkInt.AlkInt;
import execution.types.alkString.AlkString;
import symbolic.SymbolicValue;
import symbolic.SymbolicValueIface;
import util.Pair;
import util.exception.InternalException;
import util.lambda.LocationGenerator;

import javax.xml.ws.Provider;
import java.util.ArrayList;
import java.util.List;

public class SymbolicExpressionInterpreter
implements ExpressionInterpreter<SymbolicValueIface>
{
    private static final PrimitiveBuilder primitiveBuilder = new PrimitiveBuilder();

    private final ExpressionInterpreter<BaseValue> basicInterpreter;

    private final Environment env;
    private final LocationGenerator generator;

    SymbolicExpressionInterpreter(Environment env, LocationGenerator generator)
    {
        this.env = env;
        this.generator = generator;
        this.basicInterpreter = new BasicExpressionInterpreter(env, generator);
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
            children.add(symbolicValue.getAst());
        }

        AST root = getOperatorAST(op, children);
        return new SymbolicValue(root);
    }

    @Override
    public SymbolicValueIface interpretVariable(String id) {
        return new SymbolicValue(new RefIDAST(id));
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
    public SymbolicValueIface interpretCompositeFilterSpec(Primitive primitive, String id, SymbolicValueIface fromExpr, Provider<SymbolicValueIface> suchThat) {
        return null;
    }

    @Override
    public SymbolicValueIface interpretCompositeSelectSpec(Primitive primitive, String id, SymbolicValueIface fromExpr, Provider<SymbolicValueIface> suchThat) {
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

    private AST getOperatorAST(Operator op, List<AST> children)
    {
        switch (op) {
            case LOGICALOR: return LogicalOrAST.createBinary(op, children);
            case LOGICALAND: return LogicalAndAST.createBinary(op, children);
            case IN: return InExprAST.createBinary(op, children);
            case EQUAL: case NOTEQUAL: case LOWER:
            case LOWEREQ: case GREATER: case GREATEREQ: return EqualityAST.createBinary(op, children);
            case UNION: case INTERSECT: case SETSUBTRACT: return SetExprAST.createBinary(op, children);
            case BITWISEOR: case BITWISEXOR: return BitwiseOrAST.createBinary(op, children);
            case BITWISEAND: return BitwiseAndAST.createBinary(op, children);
            case SHIFTLEFT: case SHIFTRIGHT: return ShiftAST.createBinary(op, children);
            case ADD: case SUBTRACT: return AdditiveAST.createBinary(op, children);
            case MULTIPLY: case DIVIDE: case MOD: return MultiplicativeAST.createBinary(op, children);
            case PLUSPLUSLEFT: case MINUSMINUSLEFT: return PrefixAST.createUnary(op, children);
            case POSITIVE: case NEGATIVE: case NOT: return UnaryAST.createUnary(op, children);
            case PLUSPLUSRIGHT: case MINUSMINUSRIGHT: return PostfixAST.createUnary(op, children);
            case BRACKET: return BracketAST.createBinary(op, children);
            default:
                throw new InternalException("Unrecognized operator when symbolically interpreting an expression: " + op);
        }
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
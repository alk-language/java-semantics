package execution.interpreter;

import ast.AST;
import ast.attr.BuiltInFunctionASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.RepresentationASTAttr;
import ast.enums.*;
import execution.ExecutionPayload;
import execution.state.ExecutionState;
import execution.state.symbolic.*;
import util.exception.InternalException;
import visitor.stateful.StatefulExpressionInterpreter;

public class SymbolicStatefulExpressionInterpreter
implements StatefulExpressionInterpreter<ExecutionPayload, ExecutionState>
{
    private final StatefulExpressionInterpreter<ExecutionPayload, ExecutionState> baseDelegate = new BaseStatefulExpressionInterpreter();

    @Override
    public ExecutionState evaluateUnary(AST ast, ExecutionPayload payload)
    {
        OpsASTAttr attr = ast.getAttribute(OpsASTAttr.class);
        Operator op = attr.getOp(0);
        switch (op) {
            case PLUSPLUSLEFT: case MINUSMINUSLEFT:
                return new SymbolicPrefixOperatorState(op, ast, payload);
            case PLUSPLUSRIGHT: case MINUSMINUSRIGHT:
                return new SymbolicPostfixOperatorState(op, ast, payload);
            case POSITIVE: case NEGATIVE: case NOT:
                return new SymbolicUnaryOperatorState(op, ast, payload);
            case DOT:
                return new SymbolicDotOperatorState(ast, payload);
            default:
                throw new InternalException("Unrecognized unary operator: " + op);
        }
    }

    @Override
    public ExecutionState evaluateBinary(AST ast, ExecutionPayload payload)
    {
        return new SymbolicBinaryState(ast, payload);
    }

    @Override
    public ExecutionState evaluateTernary(AST ast, ExecutionPayload payload)
    {
        return new SymbolicConditionalState(ast, payload);
    }

    @Override
    public ExecutionState evaluateMethod(AST ast, ExecutionPayload payload)
    {
        return new SymbolicFactorPointMethodState(ast, payload);
    }

    @Override
    public ExecutionState evaluateFunction(AST ast, ExecutionPayload payload)
    {
        if (ast.hasAttribute(BuiltInFunctionASTAttr.class))
        {
            return new SymbolicBuiltInFunctionState(ast, payload);
        }
        else
        {
            return new SymbolicFunctionCallState(ast, payload);
        }
    }

    @Override
    public ExecutionState interpretAssignment(AST ast, ExecutionPayload payload)
    {
        return new SymbolicAssignmentState(ast, payload);
    }

    @Override
    public ExecutionState interpretRefId(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretRefId(ast, payload);
    }

    @Override
    public ExecutionState interpretSymId(AST ast, ExecutionPayload payload)
    {
        return new SymbolicIdState(ast, payload);
    }

    @Override
    public ExecutionState interpretPrimitive(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretPrimitive(primitive, ast, payload);
    }

    @Override
    public ExecutionState interpretComposite(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        RepresentationASTAttr attr = ast.getAttribute(RepresentationASTAttr.class);
        CompoundValueRepresentation repr = attr.getRepresentation();
        switch (repr) {
            case EMPTY:
                if (primitive == Primitive.SET)
                {
                    return new SymbolicEmptyState(ast, payload);
                }
            case FILTER_SPEC:
            case EXPRESSIONS:
            case COMPONENTS:
            case MAP_SPEC:
                return baseDelegate.interpretComposite(primitive, ast, payload);
            case INTERVAL:
                if (primitive == Primitive.ARRAY)
                {
                    return new ArraySymbolicIntervalState(primitive, ast, payload);
                }
                else if (primitive == Primitive.SET)
                {
                    return new SetSymbolicIntervalState(primitive, ast, payload);
                }
                return baseDelegate.interpretComposite(primitive, ast, payload);
            default:
                throw new InternalException("Unrecognized compound data type representation: " + repr);
        }
    }

    @Override
    public ExecutionState interpretFol(FOL type, AST ast, ExecutionPayload payload)
    {
        switch (type)
        {
            case IMPLIES:
                return new SymbolicImpliesState(ast, payload);
            case EQUIV:
                return new SymbolicEquivState(ast, payload);
            case FORALL:
                return new SymbolicForAllState(ast, payload);
            case EXISTS:
                return new SymbolicExistsState(ast, payload);
            default:
                throw new InternalException("Can't recognize this type of FOL operation: " + type);
        }
    }

    @Override
    public ExecutionState interpretContextVar(ContextVar var, AST ast, ExecutionPayload payload)
    {
        switch (var)
        {
            case RESULT:
                return new SymbolicResultState(ast, payload);
            case OLD:
                return new SymbolicOldState(ast, payload);
            default:
                throw new InternalException("Can't recognize this type of context variable: " + var);
        }
    }

    @Override
    public void interpretAnno(AST ast, ExecutionPayload payload)
    {

    }
}

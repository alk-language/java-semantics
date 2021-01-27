package execution.interpreter;

import ast.AST;
import ast.attr.BuiltInFunctionASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.RepresentationASTAttr;
import ast.enums.BuiltInFunction;
import ast.enums.CompoundValueRepresentation;
import ast.enums.Operator;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.state.ExecutionState;
import execution.state.expression.*;
import execution.state.expression.FactorPointMethod;
import execution.state.function.BuiltInFunctionState;
import execution.state.function.DefinedFunctionCallState;
import util.exception.InternalException;
import visitor.stateful.StatefulExpressionInterpreter;

public class BaseStatefulExpressionInterpreter
implements StatefulExpressionInterpreter<ExecutionPayload, ExecutionState>
{
    @Override
    public ExecutionState interpretRefId(AST ast, ExecutionPayload payload)
    {
        return new BaseRefIdValueState(ast, payload);
    }

    @Override
    public ExecutionState interpretFunctionCall(AST ast, ExecutionPayload payload)
    {
        return new DefinedFunctionCallState(ast, payload);
    }

    @Override
    public ExecutionState interpretPrimitive(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        return new BasePrimitiveValueState(primitive, ast, payload);
    }

    @Override
    public ExecutionState evaluateUnary(AST ast, ExecutionPayload payload)
    {
        OpsASTAttr attr = ast.getAttribute(OpsASTAttr.class);
        Operator op = attr.getOp(0);
        switch (op) {
            case PLUSPLUSLEFT: case MINUSMINUSLEFT:
                return new BasePrefixOperatorState(op, ast, payload);
            case PLUSPLUSRIGHT: case MINUSMINUSRIGHT:
                return new BasePostfixOperatorState(op, ast, payload);
            case POSITIVE: case NEGATIVE: case NOT:
                return new BaseUnaryOperatorState(op, ast, payload);
            case DOT:
                return new BaseDotOperatorState(ast, payload);
            default:
                throw new InternalException("Unrecognized unary operator: " + op);
        }
    }

    @Override
    public ExecutionState evaluateBinary(AST ast, ExecutionPayload payload)
    {
        return new BaseBinaryOperatorState(ast, payload);
    }

    @Override
    public ExecutionState evaluateTernary(AST ast, ExecutionPayload payload)
    {
        return new BaseConditionalOperatorState(ast, payload);
    }

    @Override
    public ExecutionState evaluateMethod(AST ast, ExecutionPayload payload)
    {
        return new FactorPointMethod(ast, payload);
    }

    @Override
    public ExecutionState evaluateFunction(AST ast, ExecutionPayload payload)
    {
        if (ast.hasAttribute(BuiltInFunctionASTAttr.class))
        {
            return new BuiltInFunctionState(ast, payload);
        }
        else
        {
            return null;
            // return new CustomFunctionState(ast, payload);
        }
    }

    @Override
    public ExecutionState interpretComposite(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        RepresentationASTAttr attr = ast.getAttribute(RepresentationASTAttr.class);
        CompoundValueRepresentation repr = attr.getRepresentation();
        switch (repr) {
            case EMPTY:
                return new EmptyIterableState(primitive, ast, payload);
            case EXPRESSIONS:
                return new IterableWithExpressionsState(primitive, ast, payload);
            case INTERVAL:
                return new IterableWithIntervalState(primitive, ast, payload);
            case FILTER_SPEC:
                return new IterableWithFilterSpecState(primitive, ast, payload);
            case MAP_SPEC:
                return new IterableWithMapSpecState(primitive, ast, payload);
            case COMPONENTS:
                return new BaseStructWithCompsState(ast, payload);
            default:
                throw new InternalException("Unrecognized compound data type representation: " + repr);
        }
    }
}

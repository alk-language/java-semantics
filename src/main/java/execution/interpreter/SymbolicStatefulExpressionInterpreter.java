package execution.interpreter;

import ast.AST;
import ast.attr.OpsASTAttr;
import ast.enums.Operator;
import ast.enums.Primitive;
import execution.ExecutionPayload;
import execution.parser.exceptions.NotImplementedException;
import execution.state.ExecutionState;
import execution.state.expression.BaseDotOperatorState;
import execution.state.expression.BasePostfixOperatorState;
import execution.state.expression.BasePrefixOperatorState;
import execution.state.expression.BaseUnaryOperatorState;
import execution.state.symbolic.SymbolicDotOperatorState;
import execution.state.symbolic.SymbolicPostfixOperatorState;
import execution.state.symbolic.SymbolicPrefixOperatorState;
import execution.state.symbolic.SymbolicUnaryOperatorState;
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
        return null;
    }

    @Override
    public ExecutionState evaluateTernary(AST ast, ExecutionPayload payload)
    {
        return null;
    }

    @Override
    public ExecutionState evaluateMethod(AST ast, ExecutionPayload payload)
    {
        return null;
    }

    @Override
    public ExecutionState evaluateFunction(AST ast, ExecutionPayload payload)
    {
        return null;
    }

    @Override
    public ExecutionState interpretAssignment(AST ast, ExecutionPayload payload)
    {
        throw new NotImplementedException("Assignment expressions can't be symbolically evaluated!");
    }

    @Override
    public ExecutionState interpretRefId(AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretRefId(ast, payload);
    }

    @Override
    public ExecutionState interpretPrimitive(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        return baseDelegate.interpretPrimitive(primitive, ast, payload);
    }

    @Override
    public ExecutionState interpretComposite(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        throw new NotImplementedException("Composite values can't be symbolically evaluated!");
    }
}

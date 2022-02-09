package execution.interpreter;

import ast.AST;
import ast.attr.AnnoAttr;
import ast.attr.BuiltInFunctionASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.RepresentationASTAttr;
import ast.enums.*;
import execution.ExecutionPayload;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.expression.*;
import execution.state.expression.FactorPointMethodState;
import execution.state.function.BuiltInFunctionState;
import execution.state.function.DefinedFunctionCallState;
import execution.state.statement.AssignmentState;
import util.exception.InternalException;
import visitor.stateful.StatefulExpressionInterpreter;

import java.util.List;

public class BaseStatefulExpressionInterpreter
implements StatefulExpressionInterpreter<ExecutionPayload, ExecutionState>
{
    @Override
    public ExecutionState interpretRefId(AST ast, ExecutionPayload payload)
    {
        return new BaseRefIdValueState(ast, payload);
    }

    @Override
    public ExecutionState interpretSymId(AST ast, ExecutionPayload payload)
    {
        throw new AlkException("Can't use the concrete execution in order to evaluate symbolic values.");
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
        return new FactorPointMethodState(ast, payload);
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
            return new DefinedFunctionCallState(ast, payload);
        }
    }

    @Override
    public ExecutionState interpretAssignment(AST ast, ExecutionPayload payload)
    {
        return new AssignmentState(ast, payload);
    }

    @Override
    public ExecutionState interpretComposite(Primitive primitive, AST ast, ExecutionPayload payload)
    {
        RepresentationASTAttr attr = ast.getAttribute(RepresentationASTAttr.class);
        CompoundValueRepresentation repr = attr.getRepresentation();
        switch (repr) {
            case EMPTY:
                return new EmptyCompositeState(primitive, ast, payload);
            case EXPRESSIONS:
                return new IterableWithExpressionsState(primitive, ast, payload);
            case INTERVAL:
                return new IterableWithIntervalState(primitive, ast, payload);
            case FILTER_SPEC:
                return new IterableWithFilterSpecState(primitive, ast, payload);
            case MAP_SPEC:
                return new IterableWithMapSpecState(primitive, ast, payload);
            case COMPONENTS:
            {
                if (primitive == Primitive.STRUCTURE)
                    return new BaseStructWithCompsState(ast, payload);
                else
                    return new BaseMapWithCompsState(ast, payload);
            }
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
                return new BaseImpliesState(ast, payload);
            case EQUIV:
                return new BaseEquivState(ast, payload);
            default:
                throw new AlkException("Can't use " + type + " operator in concrete execution!");
        }
    }

    @Override
    public ExecutionState interpretContextVar(ContextVar var, AST ast, ExecutionPayload payload)
    {
        throw new AlkException("Can't use context variables in concrete execution: " + var);
    }

    @Override
    public void interpretAnno(AST ast, ExecutionPayload payload)
    {
        AnnoAttr attr = ast.getAttribute(AnnoAttr.class);
        List<Anno> annos = attr.getAnnos();
        for (Anno anno : annos)
        {
            switch (anno) {
                case COUNT: payload.getAnnoHelper().count(ast); return;
            }
        }
        throw new InternalException("Unidentified or inexistent anno to analyze!");
    }

}

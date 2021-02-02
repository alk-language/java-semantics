package execution.state.statement;

import ast.AST;
import ast.attr.OpsASTAttr;
import ast.enums.Operator;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkNotAValue.AlkNotAValue;
import execution.parser.env.Location;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.UnimplementedException;

public class AssignmentState
extends ExecutionState
{
    private final Operator op;
    private AlkValue rightSide;
    private Location leftSide;

    public AssignmentState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        op = tree.getAttribute(OpsASTAttr.class).getOpList().get(0);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
        {
            return super.request(tree.getChild(1));
        }

        if (leftSide == null)
        {
            return super.request(tree.getChild(0));
        }

        try
        {
            AlkValue leftValue = (AlkValue) leftSide.getValue();
            switch (op)
            {
                case ASSIGN: break;
                case PLUS_ASSIGN: rightSide = leftValue.add(rightSide); break;
                case MINUS_ASSIGN: rightSide = leftValue.subtract(rightSide); break;
                case MULTIPLY_ASSIGN: rightSide = leftValue.multiply(rightSide); break;
                case DIVIDE_ASSIGN: rightSide = leftValue.divide(rightSide); break;
                case MOD_ASSIGN: rightSide = leftValue.mod(rightSide); break;
                case LSHIFT_ASSSIGN: rightSide = leftValue.shiftleft(rightSide); break;
                case RSHIFT_ASSIGN: rightSide = leftValue.shiftright(rightSide); break;
                case LOR_ASSIGN: rightSide = leftValue.bitwiseor(rightSide); break;
                case LAND_ASSIGN: rightSide = leftValue.bitwiseand(rightSide); break;
                default: throw new UnimplementedException("Unimplemented assignment operator: " + op);
            }

            leftSide.assign(rightSide.clone(generator));
            setResult(new ExecutionResult(leftSide));
        }
        catch (AlkException e)
        {
            super.handle(e);
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) executionResult.getValue().toRValue();
            if (rightSide == null || rightSide instanceof AlkNotAValue)
            {
                super.handle(new AlkException("Undefined variable used in assignment."));
            }
            return;
        }
        if (leftSide == null)
        {
            leftSide = executionResult.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssignmentState copy = new AssignmentState(tree, payload.clone(sm));
        copy.rightSide = rightSide.weakClone(sm.getLocationMapper());
        copy.leftSide = sm.getLocationMapper().get(leftSide);
        return super.decorate(copy, sm);
    }
}
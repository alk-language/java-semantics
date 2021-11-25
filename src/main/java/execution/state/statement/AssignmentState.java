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
import util.types.Storable;

public class AssignmentState
extends ExecutionState
{
    protected final Operator op;
    protected Storable rightSide;
    protected Location leftSide;

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
            AlkValue rightValue = (AlkValue) rightSide.toRValue();
            if (op != Operator.ASSIGN)
            {
                AlkValue leftValue = (AlkValue) leftSide.getValue();
                switch (op)
                {
                    case PLUS_ASSIGN:
                        rightValue = leftValue.add(rightValue, generator);
                        break;
                    case MINUS_ASSIGN:
                        rightValue = leftValue.subtract(rightValue);
                        break;
                    case MULTIPLY_ASSIGN:
                        rightValue = leftValue.multiply(rightValue);
                        break;
                    case DIVIDE_ASSIGN:
                        rightValue = leftValue.divide(rightValue);
                        break;
                    case MOD_ASSIGN:
                        rightValue = leftValue.mod(rightValue);
                        break;
                    case LSHIFT_ASSSIGN:
                        rightValue = leftValue.shiftleft(rightValue);
                        break;
                    case RSHIFT_ASSIGN:
                        rightValue = leftValue.shiftright(rightValue);
                        break;
                    case LOR_ASSIGN:
                        rightValue = leftValue.bitwiseor(rightValue);
                        break;
                    case LAND_ASSIGN:
                        rightValue = leftValue.bitwiseand(rightValue);
                        break;
                    default:
                        throw new UnimplementedException("Unimplemented assignment operator: " + op);
                }
            }

            leftSide.setValue(rightValue.clone(generator));
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
            rightSide = executionResult.getValue().toRValue();
            checkNotNull(rightSide, true);
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
        if (rightSide != null)
        {
            copy.rightSide = rightSide.weakClone(sm.getLocationMapper());
        }
        copy.leftSide = sm.getLocationMapper().get(leftSide);
        return super.decorate(copy, sm);
    }

    public ExecutionState decorate(AssignmentState copy, SplitMapper sm)
    {
        if (rightSide != null)
        {
            copy.rightSide = rightSide.weakClone(sm.getLocationMapper());
        }
        copy.leftSide = sm.getLocationMapper().get(leftSide);
        return super.decorate(copy, sm);
    }
}
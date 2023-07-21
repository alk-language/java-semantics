package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.InvalidLeftValueException;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.exeptions.UnimplementedException;
import ro.uaic.info.alk.util.types.Storable;

public class AssignmentState
   extends ExecutionState
{
    protected final Operator op;
    protected Storable rightSide;
    protected Location leftSide;

    public AssignmentState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
        // TODO: this doesn't work for a += b += c; this needs better testing
        op = tree.getAttribute(OpsASTAttr.class).getOpList().get(0);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
        {
            return super.requestChild(1);
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
                AlkValue leftValue = (AlkValue) leftSide.toRValue();
                checkNotNull(leftValue, false, getTree().getChild(0));

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
                    case LEFT_SHIFT_ASSIGN:
                        rightValue = leftValue.shiftLeft(rightValue);
                        break;
                    case RIGHT_SHIFT_ASSIGN:
                        rightValue = leftValue.shiftRight(rightValue);
                        break;
                    case BITWISE_OR_ASSIGN:
                        rightValue = leftValue.bitwiseOr(rightValue);
                        break;
                    case BITWISE_AND_ASSIGN:
                        rightValue = leftValue.bitwiseAnd(rightValue);
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
            super.handle(new InvalidOperationException(op, leftSide.toRValue(), rightSide, e));
        }

        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        try
        {
            if (rightSide == null)
            {
                rightSide = executionResult.toRValue();
                checkNotNull(rightSide, false, tree.getChild(1));
            }
            else if (leftSide == null)
            {
                leftSide = executionResult.toLValue();
                // TODO: is this required ?
                // checkNotNull(leftSide, true, tree.getChild(0));
            }
        }
        catch (InvalidLeftValueException ilve)
        {
            super.handle(new AlkException("Invalid left-side of assignment: " + tree.getChild(0), ilve));
        }
        catch (AlkException ex)
        {
            super.handle(ex);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssignmentState copy = new AssignmentState(tree, payload.clone(sm));
        return this.decorate(copy, sm);
    }

    public ExecutionState decorate(AssignmentState copy, SplitMapper sm)
    {
        copy.rightSide = this.rightSide == null ? null : this.rightSide.weakClone(sm.getLocationMapper());
        copy.leftSide = this.leftSide == null ? null : this.leftSide.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
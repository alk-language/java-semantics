package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.OperatorUtils;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.AssignmentState;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.exeptions.UnimplementedException;

import java.util.ArrayList;
import java.util.List;

public class SymbolicAssignmentState
   extends AssignmentState
{
    public SymbolicAssignmentState(AST tree, ExecutionPayload payload)
    {
        super(tree, payload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null || leftSide == null || !resultIsSymbolic())
        {
            return super.makeStep();
        }

        try
        {
            SymbolicValue rightValue = SymbolicValue.toSymbolic(rightSide);

            if (op != Operator.ASSIGN)
            {
                checkNotNull(leftSide, false, tree.getChild(0));
                SymbolicValue leftValue = SymbolicValue.toSymbolic(leftSide.toRValue());

                List<AST> children = new ArrayList<>();
                children.add(leftValue.toAST());
                children.add(rightValue.toAST());

                Operator assignOp;
                switch (op)
                {
                    case PLUS_ASSIGN: assignOp = Operator.ADD; break;
                    case MINUS_ASSIGN: assignOp = Operator.SUBTRACT; break;
                    case MULTIPLY_ASSIGN: assignOp = Operator.MULTIPLY; break;
                    case DIVIDE_ASSIGN: assignOp = Operator.DIVIDE; break;
                    case MOD_ASSIGN: assignOp = Operator.MOD; break;
                    case LEFT_SHIFT_ASSIGN: assignOp = Operator.SHIFT_LEFT; break;
                    case RIGHT_SHIFT_ASSIGN: assignOp = Operator.SHIFT_RIGHT; break;
                    case BITWISE_OR_ASSIGN: assignOp = Operator.BITWISE_OR; break;
                    case BITWISE_AND_ASSIGN: assignOp = Operator.BITWISE_AND; break;
                    default: throw new UnimplementedException("Unimplemented assignment operator: " + op);
                }

                // TODO: check if the operator is permitted (e.g. "a" - 2 is not valid)
                rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(assignOp, children));
            }

            // TODO: does this clone make sense? right value was freshly created
            leftSide.setValue(rightValue.clone(generator));
            setResult(new ExecutionResult(leftSide));
        }
        catch (AlkException e)
        {
            super.handle(new InvalidOperationException(op, leftSide, rightSide, e));
        }

        return null;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssignmentState copy = new SymbolicAssignmentState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }

    private boolean resultIsSymbolic()
    {
        if (rightSide instanceof SymbolicValue)
        {
            return true;
        }

        if (leftSide.isUnknown())
        {
            return false;
        }

        return op != Operator.ASSIGN && leftSide.toRValue() instanceof SymbolicValue;
    }
}

package execution.state.symbolic;

import ast.AST;
import ast.OperatorUtils;
import ast.enums.Operator;
import ast.symbolic.SelectAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.AssignmentState;
import execution.types.alkNotAValue.AlkNotAValue;
import symbolic.SymbolicExecutionPayload;
import symbolic.SymbolicValue;
import util.exception.UnimplementedException;

import java.util.ArrayList;
import java.util.List;

public class SymbolicAssignmentState
extends AssignmentState
{
    public SymbolicAssignmentState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    private boolean resultIsSymbolic()
    {
        if (rightSide instanceof SymbolicValue)
        {
            return true;
        }
        if (leftSide.toLValue().isUnknown())
        {
            return false;
        }
        return op != Operator.ASSIGN && leftSide.toRValue() instanceof SymbolicValue;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
        {
            return (ExecutionState) super.request(tree.getChild(1), new SymbolicExecutionPayload(getExec(), getEnv()));
        }

        if (leftSide == null)
        {
            return (ExecutionState) super.request(tree.getChild(0), new SymbolicExecutionPayload(getExec(), getEnv()));
        }

        if (resultIsSymbolic())
        {
            try
            {
                SymbolicValue rightValue = SymbolicValue.toSymbolic(rightSide.toRValue());

                if (leftSide.toRValue() == null && op != Operator.ASSIGN)
                {
                    super.handle(new AlkException("Undefined variable in compound assignment!"));
                }

                if (leftSide.toRValue() != null && op != Operator.ASSIGN)
                {
                    SymbolicValue leftValue = SymbolicValue.toSymbolic(leftSide.toRValue());
                    List<AST> children = new ArrayList<>();
                    children.add(leftValue.toAST());
                    children.add(rightValue.toAST());

                    switch (op)
                    {
                        case PLUS_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.ADD, children)); break;
                        case MINUS_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.SUBTRACT, children)); break;
                        case MULTIPLY_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.MULTIPLY, children)); break;
                        case DIVIDE_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.DIVIDE, children)); break;
                        case MOD_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.MOD, children)); break;
                        case LSHIFT_ASSSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.SHIFTLEFT, children)); break;
                        case RSHIFT_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.SHIFTRIGHT, children)); break;
                        case LOR_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.LOGICALOR, children)); break;
                        case LAND_ASSIGN: rightValue = new SymbolicValue(OperatorUtils.getOperatorAST(Operator.LOGICALAND, children)); break;
                        default: throw new UnimplementedException("Unimplemented assignment operator: " + op);
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
        else
        {
            return super.makeStep();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssignmentState copy = new SymbolicAssignmentState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package execution.state.symbolic;

import ast.AST;
import ast.OperatorUtils;
import ast.enums.Operator;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.AssignmentState;
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
        return rightSide instanceof SymbolicValue ||
                (!leftSide.toLValue().isUnknown() && SymbolicValue.toSymbolic(leftSide.toRValue()) != null && op != Operator.ASSIGN);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (leftSide == null || rightSide == null)
        {
            return super.makeStep();
        }

        if (resultIsSymbolic())
        {
            try
            {
                SymbolicValue rightValue = SymbolicValue.toSymbolic(rightSide.toRValue());
                SymbolicValue leftValue = SymbolicValue.toSymbolic(leftSide.toRValue());

                if (leftValue == null && op != Operator.ASSIGN)
                {
                    super.handle(new AlkException("Undefined variable in compound assignment!"));
                }

                if (leftValue != null && op != Operator.ASSIGN)
                {

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

                leftSide.assign(rightValue.clone(generator));
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

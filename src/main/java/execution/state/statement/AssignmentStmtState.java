package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.main.MainState;
import grammar.alkParser;
import parser.env.Location;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.AssignedVisitor;
import parser.visitors.ReferenceVisitor;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.VisitorFactory;
import util.exception.InternalException;
import util.exception.UnimplementedException;

@CtxState(ctxClass = alkParser.AssignmentStmtContext.class)
public class AssignmentStmtState extends ExecutionState
{

    private alkParser.AssignmentStmtContext ctx;
    private AlkValue rightSide;
    private Location leftSide;
    private String operator;

    public AssignmentStmtState(alkParser.AssignmentStmtContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
        operator = ctx.ASSIGNMENT_OPERATOR().getText();
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
        {
            return super.request(ExpressionVisitor.class, ctx.expression());
        }

        if (leftSide == null)
        {
            return super.request(ExpressionVisitor.class, ctx.ref_name());
        }

        AlkValue leftValue = leftSide.getValue();
        switch (operator)
        {
            case "=": break;
            case "+=": rightSide = leftValue.add(rightSide); break;
            case "-=": rightSide = leftValue.subtract(rightSide); break;
            case "*=": rightSide = leftValue.multiply(rightSide); break;
            case "/=": rightSide = leftValue.divide(rightSide); break;
            case "%=": rightSide = leftValue.mod(rightSide); break;
            case "<<=": rightSide = leftValue.shiftLeft(rightSide); break;
            case ">>=": rightSide = leftValue.shiftRight(rightSide); break;
            case "|=": rightSide = leftValue.bitwiseOr(rightSide); break;
            case "&=": rightSide = leftValue.bitwiseAnd(rightSide); break;
            default:
                throw new UnimplementedException("Unimplemented assignment operator: " + operator);
        }

        leftSide.assign(rightSide);
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) result.getValue().toRValue();
        }
        else if (leftSide == null)
        {
            leftSide = result.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        AssignmentStmtState copy = new AssignmentStmtState((alkParser.AssignmentStmtContext) tree, payload);
        copy.rightSide = rightSide.clone();

        // TODO: Location doesn't clone fine as it doesn't know the new store (is this however mandatory?)
        copy.leftSide = leftSide.clone();
        return super.decorate(copy);
    }
}
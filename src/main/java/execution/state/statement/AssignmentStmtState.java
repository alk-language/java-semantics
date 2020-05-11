package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.env.Location;
import execution.types.AlkValue;
import parser.env.Store;
import parser.exceptions.AlkException;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
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

        try {
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

            leftSide.assign(rightSide.clone(generator));
        }
        catch (AlkException e)
        {
            super.handle(e);
        }
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
    public ExecutionState clone(SplitMapper sm) {
        AssignmentStmtState copy = new AssignmentStmtState((alkParser.AssignmentStmtContext) tree, sm.getPayload());
        copy.rightSide = rightSide.weakClone(sm.getLocationMapper());
        copy.leftSide = sm.getLocationMapper().get(leftSide);
        return super.decorate(copy, sm);
    }
}
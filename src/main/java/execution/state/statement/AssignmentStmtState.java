package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.types.alkNotAValue.AlkNotAValue;
import grammar.alkParser;
import execution.parser.env.Location;
import execution.types.AlkValue;
import execution.parser.exceptions.AlkException;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.UnimplementedException;
import util.types.Value;

@CtxState(ctxClass = alkParser.AssignmentStmtContext.class)
public class AssignmentStmtState extends ExecutionState<Value, Value>
{

    private alkParser.AssignmentStmtContext ctx;
    private AlkValue rightSide;
    private Location leftSide;
    private String operator;

    public AssignmentStmtState(alkParser.AssignmentStmtContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
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
            return super.request(ExpressionVisitor.class, ctx.factor());
        }

        try {
            AlkValue leftValue = (AlkValue) leftSide.getValue();
            switch (operator)
            {
                case "=": break;
                case "+=": rightSide = leftValue.add(rightSide); break;
                case "-=": rightSide = leftValue.subtract(rightSide); break;
                case "*=": rightSide = leftValue.multiply(rightSide); break;
                case "/=": rightSide = leftValue.divide(rightSide); break;
                case "%=": rightSide = leftValue.mod(rightSide); break;
                case "<<=": rightSide = leftValue.shiftleft(rightSide); break;
                case ">>=": rightSide = leftValue.shiftright(rightSide); break;
                case "|=": rightSide = leftValue.bitwiseor(rightSide); break;
                case "&=": rightSide = leftValue.bitwiseand(rightSide); break;
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
    public void assign(ExecutionResult executionResult)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) executionResult.getValue().toRValue();
            if (rightSide == null || rightSide instanceof AlkNotAValue)
            {
                throw new AlkException(ctx.start.getLine(), "Undefined variable used in assignment.");
            }
        }
        else if (leftSide == null)
        {
            leftSide = executionResult.getValue().toLValue();
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        AssignmentStmtState copy = new AssignmentStmtState((alkParser.AssignmentStmtContext) tree, sm.getExecutionPayload());
        copy.rightSide = rightSide.weakClone(sm.getLocationMapper());
        copy.leftSide = sm.getLocationMapper().get(leftSide);
        return super.decorate(copy, sm);
    }
}
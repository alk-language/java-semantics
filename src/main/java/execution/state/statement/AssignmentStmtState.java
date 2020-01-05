package execution.state.statement;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.main.MainState;
import grammar.alkParser;
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
    private String operator;

    private AssignmentStmtState(alkParser.AssignmentStmtContext tree, Payload payload) {
        super(tree, payload);
        ctx = tree;
        operator = ctx.ASSIGNMENT_OPERATOR().getText();
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
            return super.request(ExpressionVisitor.class, ctx.expression());

        if (operator.equals("="))
        {
            // TODO: rethink the AssignedVisitor
            AssignedVisitor asgnVisitor = new AssignedVisitor(getEnv(), rightSide);
            asgnVisitor.visit(ctx.ref_name());
            return null;
        }

        // TODO: rethink the ReferenceVisitor
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(getEnv());
        AlkValue leftSide = ((AlkValue) referenceVisitor.visit(ctx.ref_name())).clone();

        switch (operator)
        {
            case "+=": rightSide = leftSide.add(rightSide); break;
            case "-=": rightSide = leftSide.subtract(rightSide); break;
            case "*=": rightSide = leftSide.multiply(rightSide); break;
            case "/=": rightSide = leftSide.divide(rightSide); break;
            case "%=": rightSide = leftSide.mod(rightSide); break;
            case "<<=": rightSide = leftSide.shiftLeft(rightSide); break;
            case ">>=": rightSide = leftSide.shiftLeft(rightSide); break;
            case "|=": rightSide = leftSide.bitwiseOr(rightSide); break;
            case "&=": rightSide = leftSide.bitwiseAnd(rightSide); break;
            default:
                throw new UnimplementedException("Unimplemented assignment operator: " + operator);
        }

        AssignedVisitor asgnVisitor = new AssignedVisitor(getEnv(), rightSide);
        asgnVisitor.visit(ctx.ref_name());
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) result.getValue();
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        AssignmentStmtState copy = new AssignmentStmtState((alkParser.AssignmentStmtContext) tree, payload);
        copy.rightSide = rightSide.clone();
        return super.decorate(copy);
    }
}
package parser.visitors;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import util.exception.InternalException;
import util.exception.UnimplementedException;

public class AssignmentStmtState extends ExecutionState
{

    private alkParser.AssignmentStmtContext ctx;
    private AlkValue rightSide;
    private String operator;

    AssignmentStmtState(alkParser.AssignmentStmtContext tree, StmtVisitor visitor) {
        super(tree, visitor);
        env = visitor.getEnvironment();
        ctx = tree;
        operator = ctx.ASSIGNMENT_OPERATOR().getText();
    }

    @Override
    public ExecutionState makeStep()
    {
        if (rightSide == null)
            return (ExecutionState) new ExpressionVisitor(env).visit(ctx.expression());

        if (operator.equals("="))
        {
            // TODO: rethink the AssignedVisitor
            AssignedVisitor asgnVisitor = new AssignedVisitor(env, rightSide);
            asgnVisitor.visit(ctx.ref_name());
            return null;
        }

        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
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

        AssignedVisitor asgnVisitor = new AssignedVisitor(env, rightSide);
        asgnVisitor.visit(ctx.ref_name());
        return null;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (rightSide == null)
        {
            rightSide = (AlkValue) result.getValue();
            return;
        }


    }
}


/*
        if (returnValue != null || breakFlag || continueFlag) return null;
        ExpressionVisitor exprVisitor = new ExpressionVisitor(env);
        ReferenceVisitor referenceVisitor = new ReferenceVisitor(env);
        AlkValue right_side = ((AlkValue) exprVisitor.visit(ctx.expression())).clone();
        if (ctx.ASSIGNMENT_OPERATOR().getText().equals("="))
        {
            AssignedVisitor asgnVisitor = new AssignedVisitor(env, right_side);
            return asgnVisitor.visit(ctx.ref_name());
        }
        AlkValue left_side = ((AlkValue) referenceVisitor.visit(ctx.ref_name())).clone();
        try {
            switch (ctx.ASSIGNMENT_OPERATOR().getText())
            {
                case "+=": right_side = left_side.add(right_side); break;
                case "-=": right_side = left_side.subtract(right_side); break;
                case "*=": right_side = left_side.multiply(right_side); break;
                case "/=": right_side = left_side.divide(right_side); break;
                case "%=": right_side = left_side.mod(right_side); break;
                case "<<=": right_side = left_side.shiftLeft(right_side); break;
                case ">>=": right_side = left_side.shiftLeft(right_side); break;
                case "|=": right_side = left_side.bitwiseOr(right_side); break;
                case "&=": right_side = left_side.bitwiseAnd(right_side); break;
                default: ;
            }
        } catch (InterpretorException e) {
            e.printException(ctx.start.getLine());
            return null;
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return null;
        }
        AssignedVisitor asgnVisitor = new AssignedVisitor(env, right_side);
        return asgnVisitor.visit(ctx.ref_name()); */
package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GenericState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkBool.AlkBool;

import static parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

public class ConditionalExpressionState extends ExecutionState {

    private alkParser.ConditionalExpressionContext ctx;
    private AlkValue queryExpression;

    public ConditionalExpressionState(alkParser.ConditionalExpressionContext tree, alkBaseVisitor visitor) {
        super(tree, visitor);
        ctx = tree;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (result != null)
        {
            return null;
        }

        if (queryExpression == null)
        {
            return (ExecutionState) visitor.visit(ctx.logical_or_expression());
        }

        if (ctx.expression().size() == 0)
        {
            result = new ExecutionResult(queryExpression);
            return null;
        }

        if (!(queryExpression instanceof AlkBool))
        {
            throw new AlkException(ERR_CONDITIONAL_NO_BOOL);
        }

        if (((AlkBool) queryExpression).value)
        {
            return (ExecutionState) visitor.visit(ctx.expression(0));
        }
        else
        {
            return (ExecutionState) visitor.visit(ctx.expression(1));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (queryExpression == null)
        {
            queryExpression = result.getValue();
        }
        else
        {
            this.result = result;
        }
    }
}
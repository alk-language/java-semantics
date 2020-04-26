package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToPostfixExpressionContext.class)
public class ToPostfixExpressionState extends GatewaySingleState {

    alkParser.ToPostfixExpressionContext ctx;

    public ToPostfixExpressionState(alkParser.ToPostfixExpressionContext tree, Payload payload) {
        super(tree, payload, tree.postfix_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ToPostfixExpressionState copy = new ToPostfixExpressionState(ctx, payload);
        return super.decorate(copy);
    }
}

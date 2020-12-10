package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToPostfixExpressionContext.class)
public class ToPostfixExpressionState extends GatewaySingleState {

    alkParser.ToPostfixExpressionContext ctx;

    public ToPostfixExpressionState(alkParser.ToPostfixExpressionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.postfix_expression(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToPostfixExpressionState copy = new ToPostfixExpressionState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

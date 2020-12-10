package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.RefNameFactorContext.class)
public class RefNameFactorState extends GatewaySingleState {

    alkParser.RefNameFactorContext ctx;

    public RefNameFactorState(alkParser.RefNameFactorContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.ref_name(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RefNameFactorState copy = new RefNameFactorState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.reference;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.ToBaseFactorContext.class)
public class ToBaseFactor extends GatewaySingleState {

    public ToBaseFactor(alkParser.ToBaseFactorContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.base_factor(), ExpressionVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToBaseFactor copy = new ToBaseFactor((alkParser.ToBaseFactorContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

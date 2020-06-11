package execution.state.reference;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.ToBaseFactorContext.class)
public class ToBaseFactor extends GatewaySingleState {

    public ToBaseFactor(alkParser.ToBaseFactorContext tree, Payload payload)
    {
        super(tree, payload, tree.base_factor(), ExpressionVisitor.class);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ToBaseFactor copy = new ToBaseFactor((alkParser.ToBaseFactorContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

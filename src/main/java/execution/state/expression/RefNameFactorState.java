package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import parser.env.LocationMapper;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;

@CtxState(ctxClass = alkParser.RefNameFactorContext.class)
public class RefNameFactorState extends GatewaySingleState {

    alkParser.RefNameFactorContext ctx;

    public RefNameFactorState(alkParser.RefNameFactorContext tree, Payload payload) {
        super(tree, payload, tree.ref_name(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RefNameFactorState copy = new RefNameFactorState(ctx, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

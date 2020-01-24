package execution.state.expression;

import execution.state.ExecutionState;
import execution.state.GatewaySingleState;
import grammar.alkParser;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.RefNameFactorContext.class)
public class RefNameFactorState extends GatewaySingleState {

    alkParser.RefNameFactorContext ctx;

    public RefNameFactorState(alkParser.RefNameFactorContext tree, Payload payload) {
        super(tree, payload, tree.ref_name(), ExpressionVisitor.class);
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        RefNameFactorState copy = new RefNameFactorState(ctx, payload);
        return super.decorate(copy);
    }
}

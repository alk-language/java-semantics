package execution.state.expression;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.visitors.ReferenceVisitor;
import util.CtxState;
import util.Payload;
import util.types.Value;

@CtxState(ctxClass = alkParser.RefNameFactorContext.class)
public class RefNameFactorState extends ExecutionState {

    alkParser.RefNameFactorContext ctx;

    public RefNameFactorState(alkParser.RefNameFactorContext tree, Payload payload) {
        super(tree, payload);
        this.ctx = tree;
    }

    @Override
    public ExecutionState makeStep() {
        result = new ExecutionResult((Value) new ReferenceVisitor(getEnv()).visit(ctx.ref_name()));
        return null;
    }

    @Override
    public void assign(ExecutionResult result) {
        // no-op
    }

    @Override
    public ExecutionState clone(Payload payload) {
        RefNameFactorState copy = new RefNameFactorState(ctx, payload);
        return super.decorate(copy);
    }
}

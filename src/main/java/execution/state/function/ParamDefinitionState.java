package execution.state.function;

import execution.state.ExecutionState;
import execution.state.PrimitiveState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.CtxState;
import util.Payload;
import util.functions.Parameter;
import util.types.Value;

@CtxState(ctxClass = alkParser.ParamDefinitionContext.class)
public class ParamDefinitionState extends PrimitiveState {

    alkParser.ParamDefinitionContext ctx;

    public ParamDefinitionState(alkParser.ParamDefinitionContext tree, Payload payload) {
        super(tree, payload, new Parameter(tree.ID().getText(), tree.OUT() != null));
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ParamDefinitionState copy = new ParamDefinitionState(ctx, payload);
        return super.decorate(copy);
    }
}

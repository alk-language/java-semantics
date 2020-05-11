package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.SplitMapper;
import util.types.ComponentValue;
import util.types.Value;

@CtxState(ctxClass = alkParser.ComponentDefinitionContext.class)
public class ComponentDefinitionState extends SingleState <ComponentValue, AlkValue>
{

    private alkParser.ComponentDefinitionContext ctx;

    public ComponentDefinitionState(alkParser.ComponentDefinitionContext tree, Payload payload) {
        super(tree, payload, tree.expression(), ExpressionVisitor.class);
        ctx = tree;
    }

    @Override
    protected ComponentValue interpretResult(Value value) {
        String identifier = ctx.ID().toString();
        return new ComponentValue(identifier, generator.generate((AlkValue) value.toRValue()));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ComponentDefinitionState copy = new ComponentDefinitionState((alkParser.ComponentDefinitionContext) tree, sm.getPayload());
        return super.decorate(copy, sm);
    }
}

package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import execution.types.AlkValue;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.ComponentValue;
import util.types.Value;

@CtxState(ctxClass = alkParser.ComponentDefinitionContext.class)
public class ComponentDefinitionState extends SingleState <ComponentValue, AlkValue>
{

    private alkParser.ComponentDefinitionContext ctx;

    public ComponentDefinitionState(alkParser.ComponentDefinitionContext tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.expression(), ExpressionVisitor.class);
        ctx = tree;
    }

    @Override
    protected ComponentValue interpretResult(Value value) {
        String identifier = ctx.ID().toString();
        return new ComponentValue(identifier, generator.generate((AlkValue) value.toRValue()));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ComponentDefinitionState copy = new ComponentDefinitionState((alkParser.ComponentDefinitionContext) tree, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

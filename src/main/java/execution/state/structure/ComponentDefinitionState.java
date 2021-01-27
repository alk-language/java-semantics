package execution.state.structure;

import ast.AST;
import execution.state.ExecutionState;
import execution.state.SingleState;
import grammar.alkParser;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.ComponentValue;
import util.types.Value;

@CtxState(ctxClass = alkParser.ComponentDefinitionContext.class)
public class ComponentDefinitionState extends SingleState
{

    public ComponentDefinitionState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.getChild(0)); // expression
    }

    @Override
    protected ComponentValue interpretResult(Value value) {
        String identifier = tree.getText(); // id
        return new ComponentValue(identifier, generator.generate(value.toRValue()));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        ComponentDefinitionState copy = new ComponentDefinitionState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package execution.state.structure;

import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.state.statement.ToChooseStmtState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.CtxState;
import util.Payload;
import util.types.ComponentValue;

@CtxState(ctxClass = alkParser.ComponentDefinitionContext.class)
public class ComponentDefinitionState extends SingleState <ComponentValue, AlkValue>
{

    private alkParser.ComponentDefinitionContext ctx;

    public ComponentDefinitionState(alkParser.ComponentDefinitionContext tree, Payload payload) {
        super(tree, payload, tree.expression(), ExpressionVisitor.class);
        ctx = tree;
    }

    @Override
    protected ComponentValue interpretResult(AlkValue value) {
        String identifier = ctx.ID().toString();
        return new ComponentValue(identifier, value);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        ComponentDefinitionState copy = new ComponentDefinitionState((alkParser.ComponentDefinitionContext) tree, payload);
        return super.decorate(copy);
    }
}

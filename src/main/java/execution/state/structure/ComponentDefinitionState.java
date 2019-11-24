package execution.state.structure;

import execution.state.SingleState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.types.ComponentValue;

public class ComponentDefinitionState extends SingleState <ComponentValue, AlkValue>
{

    private alkParser.ComponentDefinitionContext ctx;

    public ComponentDefinitionState(alkParser.ComponentDefinitionContext tree, DataStructureVisitor visitor) {
        super(tree, new ExpressionVisitor(visitor.getEnvironment()), tree.expression());
        ctx = tree;
    }

    @Override
    protected ComponentValue interpretResult(AlkValue value) {
        String identifier = ctx.ID().toString();
        return new ComponentValue(identifier, value);
    }
}
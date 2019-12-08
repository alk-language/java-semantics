package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Payload;
import util.types.Value;

public class IndependentSingleState extends SingleState
{

    public IndependentSingleState(ParseTree tree, Payload payload, ParseTree dependency) {
        super(tree, payload, dependency);
    }

    @Override
    protected Value interpretResult(Value value) {
        return null;
    }
}

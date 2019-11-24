package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.types.Value;

public class IndependentSingleState extends SingleState
{

    public IndependentSingleState(ParseTree tree, alkBaseVisitor visitor, ParseTree dependency) {
        super(tree, visitor, dependency);
    }

    @Override
    protected Value interpretResult(Value value) {
        return null;
    }
}

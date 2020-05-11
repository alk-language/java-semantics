package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

public abstract class IndependentSingleState extends SingleState
{

    public IndependentSingleState(ParseTree tree,
                                  Payload payload,
                                  ParseTree dependency,
                                  Class<? extends alkBaseVisitor> visitor) {
        super(tree, payload, dependency, visitor);
    }

    @Override
    protected Value interpretResult(Value value) {
        return null;
    }

    protected IndependentSingleState decorate(IndependentSingleState copy, SplitMapper sm)
    {
        return (IndependentSingleState) super.decorate(copy, sm);
    }
}

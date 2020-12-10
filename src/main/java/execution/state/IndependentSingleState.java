package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class IndependentSingleState extends SingleState
{

    public IndependentSingleState(ParseTree tree,
                                  ExecutionPayload executionPayload,
                                  ParseTree dependency,
                                  Class<? extends alkBaseVisitor> visitor) {
        super(tree, executionPayload, dependency, visitor);
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

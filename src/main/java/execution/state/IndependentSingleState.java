package execution.state;

import ast.AST;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class IndependentSingleState extends SingleState
{

    public IndependentSingleState(AST tree, ExecutionPayload executionPayload, AST dependency) {
        super(tree, executionPayload, dependency);
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

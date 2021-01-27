package execution.state;

import ast.AST;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class GatewaySingleState extends SingleState {

    public GatewaySingleState(AST tree, ExecutionPayload executionPayload, AST dependency) {
        super(tree, executionPayload, dependency);
    }

    @Override
    protected Value interpretResult(Value value)
    {
        return value;
    }

    protected GatewaySingleState decorate(GatewaySingleState copy, SplitMapper sm)
    {
        return (GatewaySingleState) super.decorate(copy, sm);
    }
}

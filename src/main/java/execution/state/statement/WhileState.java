package execution.state.statement;

import ast.AST;
import ast.stmt.WhileAST;
import execution.state.ExecutionState;
import execution.state.LoopingState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

import java.util.List;

public class WhileState
extends LoopingState
{
    public WhileState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload,
              ((WhileAST) tree).getCondition(),
              !((WhileAST) tree).getInvariants().isEmpty() ? ((WhileAST) tree).getInvariants() : null,
              ((WhileAST) tree).getStatement());
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        WhileState copy = new WhileState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.stmt.WhileAST;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.LoopingState;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;

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

package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.LoopingState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.WhileStructureContext.class)
public class WhileState extends LoopingState
{
    private alkParser.WhileStructureContext ctx;

    public WhileState(alkParser.WhileStructureContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        WhileState copy = new WhileState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}

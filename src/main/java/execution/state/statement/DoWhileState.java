package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.DoWhileStructureContext.class)
public class DoWhileState extends FinalCheckLoopingState
{
    private alkParser.DoWhileStructureContext ctx;

    public DoWhileState(alkParser.DoWhileStructureContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        DoWhileState copy = new DoWhileState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }
}
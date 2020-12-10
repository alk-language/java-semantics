package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.FinalCheckLoopingState;
import grammar.alkParser;
import execution.parser.visitors.StmtVisitor;
import execution.parser.visitors.expression.ExpressionVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;

@CtxState(ctxClass = alkParser.RepeatStructureContext.class)
public class RepeatUntilState extends FinalCheckLoopingState
{
    private alkParser.RepeatStructureContext ctx;

    public RepeatUntilState(alkParser.RepeatStructureContext tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, ExpressionVisitor.class, StmtVisitor.class, tree.expression(), tree.statement());
        this.ctx = tree;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        RepeatUntilState copy = new RepeatUntilState(ctx, sm.getExecutionPayload());
        return super.decorate(copy, sm);
    }

    @Override
    protected boolean processValidity(boolean validCondition)
    {
        return !validCondition;
    }
}
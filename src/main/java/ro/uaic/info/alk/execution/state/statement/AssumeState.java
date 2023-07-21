package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Statement;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.SingleState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InvalidAssumptionException;
import ro.uaic.info.alk.exeptions.InvalidStatementException;
import ro.uaic.info.alk.exeptions.UnexpectedTypeException;
import ro.uaic.info.alk.util.types.Storable;

/**
 * Interpretation state of the {@code assume} statement. In concrete execution
 * this is mostly a no-op. It simply returns {@code true} on the stack, after evaluating
 * the expression. However, {@code true} is expected from the provided expression.
 */
public class AssumeState
   extends SingleState
{
    public AssumeState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        if (!(value instanceof AlkBool))
        {
            throw new InvalidStatementException(Statement.ASSUME,
                                                new UnexpectedTypeException(tree.getChild(0),
                                                                            value,
                                                                            AlkBool.class));
        }

        if (((AlkBool) value).isFalse())
        {
            super.handle(new InvalidAssumptionException(tree.getChild(0)));
        }

        return AlkBool.TRUE;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssumeState copy = new AssumeState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }

}

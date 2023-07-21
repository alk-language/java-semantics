package ro.uaic.info.alk.execution.state.statement;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Statement;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.SingleState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InvalidAssertionException;
import ro.uaic.info.alk.exeptions.InvalidStatementException;
import ro.uaic.info.alk.exeptions.UnexpectedTypeException;
import ro.uaic.info.alk.util.types.Storable;

public class AssertState
   extends SingleState
{
    public AssertState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload, tree.getChild(0));
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();

        if (!(value instanceof AlkBool))
        {
            throw new InvalidStatementException(Statement.ASSERT, new UnexpectedTypeException(
                tree.getChild(0),
                value,
                AlkBool.class
            ));
        }

        if (((AlkBool) value).isFalse())
        {
            throw new InvalidAssertionException(tree.getChild(0));
        }

        return AlkBool.TRUE;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        AssertState copy = new AssertState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

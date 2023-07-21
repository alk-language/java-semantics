package ro.uaic.info.alk.execution.state.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.statement.AssertState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.exeptions.InvalidAssertionException;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class SymbolicAssertState
   extends AssertState
{
    public SymbolicAssertState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();
        if (value instanceof SymbolicValue)
        {
            SymbolicValue symVal = (SymbolicValue) value;

            if (!getExec().getPathCondition().asserts(symVal))
            {
                super.handle(new InvalidAssertionException(tree.getChild(0), symVal));
            }

            return AlkBool.TRUE;
        }

        return super.interpretResult(value);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssertState copy = new SymbolicAssertState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

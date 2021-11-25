package execution.state.symbolic;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.AssertState;
import execution.types.alkBool.AlkBool;
import symbolic.ExclusiveSymbolicValue;
import symbolic.SymbolicValue;
import util.pc.PathCondition;
import util.types.Storable;

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
        if (value instanceof ExclusiveSymbolicValue)
        {
            SymbolicValue symVal = SymbolicValue.toSymbolic(value);

            if (!getExec().getPathCondition().asserts(symVal))
            {
                // this should be UNSAT such that pc -> condition
                throw new AlkException("This symbolic path doesn't imply assertion!");
            }

            return new AlkBool(true);
        }
        else
        {
            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssertState copy = new SymbolicAssertState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

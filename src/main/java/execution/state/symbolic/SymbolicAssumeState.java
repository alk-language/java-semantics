package execution.state.symbolic;

import ast.AST;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.state.statement.AssumeState;
import execution.types.alkBool.AlkBool;
import symbolic.SymbolicValue;
import util.types.Storable;

public class SymbolicAssumeState
extends AssumeState
{
    public SymbolicAssumeState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        value = value.toRValue();
        if (value instanceof SymbolicValue)
        {
            getExec().getPathCondition().add((SymbolicValue) value.clone(generator));
            if (!getExec().getPathCondition().isSatisfiable())
            {
                super.handle(new AlkException("Assumption makes the path condition invalid: " + value));
            }
            return new AlkBool(true);
        }
        else
        {
            if (value instanceof AlkBool)
            {
                if (!((AlkBool) value).isTrue())
                {
                    getExec().halt();
                }
            }
            else
            {
                super.handle(new AlkException("Assume clause is not boolean!"));
            }

            return super.interpretResult(value);
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicAssumeState copy = new SymbolicAssumeState(tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

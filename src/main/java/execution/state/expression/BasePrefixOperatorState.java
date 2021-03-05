package execution.state.expression;

import ast.AST;
import ast.enums.Operator;
import execution.state.ExecutionState;
import execution.state.SingleState;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.types.Storable;

public class BasePrefixOperatorState
extends SingleState
{
    protected final Operator op;

    public BasePrefixOperatorState(Operator op, AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload, tree.getChild(0));
        this.op = op;
    }

    @Override
    protected Storable interpretResult(Storable value)
    {
        Storable result = value;

        if (result.toRValue() == null)
        {
            super.handle(new AlkException("Undefined variable used in prefix expression."));
        }
        switch (op)
        {
            case PLUSPLUSLEFT:
                result = ((AlkValue) result.toRValue()).plusplusleft(); break; // valoare concreta
            case MINUSMINUSLEFT:
                result = ((AlkValue) result.toRValue()).minusminusleft(); break; // valoare concreta
            default:
                throw new InternalException("Unknown prefix operator used.");
        }

        return result;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BasePrefixOperatorState copy = new BasePrefixOperatorState(op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

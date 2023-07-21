package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.SingleState;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.Storable;

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

        Location loc = result.toLValue();

        switch (op)
        {
            case PLUSPLUSLEFT:
                result = ((AlkValue) result.toRValue()).add(AlkInt.ONE, generator); break; // valoare concreta
            case MINUSMINUSLEFT:
                result = ((AlkValue) result.toRValue()).subtract(AlkInt.ONE); break; // valoare concreta
            default:
                throw new InternalException("Unknown prefix operator used.");
        }

        loc.setValue(result);
        return loc;
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        BasePrefixOperatorState copy = new BasePrefixOperatorState(op, tree, payload.clone(sm));
        return super.decorate(copy, sm);
    }
}

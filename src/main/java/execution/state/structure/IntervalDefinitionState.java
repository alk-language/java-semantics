package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.types.IntervalValue;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_LIMIT;
import static parser.exceptions.AlkException.ERR_NOINT_INTERVAL;

@CtxState(ctxClass = alkParser.IntervalDefinitionContext.class)
public class IntervalDefinitionState extends GeneratorState<IntervalValue, Value>
{

    private List<AlkValue> limits = new ArrayList<>();

    public IntervalDefinitionState(alkParser.IntervalDefinitionContext tree, Payload payload) {
        super(tree, payload, tree.expression(), ExpressionVisitor.class);
    }

    @Override
    public void assign(ExecutionResult<Value> result) {
        limits.add((AlkValue) result.getValue().toRValue());
    }

    @Override
    public IntervalValue getFinalResult() {
        AlkValue x = limits.get(0);
        AlkValue y = limits.get(1);

        if (!(x instanceof AlkInt && y instanceof AlkInt))
            throw new AlkException(ERR_NOINT_INTERVAL);

        if ((x.greater(y)).getValue())
            throw new AlkException(ERR_LIMIT);

        return new IntervalValue((AlkInt) x, (AlkInt) y);
    }

    @Override
    public ExecutionState clone(Payload payload) {
        IntervalDefinitionState copy = new IntervalDefinitionState((alkParser.IntervalDefinitionContext) tree, payload);
        for (AlkValue value : limits)
        {
            copy.limits.add(value.clone(generator));
        }
        return super.decorate(copy);
    }

}
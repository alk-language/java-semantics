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
import util.SplitMapper;
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
            super.handle(new AlkException(ERR_NOINT_INTERVAL));

        if ((x.greater(y)).getValue())
            super.handle(new AlkException(ERR_LIMIT));

        return new IntervalValue((AlkInt) x, (AlkInt) y);
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        IntervalDefinitionState copy = new IntervalDefinitionState((alkParser.IntervalDefinitionContext) tree, sm.getPayload());
        for (AlkValue value : limits)
        {
            copy.limits.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }

}
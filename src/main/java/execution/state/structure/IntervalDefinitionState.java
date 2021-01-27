package execution.state.structure;

import ast.AST;
import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.IntervalValue;

import java.util.ArrayList;
import java.util.List;

import static execution.parser.exceptions.AlkException.ERR_LIMIT;
import static execution.parser.exceptions.AlkException.ERR_NOINT_INTERVAL;

@CtxState(ctxClass = alkParser.IntervalDefinitionContext.class)
public class IntervalDefinitionState extends GeneratorState
{
    private final List<AlkValue> limits = new ArrayList<>();

    public IntervalDefinitionState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        limits.add((AlkValue) executionResult.getValue().toRValue());
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
        IntervalDefinitionState copy = new IntervalDefinitionState(tree, payload.clone(sm));
        for (AlkValue value : limits)
        {
            copy.limits.add(value.weakClone(sm.getLocationMapper()));
        }
        return super.decorate(copy, sm);
    }

}
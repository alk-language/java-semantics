package execution.state.structure;

import execution.ExecutionResult;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.DataStructureVisitor;
import util.types.IntervalValue;

import java.util.ArrayList;
import java.util.List;

import static parser.exceptions.AlkException.ERR_LIMIT;
import static parser.exceptions.AlkException.ERR_NOINT_INTERVAL;

public class IntervalDefinitionState extends GeneratorState<IntervalValue, AlkValue>
{

    private List<AlkValue> limits = new ArrayList<>();

    public IntervalDefinitionState(alkParser.IntervalDefinitionContext tree, DataStructureVisitor visitor) {
        super(tree, new ExpressionVisitor(visitor.getEnvironment()), tree.expression());
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        limits.add(result.getValue());
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
}
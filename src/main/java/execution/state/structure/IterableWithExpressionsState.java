package execution.state.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.types.AlkIterableValue;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.CtxState;
import util.Payload;
import util.exception.InternalException;

import java.util.ArrayList;
import java.util.List;

public class IterableWithExpressionsState extends GeneratorState<AlkIterableValue, AlkValue>
{
    private ArrayList<AlkValue> array = new ArrayList<>();
    private Class<? extends AlkIterableValue> clazz;

    public IterableWithExpressionsState(ParseTree tree,
                                        Payload payload,
                                        List<? extends ParseTree> dependency,
                                        Class<? extends AlkIterableValue> clazz) {
        super(tree, payload, dependency, ExpressionVisitor.class);
        this.clazz = clazz;
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        array.add(result.getValue());
    }

    @Override
    public AlkIterableValue getFinalResult() {
        try {
            AlkIterableValue iterableVal = clazz.newInstance();
            iterableVal.addAll(array);
            return iterableVal;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new InternalException(e);
        }
    }

    @Override
    public ExecutionState clone(Payload payload) {
        IterableWithExpressionsState copy = new IterableWithExpressionsState(tree, payload, null, clazz);

        for (AlkValue value : array)
        {
            copy.array.add(value.clone());
        }

        return super.decorate(copy);
    }
}
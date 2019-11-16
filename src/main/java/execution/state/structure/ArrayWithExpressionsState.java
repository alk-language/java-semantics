package execution.state.structure;

import execution.ExecutionResult;
import execution.state.GeneratorState;
import grammar.alkParser;
import parser.types.AlkValue;
import parser.types.alkArray.AlkArray;
import parser.visitors.expression.ExpressionVisitor;
import parser.visitors.structure.ArrayVisitor;

public class ArrayWithExpressionsState extends GeneratorState<AlkArray, AlkValue>
{
    private AlkArray array = new AlkArray();

    public ArrayWithExpressionsState(alkParser.ArrayWithExpressionsContext tree, ArrayVisitor visitor) {
        super(tree, new ExpressionVisitor(visitor.getEnvironment()), tree.expression());
    }

    @Override
    public void assign(ExecutionResult<AlkValue> result) {
        array.push(result.getValue());
    }

    @Override
    public AlkArray getFinalResult() {
        return array;
    }
}
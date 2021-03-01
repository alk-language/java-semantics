import util.TestingConfiguration;
import symbolic.SymbolicExpressionEvaluator;

public class SymbolicTesting extends Testing
{
    @Override
    String run(String chapter, String input, int precision)
    {
        TestingConfiguration config = new TestingConfiguration("tests/input/" + chapter + "/" + input + ".alk", precision);
        SymbolicExpressionEvaluator eval = new SymbolicExpressionEvaluator(config);
        eval.run();
        return config.getOutput();
    }
}

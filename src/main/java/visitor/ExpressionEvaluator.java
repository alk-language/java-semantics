package visitor;

import ast.AST;
import execution.parser.AlkParser;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.Store;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import execution.types.BaseValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Configuration;
import util.types.Value;

import java.io.File;

public class ExpressionEvaluator
{
    Configuration config;

    public ExpressionEvaluator(Configuration config)
    {
        this.config = config;
    }

    public void run()
    {
        File file = config.getAlkFile();
        ParseTree parseTreeRoot = AlkParser.execute(file, true);
        if (!(parseTreeRoot instanceof alkParser.ExpressionContext))
        {
            throw new AlkException("Invalid expression!");
        }

        AST root = new ParseTreeExprVisitor().visit(parseTreeRoot);

        StoreImpl store = new StoreImpl();
        Environment env = new EnvironmentImpl(store);

        ExpressionInterpreter<BaseValue> interpreter = new BasicExpressionInterpreter(env, store);
        ExpressionVisitor<BaseValue> visitor = new ExpressionVisitor<>(interpreter);

        Value value = root.accept(visitor).toRValue();
        config.getIOManager().write(value.toString());
    }
}

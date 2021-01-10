package visitor;

import ast.AST;
import execution.parser.AlkParser;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import symbolic.SymbolicValueIface;
import util.Configuration;

import java.io.File;

public class SymbolicExpressionEvaluator {

    Configuration config;

    public SymbolicExpressionEvaluator(Configuration config)
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

        ExpressionInterpreter<SymbolicValueIface> interpreter = new SymbolicExpressionInterpreter(env, store);
        ExpressionVisitor<SymbolicValueIface> visitor = new ExpressionVisitor<>(interpreter);

        SymbolicValueIface value = root.accept(visitor);
        config.getIOManager().write(value.toString());
    }

}

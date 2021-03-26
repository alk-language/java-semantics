package main;

import ast.AST;
import execution.parser.AlkParser;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import execution.types.ConcreteValue;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ParseTreeExprVisitor;
import util.Configuration;
import util.types.Storable;
import visitor.SmallStepExpressionVisitor;
import visitor.interpreter.base.BaseExpressionInterpreter;
import visitor.interpreter.SmallStepExpressionInterpreter;

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

        SmallStepExpressionInterpreter<ConcreteValue> interpreter = new BaseExpressionInterpreter(env, store);
        SmallStepExpressionVisitor<ConcreteValue> visitor = new SmallStepExpressionVisitor<>(interpreter);

        Storable value = root.accept(visitor).toRValue();
        config.getIOManager().write(value.toString());
    }
}

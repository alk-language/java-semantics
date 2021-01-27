package main;

import ast.AST;
import execution.parser.AlkParser;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ParseTreeExprVisitor;
import symbolic.SymbolicValueIface;
import util.Configuration;
import visitor.SmallStepExpressionVisitor;
import visitor.SymbolicExpressionInterpreter;
import visitor.interpreter.SmallStepExpressionInterpreter;

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

        SmallStepExpressionInterpreter<SymbolicValueIface> interpreter = new SymbolicExpressionInterpreter(env, store);
        SmallStepExpressionVisitor<SymbolicValueIface> visitor = new SmallStepExpressionVisitor<>(interpreter);

        SymbolicValueIface value = root.accept(visitor);
        config.getIOManager().write(value.toString());
    }

}

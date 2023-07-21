package ro.uaic.info.alk.main;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.EnvironmentImpl;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.ConcreteValue;
import org.antlr.v4.runtime.tree.ParseTree;
import ro.uaic.info.alk.parser.AlkParser;
import ro.uaic.info.alk.parser.AlkParseTreeExprVisitor;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.SmallStepExpressionVisitor;
import ro.uaic.info.alk.visitor.interpreter.BaseExpressionInterpreter;
import ro.uaic.info.alk.visitor.interpreter.SmallStepExpressionInterpreter;

import java.io.File;

public class ExpressionEvaluator
{
    AlkConfiguration config;

    public ExpressionEvaluator(AlkConfiguration config)
    {
        this.config = config;
    }

    public void run()
    {
        File file = config.getAlkFile();
        ParseTree parseTreeRoot = SimpleAlkParser.execute(file, true);
        if (!(parseTreeRoot instanceof AlkParser.ExpressionContext))
        {
            throw new AlkException("Invalid expression!");
        }

        AST root = new AlkParseTreeExprVisitor().visit(parseTreeRoot);

        StoreImpl store = new StoreImpl();
        Environment env = new EnvironmentImpl(store);

        SmallStepExpressionInterpreter<ConcreteValue> interpreter = new BaseExpressionInterpreter(env, store);
        SmallStepExpressionVisitor<ConcreteValue> visitor = new SmallStepExpressionVisitor<>(interpreter);

        Storable value = root.accept(visitor).toRValue();
        config.getIOManager().write(value.toString());
    }
}

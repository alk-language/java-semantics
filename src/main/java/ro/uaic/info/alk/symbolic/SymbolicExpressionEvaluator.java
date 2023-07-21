package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.StatefulStack;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionInterpreter;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulStmtInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulExpressionInterpreter;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.main.Master;
import org.antlr.v4.runtime.tree.ParseTree;
import ro.uaic.info.alk.parser.AlkParser;
import ro.uaic.info.alk.parser.AlkParseTreeExprVisitor;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.types.Storable;

import java.io.File;

public class SymbolicExpressionEvaluator
implements Master
{
    AlkConfiguration config;

    AlkExecution exec;

    public SymbolicExpressionEvaluator(AlkConfiguration config)
    {
        ExecutionInterpreter manager = new ExecutionInterpreter(new SymbolicStatefulExpressionInterpreter(),
                                                                new BaseStatefulStmtInterpreter());

        this.config = config;
        this.exec = new AlkExecution(config, manager);
    }

    public void run()
    {
        if (config.hasInput())
        {
//            InputHelper.readInitial(config, exec.getGlobal(), exec.getInterpreterManager());
        }

        File file = config.getAlkFile();
        ParseTree parseTreeRoot = SimpleAlkParser.execute(file, true);
        if (!(parseTreeRoot instanceof AlkParser.ExpressionContext))
        {
            throw new AlkException("Invalid expression!");
        }

        AST root = new AlkParseTreeExprVisitor().visit(parseTreeRoot);


        ExecutionPayload payload = new ExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreter().interpret(root, payload);
        StatefulStack<ExecutionState, ExecutionResult> stack = new StatefulStack<>(config);
        stack.push(state);
        Result<?> result = stack.run();
        Storable value = (Storable) result.getValue();

        if (config.hasMetadata())
        {
            config.getIOManager().write(exec.getGlobal().toString());
        }
    }

}

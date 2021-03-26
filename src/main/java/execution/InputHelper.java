package execution;

import ast.AST;
import ast.ASTStack;
import execution.interpreter.BaseStatefulExpressionInterpreter;
import execution.interpreter.BaseStatefulStmtInterpreter;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.parser.AlkParser;
import execution.parser.env.Environment;
import execution.parser.env.Store;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ParseTreeGlobals;
import state.Result;
import util.Configuration;
import util.types.Storable;
import visitor.stateful.StatefulInterpreterManager;

public class InputHelper
{
    public static void readInitial(Configuration config,
                                   Environment env,
                                   StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        String input = config.getInput();
        alkParser.ConfigContext tree = (alkParser.ConfigContext) AlkParser.executeInit(input);
        if (tree == null)
        {
            throw new AlkException("Syntax error in initial configuration!");
        }

        for (int i = 0; i < tree.ID().size(); i++)
        {
            String id = tree.ID(i).getText();
            ParseTree expr = tree.expression(i);
            AST exprAST = ParseTreeGlobals.getParseExprVisitor().visit(expr);
            env.update(id, evaluateExpression(config, exprAST, manager));
        }
    }
    public static Storable evaluateExpression(Configuration config,
                                              AST root,
                                              StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        Execution exec = new Execution(config, manager);
        ExecutionPayload payload = new ExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreterManager().interpret(root, payload);
        ASTStack<ExecutionState> stack = new ASTStack<>(config);
        stack.push(state);
        Result<?> result = stack.run();
        return ((Storable) result.getValue()).toRValue();
    }
}

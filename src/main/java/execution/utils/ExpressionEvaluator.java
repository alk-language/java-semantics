package execution.utils;

import ast.AST;
import ast.ASTStack;
import execution.Execution;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.parser.env.Environment;
import execution.parser.env.StoreImpl;
import execution.state.ExecutionState;
import state.Result;
import util.types.Storable;
import visitor.stateful.StatefulInterpreterManager;

public class ExpressionEvaluator
{
    public static Storable evaluate(AST root,
                                    Environment env,
                                    StoreImpl store,
                                    StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        Execution exec = new Execution(null, manager);
        exec.setStore(store);
        exec.setGlobal(env);

        ExecutionPayload payload = new ExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreterManager().interpret(root, payload);
        ASTStack<ExecutionState> stack = new ASTStack<>(null);
        stack.push(state);
        Result<?> result = stack.run();
        return (Storable) result.getValue();
    }
}

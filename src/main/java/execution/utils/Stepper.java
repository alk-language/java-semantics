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
import symbolic.SymbolicExecutionPayload;
import util.Configuration;
import util.pc.PathCondition;
import util.types.Storable;
import visitor.stateful.StatefulInterpreterManager;

public class Stepper
{
    public static final Configuration dummyConfig = new Configuration();

    public static Storable run(AST root,
                               Environment env,
                               StoreImpl store,
                               PathCondition pathCondition,
                               StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        Execution exec = new Execution(dummyConfig, manager);
        exec.setStore(store);
        exec.setGlobal(env);
        exec.setPathCondition(pathCondition == null ? new PathCondition() : pathCondition);

        SymbolicExecutionPayload payload = new SymbolicExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreterManager().interpret(root, payload);
        ASTStack<ExecutionState> stack = new ASTStack<>(null);
        stack.push(state);
        Result<?> value = stack.run();
        return value != null ? (Storable) value.getValue() : null;
    }
}

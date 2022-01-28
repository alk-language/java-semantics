package execution.utils;

import ast.AST;
import ast.ASTStack;
import execution.*;
import execution.parser.env.Environment;
import execution.parser.env.StoreImpl;
import execution.state.ExecutionState;
import state.Result;
import symbolic.SymbolicExecutionPayload;
import util.Configuration;
import util.FuncManager;
import util.pc.PathCondition;
import util.types.Storable;
import visitor.stateful.StatefulInterpreterManager;

import java.util.List;

public class Stepper
{
    public static Storable run(AST root,
                               Configuration config,
                               Environment env,
                               StoreImpl store,
                               PathCondition pathCondition,
                               FuncManager funcManager,
                               StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        Execution exec = new Execution(config, manager);
        exec.setStore(store);
        exec.setGlobal(env);
        exec.setFuncManager(funcManager);
        exec.setPathCondition(pathCondition == null ? new PathCondition() : pathCondition);

        SymbolicExecutionPayload payload = new SymbolicExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreterManager().interpret(root, payload);
        ASTStack<ExecutionState> stack = new ASTStack<>(null);
        stack.push(state);
        Result<?> value = stack.run();
        return value != null ? (Storable) value.getValue() : null;
    }

    public static List<ExecutionOutput> runBatch(AST root,
                                                 Configuration config,
                                                 Environment env,
                                                 StoreImpl store,
                                                 PathCondition pathCondition,
                                                 FuncManager funcManager,
                                                 StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        ExecutionPool pool = new ExecutionPool();
        Execution exec = pool.createExecution(config, manager);
        exec.setStore(store);
        exec.setGlobal(env);
        exec.setFuncManager(funcManager);
        exec.setPathCondition(pathCondition == null ? new PathCondition() : pathCondition);

        SymbolicExecutionPayload payload = new SymbolicExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreterManager().interpret(root, payload);
        ExecutionStack stack = new ExecutionStack(exec);
        stack.push(state);
        exec.setStack(stack);
        return pool.runAll();
    }
}

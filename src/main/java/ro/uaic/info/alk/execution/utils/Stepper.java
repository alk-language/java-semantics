package ro.uaic.info.alk.execution.utils;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.StatefulStack;
import ro.uaic.info.alk.execution.*;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.symbolic.SymbolicExecutionPayload;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.FuncManager;
import ro.uaic.info.alk.util.pc.PathCondition;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class Stepper
{
    public static Storable run(AST root, AlkExecution exec)
    {
        SymbolicExecutionPayload payload = new SymbolicExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreter().interpret(root, payload);
        StatefulStack<ExecutionState, ExecutionResult> stack = new StatefulStack<>(null);
        stack.push(state);
        Result<?> value = stack.run();
        return value != null ? (Storable) value.getValue() : null;
    }

    public static Storable run(AST root,
                               AlkConfiguration config,
                               Environment env,
                               StoreImpl store,
                               PathCondition pathCondition,
                               FuncManager funcManager,
                               ExecutionInterpreter manager)
    {
        AlkExecution exec = new AlkExecution(config, manager);
        exec.setStore(store);
        exec.setGlobal(env);
        exec.setFuncManager(funcManager);
        exec.setPathCondition(pathCondition == null ? new PathCondition(config.hasProver()) : pathCondition);

        return run(root, exec);
    }

    public static List<ExecutionOutput> runBatch(AST root,
                                                 AlkConfiguration config,
                                                 Environment env,
                                                 StoreImpl store,
                                                 PathCondition pathCondition,
                                                 FuncManager funcManager,
                                                 ExecutionInterpreter manager)
    {
        ExecutionPool pool = new ExecutionPool();
        AlkExecution exec = pool.createExecution(config, manager);
        exec.setStore(store);
        exec.setGlobal(env);
        exec.setFuncManager(funcManager);
        exec.setPathCondition(pathCondition == null ? new PathCondition(config.hasProver()) : pathCondition);

        SymbolicExecutionPayload payload = new SymbolicExecutionPayload(exec, exec.getGlobal());
        ExecutionState state = exec.getInterpreter().interpret(root, payload);
        ExecutionStack stack = new ExecutionStack(exec);
        stack.push(state);
        exec.setStack(stack);
        return pool.runAll();
    }
}

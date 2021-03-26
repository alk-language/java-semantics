package dataflow.domain;

import ast.AST;
import control.extractor.VarsBulkExtractor;
import dataflow.Domain;
import execution.BaseStatefulInterpreterManager;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.interpreter.BaseStatefulStmtInterpreter;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.parser.env.*;
import execution.state.ExecutionState;
import execution.utils.ExpressionEvaluator;
import symbolic.SymbolicValue;
import util.PathCondition;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProgramContext
implements Domain
{
    private final List<ExecutionPath> paths = new ArrayList<>();

    public ProgramContext()
    {
    }

    public ProgramContext(ProgramContext ctx)
    {
        for (ExecutionPath path : ctx.paths)
        {
            this.paths.add(new ExecutionPath(path));
        }
    }

    public static ProgramContext getInitialContext()
    {
        ProgramContext ctx = new ProgramContext();
        StoreImpl store = new StoreImpl();
        ctx.addExecutionPath(new ExecutionPath(store, new EnvironmentImpl(store), new PathCondition()));
        return ctx;
    }

    public static ProgramContext getEmptyContext()
    {
        return new ProgramContext();
    }

    public void addExecutionPath(ExecutionPath executionPath)
    {
        this.paths.add(executionPath);
    }

    public void union(ProgramContext ctx)
    {
        this.paths.addAll(ctx.paths);
    }

    public void notifyExpr(AST tree)
    {
        for (ExecutionPath path : paths)
        {
            path.notifyExpr(tree);
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("\n");
        for (ExecutionPath path : paths)
        {
            sb.append(path.toString()).append("\n");
        }
        return sb.toString();
    }
}

class ExecutionPath
{
    private final StoreImpl store;
    private final Environment env;
    private final PathCondition pc;

    public ExecutionPath(StoreImpl store, EnvironmentImpl env, PathCondition pc)
    {
        this.store = store;
        this.env = env;
        this.pc = pc;
    }

    public ExecutionPath(ExecutionPath path)
    {
        this.store = new StoreImpl();

        LocationMapper locMapping = new LocationMapper();
        Set<Location> sourceLocations = path.store.getLocations();

        for (Location loc : sourceLocations)
        {
            Location newLoc = this.store.malloc();
            locMapping.put(loc, newLoc);
        }

        for (Location loc : sourceLocations)
        {
            Storable value = loc.getValue();
            Storable copyValue = value.weakClone(locMapping);
            this.store.set(locMapping.get(loc), copyValue);
        }

        this.env = path.env.makeClone(locMapping, store);
        this.pc = path.pc.makeClone();
    }

    public void notifyExpr(AST tree)
    {
        BaseStatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager =
                new BaseStatefulInterpreterManager<>(new SymbolicStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        ExpressionEvaluator.evaluate(tree, env, store, manager);
    }

    public String toString()
    {
        return "{\n" + "Environment:\n" +
                env.toString() +
                "\n" +
                "Path Condition:\n" +
                pc.toString() +
                "\n}";
    }
}

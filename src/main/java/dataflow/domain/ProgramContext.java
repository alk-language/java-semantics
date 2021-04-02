package dataflow.domain;

import ast.AST;
import ast.enums.Operator;
import ast.expr.UnaryAST;
import control.EdgeData;
import dataflow.Domain;
import execution.BaseStatefulInterpreterManager;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.interpreter.SymbolicStatefulStmtInterpreter;
import execution.parser.env.*;
import execution.state.ExecutionState;
import execution.utils.Stepper;
import symbolic.SymbolicValue;
import util.PathCondition;
import util.exception.InternalException;
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

    public void run(AST tree, EdgeData data)
    {
        for (ExecutionPath path : paths)
        {
            path.run(tree, data);
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

    public void run(AST tree, EdgeData data)
    {
        BaseStatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager =
                new BaseStatefulInterpreterManager<>(new SymbolicStatefulExpressionInterpreter(), new SymbolicStatefulStmtInterpreter());
        Storable value = Stepper.run(tree, env, store, this.pc, manager);
        if (data != null)
        {
            if (data.getCondition())
            {
                this.pc.add(SymbolicValue.toSymbolic(value));
            }
            else
            {
                SymbolicValue symVal = SymbolicValue.toSymbolic(value);
                if (symVal == null)
                {
                    throw new InternalException("Unexpected error while symbolically evaluating a basic block!");
                }
                AST negatedAst = UnaryAST.createUnary(Operator.NOT, symVal.toAST());
                this.pc.add(new SymbolicValue(negatedAst));
            }
        }
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

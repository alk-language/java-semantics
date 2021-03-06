package execution;

import ast.AST;
import ast.attr.OpsASTAttr;
import execution.exhaustive.EnvironmentMapper;
import execution.interpreter.BaseStatefulExpressionInterpreter;
import execution.interpreter.BaseStatefulStmtInterpreter;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.parser.env.LocationMapper;
import execution.state.ExecutionState;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.cli.HelpFormatter;
import execution.parser.AlkParser;
import execution.parser.constants.Constants;
import execution.parser.env.Environment;
import execution.parser.env.EnvironmentImpl;
import execution.parser.env.StoreImpl;
import execution.parser.exceptions.AlkException;
import parser.ParseTreeGlobals;
import util.*;
import util.exception.InternalException;
import visitor.SmallStepExpressionVisitor;
import visitor.interpreter.base.BaseExpressionInterpreter;
import visitor.stateful.StatefulExpressionInterpreter;
import visitor.stateful.StatefulInterpreterManager;
import visitor.stateful.StatefulStmtInterpreter;

import java.io.File;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/**
 * The main class responsible for one alk file execution. It is implemented
 * under a thread paradigm to parallelize multiple file interpreting if needed.
 * It also wraps the data necessary for one execution only.
 */
public class Execution
extends Thread
{
    /** The main configuration delivery instance. */
    public final Configuration config;

    /** The main store associated with this execution. */
    private StoreImpl store;

    /** The main code stack associated with this execution. */
    private ExecutionStack stack;

    /** The global environment for the execution. */
    private Environment global;

    /** A manager responsible for internal functions / procedures. */
    private FuncManager funcManager;

    private final Map<Environment, Boolean> envs = new IdentityHashMap<>();

    private final ConditionPath conditionPath;

    private final StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> interpreterManager;

    // -> foloseste interpretorul clasic de instructiuni + expresii
    // -> foloseste interpretorul simbolic de instructiuni + expresii

    /**
     * Constructor with specific configuration
     *
     * @param config
     * The configuration meant to be used for this execution
     */
    public Execution(Configuration config,
                     StatefulExpressionInterpreter<ExecutionPayload, ExecutionState> expressionInterpreter,
                     StatefulStmtInterpreter<ExecutionPayload, ExecutionState> stmtInterpreter)
    {
        this(config, new BaseStatefulInterpreterManager<>(expressionInterpreter, stmtInterpreter));
    }


    public Execution(Configuration config,
                     StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        this.config = config;
        store = new StoreImpl();
        global = new EnvironmentImpl(store);
        this.registerEnv(global);
        funcManager = new FuncManager();
        interpreterManager = manager;
        conditionPath = new ConditionPath();
    }

    private boolean initialize()
    {
        if (config.hasVersion())
        {
            config.getIOManager().write("The version is " + Constants.VERSION + ".");
            return false;
        }

        if (config.getAlkFile() == null || config.hasHelp())
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "alk", config.getOptions());
            return false;
        }

        if (config.hasPrecision())
        {
            Constants.MAX_DECIMALS = config.getPrecision() + 1;
        }

        if (config.hasInput())
        {
            InputHelper.readInitial(config, global, interpreterManager);
        }

        return true;
    }

    /**
     * The main method which fires the parsing
     */
    private void execute()
    {
        if (stack == null)
        {
            if (!initialize())
                return;

            File file = config.getAlkFile();
            ParseTree tree = AlkParser.execute(file);
            if (tree == null)
            {
                throw new AlkException("Syntax error!");
            }
            AST root = ParseTreeGlobals.PARSE_TREE_VISITOR.visit(tree);
            if (root != null)
            {
                ExecutionPayload payload = new ExecutionPayload(this, global);
                ExecutionState state = interpreterManager.interpret(root, payload);
                stack = new ExecutionStack(this);
                stack.push(state);
            }
        }

        stack.run();

        // if the metadata flag is set, print the global environment
        if (config.hasMetadata())
        {
            config.getIOManager().write(global.toString());
            config.getIOManager().write("Condition path: " + conditionPath.toString());
            config.getIOManager().write("");
        }

        if (config.nonDeterministic())
        {
            config.getIOManager().write("Note that the executed algorithm is nondeterministic.");
        }

        if (config.isProbabilistic())
        {
            config.getIOManager().write("Note that the executed algorithm is probabilistic.");
            config.getIOManager().write("The probability for this execution is: " + config.getProbability());
        }
    }

    /**
     * The entry point for the thread
     */
    @Override
    public void run()
    {
        try
        {
            execute();
        }
        catch (AlkException e)
        {
            ErrorManager em = config.getErrorManager();
            em.handleError(e);
            if (((OptionProvider) config).hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
        catch (InternalException e)
        {
            if (((OptionProvider) config).hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
        finally
        {
            config.getIOManager().flush();
        }
    }


    public Execution clone()
    {
        return ExecutionCloner.makeClone(this);
    }

    public Configuration getConfiguration()
    {
        return config;
    }

    public FuncManager getFuncManager()
    {
        return funcManager;
    }

    public Configuration getConfig()
    {
        return config;
    }

    public ExecutionStack getStack()
    {
        return stack;
    }

    public Environment getGlobal()
    {
        return global;
    }

    public StoreImpl getStore()
    {
        return store;
    }

    public void setStore(StoreImpl store)
    {
        this.store = store;
    }

    public void setGlobal(Environment global)
    {
        deregisterEnv(this.global);
        this.global = global;
        registerEnv(this.global);
    }

    public void setStack(ExecutionStack stack)
    {
        this.stack = stack;
    }

    public void setFuncManager(FuncManager funcManager)
    {
        this.funcManager = funcManager;
    }

    public StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> getInterpreterManager()
    {
        return this.interpreterManager;
    }

    public void deregisterEnv(Environment environment)
    {
        envs.remove(environment);
    }

    public void registerEnv(Environment environment)
    {
        envs.put(environment, true);
    }

    public EnvironmentMapper cloneEnvironments(Execution newExec, LocationMapper locMapping, StoreImpl copyStore)
    {
        EnvironmentMapper mapper = new EnvironmentMapper();
        for (Environment env : envs.keySet())
        {
            Environment clone = env.makeClone(locMapping, copyStore);
            newExec.registerEnv(clone);
            mapper.put(env, clone);
        }
        return mapper;
    }

    public ConditionPath getConditionPath()
    {
        return conditionPath;
    }
}

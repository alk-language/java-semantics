package execution;

import ast.AST;
import ast.ASTHelper;
import ast.attr.IdASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.expr.SymIDAST;
import ast.stmt.FunctionDeclAST;
import ast.type.DataTypeAST;
import execution.exhaustive.EnvironmentMapper;
import execution.helpers.AnnoHelper;
import execution.parser.env.*;
import execution.state.ExecutionCloneContext;
import execution.state.ExecutionState;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.cli.HelpFormatter;
import execution.parser.AlkParser;
import execution.parser.constants.Constants;
import execution.parser.exceptions.AlkException;
import parser.ParseTreeGlobals;
import symbolic.SymbolicValue;
import util.*;
import util.exception.InternalException;
import util.exception.SymbolicallyImposibleException;
import util.functions.Parameter;
import util.pc.PathCondition;
import visitor.stateful.StatefulExpressionInterpreter;
import visitor.stateful.StatefulInterpreterManager;
import visitor.stateful.StatefulStmtInterpreter;

import java.io.File;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

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

    private PathCondition conditionPath;

    private final StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> interpreterManager;

    private AnnoHelper annoHelper;

    private ExecutionPool pool;

    private ExecutionOutput output = new ExecutionOutput();

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
        conditionPath = new PathCondition(config.hasProver());
        annoHelper = new AnnoHelper();
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

        if (config.getConditionPath() != null)
        {
            conditionPath = PathCondition.parse(config.getConditionPath(), config.hasProver());
        }

        return true;
    }

    private void registerFunction(FunctionDeclAST tree)
    {
        String id = tree.getAttribute(IdASTAttr.class).getId();
        ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
        List<Parameter> params = new ArrayList<>();
        List<String> modifies = new ArrayList<>();

        for (int i = 0; i < attr.getParamCount(); i++)
        {
            Parameter param = attr.getParameter(i);
            if (param.getType() == ParamType.GLOBAL)
                modifies.add(param.getName());
            else
                params.add(param);
        }

        AlkFunction function = new AlkFunction(id,
                params,
                modifies,
                tree.getBody(),
                tree.getRequires(),
                tree.getEnsures(),
                tree.getDataType());
        this.getFuncManager().define(function);
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
            if (config.hasStaticVerif())
            {
                List<FunctionDeclAST> fncs = ASTHelper.getFunctions(root);
                for (FunctionDeclAST fnc : fncs)
                {
                    registerFunction(fnc);
                }
                for (AlkFunction fnc : getFuncManager().getFunctions())
                {
                    Symbolic.verifyFunction(fnc, this);
                }
            }
            if (root != null)
            {
                ExecutionPayload payload = new ExecutionPayload(this, global);
                ExecutionState state = interpreterManager.interpret(root, payload);
                stack = new ExecutionStack(this);
                stack.push(state);
            }
        }

        // EXECUTIA ALGORITMULUI ALK
        stack.run();

        // if the metadata flag is set, print the global environment
        if (config.hasMetadata())
        {
            config.getIOManager().write(global.toString());
            config.getIOManager().write(annoHelper.toString());
            if (config.hasStaticVerif())
            {
                config.getIOManager().write("Note that the execution was symbolic.");
                if (conditionPath.verifies())
                {
                    config.getIOManager().write("Note that the " + config.getProver() + " engine was used for verification.");
                }
                config.getIOManager().write("Path condition: \n" + conditionPath.toString(3));
                config.getIOManager().write("Type constraints: ");
                Map<String, DataTypeAST> typesConstraints = conditionPath.getIdTypes(false);
                StringBuilder sb = new StringBuilder();
                for (int j=0; j < 3; j++)
                {
                    sb.append(" ");
                }
                List<String> types = new ArrayList<>();
                for (Map.Entry<String, DataTypeAST> entry : typesConstraints.entrySet())
                {
                    types.add(entry.getKey() + " : " + entry.getValue());
                }
                sb.append(String.join("\n   ", types));
                config.getIOManager().write(sb.toString());
                config.getIOManager().write("");
            }
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
            if (this.pool != null)
            {
                this.pool.incrementActive(this);
            }
            execute();
        }
        catch (AlkException e)
        {
            ErrorManager em = config.getErrorManager();
            em.handleError(e);
            output.hasError = true;
            if (((OptionProvider) config).hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
        catch (SymbolicallyImposibleException ignored)
        {
        }
        catch (InternalException e)
        {
            if (((OptionProvider) config).hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
            output.hasError = true;
            config.getErrorManager().handleError(e);
        }
        catch (Throwable e)
        {
            output.hasError = true;
            if (((OptionProvider) config).hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
        finally
        {
            config.getIOManager().flush();
            if (this.pool != null)
            {
                this.pool.decrementActive(this);
            }
            output.exec = this;
        }
    }


    public ExecutionCloneContext clone()
    {
        return clone(null);
    }

    public ExecutionCloneContext clone(ExecutionPool pool)
    {
        return ExecutionCloner.makeClone(this, pool);
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

    public PathCondition getPathCondition()
    {
        return conditionPath;
    }

    public void setPathCondition(PathCondition pc)
    {
        this.conditionPath = pc;
    }

    public AnnoHelper getAnnoHelper()
    {
        return annoHelper;
    }

    public void halt()
    {
        throw new SymbolicallyImposibleException();
    }

    public void setPool(ExecutionPool pool)
    {
        this.pool = pool;
    }

    public ExecutionPool getPool()
    {
        return pool;
    }

    public ExecutionOutput getOutput()
    {
        return output;
    }
}

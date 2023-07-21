package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTHelper;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.execution.exhaustive.EnvironmentMapper;
import ro.uaic.info.alk.execution.helpers.AnnoHelper;
import ro.uaic.info.alk.execution.utils.Stepper;
import ro.uaic.info.alk.exeptions.*;
import ro.uaic.info.alk.execution.state.ExecutionCloneContext;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.preproc.*;
import ro.uaic.info.alk.types.AlkFloat;
import org.apache.commons.cli.HelpFormatter;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.util.Constants;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.ErrorManager;
import ro.uaic.info.alk.util.FuncManager;
import ro.uaic.info.alk.util.OptionProvider;
import ro.uaic.info.alk.visitor.stateful.ExecutionExprInterpreter;
import ro.uaic.info.alk.visitor.stateful.ExecutionStmtInterpreter;
import ro.uaic.info.alk.util.pc.PathCondition;

import java.io.File;
import java.util.*;

/**
 * The main class responsible for one alk file execution. It is implemented
 * under a thread paradigm to parallelize multiple file interpreting if needed.
 * It also wraps the data necessary for one execution only.
 */
public class AlkExecution
extends Thread
{
    /** The main configuration delivery instance. */
    public final AlkConfiguration config;

    /** The main store associated with this execution. */
    private StoreImpl store;

    /** The main code stack associated with this execution. */
    private ExecutionStack stack;

    /** The global environment for the execution. */
    // TODO: is this actually needed? can we just pass it to the root of the stack?
    private Environment global;

    /** A manager responsible for internal functions / procedures. */
    private FuncManager funcManager;

    private CallStack callStack = new CallStack(this);

    private final Map<Environment, Boolean> envs = new IdentityHashMap<>();

    private PathCondition conditionPath;

    private final ExecutionInterpreter interpreter;

    private final AnnoHelper annoHelper;

    private ExecutionPool pool;

    private ExecutionOutput output = new ExecutionOutput();

    /**
     * Constructor with specific configuration
     *
     * @param config
     * The configuration meant to be used for this execution
     */
    public AlkExecution(AlkConfiguration config,
                        ExecutionExprInterpreter exprInterpreter,
                        ExecutionStmtInterpreter stmtInterpreter)
    {
        this(config, new ExecutionInterpreter(exprInterpreter, stmtInterpreter));
    }


    public AlkExecution(AlkConfiguration config, ExecutionInterpreter manager)
    {
        this.config = config;
        this.interpreter = manager;

        this.store = new StoreImpl();
        this.global = new EnvironmentImpl(store);
        this.conditionPath = new PathCondition(config.hasProver());
        this.funcManager = new FuncManager();
        this.annoHelper = new AnnoHelper();

        this.registerEnv(global);
    }

    private boolean bootstrap()
    {
        if (config.hasVersion())
        {
            config.getIOManager().write(String.format("The version is %d.%d.%d", Constants.MAJOR_VERSION,
                                                      Constants.MINOR_VERSION,
                                                      Constants.PATCH_VERSION));
            return false;
        }

        if (config.getAlkFile() == null || config.hasHelp())
        {
            // TODO: use a custom PrintWriter based on the configured IO Manager
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("alk", config.getOptions());
            return false;
        }

        Integer precision;
        if ((precision = config.getPrecision()) != null)
        {
            AlkFloat.setPrecision(precision);
        }

        String input;
        if ((input = config.getInput()) != null)
        {
            AST tree = new SimpleAlkParser().parseInit(input);
            if (tree == null)
            {
                throw new AlkSyntaxException("Syntax error in the initial configuration: " + input);
            }

            for (int i = 0; i < tree.getChildCount(); i++)
            {
                String id = tree.getChild(i).getAttribute(IdASTAttr.class).getId();
                AST exprAST = tree.getChild(i).getChild(0);
                this.global.update(id, Stepper.run(exprAST, this));
            }
        }

        String inputConditionPath;
        if ((inputConditionPath = config.getConditionPath()) != null)
        {
            this.conditionPath = PathCondition.parse(inputConditionPath, config.hasProver());
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
            if (!bootstrap())
            {
                return;
            }

            File file = config.getAlkFile();
            AST root = new SimpleAlkParser().parse(file);
            if (root == null)
            {
                throw new AlkSyntaxException("Syntax error!");
            }

            root = new AlkPreprocessor().run(root);

            if (config.hasStaticVerif())
            {
                List<FunctionDeclAST> functions = ASTHelper.getFunctions(root, true);
                for (FunctionDeclAST fnc : functions)
                {
                    funcManager.define(AlkFunction.build(fnc));
                }
                for (AlkFunction fnc : getFuncManager().getFunctions())
                {
                    Symbolic.verifyFunction(fnc, this);
                }
            }

            ExecutionPayload payload = new ExecutionPayload(this, global);
            ExecutionState state = interpreter.interpret(root, payload);
            stack = new ExecutionStack(this);
            stack.push(state);
        }

        // ALK ALGORITHM EXECUTION
        if (this.config.isDebugger())
        {
            stack.debug();
        }
        else
        {
            stack.run();
        }

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
        if (this.pool != null)
        {
            this.pool.incrementActive(this);
        }

        try
        {
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
        catch (SymbolicallyImposibleException | AlkDebugTerminateException ignored)
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
            output.exec = this;

            if (this.pool != null)
            {
                this.pool.decrementActive(this);
            }
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

    public AlkConfiguration getConfiguration()
    {
        return config;
    }

    public FuncManager getFuncManager()
    {
        return funcManager;
    }

    public AlkConfiguration getConfig()
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

    public CallStack getCallStack()
    {
        return callStack;
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

    public void setCallStack(CallStack stack)
    {
        this.callStack = stack;
    }

    public ExecutionInterpreter getInterpreter()
    {
        return this.interpreter;
    }

    public void deregisterEnv(Environment environment)
    {
        envs.remove(environment);
    }

    public void registerEnv(Environment environment)
    {
        envs.put(environment, true);
    }

    public EnvironmentMapper cloneEnvironments(AlkExecution newExec, LocationMapper locMapping, StoreImpl copyStore)
    {
        EnvironmentMapper mapper = new EnvironmentMapper();
        for (Environment env : envs.keySet())
        {
            Environment clone = env.clone(locMapping, copyStore);
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

    public void handleUnwind(UnwindException ue)
    {
        // quick fix; needs better handling
        // analysis engine usually has return outside functions
        if (!(ue instanceof ReturnException))
            config.getIOManager().write(ue.getMessage());
        if (ue instanceof FailureException)
        {
            this.output.failure = true;
        }
    }
}

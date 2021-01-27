package execution;

import ast.AST;
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
import visitor.stateful.StatefulInterpreterManager;

import java.io.File;

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

    /** The manager responsible for the environments. */
    private EnvironmentManager envManager;

    /** The global environment for the execution. */
    private Environment global;

    /** A manager responsible for internal functions / procedures. */
    private FuncManager funcManager;

    private StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> interpreterManager;

    // -> foloseste interpretorul clasic de instructiuni + expresii
    // -> foloseste interpretorul simbolic de instructiuni + expresii

    /**
     * Constructor with specific configuration
     *
     * @param config
     * The configuration meant to be used for this execution
     */
    public Execution(Configuration config)
    {
        this.config = config;
        envManager = new EnvironmentManager();
        store = new StoreImpl();
        global = new EnvironmentImpl(store);
        funcManager = new FuncManager();

        // TODO: get custom interpreter through parameter
        BaseStatefulInterpreterManager manager = new BaseStatefulInterpreterManager();
        manager.registerListener(envManager);
        interpreterManager = manager;
    }

    private boolean initialize()
    {
        if (config.getAlkFile() == null || config.hasHelp())
        {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "alk", config.getOptions());
            return false;
        }

        if (config.hasVersion())
        {
            config.getIOManager().write("The version is " + Constants.VERSION + ".");
            return false;
        }

        if (config.hasPrecision())
        {
            Constants.MAX_DECIMALS = config.getPrecision() + 1;
        }

        if (config.hasInput())
        {
            String input = config.getInput();
            alkParser.ConfigContext tree = (alkParser.ConfigContext) AlkParser.executeInit(input);

            for (int i = 0; i < tree.ID().size(); i++)
            {
                String id = tree.ID(i).getText();
                ParseTree expr = tree.expression(i);
                AST exprAST = ParseTreeGlobals.getParseExprVisitor().visit(expr);
                global.update(id, exprAST.accept(new SmallStepExpressionVisitor<>(new BaseExpressionInterpreter(global, store))));
            }
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


    public Execution clone(boolean nullifyLast)
    {
        Execution copy = ExecutionCloner.makeClone(this);
        if (nullifyLast)
        {
            copy.stack.nullifyLast();
        }
        return copy;
    }

    public EnvironmentManager getEnvManager()
    {
        return envManager;
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
        this.global = global;
    }

    public void setEnvManager(EnvironmentManager envManager)
    {
        this.envManager = envManager;
    }

    public void setStack(ExecutionStack stack)
    {
        this.stack = stack;
    }

    public void setFuncManager(FuncManager funcManager)
    {
        this.funcManager = funcManager;
    }

    public void setInterpreterManager(StatefulInterpreterManager interpreterManager)
    {
        this.interpreterManager = interpreterManager;
    }

    public StatefulInterpreterManager getInterpreterManager()
    {
        return this.interpreterManager;
    }
}

package execution;

import execution.state.ExecutionState;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.cli.HelpFormatter;
import parser.AlkParser;
import parser.constants.Constants;
import parser.env.Environment;
import parser.env.EnvironmentImpl;
import parser.env.Store;
import parser.exceptions.AlkException;
import parser.visitors.InitVisitor;
import parser.visitors.MainVisitor;
import util.*;
import util.exception.InternalException;

import java.io.File;

/**
 * The main class responsible for one alk file execution. It is implemented
 * under a thread paradigm to parallelize multiple file interpreting if needed.
 * It also wraps the data necessary for one execution only.
 */
public class Execution extends Thread
{

    private Store store;

    /** The main configuration delivery instance.*/
    private Configuration config;

    private ExecutionStack stack;

    private EnvironmentManager envManager;

    /* The global environment initially empty */
    private Environment global;

    private FuncManager funcManager;

    /**
     * Constructor with specific configuration
     *
     * @param config
     * The configuration meant to be used for this execution
     */
    public Execution(Configuration config) {
        this.config = config;
        envManager = new EnvironmentManager();
        store = new Store();
        global = new EnvironmentImpl(store);
        funcManager = new FuncManager();
    }

    private boolean initialSetup()
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
            try {
                String input = config.getInput();
                ParseTree tree = AlkParser.executeInit(input);

                ExecutionStack localStack = new ExecutionStack(config, envManager);
                InitVisitor visitor = new InitVisitor(global, new Payload(this));
                ExecutionState state =  visitor.visit(tree);
                localStack.push(state);
                localStack.run();
            }
            catch (Throwable e)
            {
                throw new AlkException("Invalid input syntax. (try not using spaces)");
            }
        }
        return true;
    }

    /**
     * The main method which fires the parsing
     *
     * @throws InternalException
     * An AlkException provided by the execution, or a wrapped non-runtime exception
     */
    private void execute() throws InternalException
    {
        if (stack == null)
        {
            if (!initialSetup())
                return;

            // get the main algorithm file and obtain the CharStream in order to be parsed
            File file = config.getAlkFile();

            ParseTree tree = AlkParser.execute(file);
            MainVisitor visitor = new MainVisitor(global, new Payload(this));
            ExecutionState state = visitor.visit(tree);
            stack = new ExecutionStack(config, envManager);
            stack.push(state);
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
            OptionProvider op = config;
            if (op.hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
        catch (InternalException e)
        {
            OptionProvider op = config;
            if (op.hasDebugMode())
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

    public EnvironmentManager getEnvManager() {
        return envManager;
    }

    public Configuration getConfiguration() {
        return config;
    }

    public FuncManager getFuncManager() {
        return funcManager;
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

    Configuration getConfig() {
        return config;
    }

    ExecutionStack getStack() {
        return stack;
    }

    public Environment getGlobal() {
        return global;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void setGlobal(Environment global) {
        this.global = global;
    }

    void setEnvManager(EnvironmentManager envManager) {
        this.envManager = envManager;
    }

    void setStack(ExecutionStack stack) {
        this.stack = stack;
    }

    void setFuncManager(FuncManager funcManager)
    {
        this.funcManager = funcManager;
    }
}

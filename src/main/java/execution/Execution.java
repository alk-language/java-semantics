package execution;

import execution.state.ExecutionState;
import parser.AlkParser;
import parser.env.Environment;
import parser.env.Store;
import util.EnvironmentManager;
import util.exception.InternalException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
        global = new Environment(store);
    }

    /**
     * The main method which fires the parsing
     *
     * @throws InternalException
     * An AlkException provided by the execution, or a wrapped non-runtime exception
     */
    private void execute() throws InternalException
    {
        ErrorManager em = config.getErrorManager();

        // get the main algorithm file and obtain the CharStream in order to be parsed
        File file = config.getAlkFile();
        CharStream alkFile = null;
        try
        {
            InputStream alkInStr = new FileInputStream(file);
            alkFile = CharStreams.fromStream(alkInStr);
        }
        catch (IOException e)
        {
            em.handleError(e, file.getPath());
        }

        /*
            execute preprocessing part
            TODO: rework preprocessing, move it to the parsing stage
         */
        /*PreProcessing pre = null;
        try
        {
            pre = new PreProcessing(file, new ArrayList<>());
        }
        catch (AlkException ex)
        {
            em.handleError(ex);
        }
        pre.execute(e, true);*/

        /*
            start parsing
            TODO: call different constructor without predefined environment
         */
        AlkParser parser = new AlkParser(alkFile, global, this);
        if (stack == null)
        {
            ExecutionState state = parser.execute(config);
            stack = new ExecutionStack(config);
            stack.push(state);
        }
        stack.run();

        // debugging
        // System.out.println("Result: " + stack.getResult());

        /* AlkParser parser = new AlkParser(alkFile, e);
        parser.execute(config); */



        // if the metadata flag is set, print the global environment
        if (config.hasMetadata())
        {
            config.getIOManager().write(global.toString());
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
        catch (InternalException e)
        {
            OptionProvider op = config;
            if (op.hasDebugMode())
            {
                // TODO: make use of em
                e.printStackTrace();
            }
        }
    }

    public EnvironmentManager getEnvManager() {
        return envManager;
    }

    public Configuration getConfiguration() {
        return config;
    }

    public Execution clone(boolean nullifyLast)
    {
        ExecutionCloner cloner = new ExecutionCloner(this);
        Execution copy = cloner.execute();
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

    void setConfig(Configuration config) {
        this.config = config;
    }

    public void setGlobal(Environment global) {
        this.global = global;
    }

    void setEnvManager(EnvironmentManager envManager) {
        this.envManager = envManager;
    }

    public void setStack(ExecutionStack stack) {
        this.stack = stack;
    }
}

class ExecutionCloner {

    private Execution source;
    private Execution copy;
    private Store copyStore;
    private Map<ExecutionState, ExecutionState> stateMapping;
    private Map<Environment, Environment> envMapping;

    ExecutionCloner(Execution exec)
    {
        source = exec;
        copyStore = source.getStore().makeClone();
        copy = new Execution(exec.getConfig());
        envMapping = source.getEnvManager().cloneEnvironments(copyStore);
        stateMapping = source.getStack().cloneStates(copy);
    }

    Execution execute() {

        Configuration config = source.getConfig();

        ExecutionStack stack = source.getStack().makeClone(copy, stateMapping);
        EnvironmentManager envManager = source.getEnvManager().makeClone(copy, stateMapping, envMapping, copyStore);

        copy.setStore(copyStore);
        copy.setConfig(config);
        copy.setGlobal(envMapping.get(source.getGlobal()));
        copy.setEnvManager(envManager);
        copy.setStack(stack);
        return copy;
    }

}

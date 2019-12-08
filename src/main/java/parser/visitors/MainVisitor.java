package parser.visitors;

import execution.state.ExecutionState;
import execution.state.main.MainState;
import execution.state.main.StatementSeqState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.Execution;
import parser.env.Environment;
import util.EnvironmentManager;
import util.Payload;

import javax.naming.spi.StateFactory;
import java.util.Stack;


/**
 * This is the class responsible for parsing an Alk program, starting from the root.
 */
public class MainVisitor extends alkBaseVisitor<ExecutionState> {

    @Deprecated
    public static Stack<Environment> stack = new Stack<>();

    @Deprecated
    public static Boolean exceptionOccured = false;

    public static Environment global;

    private Payload payload;


    /**
     * Creates a new MainVisitor with a Stack containing only the specified global enironment.
     * @param global The environment used to initialize the global environment of the visitor.
     */
    public MainVisitor(Environment global)
    {
        stack.clear();
        MainVisitor.global = global;
        stack.push(global);
        exceptionOccured = false;
    }
    
    public MainVisitor(Environment global, Payload payload)
    {
        stack.clear();
        MainVisitor.global = global;
        stack.push(global);
        exceptionOccured = false;
        this.payload = payload;
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStartPoint(alkParser.StartPointContext ctx)
    {
        EnvironmentManager envManager = payload.getEnvManager();
        MainState state = new MainState(ctx, payload);
        envManager.link(state, global);
        return state;
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        EnvironmentManager envManager = payload.getEnvManager();
        StatementSeqState state = new StatementSeqState(ctx, payload);
        envManager.link(state, global);
        return state;
    }
}

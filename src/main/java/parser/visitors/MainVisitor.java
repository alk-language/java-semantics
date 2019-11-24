package parser.visitors;

import execution.state.ExecutionState;
import execution.state.main.MainState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.Execution;
import parser.env.Environment;
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

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStartPoint(alkParser.StartPointContext ctx)
    {
        return new MainState(ctx, this);
    }
}

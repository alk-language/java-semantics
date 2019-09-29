package parser.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import java.util.Stack;


/**
 * This is the class responsible for parsing an Alk program, starting from the root.
 */
public class MainVisitor extends alkBaseVisitor {

    public static Stack<Environment> stack = new Stack<>();
    public static Environment global;
    public static Boolean exceptionOccured = false;


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
    @Override public Object visitStartPoint(alkParser.StartPointContext ctx) {
        StmtVisitor stmtVisitor = new StmtVisitor(global, false);
        if (ctx.statement_sequence() == null)
            return false;
        stmtVisitor.visit(ctx.statement_sequence());
        return true;
    }
}

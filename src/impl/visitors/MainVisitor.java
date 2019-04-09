package impl.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;

import java.util.Stack;

public class MainVisitor extends alkBaseVisitor {

    public static Stack<Environment> stack = new Stack<>();
    public static Environment Global;
    public static Boolean exceptionOccured = false;

    public MainVisitor(Environment env)
    {
        stack.clear();
        Global = env;
        stack.push(env);
        exceptionOccured = false;
    }

    @Override public Object visitStartPoint(alkParser.StartPointContext ctx) {
        StmtVisitor stmtVisitor = new StmtVisitor(Global, false);
        if (ctx.statement_sequence() == null)
            return false;
        stmtVisitor.visit(ctx.statement_sequence());
        return true;
    }
}

package preparsing.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import impl.env.Environment;
import impl.visitors.StmtVisitor;
import preparsing.PreParsing;

import java.util.Stack;

public class PreMainVisitor extends alkBaseVisitor {
    public static PreParsing data;

    public PreMainVisitor(PreParsing data)
    {
        this.data = data;
    }

    @Override public Object visitStartPoint(alkParser.StartPointContext ctx) {
        PreStmtVisitor prestmtVisitor = new PreStmtVisitor(data);
        if (ctx.statement_sequence() == null)
            return false;
        prestmtVisitor.visit(ctx.statement_sequence());
        return true;
    }
}

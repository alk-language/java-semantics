package preparsing.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import preparsing.PreParsing;


public class PreStmtVisitor extends alkBaseVisitor {

    PreParsing data;

    public PreStmtVisitor(PreParsing data)
    {
        this.data=data;
    }

    @Override public Object visitChooseStmt(alkParser.ChooseStmtContext ctx) {
        data.setType("nedeterminist");
        return null;
    }

    @Override public Object visitUniformStmt(alkParser.UniformStmtContext ctx) {
        data.setType("nedeterminist");
        return null;
    }

    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        String name = ctx.method_name().start.getText();
        if (name.equals("random") && data.getType().equals("determinist"))
            data.setType("probabilist");
        return null;
    }
}

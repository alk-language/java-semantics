package analysis.visitors;

import analysis.Analysis;
import grammar.alkBaseVisitor;
import grammar.alkParser;


public class AnalysisStmtVisitor extends alkBaseVisitor {

    Analysis data;

    public AnalysisStmtVisitor(Analysis data)
    {
        this.data=data;
    }

    @Override public Object visitChooseStmt(alkParser.ChooseStmtContext ctx) {
        data.setType("nedeterminist");
        return null;
    }

    @Override public Object visitUniformStmt(alkParser.UniformStmtContext ctx) {
        if (data.getType().equals("determinist"))
            data.setType("probabilist");
        return null;
    }

    @Override public Object visitBuiltinMethod(alkParser.BuiltinMethodContext ctx) {
        String name = ctx.method_name().start.getText();
        if (name.equals("random") && data.getType().equals("determinist"))
            data.setType("probabilist");
        return null;
    }
}

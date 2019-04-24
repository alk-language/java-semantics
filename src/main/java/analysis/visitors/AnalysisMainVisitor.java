package analysis.visitors;

import analysis.Analysis;
import grammar.alkBaseVisitor;
import grammar.alkParser;

public class AnalysisMainVisitor extends alkBaseVisitor {
    public static Analysis data;

    public AnalysisMainVisitor(Analysis data)
    {
        this.data = data;
    }

    @Override public Object visitStartPoint(alkParser.StartPointContext ctx) {
        AnalysisStmtVisitor prestmtVisitor = new AnalysisStmtVisitor(data);
        if (ctx.statement_sequence() == null)
            return false;
        prestmtVisitor.visit(ctx.statement_sequence());
        return true;
    }
}

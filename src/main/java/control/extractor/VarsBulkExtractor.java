package control.extractor;

import dataflow.CFG;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class VarsBulkExtractor
{

    public Set<String> extract(CFG cfg)
    {
        CFGVisitor visitor = new CFGVisitor();
        VarsVisitor varsVisitor = new VarsVisitor();
        visitor.register(null, varsVisitor::visit);
        visitor.extract(cfg);
        return varsVisitor.getVars();
    }

    public Set<String> extract(ParseTree tree)
    {
        VarsVisitor visitor = new VarsVisitor();
        visitor.visit(tree);
        return visitor.getVars();
    }

    static class VarsVisitor extends alkBaseVisitor<Object>
    {
        Set<String> vars = new HashSet<>();

        VarsVisitor()
        {

        }

        @Override
        public Object visitRefID(alkParser.RefIDContext ctx)
        {
            vars.add(ctx.ID().getText());
            return null;
        }

        public Set<String> getVars()
        {
            return vars;
        }
    }
}

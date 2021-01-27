package control.extractor;

import ast.AST;
import dataflow.CFG;
import grammar.alkBaseVisitor;
import grammar.alkParser;

import java.util.*;

public class VarsBulkExtractor
{

    public Set<String> extract(CFG cfg)
    {
        CFGVisitor visitor = new CFGVisitor();
        VarsVisitor varsVisitor = new VarsVisitor();
        // TODO: properly search for variables
        // visitor.register(null, varsVisitor::visit);
        visitor.extract(cfg);
        return varsVisitor.getVars();
    }

    public Set<String> extract(AST tree)
    {
        VarsVisitor visitor = new VarsVisitor();

        // TODO: properly search for variables

        // tree.accept(visitor);
        return visitor.getVars();
    }

    static class VarsVisitor
    extends alkBaseVisitor<Object>
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
